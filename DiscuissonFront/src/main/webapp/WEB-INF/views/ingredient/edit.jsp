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
<title>edit.jsp</title>
</head>
<body>
	<div class="container">
		<form:form method="post" action="ingredient"
			modelAttribute="ingredient">
			<div class="form-group">
				<form:label path="id">id:</form:label>
				<form:input path="id" cssClass="form-control" readonly="true"
					placeHolder="generation automatique" />
			</div>
			
			<div class="form-group">
				<form:label path="name">name:</form:label>
				<form:input path="name" cssClass="form-control" />
				<form:errors path="name">
					<div class="alert alert-danger">*probleme</div>
				</form:errors>
			</div>
			<div class="form-group">
				<form:label path="calorie">calorie:</form:label>
				<form:input path="calorie" cssClass="form-control" />
			</div>
			<div class="form-group">
				<form:label path="dateDebutRecolte">dateDebutRecolte:</form:label>
				<form:input path="dateDebutRecolte" cssClass="form-control" />
			</div>
			<div class="form-group">
				<form:label path="dateFinRecolte">dateFinRecolte:</form:label>
				<form:input path="dateFinRecolte" cssClass="form-control" />
			</div>
			<div class="form-group">
				<form:label path="vegetarien">vegetarien:</form:label>
				<form:input path="vegetarien" cssClass="form-control" />
			</div>
			<div class="form-group">
				<form:label path="vegan">vegan:</form:label>
				<form:input path="vegan" cssClass="form-control" />
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-outline-primary">enregistrer</button>
				<a href="fournisseur" class="btn btn-outline-warning">annuler</a>
			</div>
		</form:form>
	</div>
</body>
</html>