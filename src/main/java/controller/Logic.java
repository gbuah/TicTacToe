/**
 * 
 */
package controller;

import java.util.ArrayList;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wave.project.Globals;

import utils.CheckForWin;
import utils.InputAnalyser;
import utils.Validate;

/**
 * @author gbuah
 *
 */
@Component
public class Logic {
@Autowired
Validate validate;
@Autowired
CheckForWin checkForWin;
@Autowired
InputAnalyser analyser;

	public String play(String text) {
	
	String response = Globals.getSentString();
	
	//if its the first time and board is already full
	if(Globals.getStageCounter() == 1 && validate.isBoardFull(text)) {
		
		response = text + "\n It's the first play and the board is already full!";
	}
	
	//if board is full 
	else if(validate.isBoardFull(text)) {
		
		if(checkForWin.isThereAWinner(text)) {
			response = text + "\n" + checkForWin.whoWon();
		}
			
		else {
			response = text + "\n It's a tie!"; 
		}
			
	}
	
	//if board is not full
	else if(!validate.isBoardFull(text)) {
		ArrayList<Integer> emptySpaces = new ArrayList<Integer>();
		//check for a winner
		if(checkForWin.isThereAWinner(text)){
			
			response = text + "\n" + checkForWin.whoWon();
		}
			
		else if(!checkForWin.isThereAWinner(text)){
			
			emptySpaces = analyser.returnAllEmptyIndices(text);
			response = fillAnEmptySpot(text, emptySpaces);
		}
			
	}
	return response;
}
	
	
	public String fillAnEmptySpot(String text, ArrayList<Integer> possibleSpots) {
	//choose randomly from available spots	
	Random random = new Random();
	int choice = random.nextInt(possibleSpots.size()) + 1;
	
	//insert an o at this spot
	char[] textArray = text.toCharArray();
	textArray[possibleSpots.get(choice-1)] = 'o';
	
	//return the string
	String response = new String(textArray);
	
	//check if this new string has a win
	if(checkForWin.isThereAWinner(response)) {
		System.out.println("Second Text"+text);
		response += checkForWin.whoWon();
	}
	
	return response;
	
	}
	
}

