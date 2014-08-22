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
	<script type="text/javascript">
		function setValue(){
			var index = document.getElementById("product").selectedIndex;
			var option = document.getElementById("product").options[index];
			document.getElementById("Product ID").value=option.value;
			document.getElementById("Product Name").value=option.text;
			return true;
		}
	</script>
</head>
<body>
 
<h2>Product RatePlan Editor</h2>
 
<s:form method="post" action="addProductrateplan" onsubmit="setValue()">
    <table>
   		 <tr> 
   		 	<td>Product: 
			</td>
			<td><c:if  test="${!empty products}">
		        	<select id="product" style="width: 155px">
	      				<c:forEach items="${products}" var="pro">
	  			    		<option value="${pro.id}">${pro.productName}</option>
	    				</c:forEach>
					</select>
				</c:if></td> 
	    </tr>
	    <tr>
	        <td>
	        	<s:hidden id="Product ID" value="1" name="productrateplan.productid" />
	        	<s:hidden id="Product Name" value="name" name="productrateplan.productname" />
	        </td> 
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