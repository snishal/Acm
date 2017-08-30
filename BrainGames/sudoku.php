<?php
  session_start();
  require "utils/header.php";
  if(isset($_POST['member_id'])){
    $member_id = $_POST['member_id']; 
  }else{
    $member_id = $_SESSION['id'];
  }
  if($member_id == ""){
    header('Location: index.php'); 
  }else{
    echo "<script type='text/javascript'> var id = '".$member_id."'; </script>";
    $conn = mysqli_connect("localhost", "root", "", "braingames");
    $query = "INSERT INTO `game`(`id`) VALUES ('$member_id')";
    mysqli_query($conn, $query);
    mysqli_close($conn);
    $_SESSION['id'] = $member_id;
  }
?>
<!DOCTYPE html>
<html>
<head>
  <title>BrainGames|Sudoku</title>
</head>
<body>

  <div id="article">
  <?php

  	$sudoku_file = fopen("csv/sudoku.csv", "r");

  	$sudoku = array();

  	while(!feof($sudoku_file))
  	{
  		array_push($sudoku ,fgetcsv($sudoku_file));
  	}

    $sudoku_grid = "<div class = 'grid'>";
    for($i = 0, $id = 0; $i < 3; $i++){

      $sudoku_grid = $sudoku_grid."<div class='row row_sudoku'>";

      for ($j=0; $j < 3; $j++) { 
        # code...

        $sudoku_grid = $sudoku_grid."<div class='block'>";

        for ($k=0; $k < 9; $k++) {

          $val = $sudoku[3*$i + (int)($k/3)][3*$j + $k%3];
          if($val == 0)
	         $sudoku_grid = $sudoku_grid."<input class='sudoku_input' type='number' id = ".$id." onkeyup = 'saveValue(this)' />";
	        else{
            $sudoku_grid = $sudoku_grid."<input class='sudoku_input sudoku_text' type='text' readonly value=".$val." id = ".$id.">";
          }
          if($k%3 == 2)
	      	$sudoku_grid = $sudoku_grid."<br/>";

          $id++;

        }

        $sudoku_grid = $sudoku_grid."</div>";       

      }

      $sudoku_grid = $sudoku_grid."</div>";

    }
    $sudoku_grid = $sudoku_grid."</div>";

    echo $sudoku_grid;

  ?>

  <center><button  onclick="sudoku_verify()" class="button button_green button_shawdow">Submit</button></center>

  <div id="snackbar">Incorrect Solution. Please Review your Solution</div>
  </div>

  <form action="hitori.php" method="post" id="submit">
    <input type="hidden" name="member_id" value=<?php echo $member_id ?> />
  </form>

</body>
</html>

<script type="text/javascript" src = "js/script.js"></script>
<script type="text/javascript" src = "js/detect_browser.js"></script>