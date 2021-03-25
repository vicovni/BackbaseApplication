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
	"id",
	"holder",
	"number",
	"kind",
	"IBAN",
	"swift_bic",
	"bank",
	"metadata"
})
@Api(value = "OpenBank OtherAccount object", description = "Backbase API")

public class OtherAccount {

	@JsonProperty("id")
	private String id;
	@JsonProperty("holder")
	private Holder holder;
	@JsonProperty("number")
	private String number;
	@JsonProperty("kind")
	private String kind;
	@JsonProperty("IBAN")
	private String iBAN;
	@JsonProperty("swift_bic")
	private Object swiftBic;
	@JsonProperty("bank")
	private Bank bank;
	@JsonProperty("metadata")
	private Metadata metadata;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("id")
	public String getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("holder")
	public Holder getHolder() {
		return holder;
	}

	@JsonProperty("holder")
	public void setHolder(Holder holder) {
		this.holder = holder;
	}

	@JsonProperty("number")
	public String getNumber() {
		return number;
	}

	@JsonProperty("number")
	public void setNumber(String number) {
		this.number = number;
	}

	@JsonProperty("kind")
	public String getKind() {
		return kind;
	}

	@JsonProperty("kind")
	public void setKind(String kind) {
		this.kind = kind;
	}

	@JsonProperty("IBAN")
	public String getIBAN() {
		return iBAN;
	}

	@JsonProperty("IBAN")
	public void setIBAN(String iBAN) {
		this.iBAN = iBAN;
	}

	@JsonProperty("swift_bic")
	public Object getSwiftBic() {
		return swiftBic;
	}

	@JsonProperty("swift_bic")
	public void setSwiftBic(Object swiftBic) {
		this.swiftBic = swiftBic;
	}

	@JsonProperty("bank")
	public Bank getBank() {
		return bank;
	}

	@JsonProperty("bank")
	public void setBank(Bank bank) {
		this.bank = bank;
	}

	@JsonProperty("metadata")
	public Metadata getMetadata() {
		return metadata;
	}

	@JsonProperty("metadata")
	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
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