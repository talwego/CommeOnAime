<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<base href="${pageContext.request.contextPath}/">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
<title>validerPanier.jsp</title>
</head>
<body>
	<div class="container">
		<form:form method="post" action="achat" modelAttribute="user">
			<div class="form-group">
				<form:label path="id">client:</form:label>
				<form:select cssClass="form-control" path="id"
					items="${clients}" itemValue="id" itemLabel="infos">
				</form:select>
			</div>
			<div class="form-group">
				<a href="achat/nouveauClient" class="btn btn-outline-warning">nouveau client</a>
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-outline-primary">enregistrer</button>
			</div>
		</form:form>
	</div>
</body>
</html>