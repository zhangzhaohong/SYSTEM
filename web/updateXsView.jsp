<%@ page language="java" pageEncoding="gb2312" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head></head>
<body style="background-color: rgb(239,246,254);">
<s:set var="student" value="#request.studentInfo"></s:set>
<s:form action="updatestudent" method="post" enctype="multipart/form-data">
    <table border="0" cellspacing="1" cellpadding="8" width="500">
        <tr>
            <td width="80">ѧ�ţ�</td>
            <td>
                <input type="text" name="student.sno" value="<s:property value="#student.sno"/>" readonly/>
            </td>
        </tr>
        <tr>
            <td width="80">������</td>
            <td>
                <input type="text" name="student.sname" value="<s:property value="#student.sname"/>"/>
            </td>
        </tr>
        <tr>
            <td width="80">
                <s:radio list="#{1:'��',0:'Ů'}" value="#student.sex" label="�Ա�" name="student.sex"></s:radio>
            </td>
        </tr>
        <tr>
            <td>
                <s:select name="student.major.id" list="#{'0001':'�����','0002':'����','0003':'WEB','0004':'����'}" headerKey="0"
                          headerValue="--��ѡ��רҵ--" label="רҵ"></s:select>
            </td>
        </tr>
        <tr>
            <td width="80">����ʱ�䣺</td>
            <td>
                <input type="text" name="student.birthday" value="<s:property value="#student.birthday"/>"/>
            </td>
        </tr>
        <tr>
            <td width="80">��ѧ�֣�</td>
            <td>
                <input type="text" name="student.totalCredits" value="<s:property value="#student.totalCredits"/>"/>
            </td>
        </tr>
        <tr>
            <td width="80">��ע��</td>
            <td>
                <input type="text" name="student.remarks" value="<s:property value="#student.remarks"/>"/>
            </td>
        </tr>
        <tr>
            <td>��Ƭ</td>
            <td>
                <input type="file" name="photoFile"/>
            </td>
        </tr>
    </table>
    <input type="submit" value="�޸�"/>
    <!-- ������һ���� -->
    <input type="button" value="����" onclick="history.back();"/>
</s:form>
<!-- ������ JavaScript ��ʵ�ָ��ݸ�ѧ����רҵ ID ����ʾרҵ�� -->
<script type="text/javascript">
    document.getElementById("student.major.id").value = '<s:property value="#student.major.id"/>'
</script>
</body>
</html>
