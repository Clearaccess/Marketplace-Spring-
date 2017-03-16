<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
        <%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
            <%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>

                <jsp:directive.page import="to.User" />
                <jsp:directive.page import="to.Item" />
                <jsp:directive.page import="to.Bid" />
                <jsp:directive.page import="java.util.ArrayList" />
                <jsp:directive.page import="view.entities.ViewItem" />
                <html>

                <head>
                    <title>Items</title>
                    <link rel="stylesheet" href="../css/bootstrap.min.css">
                    <link rel="stylesheet" href="../css/bootstrap-theme.min.css">
                    <link rel="stylesheet" href="../css/showItems.css">
                </head>

                <body>
                    <jsp:directive.include file="toolbar.jsp" />

                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-sm-offset-1 col-sm-11">
                                <form class="form-inline" method="GET" action="search">
                                    <h3 class="form-signin-heading">Search parameters</h3>
                                    <h5 class="form-signin-heading">Keyword:</h5>
                                    <div class="form-group">
                                        <label class="sr-only" for="inputKeyWord">Key word</label>
                                        <input name="keyWord" type="text" class="form-control" id="inputKeyWord" placeholder="Key word">
                                    </div>
                                    <select name="field" class="form-control">
                            <option value="1">UID</option>
                            <option value="2">Title</option>
                            <option value="3">Description</option>
                        </select>
                                    <button type="submit" class="btn btn-primary">Search</button>
                                </form>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12" id="pane">
                                <ul class="nav nav-tabs">
                                    <li role="presentation" class="active panes"><a href="showItems">Show All Items</a></li>
                                    <li role="presentation" class="panes"><a href="showMyItems">Show My Items</a></li>
                                    <li role="presentation" class="panes"><a href="editItem">Sell</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="row"></div>
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="table-responsive">
                                    <table class="table table-hover">
                                        <tbody>
                                            <c:set var="items" scope="request" value="${pageContext.request.getAttribute(" items ")}"/>
                                            <c:forEach var="i" begin="0" end="${items.size()}">
                                                <tr>
                                                    <td class="text-center">
                                                        <c:out value="${items[i].getItemId()}" />
                                                    </td>
                                                    <td class="text-center">
                                                        <c:out value="${items[i].getTitle()}" />
                                                    </td>
                                                    <td class="text-center">
                                                        <c:if test="${items[i].getDescription()!=null}">
                                                            <c:out value="${items[i].getDescription()}" />
                                                        </c:if>
                                                    </td>
                                                    <td class="text-center">
                                                        <c:out value="${items[i].getFullNameSeller()}"/>
                                                    </td>
                                                    <td class="text-center">
                                                        <c:out value="${items[i].getStartPrice()}"/>
                                                    </td>
                                                    <td class="text-center">
                                                        <c:if test="${items[i].getBidIncrement()!=0.0}">
                                                            <c:out value="${items[i].getBidIncrement()}"/>
                                                        </c:if>
                                                    </td>
                                                    <td class="text-center">
                                                        <c:if test="${items[i].getBestOffer()!=0.0}">
                                                            <c:out valur="${items[i].getBestOffer()}" />
                                                        </c:if>
                                                    </td>
                                                    <td class="text-center">
                                                        <c:if test="${items[i].getFullNameBidder()!=null}">
                                                            <c:out value="${items[i].getFullNameBidder()}"/>
                                                        </c:if>
                                                    </td>
                                                    <td class="text-center">
                                                        <c:if test="${!items[i].isBuyItNow()}">
                                                            <c:out value="${items[i].getStopDate()}"/>
                                                        </c:if>
                                                    </td>
                                                    <c:if test="${items[i].isBuyItNow()}">
                                                        <td class="text-center">
                                                            <c:if test="${pageContext.session.getAttribute("user")!=null && ((User)pageContext.session.getAttribute("user")).getUserId()!=items[i].getSellerId()}">
                                                                <jsp:directive.include file="biddingBuy.jsp" />
                                                            </c:if>
                                                        </td>
                                                    </c:if>
                                                    <c:if test="${!items[i].isBuyItNow()}">
                                                        <td class="text-center">
                                                            <c:if test="${pageContext.session.getAttribute("user")!=null && ((User)pageContext.session.getAttribute("user")).getUserId()!=items[i].getSellerId()}">
                                                                <jsp:directive.include file="biddingDoBid.jsp" />
                                                            </c:if>
                                                        </td>
                                                    </c:if>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                        <thead>
                                            <tr class="info">
                                                <th class="text-center">Items</th>
                                                <th/>
                                                <th/>
                                                <th/>
                                                <th/>
                                                <th/>
                                                <th/>
                                                <th/>
                                                <th/>
                                                <th/>
                                            </tr>
                                            <tr>
                                                <th class="text-center">
                                                    UID
                                                </th>
                                                <th class="text-center">
                                                    Title
                                                </th>
                                                <th class="text-center">
                                                    Description
                                                </th>
                                                <th class="text-center">
                                                    Seller
                                                </th>
                                                <th class="text-center">
                                                    Start price
                                                </th>
                                                <th class="text-center">
                                                    Bid inc
                                                </th>
                                                <th class="text-center">
                                                    Best offer
                                                </th>
                                                <th class="text-center">
                                                    Bidder
                                                </th>
                                                <th class="text-center">
                                                    Stop date
                                                </th>
                                                <th class="text-center">
                                                    Bidding
                                                </th>
                                            </tr>
                                        </thead>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <script src="../js/jquery-3.1.1.min.js"></script>
                    <script src="../js/bootstrap.min.js"></script>
                    <script src="../js/showItems/controlMain.js"></script>
                </body>

                </html>