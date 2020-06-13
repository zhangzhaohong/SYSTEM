<%--
  Created by IntelliJ IDEA.
  User: zhangzhaohong
  Date: 2020-03-14
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="gb2312" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>���԰���Ϣ</title>
    <link rel="stylesheet" href="css/bootstrap.css" type="text/css">
    <link rel="stylesheet" href="css/main.css" type="text/css">
    <script src="js/jquery.js" type="text/javascript" charset="utf-8"></script>
    <script src="js/bootstrap.bundle.js" type="text/javascript" charset="utf-8"></script>
    <script src="js/common.js" type="text/javascript" charset="utf-8"></script>
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
        function selectInit(selectElementID, selectedForvalue) {
            //var selectyObj = this.document.getElementById(selectElementID);
            //var selectLength = selectyObj.length;
            //for(var i = 0 ; i < selectLength ; i++ ){
            //	if(selectyObj[i].value == selectedForvalue){
            //		selectyObj[i].selected = true;
            //	}
            //}
            if (selectedForvalue === "all") {
                $("#article_filter_list").text("ȫ������");
            } else if (selectedForvalue === "myedded") {
                $("#article_filter_list").text("����ӵ�����");
            } else if (selectedForvalue === "today") {
                $("#article_filter_list").text("����");
            } else if (selectedForvalue === "month") {
                $("#article_filter_list").text("����");
            }
            if (selectedForvalue === "timedown") {
                $("#article_order_list").text("ʱ��-����");
            } else if (selectedForvalue === "timeup") {
                $("#article_order_list").text("ʱ��-����");
            } else if (selectedForvalue === "iddown") {
                $("#article_order_list").text("ID-����");
            } else if (selectedForvalue === "idup") {
                $("#article_order_list").text("ID-����");
            }
        }

        function searchCriteria(type) {
            if (type == "article_id") {
                $("#search_list").text("ID");
            }
        }

        function searchArticle() {
            //var paramName = document.mainForm.search_list.value;
            var paramName = document.getElementById("search_list").text;
            if (paramName == "ID") {
                paramName = "article_id";
            }
            //alert("paramName="+paramName);
            var paramValue = document.mainForm.key.value;
            //alert(typeof(paramName));
            //alert("paramValue="+paramValue);
            //alert(typeof(paramValue));
            if (paramName == "arcicle_id") {
                if (isNaN(paramValue)) {
                    alert("��������ȷ��ID�����֣���");
                    return false;
                }
            }
            var tmp = removeSearch("URL", "arcicle_id");
            tmp = removeSearch(tmp, "title");
            tmp = removeSearch(tmp, "keyword");
            tmp = removeSearch(tmp, "add_user");
            tmp = removeSearch(tmp, "add_date");
            tmp = removeSearch(tmp, "sava_date");
            tmp = removeSearch(tmp, "pn");

            tmp = addSearch(tmp, "searchType", paramName);
            var search = addSearch(tmp, paramName, paramValue);

            //alert("search="+search);
            mangeUrlLoad(search);
        }

        function goSearchArticle() {
            if (event.keyCode == 13) {
                searchArticle();
                return false;
            }
        }

        function pageInit() {
            selectInit("filter", "${param.filter}");
            selectInit("order", "${param.order}");
            //selectInit("page_list","$(param.pn)");
            //selectInit("page_list","$(param.date)");
            selectInit("search_list", "$(param.searchType)");
        }
    </script>
</head>
<body onLoad="pageInit()">
<c:if test="${sessionScope.user==null}">
    <jsp:forward page="login.jsp"/>
