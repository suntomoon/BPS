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
			var index = document.getElementById("productrateplan").selectedIndex;
			var option = document.getElementById("productrateplan").options[index];
			document.getElementById("Rateplan ID").value=option.value;
			document.getElementById("Rateplan Name").value=option.text;
			
			var index = document.getElementById("chargetype").selectedIndex;
			var option = document.getElementById("chargetype").options[index];
			document.getElementById("Charge Type").value=option.text;
			
			var index = document.getElementById("chargemodel").selectedIndex;
			var option = document.getElementById("chargemodel").options[index];
			document.getElementById("Charge Model").value=option.text;
		}
	</script>
</head>
<body>
 
<h2>Product Item Editor</h2>

<s:form method="post" action="addProductitem" onsubmit="setValue()">
    <table>
	    <tr> 
   		 	<td>ProductRatePlan: 
   		 	</td>
   		 	<td>
	   		 	<c:if  test="${!empty productrateplans}">
		        	<select id="productrateplan" style="width: 155px">
	      				<c:forEach items="${productrateplans}" var="prrp">
	  			    		<option value="${prrp.id}">${prrp.productrateplanname}</option>
	    				</c:forEach>
					</select>
				</c:if>
			</td> 
	    </tr>
	    <tr>
	        <td>
	        	<s:hidden id="Rateplan ID" value="1" name="productitem.planid" />
	        	<s:hidden id="Rateplan Name" value="name" name="productitem.planname" />
	        	<s:hidden id="Charge Type" value="name" name="productitem.itemchargetype" />
	        	<s:hidden id="Charge Model" value="name" name="productitem.itemchargemodel" />
	        </td> 
	    </tr>
	    <tr>
	        <td><s:textfield key="Item Name" name="productitem.itemname"/></td> 
	    </tr>
	    <tr>
	    	<td>Charge Type: 
   		 	</td>
	    	<td>
		    	<select id="chargetype" style="width: 155px">
	   				<option value="1">Recurring</option>
	 				<option value="1">Onetime</option>
				</select>
	       	</td> 
	    </tr>
	    <tr>
	    	<td>Charge Model: 
   		 	</td>
	    	<td>
		       <select id="chargemodel" style="width: 155px">
	   				<option value="1">FlatFee</option>
				</select>
			</td>
	    </tr>
	    <tr>
	        <td><s:textfield key="Amount" name="productitem.itemamount"/></td> 
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
     
<h3>Product Items</h3>
<c:if  test="${!empty productitems}">
	<table class="list">
		<tr>
			<th align="left">Rate Plan</th>
		    <th align="left">Product Item</th>
		    <th align="left">Charge Type</th>
		    <th align="left">Charge Model</th>
			<th align="left">Amount</th>
		    <th align="left">Description</th>
		    <th align="left">Operation</th>
		</tr>
		<c:forEach items="${productitems}" var="prit">
		    <tr>
		    	<td>${prit.planname}</td>
		        <td>${prit.itemname} </td>
		        <td>${prit.itemchargetype}</td>
		        <td>${prit.itemchargemodel}</td>
		        <td>${prit.itemamount}</td>
		        <td>${prit.itemdescription} </td>
		        <td><a href="deleteProductitem/${prit.id}">delete</a></td>
		    </tr>
		</c:forEach>
	</table>
</c:if>
</body>
</html>