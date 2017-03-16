<!DOCTYPE html>
<html>

<head>
    <title>Registration</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="../css/registration.css">
</head>

<body>
    <div class="container">
        <form class="form-horizontal" id="form" action="register" method="POST">
            <div class="form-group">
                <label for="fullName" class="col-sm-2 control-label">Full Name:</label>
                <div class="col-sm-10">
                    <input name="fullName" value="" type="text" class="form-control" id="fullName" placeholder="Full name" required autofocus>
                </div>
            </div>
            <div class="form-group">
                <label for="billingAddress" class="col-sm-2 control-label">Billing address:</label>
                <div class="col-sm-10">
                    <input name="billingAddress" value="" type="text" class="form-control" id="billingAddress" placeholder="Billing address" required>
                </div>
            </div>
            <div class="form-group">
                <label for="inputLogin" class="col-sm-2 control-label">Login: </label>
                <div class="col-sm-10">
                    <input name="login" value="" type="text" class="form-control" id="login" placeholder="Login" required>
                </div>  
            </div>
            <div class="form-group">
                <label for="inputPassword" class="col-sm-2 control-label">Password: </label>
                <div class="col-sm-10">
                    <input name="password" value="" type="password" class="form-control" id="password" placeholder="Password" required>
                </div>
            </div>
            <div class="form-group">
                <label for="rePassword" class="col-sm-2 control-label">Re-enter Password: </label>
                <div class="col-sm-10">
                    <input name="rePassword" value="" type="password" class="form-control" id="rePassword" placeholder="Re-enter password" required>
                </div>
            </div>
            <% if(request.getAttribute("error")!=null) { %>
                        <div class="alert alert-danger col-sm-offset-2" role="alert">
                          <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                          <span class="sr-only">Error:</span>
                          <%= request.getAttribute("error")%>
                        </div>
                        <br/>
                        <% } %>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-primary btn-lg" id="bReg">Registration</button>
                    <button type="reset" class="btn btn-primary btn-lg" id="bReset">Reset</button>
                </div>
            </div>
        </form>

    </div>
    <script src="../js/jquery-3.1.1.min.js"></script>
    <script src="../js/jquery.validate.min.js"></script>
    <script src="../js/additional-methods.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/registration/validate.js"></script>
    <script src="../js/redirect.js"></script>
</body>

</html>