$(document).ready(function () {
    
    $('#getposts_form').submit(function (event) {
        event.preventDefault();
        
        // clear out our output areas first!
        $('#output').empty();
        $('#erros').empty();

        var startDate = $('#startdate').val();
        var endDate = $('#enddate').val();
        var favorites = $('#favorites').val();
        var titles = $('#title').val();
        var limit = $('#limit').val();
        var sort = $('#sort').val();
        var sort_desc = $("#sort-desc").val();
        var body = $("#body").val();
        
        var datePattern = /^(((0[1-9])|(1[0-2]))(\/)(((0[1-9])|([1-2][0-9]))|(3[0-1]))(\/)(20[0-2][0-9]))$/;
        
        if(datePattern.test(startDate) && datePattern.test(endDate)){
            $("#errors").html("");
            $("#ajaxIndicator").modal('show');
        $.ajax({
           url: 'proxy.php',
           data: {
             startdate: startDate,
             enddate: endDate,
             favorites: favorites,
             title: titles,
             limit: limit,
             sort: sort,
             sort_desc: sort_desc,
             body: body
           },
           type: 'GET',
           dataType: 'HTML',
           success: function(serverResponse){
               console.log(serverResponse);
               $('#output').append(serverResponse);
               
               
           },
           error: function(jqXHR, textStatus, error){
               $('#errors').append(error);
                console.log(jqXHR);
               
           },
           complete: function(){
               $('#ajaxIndicator').modal('hide');
           }
        });
        }else{
            $("#errors").append("Invalid start or end date");
        }
        
        // ***** TODO: VALIDATE STARTDATE AND ENDDATE; DISPLAY VALIDATION ERRORS IN "ERRORS" DIV
        
        
        // make the ajax request
        
       
        // let the user know something is happening in the meantime

       
    });
    
});
