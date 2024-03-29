<%@ page import="kr.or.ddit.buyer.controller.BuyerUpdateController" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form method="post" modelAttribute="${BuyerUpdateController.MODELNAME }">
	<form:hidden path="buyerId"/>
	<table class="table table-bordered">
		<tr>
			<th>제조사명</th>
			<td>
				<form:input type="text" path="buyerName" required="true"
					cssClass="form-control" />
				<form:errors path="buyerName" cssClass="text-danger" />
			</td>
		</tr>
		<tr>
			<th>분류코드</th>
			<td>
				<form:select path="buyerLgu" cssClass="form-select" disabled="true">
					<c:forEach items="${lprodList }" var="lprod">
						<form:option value="${lprod.lprodGu }" label="${lprod.lprodNm }" />
					</c:forEach>
				</form:select>
				<form:errors path="buyerLgu" element="span" cssClass="text-danger" />
			</td>
		</tr>
		<tr>
			<th>은행</th>
			<td>
				<form:input type="text" path="buyerBank"
					cssClass="form-control" />
				<form:errors path="buyerBank" cssClass="text-danger" />
			</td>
		</tr>
		<tr>
			<th>계좌번호</th>
			<td>
				<form:input type="text" path="buyerBankno"
					cssClass="form-control" />
				<form:errors path="buyerBankno" cssClass="text-danger" />
			</td>
		</tr>
		<tr>
			<th>계좌주</th>
			<td>
				<form:input type="text" path="buyerBankname"
					cssClass="form-control" />
				<form:errors path="buyerBankname" cssClass="text-danger" />
			</td>
		</tr>
		<tr>
			<th>우편번호</th>
			<td>
				<form:input type="text" path="buyerZip"
					cssClass="form-control" />
				<form:errors path="buyerZip" cssClass="text-danger" />
			</td>
		</tr>
		<tr>
			<th>주소1</th>
			<td>
				<form:input type="text" path="buyerAdd1"
					cssClass="form-control" />
				<form:errors path="buyerAdd1" cssClass="text-danger" />
			</td>
		</tr>
		<tr>
			<th>주소2</th>
			<td>
				<form:input type="text" path="buyerAdd2"
					cssClass="form-control" />
				<form:errors path="buyerAdd2" cssClass="text-danger" />
			</td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td>
				<form:input type="text" path="buyerComtel" required="true"
					cssClass="form-control" />
				<form:errors path="buyerComtel" cssClass="text-danger" />
			</td>
		</tr>
		<tr>
			<th>팩스번호</th>
			<td>
				<form:input type="text" path="buyerFax" required="true"
					cssClass="form-control" />
				<form:errors path="buyerFax" cssClass="text-danger" />
			</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>
				<form:input type="text" path="buyerMail" required="true"
					cssClass="form-control" />
				<form:errors path="buyerMail" cssClass="text-danger" />
			</td>
		</tr>
		<tr>
			<th>담당자</th>
			<td>
				<form:input type="text" path="buyerCharger"
					cssClass="form-control" />
				<form:errors path="buyerCharger" cssClass="text-danger" />
			</td>
		</tr>
		<tr>
			<th>내선번호</th>
			<td>
				<form:input type="text" path="buyerTelext"
					cssClass="form-control" />
				<form:errors path="buyerTelext" cssClass="text-danger" />
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<button type="submit" class="btn btn-primary">전송</button>
				<button type="reset" class="btn btn-danger">취소</button>
				<button type="button" class="btn btn-secondary"
					onclick="history.back();">뒤로가기</button>
			</td>
		</tr>
	</table>
</form:form>

