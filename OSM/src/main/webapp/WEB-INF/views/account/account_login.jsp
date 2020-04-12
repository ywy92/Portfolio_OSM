<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class='wrap'>
	<div class='form'>
		<form action='/account/login' method='post'>
			<div class='group' style = "margin-bottom: 10px;">
				<label for="m_id">아이디</label>
				<div class='input'> 
					<input type='text' name='m_id' id="m_id" value="${m_id}"/>
				</div>
			</div>
			<div class='group' style = "margin-bottom: 10px;">
				<label for="m_password">비밀번호</label>
				<div class='input'>
					<input type='password' name='m_password' id="m_password">
				</div>
			</div>
			<div class='group'>
				<p class='fail'>${msg}</p> 
			</div>
		</form> 
	</div>
</div>