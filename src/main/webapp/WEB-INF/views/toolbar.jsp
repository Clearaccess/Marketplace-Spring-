<%@ page import="to.User" %>

<nav class="navbar navbar-default navbar-fixed-top">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="#">Online marketplace</a>
                    </div>

                    <div class="collapse navbar-collapse">
                        <form class="navbar-form navbar-right">
                            <p class="navbar-text">You are logged in as: </p>
                            <% if(session.getAttribute("user")!=null){
                                User user=(User)session.getAttribute("user");%>
                                <p class="navbar-text" id="userName">
                                    <%= user.getFullName()%>
                                </p>
                                <div class="form-group">
                                    <button type="submit" class="btn btn-primary navbar-btn" formaction="logout" formmethod="POST">Sign out</button>
                                </div>
                                <%} else {%>
                                    <p class="navbar-text" id="userName">Guest</p>
                                    <div class="form-group">
                                        <button type="submit" class="btn btn-primary navbar-btn" formaction="login" formmethod="GET">Sign in</button>
                                    </div>
                                    <%}%>
                        </form>
                    </div>
                </div>
            </nav>