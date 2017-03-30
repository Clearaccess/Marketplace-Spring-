<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
        <%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
            <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
                <%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

                    <jsp:directive.page import="com.marketplace.spring.models.User" />
                    <jsp:directive.page import="com.marketplace.spring.models.Item" />
                    <jsp:directive.page import="com.marketplace.spring.models.Bid" />
                    <jsp:directive.page import="java.util.ArrayList" />
                    <jsp:directive.page import="com.marketplace.spring.views.entities.ViewItem" />

                    <html xmlns:th="http://www.thymeleaf.org">

                    <head>
                        <tiles:insertAttribute name="header" />
                    </head>

                    <body>
                        <tiles:insertAttribute name="toolbar" />

                        <tiles:insertAttribute name="body" />

                        <tiles:insertAttribute name="script" />
                    </body>

                    </html>