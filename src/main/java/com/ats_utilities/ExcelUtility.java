package com.ats_utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	//This class contains the various methods that will read the data from the excel.

	static FileInputStream fis = null;
	static XSSFWorkbook workbook = null;
	static XSSFSheet sheet = null;
	static XSSFRow header = null;
	static XSSFCell cell = null;
	public static ArrayList<String> ar = new ArrayList<String>();

	public ExcelUtility(String path) throws IOException {

		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
	}

	public String getCellData(String name, int rowNum, int colNum) {

		String data = null;
		sheet = workbook.getSheet(name);
		cell = sheet.getRow(rowNum).getCell(colNum);
		
		if(cell==null)
			return "";

		if (cell.getCellType().equals(CellType.STRING)) {
			data = cell.getStringCellValue();
		}

		if (cell.getCellType().equals(CellType.NUMERIC)) {
			//data = String.valueOf(cell.getNumericCellValue());
			//data=NumberToTextConverter.toText(cell.getNumericCellValue());
			
			DataFormatter dataFormatter = new DataFormatter();
			data = dataFormatter.formatCellValue(cell);
		}

		if (cell.getCellType().equals(CellType.BOOLEAN)) {
			data = String.valueOf(cell.getBooleanCellValue());
		}

		return data;

	}

	public int getRowCount(String name) throws IOException {
		sheet = workbook.getSheet(name);
		return sheet.getLastRowNum() + 1;

	}

	public int getColumnCount(String name) throws IOException {
		sheet = workbook.getSheet(name);
		header = sheet.getRow(0);

		return header.getLastCellNum();

	}

	public ArrayList<String> getheader(String name) throws IOException {
		sheet = workbook.getSheet(name);
		header = sheet.getRow(0);
		for (Cell cell : header) {
			ar.add(cell.getStringCellValue());

		}
		return ar;

	}

}
