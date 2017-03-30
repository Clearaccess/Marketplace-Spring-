<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
        <%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
            <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
                <%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<div class="container">
    <form id="form" class="form-horizontal" th:action="@{/advancedSearch}" th:object="${criteria}" method="POST">
        <div class="form-group">
            <div class="row">
                <label for="itemUID" class="col-sm-2 control-label">Item UID:</label>
                <div class="col-sm-10">
                    <input id="itemUID" name="itemUID" type="number" value="${criteria.getItemUID()}" th:field="*{itemUID}" class="form-control"
                        min=0 step=1 placeholder="Item UID">
                        <sf:errors path="itemUID" />
                </div>
            </div>

            <div class="row">
                <label for="title" class="col-sm-2 control-label">Title:</label>
                <div class="col-sm-10 ">
                    <input id="title" name="title" type="text" value="${criteria.getTitle()}" th:field="*{title}" class="form-control" placeholder="Title">
                </div>
            </div>
            <div class="row">
                <label for="description" class="col-sm-2 control-label">Description:</label>
                <div class="col-sm-10">
                    <input id="description" name="description" type="text" value="${criteria.getDescription()}" th:field="*{description}" class="form-control"
                        placeholder="Description">
                </div>
            </div>
        </div>

        <div class="form-group">
            <div class="row">
                <label for="minPrice" class="col-sm-2 control-label">Min. price: </label>
                <div class="col-sm-4">
                    <input id="minPrice" name="minPrice" type="number" value="${criteria.getMinPrice()}" th:field="*{minPrice}" class="form-control"
                        min="1" step="0.05" placeholder="Min Price">
                </div>
                <label for="maxPrice" class="col-sm-2 control-label">Max. price: </label>
                <div class="col-sm-4 ">
                    <input id="maxPrice" name="maxPrice" type="number" value="${criteria.getMaxPrice()}" th:field="*{maxPrice}" class="form-control"
                        min="1" step="0.05" placeholder="Max price">
                </div>
            </div>
        </div>

        <div class="form-group">
            <div class="row">
                <div class="checkbox col-sm-offset-2 col-sm-10">
                    <input id="onlyBuyItems" name="onlyBuyItems" type="checkbox" th:field="*{onlyBuyItems}" <c:if test="${criteria.getOnlyBuyItems()}"> checked </c:if>>
                    <label>Show Only Buy It Now Items</label>
                </div>
            </div>
        </div>

        <div class="form-group">
            <div class="row">
                <label for="startDate" class="col-sm-2 control-label">Start date:</label>
                <div class="col-sm-10">
                    <input id="startDate" name="startDate" type="datetime-local" value="${criteria.getStartDateHtml5DateTimeLocale()}" th:field="*{startDate}"
                        class="form-control" placeholder="Start Date">
                        <!--<input id="startDate" name="startDate" type="text" value="2010-02-30T11:00" th:field="*{startDate}" class="form-control" placeholder="Start Date">-->
                </div>
            </div>
            <div class="row">
                <label for="expireDate" class="col-sm-2 control-label">Expire date:</label>
                <div class="col-sm-10">
                    <input id="expireDate" name="expireDate" type="datetime-local" value="${criteria.getExpireDateHtml5DateTimeLocale()}" th:field="*{expireDate}"
                        class="form-control" placeholder="Expire Date">
                </div>
            </div>
        </div>

        <div class="form-group">
            <div class="row">
                <label for="bidderCount" class="col-sm-2 control-label">Bidder count:</label>
                <div class="col-sm-10">
                    <input id="bidderCount" name="bidderCount" type="number" value="${criteria.getBidderCount()}" th:field="*{bidderCount}" class="form-control"
                        min=0 step=1 placeholder="Bidder Count">
                </div>
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-4 col-sm-8">
                <button type="submit" class="btn btn-primary btn-lg" id="search" name="action" value="searchAdvanced">Search</button>
                <button type="submit" class="btn btn-primary btn-lg" id="clearSearch" formnovalidate name="action" value="clearSearchAdvanced">Clear Search</button>
            </div>
        </div>
    </form>
</div>