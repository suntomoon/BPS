<%@ taglib prefix="s" uri="/struts-tags"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Customer</title>
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
 
<<<<<<< HEAD
<h2>Customer</h2>
=======
<h2>Customers List Editor</h2>
>>>>>>> 1e2452d73386434a7c1fa101457087063bb70e19
 
<s:form method="post" action="addCustomer">
    <table>
	    <tr>
	        <td><s:textfield key="label.firstname" name="customer.firstname"/></td> 
	    </tr>
	    <tr>
	        <td><s:textfield key="label.lastname" name="customer.lastname"/></td>
	    </tr>
	    <tr>
	        <td><s:textfield key="label.email" name="customer.email"/></td>
	    </tr>
	    <tr>
	        <td><s:textfield key="label.telephone" name="customer.telephone"/></td>
	    </tr>
	    <tr>
	        <td><s:textfield key="label.billdate" name="customer.billdate"/></td>
	    </tr>
	    <tr>
	        <td>
	        	<s:submit key="label.addcustomer"></s:submit>
	        </td>
	    </tr>
	</table> 
</s:form>
 
     
<h3>Customers</h3>
<c:if  test="${!empty customers}">
	<table class="list">
		<tr>
		    <th align="left">Name</th>
		    <th align="left">Email</th>
		    <th align="left">Telephone</th>
		    <th align="left">BillDate</th>
		    <th align="left">Actions</th>
		</tr>
		<c:forEach items="${customers}" var="cus">
		    <tr>
		        <td>${cus.lastname}, ${cus.firstname} </td>
		        <td>${cus.email}</td>
		        <td>${cus.telephone}</td>
		        <td>${cus.billdate}</td>
		        <td><a href="deleteCustomer/${cus.id}">delete</a></td>
		    </tr>
		</c:forEach>
	</table>
</c:if>
 
</body>
</html>