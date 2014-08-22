<html>
<head>
<style type="text/css">
body {
	margin: 0;
	padding: 0 10px 0 10px;
	height: 100%;
	overflow-y: auto;
}

#content {
	margin: 90px 0px 0px 150px;
	display: block;
	padding: 0px;
}

#header {
	display: block;
	top: 0px;
	left: 0px;
	width: 100%;
	height:	70px;
	position: fixed;
	background-color: #ffffff;
	border: 1px solid #888;
}

#navigation {
	display: block;
	top: 90px;
	left: 0px;
	width: 142px;
	height: 100%;
	position: fixed;
	border: 1px solid #888;
}

* html #header {
	position: absolute;
}

* html #navigation {
	position: absolute;
}
</style>

</head>
<body>

	<div id="header">
		<jsp:include page="view/top.jsp" />
	</div>

	<div id="navigation">
		<jsp:include page="view/menu.jsp" />
	</div>

	<div id="content">
		<iframe name="content" src="view/content.jsp" width="100%"
			height="100%"> </iframe>
	</div>
</body>
</html>
