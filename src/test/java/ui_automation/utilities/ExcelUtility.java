package ui_automation.utilities;

import org.apache.poi.xssf.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
public class ExcelUtility {
    private static XSSFSheet workSheet;
    private static XSSFWorkbook workBook;
    private static XSSFCell cell;
    private static XSSFRow row;
    private static MissingCellPolicy xRow;


//      1- Create an object of FileInputStream class to read Excel file
//          FileInputStream fis = new FileInputStream("C:\\mydata.xlsx");
//       2- Create object of XSSFWorkbook class
//          XSSFWorkbook workbook = new XSSFWorkbook(fis);
//       3-Create object of XSSFWorksheet class
//          XSSFSheet sheet = workbook.getSheetAt(0);
//       4- Access a given row:
//          XSSFRow row  = sheet .getRow(1);
//       5-Access a given cell:
//          XSSFCell cell = row.getCell(1);
//          String value = cell.getStringCellValue();
//        OR - Alternatively:
//          String value = sheet .getRow(1).getCell(1).getStringCellValue();


    public static void setExcelFile(String Path, String SheetName) throws Exception {
        try {
            FileInputStream ExcelFile = new FileInputStream(Path);
            workBook = new XSSFWorkbook(ExcelFile);
            workSheet = workBook.getSheet(SheetName);
        } catch (Exception e) {

            throw (e);

        }
    }

    public static Object getCellData(int RowNum, int ColNum) throws Exception{
        try{
            cell = workSheet.getRow(RowNum).getCell(ColNum);
            return cell.getStringCellValue();
        }catch (Exception IllegalStateException){
            try{
                cell = workSheet.getRow(RowNum).getCell(ColNum);
                return cell.getNumericCellValue();
            }
            catch (Exception e){
                cell = workSheet.getRow(RowNum).getCell(ColNum);
                return cell.getDateCellValue();
            }
        }
    }


    public static void setCellData(String path, String value,  int RowNum, int ColNum) throws Exception {
        try{
            row  = workSheet.getRow(RowNum);
            cell = row.getCell(ColNum);
            if (cell == null) {
                cell = row.createCell(ColNum);
                cell.setCellValue(value);
            } else {
                cell.setCellValue(value);
            }
            FileOutputStream fileOut = new FileOutputStream(path);
            workBook.write(fileOut);
            fileOut.flush();
            fileOut.close();
        }catch(Exception e){

            throw (e);

        }

    }


    public static void createExcelAndWrite(String fileName, String value){
        workBook = new XSSFWorkbook();
        workSheet = workBook.createSheet("FIRST SHEET");
        row = workSheet.createRow(0);
        cell = row.createCell(0);
        cell.setCellValue(value);
        try (FileOutputStream fos = new FileOutputStream(new File(fileName)))
        {
            workBook.write(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}