package com.example.demo.filter;

import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;

import com.example.demo.dto.RoleDto;
import com.example.demo.util.JwtUtil;

import io.jsonwebtoken.Claims;
import reactor.core.publisher.Mono;





@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {

    @Autowired
    private RouteValidator validator;


    @Autowired
    private JwtUtil jwtUtil;

    public AuthenticationFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            if (validator.isSecured.test(exchange.getRequest())) {
            	
                //header contains token or not
                if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                    throw new RuntimeException("missing authorization header");
                }

                String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
                if (authHeader != null && authHeader.startsWith("Bearer ")) {
                    authHeader = authHeader.substring(7);
                }
                try {
//                    //REST call to AUTH service
//                    template.getForObject("http://IDENTITY-SERVICE//validate?token" + authHeader, String.class);
                    
                    jwtUtil.validateToken(authHeader);
                    System.out.println("Token Validated");
                    // Validate token and extract claims
                    Claims claims = jwtUtil.validateTokenWithRoles(authHeader);
                    List<RoleDto> roles = claims.get("roles", List.class);
                    System.out.println(roles);
                    // Role-based validation (example: allow only ADMIN role for specific routes)
                    String path = exchange.getRequest().getPath().toString();
                    HttpMethod method = exchange.getRequest().getMethod();
                    System.out.println("Path="+path + " Method" + method);
                    
                    if(roles!=null && roles.size()>0)
                    {
                    	String role = roles.get(0).getName();
                    	
                    	if(path.startsWith("/products"))
                		{
                    			if(method == HttpMethod.GET && !role.equals("ROLE_ADMIN"))
                    				return onError(exchange, "Unauthorized access to application", HttpStatus.UNAUTHORIZED);
                		}
                    	
                    		
                    }
                    

                } catch (Exception e) {
                    System.out.println("invalid access...!");
                    return onError(exchange, "Unauthorized access to application", HttpStatus.UNAUTHORIZED);
                }
            }
            return chain.filter(exchange);
        });
    }
    private Mono<Void> onError(org.springframework.web.server.ServerWebExchange exchange, String error, HttpStatus status) {
    	System.out.println("---------------------------------");
    	ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(status);
        response.getHeaders().setContentType(MediaType.APPLICATION_JSON);

        String errorMessage = String.format("{\"error\": \"%s\"}", error);
        byte[] bytes = errorMessage.getBytes(StandardCharsets.UTF_8);

        return response.writeWith(Mono.just(response.bufferFactory().wrap(bytes)));
    }
    public static class Config {

    }
}