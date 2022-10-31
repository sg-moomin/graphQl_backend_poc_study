package com.sgmoomin.api.board.resolver.mutation;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sgmoomin.api.board.entity.Board;
import com.sgmoomin.api.board.repository.BoardRepository;

import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardMutation implements GraphQLMutationResolver{
	
	private final BoardRepository boardRepository;

	private Board board;
	
	public Board registerBoard(Board board){
		System.out.println("resgisterBoardService");
		Board boardSave = boardRepository.save(board.builder()
				.boardId(board.getBoardId())
				.boardName(board.getBoardName())
				.createDate(board.getCreateDate())
				.build()
				);
		return boardSave;
	}
	
	public Board updateBoard(Board board) {
		Board boardEntity = boardRepository.save(board.builder()
				.boardId(board.getBoardId())
				.boardName(board.getBoardName())
				.createDate(board.getCreateDate())
				.build());
		return boardEntity;
	}
	
	public Board deleteBoard(Board board) {
		Optional<Board> boardOpt = boardRepository.findById(board.getBoardId());
		if(boardOpt.isPresent()) {
			boardRepository.delete(board);
		}
	
		return board;
	}
}