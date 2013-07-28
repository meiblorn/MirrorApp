<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>IndexControllerTest</title>
    <style type="text/css">
        html, body {
            margin: 0;
            padding: 0;
            height: 100%;
        }

        #header, #footer {
            margin: 2px;
            padding: 2px;
            height: 100px;
            background: #FFEF97;
            border: 5px ridge #8b7e96;
        }

        #main {
            border: 5px ridge #8b7e96;
            position: fixed;
            height: 98%;
            width: 99%;
            margin: 2px;
        }
    </style>
</head>
<body>
<div id="header">
    Event Actions
</div>

<div id="main">
    <div>
        <form:form method="get" name="getEvent" commandName="getEvent">
            <div>
                <div>Get Event</div>
            </div>
            <div>
                <div>ID</div>
                <div><form:input path="id" /></div>
            </div>
            <input type="submit" value="Get">
        </form:form>
    </div>

    <div>
        <form:form method="post" name="putEvent" commandName="putEvent">
            <div>
                <div>Put Event</div>
            </div>
            <div>
                <div>Message</div>
                <div><form:textarea path="message" /></div>
            </div>
            <input type="submit" value="Put">
        </form:form>
    </div>
    <div>
        <form:form method="post" name="removeEvent" commandName="removeEvent">
            <div>
                <div>Remove Event</div>
            </div>
            <div>
                <div>ID</div>
                <div><form:input path="id" /></div>
            </div>
            <input type="submit" value="Remove">
        </form:form>
    </div>
</div>

<div id="footer">
    Grid Dynamics, 2013.
</div>
</body>
</html>