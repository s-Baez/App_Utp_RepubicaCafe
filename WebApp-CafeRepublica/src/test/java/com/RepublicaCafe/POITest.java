package com.RepublicaCafe;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;
public class POITest {
    public static void main(String[] args) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Ingresos");
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("ID Ingreso");
        headerRow.createCell(1).setCellValue("Fecha");
        headerRow.createCell(2).setCellValue("Cantidad");
        headerRow.createCell(3).setCellValue("ID");
        headerRow.createCell(4).setCellValue("ID Proveedor");
        headerRow.createCell(5).setCellValue("ID Usuario");
        headerRow.createCell(6).setCellValue("Precio Unitario");
        headerRow.createCell(7).setCellValue("Total");

        Row dataRow = sheet.createRow(1);
        dataRow.createCell(0).setCellValue(1);
        dataRow.createCell(1).setCellValue("2024-11-07");
        dataRow.createCell(2).setCellValue(100);
        dataRow.createCell(3).setCellValue(101);
        dataRow.createCell(4).setCellValue(1);
        dataRow.createCell(5).setCellValue(1);
        dataRow.createCell(6).setCellValue(15.75);
        dataRow.createCell(7).setCellValue(100 * 15.75);

        try (FileOutputStream fileOut = new FileOutputStream("formato_ingreso.xlsx")) {
            workbook.write(fileOut);
            System.out.println("El archivo 'formato_ingreso.xlsx' se ha creado exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al crear el archivo Excel: " + e.getMessage());
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}