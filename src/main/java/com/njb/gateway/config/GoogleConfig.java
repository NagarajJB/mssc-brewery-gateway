package com.njb.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

//@Profile("udemy")
//@Configuration
public class GoogleConfig {

	@Bean
	public RouteLocator googleRouterConfig(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r -> r.path("/googlesearch")
						.filters(f -> f.rewritePath("/googlesearch(?<segment>/?.*)", "/${segment}"))
						.uri("https://www.google.com/").id("google"))
				.build();
	}

}
