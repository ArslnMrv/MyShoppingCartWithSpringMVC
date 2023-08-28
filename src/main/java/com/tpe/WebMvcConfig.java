package com.tpe;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan("com.tpe")
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean
    public InternalResourceViewResolver resolver(){  //ViewRoselver bileşeni ayarları configure edilecek; ModelAndView objesi döner
        InternalResourceViewResolver resolver= new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);  //Jsp içindeki tagları kullanmamızı sağlar. JavaStandartTagLibrary
        resolver.setPrefix("/WEB-INF/views/");  //view dosyalarının yeri
        resolver.setSuffix(".jsp");  //view dosyları için format
        return resolver;
    }

    @Override   //static sayfalar için
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
       registry.addResourceHandler("/resources/**").  //bu path altındaki tüm sayfalar static
               addResourceLocations("/resources/").  //kaynakların yeri
               setCachePeriod(0);  //cacheleme istemiyoruz
    }
}
