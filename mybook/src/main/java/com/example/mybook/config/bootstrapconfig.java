package com.example.mybook.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class bootstrapconfig implements WebMvcConfigurer {
@Override
public void addResourceHandlers(ResourceHandlerRegistry registry) {
	// TODO Auto-generated method stub
	ResourceHandlerRegistration registration=registry.addResourceHandler("/resource/**");
	registration.addResourceLocations("/resource/");
	 registry.addResourceHandler("/resources/bootstrap/**")
     .addResourceLocations("classpath:/META-INF/resources/webjars/bootstrap/5.0.0/");
	 registry.addResourceHandler("/resources/css/**").addResourceLocations("classpath:/static/css/");
	
	
}
}
