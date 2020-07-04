package com.mcintech.interest.restcontroller;

import com.mcintech.interest.document.InterestResult;
import com.mcintech.interest.repository.InterestResultRepository;
import com.mcintech.interest.request.InterestCalculatorRequest;
import com.mcintech.interest.service.InterestCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/interest-results")
public class InterestRestController {

	@Autowired
	private InterestResultRepository interestResultRepository;
	@Autowired
	private InterestCalculatorService service;

	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping()
	public BigDecimal calculateInterest(@Valid @RequestBody InterestCalculatorRequest interestCalculatorRequest) {
		return service.calculateInterest(interestCalculatorRequest.getBalance(),
				interestCalculatorRequest.getLowRate(), interestCalculatorRequest.getMedRate(),
				interestCalculatorRequest.getHighRate());
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/all")
	public List<InterestResult> getAll() {
		return interestResultRepository.findAll();
	}
	
}
