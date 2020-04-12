$(function() {
		var old_year = null;
		var old_month = null;
		var index = 0;
		var focusFail = 0;
		$(".radio_man,.radio_woman").click(function() {
			var target = $(this).attr('class');
			target = target == "radio_man" ? "#woman" : "#man";
			$(target).prop('checked', false);
			target = target == "#woman" ? "#man" : "#woman";
			$(target).prop('checked', true);
		});
		$("input").focus(function() {
			if ($(this).attr('readonly') == undefined && focusFail == 0) {
				InputValueCheck($(this).attr('name'));
				return; 
			}
		});
		$("input[name='m_nickname']").keyup(function(){
			var flag = NodeSelector($(this));
			var value = $(this).val();
			index = 0;
			for(var i = 0; i <value.length; i++){
				var token = value.charAt(i);
				index += /[가-힣]/.test(token)?2:1;
			}
			$(flag).attr('class','length');
			$(flag).html("한글,영어,숫자 조합가능합니다.<span>("+index+"/14Byte)</span>");
		});
		$("#date").click(function(){
			if(old_month != null && old_year != null){
				return;
			}
			var target = "year";
			var flag = NodeSelector($(this));
			var msg = "년도를";
			if(new Date().getFullYear() - $("select[name='year']").val() > 15 &&
					$("select[name='month']").val() == 'x'){
				target = "month";
				msg = "월을";
			}
			$("select[name='"+target+"']").focus();
			$(flag).attr('class' ,"fail");
			$(flag).html(msg+" 선택해 주세요.");
			
		});
		$("#m_address1,#m_zipcode,#m_address2").click(function(){
			if($("#m_address1").val()!="" && $("#m_zipcode").val()!=""){ 
				return;
			}else if(confirm("주소를 검색하시겠습니까?")){
				daumPostcode();
			}
		});
		$("select").change(function(){
			var self = $(this);
			var name = $(self).attr('name');
			var year = $("select[name='year']");
			var month = $("select[name='month']");
			var date = $("select[name='date']");
			var flag = false;
			var status = "fail";
			var msg ="";
			try{
				flag = new Date().getFullYear() - $(year).val() < 15;
				if(name == 'month' && flag ){
					throw new Error(2);
				}else if(flag){
					throw new Error(1);
				}else if(name == 'date' && $(month).val() == 'x'){
					throw new Error(3);
				}
				getDates([$(year).val(),$(month).val()]);
				status = name == "date"?"success":"stash";
				msg = $(month).val()=='x'?"월을 선택해 주세요."
						:$(date).val()=='x'?"일을 선택해 주세요.":"";
				
			}catch (e) {
				status = "fail";
				msg = /[1]+?/.test(e)?"만 15세 이상만 가입할수 있습니다."
						:/[2]+?/.test(e)?"년도를 확인해 주세요."
								:"월을 먼저 선택해 주세요.";
				
			}finally{
				flag = NodeSelector(self);
				$(flag).attr('class',status);
				$(flag).html(msg);
			}
		});
		function getDates(birth){
			var date = new Date(birth[0],birth[1],0).getDate();
			var optionTag = null;
			if(old_year != birth[0] || old_month != birth[1]){
				optionTag = "<option value='x'>선택</option>";
				for(var i = 1; i<date; i ++){
					var value = String(i);
					value = value.length == 1 ?"0"+value :value;
					optionTag+="<option value='"+value+"'>"+value+"</option>";
				}
				$("#date").html(optionTag);
				old_year = birth[0];
				old_month = birth[1];
			}
		}
		function InputValueCheck(target) {
			$("input[name='" + target + "']").focusout(function() {
				var self = $(this);
				var value = $(self).val();
				var checkMsg = RegularExpression(target, value);
				var flag = NodeSelector(self);
				if (checkMsg != null) {
					$(flag).html(checkMsg);
					$(flag).attr('class', 'fail');
					if(!($(self).attr('name')=='m_password2')){
						$(self).focus();
						focusFail = 1;
					}
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
							: /[^가-힣]/.test(value) ? "한글로만 입력이 가능합니다." : null;
					break;
				case "m_id":
					checkMsg = value.length<4 || value.length>15 ? "최소 4글자 최대 12 글자입니다."
							:/^[0-9]/.test(value) ?"숫자로 시작하실수 없습니다."  
							:/[\W|_].?/.test(value)?"공백,특수문자,한글을 포함할수 없습니다."
									: null;
					break;
				case "m_password":
					checkMsg = value.length<9 || value.length>15? "최소 9글자 최대 15글자 입니다."
							:/[\s].?/.test(value)?"공백을 포함할수 없습니다."
									:/^([a-zA-Z0-9]{1,}[~|!|@|#|$|%|^|&|*]{1,})$/.test(value)?null
											:"영문,숫자,특수문자(~,!,@,#,$,%,^,&,*)를 조합해야합니다.";
					break;
				case "m_password2":
					var checkPassword = $("input[name='m_password']").val();
					checkMsg = value != checkPassword ? "비빌번호가 같지 않습니다." : null; 
					break;
				case "m_nickname":
					checkMsg = index<4 || index>14?"최소 4글자 최대 14글자 입니다."
									:/[^a-zA-Z0-9가-힣]/.test(value)?"공백,자음모음,특수문자를 포함할수 없습니다."
											:null;  
					break;
				case "m_phone":
					checkMsg = /^(^(?:01)[0-9]{1}[-]{1}[0-9]{3,4}[-]{1}[0-9]{4})$/.test(value) ? null
							: "ex)01(0~9)-222~2-2222";
					break;
				case "m_email":
					checkMsg = /^[a-zA-Z]{1}[a-zA-Z0-9|_]{4,12}[@]{1}[a-zA-Z]{4,}[.]{1}(?:(com|kr.co))/.test(value)?null
							:"ex)아이디@주소.(com|kr.co)";
					break;
				case "m_address2":
					checkMsg = value.length != 0 ? null : "필수 입력 사항입니다.";
					break;
			}
			return checkMsg;
		}
	
			
		
		function FinallyCheck(self) {
			var target = $(self).attr('name');
			var value = $(self).val();
			var flag = NodeSelector(self);
			var msg = "";
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
			case "m_password2":
				msg = "비밀번호가 동일합니다.";
				break;
			}
			$(flag).html(msg);
			$(flag).attr('class', 'success');
			focusFail=0;
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
		$("#submit").click(function(){
			var flag = submitCheck($("input"));
			flag = flag? submitCheck($("select")): false;
			if(flag){
				$("form").submit();
			}
		});
		function submitCheck(self){
			for(var index = 0; index<self.length; index++){
				var flag = NodeSelector($(self[index]));
				if($(flag).attr('class') == undefined){
					continue;
				}else if($(flag).attr('class') != 'success'){
					$(flag).attr('class','fail');
					var msg = $(self).prop('tagName') == "SELECT"?"필수 선택란 입니다."
							:"필수입력란 입니다.";
					$(flag).html(msg);
					$(self[index]).focus();
					return false;
				}
			}
			return true;
		}
		function reSet(){
			var input = $("input");
			for(var index = 0; index<input.length; index++){
				$(input[index]).val("");
			}
		}	
		reSet();
});
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