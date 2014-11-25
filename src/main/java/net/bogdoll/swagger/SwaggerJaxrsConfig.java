package net.bogdoll.swagger;

import java.util.Collections;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

import com.google.common.collect.ImmutableMap;
import com.wordnik.swagger.jersey.config.JerseyJaxrsConfig;

public class SwaggerJaxrsConfig implements ServletConfig {
    private final Map<String, String> initParams;

    private SwaggerJaxrsConfig(Map<String,String> aParams) {
    	initParams = ImmutableMap.copyOf(aParams);
    }

    @Override
    public String getServletName() {
        return "JaxRS Servlet";
    }

    @Override
    public ServletContext getServletContext() {
        return null;
    }

    @Override
    public String getInitParameter(String s) {
        return initParams.get(s);
    }

    @Override
    public Enumeration<String> getInitParameterNames() {
        return Collections.enumeration(initParams.keySet());
    }
    
    public static void register(Map<String, String> aSwaggerParams) {
		new JerseyJaxrsConfig().init(new SwaggerJaxrsConfig(aSwaggerParams));
	}
}