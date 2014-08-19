<%@ taglib prefix="s" uri="/struts-tags"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>BPS</title>
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
 
<h2>Product RatePlan Editor</h2>
 
<s:form method="post" action="addProductrateplan">
    <table>
    	<tr>
	        <td><s:textfield key="Product" name="productrateplan.productname"/></td> 
	    </tr>
	    <tr>
	        <td><s:textfield key="Rate Plan" name="productrateplan.productrateplanname"/></td> 
	    </tr>
	    <tr>
	        <td><s:textfield key="Description" name="productrateplan.productrateplandescription"/></td>
	    </tr>
	    <tr>
	        <td>
	        	<s:submit key="label.addProductrateplan"></s:submit>
	        </td>
	    </tr>
	</table> 
</s:form>
 
     
<h3>Product RatePlans</h3>
<c:if  test="${!empty productrateplans}">
	<table class="list">
		<tr>
		    <th align="left">Product</th>
		    <th align="left">Rate Plan</th>
		    <th align="left">Description</th>
		    <th align="left">Action</th>
		</tr>
		<c:forEach items="${productrateplans}" var="prrp">
		    <tr>
		        <td>${prrp.productname} </td>
		        <td>${prrp.productrateplanname} </td>
		        <td>${prrp.productrateplandescription}</td>
		        <td><a href="deleteProductrateplan/${prrp.id}">delete</a></td>
		    </tr>
		</c:forEach>
	</table>
</c:if>
 
</body>
</html>