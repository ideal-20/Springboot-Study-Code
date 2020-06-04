//package cn.ideal.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.FilterType;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//
//import javax.sql.DataSource;
//
///**
// * @ClassName: DataSourceConfig
// * @Description: TODO
// * @Author: BWH_Steven
// * @Date: 2020/6/4 10:58
// * @Version: 1.0
// */
//@Configuration
//@ComponentScan(basePackages = "cn.ideal.*", excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)})
//public class DataSourceConfig {
//
//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource ds = new DriverManagerDataSource();
//        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        ds.setUrl("jdbc:mysql://localhost:3306/springboot_security_test?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf-8");
//        ds.setUsername("root");
//        ds.setPassword("root99");
//        return ds;
//    }
//}