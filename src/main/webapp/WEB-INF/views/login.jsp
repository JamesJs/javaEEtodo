<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<%@ include file="../common/header.jspf"  %>
<body>

	<%@ include file="../common/nav.jspf"  %>

	<div class="container">
		<H1>Welcome ${name}</H1>
			<p><font color="red">${errorMessage}</font></p>
	<form action="/login.do" method="POST">
		Name : <input name="name" type="text" /> Password : <input name="password" type="password" /> <input type="submit" />
	</form>
	</div>

	<%@ include file="../common/footer.jspf" %>

	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>

</html>

