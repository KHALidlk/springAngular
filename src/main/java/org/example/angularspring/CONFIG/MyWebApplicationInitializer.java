package org.example.angularspring.CONFIG;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
import org.example.angularspring.CONFIG.AppConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MyWebApplicationInitializer implements WebApplicationInitializer {


    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // Register the Spring DispatcherServlet
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(AppConfig.class);
        context.register(WebConfig.class); // Add the new WebConfig
        context.setServletContext(servletContext);
        ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
        registration.setLoadOnStartup(1);
        registration.addMapping("/*"); // Changed mapping to handle all requests
    }
}

