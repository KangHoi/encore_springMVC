<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>	
	<jsp:include page="/header.jsp"/>
	<table>
		<tr>
			<th>모델번호</th>
			<th>모델이름</th>
			<th>가격</th>
			<th>제조사명</th>
			<th>삭제</th>
		</tr>	
		<c:forEach items="${phones}" var="phone">
			<tr>
				<td><a href="detail.do?num=${phone.num}">${phone.num}</a></td>
				<td>${phone.model}</td>
				<td>${phone.price}</td>
				<td>${phone.company.vendor}</td>
				<td><input type="checkbox" data-num="${phone.num}"></td>
			</tr>
		</c:forEach>	
	</table>
	<a href="regPhone.do">추가 등록</a>&nbsp;
	<a href="#" id="selectedDel">선택항목삭제</a>
</body>
<script>
/* JavaScript 1. 
$('#selectedDel').on('click',function(){
		let url = "delete.do?"
		$(":checkbox:checked").each(function(index, item) {
			url+="num="+$(item).attr('data-num')+"&"
		});//each
		location.href=url;
	});//on 
*/

//비동기 작성 2.
$('#selectedDel').click(function() {
	var param="";
	$(":checkbox:checked").each(function(index, item) {
		param = param +"&num="+$(item).attr("data-num");
	});//each
	
	$.ajax({
		type:'get',
		url:'deleteAjax.do',
		data:param,
		
		success:function(data){
			location.reload();
		}
	});//ajax
});//click

</script>

</html>



















