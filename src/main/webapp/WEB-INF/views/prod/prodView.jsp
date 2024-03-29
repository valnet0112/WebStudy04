<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>	
<h5 class="text-center">상품 상세 조회</h5>
<table class="table table-bordered">
	<tr>
		<th>상품코드</th>
		<td>${prod.prodId}</td>
	</tr>
	<tr>
		<th>상품명</th>
		<td>${prod.prodName}</td>
	</tr>
	<tr>
		<th>분류명</th>
		<td>${prod.lprod.lprodNm}</td>
	</tr>
	<tr>
		<th>제조사</th>
		<td>
			<table class="table table-bordered">
				<thead class="table-dark">
					<tr>
						<th>제조사명</th>
						<th>소재지</th>
						<th>연락처</th>
						<th>담당자</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<c:set var="buyer" value="${prod.buyer }"/>
						<c:url value="/buyer/buyerView.do" var="viewUrl">
							<c:param name="what" value="${buyer.buyerId }" />
						</c:url>
						<td>
							<a href="${viewUrl }">${buyer.buyerName }</a>
						</td>
						<td>${buyer.buyerAdd1 }</td>
						<td>${buyer.buyerComtel }</td>
						<td>${buyer.buyerCharger }</td>
					</tr>
				</tbody>
			</table>
		</td>
	</tr>
	<tr>
		<th>구매가</th>
		<td>${prod.prodCost}</td>
	</tr>
	<tr>
		<th>판매가</th>
		<td>${prod.prodPrice}</td>
	</tr>
	<tr>
		<th>세일가</th>
		<td>${prod.prodSale}</td>
	</tr>
	<tr>
		<th>요약정보</th>
		<td>${prod.prodOutline}</td>
	</tr>
	<tr>
		<th>상세정보</th>
		<td>${prod.prodDetail}</td>
	</tr>
	<tr>
		<th>이미지</th>
		<td>
			<spring:eval expression="@appInfo.prodPath" var="prodPath"/>
			<img src="<c:url value='${prodPath }${prod.prodImg}'/>">
		</td>
	</tr>
	<tr>
		<th>총재고</th>
		<td>${prod.prodTotalstock}</td>
	</tr>
	<tr>
		<th>입고일</th>
		<td>${prod.prodInsdate}</td>
	</tr>
	<tr>
		<th>적정재고</th>
		<td>${prod.prodProperstock}</td>
	</tr>
	<tr>
		<th>크기</th>
		<td>${prod.prodSize}</td>
	</tr>
	<tr>
		<th>색상</th>
		<td>${prod.prodColor}</td>
	</tr>
	<tr>
		<th>배송방법</th>
		<td>${prod.prodDelivery}</td>
	</tr>
	<tr>
		<th>단위</th>
		<td>${prod.prodUnit}</td>
	</tr>
	<tr>
		<th>입고량</th>
		<td>${prod.prodQtyin}</td>
	</tr>
	<tr>
		<th>출고량</th>
		<td>${prod.prodQtysale}</td>
	</tr>
	<tr>
		<th>마일리지</th>
		<td>${prod.prodMileage}</td>
	</tr>
	<tr>
		<td colspan="2">
			<a class="btn btn-primary" data-go-link="/prod/prodList.do">상품목록</a>	
			<a class="btn btn-secondary" href="javascript:;" onclick="history.back();">뒤로가기</a>
			<c:url value="/prod/prodUpdate.do" var="updateUrl">
				<c:param name="what" value="${prod.prodId }" />
			</c:url>
			<a href="${updateUrl }" class="btn btn-success" >상품수정</a>	
		</td>
	</tr>
</table>










