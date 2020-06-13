<%--
  Created by IntelliJ IDEA.
  User: zhangzhaohong
  Date: 2020/6/13
  Time: 1:06 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="UploadPhotoServlet" method="POST" enctype="multipart/form-data">
    上传图片:<br><input type="file" name="filepath"/><br>
    <input type="submit" value="上传">
</form>
</body>
</html>
