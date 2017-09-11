package org.superbiz.moviefun;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.context.embedded.ServletRegistrationBean;


@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean(ActionServlet actionServlet){
        return new ServletRegistrationBean(actionServlet, "/moviefun/*");
    }
}