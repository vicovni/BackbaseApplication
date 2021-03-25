package com.backbaseproject.api.service;

import static org.junit.Assert.*;

import org.junit.Test;

//import com.backbaseproject.api.service.OpenBankServiceTest;

public class OpenBankServiceImplTest {

	@Test
	public void testGetTransactionList() {
		assertTrue( (new OpenBankServiceImpl().getTransactionList()) != null);
		assertTrue( (new OpenBankServiceImpl().getTransactionList()).size() > 0);
	}

	@Test
	public void testGetTransactionListByTransactionType() {
		assertTrue( (new OpenBankServiceImpl().getTransactionListByTransactionType("SEPA")) != null);
		assertTrue( (new OpenBankServiceImpl().getTransactionListByTransactionType("SEPA")).size() > 0);	
	}

	@Test
	public void testGetTotalAmountByTransactionType() {
		assertTrue( (new OpenBankServiceImpl().getTotalAmountByTransactionType("SEPA")) != null);	
	}

}
