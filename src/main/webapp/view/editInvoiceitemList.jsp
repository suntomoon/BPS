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

<a href="/BPS/listInvoice">back</a>

<h3>InvoiceItems</h3>
<c:if  test="${!empty invoiceitems}">
	<table class="list">
		<tr>
		    <th align="left">InvoiceName</th>
		    <th align="left">InvoiceItemName</th>
		    <th align="left">InvoiceItemStartDate</th>
		    <th align="left">InvoiceItemEndDate</th>
		    <th align="left">Amount</th>
		</tr>
		<c:forEach items="${invoiceitems}" var="invitem">
		    <tr>
		        <td>${invitem.invoicename} </td>
		        <td>${invitem.invoiceitemname}</td>
		        <td>${invitem.startdate}</td>
		        <td>${invitem.enddate}</td>
		        <td>${invitem.amount}</td>
		    </tr>
		</c:forEach>
	</table>
</c:if>
 
</body>
</html>