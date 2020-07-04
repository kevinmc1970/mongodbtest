package com.mcintech.interest.restcontroller;

import java.math.BigDecimal;
import java.util.List;

import com.mcintech.interest.document.InterestResult;
import com.mcintech.interest.request.InterestCalculatorRequest;
import com.mcintech.interest.service.InterestCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;

import com.mcintech.interest.repository.InterestResultRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/interest-results")
public class InterestRestController {

	@Autowired
	private InterestResultRepository interestResultRepository;
	@Autowired
	private InterestCalculatorService service;

	@PostMapping()
	public BigDecimal calculateInterest(@RequestBody InterestCalculatorRequest interestCalculatorRequest) {
		return service.calculateInterest(interestCalculatorRequest.getBalance(),
				interestCalculatorRequest.getLowRate(), interestCalculatorRequest.getMedRate(),
				interestCalculatorRequest.getHighRate());
	}

	@GetMapping("/all")
	public List<InterestResult> getAll() {
		return interestResultRepository.findAll();
	}
	
}
