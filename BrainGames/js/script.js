/*Help Toggle Button*/
var clicked = 0;
function displayRules(){
  if(clicked == 0){
    var item = document.getElementById('rules');
    item.style.opacity = 1;
    document.body.style.backgroundColor = 'rgba(2, 130, 255, 1)';
    document.getElementById('help').innerHTML = '&#x2716;';
    document.getElementById('article').style.opacity = 0;
    //document.getElementById('article').style.zIndex = '-1';
    clicked = 1;
  }
  else{
    var item = document.getElementById('rules');
    item.style.opacity = 0;
    document.body.style.backgroundColor = 'white';
    document.getElementById('help').innerHTML = '&#63;';
    document.getElementById('article').style.opacity = 1; 
    clicked = 0;
  }
}

/*save Values */
function saveValue(item){
  var id = item.id;   
  var val = item.value; 
  localStorage.setItem(id, val);
}

function saveBGColor(item){
  var id = item.id;   
  var bg = item.style.backgroundColor;
  localStorage.setItem(id, bg);
}


/*get saved Values*/
function getSavedValue(id){
  if (localStorage.getItem(id) === null) {
      return "";
  }
  return localStorage.getItem(id);
}

function getSavedBGColor(id){
  if (localStorage.getItem(id) === null) {
      return "white";
  }
  return localStorage.getItem(id);
}


/*Change color of Element*/
function changecolor(item){

  if(item.style.backgroundColor != "black"){
    item.style.backgroundColor = "black";
    item.style.color = "white";
  }
  else{
    item.style.backgroundColor = "white";
    item.style.color = "black";
  }

  saveBGColor(item);

}


/*Verify Sudoku*/
function sudoku_verify() {
  var sudoku = [];
  for (var i = 0; i <= 80; i++) {
    sudoku.push(document.getElementById(i).value);  
  }
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
     if(this.responseText == 'verified'){
      var now = new Date().getTime()-startTime;
      var hours = Math.floor((now % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
      var minutes = Math.floor((now % (1000 * 60 * 60)) / (1000 * 60));
      var seconds = Math.floor((now % (1000 * 60)) / 1000);
      xhttp.open("GET", "utils/saveTimeStamp.php?sudokutimeStamp=" + hours + ":"  + minutes + ":" + seconds + "&member_id=" + id, true);
      xhttp.send();
      for (var i = 0; i <= 80; i++) {
        localStorage.removeItem(i);
      }
      snackbar('true');
      setTimeout(function(){ document.getElementById('submit').submit(); }, 3000);
     }else{
      snackbar('false');
     }
    }
  };
  xhttp.open("GET", "utils/verify.php?sudoku=" + sudoku, true);
  xhttp.send();
}

/*Verify Hitori*/
function hitori_verify(){
  var hitori = [];
  for (var i = 0; i <= 63; i++) {
    if(document.getElementById(i).style.backgroundColor == "black")
      hitori.push(i);  
  }

  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
     if(this.responseText == 'verified'){
      var now = new Date().getTime()-startTime;
      var hours = Math.floor((now % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
      var minutes = Math.floor((now % (1000 * 60 * 60)) / (1000 * 60));
      var seconds = Math.floor((now % (1000 * 60)) / 1000);
      xhttp.open("GET", "utils/saveTimeStamp.php?hitoritimeStamp=" + hours + ":"  + minutes + ":" + seconds + "&member_id=" + id, true);
      xhttp.send();
      for (var i = 0; i <= 63; i++) {
        localStorage.removeItem(i);
      }
      snackbar('true');
      setTimeout(function(){ document.getElementById('submit').submit(); }, 3000);
      
     }else{
      snackbar('false');
     }
    }
  };
  xhttp.open("GET", "utils/verify.php?hitori=" + hitori, true);
  xhttp.send();
}

/*Verify Kakuro*/
function kakuro_verify(){
  var kakuro = [];
  for (var i = 0; i <= 47; i++) {
    kakuro.push(document.getElementById(i).value);  
  }
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
     if(this.responseText == 'verified'){
      var now = new Date().getTime()-startTime;
      var hours = Math.floor((now % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
      var minutes = Math.floor((now % (1000 * 60 * 60)) / (1000 * 60));
      var seconds = Math.floor((now % (1000 * 60)) / 1000);
      xhttp.open("GET", "utils/saveTimeStamp.php?kakurotimeStamp=" + hours + ":"  + minutes + ":" + seconds + "&member_id=" + id, true);
      xhttp.send();
      for (var i = 0; i <= 47; i++) {
        localStorage.removeItem(i);
      }
      localStorage.clear();
      snackbar('true');
      setTimeout(function(){ window.location = 'final.html'; }, 3000);
     }else{
      snackbar('false');
     }
    }
  };
  xhttp.open("GET", "utils/verify.php?kakuro=" + kakuro, true);
  xhttp.send();
}

/*Snackbar or Toast*/
function snackbar(status) {
    if(status == 'false'){
      var x = document.getElementById("snackbar")
      x.className = "show";
      setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
    }else{
      var x = document.getElementById("snackbar")
      x.innerHTML = "Solution Accepted";
      x.className = "show";
      setTimeout(function(){ x.className = x.className.replace("show", ""); x.innerHTML = x.innerHTML.replace("Solution Accepted", "Incorrect Solution. Please Review your Solution"); }, 3000);
    }
}

window.onload = function() {
  
  /*Load Saved Data*/
  if(window.location.pathname == '/BrainGames/sudoku.php'){
    for (var i = 0; i <= 80; i++) {
      var item = document.getElementById(i);
      if(item.type == 'number'){
        var val = getSavedValue(i);
        item.value = val;
      }
    }
  }else if(window.location.pathname == '/BrainGames/hitori.php'){
    for (var i = 0; i <= 63; i++) {
      var item = document.getElementById(i);
      var color = getSavedBGColor(i);
      item.style.backgroundColor = color;
      if(color != "black"){
        item.style.color = "black";
      }else{
        item.style.color = "white";
      }
    }
  }else if(window.location.pathname == '/BrainGames/kakuro.php'){
    for (var i = 0; i <= 47; i++) {
      var item = document.getElementById(i);
      if(item.type == 'number')
        item.value = getSavedValue(i);
  }

}

}

/*Timer*/
if(window.location.pathname != '/BrainGames/final.html' && window.location.pathname != '/BrainGames/index.php' && window.location.pathname != '/BrainGames/'){
  
  var startTime = localStorage.getItem('startTime');    // Read from storage.
  if(startTime === null) {                                   // Not stored?
      startTime = new Date().getTime() // Make a new one.
      localStorage.setItem('startTime', startTime);     // Store it.
  }

  // Update the count down every 1 second
  var x = setInterval(function() {

    // Find the distance between now an the count down date
    var now = new Date().getTime()-startTime;

    // Time calculations for days, hours, minutes and seconds
    var hours = Math.floor((now % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
    var minutes = Math.floor((now % (1000 * 60 * 60)) / (1000 * 60));
    var seconds = Math.floor((now % (1000 * 60)) / 1000);
    var milliseconds = Math.floor((now % (1000)));

    // Display the result in the element with id="demo"
    document.getElementById("timer").innerHTML = hours + "h " + minutes + "m " + seconds + "s " + milliseconds + "ms";

    // If the count down is finished, write some text 
  }, 300);

}