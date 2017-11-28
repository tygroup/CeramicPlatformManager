package com.cpf.resources.jackson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties({"showtype","showtype","fillinno","fillinunit","gameid"})
public abstract class FillInItemsMixIn {
	@JsonProperty("id")
	 String fillinitemsid;
	@JsonProperty("name")
	 String itemname;
	@JsonProperty("pId")
	 String parentid;
}
