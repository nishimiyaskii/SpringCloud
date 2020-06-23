package com.aimerrhythms.springcloud.eurekaserver1.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().
                //只开启eureka账号密码登陆
                antMatchers("/actuator/**").permitAll().
                //其他请求全放过
                anyRequest().authenticated().
                //关闭跨域请求保护：security提供的
                and().csrf().disable()
                //只开启基本账号密码校验
                .httpBasic();
//        super.configure(http);
    }
}
