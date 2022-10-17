package com.sgmoomin.api.board.resolver.query;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sgmoomin.api.board.entity.Board;
import com.sgmoomin.api.board.repository.BoardRepository;

import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class BoardQuery implements GraphQLQueryResolver {

	
	private final BoardRepository boardRepository;
	
	private Board board;
	public Board getBoard(Board Board) {
		
		Optional<Board> boardEntity = boardRepository.findById(board.getBoardId());
		return boardEntity.orElseThrow();
		
	}
	
	public List<Board> allGetBoard(Board board){
		List<Board> boardList = new ArrayList<Board>();
		List<Board> returnList = new ArrayList<Board>();
		boardList = boardRepository.findAll();
		for(Board entity : boardList) {
			if(entity.getBoardId().equals(board.getBoardId())) {
				returnList.add(entity);
			}
		}
		
		return returnList;
	}
	
}
