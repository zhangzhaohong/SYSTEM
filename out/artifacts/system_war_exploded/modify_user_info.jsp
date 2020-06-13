<%@ page contentType="text/html; charset=gb2312" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=GBK">
    <title>个人信息</title>
    <style type="text/css">
        <!--
        .style1 {
            color: #0000FF
        }

        -->
    </style>
    <link href="css/oper_area.css" rel="stylesheet" type="text/css">
</head>
<script src="js/common.js"></script>
<body>
<s:form action="modifyUserInfo" method="post" theme="simple">
    <jsp:include page="include/mainTitle.jsp">
        <jsp:param name="mainTitle" value="修改用户信息"/>
        <jsp:param name="hasBlankLine" value="true"/>
    </jsp:include>

    <table style="width:100%;border:0 solid black; border-spacing: 0;padding: 0;">
        <tr>
            <td class="title-bar">
                <table style="width:98%;border:0 solid black; border-spacing: 0;padding: 0;text-align:center; ">
                    <tr>
                        <td style="width: 26px;" class="title-bar-title-icon">&nbsp;</td>
                        <td style="width: 745px;" class="title-bar-text">修改用户信息</td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
    <table style="width:99%;border:0 solid black; border-spacing: 0;padding: 0;text-align:center; "
           class="oper-bar">
        <tr>
            <td style="text-align: left"></td>
            <td style="text-align: right;"><span class="title_bar"> </span></td>
        </tr>
    </table>


    <table style="width:99%;border:0 solid black; border-spacing: 0;padding: 0;text-align:center; "
           class="title-bar2">
        <tr>
            <td>
                <table style="width:98%;border:0px solid black; border-spacing: 0px;padding: 0px;text-align:center; ">
                    <tr style="cursor:pointer" onClick="titleBarShowOrHide('p1')">
                        <td style="width: 26px;" class="title-bar2-btn-col" id="p1_btn">&nbsp;</td>
                        <td style="width: 745px;" class="title-bar2-text">用户信息</td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
    <table style="width:99%;border:0px solid black; border-spacing: 0px;padding: 0px;text-align:center; "
           class="table-frame" id="p1">
        <tr>
            <td style="width: 17%;height: 22px;text-align: right;" class="table-frame-input-title">用户名：</td>
            <td style="height: 22px" colspan="3" class="table-cell-input"><span class="test_must"><b>
                <s:label name="userinfo.test.username"/>
                <s:hidden name="userinfo.test.id"/>
							<s:hidden name="userinfo.test.username"/>
							<s:hidden name="userinfo.test.userpwd"/> </b></span></td>
        </tr>
        <tr>
            <td style="height: 22px;text-align: right;" class="table-frame-input-title">密码：</td>
            <td style="width:35%;height: 22px;" class="table-cell-input"><span class="test_must">
                <s:password name="userpwd" value="userinfo.test.userpwd" cssClass="form_input" id="TITLE23" size="24"/>
				</span> <span class="test_must">*<img src="images/info2.gif" width="16" height="16"
                                                      alt="不修改密码请不要填写"></span></td>
            <td style="width:13%;  height: 22px;text-align: right;" class="table-frame-input-title">确认密码：</td>
            <td style="width:35%" class="table-cell-input"><span class="test_must">
                <s:password name="userpwdag" value="userinfo.test.userpwd" cssClass="form_input" id="TITLE24"
                            size="24"/> * <img
                    src="images/info2.gif" width="16" height="16" alt="不修改密码请不要填写"></span></td>
        </tr>
        <tr>
            <td style="width: 17%;height: 22px;text-align: right;" class="table-frame-input-title">用户类型：</td>
            <td style="height: 22px" colspan="3" class="table-cell-input"><s:radio
                    list="#{'admin':'管理员','vip':'VIP','guest':'游客' }" name="userinfo.test.usertype"
                    value="userinfo.test.usertype"/></td>
        </tr>
    </table>
    <table style="width:99%;border:0 solid black; border-spacing: 0;padding: 0;text-align:center; " class="title-bar2">
        <tr>
            <td>
                <table style="width:98%;border:0 solid black; border-spacing: 0;padding: 0;text-align:center; ">
                    <tr style="cursor:pointer" onClick="titleBarShowOrHide('p3')">
                        <td style="width: 26px;" class="title-bar2-btn-col" id="p3_btn">&nbsp;</td>
                        <td style="width: 745px;" class="title-bar2-text">用户详细资料</td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
    <table style="width:99%;border:0 solid black; border-spacing: 0;padding: 0;text-align:center; "
           class="table-frame" id="p3">
        <tr>
            <td style="width: 17%;height: 22px;text-align: right;" class="table-frame-input-title">学号：</td>
            <td style="width: 83%;height: 22px;" class="table-cell-input"><span class="test_must">
                <s:textfield name="userinfo.code" cssClass="form_input" size="32"/>
						<s:hidden name="userinfo.id"/>
				</span></td>
        </tr>
        <tr>
            <td style="width: 17%;height: 22px;text-align: right;" class="table-frame-input-title">姓名：</td>
            <td style="width: 83%;height: 22px;" class="table-cell-input"><span class="test_must"> <s:textfield
                    name="userinfo.cnname" cssClass="form_input" size="32"/>
				</span></td>
        </tr>
        <tr>
            <td style="width: 17%;height: 22px;text-align: right;" class="table-frame-input-title">性别：</td>
            <td style="width: 83%;height: 22px;" class="table-cell-input"><s:radio list="#{'M':'男','F':'女'}"
                                                                                   name="userinfo.sex"
                                                                                   cssClass="form_input"/></td>
        </tr>
        <tr>
            <td style="width: 17%;height: 22px;text-align: right;" class="table-frame-input-title">出生时间：</td>
            <td style="width: 83%;height: 22px;" class="table-cell-input"><span class="test_must"> <s:textfield
                    name="userinfo.birDate" cssClass="form_input" size="32"/>
				</span></td>
        </tr>
        <tr>
            <td style="width: 17%;height: 22px;text-align: right;" class="table-frame-input-title">专业：</td>
            <td style="width: 83%;height: 22px;" class="table-cell-input"><span class="test_must"> <s:textfield
                    name="userinfo.spec" cssClass="form_input" size="32"/>
				</span></td>
        </tr>
        <tr>
            <td style="width: 17%;height: 22px;text-align: right;" class="table-frame-input-title">备注：</td>
            <td style="width: 83%;height: 22px;" class="table-cell-input"><span class="test_must">
                <s:textarea rows="5" cols="31" name="userinfo.remarks" cssClass="form_input"/>
				</span>
            </td>
        </tr>
    </table>
    <table style="width:99%;border:0 solid black; border-spacing: 0;padding: 0;text-align:center; "
           class="buttun-bar">
        <tr>
            <td>
                <s:submit cssClass="form-buttun" value="保 存"/>
                <input type="button" class="form-buttun" value="取 消" onClick="location.href='user_list.jsp'">
            </td>
        </tr>
    </table>
</s:form>
</body>
</html>
