<?php
  
  $conn = mysqli_connect("localhost", "root", "", "braingames");
  $member_id = $_GET['member_id'];
  if(isset($_GET['sudokutimeStamp'])){
  	$time = $_GET['sudokutimeStamp'];
  	$query = "Update `game` set `sudoku_time` = '$time' where id = '$member_id'";
  }else if(isset($_GET['hitoritimeStamp'])){
  	$time = $_GET['hitoritimeStamp'];
  	$query = "Update `game` set `hitori_time` = '$time' where id = '$member_id'";
  }else if(isset($_GET['kakurotimeStamp'])){
    $time = $_GET['kakurotimeStamp'];
    $query = "Update `game` set `kakuro_time` = '$time' where id = '$member_id'";
  }
  mysqli_query($conn, $query);
  mysqli_close($conn);

?>