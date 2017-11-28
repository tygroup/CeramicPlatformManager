package com.cpf.resources;

import java.util.ResourceBundle;

public class ConfigUtilss {
	private String config;

	/**
	 * 配置属性文件,用包含属性文件的所在包全路径
	 * 
	 * @param config
	 */
	public ConfigUtilss(String config) {
		this.config = config;
	}

	public ConfigUtilss() {
	}

	public String getConfig() {
		return config;
	}

	public void setConfig(String config) {
		this.config = config;
	}

	/**
	 * 取得属性文件属性值
	 * 
	 * @param key
	 *            属性名称
	 * @return 属性值
	 */
	public String getConfigProperty(String key) {
		ResourceBundle resourceBundle = ResourceBundle.getBundle(config);
		return resourceBundle.getString(key);
	}


}