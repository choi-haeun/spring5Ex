package com.spring.board.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class TodoDTO {

	private String title;
	@DateTimeFormat(pattern="yyyy/MM/dd")	//파라미터로 사용되는 인스턴스를 형식이 맞다면 자동으로 날짜로 변환 (@InintBinder은 필요 X)
	private Date dueDate;
}
