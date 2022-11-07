<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>Ingredient.jsp</title>
</head>
<body>
	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th>calorie</th>
					<th>name</th>
					<th>dateDebutRecolte</th>
					<th>dateFinRecolte</th>
					<th>vegetarien</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="obj" items="${ingredient}">
					<tr>
						<td>${obj.calorie}</td>
						<td>${obj.name}</td>
						<td>${obj.dateDebutRecolte}</td>
						<td>${obj.dateFinRecolte}</td>
						<td>${obj.vegetarien}</td>
						<td>${obj.vegan}</td>
					<td><a href="ingredient/edit/${p.id}" class="btn btn-outline-primary">editer</a></td>
					<td><a href="ingredient/delete/${p.id}" class="btn btn-outline-danger">supprimer</a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="ingredient/add" class="btn btn-link">nouvel recette</a>
	</div>
</body>
</html>