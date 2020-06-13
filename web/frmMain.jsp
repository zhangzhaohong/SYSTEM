<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>留言板系统</title>
</head>
<script>

    //控制LOGO框架的显示与隐藏
    function showOrHiddenLogoFrame(isShow) {
        if (isShow) {
            document.all.middleFrame.cols = "180,10,*";
        } else {
            document.all.middleFrame.cols = "0,10,*";
        }
    }
</script>


<frameset rows="60,30,*,4" cols="*" frameborder="yes" border="0" framespacing="0" name="fwFrame">
    <frame name="logoFrame" scrolling="NO" noresize src="logo.jsp" frameborder="NO">
    <frame name="menutabFrame" scrolling="NO" noresize src="menu_tab.jsp" frameborder="NO">

    <frameset rows="*" cols="180,10,*" frameborder="NO" border="0" framespacing="0" name="middleFrame">
        <frame name="menuFrame" noresize scrolling="no" src="menu.jsp" frameborder="NO">
        <frame name="leftCtruBarFrame" src="left_ctrl_bar.jsp" noresize scrolling="NO">
        <frame name="mainFrame" src="main.jsp" noresize scrolling="yes">
    </frameset>

    <frame name="stateBarFrame" scrolling="NO" noresize src="state_bar.jsp" frameborder="NO">
</frameset>

<noframes>
    <body bgcolor="#FFFFFF" text="#000000" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
    </body>
</noframes>
</html>
