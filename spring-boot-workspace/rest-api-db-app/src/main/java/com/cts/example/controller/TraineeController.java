package com.cts.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.example.model.Trainee;
import com.cts.example.repository.TraineeRepo;

@RestController
@RequestMapping("/trainees")
public class TraineeController {

	@Autowired
	private TraineeRepo repo;
	
	@PostMapping("/")
	public Trainee addTrainee(@RequestBody Trainee trainee) {
		return repo.save(trainee);
	}
	
	
	@GetMapping("/")
	public List<Trainee> getAllTrainees(){
		return repo.findAll();
	}
	
	@GetMapping("/id/{id}")
	public Trainee getTraineeById(@PathVariable int id) {
		return repo.getById(id);
	}
	
}
