<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<table class="table table-bordered text-center">
	<thead>
		<tr>
			<th>일련번호</th>
			<th>회원명</th>
			<th>이메일</th>
			<th>휴대폰</th>
			<th>주소1</th>
			<th>마일리지</th>
		</tr>
	</thead>
	<tbody>
<%-- 		<c:choose> --%>
<%-- 			<c:when test="${not empty memberList }"> --%>
<%-- 				<c:forEach items="${memberList }" var="member"> --%>
<!-- 					<tr> -->
<%-- 						<td>${member.rnum }</td> --%>
<%-- 						<td>${member.memName }</td> --%>
<%-- 						<td>${member.memMail }</td> --%>
<%-- 						<td>${member.memHp }</td> --%>
<%-- 						<td>${member.memAdd1 }</td> --%>
<%-- 						<td>${member.memMileage }</td> --%>
<!-- 					</tr> -->
<%-- 				</c:forEach> --%>
<%-- 			</c:when> --%>
<%-- 			<c:otherwise> --%>
<!-- 				<tr> -->
<!-- 					<td colspan="6">조건에 맞는 회원이 없음.</td> -->
<!-- 				</tr> -->
<%-- 			</c:otherwise> --%>
<%-- 		</c:choose> --%>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="6">
				<form id="submitForm" action="<c:url value='/member/memberList.do'/>" 
						class="border border-danger m-3 p-3">
					<h6>전송UI(Hidden Form)</h6>
					<input type="text" name="page" placeholder="page"/>
					<input type="text" name="searchType" value="${condition.searchType }" placeholder="searchType"/>
					<input type="text" name="searchWord" value="${condition.searchWord }" placeholder="searchWord"/>
				</form>
				<div data-pg-role="searchUI" data-pg-target="#submitForm" 
						class="m-3 p-3 border border-primary row justify-content-center">
					<h6>입력UI</h6>
					<div class="col-auto">
						<select name="paging.simpleCondition.searchType" class="form-select">
							<option value >전체</option>
							<option value="name">이름</option>
							<option value="address">주소</option>
					</div>
					<div class="col-auto">
						<input name="paging.simpleCondition.searchWord" class="form-control"/>
					</div>
					<div class="col-auto">
						<button type="button" data-pg-role="searchBtn" class="btn btn-primary">검색</button>
					</div>
				</div>
				<div id="pagingArea"></div>
			</td>
		</tr>
	</tfoot>
</table>
<script src="<c:url value='/resources/js/app/common/paging.js'/>"></script>
<script src="<c:url value='/resources/js/app/common/paging.js'/>"></script>










