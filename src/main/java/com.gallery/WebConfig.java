package com.gallery;

import com.gallery.support.converter.LongTypeIdToEntityConverter;
import com.gallery.support.method.UserMethodArgumentResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewInterceptor;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.WebContentInterceptor;

import javax.persistence.EntityManagerFactory;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: seoilhyun
 * Date: 2015. 2. 24.
 * Time: 오후 1:52
 * To change this template use File | Settings | File Templates.
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Autowired EntityManagerFactory entityManagerFactory;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(longTypeIdToEntityConverter());
    }

    @Bean
    public LongTypeIdToEntityConverter longTypeIdToEntityConverter() {
        return new LongTypeIdToEntityConverter();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(webContentInterceptor());

        InterceptorRegistration openEntityManagerInViewInterceptor = registry.addWebRequestInterceptor(openEntityManagerInViewInterceptor());
        openEntityManagerInViewInterceptor.addPathPatterns("/admin/album/**");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(userMethodArgumentResolver());
    }

    @Bean
    public WebContentInterceptor webContentInterceptor() {
        WebContentInterceptor interceptor = new WebContentInterceptor();
        interceptor.setCacheSeconds(0);

        return interceptor;
    }

    @Bean
    public OpenEntityManagerInViewInterceptor openEntityManagerInViewInterceptor() {
        OpenEntityManagerInViewInterceptor interceptor =  new OpenEntityManagerInViewInterceptor();
        interceptor.setEntityManagerFactory(entityManagerFactory);

        return interceptor;
    }

    @Bean
    public HandlerMethodArgumentResolver userMethodArgumentResolver() {
        return new UserMethodArgumentResolver();
    }

}
