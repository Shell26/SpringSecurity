package ru.shell.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;


public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    //регистрируем конфигурацию HiberConfig в контексте Spring.
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{HibernateConfig.class};
    }

    @Override
    //регистрируем конфигурацию WebConfig в контексте Spring.
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    // чтобы не было проблем с кодировкой при отправки с формы русских символов
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return new Filter[] {characterEncodingFilter};
    }
}
