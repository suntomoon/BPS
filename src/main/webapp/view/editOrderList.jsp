<%@ taglib prefix="s" uri="/struts-tags"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Order</title>
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
 
<h2>BPS-Order</h2>
 
<s:form method="post" action="addOrder">
    <table>
	    <tr>
	        <td><s:textfield key="label.customerid" name="order.customerid"/></td> 
	    </tr>
	    <tr>
	        <td><s:textfield key="label.orderstartdate" name="order.orderstartdate"/></td>
	    </tr>
	     <tr>
	        <td><s:textfield key="label.orderenddate" name="order.orderenddate"/></td>
	    </tr>
	    <tr>
	        <td>
	        	<s:submit key="label.addorder"></s:submit>
	        </td>
	    </tr>
	</table> 
</s:form>
 
     
<h3>Orders Editor</h3>
<c:if  test="${!empty orders}">
	<table class="list">
		<tr>
		    <th align="left">CustomerID</th>
		    <th align="left">OrderStartDate</th>
		    <th align="left">OrderEndDate</th>
		    <th align="left">Actions</th>
		</tr>
		<c:forEach items="${orders}" var="order">
		    <tr>
		        <td>${order.customerid} </td>
		        <td>${order.orderstartdate}</td>
		        <td>${order.orderenddate}</td>
		        <td><a href="deleteOrder/${order.id}">delete</a></td>
		    </tr>
		</c:forEach>
	</table>
</c:if>
 
</body>
</html>