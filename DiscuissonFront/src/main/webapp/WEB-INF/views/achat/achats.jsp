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
<title>achat.jsp</title>
</head>
<body>
	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th>produit</th>
					<th>prix</th>
					<th></th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="obj" items="${produits}">
					<tr>
						<td>${obj.libelle}</td>
						<td>${obj.prix}</td>
						<td><a href="achat/ajouterQuantite/${obj.id}"
							class="btn btn-outline-primary">ajouter</a></td>
						<c:if test="${panier[obj]!=null}">
						<td>${panier[obj]}</td>
						<td><a href="achat/supprimerQuantite/${obj.id}"
							class="btn btn-outline-danger">supprimer</a></td>
						</c:if>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<c:if test="${!panier.isEmpty()}">
			<a href="achat/validerCommande" class="btn btn-outline-warning">valider
				la commande</a>
		</c:if>
	</div>
</body>
</html>