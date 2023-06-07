package com.lgy.spring_mvc_board.dto;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BDto {
//	데이터베이스의 테이블의 컬럼을 프로퍼티로 작성
	private int bid;
	private String bname;
	private String btitle;
	private String bcontent;
	private Timestamp bdate;
	private int bhit;
}



