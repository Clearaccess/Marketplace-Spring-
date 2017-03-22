<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %>

    <jsp:directive.page import="com.marketplace.spring.models.Item" />

    <html>

    <head>
        <title>Edit Item</title>
        <link rel="stylesheet" href="resources/css/bootstrap.min.css">
        <link rel="stylesheet" href="resources/css/bootstrap-theme.min.css">
        <link rel="stylesheet" href="resources/css/editItem.css">
    </head>

    <body>
        <jsp:directive.include file="toolbar.jsp" />

        <div class="container">
            <form class="form-horizontal" id="form" action="edit" method="POST">
                <c:if test="${requestScope.item!=null}">
                    ${requestScope.item!=null}

                        <div class="row">
                            <label for="titleOfItem" class="col-sm-2 control-label">Title of item:</label>
                            <div class="col-sm-10">
                                <input name="title" value="${item.getTitle()}" form="form" type="text" class="form-control" id="titleOfItem" placeholder="Title of item"
                                    required autofocus>
                            </div>
                        </div>
                        <div class="row">
                            <label for="description" class="col-sm-2 control-label">Description:</label>
                            <div class="col-sm-10">
                                <c:if test="${item.getDescription()!=null}">
                                    <textarea name="description" value="${item.getDescription()}" form="form" class="form-control" rows="5" id="description"></textarea>
                                </c:if>
                                <c:if test="${item.getDescription()==null}">
                                    <textarea name="description" value="" form="form" class="form-control" rows="5" id="description"></textarea>
                                </c:if>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <label for="startPrice" class="col-sm-2 control-label">Start price: </label>
                            <div class="col-sm-6">
                                <input name="startPrice" form="form" type="number" class="form-control" id="startPrice" placeholder="Start price" min="1"
                                    value="${item.getStartPrice()}" step="${item.getBidIncrement()}" required>
                            </div>
                        </div>
                        <fieldset>
                            <c:if test="${item.isBuyItNow()}">
                                <div class="row">
                                    <label for="bidIncrement" class="col-sm-2 control-label">Bid increment: </label>
                                    <div class="col-sm-6">
                                        <input name="bidIncrement" form="form" type="number" class="form-control" id="bidIncrement" placeholder="Bid increment" min=0.05
                                            value="0.05" step="0.05" required>
                                    </div>
                                </div>
                                <div class="row">
                                    <label for="timeLeft" class="col-sm-2 control-label">Time left: </label>
                                    <div class="col-sm-6">
                                        <input name="time" min=00:00 value="00:00" form="form" type="time" class="form-control" id="timeLeft" placeholder="Time left"
                                            required>
                                    </div>
                                </div>
                            </c:if>

                            <c:if test="${!item.isBuyItNow()}">
                                <div class="row">
                                    <label for="bidIncrement" class="col-sm-2 control-label">Bid increment: </label>
                                    <div class="col-sm-6">
                                        <input name="bidIncrement" form="form" type="number" class="form-control" id="bidIncrement" placeholder="Bid increment" min=0.05
                                            value="${item.getBidIncrement()}" step="0.05" required>
                                    </div>
                                </div>
                                <div class="row">
                                    <label for="timeLeft" class="col-sm-2 control-label">Time left: </label>
                                    <div class="col-sm-6">
                                        <input name="time" min=00:00 value="${item.getTimeLeft()/3600}:${item.getTimeLeft()%3600/60}" form="form" type="time" class="form-control"
                                            id="timeLeft" placeholder="Time left" required>
                                    </div>
                                </div>
                            </c:if>
                        </fieldset>
                    </div>
                    <div class="form-group">
                        <label for="buyItNow" class="col-sm-2 control-label">Buy It Now: </label>
                        <div class="checkbox col-sm-1">
                            <label>
                                <c:if test="${item.isBuyItNow()}">
                                    <input name="buy" form="form" type="checkbox" value="buyItNow" id="buyItNow" checked>
                                </c:if>
                                <c:if test="${!item.isBuyItNow()}">
                                    <input name="buy" form="form" type="checkbox" value="buyItNow" id="buyItNow">
                                </c:if>
                            </label>
                        </div>
                    </div>
                    <input name="itemId" form="form" type="hidden" value="${item.getItemId()}" id="buyItNow">
                </c:if>

                <c:if test="${requestScope.item==null}">
                    <div class="form-group">

                        <div class="row">
                            <label for="titleOfItem" class="col-sm-2 control-label">Title of item:</label>
                            <div class="col-sm-10">
                                <input name="title" value="" form="form" type="text" class="form-control" id="titleOfItem" placeholder="Title of item" required
                                    autofocus>
                            </div>
                        </div>
                        <div class="row">
                            <label for="description" class="col-sm-2 control-label">Description:</label>
                            <div class="col-sm-10">
                                <textarea name="description" value="" form="form" class="form-control" rows="5" id="description"></textarea>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <label for="startPrice" class="col-sm-2 control-label">Start price: </label>
                            <div class="col-sm-6">
                                <input name="startPrice" form="form" type="number" class="form-control" id="startPrice" placeholder="Start price" min="1"
                                    value="1" step="0.05" required>
                            </div>
                        </div>
                        <fieldset>
                            <div class="row">
                                <label for="bidIncrement" class="col-sm-2 control-label">Bid increment: </label>
                                <div class="col-sm-6">
                                    <input name="bidIncrement" form="form" type="number" class="form-control" id="bidIncrement" placeholder="Bid increment" min=0.05
                                        value=0.05 step="0.05" required>
                                </div>
                            </div>
                            <div class="row">
                                <label for="timeLeft" class="col-sm-2 control-label">Time left: </label>
                                <div class="col-sm-6">
                                    <input name="time" min=00:00 value="00:00" form="form" type="time" class="form-control" id="timeLeft" placeholder="Time left"
                                        required>
                                </div>
                            </div>
                        </fieldset>
                    </div>
                    <div class="form-group">
                        <label for="buyItNow" class="col-sm-2 control-label">Buy It Now: </label>
                        <div class="checkbox col-sm-1">
                            <label>
                        <input name="buy" form="form" type="checkbox" value="1" id="buyItNow">
                    </label>
                        </div>
                    </div>
                    <input name="itemId" form="form" type="hidden" value="" id="buyItNow">
                </c:if>

                <div class="form-group">
                    <div class="col-sm-offset-4 col-sm-8">
                        <button type="submit" class="btn btn-primary btn-lg" id="save">Publish/ Save</button>
                        <button type="reset" class="btn btn-primary btn-lg" id="reset">Reset</button>
                    </div>
                </div>
            </form>

        </div>
        <script src="resources/js/jquery-3.1.1.min.js"></script>
        <script src="resources/js/bootstrap.min.js"></script>
        <script src="resources/js/editItem/controlMain.js"></script>
    </body>

    </html>