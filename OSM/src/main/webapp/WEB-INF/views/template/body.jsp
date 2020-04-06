<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
.wrap {
	margin: auto;
	text-align: center;
}

.wrap .form {
	margin: auto;
	max-width: 500px;
}
.group{
	display: inline-block;
}
.group label{
	float:left;
	font-size: 20px;
	font-weight: 900;
}
.group .input input{
	width: 320px;
	height: 35px;
	font-size: 30px;
	text-align: center;
}
.input .flag {
	text-align: center;
	margin: 3px 0px;
	height: 21px;
}

.input .false {
	color: red;
}

.input .success {
	color: green;
}
</style>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
<title><tiles:insertAttribute name="title" /></title>
</head>
<body>
	<header>
		<tiles:insertAttribute name="header" />
	</header>
	<main>
		<tiles:insertAttribute name="body" />
	</main>
	<footer>
		<tiles:insertAttribute name="footer" />
	</footer>
</body>
</html>