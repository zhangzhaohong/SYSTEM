<%@ page contentType="text/html; charset=GBK" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=GBK">
    <title>留言板</title>
    <link href="css/style.css" rel="stylesheet" type="text/css">

    <link href="css/logo.css" rel="stylesheet" type="text/css">
</head>

<body>

<c:if test="${sessionScope.user==null }">
    <script>
        top.location.href = "login.jsp";
    </script>
</c:if>

<table style="width:100% ">
    <tr>
        <td>
            <table style="width:100% ">
                <tr height="57">
                    <td style="vertical-align: middle;">&nbsp;&nbsp;
                        <img src="images/lylogo.gif">&nbsp;
                    </td>
                    <td style="text-align: right;" class="login-text"><br>[${user.username }]
                    </td>
                    <td style="width:280px;text-align: center; ">
                        <table style="width:100%;height: 57px;text-align: center; ">
                            <tr height="57">
                                <td style="width:100% ">
                                    <table style="text-align: center;">
                                        <tr height="28">
                                            <td colspan="3">&nbsp;</td>
                                        </tr>
                                        <tr>
                                            <td class="right-button-left"></td>
                                            <td style="text-align: right;" class="right-button-bg">
                                                <table style="height: 29px">
                                                    <tr>
                                                        <td class="button-help-mouseout"
                                                            onMouseOut="this.className='button-help-mouseout'"
                                                            onMouseOver="this.className='button-help-mouseover'"
                                                            style="cursor:pointer"
                                                            onClick="top.mainFrame.location.href='../help.jsp'">&nbsp;
                                                        </td>
                                                        <td class="button-split-line">&nbsp;</td>
                                                        <td class="button-mpwd-mouseout"
                                                            onMouseOut="this.className='button-mpwd-mouseout'"
                                                            onMouseOver="this.className='button-mpwd-mouseover'"
                                                            style="cursor:pointer"
                                                            onClick="top.mainFrame.location.href='modifyUserInfo.action?UID=${user.id }'">
                                                            &nbsp;
                                                        </td>
                                                        <td class="button-split-line">&nbsp;</td>
                                                        <td class="button-logout-mouseout"
                                                            onMouseOut="this.className='button-logout-mouseout'"
                                                            onMouseOver="this.className='button-logout-mouseover'"
                                                            style="cursor:pointer"
                                                            onClick="top.location.href='userLogout.action'">&nbsp;
                                                        </td>
                                                    </tr>
                                                </table>
                                            </td>
                                            <td class="right-button-right">&nbsp;</td>
                                        </tr>

                                    </table>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td style="height: 3px" class="bottom-line"></td>
    </tr>
</table>
</body>
</html>
