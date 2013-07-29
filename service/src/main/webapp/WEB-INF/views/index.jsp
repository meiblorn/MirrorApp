<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>IndexControllerTest</title>
</head>
<body>
<div id="header">
    Event Actions
</div>

<div id="main">
    <div id="get-event-form">
        <form:form method="post" action="get" modelAttribute="event">
            <div class="form-row">
                <div class="row-name">Id:</div>
                <div class="row-data"><form:input path="id"/></div>
            </div>
            <div class="form-submit">
                <input type="submit" value="Get event" />
            </div>
        </form:form>
    </div>
    <div id="put-event-form">
        <form:form method="post" action="put" modelAttribute="event">
            <div class="form-row">
                <div class="row-name">Id:</div>
                <div class="row-data"><form:input path="id"/></div>
            </div>
            <div class="form-row">
                <div class="row-name">Message:</div>
                <div class="row-data"><form:textarea path="message"/></div>
            </div>
            <div class="form-submit">
                <input type="submit" value="Put event" />
            </div>
        </form:form>
    </div>
    <div id="remove-event-form">
        <form:form method="post" action="remove" modelAttribute="event">
            <div class="form-row">
                <div class="row-name">Id:</div>
                <div class="row-data"><form:input path="id"/></div>
            </div>
            <div class="form-submit">
                <input type="submit" value="Remove event" />
            </div>
        </form:form>
    </div>
</div>

<div id="footer">
    Grid Dynamics, 2013.
</div>

</body>
</html>