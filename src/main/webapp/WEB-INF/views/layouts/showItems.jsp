<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
        <%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
            <%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>

                <jsp:directive.page import="com.marketplace.spring.models.User" />
                <jsp:directive.page import="com.marketplace.spring.models.Item" />
                <jsp:directive.page import="com.marketplace.spring.models.Bid" />
                <jsp:directive.page import="java.util.ArrayList" />
                <jsp:directive.page import="com.marketplace.spring.views.entities.ViewItem" />

                <div class="container-fluid">
                    <div class="row">
                        <div class="col-sm-offset-1 col-sm-11">
                            <form class="form-inline" method="GET" action="search">
                                <h3 class="form-signin-heading">Search parameters</h3>
                                <h5 class="form-signin-heading">Keyword:</h5>
                                <div class="form-group">
                                    <label class="sr-only" for="inputKeyWord">Key word</label>
                                    <input id="inputKeyWord" name="keyWord" type="text" class="form-control" placeholder="Key word">
                                </div>
                                <select id="sSearchField" name="field" class="form-control">
                            <option value="1">UID</option>
                            <option value="2">Title</option>
                            <option value="3">Description</option>
                        </select>
                                <button id="bSearch" type="button" class="btn btn-primary">Search</button>
                                <a class="btn btn-default" href="advancedSearch" role="button">Advanced search</a>
                            </form>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-12" id="pane">
                            <ul class="nav nav-tabs">
                                <li role="presentation" class="active panes"><a href="showItems">Show All Items</a></li>
                                <li role="presentation" class="panes"><a href="showMyItems" disabled>Show My Items</a></li>
                                <li role="presentation" class="panes"><a href="editItem">Sell</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="row"></div>
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="table-responsive">
                                <table class="table table-hover">
                                    <tbody id="tBody">
                                        <!--<c:forEach var="item" items="${items}">
                                            <tr>
                                                <td class="text-center">
                                                    ${item.getItemId()}
                                                </td>
                                                <td class="text-center">
                                                    ${item.getTitle()}
                                                </td>
                                                <td class="text-center">
                                                    <c:if test="${item.getDescription()!=null}">
                                                        ${item.getDescription()}
                                                    </c:if>
                                                </td>
                                                <td class="text-center">
                                                    ${item.getFullNameSeller()}
                                                </td>
                                                <td class="text-center">
                                                    ${item.getStartPrice()}
                                                </td>
                                                <td class="text-center">
                                                    <c:if test="${item.getBidIncrement()!=0.0}">
                                                        ${item.getBidIncrement()}
                                                    </c:if>
                                                </td>
                                                <td class="text-center">
                                                    <c:if test="${item.getBestOffer()!=0.0}">
                                                        ${item.getBestOffer()}
                                                    </c:if>
                                                </td>
                                                <td class="text-center">
                                                    <c:if test="${item.getFullNameBidder()!=null}">
                                                        ${item.getFullNameBidder()}
                                                    </c:if>
                                                </td>
                                                <td class="text-center">
                                                    <c:if test="${!item.isBuyItNow()}">
                                                        ${item.getStopDate()}
                                                    </c:if>
                                                </td>
                                                <c:if test="${item.isBuyItNow()}">
                                                    <td class="text-center">
                                                        <c:if test="${sessionScope.user != null && sessionScope.user.getUserId() != item.getSellerId()}">
                                                            <jsp:directive.include file="biddingBuy.jsp" />
                                                        </c:if>
                                                    </td>
                                                </c:if>
                                                <c:if test="${!item.isBuyItNow()}">
                                                    <td class="text-center">
                                                        <c:if test="${sessionScope.user != null && sessionScope.user.getUserId() != item.getSellerId()}">
                                                            <jsp:directive.include file="biddingDoBid.jsp" />
                                                        </c:if>
                                                    </td>
                                                </c:if>
                                            </tr>
                                        </c:forEach>-->
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