<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<div id="content">
	
	<table width="800" cellspacing="0" cellPadding="0" id="listTable">
		<thead>
		<tr>
			<td width="400">Skip name</td>
			<td>Location</td>
			<td>Is full</td>
			<td>type</td>
			<td>Skip status</td>
			<td>capacity</td>
			<td>current capacity</td>
			<td>Operation</td>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${datas.datas }" var="s">
			<tr>
				<td>>${s.name }</td>
				<td>${s.location}</td>
				<td>
					<c:if test="${s.full eq 0 }">Not full</c:if>
					<c:if test="${s.full eq 1 }">full</c:if>
				</td>
				<td>
					<c:if test="${s.type eq 0 }">General waste</c:if>
					<c:if test="${s.type eq 1 }">Construction waste</c:if>
				</td>
				<td>
					<c:if test="${s.status eq 0 }">Unused</c:if>
					<c:if test="${s.status eq 1 }">Using</c:if>
				</td>
				<td>${s.capacity}</td>
				<td>${s.currentCapacity}</td>
				
				
				<td>
					Delete,Update
				
				</td>
			</tr>
		</c:forEach>
		</tbody>
		<tfoot>
		<tr>
			<td colspan="6" style="text-align:right;margin-right:10px;">
			<jsp:include page="/jsp/pager.jsp">
				<jsp:param value="${datas.total }" name="totalRecord"/>
				<jsp:param value="audits" name="url"/>
			</jsp:include>
			</td>
		</tr>
		</tfoot>
	</table>
</div>
</body>
</html>