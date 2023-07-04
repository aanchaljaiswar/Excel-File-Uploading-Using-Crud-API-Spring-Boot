package com.ExcelProd.helper;

import java.io.*;
import java.util.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.ExcelProd.entity.Product;

public class ProductHelper {

	//check that file is of excel type or not
	public static boolean checkExcelFormat(MultipartFile file)
	{
		String contentType = file.getContentType();
		if(contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
		{
			return true;
		} else {
			return false;
		}
			
		
	}
	
	
	//covert xcl to list of products
	public static List<Product> convertExcelToListOfProduct(InputStream is)
	{
		List<Product> list=new ArrayList<>();
		
		try
		{
			
			XSSFWorkbook workbook = new XSSFWorkbook(is);
			XSSFSheet sheet = workbook.getSheet("data");
			
			int rowNumber=0;
			Iterator<Row> iterator = sheet.iterator();
			
			while(iterator.hasNext())
			{
				Row row = iterator.next();
				
				if(rowNumber==0)
				{
					rowNumber++;
					continue;
				}
				
				int cid=0;
				Iterator<Cell> cells = row.iterator();
				
				Product p=new Product();
				
				while(cells.hasNext())
				{
					Cell cell = cells.next();
					
					switch(cid)
					{
					
					case 0:
						p.setProductID((int)cell.getNumericCellValue());
						break;
					case 1:
						p.setProductName(cell.getStringCellValue());
						break;
					case 2:
						p.setProductDesc(cell.getStringCellValue());
						break;
					case 3:
						p.setProductPrice(cell.getNumericCellValue());
						break;
					default:
						break;
					}
					cid++;
				}
				list.add(p);
			}                             
			
		}catch(Exception e)
		
		{
			e.printStackTrace();
		}
		return list;
	}
	
}
