<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/el-function/member" prefix="util"%>

<div class='wrap'>	
	<div class='title'>
		<h1>회원가입</h1>
	</div>
	<div class='form'>
		<form action='/member/insert' method='post'>
			<div class='group'>
					<label for='m_name'>이름</label>
				<div class='input'>
					<input type='text' name='m_name' id='m_name'/>
					<p class='flag'></p>
				</div>
			</div>
			<div class='group'>
					<label for='m_id'>아이디</label> 
				<div class ='input' id='input_id'>
					<input type='text' name='m_id' id='m_id' />
					<p class='flag'></p>
				</div>
			</div>	
			<div class='group'>
				<label for='m_password'>비밀번호</label> 
				<div class ='input' id='input_password'>
					<input type='text' name='m_password' id='m_password'/>
					<p class='flag'></p>
				</div>
				<label for='m_password_check'>비밀번호 확인</label>
				<div class='input' id='input_password_check'>
					<input type='text' id='m_password_check'/> 
					<p class='flag'></p>
				</div>	
			</div>	
			<div class='group'>
					<label for='m_nickname'>닉네임</label> 
				<div class ='input' id='input_nickname'>
					<input type='text' name='m_nickname' id='m_nickname' />
					<p class='flag'></p>
				</div>
			</div>	
			<div class='group'>
				<div class='select' id='birth'>
					<strong>생년월일</strong> 
					<select name="year" id='year'>
						<c:forEach items="${util:getBirth('year') }" var="year">
							<option value="${year }">${year }</option>
						</c:forEach>
					</select> 
					<span>년</span> 
					<select name="month">
						<option value='x'>선택</option>
						<c:forEach items="${util:getBirth('month') }" var="month">
							<option value="${month }">${month }</option>
						</c:forEach>
					</select>
					<span>월</span>
					<select name='date' id='date'>
						<option value='x'>선택</option>
					</select>
					<span>일</span>
				</div>
				<p class='flag'></p>
			</div>	
				<div class='group'>
					<label for='m_phone'>전화번호</label> 
				<div class ='input' id='input_phone'>
					<input type='text' name='m_phone' id='m_phone' />
					<p class='flag'></p>
				</div>
			</div>	 
				<div class='group'>
					<label for='m_email'>이메일</label> 
				<div class ='input' id='input_email'>
					<input type='text' name='m_email' id='m_email' />
					<p class='flag'></p>
				</div>
			</div>	
		</form>
	</div>

	<div class='button'>
		<button id='sumit'>회원가입</button>
		<button onclick="location.href='/'">초기화면</button>
	</div>
</div>