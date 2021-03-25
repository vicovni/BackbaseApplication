package com.backbaseproject.api.controller;

import static org.junit.Assert.*;

import org.junit.Test;

public class BackbaseApplicationControllerTest {

	@Test
	public void testSayHello() {
		assertEquals("{\"msg\": \"Hello World\"}", new BackbaseApplicationController().sayHello().getBody());
	}

	@Test(expected = Exception.class)
	public void testTestCamel() throws Exception {
		assertTrue( (new BackbaseApplicationController().testCamel().toString()) != null);
	
	}

	@Test
	public void testGetTransactionListGuest() throws Exception{
		assertTrue( (new BackbaseApplicationController().getTransactionListGuest().toString()) != null);
	}

	@Test
	public void testGetTransactionListByTransactionTypeGuest() throws Exception{
		assertTrue( (new BackbaseApplicationController().getTransactionListByTransactionTypeGuest().toString()) != null);
	}

	@Test
	public void testGetTotalAmountByTransactionTypeGuest() throws Exception{
		assertTrue( (new BackbaseApplicationController().getTotalAmountByTransactionTypeGuest().toString()) != null);
	}

	@Test (expected = Exception.class)
	public void testGetTransactionList() {
		assertTrue( (new BackbaseApplicationController().getTransactionList()) != null);
		assertTrue( (new BackbaseApplicationController().getTransactionList()).size() > 0);
	}

	@Test (expected = Exception.class)
	public void testGetTransactionListByTransactionType() {
		assertTrue( (new BackbaseApplicationController().getTransactionListByTransactionType("SEPA")) != null);
		assertTrue( (new BackbaseApplicationController().getTransactionListByTransactionType("SEPA")).size() > 0);
	}

	@Test (expected = Exception.class)
	public void testGetTotalAmountByTransactionType() {
		assertTrue( (new BackbaseApplicationController().getTotalAmountByTransactionType("SEPA")) != null);
		
	}

}
