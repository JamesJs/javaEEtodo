<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<%@ include file="../common/header.jspf"  %>
<body>

	<%@ include file="../common/nav.jspf"  %>

	<div class="container">
		<H1>Welcome ${name}</H1>

		
		<table class="table table-striped">
		<caption>Your Todos are</caption>
			<thead>
			<th>Description</th>
			<th>Category</th>
			<th>Actions</th>
			
			
			
			</thead>
			<tbody>
					
					<c:forEach items="${todos}" var="todo">
						<tr>
							<td>${todo.name}</td>
							<td>${todo.category}</td>
							<td>
							<a class="btn btn-danger"
							href="/delete-todo.do?todo=${todo.name}&category=${todo.category}">Delete</a>
							</td>
						</tr>
					</c:forEach>
				
			
			</tbody>
		
		</table>

		<p>
			<font color="red">${errorMessage}</font>
		</p>
		<a class="btn btn-success"
					href="/add-todo.do">Add tudo</a>
	</div>

	<%@ include file="../common/footer.jspf" %>

	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>

</html>