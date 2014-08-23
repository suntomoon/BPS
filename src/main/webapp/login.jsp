<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>BPS</title>
<style>
table.list {
	border-collapse: collapse;
	width: 40%;
}

table.list, table.list td, table.list th {
	border: 1px solid gray;
	padding: 5px;
}
</style>
</head>
<body>

	<h2>Welcome to BPS</h2>

	<s:form method="post" action="toLogin">
		<table>
			<tr>
				<td><s:textfield key="Username" name="login.username" /></td>
			</tr>
			<tr>
				<td><s:textfield key="Password"
						name="login.password" /></td>
			</tr>
			<tr>
				<td><s:submit key="label.signin"></s:submit></td>
			</tr>
		</table>
	</s:form>


</body>
</html>