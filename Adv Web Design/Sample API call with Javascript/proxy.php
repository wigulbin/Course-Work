<?php
    
    $startDate = $_REQUEST['startdate'];
    $endDate = $_REQUEST['enddate'];
    $favorites = $_REQUEST['favorites'];
    $title = $_REQUEST['title'];
    $limit = $_REQUEST['limit'];
    $sort = $_REQUEST['sort'];
    $sort_desc = $_REQUEST['sort_desc'];
    $body = $_REQUEST['body'];
    
    $response = file_get_contents('http://000.vlcnetworks.net/api/indirect/getposts.html.php?startdate=' . $startDate . '&enddate=' . $endDate . '&favorites=' . $favorites . '&limit=' . $limit . '&sort=' . $sort . '&sort_descending=' . $sort_desc. '&title=' . $title . '&body=' . $body);
    
    print('http://000.vlcnetworks.net/api/indirect/getposts.html.php?startdate=' . $startDate . '&enddate=' . $endDate . '&favorites=' . $favorites . '&limit=' . $limit . '&sort=' . $sort . '&sort_descending=' . $sort_desc . '&title=' . $title . '&body=' . $body);
    
    print($response);
?>