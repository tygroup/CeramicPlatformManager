package com.cpf.resources.jackson;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties({"phonenum","address","zipcode","bureaucode","areaid","layerNum","nodeCount","areaname"})
public abstract  class BureauMixIn {
	@JsonProperty("id")
	 String bureauid;
	@JsonProperty("name")
	 String bureauname;
	@JsonProperty("pId")
	 String parentid;
	

}
