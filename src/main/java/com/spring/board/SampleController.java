package com.spring.board;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.board.domain.SampleDTO;
import com.spring.board.domain.SampleDTOList;
import com.spring.board.domain.TodoDTO;

import lombok.extern.log4j.Log4j;

@Controller	//클래스의 인스턴스를 스프링의 빈으로 등록, 컨트롤러로 사용 (<component-scan>활용)
@RequestMapping("/sample/*")	//특정 URI에 대한 처리를 해당 컨트롤러나 메서드에서 처리(클래스,메소드 둘다 사용가능)ㄴ
@Log4j
public class SampleController {
	
	@RequestMapping(value="/basic",method= {RequestMethod.GET,RequestMethod.POST})
	public void basicGet() {
		log.info("basic get........");
	}
	
	@GetMapping("/basicOnlyGet")
	public void basicGet2() {
		log.info("basic get only get..........");
	}
	
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		log.info(""+dto);
		return "ex01";
	}
	
	//파라미터 수집 변환
	//@RequestParam - 사용된 변수명과 파라미터의 이름이 다른 경우 유용하게 사용됨
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name,@RequestParam("age") int age) {
		log.info("name : "+name);
		log.info("age : "+age);
		return "ex02";
	}
	
	//리스트, 배열 처리
	//동일한 이름의 파라미터가 여러개 전달되는 경우
	//스프링은 parameter타입을 보고 객체생성 - 인터페이스 X, 실제적인 클래스 타입으로 지정(List<>)
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids")ArrayList<String> ids) {
		log.info("ids : "+ids);
		return"ex02List";
	}
	
	@GetMapping("/ex02Array")
	public String ex02Array(@RequestParam("ids") String[] ids) {
		log.info("array ids : "+Arrays.toString(ids));
		return "ex02Array";
	}
	
	//전달할 데이터가 객체타입이고 여러개를 처리해야할떄
	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleDTOList list) {	
		//파라미터 타입 - SampleDTOList, [index] 형식으로 전달해서 처리
		//자바스크립트 이용시 [ 는 %5B ]는 %5D
		log.info("list dtos : "+list);
		return "ex02Bean";
	}
	
	//binding : 파라미터의 수집
	//@InitBinder 파라미터를 변환해서 처리해야하는 경우
	
//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat,false));
//	}
	
	@GetMapping("/ex03")
	public String ex03(TodoDTO todo) {
		log.info("todo"+todo);
		return "ex03";
	}
	
	
}

