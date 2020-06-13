<%@ page contentType="text/html; charset=gb2312" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=GBK">
    <title>������Ϣ</title>
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
        <jsp:param name="mainTitle" value="�޸��û���Ϣ"/>
        <jsp:param name="hasBlankLine" value="true"/>
    </jsp:include>

    <table style="width:100%;border:0 solid black; border-spacing: 0;padding: 0;">
        <tr>
            <td class="title-bar">
                <table style="width:98%;border:0 solid black; border-spacing: 0;padding: 0;text-align:center; ">
                    <tr>
                        <td style="width: 26px;" class="title-bar-title-icon">&nbsp;</td>
                        <td style="width: 745px;" class="title-bar-text">�޸��û���Ϣ</td>
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
                        <td style="width: 745px;" class="title-bar2-text">�û���Ϣ</td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
    <table style="width:99%;border:0px solid black; border-spacing: 0px;padding: 0px;text-align:center; "
           class="table-frame" id="p1">
        <tr>
            <td style="width: 17%;height: 22px;text-align: right;" class="table-frame-input-title">�û�����</td>
            <td style="height: 22px" colspan="3" class="table-cell-input"><span class="test_must"><b>
                <s:label name="userinfo.test.username"/>
                <s:hidden name="userinfo.test.id"/>
							<s:hidden name="userinfo.test.username"/>
							<s:hidden name="userinfo.test.userpwd"/> </b></span></td>
        </tr>
        <tr>
            <td style="height: 22px;text-align: right;" class="table-frame-input-title">���룺</td>
            <td style="width:35%;height: 22px;" class="table-cell-input"><span class="test_must">
                <s:password name="userpwd" value="userinfo.test.userpwd" cssClass="form_input" id="TITLE23" size="24"/>
				</span> <span class="test_must">*<img src="images/info2.gif" width="16" height="16"
                                                      alt="���޸������벻Ҫ��д"></span></td>
            <td style="width:13%;  height: 22px;text-align: right;" class="table-frame-input-title">ȷ�����룺</td>
            <td style="width:35%" class="table-cell-input"><span class="test_must">
                <s:password name="userpwdag" value="userinfo.test.userpwd" cssClass="form_input" id="TITLE24"
                            size="24"/> * <img
                    src="images/info2.gif" width="16" height="16" alt="���޸������벻Ҫ��д"></span></td>
        </tr>
        <tr>
            <td style="width: 17%;height: 22px;text-align: right;" class="table-frame-input-title">�û����ͣ�</td>
            <td style="height: 22px" colspan="3" class="table-cell-input"><s:radio
                    list="#{'admin':'����Ա','vip':'VIP','guest':'�ο�' }" name="userinfo.test.usertype"
                    value="userinfo.test.usertype"/></td>
        </tr>
    </table>
    <table style="width:99%;border:0 solid black; border-spacing: 0;padding: 0;text-align:center; " class="title-bar2">
        <tr>
            <td>
                <table style="width:98%;border:0 solid black; border-spacing: 0;padding: 0;text-align:center; ">
                    <tr style="cursor:pointer" onClick="titleBarShowOrHide('p3')">
                        <td style="width: 26px;" class="title-bar2-btn-col" id="p3_btn">&nbsp;</td>
                        <td style="width: 745px;" class="title-bar2-text">�û���ϸ����</td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
    <table style="width:99%;border:0 solid black; border-spacing: 0;padding: 0;text-align:center; "
           class="table-frame" id="p3">
        <tr>
            <td style="width: 17%;height: 22px;text-align: right;" class="table-frame-input-title">ѧ�ţ�</td>
            <td style="width: 83%;height: 22px;" class="table-cell-input"><span class="test_must">
                <s:textfield name="userinfo.code" cssClass="form_input" size="32"/>
						<s:hidden name="userinfo.id"/>
				</span></td>
        </tr>
        <tr>
            <td style="width: 17%;height: 22px;text-align: right;" class="table-frame-input-title">������</td>
            <td style="width: 83%;height: 22px;" class="table-cell-input"><span class="test_must"> <s:textfield
                    name="userinfo.cnname" cssClass="form_input" size="32"/>
				</span></td>
        </tr>
        <tr>
            <td style="width: 17%;height: 22px;text-align: right;" class="table-frame-input-title">�Ա�</td>
            <td style="width: 83%;height: 22px;" class="table-cell-input"><s:radio list="#{'M':'��','F':'Ů'}"
                                                                                   name="userinfo.sex"
                                                                                   cssClass="form_input"/></td>
        </tr>
        <tr>
            <td style="width: 17%;height: 22px;text-align: right;" class="table-frame-input-title">����ʱ�䣺</td>
            <td style="width: 83%;height: 22px;" class="table-cell-input"><span class="test_must"> <s:textfield
                    name="userinfo.birDate" cssClass="form_input" size="32"/>
				</span></td>
        </tr>
        <tr>
            <td style="width: 17%;height: 22px;text-align: right;" class="table-frame-input-title">רҵ��</td>
            <td style="width: 83%;height: 22px;" class="table-cell-input"><span class="test_must"> <s:textfield
                    name="userinfo.spec" cssClass="form_input" size="32"/>
				</span></td>
        </tr>
        <tr>
            <td style="width: 17%;height: 22px;text-align: right;" class="table-frame-input-title">��ע��</td>
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
                <s:submit cssClass="form-buttun" value="�� ��"/>
                <input type="button" class="form-buttun" value="ȡ ��" onClick="location.href='user_list.jsp'">
            </td>
        </tr>
    </table>
</s:form>
</body>
</html>
