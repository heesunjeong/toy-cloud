package com.joy.toyzuul.config;

import com.joy.toyzuul.fallback.DefaultFallbackProvider;
import com.joy.toyzuul.fallback.ToyFallbackProvider;
import com.joy.toyzuul.filter.ErrorFilter;
import com.joy.toyzuul.filter.PostFilter;
import com.joy.toyzuul.filter.PreFilter;
import com.joy.toyzuul.filter.RouteFilter;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    @Bean
    public FallbackProvider defaultFallbackProvider() {
        return new DefaultFallbackProvider();
    }

    @Bean
    public FallbackProvider toyFallbackProvider() {
        return new ToyFallbackProvider();
    }

    @Bean
    public PreFilter preFilter() {
        return new PreFilter();
    }

    @Bean
    public PostFilter postFilter() {
        return new PostFilter();
    }

    @Bean
    public RouteFilter routeFilter() {
        return new RouteFilter();
    }

    @Bean
    public ErrorFilter errorFilter() {
        return new ErrorFilter();
    }
}
