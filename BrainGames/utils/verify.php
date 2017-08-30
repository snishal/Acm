<?php

	$verified = 1; 

	if(isset($_REQUEST['sudoku'])){

		$sudoku = $_REQUEST['sudoku'];

		$sudoku = explode(",", $sudoku);

		$sudoku_sol_file = fopen("../csv/sudoku_sol.csv", "r");

	  	$sudoku_sol = array();

	  	while(!feof($sudoku_sol_file))
	  	{
	  		array_push($sudoku_sol ,fgetcsv($sudoku_sol_file));
	  	}

	  	for($i = 0, $key = 0; $i < 3; $i++){

	    	for ($j=0; $j < 3; $j++) { 

	        	for ($k=0; $k < 9; $k++) {

					if($sudoku_sol[3*$i + (int)($k/3)][3*$j + $k%3] != $sudoku[$key++]){
						$verified = 0;
						goto j;
					}
	        	};
		 	}
		}
	}else if(isset($_REQUEST['hitori'])){

		$hitori = $_REQUEST['hitori'];

		$hitori = explode(",",$hitori);
		
		$hitori_sol_file = fopen("../csv/hitori_sol.csv", "r");

	  	$hitori_sol = fgetcsv($hitori_sol_file);

	  	if(count($hitori)!=count($hitori_sol)){
	  		$verified = 0;
	  		goto j;
	  	}

	  	$idx = 0;

	  	foreach ($hitori_sol as $key => $value) {
	  		if($hitori[$idx++] != $value){
	  			$verified = 0;
	  			goto j;
	  		}
	  	}
	}else if(isset($_REQUEST['kakuro'])){

		$kakuro = $_REQUEST['kakuro'];

		$kakuro = explode(",",$kakuro);
		
		$kakuro_sol_file = fopen("../csv/kakuro_sol.csv", "r");

	  	$kakuro_sol = fgetcsv($kakuro_sol_file);

	  	$idx = 0;

	  	for($i=0; $i<=47; $i++){
	  		if($kakuro[$i] != $kakuro_sol[$i]){
	  			$verified = 0;
	  			goto j;
	  		}
	  	}

	}

	j: if($verified == 1)
		echo "verified";
	else
		echo "error";

?>