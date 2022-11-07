package message;

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<base href="${pageContext.request.contextPath}/">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
<title>Discuisson</title>
</head>
<body>
	<div class="container">
		<form:form method="post" action="message" modelAttribute="message">
			<div class="form-group">
				<form:label path="id">id:</form:label>
				<form:input path="id" readonly="true" cssClass="form-control"
					placeholder="Auto" />
			</div>
			<div class="form-group">
				<form:label path="date">date:</form:label>
				<form:input path="date" readonly="true" cssClass="form-control"
					placeholder="Auto" />
			</div>
			<div class="form-group">
				<form:label path="sujet">sujet:</form:label>
				<form:input path="sujet" cssClass="form-control" />
				<form:errors path="sujet" cssClass="alert alert-danger small"
					element="div"></form:errors>
			</div>
			<div class="form-group">
				<form:label path="text">text:</form:label>
				<form:input path="text" cssClass="form-control" />			
				<form:errors path="text" cssClass="alert alert-danger small"
					element="div"></form:errors>
			</div>
			<div class="form-group">
				<form:label path="nutritionist">nutritionist:</form:label>
				<form:select cssClass="form-control" path="nutritionist.id" items="${nutritionist}" itemValue="id" itemLabel="infos">
				</form:select>
				<form:errors path="nutritionist"></form:errors>
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-outline-primary">envoyer</button>
				<a href="message" class="btn btn-outline-warning">annuler</a>
			</div>
		</form:form>
	</div>
</body>
</html>