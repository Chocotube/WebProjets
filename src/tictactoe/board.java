package tictactoe;

public class board {
	boolean turn;
	String[] game;
	boolean start;    
    
    public board() {
    	turn = true;
    	game = new String[9];
    	for(int i = 0; i < 9 ; ++i) {
    		game[i] = " ";
    	}
    }
    
    public boolean getTurn() {
    	return turn; 
    }
    
    public boolean getStart() {
    	return start;
    }
    
    public String getStatus(){
    	String status = "tie";
    	
    	if(game[0] == game[1] && game[0] == game[2] && game[0] !=  " ")
    		status = game[0];
    	else if(game[3] == game[4] && game[3] == game[5] && game[3] !=  " ")
    		status = game[3];
    	else if(game[6] == game[7] && game[6] == game[8] && game[6] !=  " ")
    		status = game[6];
    	
    	else if(game[0] == game[3] && game[0] == game[6] && game[0] !=  " ")
    		status = game[0];
    	else if(game[1] == game[4] && game[1] == game[7] && game[1] !=  " ")
    		status = game[1];
    	else if(game[2] == game[5] && game[2] == game[8] && game[2] !=  " ")
    		status = game[2];
    	
    	else if(game[0] == game[4] && game[0] == game[8] && game[0] !=  " ")
    		status = game[0];
	    else if(game[2] == game[4] && game[2] == game[6] && game[2] !=  " ")
	    	status = game[2];
    	
	    else {
	    	for(int i = 0; i < 9 ; ++i) {
	    		if(game[i] == " ") {
	    			status = "not_tie";
	    		}	
	    	}
	    }    	
    	return status;
    }
    
    public String[] getBoard() {
    	String gameboard[] = new String[9];
    	int i = 0;
    	while(i < 9)
    	{
    		if(game[i] == " ")
    			gameboard[i] = "<div class=\"row align-items-center justify-content-center\"><a href='playcontroller?move="+i+"'>-</a></div>";
    		else if(game[i] == "O")
    			gameboard[i] = "<div class=\"row align-items-center justify-content-center\"><span style='color:blue'>O</span></div>";
    		else if(game[i] == "X")
    			gameboard[i] = "<div class=\"row align-items-center justify-content-center\"><span style='color:red'>X</span></div>";
    		++i;
    	}
    	
    	return gameboard;
    }
    
    public void setNew(String param)
    {
    	if (param!= null) 
    	{
    		turn = true;
    		int i = 0;
    		while( i < 9) {
    			game[i] = " ";
    			++i;
    		}	
    	}
    }
    
    public void setMove(int casse) {
    	if(game[casse] ==  " ")
    	{
    		if(turn) {
    			
    			game[casse] = "O";
    		}
    		else {
    			game[casse] = "X";
    		}
    		turn = !turn;
    	}
    }
    
}
