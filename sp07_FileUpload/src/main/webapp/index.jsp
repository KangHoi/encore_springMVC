<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<!-- 
File Upload 폼 작성 시 유의사항
1) form tag를 사용하자... a 태그는 사용 못함
2) 전송 방식은 반드시 post (method="post"), get방식은 안됨.
	단순한 스트링 값을 넘기는 것이 아니라 MultipartFile 객체를 넘기기 때문이다.
3) form 태그의 옵션 속성으로 action, method말고도 enctype="multipart/form-data" 이부분 반드시 입력한다.
4) MultipartFile (파일 업로드 핵심 라이브러리)를 bean설정문서에 등록한다. 
5) poem.xml dependency 추가.. commons-fileupload
 -->
 
 <!-- C:\encore_kjw\apache-tomcat-8.5.64\webapps\sp07_FileUpload\upload
 		이 경로에 저장되어있다.  -->
<body>
<h2 align="center">Single File Upload Form...</h2>
<form action="fileupload.do" method="post" enctype="multipart/form-data">
	사용자명 : <input type="text" name="userName">
	<input type="file" name="uploadFile">
	<input type="submit" value="파일 업로드">

</form>

</body>
</html>

<!-- 
보통은  index.jsp에서 컨트롤러 작성으로 넘어가는 것이 순서인데
FileUpload 로직은 컨트롤러 작성하기 이전에 VO작성을 먼저 해야한다.
 
VO 작성이란?
MultipartFile에 의해 업로드된 파일의 모든 정보를 담고있는 VO객체를 말한다.
 -->