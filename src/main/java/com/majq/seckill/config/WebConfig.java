package com.majq.seckill.config;

import com.majq.seckill.inerceptor.MyLogInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	public static final String OBJECT_MAPPER = "objectMapper";

	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {

	}

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

	}

	@Override
	public void configureAsyncSupport(AsyncSupportConfigurer configurer) {

	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {

	}

	@Override
	public void addFormatters(FormatterRegistry registry) {

	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new MyLogInterceptor()).addPathPatterns(MyLogInterceptor.URL_PATTERN);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {

	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		//registry.addViewController("/index").setViewName("index");
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		//ThymeleafViewResolver resolver = new ThymeleafViewResolver();
		//registry.viewResolver(resolver);
	}

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {

	}

	@Override
	public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> handlers) {

	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

	}

	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {

	}

	@Override
	public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {

	}

	@Override
	public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {

	}

	@Override
	public Validator getValidator() {
		return null;
	}

	@Override
	public MessageCodesResolver getMessageCodesResolver() {
		return null;
	}

}
