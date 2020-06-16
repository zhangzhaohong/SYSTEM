<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>留言板</title>
    <link href="./css/oper_area.css" rel="stylesheet" type="text/css">
</head>
<body>
<div style="width: 100%;">
    <s:form action="addLyAction" method="post" theme="simple">
        <table style="width: 100%;border: 0;border-spacing: 0;padding: 0;">
            <tr>
                <td class="title-bar">
                    <table style="width: 100%;border-spacing: 0;padding: 0;">
                        <tr>
                            <td style="width: 26px" class="title-bar-title-icon">&nbsp;</td>
                            <td style="width: 745px" class="title-bar-text">添加留言</td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
        <table style="width: 100%;border-spacing: 0;padding: 0;text-align: center;margin: 100px 0 0 0;" id="p1">
            <tr>
                <td style="width: 24%;height: 24px;background-color: rgb(239,246,254);" class="table-frame-input-title">
                    留言标题
                </td>
                <td style="height: 24px;background-color: rgb(239,246,254);" class="table-cell-input">
                    <s:textfield name="ly.title" cssClass="form-input" size="100"/>
                    <s:hidden name="ly.id"/>
                </td>
            </tr>
            <tr>
                <td style="width: 24%;height: 350px;line-height: 22;background-color: rgb(239,246,254);"
                    class="table-frame-input-title">留言内容
                </td>
                <td style="height: 350px;background-color: rgb(239,246,254);" class="table-cell-input">
                    <s:textarea rows="24" cols="100" name="ly.lyContent"/>
                </td>
            </tr>
        </table>
        <table style="width: 99%;border-spacing: 0;padding: 0;text-align: center;border:0;">
            <tr>
                <td class="buttun-bar">
                    <s:submit value="提交" cssClass="form-buttun"/>
                    <s:reset value="重置" cssClass="form-buttun"/>
                </td>
            </tr>
        </table>
    </s:form>
</div>
<div>
    <br/>
    &nbsp;<s:label name="titleErr" style="color:red;"/>
    &nbsp;<p name="titleErr" style="color:red;"></p>
    <br/>
    <br/>
    &nbsp;<s:label name="lyContentErr" style="color:red;"/>
</div>
</body>
</html>
