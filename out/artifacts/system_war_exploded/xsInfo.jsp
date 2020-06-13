<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <link href="./css/oper_area.css" rel="stylesheet" type="text/css">
</head>
<body bgcolor="#D9DFAA">
<table style="width: 100%;border: 0;border-spacing: 0;padding: 0;">
    <tr>
        <td class="title-bar">
            <table style="width: 98%;border-spacing: 0;padding: 0;">
                <tr>
                    <td style="width: 26px" class="title-bar-title-icon">&nbsp;</td>
                    <td style="width: 745px" class="title-bar-text">学生列表</td>
                </tr>
            </table>
        </td>
    </tr>
</table>
<table style="width: 99%;border-spacing: 0;padding: 0;text-align: center;" class="oper-bar">
    <tr>
        <td style="text-align: left;">&nbsp;</td>
        <td style="text-align: right;"><span class="title-bar"><input name="Submit22" type="button" class="form-button"
                                                                      value="添加"
                                                                      onClick="location.href='addXsInfo.jsp'"></span>
        </td>
    </tr>
</table>
<table style="width: 100%;height:30px;border: 0;border-spacing: 0;padding: 0;">
    <tr style="background-color: rgb(193,218,243);color: rgb(15,25,255);">
        <th>学号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>专业</th>
        <th>出生时间</th>
        <th>总学分</th>
        <th>详细信息</th>
        <th>操作</th>
        <th>操作</th>
    </tr>
    <s:iterator value="#request.list">
        <tr style="color: rgb(15,25,255);text-align: center;">
            <td><s:property value="#student.sno"/></td>
            <td><s:property value="#student.sname"/></td>
            <td>
                <s:if test="#student.sex==1">男</s:if>
                <s:else>女</s:else>
            </td>
            <td><s:property value="#student.major.majorName"/></td>
            <td><s:property value="#student.birthday"/></td>
            <td><s:property value="#student.totalCredits"/></td>
            <td>
                <a href="findstudent.action?student.sno=<s:property value="#student.sno"/>">详细信息</a>
            </td>
            <td>
                <a href="deletestudent.action?student.sno=<s:property value="#student.sno"/>"
                   onClick="if(!confirm('确定删除该生信息吗？'))return false;else return true;">删除</a>
            </td>
            <td>
                <a href="updatestudentView.action?student.sno=<s:property value="#student.sno"/>">修改</a>
            </td>
        </tr>
    </s:iterator>
    <tr>
        <td colspan="9" style="text-align: center;">
            <s:set var="page" value="#request.page"></s:set>
            <s:if test="#page.hasFirst">
                <s:a href="studentInfo.action?pageNow=1">首页</s:a>
            </s:if>
            <s:if test="#page.hasPre">
                <a href="studentInfo.action?pageNow=<s:property value="#page.pageNow-1"/>">上一页</a>
            </s:if>
            <s:if test="#page.hasNext">
                <a href="studentInfo.action?pageNow=<s:property value="#page.pageNow+1"/>">下一页</a>
            </s:if>
            <s:if test="#page.hasLast">
                <a href="studentInfo.action?pageNow=<s:property value="#page.totalPage"/>">尾页</a>
            </s:if>
        </td>
    </tr>
</table>
</body>
</html>
