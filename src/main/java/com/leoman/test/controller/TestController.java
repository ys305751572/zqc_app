package com.leoman.test.controller;

import com.leoman.common.annotion.RequestLimit;
import com.leoman.common.core.Configue;
import com.leoman.test.entity.TestEntity;
import com.leoman.utils.XlsUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Administrator on 2016/7/1.
 */

@RequestMapping("/admin/test")
@Controller
public class TestController {

    @RequestLimit(count = 5)
    @RequestMapping(value = "/aes",method = RequestMethod.POST)
    public String aes(TestEntity testEntity) {
        System.out.println(testEntity.toString());
        return "success";
    }

    @RequestMapping(value = "/excel")
    public String excel(){
        try {

        }catch (RuntimeException e){
            e.printStackTrace();
        }
        return "/testXls/test";
    }

    @RequestMapping("/excel/export")
    public void saveImage(HttpServletRequest request,
                          HttpServletResponse response,
                          @RequestParam(required=false) MultipartFile file) throws IOException {
        try {
            String outPath = Configue.getUploadPath()+"test.xls";
            String fileType = outPath.substring(outPath.lastIndexOf(".") + 1, outPath.length());
            // 创建工作文档对象
            Workbook wb = null;
            if (fileType.equals("xls")) {
                wb = new HSSFWorkbook();
            } else if (fileType.equals("xlsx")) {
                wb = new XSSFWorkbook();
            } else {
                System.out.println("您的文档格式不正确！");
                return ;
            }

            //语数外
            Sheet sheet1 = XlsUtil.read(file,0);
            int rowNum1 = sheet1.getLastRowNum();//行数

            //数理化
            Sheet sheet2 = XlsUtil.read(file,1);
            int rowNum2 = sheet2.getLastRowNum();//行数

            // 创建sheet对象
            Sheet sheet3 = wb.createSheet("sheet1");
            Row header = sheet3.createRow(0);
            Cell title = header.createCell(1);
            title.setCellValue("总计");

            if(rowNum1 == rowNum2){
                for(int i=1; i<=rowNum1; i++){


                    Row row1 = sheet1.getRow(i);
                    for(Cell cell : row1){
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                    }
                    String yuwen = row1.getCell(1).getStringCellValue();
                    String shuxue = row1.getCell(2).getStringCellValue();
                    String english = row1.getCell(3).getStringCellValue();

                    Row row2 = sheet2.getRow(i);
                    for(Cell cell : row2){
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                    }
                    String wuli = row2.getCell(1).getStringCellValue();
                    String huaxue = row2.getCell(2).getStringCellValue();
                    String shengwu = row2.getCell(3).getStringCellValue();

                    //新建一行
                    Row row = (Row) sheet3.createRow(i);
                    Cell cell1 = row.createCell(0);
                    cell1.setCellValue(row1.getCell(0).getStringCellValue());
                    Cell cell2 = row.createCell(1);
                    cell2.setCellValue(Integer.valueOf(yuwen)+Integer.valueOf(shuxue)+Integer.valueOf(english)
                            +Integer.valueOf(wuli)+Integer.valueOf(huaxue)+Integer.valueOf(shengwu));

                }
            }

            OutputStream os = response.getOutputStream();// 取得输出流
            response.setContentType("application/x-download");
            response.setHeader("Content-disposition", "attachment;filename=student.xls");
            wb.write(os);
            // 关闭文件流
            os.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
