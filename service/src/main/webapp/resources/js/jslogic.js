$(document).ready(function() {
    function jsonRequest(url, data, success, error) {
        $.ajax({
            type: "POST",
            url: url,
            data: data ,
            success: success,
            error: error
        });
    }

    function addEvent(id, message) {
        var eventTmpl = $("<div>");
            eventTmpl.addClass("event");
            var eventHeaderTmpl = $("<div>");
                eventHeaderTmpl.addClass("event-header");
                var eventHeaderIdTmpl = $("<div>");
                    eventHeaderIdTmpl.addClass("event-id-header");
                    eventHeaderIdTmpl.text("Event id: " + id);
                    eventHeaderIdTmpl.click(function() {
                        $(this).parent().next("div .event-data").slideToggle(500)
                    });
                var eventHeaderLinkTmpl = $("<div>");
                    eventHeaderLinkTmpl.addClass("event-link");
                    eventHeaderLinkTmpl.append($('<a href="remove/'
                        + id + '">| Remove</a>'));
            var eventDataTmpl = $("<div>");
                eventDataTmpl.addClass("event-data");
                eventDataTmpl.text(message);
                eventDataTmpl.hide();

        eventHeaderTmpl.append(eventHeaderIdTmpl);
        eventHeaderTmpl.append(eventHeaderLinkTmpl);

        eventTmpl.append(eventHeaderTmpl);
        eventTmpl.append(eventDataTmpl);
        $("#events").append(eventTmpl);
    }

    $("#put-event-form input[type=button]").click(function() {
        jsonRequest(
            "put",
            $("#put-event-form").serialize(),
            function(response) {
                addEvent(response.id, response.message);
            }
        )
    });
});