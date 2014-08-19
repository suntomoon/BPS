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
</head>
<body>
 
<h2>BillRun Editor</h2>
 
<s:form method="post" action="addBillrun">
    <table>
	    <tr>
	        <td><s:textfield key="label.customerid" name="billrun.customerid"/></td> 
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