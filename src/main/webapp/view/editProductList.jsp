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

	<h2>Product Editor</h2>

	<s:form method="post" action="addProduct">
		<table>
			<tr>
				<td><s:textfield key="Product Name" name="product.productName" /></td>
			</tr>
			<tr>
				<td><s:textfield key="Description"
						name="product.productDescription" /></td>
			</tr>
			<tr>
				<td><s:submit key="label.addproduct"></s:submit></td>
			</tr>
		</table>
	</s:form>

	<h3>Products</h3>
	<c:if test="${!empty products}">
		<table class="list">
			<tr>
				<th align="left">ProductName</th>
				<th align="left">Description</th>
				<th align="left">Operation</th>
			</tr>
			<c:forEach items="${products}" var="pro">
				<tr>
					<td>${pro.productName}</td>
					<td>${pro.productDescription}</td>
					<td><a href="deleteProduct/${pro.id}">delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

</body>
</html>