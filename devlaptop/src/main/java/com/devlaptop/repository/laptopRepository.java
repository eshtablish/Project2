package com.devlaptop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.devlaptop.model.laptop;
import com.devlaptop.*;

@Repository
public interface laptopRepository extends JpaRepository<laptop,Integer> {

}