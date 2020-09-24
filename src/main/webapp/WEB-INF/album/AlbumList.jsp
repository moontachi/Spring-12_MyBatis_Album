<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>   
album\AlbumList.jsp<br>


<table border="1">
	<tr>
		<td>번호</td>
		<td>노래제목</td>
		<td>가수명</td>
		<td>가격</td>
		<td>발매일</td>
		<td>삭제</td>
		<td>수정</td>
	</tr>
	<c:forEach var="i" items="${lists}">
		<tr>
			<td>${i.num }</td>
			<td>${i.title }</td>
			<td>${i.singer }</td>
			<td>${i.price }</td>
			<td>${i.day }</td>
			<td>
				<a href="delete.ab?num=${i.num }">삭제</a>
			</td>
			<td>
				<a href="update.ab?num=${i.num }">수정</a>
			</td>
		</tr>
	</c:forEach>
</table>
<a href="insert.ab">삽입 고고</a>


