<%@ taglib prefix="s" uri="/struts-tags"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Invoice</title>
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
<h3>Invoices</h3>
<c:if  test="${!empty invoices}">
	<table class="list">
		<tr>
		    <th align="left">InvoiceID</th>
		    <th align="left">InvoiceDate</th>
		    <th align="left">Amount</th>
		</tr>
		<c:forEach items="${invoices}" var="inv">
		    <tr>
		        <td>${inv.invoiceid} </td>
		        <td>${inv.invoicedate}</td>
		        <td>${inv.amount}</td>
		    </tr>
		</c:forEach>
	</table>
</c:if>
 
</body>
</html>