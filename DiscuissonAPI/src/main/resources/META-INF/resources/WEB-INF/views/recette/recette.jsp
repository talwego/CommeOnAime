<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
<title>recette.jsp</title>
<base href="${pageContext.request.contextPath}/">
</head>
<body>
	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th>name:</th>
					<th>vegetarien:</th>
					<th>vegan:</th>
					<th>calorie:</th>
					<th>Debut de la saison:</th>
					<th>Fin de la saison:</th>
					<th>commentaires:</th>
					<th>note:</th>
					<th>Temps de préparation:</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="p" items="${recette}">
				<tr>
					<td>${p.name}</td>
					<td>${p.vegetarien}</td>
					<td>${p.vegan}</td>
					<td>${p.calorie}</td>
					<td>${p.debutSaison}</td>
					<td>${p.finSaison}</td>
					<td>${p.commentaires}</td>
					<td>${p.note}</td>
					<td>${p.tempsDeCuisine}</td>
					<td><a href="recette/edit/${p.id}" class="btn btn-outline-primary">editer</a></td>
					<td><a href="recette/delete/${p.id}" class="btn btn-outline-danger">supprimer</a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="recette/add" class="btn btn-link">nouvel recette</a>
	</div>
</body>
</html>