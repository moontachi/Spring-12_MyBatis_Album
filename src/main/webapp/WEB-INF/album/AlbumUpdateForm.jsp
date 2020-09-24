<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<style type="text/css">
	.err{
		font-size: 9pt;
		color: red;
		font-weight: bold;
	}
</style>
WEB-INF\album\AlbumUpdateForm.jsp<br>

<h1>앨범  추가</h1>
<form:form commandName="ab" action="update.ab" method="post">
<input type="hidden" name="num" value="${ ab.num }">
	<p>
		<label>노래제목</label>
		<input type="text" name="title" value="${ ab.title }">
		<form:errors cssClass="err" path="title"/> <br>
	</p>
	
	<p>
		<label>가수명</label>
		<input type="text" name="singer" value="${ ab.singer }">
		<form:errors cssClass="err" path="singer"/> <br>
	</p>
	
	<p>
		<label>가격</label>
		<input type="text" name="price" value="${ ab.price }">
		<form:errors cssClass="err" path="price"/> <br>
	</p>
	
	<p>
		<label>발매일</label>
		<input type="text" name="day" value="${ ab.day }">
		<form:errors cssClass="err" path="day"/> <br>
	</p>

	<p>
		<input type="submit" value="수정하기">
	</p>
</form:form>