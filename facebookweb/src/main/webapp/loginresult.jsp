<%
int i=(int)request.getAttribute("result");
String email=request.getAttribute("email").toString();
if(i>0){%>
	<p>Welcome <%= email %>!</p><br><br>
	<a href=viewProfileServlet>view profile</a>
	<a href=editProfileServlet>edit profile</a>
	<a href=SearchProfileServlet>search profile</a>
	<a href=DeleteProfileServlet>delete profile</a>
    <a href=viewAllProfileServlet>view all profile</a>
<%}

else{%>
	<p>"Invalid login id and/or password")</p>
	<a href=login.html>Login again</a>
<%} %>
