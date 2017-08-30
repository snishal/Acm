<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" type="text/css" href="css/braingames.css">
  <link href="https://fonts.googleapis.com/css?family=Roboto+Slab" rel="stylesheet">
</head>
<body>

  <figure>
    <img src="img/logo.png" height="100" width="100" id="logo1" />
    <figcaption>
	    <h1>DDUC ACM CHAPTER</h1>
	    <h2>Brain Games - Reborn</h2>
    </figcaption>
    <img src="img/braingame.jpg" height="100" width="100" id="logo2"/>
  </figure>

  <div class="util">
    <span>
      <img src="img/timer.png" height="60" width="60" id="timer_img">
      <h2 id="timer"></h2>    
    </span>
    <div id="help" onclick="displayRules()">&#63;</div>
  </div>
  <div class="overlay" id="rules">
    <div class="text">
      <b>RULES</b> <br/>
      <b>SUDOKU:</b><br/>
      ⦁ You can only use numbers from 1-9.<br/>
      ⦁ Each of the nine blocks has to contain all the numbers from 1 to 9 within its squares.<br/>
      ⦁ Each number can only appear once in a row, column or box.<br/>
      <br/>
      <b>HITORI:</b><br/>
      ⦁ No number appears in a row or column more than once (use shaded squares).<br/>
      ⦁ Shaded (black) squares do not touch each other vertically or horizontally.<br/>
      ⦁ Use minimum number of shaded square.<br/>
      ⦁ When completed, all un-shaded (white) squares create a single continuous area.<br/>
      <br/>
      <b>KAKURO:</b><br/>
      ⦁ You can only use numbers from 1-9.<br/>
      ⦁ The object is to fill all empty squares such that the sum of each horizontal block equals the clue on its left, and the sum of each vertical block equals the clue on its top.<br/>
      ⦁ In a single sum, numbers can only be used once.<br/>
    </div>
  </div>

</body>