<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Events</title>
    <link href="resources/css/style.css" type="text/css" rel="stylesheet">
</head>
<body>
<div id="wrapper">
    <div id="main">
        <div id="put-event-block">
            <form:form id="put-event-form" method="post" action="put" modelAttribute="formEvent">
                <div class="form-row">
                    <div class="row-name">Id:</div>
                    <div class="row-data"><form:input path="id"/></div>
                </div>
                <div class="form-row">
                    <div class="row-name">Message:</div>
                    <div class="row-data"><form:textarea path="message"/></div>
                </div>
                <div class="form-submit">
                    <input type="submit" value="Put event"/>
                </div>
            </form:form>
        </div>
        <c:forEach var="event" items="${eventList}">
            <div id="events">
                <div id="template-event" class="event">
                    <div class="event-header-block">
                        <div class="event-id-header">
                            Event id: ${event.id}
                        </div>
                        <div class="event-remove-block">
                            <a href="remove/${event.id}">| Remove</a>
                        </div>
                    </div>
                    <div class="event-data">
                        ${event.message}
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>