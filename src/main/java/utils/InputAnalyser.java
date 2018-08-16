/**
 * 
 */
package utils;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

/**
 * @author gbuah
 *
 */
@Component
public class InputAnalyser {
		//return index of all empty spaces
		public ArrayList<Integer> returnAllEmptyIndices(String input) {
			
			char[] userInputArray = input.toCharArray();
			ArrayList<Integer> emptyIndices = new ArrayList<Integer>(); 
			
			for(int i = 0; i<input.length(); i++) {
				if(userInputArray[i] == '+') {
					emptyIndices.add(i);
				}
			}
			
			return emptyIndices;
		}
		
		//return index of all naughts
		public ArrayList<Integer> returnAllNaughtIndices(String input) {
			
			char[] userInputArray = input.toCharArray();
			ArrayList<Integer> naughtIndices = new ArrayList<Integer>(); 
			
			for(int i = 0; i<input.length(); i++) {
				if(userInputArray[i] == 'o' || userInputArray[i] == 'O') {
					naughtIndices.add(i+1);
				}
			}
			
			return naughtIndices;
		}

		//return index of all crosses
		public ArrayList<Integer> returnAllCrossIndices(String input) {
		
		char[] userInputArray = input.toCharArray();
		ArrayList<Integer> crossIndices = new ArrayList<Integer>(); 
		
		for(int i = 0; i<input.length(); i++) {
			if(userInputArray[i] == 'x' || userInputArray[i] == 'X') {
				crossIndices.add(i+1);
			}
		}
		
		return crossIndices;
	}

		//return index of all filled spaces
		public ArrayList<Integer> returnAllFilledIndices(String input) {
					
					char[] userInputArray = input.toCharArray();
					ArrayList<Integer> emptyIndices = new ArrayList<Integer>(); 
					
					for(int i = 0; i<input.length(); i++) {
						if(userInputArray[i] != '+') {
							emptyIndices.add(i);
						}
					}
					
					return emptyIndices;
				}
				
		//check if board is full
		public boolean isBoardFull(String text) {
			boolean response = false;
			char[] userInputArray = text.toCharArray();
			for(int i = 0; i<userInputArray.length; i++) {
				if(userInputArray[i] == '+')
					response = false;
			}
			
			return response;
		}

}

