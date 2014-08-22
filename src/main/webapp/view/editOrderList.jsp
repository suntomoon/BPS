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
	<script type="text/javascript">
		function setValue(){
			var index = document.getElementById("customer").selectedIndex;
			var option = document.getElementById("customer").options[index];
			document.getElementById("customerid").value=option.value;
			document.getElementById("customername").value=option.text;
		}
	</script>
</head>
<body>
 
<h2>Order Editor</h2>
 
<s:form method="post" action="addOrder" onsubmit="setValue()">
    <table>
    	<tr>
    		<td>Customer: 
			</td>
			<td><c:if  test="${!empty customers}">
		        	<select id="customer" style="width: 155px">
	      				<c:forEach items="${customers}" var="cus">
	  			    		<option value="${cus.id}">${cus.firstname} ${cus.lastname}</option>
	    				</c:forEach>
					</select>
				</c:if></td> 
    	</tr>
	    <tr>
	        <td><s:hidden id="customerid" value="1" name="order.customerid" />
	        	<s:hidden id="customername" value="name" name="order.customername" /></td> 
	    </tr>
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
    		<td>RatePlan: 
			</td>
			<td><c:if  test="${!empty productrateplans}">
		        	<select id="productrateplan" style="width: 155px">
	      				<c:forEach items="${productrateplans}" var="prp">
	  			    		<option value="${prp.id}">${prp.productrateplanname}</option>
	    				</c:forEach>
					</select>
				</c:if></td> 
    	</tr>
	    <tr>
	        <td><s:textfield key="label.orderstartdate" name="order.orderstartdate"/></td>
	    </tr>
	     <tr>
	        <td><s:textfield key="label.orderenddate" name="order.orderenddate"/></td>
	    </tr>
	    <tr>
	        <td><s:label key="Daily" label="Order Type" /></td>
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
		    <th align="left">CustomerName</th>
		    <th align="left">OrderStartDate</th>
		    <th align="left">OrderEndDate</th>
		    <th align="left">Actions</th>
		</tr>
		<c:forEach items="${orders}" var="order">
		    <tr>
		        <td>${order.customerid} </td>
		        <td>${order.customername} </td>
		        <td>${order.orderstartdate}</td>
		        <td>${order.orderenddate}</td>
		        <td><a href="deleteOrder/${order.id}">delete</a></td>
		    </tr>
		</c:forEach>
	</table>
</c:if>
 
<h3>Order Plans</h3>
<c:if  test="${!empty orderplans}">
	<table class="list">
		<tr>
		    <th align="left">OrderID</th>
		    <th align="left">OrderPlanName</th>
		</tr>
		<c:forEach items="${orderplans}" var="ordp">
		    <tr>
		        <td>${ordp.orderid} </td>
		        <td>${ordp.orderplanname} </td>
		    </tr>
		</c:forEach>
	</table>
</c:if>
 
<h3>Order Items</h3>
<c:if  test="${!empty orderitems}">
	<table class="list">
		<tr>
		    <th align="left">OrderPlanID</th>
		    <th align="left">OrderItemName</th>
		    <th align="left">ChargeType</th>
		    <th align="left">ChargeMode</th>
		    <th align="left">Amount</th>
		</tr>
		<c:forEach items="${orderitems}" var="ori">
		    <tr>
		        <td>${ori.orderplanid} </td>
		        <td>${ori.orderitemname} </td>
		        <td>${ori.chargetype} </td>
		        <td>${ori.chargemode} </td>
		        <td>${ori.amount} </td>
		    </tr>
		</c:forEach>
	</table>
</c:if>
</body>
</html>