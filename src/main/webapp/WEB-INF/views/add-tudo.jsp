<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<%@ include file="../common/header.jspf"  %>

<body>
	<%@ include file="../common/nav.jspf"  %>
	

	<div class="container">
		
		<form method="POST" action="/add-todo.do">
			<fieldset class="form-group">
				<label>New Todo</label> 
				<input class="form-control" name="todo" type="text" /> <br/>
			</fieldset>
			<fieldset class="form-group">
				<label>Category</label> 
				<input class="form-control" name="category" type="text" />	 <br/>
			</fieldset>
			 <input name="add"
				type="submit" class="btn btn-success" value="submit" />
		</form>
		
	</div>

	<%@ include file="../common/footer.jspf" %>

	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>

</html>