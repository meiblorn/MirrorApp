<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>IndexControllerTest</title>
    <link href="resources/css/style.css" type="text/css" rel="stylesheet">
    <script src="http://code.jquery.com/jquery-2.0.3.min.js" type="text/javascript"></script>
    <script src="resources/js/ajax.js" type="text/javascript"></script>
</head>
<body>
<div id="wrapper">
    <div id="main">
        <div id="put-event-block">
            <form:form id="put-event-form" method="post" action="put" modelAttribute="event">
                <div class="form-row">
                    <div class="row-name">Id:</div>
                    <div class="row-data"><form:input path="id"/></div>
                </div>
                <div class="form-row">
                    <div class="row-name">Message:</div>
                    <div class="row-data"><form:textarea path="message"/></div>
                </div>
                <div class="form-submit">
                    <input type="button" value="Put event"/>
                </div>
            </form:form>
        </div>
        <div id="events"></div>
    </div>
</div>
</body>
</html>