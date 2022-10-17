package com.sgmoomin.api.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sgmoomin.api.board.entity.Board;


@RestController
public class boardController {

	@RequestMapping(method = RequestMethod.POST, path = "/")
	public String RestFulTest(@RequestBody Board board) throws Exception{
		return "nulls";
	}
	
}
