/* Article FructCode.com */
$( document ).ready(function() {
    $("#btn").click(
        function(){
            sendAjaxForm('result_form', 'ajax_form', '/products');
            return false;
        }
    );
});

function sendAjaxForm(result_form, ajax_form, url) {
    $.ajax({
        url:     url, //url страницы (action_ajax_form.php)
        type:     "POST", //метод отправки
        dataType: "html", //формат данных
        data: $("#"+ajax_form).serialize(),  // Сеарилизуем объект
        success: function(response) { //Данные отправлены успешно
            result = $.parseJSON(response);
            $('#result_form').html(result.name+'<br>'+ result.description +'<br>'+ result.createDate +'<br>'+ result.place_storage
                +'<br>'+ result.reserved);
        },
        error: function(response) { // Данные не отправлены
            $('#result_form').html('Ошибка. Данные не отправлены.');
        }
    });
}