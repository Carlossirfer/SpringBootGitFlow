/**
 * 
 */
package com.ciber.springBoot.HolaSpringBoot.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author ciber
 *
 */
//añadiendo un comentario
//comentario para release
@Configuration
@ComponentScan(basePackages = {"com.ciber.springBoot.HolaSpringBoot"})
public class AppConfig {

//    @Bean
//    public InternalResourceViewResolver getInternalResourceViewResolver() {
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("/templates");
//        resolver.setSuffix(".html");
//        return resolver;
//    }
 
}
