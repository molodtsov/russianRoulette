package com.github.molodtsov.russianRoulette.web;

import com.github.molodtsov.russianRoulette.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.github.molodtsov.russianRoulette"})
public class ProdConfiguration extends WebMvcConfigurerAdapter {

    @Bean
    public EntityManagerFactory getEntityManagerFactory(){
        return Persistence.createEntityManagerFactory( "ProdPersistenceUnit");

    }

    @Bean
    public EntityManager getEntityManager(@Autowired EntityManagerFactory emf){
        return emf.createEntityManager();
    }

    @Bean
    public Game getGame() {
        return new Game();
    }
    @Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver("/pages/", ".jsp");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }

    @Bean
    public ViewResolver getRedirectsResolver() {
        UrlBasedViewResolver urlBasedViewResolver = new UrlBasedViewResolver();
        urlBasedViewResolver.setViewClass(JstlView.class);
        return urlBasedViewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/styles/*.css")
                .addResourceLocations("/styles/");
    }

}
