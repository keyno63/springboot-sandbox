package jp.co.who.spring_tutorial.api.filter.config;

import jp.co.who.spring_tutorial.api.filter.filter.HeaderFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean bean = new FilterRegistrationBean(new HeaderFilter());
        return bean;
    }
}
