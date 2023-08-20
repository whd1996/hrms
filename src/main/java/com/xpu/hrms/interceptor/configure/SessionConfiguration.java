package com.xpu.hrms.interceptor.configure;

import com.xpu.hrms.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.ArrayList;
import java.util.List;



@Configuration
public class SessionConfiguration implements WebMvcConfigurer {
	@Autowired
	private LoginInterceptor loginInterceptor;

	@Override
    public void addInterceptors(InterceptorRegistry registry) {
		//List<String> addPathList = null;
		List<String> excludePathList = null;
		// 登录拦截器
		InterceptorRegistration login = registry
				.addInterceptor(this.loginInterceptor);
		// 设置拦截的路径
		login.addPathPatterns("/*/*");
		// 设置例外的路径
		excludePathList = new ArrayList<>();
		excludePathList.add("/user/login");
        excludePathList.add("/api");
		excludePathList.add("/user/regist");
		excludePathList.add("/user/foundPwd");
		excludePathList.add("/user/logout");
		//excludePathList.add("/user/listUserRole");//测试用
		excludePathList.add("/user/addUser");
		excludePathList.add("/css/**");
		excludePathList.add("/images/**");
		excludePathList.add("/plugins/**");
		excludePathList.add("/js/**");
		excludePathList.add("/data/**");
		login.excludePathPatterns(excludePathList);
    }
	
	@Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/static/");
        viewResolver.setSuffix(".html");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
		registry.addResourceHandler("/static/js/**").addResourceLocations("classpath:/static/js/");
		registry.addResourceHandler("/static/css/**").addResourceLocations("classpath:/static/css/");
		registry.addResourceHandler("/static/data/**").addResourceLocations("classpath:/static/data/");
		registry.addResourceHandler("/static/images/**").addResourceLocations("classpath:/static/images/");
		registry.addResourceHandler("/static/plugins/**").addResourceLocations("classpath:/static/plugins/");

		System.out.println("---------------------------");
		WebMvcConfigurer.super.addResourceHandlers(registry);
	}

}
