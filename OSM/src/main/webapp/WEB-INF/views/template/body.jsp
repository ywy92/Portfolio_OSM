<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/resources/common/css/wrap.css" rel="stylesheet"/>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
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