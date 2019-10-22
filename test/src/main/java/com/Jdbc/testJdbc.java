package com.Jdbc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class testJdbc {


	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(TxConfig.class);
		JdbcTemplate jdbcTemplate=applicationContext.getBean(JdbcTemplate.class);
		System.out.println(jdbcTemplate);
	}
}