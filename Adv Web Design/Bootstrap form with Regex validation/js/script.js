$(document).ready(function(){
    $('#my-form').submit(function(){
         var error = '';
        
         var fname = $('#fname').val();
         var lname = $('#lname').val();
         var email = $('#email').val();
         var tphone = $('#tphone').val();
         var city = $('#city').val();
         var zip = $('#zip').val();
         
         var fnamePattern = /^[A-Z][a-z]{1,10}$/
         var lnamePattern = /((([A-Z][a-z]{1,2}(\s)?){0,3})|[A-Z]')(([A-Z][a-z]{1,10})|([A-Z][a-z][A-Z][a-z]{1,10}))/g;
         var emailPattern = /^[A-Za-z]{1,20}@[A-Za-z]{2,6}.com$/;
         var tphonePattern = /^((\(?)[0-9]{3}(\))?(-)?)?([0-9]{3}(-)?[0-9]{4})$/;
         var zipPattern = /^([0-9]{4}-)?([0-9]{5})$/;
         var cityPattern = /([A-Z][a-z]{0,20})|([A-Z][a-z]{1,10}\s[A-Z][a-z]{1,10})/g;
         console.log(email);
         console.log("~~~");
         console.log(emailPattern.test(email));
         
         if(!fnamePattern.test(fname)){
             error += "wrong first name\n";
             $('#fnamediv').removeClass("has-success has-feedback");
             $('#fnamediv').addClass("has-error has-feedback");
             $('#fnamediv2').append("Invalid first name");
         }else{
             $('#fnamediv').removeClass("has-error has-feedback");
             $('#fnamediv').addClass("has-success has-feedback");
         }
         
         if(!lnamePattern.test(lname)){
             error += "wrong last name\n";
             $('#lnamediv').removeClass("has-success has-feedback");
             $('#lnamediv').addClass("has-error has-feedback");
             $('#lnamediv2').append("Invalid last name");
         }else{
             $('#lnamediv').removeClass("has-error has-feedback");
             $('#lnamediv').addClass("has-success has-feedback");
         }
         
         if(!emailPattern.test(email)){
             error += "wrong email\n";
             $('#emaildiv').removeClass("has-success has-feedback");
             $('#emaildiv').addClass("has-error has-feedback");
             $('#emaildiv2').append("Invalid email");
         }else{
             $('#emaildiv').removeClass("has-error has-feedback");
             $('#emaildiv').addClass("has-success has-feedback");
         }
         
         if($('#state').val()==""){
             error += "please select a stat\n";
             $('#statediv').removeClass("has-success has-feedback");
             $('#statediv').addClass("has-error has-feedback");
             $('#statediv').append("Invalid state");
         }else{
             $('#statediv').removeClass("has-error has-feedback");
             $('#statediv').addClass("has-success has-feedback");
         }
         
         if(!tphonePattern.test(tphone)){
             error += "wrong telephone\n";
             $('#tphonediv').addClass("has-error has-feedback");
             $('#tphonediv').removeClass("has-success has-feedback");
             $('#tphonediv2').append("Invalid telephone number");
         }else{
             $('#tphonediv').addClass("has-success has-feedback");
             $('#tphonediv').removeClass("has-error has-feedback");
         }
         
         if(!zipPattern.test(zip)){
             error += "wrong zip\n";
             $('#zipdiv').addClass("has-error has-feedback");
             $('#zipdiv').removeClass("has-success has-feedback");
             $('#zipdiv').append("Invalid zip code");
         }else{
             $('#zipdiv').addClass("has-success has-feedback");
             $('#zipdiv').removeClass("has-error has-feedback");
         }
         
         if(!cityPattern.test(city)){
             error += "wrong city\n";
             $('#citydiv').addClass("has-error has-feedback");
             $('#citydiv').addClass("has-success has-feedback");
             $('#citydiv2').append("Invalid city");
         }else{
             $('#citydiv').addClass("has-success has-feedback");
             $('#citydiv').addClass("has-error has-feedback");
         }
         
         var check = $('#check-term').prop('checked');
         //console.log(check);
         if(!check){
             $('#check-term').append("Box not checked");
             alert("Box not checked");
             return false;
         }else{
             
         }
         if(error){
             alert(error);
             return false;
         }
         
    });
    
    $('#modal-submit').click(function(){
        $('#check-term').prop('checked', true);
        
    })
});