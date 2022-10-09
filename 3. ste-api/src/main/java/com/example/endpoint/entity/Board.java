package com.example.endpoint.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board {

	@Id @GeneratedValue
	private String boardId;
	private String boardName;
	private String createDate;
	

}
