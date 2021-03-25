package com.backbaseproject.api.model.openbank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.Api;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"transactions"
})
@XmlRootElement
@Api(value = "OpenBank Transactions object", description = "Backbase API")

public class Transactions {

	@JsonProperty("transactions")
	private List<Transaction> transactions = null;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("transactions")
	public List<Transaction> getTransactions() {
		return transactions;
	}

	@JsonProperty("transactions")
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}