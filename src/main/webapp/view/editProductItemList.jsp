<%@ taglib prefix="s" uri="/struts-tags"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>BPS Demo</title>
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
 
<h2>Product Items List Editor</h2>
 
<s:form method="post" action="addProductitem">
    <table>
    	<tr>
	        <td><s:textfield key="Product Item" name="productitem.itemname"/></td> 
	    </tr>
	    <tr>
	        <td><s:textfield key="Charge Model" name="productitem.itemchargemodel"/></td> 
	    </tr>
	    <tr>
	        <td><s:textfield key="Charge Type" name="productitem.itemchargetype"/></td> 
	    </tr>
	    <tr>
	        <td><s:textfield key="Description" name="productitem.itemdescription"/></td>
	    </tr>
	    <tr>
	        <td>
	        	<s:submit key="label.addProductitem"></s:submit>
	        </td>
	    </tr>
	</table> 
</s:form>
 
     
<h3>Product Items Available</h3>
<c:if  test="${!empty productitems}">
	<table class="list">
		<tr>
		    <th align="left">Product Item</th>
		    <th align="left">Charge Model</th>
		    <th align="left">Charge Type</th>
		    <th align="left">Description</th>
		    <th align="left">Operation</th>
		</tr>
		<c:forEach items="${productitems}" var="prit">
		    <tr>
		        <td>${prit.itemname} </td>
		        <td>${prit.itemchargemodel} </td>
		        <td>${prit.itemchargetype}</td>
		        <td>${prit.itemdescription} </td>
		        <td><a href="deleteProductitem/${prit.id}">delete</a></td>
		    </tr>
		</c:forEach>
	</table>
</c:if>
 
</body>
</html>