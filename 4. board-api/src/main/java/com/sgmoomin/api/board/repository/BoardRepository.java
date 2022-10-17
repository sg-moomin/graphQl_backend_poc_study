package com.sgmoomin.api.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgmoomin.api.board.entity.Board;


public interface BoardRepository extends JpaRepository<Board, String> {

}
