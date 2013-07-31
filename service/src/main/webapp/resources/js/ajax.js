$(document).ready(function() {
    function jsonRequest(url, data, success) {
        $.ajax({
            type: "POST",
            url: url,
            data: data ,
            success: success
        });
    }

    function addEvent(id, message) {
        var template = $("<div>").addClass("event").
            append($("<div>").addClass("event-header").
                append($("<div>").addClass("event-id-header")
                    .text(id)
                ).
                append($("<div>").addClass("event-link").
                    append($('<a href="get/'+ id + '">event page&raquo;</a>'))
                )
                .click(function() {
                    $(this).next("div .event-data").slideToggle(500)
                })
        ).
        append($("<div>").addClass("event-data").text(message).hide());

        $("#events").append(template);
    }

    $("#put-event-form input[type=button]").click(function() {
        jsonRequest("put", $("#put-event-form").serialize(), function(response) {
            addEvent(response.id, response.message);
        });
    });
});