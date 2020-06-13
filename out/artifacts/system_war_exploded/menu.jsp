<%@ page contentType="text/html; charset=GBK" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=GBK">
    <title>CMS</title>
    <link href="css/menu.css" rel="stylesheet" type="text/css">
    <link href="css/tree.css" rel="stylesheet" type="text/css">
    <script src="js/common.js"></script>
    <script src="js/tree/xtree.js"></script>
    <script src="js/page_init.js"></script>
    <c:if test="${sessionScope.user==null }">
        <script>
            top.location.href = "login.jsp";
        </script>
    </c:if>
</head>
<script>
    //当前的菜单
    var currMenu = "${param.type}";

    function displayOrHideMenu(objID) {
        displayOrHide("menu_" + objID);

        var linkTable = document.getElementById("menu_" + objID);
        var obj = document.getElementById("menu_title_" + objID);

        if (obj) {
            if (linkTable.style.display == "") {
                obj.className = "menu-ctrl-bar-exp-button";
            } else {
                obj.className = "menu-ctrl-bar-col-button";
            }
        }
    }

    //页面初始化
    function pageInit() {
        if (document.getElementById("NODE_ID")) {
            selectInit("NODE_ID", "${param.cluster_node_id}");
        }
    }

    //切换要显示的菜单
    function loadMenu(showMenuID) {
        //如果当前要切换的菜单不是当前正在显示的菜单
        if (showMenuID != currMenu) {
            document.getElementById("module_span_" + currMenu).style.display = "none";
            document.getElementById("module_span_" + showMenuID).style.display = "";
        } else {
            document.getElementById("module_span_" + showMenuID).style.display = "";
        }

        currMenu = showMenuID;

    }

</script>

<body onLoad="loadMenu(currMenu)">
<table style="width: 100%;border: 0;border-spacing: 0;padding: 0;">
    <tr>
        <td class="menu-border-line"></td>
    </tr>
</table>
<table style="width: 100%;border: 0;border-spacing: 0;padding: 0;">
    <tr>
        <td style="height: 8px;"></td>
    </tr>
</table>

<!-- 留言管理 -->
<table style="width: 94%;border:0; text-align: center;border-spacing: 0;padding: 0;">
    <tr>
        <td class="menu-ctrl-bar-left"></td>
        <td class="menu-ctrl-bar-bg">
            <table style="width:100%;border:0;border-spacing: 0;padding: 0;">
                <tr style="cursor:pointer" onClick="displayOrHideMenu('module_ly')">
                    <td style="width: 157px" class="menu-ctrl-bar-title">留言管理</td>
                    <td style="width: 25px" class="menu-ctrl-bar-exp-button">&nbsp;</td>
                </tr>
            </table>
        </td>
        <td class="menu-ctrl-bar-right"></td>
    </tr>
</table>
<table style="width: 94%;border:0; text-align: center;border-spacing: 0;padding: 0;" id="menu_module_ly">
    <tr>
        <td class="menu-link-area-left"></td>
        <td style="height:10px" class="menu-link-area-bg">
            <table style="width:98%;border:0;border-spacing: 0;padding: 0;">
                <tr>
                    <td class="menu-icon">&nbsp;</td>
                    <td class="menu-text"><a href="liuyan.jsp" target="mainFrame">添加留言</a></td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align: center;height: 12px">
                        <table style="width:90%;border:0;border-spacing: 0;padding: 0;">
                            <tr>
                                <td style="height: 2px;vertical-align: middle;" class="menu_class_line"></td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td class="menu-icon">&nbsp;</td>
                    <td class="menu-text"><a href="mainAction.action" target="_parent">所有留言</a></td>
                </tr>
                <tr>
                    <td class="menu-icon">&nbsp;</td>
                    <td class="menu-text"><a href="mainAction.action?filter=myadded" target="_parent">我的留言</a></td>
                </tr>
            </table>
        </td>
        <td class="menu-link-area-right"></td>
    </tr>

</table>


<table style="width: 94%;border:0; text-align: center;border-spacing: 0;padding: 0;">
    <tr>
        <td class="menu-bottom-left"></td>
        <td class="menu-bottom-bg">&nbsp;</td>
        <td class="menu-bottom-right"></td>
    </tr>
</table>

<!-- 学生信息管理 -->

<table style="width: 94%;border:0; text-align: center;border-spacing: 0;padding: 0;">
    <tr>
        <td class="menu-ctrl-bar-left"></td>
        <td class="menu-ctrl-bar-bg">
            <table style="width:100%;border:0;border-spacing: 0;padding: 0;">
                <tr style="cursor:pointer" onClick="displayOrHideMenu('module_stuInfo')">
                    <td style="width: 157px" class="menu-ctrl-bar-title">学生信息管理</td>
                    <td style="width: 25px" class="menu-ctrl-bar-exp-button">&nbsp;</td>
                </tr>
            </table>
        </td>
        <td class="menu-ctrl-bar-right"></td>
    </tr>
</table>

