<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<a href="javascript:;" data-go-link="/buyer/buyerInsert.do">신규제조사등록</a>
<table class="table table-bordered">
	<thead>
		<tr>
			<th>일련번호</th>
			<th>제조사명</th>
			<th>분류명</th>
			<th>소재지</th>
			<th>이메일</th>
			<th>연락처</th>
			<th>담당자</th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${not empty buyerList }">
			<c:forEach items="${buyerList }" var="buyer">
				<tr>
					<td>${buyer.rnum }</td>
					<td>
						<c:url value="/buyer/buyerView.do" var="viewUrl">
							<c:param name="what" value="${buyer.buyerId }" />
						</c:url>
						<a href="${viewUrl }">${buyer.buyerName }</a>
					</td>
					<td>${buyer.lprod.lprodNm }</td>
					<td>${buyer.buyerAdd1 }</td>
					<td>${buyer.buyerMail }</td>
					<td>${buyer.buyerComtel }</td>
					<td>${buyer.buyerCharger }</td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${empty prodList }">
			<tr>
				<td colspan="7">제조사 없음.</td>
			</tr>
		</c:if>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="7">
				<form id="searchForm" action="<c:url value='/buyer/buyerList.do'/>" 
						class="border border-danger m-3 p-3">
					<h6>전송UI</h6>
					<input type="number" name="page" />
					<input type="text" name="buyerLgu" value="${condition.buyerLgu }"/>
					<input type="text" name="buyerAdd1"  value="${condition.buyerAdd1 }"/>
					<input type="text" name="buyerName"  value="${condition.buyerName }"/>
				</form>
				<div data-pg-role="searchUI" data-pg-target="#searchForm"  
						class="m-3 p-3 border border-primary row justify-content-center">
					<h6>입력 UI</h6>	
					<div class="col-auto">	
						<select name="buyerLgu" data-pg-init-value="${condition.buyerLgu }">
							<option value>분류선택</option>
							<c:forEach items="${lprodList }" var="lprod">
								<option value="${lprod.lprodGu }">${lprod.lprodNm }</option>
							</c:forEach>
						</select>
					</div>
					<div class="col-auto">
						<input type="text" name="buyerAdd1"  value="${condition.buyerAdd1 }" placeholder="지역"/>
					</div>
					<div class="col-auto">
						<input type="text" name="buyerName"  value="${condition.buyerName }" placeholder="업체명"/>
					</div>
					<div class="col-auto">
						<button data-pg-role="searchBtn">검색</button>
					</div>
				</div>
				${pagingHTML }
			</td>
		</tr>
	</tfoot>
</table>
<script src="<c:url value='/resources/js/app/common/paging.js'/>"></script>
<script>
	let $prodBuyer = $('select[name="prodBuyer"]');
	$('select[name="prodLgu"]').on("change", (event)=>{
		let $prodLgu = $(event.target);
		let selectedLgu = $prodLgu.val();
		$prodBuyer.find("option:gt(0)").each((i,o)=>{
			let $o = $(o);
			let showFlag = (selectedLgu && $o.hasClass(selectedLgu)) || (!selectedLgu);
			$o.toggle(showFlag);
		});
// 		$prodBuyer.find(`option.\${selectedLgu}`).show();
	});
</script>


<!-- 검색조건  : 상품분류코드, 제조사코드, 상품명, 전체(searchType) -->
<!-- 검색단어(searchWord) -->
