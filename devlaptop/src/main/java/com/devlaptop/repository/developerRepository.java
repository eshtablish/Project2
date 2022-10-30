package com.devlaptop.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.devlaptop.model.developer;
import com.devlaptop.*;

public interface developerRepository extends JpaRepository<developer,Integer> {

}