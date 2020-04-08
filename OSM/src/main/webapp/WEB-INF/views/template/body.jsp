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
.hutton button {
	width: 49%;
	height: 30px;
}
</style>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$(".radio_man,.radio_woman").click(function() {
			var target = $(this).attr('class');
			target = target == "radio_man" ? "#woman" : "#man";
			$(target).prop('checked', false);
			target = target == "#woman" ? "#man" : "#woman";
			$(target).prop('checked', true);
		});
		$("input").change(function() {
			if ($(this).attr('readonly') == undefined) {
				InputValueCheck($(this).attr('name'));
			}
		});
		function InputValueCheck(target) {
			$("input[name='" + target + "']").focusout(function() {
				var self = $(this);
				var value = $(self).val();
				var checkMsg = RegularExpression(target, value);
				var flag = NodeSelector(self);
				if (checkMsg != null) {
					$(flag).html(checkMsg);
					$(flag).attr('class', 'fail');
					$(self).focus();
					return;
				}
				FinallyCheck(self);
			});
		}

		function NodeSelector(self) {
			var parent = $(self).parents(".group")
			return $(parent).children("p");
		}

		function RegularExpression(target, value) {
			var checkMsg = null;
			switch (target) {
			case "m_name":
				checkMsg = value.length<2 || value.length>5 ? "최소 2글자 최대 5글자입니다."
						: /[가-힣]{2,5}/.test(value) ? null : "한글로만 입력이 가능합니다.";
				break;
			case "m_id":
				checkMsg = value.length<4 || value.length>15 ? "최소 4글자 최대 12 글자입니다."
						:/^[0-9]/.test(value) ?"숫자로 시작하실수 없습니다."  
						:/[\W|_].?/.test(value)?"공백,특수문자,한글을 포함할수 없습니다."
								: null;
				break;
			case "m_password":
				break;
			case "m_nickname":
				checkMsg = /^[0-9]/.test(value)?"숫자로 시작할수 없습니다." 
						:/[\s|ㄱ-ㅎㅏ-ㅣ|~!@#$%^&*()_+-=\\\|\[\]{}\.\,\/?].?/.test(value)?"자음모음,특수문자를 포함할수 없습니다."
								:null;  
							
				break;
			}
			return checkMsg;
		}

		function FinallyCheck(self) {
			var target = $(self).attr('name');
			var value = $(self).val();
			var flag = NodeSelector(self);
			var msg = null;
			switch (target) {
			case "m_name":
				msg = "이쁜 이름이시네요!";
				break;
			case "m_id":
			case "m_nickname":
				Duplicate(self)
				break;
			case "m_password":
				msg = "비밀번호를 확인해 주세요.";
				$("#m_password_check").focus();
				break;
			default:

				break;
			}
			if (msg != null) {
				$(flag).html(msg);
				$(flag).attr('class', 'success');
			}
		}
		function Duplicate(self) {
			var target = $(self).attr('name');
			target = "osm_"+target;
			var value = $(self).val();
			$.ajax({
				type: 'post',
				url : "/member/duplicate",
				dataType : "text",
				data:{
					target:target,
					value:value
						},
				success:function(result){
					var flag = NodeSelector(self);
					var msg = result=='success'?"사용하셔도":"중복된";
						msg += " "+( $(self).attr('name') == "m_id"?"아이디":"닉네임");
						msg +=" 입니다.";
					$(flag).attr('class',result);
					$(flag).html(msg);
					if(result == "fail"){
						$(self).focus(); 
					}
				}		
			});
		}
	});
</script>

<script type="text/javascript">
	function daumPostcode() {
		new daum.Postcode(
				{
					oncomplete : function(data) {
						// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

						// 각 주소의 노출 규칙에 따라 주소를 조합한다.
						// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
						var fullAddr = ''; // 최종 주소 변수
						var extraAddr = ''; // 조합형 주소 변수

						// 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
						if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
							fullAddr = data.roadAddress;

						} else { // 사용자가 지번 주소를 선택했을 경우(J)
							fullAddr = data.jibunAddress;
						}

						// 사용자가 선택한 주소가 도로명 타입일때 조합한다.
						if (data.userSelectedType === 'R') {
							// 법정동명이 있을 경우 추가한다.
							if (data.bname !== '') {
								extraAddr += data.bname;
							}
							// 건물명이 있을 경우 추가한다.
							if (data.buildingName !== '') {
								extraAddr += (extraAddr !== '' ? ', '
										+ data.buildingName : data.buildingName);
							}
							// 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
							fullAddr += (extraAddr !== '' ? ' (' + extraAddr
									+ ')' : '');
						}

						// 우편번호와 주소 정보를 해당 필드에 넣는다.
						document.getElementById('m_zipcode').value = data.zonecode; // 5자리
						// 새우편번호
						// 사용
						document.getElementById('m_address1').value = fullAddr;

						// 커서를 상세주소 필드로 이동한다.
						document.getElementById('m_address2').focus();
					}
				}).open();
	}
</script>
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