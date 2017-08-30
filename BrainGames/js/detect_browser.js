// Firefox 1.0+
var isFirefox = typeof InstallTrigger !== 'undefined';

if(isFirefox){

	if(window.location.pathname == '/BrainGames/kakuro.php'){
		for(var i = 0; i<=47; i++){
			var ele = document.getElementById(i);
			ele.className += ' kakuro_moz_input';
		}
	}
	else if(window.location.pathname == '/BrainGames/hitori.php'){
		for(var i = 0; i<=63; i++){
			var ele = document.getElementById(i);
			ele.className += ' hitori_moz_input';
		}
	}
	else if(window.location.pathname == '/BrainGames/sudoku.php'){
		for(var i = 0; i<=63; i++){
			var ele = document.getElementById(i);
			if(ele.type == 'number'){
		    	ele.className += ' sudoku_moz_input';
		    }
		}
	}

}