<%@ page contentType="text/html; charset=gb2312"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title></title>
<link href="css/style.css" rel="stylesheet" type="text/css">
<link href="css/left_ctrl_bar.css" rel="stylesheet" type="text/css">
</head>

<script>
	var show = true;

	function menuShowOrHide(){
		
	
		if(show){
			show = false;
			document.all.buttonTable.className = "exp_button";
		}else{
			show = true;
			document.all.buttonTable.className = "col_button";
		}
		
		top.showOrHiddenLogoFrame(show);

	}
</script>

<body>
<table style="cursor:pointer;width: 10px;height: 100%;border: 0;padding: 0;border-spacing: 0" onClick="menuShowOrHide()">
  <tr>
    <td class="ctrl-bar-up">&nbsp;</td>
  </tr>
  <tr>
    <td class="ctrl-bar-bg">
	<table style="width: 100%;border:0;border-spacing: 0;padding: 0"  class="col_button" id="buttonTable">
      <tr>
        <td>&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td class="crtl-bar-down">&nbsp;</td>
  </tr>
</table>
</body>
</html>
