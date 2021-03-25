package com.backbaseproject.api.model.openbank;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.Api;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"currency",
	"amount"
})
@Api(value = "OpenBank NewBalance object", description = "Backbase API")

public class NewBalance {

	@JsonProperty("currency")
	private String currency;
	@JsonProperty("amount")
	private Object amount;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("currency")
	public String getCurrency() {
		return currency;
	}

	@JsonProperty("currency")
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@JsonProperty("amount")
	public Object getAmount() {
		return amount;
	}

	@JsonProperty("amount")
	public void setAmount(Object amount) {
		this.amount = amount;
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