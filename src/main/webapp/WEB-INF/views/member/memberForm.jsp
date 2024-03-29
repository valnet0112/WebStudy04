<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<pre>
message = ${message }
member = ${member }
contentPage = <%=request.getAttribute("contentPage")%>, ${contentPage }
errors = ${errors }
</pre>
<form:form method="post" modelAttribute="member" enctype="multipart/form-data">
	<table>
		<tr>	
			<th>프로필</th>
			<td>
				<input type="file" name="memImage" class="form-control" />
				<form:errors path="memImage" cssClass="text-danger"/>
			</td>
		</tr>
		<tr>
			<th>회원아이디</th>
			<td>
				<form:input type="text" path="memId" required="true"
					cssClass="form-control" />
				<form:errors path="memId" cssClass="text-danger" />
			</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td>
				<form:input type="text" path="memPass" required="true"
					cssClass="form-control" />
				<form:errors path="memPass" cssClass="text-danger" />
			</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>
				<form:input type="text" path="memName"
					cssClass="form-control" />
				<form:errors path="memName" cssClass="text-danger" />
			</td>
		</tr>
		<tr>
			<th>주민번호1</th>
			<td>
				<form:input type="text" path="memRegno1"
					cssClass="form-control" />
				<form:errors path="memRegno1" cssClass="text-danger" />
			</td>
		</tr>
		<tr>
			<th>주민번호2</th>
			<td>
				<form:input type="text" path="memRegno2"
					cssClass="form-control" />
				<form:errors path="memRegno2" cssClass="text-danger" />
			</td>
		</tr>
		<tr>
			<th>생일</th>
			<td>
				<form:input type="datetime-local" path="memBir"
					cssClass="form-control" />
				<form:errors path="memBir" cssClass="text-danger" />
			</td>
		</tr>
		<tr>
			<th>우편번호</th>
			<td>
				<form:input type="text" path="memZip" required="true"
					cssClass="form-control" />
				<form:errors path="memZip" cssClass="text-danger" />
			</td>
		</tr>
		<tr>
			<th>주소1</th>
			<td>
				<form:input type="text" path="memAdd1" required="true"
					cssClass="form-control" />
				<form:errors path="memAdd1" cssClass="text-danger" />
			</td>
		</tr>
		<tr>
			<th>주소2</th>
			<td>
				<form:input type="text" path="memAdd2" required="true"
					cssClass="form-control" />
				<form:errors path="memAdd2" cssClass="text-danger" />
			</td>
		</tr>
		<tr>
			<th>집전번</th>
			<td>
				<form:input type="text" path="memHometel"
					cssClass="form-control" />
				<form:errors path="memHometel" cssClass="text-danger" />
			</td>
		</tr>
		<tr>
			<th>회사전번</th>
			<td>
				<form:input type="text" path="memComtel"
					cssClass="form-control" />
				<form:errors path="memComtel" cssClass="text-danger" />
			</td>
		</tr>
		<tr>
			<th>휴대폰</th>
			<td>
				<form:input type="text" path="memHp" required="true"
					cssClass="form-control" />
				<form:errors path="memHp" cssClass="text-danger" />
			</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>
				<form:input type="email" path="memMail"
					cssClass="form-control" />
				<form:errors path="memMail" cssClass="text-danger" />
			</td>
		</tr>
		<tr>
			<th>직업</th>
			<td>
				<form:input type="text" path="memJob"
					cssClass="form-control" />
				<form:errors path="memJob" cssClass="text-danger" />
			</td>
		</tr>
		<tr>
			<th>취미</th>
			<td>
				<form:input type="text" path="memLike"
					cssClass="form-control" />
				<form:errors path="memLike" cssClass="text-danger" />
			</td>
		</tr>
		<tr>
			<th>기념일</th>
			<td>
				<form:input type="text" path="memMemorial"
					cssClass="form-control" />
				<form:errors path="memMemorial" cssClass="text-danger" />
			</td>
		</tr>
		<tr>
			<th>기념일자</th>
			<td>
				<form:input type="date" path="memMemorialday"
					cssClass="form-control" />
				<form:errors path="memMemorialday" cssClass="text-danger" />
			</td>
		</tr>
		<tr>
			<th>마일리지</th>
			<td>1000</td>
		</tr>
		<tr>
			<td colspan="2">
				<button type="submit" class="btn btn-primary">전송</button>
				<button type="reset" class="btn btn-danger">취소</button>
			</td>
		</tr>
	</table>
</form:form>










