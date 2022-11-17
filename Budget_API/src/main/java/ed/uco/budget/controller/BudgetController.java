package ed.uco.budget.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.uco.budget.crosscutting.execption.BudgetCustomException;
import edu.uco.budget.domain.BudgetDTO;
import edu.uco.budget.service.command.CreateBudgetCommand;
import edu.uco.budget.service.command.implementation.CreateBudgetCommandImpl;
import edu.uco.budget.service.usecase.budget.;

@RestController
@RequestMapping("/api/budget")
public class BudgetController {
	
	private CreateBudgetCommand createBudgetCommand = new CreateBudgetCommandImpl();
	
	@GetMapping("/dummy")
	public BudgetDTO hola() {
		return new BudgetDTO();
	}
	
	@PostMapping
	public ResponseEntity<Response<BudgetDTO>> create(@RequestBody BudgetDTO budget) {

		final Response<BudgetDTO> response = new Response<>();
		HttpStatus httpStatus = HttpStatus.OK;
		
		try {
			createBudgetCommand.execute(budget);
			List<BudgetDTO> data =new ArrayList<>();
			data.add(budget);
			response.setData(data);
			
			response.addSuccessMessage("");
		} catch (final BudgetCustomException exception) {
			
			httpStatus=HttpStatus.BAD_REQUEST;
			
			if(exception.isTechinalException()) {
				response.addSuccessMessage("");
			}else {
				response.addErrorMessage(exception.getMessage());
			}
			
			System.err.println();
		}catch (final Exception exception) {
			httpStatus
			response.addFatalMessage("");
		}
		return new ResponseEntity<BudgetDTO>(response, httpStatus);
	}
	
	

}
