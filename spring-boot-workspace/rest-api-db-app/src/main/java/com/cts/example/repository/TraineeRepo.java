package com.cts.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.example.model.Trainee;

public interface TraineeRepo extends JpaRepository<Trainee, Integer>{

}
