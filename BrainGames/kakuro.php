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
  }

?>
<!DOCTYPE html>
<html>
<head>
  <title>BrainGames|Kakuro</title>
</head>
<body>

  <div id="article">
  <?php

    $kakuro_file = fopen("csv/kakuro.csv", "r");

    $kakuro = array();

    while(!feof($kakuro_file))
    {
      array_push($kakuro ,fgetcsv($kakuro_file));
    }

    $kakuro_grid = "<div class = 'grid'>";
    
    for($i = 0, $id=0; $i < 10; $i++){

      $kakuro_grid = $kakuro_grid."<div class = 'row row_kakuro'>";

      for($j = 0; $j < 10; $j++){

        $val = $kakuro[$i][$j];

        if($val == -1){
          $kakuro_grid = $kakuro_grid."<div class='empty_block'></div>";
        }elseif($val == 0 && strlen($val) == 1){
          $kakuro_grid = $kakuro_grid."<input class = 'kakuro_input' type='number' id = ".$id++." onkeyup = 'saveValue(this)' />";
        }else{
          $val = explode(" ", $val);
            if($j == 0 || $i == 9){
              $kakuro_grid = $kakuro_grid."<div class='kakuro_div'>
                                            <div class='line1'></div>
                                            <span class='top_right'>".$val[0]."</span>
                                          </div>";  
            }
            elseif($i == 0 || $j == 9){
             $kakuro_grid = $kakuro_grid."<div class='kakuro_div'>
                                            <div class='line1'></div>
                                            <span class='bottom_left'>".$val[0]."</span>
                                          </div>";   
            }else{
              $count = count($val);
              foreach ($val as $key => $value) {
                  # code...
                  if($value == 0)
                    $val[$key] = "";
              }
                $kakuro_grid = $kakuro_grid."<div class='kakuro_div'>
                                            <div class='line1'></div>
                                            <div class='line2'></div>
                                            <span class='mid_left'>".$val[0]."</span>
                                            <span class='mid_top'>".$val[1]."</span>
                                            <span class='mid_right'>".$val[2]."</span>
                                            <span class='mid_bottom'>".$val[3]."</span>
                                          </div>";   
            }
        }
      }

      $kakuro_grid = $kakuro_grid."</div>";      

    }

    $kakuro_grid = $kakuro_grid."</div>";

    echo $kakuro_grid;

  ?>

  <center><button class="button button_green button_shawdow" onclick="kakuro_verify()">Submit</button></center>

  <div id="snackbar">Incorrect Solution. Please Review your Solution</div>
  </div>
</body>
</html>

<script type="text/javascript" src = "js/script.js"></script>
<script type="text/javascript" src = "js/detect_browser.js"></script>