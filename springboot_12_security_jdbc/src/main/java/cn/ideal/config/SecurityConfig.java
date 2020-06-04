package cn.ideal.config;

import cn.ideal.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

/**
 * @ClassName: SecurityConfig
 * @Description: TODO
 * @Author: BWH_Steven
 * @Date: 2020/5/26 11:49
 * @Version: 1.0
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .anyRequest().authenticated()
//                .and().formLogin();
//                .and().httpBasic();

        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/levelA/**").hasRole("vip1")
                .antMatchers("/levelB/**").hasRole("vip2")
                .antMatchers("/levelC/**").hasRole("vip3")
                .and().formLogin();


//                .usernameParameter("username")
//                .passwordParameter("password")
//                .loginPage("/toLoginPage")
//                .loginProcessingUrl("/login"); // 登陆表单提交请求

//        http.csrf().disable();//关闭csrf功能:跨站请求伪造,默认只能通过post方式提交logout请求
//        http.logout().logoutSuccessUrl("/");
//        //记住我
//        http.rememberMe();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select username,password,roles from student where username = ?")
                .authoritiesByUsernameQuery("select username, roles from student where username = ?")
                .passwordEncoder(new PasswordEncoder() {
                    @Override
                    public String encode(CharSequence rawPassword) {
                        return MD5Util.MD5EncodeUtf8((String) rawPassword);
                    }

                    @Override
                    public boolean matches(CharSequence rawPassword, String encodedPassword) {
                        return encodedPassword.equals(MD5Util.MD5EncodeUtf8((String) rawPassword));
                    }
                });
    }



}
