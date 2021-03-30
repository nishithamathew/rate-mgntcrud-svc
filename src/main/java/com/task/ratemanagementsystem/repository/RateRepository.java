package com.task.ratemanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.ratemanagementsystem.model.RateEntity;

public interface RateRepository extends JpaRepository<RateEntity, Long> {

}
