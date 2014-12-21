<%@page import="$" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title><%=UserInfo.TABLE_ALIAS%>信息</title>
</rapid:override>

<rapid:override name="content">
	<s:form action="/somebody/UserInfo/list.do" method="get" theme="simple">
		<input type="button" value="返回列表" onclick="window.location='${ctx}/somebody/UserInfo/list.do'"/>
		<input type="button" value="后退" onclick="history.back();"/>
		
		<s:hidden name="userId" id="userId" value="%{model.userId}"/>
	
		<table class="formTable">
			<tr>	
				<td class="tdLabel"><%=UserInfo.ALIAS_USERNAME%></td>	
				<td><s:property value="%{model.username}" /></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UserInfo.ALIAS_PASSWORD%></td>	
				<td><s:property value="%{model.password}" /></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UserInfo.ALIAS_BIRTH_DATE%></td>	
				<td><s:property value="%{model.birthDateString}" /></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UserInfo.ALIAS_SEX%></td>	
				<td><s:property value="%{model.sex}" /></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UserInfo.ALIAS_AGE%></td>	
				<td><s:property value="%{model.age}" /></td>
			</tr>
		</table>
	</s:form>
</rapid:override>

<%-- jsp模板继承,具体使用请查看: http://code.google.com/p/rapid-framework/wiki/rapid_jsp_extends --%>
<%@ include file="base.jsp" %>