<table style="width: 94%;border:0; text-align: center;border-spacing: 0;padding: 0;" id="menu_module_stuInfo">
    <tr>
        <td class="menu-link-area-left"></td>
        <td style="height:10px" class="menu-link-area-bg">

            <table style="width:98%;border:0;border-spacing: 0;padding: 0;">
                <tr>
                    <td class="menu-icon">&nbsp;</td>
                    <td class="menu-text"><a href="addstudentView.action" target="mainFrame">学生信息录入</a></td>
                </tr>

                <tr>
                    <td class="menu-icon">&nbsp;</td>
                    <td class="menu-text"><a href="studentInfo.action" target="mainFrame">学生信息查询</a></td>
                </tr>


            </table>
        </td>
        <td class="menu-link-area-right"></td>
    </tr>

</table>

<table style="width: 94%;border:0; text-align: center;border-spacing: 0;padding: 0;">
    <tr>
        <td class="menu-bottom-left"></td>
        <td class="menu-bottom-bg">&nbsp;</td>
        <td class="menu-bottom-right"></td>
    </tr>
</table>


<!-- 专业课程管理 -->
<table style="width: 94%;border:0; text-align: center;border-spacing: 0;padding: 0;">
    <tr>
        <td class="menu-ctrl-bar-left"></td>
        <td class="menu-ctrl-bar-bg">
            <table style="width:100%;border:0;border-spacing: 0;padding: 0;">
                <tr style="cursor:pointer" onClick="displayOrHideMenu('module_ms')">
                    <td style="width: 157px" class="menu-ctrl-bar-title">专业课程管理</td>
                    <td style="width: 25px" class="menu-ctrl-bar-exp-button">&nbsp;</td>
                </tr>
            </table>
        </td>
        <td class="menu-ctrl-bar-right"></td>
    </tr>
</table>
<table style="width: 94%;border:0; text-align: center;border-spacing: 0;padding: 0;" id="menu_module_ms">
    <tr>
        <td class="menu-link-area-left"></td>
        <td style="height:10px" class="menu-link-area-bg">
            <table style="width:98%;border:0;border-spacing: 0;padding: 0;">
                <tr>
                    <td class="menu-icon">&nbsp;</td>
                    <td class="menu-text"><a href="studscore/majorOper.jsp" target="mainFrame">添加专业</a></td>
                </tr>
                <tr>
                    <td class="menu-icon">&nbsp;</td>
                    <td class="menu-text"><a href="liuyan.jsp" target="mainFrame">查询专业</a></td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align: center;height: 12px">
                        <table style="width:90%;border:0;border-spacing: 0;padding: 0;">
                            <tr>
                                <td style="height: 2px;vertical-align: middle;" class="menu_class_line"></td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td class="menu-icon">&nbsp;</td>
                    <td class="menu-text"><a href="mainAction.action" target="_parent">添加课程</a></td>
                </tr>
                <tr>
                    <td class="menu-icon">&nbsp;</td>
                    <td class="menu-text"><a href="mainAction.action?filter=myadded" target="_parent">查询课程</a></td>
                </tr>
            </table>
        </td>
        <td class="menu-link-area-right"></td>
    </tr>

</table>


<table style="width: 94%;border:0; text-align: center;border-spacing: 0;padding: 0;">
    <tr>
        <td class="menu-bottom-left"></td>
        <td class="menu-bottom-bg">&nbsp;</td>
        <td class="menu-bottom-right"></td>
    </tr>
</table>

<!-- 成绩信息管理 -->

<table style="width: 94%;border:0; text-align: center;border-spacing: 0;padding: 0;">
    <tr>
        <td class="menu-ctrl-bar-left"></td>
        <td class="menu-ctrl-bar-bg">
            <table style="width:100%;border:0;border-spacing: 0;padding: 0;">
                <tr style="cursor:pointer" onClick="displayOrHideMenu('module_score')">
                    <td style="width: 157px" class="menu-ctrl-bar-title">成绩信息管理</td>
                    <td style="width: 25px" class="menu-ctrl-bar-exp-button">&nbsp;</td>
                </tr>
            </table>
        </td>
        <td class="menu-ctrl-bar-right"></td>
    </tr>
</table>

<table style="width: 94%;border:0; text-align: center;border-spacing: 0;padding: 0;" id="menu_module_score">
    <tr>
        <td class="menu-link-area-left"></td>
        <td style="height:10px" class="menu-link-area-bg">

            <table style="width:98%;border:0;border-spacing: 0;padding: 0;">
                <tr>
                    <td class="menu-icon">&nbsp;</td>
                    <td class="menu-text"><a href="addXscjView.action" target="mainFrame">成绩信息录入</a></td>
                </tr>

                <tr>
                    <td class="menu-icon">&nbsp;</td>
                    <td class="menu-text"><a href="xscjInfo.action" target="_parent">成绩信息查询</a></td>
                </tr>


            </table>
        </td>
        <td class="menu-link-area-right"></td>
    </tr>

</table>

<table style="width: 94%;border:0; text-align: center;border-spacing: 0;padding: 0;">
    <tr>
        <td class="menu-bottom-left"></td>
        <td class="menu-bottom-bg">&nbsp;</td>
        <td class="menu-bottom-right"></td>
    </tr>
</table>

<!--  -->


</body>
</html>