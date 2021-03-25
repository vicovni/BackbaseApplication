package com.backbaseproject.api.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.backbaseproject.api.model.backbase.Transaction;
import com.backbaseproject.api.model.openbank.Transactions;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Service
@Api(value = "OpenBankService implementation", description = "Backbase API")
@ApiModel
public class OpenBankServiceImpl implements OpenBankService {

	@ApiModelProperty("log object")
	static Logger log = Logger.getLogger(OpenBankServiceImpl.class.getName());

	@ApiModelProperty("Get transaction list implementation")
	@Override
	public List<Transaction> getTransactionList() {
		log.info("getTransactionList method started");
		List<Transaction> result = new ArrayList<>();
		final ClientConfig clientConfig = new DefaultClientConfig();
		final Client client = Client.create(clientConfig);
		final WebResource webResource = client.resource(UriBuilder.fromUri("https://apisandbox.openbankproject.com").build());
		Transactions transactions = webResource.path("obp/v1.2.1/banks/rbs/accounts/savings-kids-john/public").path("transactions").accept(MediaType.APPLICATION_JSON).get(Transactions.class);
		
		for(com.backbaseproject.api.model.openbank.Transaction tran : transactions.getTransactions()) {
			com.backbaseproject.api.model.backbase.Transaction backbaseTransaction = new Transaction();
			backbaseTransaction.setId(tran.getId());
			backbaseTransaction.setAccountId(tran.getThisAccount() != null? tran.getThisAccount().getId(): null);
			backbaseTransaction.setCounterpartyAccount(tran.getOtherAccount() !=null? tran.getOtherAccount().getNumber() : null);
			backbaseTransaction.setCounterpartyName(tran.getOtherAccount()!=null && tran.getOtherAccount().getHolder()!=null? tran.getOtherAccount().getHolder().getName(): null);
			backbaseTransaction.setCounterPartyLogoPath(tran.getOtherAccount()!=null &&tran.getOtherAccount().getMetadata() !=null?(String)tran.getOtherAccount().getMetadata().getImageURL(): null);
			backbaseTransaction.setInstructedAmount(tran.getDetails()!=null && tran.getDetails().getValue()!=null?tran.getDetails().getValue().getAmount():null);
			backbaseTransaction.setInstructedCurrency(tran.getDetails()!=null && tran.getDetails().getValue() !=null?tran.getDetails().getValue().getCurrency():null);
			backbaseTransaction.setTransactionAmount(tran.getDetails()!=null && tran.getDetails().getValue() !=null?tran.getDetails().getValue().getAmount():null);
			backbaseTransaction.setTransactionCurrency(tran.getDetails()!=null && tran.getDetails().getValue() !=null?tran.getDetails().getValue().getCurrency():null);
			backbaseTransaction.setTransactionType(tran.getDetails()!=null?tran.getDetails().getType():null);
			backbaseTransaction.setDescription(tran.getDetails()!=null?tran.getDetails().getDescription():null);
			result.add(backbaseTransaction);
		}
		return result;
	}

	@ApiModelProperty("Get transaction list by transaction type implementation")
	@Override
	public List<Transaction> getTransactionListByTransactionType(String transactionType) {
		log.info("getTransactionListByTransactionType method started");
		List<Transaction> result = new ArrayList<>();
		List<Transaction> transactions = this.getTransactionList();
		for(Transaction tran : transactions) {
			if(tran.getTransactionType()!=null && tran.getTransactionType().equals(transactionType)) {
				result.add(tran);
			}
		}
		return result;
	}

	@ApiModelProperty("Get total amount by transaction type implementation")
	@Override
	public Double getTotalAmountByTransactionType(String transactionType) {
		log.info("getTotalAmountByTransactionType method started");

		Double result = 0.0;
		List<Transaction> transactions = this.getTransactionList();
		for(Transaction tran : transactions) {
			if(tran.getTransactionType()!=null && tran.getTransactionType().equals(transactionType)) {
				result+= Double.parseDouble(tran.getTransactionAmount()!=null?tran.getTransactionAmount():"0.0");
			}
		}
		return result;
	}


}
