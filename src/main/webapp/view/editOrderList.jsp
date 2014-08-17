<%@ taglib prefix="s" uri="/struts-tags"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Spring-4 + Struts-3 + Hibernate Integration Demo</title>
    <style>
	table.list
	{
		border-collapse:collapse;
		width: 40%;
	}
	table.list, table.list td, table.list th
	{
		border:1px solid gray;
		padding: 5px;
	}
	</style>
</head>
<body>
 
<h2>Spring-4 + Struts-3 + Hibernate Integration Demo</h2>
 
<s:form method="post" action="addOrder">
    <table>
	    <tr>
	        <td><s:textfield key="label.customerid" name="order.customerid"/></td> 
	    </tr>
	    <tr>
	        <td><s:textfield key="label.orderdate" name="order.orderdate"/></td>
	    </tr>
	    <tr>
	        <td>
	        	<s:submit key="label.addorder"></s:submit>
	        </td>
	    </tr>
	</table> 
</s:form>
 
     
<h3>Orders</h3>
<c:if  test="${!empty orders}">
	<table class="list">
		<tr>
		    <th align="left">CustomerID</th>
		    <th align="left">OrderDate</th>
		    <th align="left">Actions</th>
		</tr>
		<c:forEach items="${orders}" var="order">
		    <tr>
		        <td>${order.customerid} </td>
		        <td>${order.orderdate}</td>
		        <td><a href="deleteOrder/${order.id}">delete</a></td>
		    </tr>
		</c:forEach>
	</table>
</c:if>
 
</body>
</html>