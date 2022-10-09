package com.example.endpoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.endpoint.entity.Board;

public interface BoardRepository extends JpaRepository<Board, String> {

}
