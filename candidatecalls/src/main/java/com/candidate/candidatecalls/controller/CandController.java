package com.candidate.candidatecalls.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.candidate.candidatecalls.model.Authentication;
import com.candidate.candidatecalls.model.Candidate;
import com.candidate.candidatecalls.model.Candidatecalls;
import com.candidate.candidatecalls.service.CandidateService;



@Component
@RestController
@RequestMapping("/api/v1")
public class CandidateController {
	
	@Autowired
	private CandidateService candidateservice;

	private static Map<Integer,Candidate> candidates = new HashMap<>();
	
<<<<<<< Updated upstream:candidatecalls/src/main/java/com/candidate/candidatecalls/controller/CandController.java
	
	@GetMapping("/can/{id}")
	public ResponseEntity <Candidate>getCandidate(@PathVariable("id")Integer id,Candidate can) {
		/* can.setId(id); */  
		return new ResponseEntity <Candidate>(canservice.getCand(can,id),HttpStatus.OK);
	}
	
	@GetMapping("/can") 
	  public ResponseEntity<List<Candidate>>getCandidateAll() {
		  return new ResponseEntity<List<Candidate>>(canservice.getAllCan(),HttpStatus.OK);
		  }
	 
	
	@PostMapping(value="/can")
=======
	// get candidate details by id
	@GetMapping("/candidate/{id}")
	public ResponseEntity<Candidate> getCandidate(@PathVariable("id") Integer id, Candidate can) {
		return new ResponseEntity<Candidate>(candidateservice.getCandidate(can, id), HttpStatus.OK);
	}

	// get all candidate details
	@GetMapping("/candidate")
	public ResponseEntity<List<Candidate>> getCandidateAll() {
		return new ResponseEntity<List<Candidate>>(candidateservice.getAllCandidates(), HttpStatus.OK);
	}

	// post candidate details
	@PostMapping(value = "/candidate")
>>>>>>> Stashed changes:candidatecalls/src/main/java/com/candidate/candidatecalls/controller/CandidateController.java
	public ResponseEntity<Integer> saveCan(@RequestBody Candidate can) {
		return new ResponseEntity<>(candidateservice.saveCandidate(can), HttpStatus.OK);
	}
<<<<<<< Updated upstream:candidatecalls/src/main/java/com/candidate/candidatecalls/controller/CandController.java
	
	
	//Candidate call post api
	
	@PostMapping(value="/can/{candidateid}/candidateCall")
	public ResponseEntity<Integer> saveCan(@PathVariable("candidateid")Integer candidateid,@RequestBody Candidatecalls ccal,Candidate can) {
		can = canservice.getCand(can, candidateid);
=======

	// Candidate call post api

	@PostMapping(value = "/candidate/{candidateid}/candidateCall")
	public ResponseEntity<Integer> saveCan(@PathVariable("candidateid") Integer candidateid,
			@RequestBody Candidatecalls ccal, Candidate can) {
		can = candidateservice.getCandidate(can, candidateid);
>>>>>>> Stashed changes:candidatecalls/src/main/java/com/candidate/candidatecalls/controller/CandidateController.java
		ccal.setCandidate(can);

		return new ResponseEntity<>(candidateservice.saveCandidatecalls(ccal), HttpStatus.OK);
	}
<<<<<<< Updated upstream:candidatecalls/src/main/java/com/candidate/candidatecalls/controller/CandController.java
	
	
	//Authentication API
=======

	// Authentication API
	@PostMapping(value = "/candidate/auth")
	public ResponseEntity<Integer> auth(@RequestBody Authentication authentication, Candidate can) {
		List<Candidate> can1 = candidateservice.getAllCandidates();
		authentication.setCandidate(can1);
		return new ResponseEntity<>(
				candidateservice.authenticateUser(authentication.getUserId(), authentication.getPassword()), HttpStatus.OK);
	}

	// Get Individual Candidate Call list by id
	@GetMapping(value = "/candidateCallList/{id}")
	public ResponseEntity<List<Candidatecalls>> callList(@PathVariable("id") Integer id, Candidate can) {
		return new ResponseEntity<List<Candidatecalls>>(candidateservice.getCandidateCallList(can, id), HttpStatus.OK);
	}

	// delete candidate details by id
	@GetMapping(value = "/deleteCandidateById/{id}/")
	public ResponseEntity<Integer> deleteCandidate(@PathVariable("id") Integer id, Candidate can,@RequestBody Candidatecalls ccal) {
		return new ResponseEntity<Integer>(candidateservice.deleteCandidateById(id, can), HttpStatus.OK);
	}

	// update candidate details by id
	@PutMapping(value = "/updateCandidateById/{id}")
	public int updateCan(@RequestBody Candidate can, @PathVariable("id") int id) {
		return candidateservice.updateCandidate(id, can);
	}

	// update candidate calls by id
	@PutMapping(value = "/updateCandidateCallsById/{id}")
	public int updateCCalls(@RequestBody Candidatecalls can, @PathVariable("id") int id) {
		return candidateservice.updateCandidateCall(id, can);
	}
	
>>>>>>> Stashed changes:candidatecalls/src/main/java/com/candidate/candidatecalls/controller/CandidateController.java
	
		@PostMapping(value= "/can/auth")
		public ResponseEntity<Integer> auth(@RequestBody Authentication authentication, Candidate can)
		{
			List<Candidate> can1 = canservice.getAllCan();
			authentication.setCandidate(can1);
			return new ResponseEntity<>(canservice.authenticateUser(authentication.getUserId(),authentication.getPassword()),HttpStatus.OK);
		}
 
}
