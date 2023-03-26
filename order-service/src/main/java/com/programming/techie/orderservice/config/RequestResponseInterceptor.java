package com.programming.techie.orderservice.config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RequestResponseInterceptor implements ClientHttpRequestInterceptor {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        System.out.print("!@!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.print("!@!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");System.out.print("!@!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.print("!@!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.print("!@!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.print("!@!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");




        JwtAuthenticationToken token =  (JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        request.getHeaders().set("Authorization", "Bearer " + token.getToken().getTokenValue());



            log.debug("===========================request begin================================================");
            log.debug("URI         : {}", request.getURI());
            log.debug("Method      : {}", request.getMethod());
            log.debug("Headers     : {}", request.getHeaders());
            log.debug("Request body: {}", new String(body, "UTF-8"));
            log.debug("==========================request end================================================");

        return execution.execute(request, body);
    }
}
