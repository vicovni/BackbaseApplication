package com.backbaseproject.api.model.backbase;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Api(value = "Backbase Transaction business object", description = "Backbase API")
@ApiModel

public class Transaction {
	@ApiModelProperty("id")
	private String id;
	@ApiModelProperty("account id")
	private String accountId;
	@ApiModelProperty("counterparty account")
	private String counterpartyAccount;
	@ApiModelProperty("counterparty name")
	private String counterpartyName;
	@ApiModelProperty("counterparty logo path")
	private String counterPartyLogoPath;
	@ApiModelProperty("instructed amount")
	private String instructedAmount;
	@ApiModelProperty("instructed currency")
	private String instructedCurrency;
	@ApiModelProperty("transaction amount")
	private String transactionAmount;
	@ApiModelProperty("transaction currency")
	private String transactionCurrency;
	@ApiModelProperty("transaction type")
	private String transactionType;
	@ApiModelProperty("description")
	private String description;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getCounterpartyAccount() {
		return counterpartyAccount;
	}
	public void setCounterpartyAccount(String counterpartyAccount) {
		this.counterpartyAccount = counterpartyAccount;
	}
	public String getCounterpartyName() {
		return counterpartyName;
	}
	public void setCounterpartyName(String counterpartyName) {
		this.counterpartyName = counterpartyName;
	}
	public String getCounterPartyLogoPath() {
		return counterPartyLogoPath;
	}
	public void setCounterPartyLogoPath(String counterPartyLogoPath) {
		this.counterPartyLogoPath = counterPartyLogoPath;
	}
	public String getInstructedAmount() {
		return instructedAmount;
	}
	public void setInstructedAmount(String instructedAmount) {
		this.instructedAmount = instructedAmount;
	}
	public String getInstructedCurrency() {
		return instructedCurrency;
	}
	public void setInstructedCurrency(String instructedCurrency) {
		this.instructedCurrency = instructedCurrency;
	}
	public String getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public String getTransactionCurrency() {
		return transactionCurrency;
	}
	public void setTransactionCurrency(String transactionCurrency) {
		this.transactionCurrency = transactionCurrency;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
