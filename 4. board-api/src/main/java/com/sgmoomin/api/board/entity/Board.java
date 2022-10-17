package com.sgmoomin.api.board.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Setter
@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class Board {

	@Id @GeneratedValue
	private String boardId;
	
	private String boardName;
	
	private String createDate;
	

//	@Builder
//	public Board(String boardId, String boardName, String createDate) {
//		this.boardId = boardId;
//		this.boardName = boardName;
//		this.createDate = createDate;
//	}
	
}
