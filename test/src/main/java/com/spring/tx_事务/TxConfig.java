package com.spring.tx_事务;


import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
* 声明式事务
 * EnableTransactionManagement开启事务
 * 环境搭建
 * 1.导入依赖
*/
@Configuration
@EnableTransactionManagement
public class TxConfig {
}