</c:if>
<form action="" method="post" class="m-0" name="mainForm">
    <table border="1" style="width:100%"
           class="table table-bordered table-hover">
        <caption>������Ϣ����</caption>
        <tr class="nav-liuyan">
            <td colspan="6" class="my-auto">
                <input type="button" value="�������" onClick="location.href='liuyan.jsp'"
                       class="btn btn-outline-primary float-left">
                <input type="button" value="�޸�" class="btn btn-outline-warning float-right">
                <input type="button" value="ɾ����ѡ" class="btn btn-outline-danger float-right mx-2">
            </td>
        </tr>
        <tr class="nav-search">
            <td colspan="6" class="my-auto">
                <ul class="nav nav-pills">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" id="article_filter_list" data-toggle="dropdown" href="#">
                            ����ɸѡ
                        </a>
                        <ul class="dropdown-menu">
                            <li id="all" onClick="dataFilter('filter')"><a class="aa dropdown-item" href="#">ȫ������</a>
                            </li>
                            <li id="myedded" onClick="dataFilter('filter')"><a class="aa dropdown-item"
                                                                               href="#">����ӵ�����</a></li>
                            <li id="today" onClick="dataFilter('filter')"><a class="aa dropdown-item" href="#">����</a>
                            </li>
                            <li id="month" onClick="dataFilter('filter')"><a class="aa dropdown-item" href="#">����</a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" id="bb" data-toggle="dropdown" href="#">
                            ���ڿ���
                        </a>
                        <ul class="dropdown-menu">
                            <li onClick="dataFilter('date')"><a class="bb dropdown-item" href="#">��ǰ��</a></li>
                            <li onClick="dataFilter('date')"><a class="bb dropdown-item" href="#">���ڵ�</a></li>
                            <li onClick="dataFilter('date')"><a class="bb dropdown-item" href="#">δ��ʼ��</a></li>
                        </ul>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" id="article_order_list" data-toggle="dropdown" href="#">
                            ����˳��
                        </a>
                        <ul class="dropdown-menu">
                            <li id="timedown" onClick="dataFilter('order')"><a class="cc dropdown-item"
                                                                               href="#">ʱ��-����</a></li>
                            <li id="timeup" onClick="dataFilter('order')"><a class="cc dropdown-item" href="#">ʱ��-����</a>
                            </li>
                            <li id="iddown" onClick="dataFilter('order')"><a class="cc dropdown-item" href="#">ID-����</a>
                            </li>
                            <li id="idup" onClick="dataFilter('order')"><a class="cc dropdown-item" href="#">ID-����</a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item ml-auto">
                        <!-- <form class="form-inline" role="form"> -->
                        <div class="nav nav-pills dropdown form-group" style="float:left;">
                            <a class="nav-link dropdown-toggle" data-toggle="dropdown" id="search_list" href="#">
                                ɸѡ����
                            </a>
                            <ul class="dropdown-menu">
                                <li id="article_id" onClick="searchCriteria('article_id')"><a
                                        class="article_id dropdown-item" href="#">ID</a></li>
                                <li id="title"><a class="dropdown-item" href="#">����</a></li>
                            </ul>
                        </div>
                        <div class="form-group" style="float:left;">
                            <%--@declare id="name"--%><label class="sr-only" for="name">����</label>
                            <input type="search" class="form-control" name="key" id="key"
                                   onKeyDown="return goSearchArticle()"
                                   placeholder="����">
                        </div>
                        <input type="submit" class="btn btn-outline-dark" onclick="searchArticle()" value="�ύ"/>
                        <!-- </form> -->
                    </li>
                </ul>
            </td>
        </tr>
        <tr class="nav-menu">
            <th><input type="checkbox" name="selectAll" value="checkbox" onClick="checkAll(this.form)"
                       class="checkbox-custom"/></th>
            <th>����������</th>
            <th>����ʱ��</th>
            <th>���Ա���</th>
            <th>��������</th>
            <th>����</th>
        </tr>
        <c:forEach items="${myLyList}" var="ly">
            <tr>
                <th><input type="checkbox" name="selected" value="$(ly.id)" onClick="unselectall('selectAll')"/></th>
                <td>${ly.test.username}</td>
                <td>${ly.lydate}</td>
                <td>${ly.title}</td>
                <td>${ly.lyContent}</td>
                <td><c:if test="${user.id == ly.test.id}">
                    <a href="addLyAction.action?id=${ly.id}">�޸�</a>
                </c:if>
                    <c:if test="${user.usertype=='admin'}">

                        <a href="#"
                           onClick="confirmAction(mainForm,' ȷ��ɾ���������� ','addLyAction.action?type=delete&delid=${ly.id}')">ɾ��</a>

                    </c:if></td>
            </tr>
        </c:forEach>
        <tr class="nav-page">
            <td colspan="6">
                ��${totalRec}������&nbsp;&nbsp;��ǰ��
                <a href="#">
                    <select name="page_list" id="page_list" class="selectpicker show-tick" data-style="btn"
                            data-width="80px" onChange="pageJump()">
                        <c:forEach begin="1" end="${pageCount}" step="1" var="i">
                            <c:if var="jugSel" test="${pageNum==i }">
                                <option value="${i}" title="${i}/${pageCount}" selected>${i}</option>
                            </c:if>
                            <c:if test="${!jugSel}">
                                <option value="${i}" title="${i}/${pageCount}">${i}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </a>
                ҳ&nbsp;&nbsp;��${pageCount}ҳ&nbsp;&nbsp;&nbsp;&nbsp;
                <ul class="pagination pagination-lg justify-content-center">
                    <li class="page-item"><span><a class="page-link" href="javascript:first_page();">��ҳ</a></span></li>
                    <li class="page-item"><span><a class="page-link" href="javascript:prev_page();">��һҳ</a></span></li>
                    <!-- <li class="page-item page-count">
							<a class="page-link" href="#">
								<select name="page_list" id="page_list" class="selectpicker show-tick" data-style="btn"  data-width="80px" onChange="pageJump()">
								    <c:forEach begin="1" end="${pageCount}"  step="1" var="i">
								    	<c:if var="jugSel" test="${pageNum==i }"><option value="${i}" title="${i}/${pageCount}" selected>${i}</option></c:if>
								    	<c:if test="${!jugSel}"><option value="${i}"  title="${i}/${pageCount}">${i}</option></c:if>
								    </c:forEach>
								 </select>
							</a>
						</li> -->
                    <li class="page-item"><span><a class="page-link"
                                                   href="javascript:next_page('${pageCount}');">��һҳ</a></span></li>
                    <li class="page-item"><span><a class="page-link" href="javascript:last_page('${pageCount}');">βҳ</a></span>
                    </li>
                    <!-- ------------------------------------------------------------------- -->
                    <!-- <br/>
						<c:if var="jugFir" test="${pageNum==1 }">
							<li class="page-item"><a class="page-link" disabled="disabled" href="">��ҳ</a></li>
							<li class="page-item">
								<a class="page-link" disabled="disabled" href="">
									<span>��һҳ</span>
								</a>
							</li>
						</c:if>
						<c:if test="${!jugFir}">
							<li class="page-item"><a class="page-link" href="pageLy.action?page=1">��ҳ</a></li>
							<li class="page-item">
								<a class="page-link" href="pageLy.action?page=${pageNum-1}">
									<span>��һҳ</span>
								</a>
							</li>
						</c:if>
						<c:if var="pageLast" test="${pageNum==pageCount||pageCount==0}">
							<li class="page-item"><a class="page-link" disabled="disabled" href=""><span>��һҳ</span></a></li>
							<li class="page-item"><a class="page-link" disabled="disabled" href="">βҳ</a></li>
						</c:if>
						<c:if test="${!pageLast}">
							<li class="page-item"><a class="page-link" href="pageLy.action?page=${pageNum+1}"><span>��һҳ</span></a></li>
							<li class="page-item"><a class="page-link" href="pageLy.action?page=${pageCount}">βҳ</a></li>
						</c:if> -->
                </ul>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
