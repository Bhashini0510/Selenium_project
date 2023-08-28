package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import tech.grasshopper.excel.report.exception.ExcelReportException;

public class ExcelUtil {
	
	public static List<String> readFromExcel(String path,String sheet, int row) throws IOException{
		
		File file= new File(path);
		FileInputStream fio = new FileInputStream(file);
		
		List<String> inputs = new ArrayList<String>();
		//HSSFWorkbook - .xls
		//XSSFWorkbook - .xlxs
		XSSFWorkbook wb = new XSSFWorkbook(fio);
		XSSFSheet ws = wb.getSheet(sheet);
		Row xlRow=ws.getRow(row); 
		Iterator<Cell> i = xlRow.iterator();
		while(i.hasNext()) {
			Cell cell = i.next();
			inputs.add(cell.getStringCellValue());
		}
		wb.close();
		return inputs;
		
	}
	
	public static List<Map<Integer, String>> getDataFromExcel(String path, String sheet) throws IOException{
		
		File file= new File(path);
		FileInputStream fio = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fio);
		XSSFSheet ws = wb.getSheet(sheet);
		Iterator<Row> r = ws.rowIterator();
		List<Map<Integer,String>> dataTable = new ArrayList<Map<Integer,String>>();
		Row row;
		Cell cell;
		while(r.hasNext()) {
			
			row=r.next();
			Iterator<Cell> c = row.cellIterator();
			LinkedHashMap<Integer, String> colData = new LinkedHashMap<Integer, String>();
			while(c.hasNext()) {
				cell = c.next();
				colData.put(cell.getColumnIndex(), cell.getStringCellValue());
			}
			dataTable.add(colData);
			
		}
		
		return dataTable;
		
	}

	

}