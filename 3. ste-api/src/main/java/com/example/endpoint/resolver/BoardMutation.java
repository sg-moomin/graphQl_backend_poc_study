package com.example.endpoint.resolver;

import com.example.endpoint.entity.Board;
import com.example.endpoint.repository.BoardRepositoryImpl;
import com.example.endpoint.service.BoardServiceImpl;

import graphql.kickstart.tools.GraphQLMutationResolver;

public class BoardMutation implements GraphQLMutationResolver{
	
//	private final BoardService boardService;
//	
//	private final BoardRepository boardRepository;
//
//	private Board board;
//	
//	public BoardMutation(BoardService boardService
//			,BoardRepository boardRepository) {
//		this.boardService = boardService;
//		this.boardRepository = boardRepository;
//	}
	
	
	public Board registerBoard(Board board){
		
		return board;
	}
	
	public Board getBoard(Board board) {
		return board;
	}
}
