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
			<th align="left">CustomerID</th>
		    <th align="left">CustomerName</th>
		    <th align="left">InvoiceID</th>
		    <th align="left">InvoiceDate</th>
		    <th align="left">Amount</th>
		    <th align="left">Balance</th>
		    <th align="left">Actions</th>
		</tr>
		<c:forEach items="${invoices}" var="inv">
		    <tr>
		    	<td>${inv.customerid} </td>
		        <td>${inv.customername}</td>
		        <td>${inv.invoiceid} </td>
		        <td>${inv.invoicedate}</td>
		        <td>${inv.amount}</td>
		        <td>${inv.balance}</td>
		        <td><a href="listInvoiceitem/${inv.id}">view</a>|<a href="view/editPaymentList.jsp">makePayment</a></td>
		    </tr>
		</c:forEach>
	</table>
</c:if>
<br/>
<br/>
<s:form method="post" action="downloadInvoice">
	<s:radio label="Invoice Format" name="formattype" list="#{'1':'TXT','2':'CSV','3':'PDF'}" value="1" />
	<br/>
	<s:submit key="Download"></s:submit>
</s:form>
</body>
</html>