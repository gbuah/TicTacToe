/**
 * 
 */
package utils;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wave.project.Globals;

/**
 * @author gbuah
 *
 */
@Component
public class Validate {

	 char[] userInputArray;
	 @Autowired
	 InputAnalyser analyser;
	 
	 
	public boolean validateAll(String input) {
		
		if(checkContentValidity(input) && checklengthValidity(input) && checkWhoseTurn(input))
			return true;
		else
			return false;
	}
	
	public boolean checkContentValidity(String input) {
		
		userInputArray = input.toCharArray();
		
		for(int i = 0; i<input.length(); i++) {
			if(userInputArray[i] == 'X' || userInputArray[i] == 'x' || userInputArray[i] == 'o' || userInputArray[i] == 'O' || userInputArray[i] == '+'	) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean checklengthValidity(String input) {
		boolean response = false;
		
		if(input.length() == 9)
			response = true;
		
		return response;
	}
	
	public boolean checkWhoseTurn(String input) {
				
		if(getNumberOfOs(input) - getNumberOfOs(input)==1 || getNumberOfOs(input) == getNumberOfOs(input))
		return true;
		
		else
		return false;
	}
	
	public boolean isBoardFull(String input) {
		
		boolean response = true;
		userInputArray = input.toCharArray();
		
		for(int i = 0; i<input.length(); i++) {
			if(userInputArray[i] == '+') {
				response = false;
			}
		}
		
		return response;
	}
	
	public boolean checkForLegitimateMove(String input) {
		char[] userInputArray = input.toCharArray();
		char[] storedArray = Globals.getSentString().toCharArray();
		ArrayList<Integer> storedResponse = analyser.returnAllFilledIndices(Globals.getSentString());
		char[] checkReceivedArray = new char[storedResponse.size()];
		char[] checkStoredArray = new char[storedResponse.size()];
		for(int i= 0;i<storedResponse.size();i++) {
			checkReceivedArray[i] = userInputArray[storedResponse.get(i)];
			checkStoredArray[i] = storedArray[storedResponse.get(i)];
		}
		
		if(userInputArray.equals(storedArray))
			return true;
		else
		return false;
		
	}
	
	//count number of crosses
	public int getNumberOfOs(String input) {
		int response = 0;
		userInputArray = input.toCharArray();
		
		for(int i = 0; i<input.length(); i++) {
			if(userInputArray[i] == 'o' || userInputArray[i] == 'O') {
				response++;
			}
		}
		return response;
	}
	
	
	//count number of naughts
	public int getNumberOfXs(String input) {
		int response = 0;
		userInputArray = input.toCharArray();
		
		for(int i = 0; i<input.length(); i++) {
			if(userInputArray[i] == 'x' || userInputArray[i] == 'X') {
				response++;
			}
		}
		return response;
	}

}

