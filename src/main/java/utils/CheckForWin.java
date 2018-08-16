/**
 * 
 */
package utils;

import org.springframework.stereotype.Component;

import com.wave.project.Globals;

/**
 * @author gbuah
 *
 */
@Component
public class CheckForWin {

	//check if there is a winner
	public boolean isThereAWinner(String text) {
		if(checkRowForWin(text) || checkColumnForWin(text) ||  checkDiagonalForWin(text) ) {
			resetStageCounter();
			return true;
		}
		else	
		return false;
		
	}
	
	//check if there is a win by row
	public boolean checkRowForWin(String text) {
	
		boolean response = false;
		
		char [] rowArray = convertToLowercase(text);
	
		
		if(rowArray[0] == rowArray[1] && rowArray[1] == rowArray[2] && rowArray[0]!='+') {
			Globals.setWinner(rowArray[0]);
			response = true;
		}
			
		
		else if(rowArray[3] == rowArray[4] && rowArray[4] == rowArray[5] && rowArray[3]!='+') {
			Globals.setWinner(rowArray[3]);
			response = true;
		}
		
		else if(rowArray[6] == rowArray[7] && rowArray[7] == rowArray[8] && rowArray[6]!='+') {
			Globals.setWinner(rowArray[6]);
			response = true;
		}
			
		else {
			response = false;
		}
			return response;
	}
	
	//check if there is a win by column
	public boolean checkColumnForWin(String text) {
		
		boolean response = false;
		char [] ColumnArray = convertToLowercase(text);;
		
		if(ColumnArray[0] == ColumnArray[3] && ColumnArray[3] == ColumnArray[6] && ColumnArray[0]!='+') {
			Globals.setWinner(ColumnArray[0]);
			response = true;
		}
		
		else if(ColumnArray[1] == ColumnArray[4] && ColumnArray[4] == ColumnArray[7] && ColumnArray[1]!='+') {
			Globals.setWinner(ColumnArray[1]);
			response = true;
		}
		
		else if(ColumnArray[2] == ColumnArray[5] && ColumnArray[5] == ColumnArray[8] && ColumnArray[2]!='+') {
			Globals.setWinner(ColumnArray[2]);
			response = true;
		}
		
		else {
			response = false;
		}
			return response;
	}
	
	//check if there is a win by diagonal
	public boolean checkDiagonalForWin(String text) {
		
		char [] diagArray = convertToLowercase(text);
		
		if(diagArray[0] == diagArray[4] && diagArray[4] == diagArray[8] && diagArray[0]!='+') {
			Globals.setWinner(diagArray[0]);
			return true;
		}
		
		else if(diagArray[2] == diagArray[4] && diagArray[4] == diagArray[6] && diagArray[2]!='+') {
			Globals.setWinner(diagArray[2]);
			return true;
		}
	
		else
			return false;
	}
	
	//convert string contents to lower case
	public char[] convertToLowercase(String text) {
		
		char [] Array = text.toCharArray();
		for (int i = 0;i<Array.length;i++) {
			Character.toLowerCase(Array[i]);
		}
		
		return Array;
	}
	
	//return who won
	public String whoWon() {
		String response = "cannot find anything";
		if(Globals.getWinner() =='o') {
			response = "\n I won!";
		}
			
		else if(Globals.getWinner() =='x') {
			response = "\n You won!";
		}
			
		return response;
	}
	
	//reset the stage counter
	public void resetStageCounter() {
		Globals.setStageCounter(1);
	}
}
