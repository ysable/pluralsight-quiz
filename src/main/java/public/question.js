$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/question"
    }).then(function(data) {
       $('.question-id').append(data.id);
       $('.question-name').append(data.questionName);
       $('.answer').append(data.correctAnswer);
    });
});