<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table style="width:100%;border: 0;border-spacing: 0;padding: 0;">
	<tr>
		<td class="title-bar">
			<table style="width:98%;border-spacing: 0;padding: 0;">
				<tr>
					<td style="width:26" class="title-bar-title-icon">&nbsp;</td>
					<td style="width:745" class="title-bar-text">${param.mainTitle }</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<c:if test="${param.hasBlankLine=='true'}">
<table style="width:99%;border:0px solid black; border-spacing: 0px;padding: 0px;text-align:center; " class="oper-bar">
			<tr>
				<td style="text-align: left"></td>
				<td style="text-align: right;"><span class="title_bar"> </span></td>
			</tr>
</table>
</c:if>