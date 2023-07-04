package com.lgy.spring_mvc_board_std.dto;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BDto {
	private int bid;
	private String bname;
	private String btitle;
	private String bcontent;
	private Timestamp bdate;
	private int bhit;
}





