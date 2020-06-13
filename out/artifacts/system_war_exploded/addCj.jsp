<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<body style="background-color: rgb(239,246,254);">
<h3>请录入学生成绩</h3>
<hr>
<s:form action="addorupdateschool" method="post">
    <table border="1" cellspacing="1" cellpadding="8" width="400">
        <tr>
            <td width="100">
                学生：
            </td>
            <td>
                <select name="success.id.sno">
                    <s:iterator id="student" value="#request.list1">
                        <option value="<s:property value="#student.sno"/>">
                            <s:property value="#student.sname"/>
                        </option>
                    </s:iterator>
                </select>
            </td>
        </tr>
        <tr>
            <td width="100">
                课程：
            </td>
            <td>
                <select name="success.id.cno">
                    <s:iterator id="classes" value="#request.list2">
                        <option value="<s:property value="#classes.cno"/>">
                            <s:property value="#classes.cname"/>
                        </option>
                    </s:iterator>
                </select>
            </td>
        </tr>
        <tr>
            <s:textfield label="成绩" name="success.success" size="15"></s:textfield>
        </tr>
    </table>
    <input type="submit" value="确定"/>
    <input type="reset" value="重置"/>
</s:form>
</body>
</html>
