package com.example.hairremoval.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserIdSequenceRepository  extends JpaRepository<String,Integer> {

}
