<?php
  session_start();
  require "utils/header.php";
  if(isset($_POST['member_id'])){
    $member_id = $_POST['member_id']; 
  }else{
    $member_id = $_SESSION['id'];
  }
  if($member_id == ""){
    header('Location: sudoku.php');
  }else{
    echo "<script type='text/javascript'> var id = '".$member_id."'; </script>";
    $_SESSION['id'] = $member_id;
  }
?>
<!DOCTYPE html>
<html>
<head>
  <title>BrainGames|Hitori</title>
</head>
<body>

  <div id="article">
  <?php

    $hitori_file = fopen("csv/hitori.csv", "r");

    $hitori = array();

    while(!feof($hitori_file))
    {
      array_push($hitori ,fgetcsv($hitori_file));
    }

    $hitori_grid = "<div class = 'grid'>";
    
    for($i = 0; $i < 8; $i++){

      $hitori_grid = $hitori_grid."<div class = 'row row_hitori'>";

      for($j = 0; $j < 8; $j++){

        $val = $hitori[$i][$j];

        $hitori_grid = $hitori_grid."<input type='text' class = 'hitori_input' readonly onclick = 'changecolor(this)' value=".$val." id = ".(8*$i+$j).">";
      
      }

      $hitori_grid = $hitori_grid."</div>";      

    }

    $hitori_grid = $hitori_grid."</div>";

    echo $hitori_grid;

  ?>

  <center><button class="button button_green button_shawdow" onclick="hitori_verify()">Submit</button></center>

  <div id="snackbar">Incorrect Solution. Please Review your Solution</div>
  </div>

  <form action="kakuro.php" method="post" id="submit">
    <input type="hidden" name="member_id" value=<?php echo $member_id ?> />
  </form>

</body>
</html>

<script type="text/javascript" src = "js/script.js"></script>
<script type="text/javascript" src = "js/detect_browser.js"></script>