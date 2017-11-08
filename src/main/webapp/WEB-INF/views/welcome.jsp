 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
	<head>
				<title>Rollbar Example</title>
				 <style type="text/css">
				    			<%@include file="main.css" %>
				 </style>
				 <script type="text/javascript">
	    			<%@include file="js.js" %>
				 </script>
	</head>
    <body>
         <div class="boxed">
            <img src="rollbarlogo.png" alt="Smiley face" height="42" width="42">
        </div>
        <center>
		        <div class="customBox">
		                <center><h1>Rollbar Java Notifier Example</h1></center><br>
						<form action="/spring-mvc/createException" method="POST">
								<center>
										<input style="height:50px;width:200px" type="submit"  value="Throw an error" />
								</center>
						</form>          
		        </div>
        </center>      
	</body>
</html>