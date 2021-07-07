package com.cts.app.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.cts.app.model.Trainee;
import com.cts.app.repository.TraineeRepo;

@RestController
@RequestMapping("/trainees")
public class TraineeController {

	
	@Autowired
	private AmazonDynamoDB amazonDynamoDb;
	
	@Autowired
	private TraineeRepo repo;
	
	private DynamoDBMapper dbMapper;
	
	@PostConstruct
	public void init() {
//		dbMapper=new DynamoDBMapper(amazonDynamoDb);
//		CreateTableRequest createTableRequest=dbMapper.generateCreateTableRequest(Trainee.class);
//		createTableRequest.setProvisionedThroughput(new ProvisionedThroughput(1L, 1L));
		// amazonDynamoDb.createTable(createTableRequest);
	}
	
	
	@GetMapping
	public List<Trainee> getAllTrainees(){
		return (List<Trainee>)repo.findAll();
	}
	
	
	
}
