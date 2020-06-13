//��ǰ�Ĳ˵�
var currMenu = "${param.type}";

function displayOrHideMenu(objID){
	displayOrHide("menu_" + objID);
	
	var linkTable = document.getElementById("menu_" + objID);
	var obj = document.getElementById("menu_title_" + objID);
	
	if(obj){
		if(linkTable.style.display==""){
			obj.className = "menu-ctrl-bar-exp-button";
		}else{
			obj.className = "menu-ctrl-bar-col-button";
		}
	}
}
function titleBarShowOrHide(objID){
	displayOrHide(objID);
	var linkTable = document.getElementById(objID);
	var obj = document.getElementById(objID + "_btn");
	if(obj){
		if(obj.style.display=="" || obj.style.display=="block"){
			//obj.className = "title-bar2-btn-col";
			obj.style.display="none";
		}else{
			//obj.className = "title-bar2-btn-exp";
			obj.style.display="block";
		}
	}
}

//�л�Ҫ��ʾ�Ĳ˵�
function loadMenu(showMenuID){
	//�����ǰҪ�л��Ĳ˵����ǵ�ǰ������ʾ�Ĳ˵�
	if(showMenuID != currMenu){		
		document.getElementById("module_span_" + currMenu).style.display = "none";
		document.getElementById("module_span_" + showMenuID).style.display = "";
	}else{
		document.getElementById("module_span_" + showMenuID).style.display = "";
	}
	
	currMenu = showMenuID;
	
}


function displayOrHide(obj){
	if(obj != ""){
		var displayObj = document.getElementById(obj);
		if(displayObj){
			
			if(displayObj.style.display==""){
				displayObj.style.display = "none";
			}else{
				displayObj.style.display = "";
			}
		}
		
	}
}
function checkAll(form){
	var eSource = window.event.srcElement;
	for(var i = 0 ; i < form.elements.length ; i++){
		var e = form.elements[i];
		if(e.Name != eSource.name && e.disabled == false){
			e.checked = eSource.checked;
		}
	}
}
function dataFilter(search_param_name){
	var e =event.srcElement.parentNode;
	var tmp = removeSearch("URL",search_param_name);
	var search = addSearch(tmp,search_param_name,e.id);
	//alert(search);
	mangeUrlLoad(search);
}
function removeSearch(searchStr,name){
	if(searchStr == "URL"){
		return searchManage(this.location.search.substr(1),"remove",name,"");
	}
	return searchManage(searchStr,"remove",name,"");
}
function searchManage(searchStr,operType,name,value){
	var searchArray = new Array();
	var returnStr = "";
	if(searchStr != ""){
		searchArray	 = searchStr.split("&");
	
		for(var i = 0 ; i < searchArray.length ; i++){
			if(searchArray[i] != ""){
				var paramArray = new Array();
				paramArray = searchArray[i].split("=");
				if(paramArray[0] == name){
					searchArray.splice(i,1);
					i--;
				}
			}
		}
	}
	if(operType == "add"){
		returnStr = name + "=" + value;
	}
	if(operType == "remove"){
		
	}
	for(var j = 0 ; j < searchArray.length ; j++){
		if(searchArray[j] != ""){
			returnStr += "&" + searchArray[j];
		}
	}
	return returnStr;
}
function addSearch(searchStr,name,value){
	if(searchStr == "URL"){
		return searchManage(this.location.search.substr(1),"add",name,value);
	}
	return searchManage(searchStr,"add",name,value);
}
function pageJump(){
	var e = event.srcElement;
	var search = addSearch("URL","page",e.value);
	mangeUrlLoad(search);
}
function mangeUrlLoad(search){
	var str = this.location.href;
	if(str.lastIndexOf(".jsp")>-1){
		var i = str.lastIndexOf("/");
		str = str.substr(0,i+1);
		this.location.href = str +"pageLy.action?"+search;
	}else{
		this.location.search = search;
	}
}
function first_page(){
	var search = addSearch("URL","page",1);
	//alert(search);
	mangeUrlLoad(search);
}
function next_page(pageCount){
	var pn = getSearchValue("URL","page");
	var nextPage;
	if (pn == "" ||pn == null){
		nextPage = 2;
	}else{
		nextPage = parseInt(pn) + 1;
	}
	if(nextPage > pageCount){
		nextPage = pageCount;
	}
	var search = addSearch("URL","page",nextPage);
	mangeUrlLoad(search);
}
function prev_page(){
	var pn = getSearchValue("URL","page");
	if (pn == "" ||pn == null){
		first_page();
		return;
	}
	if (parseInt(pn) <= 1){
		first_page();
		return;
	}
	var nextPage = parseInt(pn) - 1;
	if(nextPage < 1){
		nextPage = 1;
	}
	var search = addSearch("URL","page",nextPage);
	mangeUrlLoad(search);
}
function last_page(pageCount){
	var search = addSearch("URL","page",pageCount);
	mangeUrlLoad(search);
}
function goto_page(pageNum){
	var search = addSearch("URL","page",pageNum);
	mangeUrlLoad(search);
}
function getSearchValue(searchStrparam,name){
	if(searchStrparam =="URL"){
		searchStr = this.location.search.substr(1);
	}else{
		searchStr = searchStrparam;
	}
	var searchArray = new Array();
	var returnStr = "";
	if(searchStr != ""){
		searchArray = searchStr.split("&");
		for(var i = 0 ; i < searchArray.length ; i++){
			if(searchArray[i] != ""){
				var paramArray = new Array();
				paramArray = searchArray[i].split("=");
				if(paramArray[0] == name){
					returnStr = paramArray[1];
					return returnStr;
				}
			}
		}
	}
	return "";
}
function confirmAction(formObject,msg,action){
	if(! window.confirm(msg)){
		return;
	}
	formObject.action = action;
	formObject.submit();
}