<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>   
<form:form method="post" modelAttribute="prod" enctype="multipart/form-data">
<table class="table table-bordered">
		<tr>
			<th>상품명</th>
			<td>
				<form:input path="prodName" class="form-control" />
				<form:errors path="prodName" element="span" cssClass="text-danger"/>
			</td>
		</tr>
		<tr>
			<th>분류코드</th>
			<td>
				<form:select path="prodLgu">
					<form:option value="" label="분류선택" />
					<c:forEach items="${lprodList }" var="lprod">
						<form:option value="${lprod.lprodGu }" label="${lprod.lprodNm }" />
					</c:forEach>
				</form:select>
				<form:errors path="prodLgu" element="span" cssClass="text-danger" />
			</td>
		</tr>
		<tr>
			<th>제조사코드</th>
			<td>
				<form:select path="prodBuyer">
					<form:option value="" label="제조사선택" />
					<c:forEach items="${buyerList }" var="buyer">
						<form:option value="${buyer.buyerId }" cssClass="${buyer.buyerLgu }" label="${buyer.buyerName }" />
					</c:forEach>
				</form:select>
				<form:errors path="prodBuyer" element="span" cssClass="text-danger" />
			</td>
		</tr>
		<tr>
			<th>구매가</th>
			<td>
				<form:input type="number" path="prodCost" class="form-control" />
				<form:errors path="prodCost" element="span" cssClass="text-danger" />
			</td>
		</tr>
		<tr>
			<th>판매가</th>
			<td>
				<form:input type="number" path="prodPrice" class="form-control" />
				<form:errors path="prodPrice" element="span" cssClass="text-danger" />
			</td>
		</tr>
		<tr>
			<th>세일가</th>
			<td>
				<form:input type="number" path="prodSale" class="form-control" />
				<form:errors path="prodSale" element="span" cssClass="text-danger" />
			</td>
		</tr>
		<tr>
			<th>요약정보</th>
			<td>
				<form:input path="prodOutline" class="form-control" />
				<form:errors path="prodOutline" element="span" cssClass="text-danger" />
			</td>
		</tr>
		<tr>
			<th>상세정보</th>
			<td>
				<form:textarea path="prodDetail" class="form-control" />
				<form:errors path="prodDetail" element="span" cssClass="text-danger" />
			</td>
		</tr>
		<tr>
			<th>이미지</th>
			<td>
				<form:input type="file" path="prodImage" class="form-control" />
				<form:errors path="prodImage" element="span" cssClass="text-danger" />
			</td>
		</tr>
		<tr>
			<th>총재고</th>
			<td>
				<form:input type="number" path="prodTotalstock" class="form-control" />
				<form:errors path="prodTotalstock" element="span" cssClass="text-danger" />
			</td>
		</tr>
		<tr>
			<th>적정재고</th>
			<td>
				<form:input type="number" path="prodProperstock" class="form-control" />
				<form:errors path="prodProperstock" element="span" cssClass="text-danger" />
			</td>
		</tr>
		<tr>
			<th>크기</th>
			<td>
				<form:input path="prodSize" class="form-control" />
				<form:errors path="prodSize" element="span" cssClass="text-danger" />
			</td>
		</tr>
		<tr>
			<th>색상</th>
			<td>
				<form:input path="prodColor" class="form-control" />
				<form:errors path="prodColor" element="span" cssClass="text-danger" />
			</td>
		</tr>
		<tr>
			<th>배송방법</th>
			<td>
				<form:input path="prodDelivery" class="form-control" />
				<form:errors path="prodDelivery" element="span" cssClass="text-danger" />
			</td>
		</tr>
		<tr>
			<th>단위</th>
			<td>
				<form:input path="prodUnit" class="form-control" />
				<form:errors path="prodUnit" element="span" cssClass="text-danger" />
			</td>
		</tr>
		<tr>
			<th>입고량</th>
			<td>
				<form:input type="number" path="prodQtyin" class="form-control" />
				<form:errors path="prodQtyin" element="span" cssClass="text-danger" />
			</td>
		</tr>
		<tr>
			<th>출고량</th>
			<td>
				<form:input type="number" path="prodQtysale" class="form-control" />
				<form:errors path="prodQtysale" element="span" cssClass="text-danger" />
			</td>
		</tr>
		<tr>
			<th>마일리지</th>
			<td>
				<form:input type="number" path="prodMileage" class="form-control" />
				<form:errors path="prodMileage" element="span" cssClass="text-danger" />
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<button type="submit" class="btn btn-primary">전송</button>
				<button type="reset" class="btn btn-danger">취소</button>
			</td>
		</tr>
	</table>
</form:form>
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
	}).trigger("change");
</script>
		


