<div class="container">
    <form class="form-signin" id="form" action="login" method="POST">
        <h2 class="form-signin-heading">Please sign in or sign up</h2>
        <label for="inputLogin" class="sr-only">Login</label>
        <input name="login" value="" type="text" id="username" class="form-control" placeholder="Login" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input name="password" value="" type="password" id="password" class="form-control" placeholder="Password" required pattern="[^]{6,}"
            title="Need more 6 symbols">
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