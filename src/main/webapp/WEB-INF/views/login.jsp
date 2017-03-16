<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>

<html>

<head>
    <title>Page Login</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="../css/login.css">
</head>

<body>
    <div class="container">
        <form class="form-signin" id="form" action="login" method="POST">
            <h2 class="form-signin-heading">Please sign in or sign up</h2>
            <label for="inputLogin" class="sr-only">Login</label>
            <input name="login" value="" type="text" id="username" class="form-control" placeholder="Login" required autofocus>
            <label for="inputPassword" class="sr-only">Password</label>
            <input name="password" value="" type="password" id="password" class="form-control" placeholder="Password" required pattern="[^]{6,}" title="Need more 6 symbols">
            <% if(request.getAttribute("error")!=null) { %>
            <div class="alert alert-danger" role="alert">
              <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
              <span class="sr-only">Error:</span>
              <%= request.getAttribute("error")%>
            </div>
            <% } %>
            <br/>
            <button class="btn btn-lg btn-primary btn-block" id="bLoginSignIn" type="submit">Sign In</button>
            <button class="btn btn-lg btn-primary btn-block" id="bLoginEnterGuest" type="button">Enter as guest</button>
            <button class="btn btn-lg btn-primary btn-block" id="bLoginReg" type="button">Register</button>
        </form>

    </div>
    <script src="../js/jquery-3.1.1.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/redirect.js"></script>
</body>

</html>