package com.cpf.resources;

import java.io.File;

/**
 * 系统常量定义
 * 
 * @author Administrator
 * 
 */
public class SysConst {
	/**
	 * 文件导出生成路径
	 */
	public enum exportExcelPah {
		EXCELFLIEPATH("D:" + File.separator + "excelFile");
		private String name;

		public String getName() {
			return name;
		}

		private exportExcelPah(String name) {
			this.name = name;
		}

	}

	/**
	 * 分析图设置
	 * 
	 * @author Administrator
	 * 
	 */
	public enum echart {
		FONTFAMILY("微软雅黑"), FONTSIZE("20"), NEARNAKEDEYERIGHT("近裸眼右眼视力"), NEARNAKEDEYELEFT(
				"近裸眼左眼视力"), FARNAKEDEYELEFT("远裸眼左眼视力"), FARNAKEDEYERIGHT(
				"远裸眼右眼视力");
		private String name;

		public String getName() {
			return name;
		}

		private echart(String name) {
			this.name = name;
		}

	}
	/**
	 * 极光推送消息类型
	 * 
	 * @author Administrator
	 * 
	 */
	public enum jMessageType {
		JOB("1"), MESSAGE("2"), SCHOOLNOTICE("3");
		private String name;

		public String getName() {
			return name;
		}

		private jMessageType(String name) {
			this.name = name;
		}

	}
}
