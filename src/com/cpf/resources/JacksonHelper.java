package com.cpf.resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

public class JacksonHelper {

	private String filterName;

	private String[] propertyName;

	private Class<?> targetClass;
	private Class<?> mixinSourceClass;
	private Object object;

	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}

	public void setPropertyName(String[] propertyName) {
		this.propertyName = propertyName;
	}

	public void setTargetClass(Class<?> targetClass) {
		this.targetClass = targetClass;
	}

	public void setMixinSourceClass(Class<?> mixinSourceClass) {
		this.mixinSourceClass = mixinSourceClass;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	/**
	 * 数据集object中按照指定propertyName(过滤掉targetClass中非propertyName属性)生成json，
	 * 不能改变生成json中字段名称
	 * 
	 * @return
	 * @throws JsonProcessingException
	 */
	public String getJacksonInterface() throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		FilterProvider idFilterProvider = new SimpleFilterProvider().addFilter(
				filterName,
				SimpleBeanPropertyFilter.filterOutAllExcept(propertyName));
		objectMapper.setFilterProvider(idFilterProvider);
		objectMapper.addMixIn(targetClass, mixinSourceClass);
		return objectMapper.writeValueAsString(object);
	}

	/**
	 * 数据集object中按照指定mixinSourceClass生成json
	 * 
	 * @return
	 * @throws JsonProcessingException
	 */
	public String getJacksonClass() throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.addMixInAnnotations(targetClass, mixinSourceClass);
		return objectMapper.writeValueAsString(object);
	}
}
