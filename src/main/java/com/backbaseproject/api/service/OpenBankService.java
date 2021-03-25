package com.backbaseproject.api.service;

import java.util.List;

import com.backbaseproject.api.model.backbase.Transaction;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@Api(value = "OpenBankService interface", description = "Backbase API")
@ApiModel
public interface OpenBankService {
	
	@ApiModelProperty("Get transaction list")
	List<Transaction> getTransactionList();
	@ApiModelProperty("Get transaction list by transaction type")
	List<Transaction> getTransactionListByTransactionType(String transactionType);
	@ApiModelProperty("Get total amount by transaction type")
	Double getTotalAmountByTransactionType(String transactionType);

}
