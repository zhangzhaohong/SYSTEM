<%@ page language="java" pageEncoding="gb2312" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body style="background-color: rgb(239,246,254);">
<h3>����дѧ����Ϣ</h3>
<hr width="700" align="left">
<s:form action="addstudent" method="post" enctype="multipart/form-data">
<table border="0" cellspacing="0" cellpadding="1">
    <tr>
        <td>
            <s:textfield name="student.sno" label="ѧ��" value=""></s:textfield>
        </td>
    </tr>
    <tr>
        <td>
            <s:textfield name="student.sname" label="����" value=""></s:textfield>
        </td>
    </tr>
    <tr>
        <td>
            <s:radio name="student.sex" value="1" list="#{1:'��',0:'Ů'}" label="�Ա�"/>
        </td>
    </tr>
    <tr>
        <%--<s:select name="student.major.id" list="list" listKey="id" listValue="majorName" headerKey="0" headerValue="--��ѡ��רҵ--" label="רҵ"></s:select>--%>
        <s:select name="student.major.id" list="#{'0001':'�����','0002':'����','0003':'WEB','0004':'����'}" headerKey="0"
                  headerValue="--��ѡ��רҵ--" label="רҵ"></s:select>
    </tr>
    <tr>
        <s:textfield name="student.birthday" label="����ʱ��" value=""></s:textfield>
    </tr>
    <tr>
        <td>
            <s:textfield name="student.totalCredits" label="��ѧ��" value=""></s:textfield>
        </td>
    </tr>
    <tr>
        <td>
            <s:textfield name="student.remarks" label="��ע" value=""></s:textfield>
        </td>
    </tr>
    <tr>
        <td>
            <s:file name="photoFile" label="��Ƭ" value=""></s:file>
        </td>
    </tr>
</table>
<p>
    <input type="submit" value="���"/>
    <input type="reset" value="����"/>
    </s:form>
</body>
</html>
