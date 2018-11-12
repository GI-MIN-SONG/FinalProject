<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비동기 방식의 통신테스트(AJAX)</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
</head>
<body>

<div id="content"></div>
<p><button id="btn">클릭하세요~!</button></p>

<script type="text/javascript">
	$("#btn").click(function () {
//		alert("버튼클릭");

	// 비동기식 통신을 위한 ajax 호출 코드
	// 현재 페이지의 이동없이 서버와 데이터를 주고받을 수 있습니다.
	// 데이터의 교환에는 일반적으로 JSON 형식의 데이터를 활용합니다.
	
	$.ajax({
		// 호출 방식
		type:"POST",
		// 호출 URL(서버)
		url: "${pageContext.request.contextPath}/ajaxTest",
		// 전달할 데이터 타입
		dataType: "json",
		// 서버에 전달하기 위한 데이터
		data: "{ name : aaa}",
		// 통신이 성공했을 경우 자동 호출되는 이벤트 함수를 지정
		success: function (result) {
			alert(result.msg);
			$("#content").text(result.msg);
		},
		
		error: function(){
			alert("ajax 통신 에러 발생");
		}
	});

	});
</script>

</body>
</html>