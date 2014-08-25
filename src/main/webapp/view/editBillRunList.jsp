<%@ taglib prefix="s" uri="/struts-tags"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>BillRun</title>
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
			document.getElementById("customerid").value = option.value;
			document.getElementById("customername").value = option.text;
		}
	</script>
</head>
<body>
 
<h2>BillRun Editor</h2>
 
<s:form method="post" action="addBillrun" onsubmit="setValue()">
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
	        <td>
	        	<s:hidden id="customerid" value="1" name="billrun.customerid" />
	        	<s:hidden id="customername" value="1" name="billrun.customername" />
	        </td> 
	    </tr>
	    <tr>
	        <td><s:textfield key="label.billrunenddate" name="billrun.billrunenddate"/></td>
	    </tr>
	    <tr>
	        <td>
	        	<s:submit key="label.addBillRun"></s:submit>
	        </td>
	    </tr>
	</table> 
</s:form>
 
     
<h3>BillRun List</h3>
<c:if  test="${!empty billruns}">
	<table class="list">
		<tr>
		    <th align="left">CustomerID</th>
		    <th align="left">BillRunEndDate</th>
		    <th align="left">Actions</th>
		</tr>
		<c:forEach items="${billruns}" var="br">
		    <tr>
		        <td>${br.customerid} </td>
		        <td>${br.billrunenddate}</td>
		        <td><a href="deleteBillrun/${br.id}">delete</a></td>
		    </tr>
		</c:forEach>
	</table>
</c:if>
 
</body>
</html>