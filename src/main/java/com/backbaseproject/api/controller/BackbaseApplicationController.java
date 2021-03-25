package com.backbaseproject.api.controller;

import java.util.List;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.spring.SpringCamelContext;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backbaseproject.api.model.backbase.Transaction;
import com.backbaseproject.api.service.OpenBankService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@RestController
@RequestMapping(value = "/")

@ComponentScans({
	@ComponentScan("org.apache.camel.impl"),
	@ComponentScan("com.backbaseproject.api.service")
})
@Api(value = "User Resource REST Endpoint", description = "Backbase API")
@ApiModel
public class BackbaseApplicationController {
	@ApiModelProperty(notes = "Log object")
	static Logger log = Logger.getLogger(BackbaseApplicationController.class.getName());
	
	@ApiModelProperty(notes = "open bank service")
	@Autowired
	OpenBankService openBankService;
	@ApiModelProperty(notes = "http headers")
	final HttpHeaders httpHeaders= new HttpHeaders();
	
	@ApiModelProperty(notes = "Hello test operation")
    @RequestMapping(value = "hello")
    public ResponseEntity<String> sayHello() {
        //final HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        log.info("sayHello method started");
        return new ResponseEntity<String>("{\"msg\": \"Hello World\"}", httpHeaders, HttpStatus.OK);

        
    }
    
	@ApiModelProperty(notes = "hello world test method for Apache camel")
    @RequestMapping(value= "hellocamel")
    public Object testCamel() throws Exception {
    	log.info("testCamel method started");
    	ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        CamelContext camelContext = SpringCamelContext.springCamelContext(appContext, false);
        try {
            ProducerTemplate template = camelContext.createProducerTemplate();
            camelContext.start();
            return template.request("direct:hello", null).getOut().getBody(String.class);
        } finally {
            camelContext.stop();
        }
    }
    
	@ApiModelProperty(notes = "Get transaction list for guest users")
    @RequestMapping(value= "/anonymous/transaction")
    public ResponseEntity<String> getTransactionListGuest() throws Exception {
    	log.info("getTransactionListGuest method started");
    	ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        CamelContext camelContext = SpringCamelContext.springCamelContext(appContext, false);
        try {
            ProducerTemplate template = camelContext.createProducerTemplate();
            camelContext.start();
            String result = template.request("direct:transaction", null).getOut().getBody(String.class);
            return new ResponseEntity<String>(result, httpHeaders, HttpStatus.OK);
        } finally {
            camelContext.stop();
        }
    }
 
	@ApiModelProperty(notes = "Get transaction lisy by transaction type for guest users")
    @RequestMapping(value= "/anonymous/transactiontype")
    public ResponseEntity<String> getTransactionListByTransactionTypeGuest() throws Exception {
    	log.info("getTransactionListByTransactionTypeGuest method started");

    	ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        CamelContext camelContext = SpringCamelContext.springCamelContext(appContext, false);
        try {
            ProducerTemplate template = camelContext.createProducerTemplate();
            camelContext.start();
            String result = template.request("direct:transactiontype", null).getOut().getBody(String.class);
            return new ResponseEntity<String>(result, httpHeaders, HttpStatus.OK);
        } finally {
            camelContext.stop();
        }
    }
    
	@ApiModelProperty(notes = "Get total amount by transaction type for guest users")
    @RequestMapping(value= "/anonymous/transactiontype/amount")
    public ResponseEntity<String> getTotalAmountByTransactionTypeGuest() throws Exception {
    	log.info("getTotalAmountByTransactionTypeGuest method started");

    	ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        CamelContext camelContext = SpringCamelContext.springCamelContext(appContext, false);
        try {
            ProducerTemplate template = camelContext.createProducerTemplate();
            camelContext.start();
            String result = template.request("direct:transactiontypeamount", null).getOut().getBody(String.class);
            return new ResponseEntity<String>(result, httpHeaders, HttpStatus.OK);
        } finally {
            camelContext.stop();
        }
    }

	@ApiModelProperty(notes = "Get transaction list for authorized users")
    @GetMapping("/transaction") 
    public List<Transaction> getTransactionList(){
    	log.info("getTransactionList method started");

    	return openBankService.getTransactionList();
    }
    
	@ApiModelProperty(notes = "Get transaction list by transaction type for authorized users")
    @GetMapping("/transaction/{type}")
    public List<Transaction> getTransactionListByTransactionType(@PathVariable String type){
    	log.info("getTransactionListByTransactionType method started");
    	return openBankService.getTransactionListByTransactionType(type);
    }
    @GetMapping("/transaction/{type}/amount")
    public Double getTotalAmountByTransactionType(@PathVariable String type) {
    	log.info("getTotalAmountByTransactionType method started");

    	return openBankService.getTotalAmountByTransactionType(type);
    }
}