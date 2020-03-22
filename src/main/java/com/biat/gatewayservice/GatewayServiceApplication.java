package com.biat.gatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class GatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}
    @Bean
	RouteLocator StaticRoutes(RouteLocatorBuilder builder)
{
	return builder.routes()
			.route(r->r.path("/customers/**").uri("lb://CUSTOMER-SERVICE").id("r1"))
			.route(r->r.path("/products/**").uri("lb://INVENTORY-SERVICE").id("r2"))
			.route(r->r.path("/biat/**").uri("lb://CUSTOMER-SERVICE").id("r3"))
			.build();
}
}
