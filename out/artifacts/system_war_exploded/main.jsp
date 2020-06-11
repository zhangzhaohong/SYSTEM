<%--
  Created by IntelliJ IDEA.
  User: zhangzhaohong
  Date: 2020-03-14
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="gb2312" import="com.project.pro.vo.UserTable,java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>���԰���Ϣ</title>
    <link rel="stylesheet" href="css/bootstrap.css" type="text/css">
    <link rel="stylesheet" href="css/main.css" type="text/css">
    <script src="js/jquery.js" type="text/javascript" charset="utf-8"></script>
    <script src="js/bootstrap.bundle.js" type="text/javascript" charset= "utf-8"></script>
    <script src="js/common.js" type="text/javascript" charset= "utf-8"></script>
    <script type="text/javascript">
        //	window.onload = function(){
        //		$("li a").on('click',function(e){
        //alert(e.target.innerHTML);
        //$("#cc").innerHTML=e.target.innerHTML;
        //alert($("#aa").innerHTML);
        //			var val = $(this).html();
        //			var thisClass = $(this).attr('class');
        //alert(thisClass);
        //			if(thisClass.indexOf('aa')!=-1){
        //alert(val);
        //alert(e.target.innerHTML);
        //				$("#aa").text(val);
        //			}else if(thisClass.indexOf('bb')!=-1){
        //				$("#bb").text(val);
        //alert('2');
        //alert(val);
        //			}else if(thisClass.indexOf('cc')!=-1){
        //				$("#cc").text(val);
        //alert('3');
        //			}
        //$("#aa").text(val);
        //		});
        //	}
        function selectInit(selectElementID,selectedForvalue){
            //var selectyObj = this.document.getElementById(selectElementID);
            //var selectLength = selectyObj.length;
            //for(var i = 0 ; i < selectLength ; i++ ){
            //	if(selectyObj[i].value == selectedForvalue){
            //		selectyObj[i].selected = true;
            //	}
            //}
            if(selectedForvalue === "all"){
                $("#article_filter_list").text("ȫ������");
            }else if(selectedForvalue === "myedded"){
                $("#article_filter_list").text("����ӵ�����");
            }else if(selectedForvalue === "today"){
                $("#article_filter_list").text("����");
            }else if(selectedForvalue === "month"){
                $("#article_filter_list").text("����");
            }
            if(selectedForvalue === "timedown"){
                $("#article_order_list").text("ʱ��-����");
            }else if(selectedForvalue === "timeup"){
                $("#article_order_list").text("ʱ��-����");
            }else if(selectedForvalue === "iddown"){
                $("#article_order_list").text("ID-����");
            }else if(selectedForvalue === "idup"){
                $("#article_order_list").text("ID-����");
            }
        }
        function searchCriteria(type){
            if(type=="article_id"){
                $("#search_list").text("ID");
            }
        }
        function searchArticle(){
            //var paramName = document.mainForm.search_list.value;
            var paramName = document.getElementById("search_list").text;
            if(paramName=="ID"){
                paramName="article_id";
            }
            //alert("paramName="+paramName);
            var paramValue = document.mainForm.key.value;
            //alert(typeof(paramName));
            //alert("paramValue="+paramValue);
            //alert(typeof(paramValue));
            if(paramName == "arcicle_id"){
                if(isNaN(paramValue)){
                    alert("��������ȷ��ID�����֣���");
                    return false;
                }
            }
            var tmp = removeSearch("URL","arcicle_id");
            tmp = removeSearch(tmp,"title");
            tmp = removeSearch(tmp,"keyword");
            tmp = removeSearch(tmp,"add_user");
            tmp = removeSearch(tmp,"add_date");
            tmp = removeSearch(tmp,"sava_date");
            tmp = removeSearch(tmp,"pn");

            tmp = addSearch(tmp,"searchType",paramName);
            var search = addSearch(tmp,paramName,paramValue);

            //alert("search="+search);
            mangeUrlLoad(search);
        }
        function goSearchArticle(){
            if(event.keyCode == 13){
                searchArticle();
                return false;
            }
        }
        function pageInit(){
            selectInit("filter","${param.filter}");
            selectInit("order","${param.order}");
            //selectInit("page_list","$(param.pn)");
            //selectInit("page_list","$(param.date)");
            selectInit("search_list","$(param.searchType)");
        }
    </script>
</head>
<body>
<c:if test="${sessionScope.user==null}">
    <jsp:forward page="login.jsp"/>
</c:if>
${user.username } : ${user.userType},���ã���ӭ��¼���԰塣
<div>
    <table border="1">
        <caption>����������Ϣ</caption>
        <tr>
            <th>����������</th><th>����ʱ��</th><th>���Ա���</th><th>��������</th>
        </tr>
        <c:forEach items="${requestScope.myLyList}" var="ly">
            <tr>
                <td>${ly.username }</td>
                <td>${ly.lydate }</td>
                <td>${ly.title }</td>
                <td>${ly.lyContent }</td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="4" style="text-align: right;">
                <c:if var="jugFir" test="${requestScope.pageNum==1}">��ҳ|��һҳ|</c:if>
                <c:if test="${!jugFir}"><a href="mainAction.action?page=1">��ҳ</a>|<a href="mainAction.action?page=${requestScope.pageNum-1 }">��һҳ</a>|</c:if>

                <c:if var="jugLast" test="${requestScope.pageNum==requestScope.pageCount||requestScope.pageCount==0}">��һҳ|βҳ</c:if>
                <c:if test="${!jugLast}">
                    <a href="mainAction.action?page=${requestScope.pageNum+1 }">��һҳ</a>|<a href="mainAction.action?page=${requestScope.pageCount }">βҳ</a></c:if>
            </td>
        </tr>
    </table>
</div>
<form action="liuyan.jsp" method="post">
    <input type="submit" value="����">
</form>
</body>
</html>
