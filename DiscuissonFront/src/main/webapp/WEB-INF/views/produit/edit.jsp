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
		<form:form method="post" action="produit" modelAttribute="produit">
			<input type="hidden" name="query" value="save">
			<div class="form-group">
				<form:label path="id">id</form:label>
				<form:input path="id" readonly="true" placeholder="generation auto" />
			</div>
			<div class="form-group">
				<form:label path="libelle">libelle:</form:label>
				<form:input path="libelle" cssClass="form-control" />
				<form:errors path="libelle" element="div"
					cssClass="alert alert-danger"></form:errors>
			</div>
			<div class="form-group">
				<form:label path="prix">prix:</form:label>
				<form:input path="prix" cssClass="form-control" type="number"
					step="0.1" />
				<form:errors path="prix" element="div" cssClass="alert alert-danger"></form:errors>
			</div>
			<div class="form-group">
				<form:label path="fournisseur">fournisseur:</form:label>
				<form:select cssClass="form-control" path="fournisseur.id"
					items="${fournisseurs}" itemValue="id" itemLabel="infos">
				</form:select>
				<form:errors path="fournisseur" element="div"
					cssClass="alert alert-danger"></form:errors>
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-outline-primary">enregistrer</button>
				<a href="produit" class="btn btn-outline-warning">annuler</a>
			</div>
		</form:form>
	</div>
</body>
</html>