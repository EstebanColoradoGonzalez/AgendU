package com.agendu.infrastructure.configuration;

import com.agendu.infrastructure.filter.AuthenticationFilter;
import com.agendu.infrastructure.service.login.ServiceValidateToken;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationSecurity
{
    private static final String URL_PATTERN = "/*";

    @Bean
    public FilterRegistrationBean<AuthenticationFilter> authenticationFilter(ServiceValidateToken serviceValidateToken)
    {
        FilterRegistrationBean<AuthenticationFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new AuthenticationFilter(serviceValidateToken, new String[]{"/api/login", "/api/students*", "/swagger-ui.html","/swagger-ui/index.html","/v3/api-docs/swagger-config","/v3/api-docs", "*.js","*.css","*.png"}));
        registrationBean.addUrlPatterns(URL_PATTERN);

        return registrationBean;
    }
}
