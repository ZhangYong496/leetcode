package com.example.demo.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author alexzhang
 */
@Configuration
public class WebAppConfigurer implements WebMvcConfigurer {

    @Bean
    public FilterRegistrationBean filterRegister() {
        FilterRegistrationBean frBean = new FilterRegistrationBean();
        frBean.setFilter(new UserDefinedFilter());
        frBean.addUrlPatterns("/*");
        return frBean;
    }

}
