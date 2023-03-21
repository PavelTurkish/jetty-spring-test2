

package com.foo.jetty;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.ee10.webapp.WebAppContext;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;


public class JettySpringTest2 {

    private static String WAR_PATH = "/home/pavel/Temp/jetty-spring-test1/target/jetty-spring-test1-1.0.0.war";

    public static void main(String[] args) throws Exception {
        JpmsUtils.printEnvironment(false);
        Server server = new Server( 8080 );
        server.setDumpAfterStart(false);
        server.start();

        WebAppContext webAppContext = new WebAppContext();
        webAppContext.setClassLoader(JettySpringTest2.class.getClassLoader());
        webAppContext.setContextPath( "/" );
        webAppContext.setWar(WAR_PATH);
        webAppContext.setExtractWAR(true);
        webAppContext.setServer(server);
        webAppContext.setAttribute(
                "org.eclipse.jetty.server.webapp.ContainerIncludeJarPattern",
                ".*/[^/]*servlet-api-[^/]*\\.jar$|.*/javax.servlet.jsp.jstl-.*\\.jar$|.*/[^/]*taglibs.*\\.jar$" );
        webAppContext.start();
    }

    private void classUsing() {
        MediaType mp;
        Controller c;
        Model m;
        GetMapping gm;
        Autowired a;
        ApplicationContext ac;
        Bean b;
        ComponentScan cs;
        ViewResolver vr;
        EnableWebMvc e;
        ViewResolverRegistry vrr;
        WebMvcConfigurer mvc;
        SpringTemplateEngine en;
        SpringResourceTemplateResolver dsds;
        ThymeleafViewResolver th;
    }
}
