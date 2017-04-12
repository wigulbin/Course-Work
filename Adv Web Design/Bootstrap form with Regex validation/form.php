<!DOCTYPE html>
<html>
    <head>
        
    </head>
    <body>
        <?php
            $first = $_REQUEST['fname'];
            $last = $_REQUEST['lname'];
            $email = $_REQUEST['email'];
            $tphone = $_REQUEST['tphone'];
            $city = $_REQUEST['city'];
            $state = $_REQUEST['state'];
            $zip = $_REQUEST['zip'];
            
            echo $first."\n";
            echo $last."\n";
            echo $email."\n";
            echo $tphone."\n";
            echo $city."\n";
            echo $state."\n";
            echo $zip."\n";
        ?>
    </body>
</html>
