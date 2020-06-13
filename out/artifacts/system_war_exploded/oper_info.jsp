<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<link rel="stylesheet" href="css/bootstrap.css" type="text/css">
	<link rel="stylesheet" href="css/modify_user_info.css" type="text/css">
	<link rel="stylesheet" href="css/oper_area.css" type="text/css">
</head>
<body>
	<table border="1" style="width:100%" class="table table-bordered">
		<caption></caption>
		<thead>
		 	<tr>
		 		<th class="userinfo_title p-2">操作提示</th>
			</tr>
		</thead>
		<tr>
		   <td style="padding:10px 20%;">
				<table style="background-color: white;" class="table table-bordered">	
					<tr>
						<td style="width: 156;height: 20;text-align: content;color:blue;">操作:</td>
						<td style="height: 20;text-align: content;">${action }</td>
					</tr>
					<tr>
						<td style="height: 20;text-align: content;color:blue;">提示信息:</td><
						<td style="height: 20;text-align: content;">${oper_info }</td>
					</tr>
					<c:if var="nextOper" test="${next_url!=null}">
						<tr>
							<td style="width: 156;height: 20;text-align: content;color:blue;">下一步:</td>
							<td style="height: 20;text-align: content;color:orange;">
								正在转向${next_info }......	
								<script type="text/javascript">
									onload=function(){ 
										setTimeout(go, 3000);
									}; 
									function go(){ 
										location.href="${next_url}"; 
									}
								</script> 
							</td>
						</tr>
					</c:if>
				</table>
		   </td>
		</tr>
	</table>
</body>
</html>