package com.backbaseproject.api.router;

import java.util.Base64;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Api(value = "Routes configuration for apache Camel", description = "Backbase API")
@ApiModel
@Component
public class ApiRestRouter extends RouteBuilder {

	@ApiModelProperty("UTF-8 constant")
    public static final String UTF_8 = "UTF-8";
	@ApiModelProperty("content type constant")
	public static final String CONTENT_TYPE = "Content-Type";
	@ApiModelProperty("application json constant")
    public static final String APPLICATION_JSON = "application/json";
    
	@ApiModelProperty("Configure routes")
	@Override
	public void configure() throws Exception {
		
        from("direct:hello")
        .log("body insertStudent request ${body}")
        .setHeader(Exchange.HTTP_METHOD, constant("GET"))
        .setHeader(CONTENT_TYPE, simple(APPLICATION_JSON))
        .setHeader("Authorization", simple("Basic " + Base64.getEncoder().encodeToString(("user:password").getBytes()) ))
        .to("http://localhost:8082/hello").end();
        
        from("direct:transaction")
        .log("body insertStudent request ${body}")
        .setHeader(Exchange.HTTP_METHOD, constant("GET"))
        .setHeader(CONTENT_TYPE, simple(APPLICATION_JSON))
        .setHeader("Authorization", simple("Basic " + Base64.getEncoder().encodeToString(("user:password").getBytes()) ))
        .to("http://localhost:8082/transaction").end();
        
        from("direct:transactiontype")
        .log("body insertStudent request ${body}")
        .setHeader(Exchange.HTTP_METHOD, constant("GET"))
        .setHeader(CONTENT_TYPE, simple(APPLICATION_JSON))
        .setHeader("Authorization", simple("Basic " + Base64.getEncoder().encodeToString(("user:password").getBytes()) ))
        .to("http://localhost:8082/transaction/SEPA").end();

        from("direct:transactiontypeamount")
        .log("body insertStudent request ${body}")
        .setHeader(Exchange.HTTP_METHOD, constant("GET"))
        .setHeader(CONTENT_TYPE, simple(APPLICATION_JSON))
        .setHeader("Authorization", simple("Basic " + Base64.getEncoder().encodeToString(("user:password").getBytes()) ))
        .to("http://localhost:8082/transaction/SEPA/amount").end();

	}
}
