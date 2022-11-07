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
		<form:form method="post" action="recette" modelAttribute="recette">
			<input type="hidden" name="query" value="save">
			<div class="form-group">
				<form:label path="id">id</form:label>
				<form:input path="id" readonly="true" placeholder="generation auto" />
			
				<div class="form-group">
				<form:label path="name">name:</form:label>
				<form:input path="name" cssClass="form-control" />
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
				<form:label path="calorie">calorie:</form:label>
				<form:input path="calorie" cssClass="form-control" />
				
			</div>
			<div class="form-group">
				<form:label path="debutSaison">debutSaison:</form:label>
				<form:input path="debutSaison" cssClass="form-control"/>
			</div>
			<div class="form-group">
				<form:label path="finSaison">finSaison:</form:label>
				<form:input path="finSaison" cssClass="form-control"/>
			</div>
			<div class="form-group">
				<form:label path="commentaires">commentaires:</form:label>
				<form:input path="commentaires" cssClass="form-control"/>
			</div>
			<div class="form-group">
				<form:label path="note">note:</form:label>
				<form:input path="note" cssClass="form-control"/>
			</div>
			<div class="form-group">
				<form:label path="tempsDeCuisine">tempsDeCuisine:</form:label>
				<form:input path="tempsDeCuisine" cssClass="form-control"/>
			</div>
			
			
			<div class="form-group">
				<button type="submit" class="btn btn-outline-primary">enregistrer</button>
				<a href="recette" class="btn btn-outline-warning">annuler</a>
			</div>
		</form:form>
	</div>
</body>
</html>