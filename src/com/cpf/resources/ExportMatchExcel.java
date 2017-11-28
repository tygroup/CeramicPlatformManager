package com.cpf.resources;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;

public class ExportMatchExcel {

	@SuppressWarnings("unchecked")
	public void exportMatchExcel(String title, String[] headers,
			List<?> dataset, OutputStream out, String pattern) {
		// 声明一个工作薄
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 生成一个表格
		HSSFSheet sheet = workbook.createSheet(title);
		// 设置表格默认列宽度为15个字节
		sheet.setDefaultColumnWidth((short) 20);
		// 生成一个样式
		HSSFCellStyle style = workbook.createCellStyle();
		// 设置这些样式
		style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);

		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		// 生成一个字体
		HSSFFont font = workbook.createFont();
		font.setColor(HSSFColor.VIOLET.index);
		font.setFontHeightInPoints((short) 12);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		// 把字体应用到当前的样式
		style.setFont(font);
		// 生成并设置另一个样式
		HSSFCellStyle style2 = workbook.createCellStyle();
		style2.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
		style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		// 生成另一个字体
		HSSFFont font2 = workbook.createFont();
		font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
		// 把字体应用到当前的样式
		style2.setFont(font2);
		for (int i = 0; i < 5; i++) {

			// 在sheet里增加合并单元格
			sheet.addMergedRegion(new CellRangeAddress(0, 1, i, i));
		}
		// 在sheet里增加合并单元格
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 5, headers.length - 1));
		// 产生表格标题行
		HSSFRow row = sheet.createRow(0);
		for (short i = 0; i < headers.length; i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellStyle(style);
			HSSFRichTextString text = new HSSFRichTextString(headers[i]);

			if (i == 5) {

				cell.setCellValue("报名资料 ");
				// 合并边框
				for (int y = i + 1; y < headers.length; y++) {
					row.createCell(y).setCellStyle(style);
				}
				row = sheet.createRow(1);
				for (int j = 0; j < headers.length - 5; j++) {
					HSSFCell cell1 = row.createCell(j + 5);
					cell1.setCellStyle(style);
					HSSFRichTextString text1 = new HSSFRichTextString(
							headers[j + 5]);
					
					cell1.setCellValue(text1);
				}
			} else  {
				cell.setCellValue(text);
			}
		}
		
		// 遍历集合数据，产生数据行
		Iterator<?> it = dataset.iterator();
		int index = 1;
		/*while (it.hasNext()) {
			index++;
			row = sheet.createRow(index);
		//	Entered t = (Entered) it.next();
			t.setFillInItemsSet(t.getFillInItemsSet());
			for (short i = 0; i < headers.length; i++) {
				HSSFCell cell = row.createCell(i);
				cell.setCellStyle(style2);
				if (i == 0) {
					cell.setCellValue(t.getUsername());
				} else if (i == 1) {
					cell.setCellValue(t.getPhonenum());
				} else if (i == 2) {
					cell.setCellValue(t.getEntryfee());
				} else if (i == 3) {
					String ss="未交报名费";
					if("1".equals(t.getIspay())){
						ss="已交报名费";
					}else if("2".equals(t.getIspay())){
						ss="已交预付款，待交全款";
					}
					cell.setCellValue(ss);
				} else if (i == 4) {
					cell.setCellValue(t.getStudentName() == null ? "无" : t
							.getStudentName());
				} else {
					EnteredMsg em = t.getFillInItemsSet().get(i - 5)
							.getEnteredMsgSet().get(0);
					cell.setCellValue(em.getItemvalue());
				}*/

			//}
		//}
		/*try {
			//workbook.write(out);
		} catch (IOException e) {
			e.printStackTrace();
		}*/
	}

}
