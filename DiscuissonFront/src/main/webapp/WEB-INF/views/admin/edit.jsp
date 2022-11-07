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
		<form:form method="post" action="admin"
			modelAttribute="admin">
			<div class="form-group">
				<form:label path="id">id:</form:label>
				<form:input path="id" cssClass="form-control" readonly="true"
					placeHolder="generation automatique" />
			</div>
			<div class="form-group">
				<form:label path="login">login:</form:label>
				<form:input path="login" cssClass="form-control" />
				<form:errors path="login" element="div" cssClass="alert alert-danger"></form:errors>
			</div>
			<div class="form-group">
				<form:label path="password">password:</form:label>
				<form:input path="password" cssClass="form-control" />
				<form:errors path="password">
					<div class="alert alert-danger">*probleme</div>
				</form:errors>
			</div>
			
			<div class="form-group">
				<button type="submit" class="btn btn-outline-primary">enregistrer</button>
				<a href="fournisseur" class="btn btn-outline-warning">annuler</a>
			</div>
		</form:form>
	</div>
</body>
</html>