<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/el-function/member" prefix="util"%>
<link href="/resources/member/css/form.css" rel="stylesheet">
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
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
				</div>
				<p class='flag'></p>
			</div>
			<div class='group'>
				<label for='m_id'>아이디</label> 
				<div class ='input' id='input_id'>
					<input type='text' name='m_id' id='m_id' />
				</div>
				<p class='flag'></p>
			</div>	
			<div class='group'>
				<label for='m_password'>비밀번호</label>  
				<div class ='input' id='input_password'>
					<input type="password" name='m_password' id='m_password'/>
					<p class='flag'></p>
				</div>
				<label for='m_password_check'>비밀번호 확인</label>
				<div class='input' id='input_password_check'>
					<input type='password' name='m_password2' id='m_password_check'/> 
				</div>	
				<p class='flag'></p>
			</div>	
			<div class='group'>
					<label for='m_nickname'>닉네임</label> 
				<div class ='input' id='input_nickname'>
					<input type='text' name='m_nickname' id='m_nickname' />
				</div>
				<p class='flag'></p>
			</div>	
			<div class='group'>
				<strong>성별</strong> 
				<div class='radio_man'>
					<span>남자</span>
					<input type="radio" name="m_gender" id='man' checked="checked"/>
				</div>
				<div class='radio_woman'>
					<span>여자</span>
					<input type='radio' id='woman'>
				</div>
				<p>&nbsp;</p>
			</div>
			<div class='group'>
				<strong>생년월일</strong> 
				<div class='select' id='birth'>
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
				</div>
				<p class='flag'></p>
			</div>	 
			<div class='group'>
				<label for='m_email'>이메일</label> 
				<div class ='input' id='input_email'>
					<input type='text' name='m_email' id='m_email' />
				</div>
				<p class='flag'></p>
			</div>	
			<div class='group'>
				<label>우편주소</label>
				<div class='zipcode'>
					<input type='text' name='m_zipcode' id='m_zipcode' readonly />
					<button type="button" onclick="javascript:daumPostcode()">우편검색</button>
				</div>
				<p></p>
			</div>
			<div class='group'>
 				<label>주소</label>
 				<div class='input'>
					<input type='text' name='m_address1' id='m_address1' readonly/>
					<p>&nbsp;</p>
				</div>
				<label for='m_address2'>상세주소</label>
				<div class='input'>
					<input type='text' name='m_address2' id='m_address2'/>
				</div>
				<p class='flag'></p>
			</div>
		</form> 
		<div class='group'>
			<div class='button'>
				<button id='sumit'>회원가입</button>
				<button onclick="location.href='/'">초기화면</button>
			</div>
		</div>
	</div>
</div>