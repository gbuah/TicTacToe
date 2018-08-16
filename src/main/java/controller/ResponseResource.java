/**
 * 
 */
package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wave.project.Globals;

import utils.Validate;

/**
 * @author gbuah
 *
 */
@Component
@ComponentScan(basePackageClasses= {Validate.class,Logic.class})
@RestController
@RequestMapping(value = "/tictactoe")
public class ResponseResource {

	@Autowired
	Validate validate;
	@Autowired 
	Logic logic;
	
	
	@GetMapping(value ="/Board/{userInput}")
	public String receiveUserInput(@PathVariable(value = "userInput") String userInput) {
		if(Globals.getStageCounter() != 1 && !validate.checkForLegitimateMove(userInput))
			return "Invalid move!";
		
		else if(Globals.getStageCounter() == 1 && validate.validateAll(userInput)) {
			System.out.println("Counter is 1 and validation passes");
			Globals.setSentString(logic.play(userInput));
			return replace(logic.play(userInput));
		}
		//check if board passes validation
		else if(validate.validateAll(userInput)) {
			Globals.setSentString(logic.play(userInput));
			Globals.setStageCounter(Globals.getStageCounter() + 1);
			return replace(logic.play(userInput));
		}
		
		else 
			return HttpStatus.BAD_REQUEST.getReasonPhrase();
	}
	
	public String replace(String input) {
		return input.replace('+', ' ');
	}
	
}

