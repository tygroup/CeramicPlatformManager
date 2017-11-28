package com.cpf.resources.jackson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties({"nodeCount"})
public abstract class AreaMixIn {
	@JsonProperty("id")
	 String areaid;
	@JsonProperty("name")
	 String areaname;
	@JsonProperty("pId")
	 String parentid;
	
}
