/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.connect.security;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

            
            response.setHeader("Content-Disposition", "attachment;filename=\"result.pdf\"");
            HttpSession UserSession = request.getSession(false);
            if(UserSession.getAttribute("Username") == null)
               {
           response.sendRedirect("index.html");
        }

        else
               {
           Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 20, Font.BOLD);
           Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.NORMAL);
            // step 1
            Document document = new Document(PageSize.A4, 50, 50, 50, 50);
            // step 2
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PdfWriter.getInstance(document, baos);



        // step 4
            Paragraph para1 = new Paragraph("ONLINE EXAMINATION PORTAL", catFont);
            para1.setAlignment(Element.ALIGN_CENTER);
            
            Paragraph para2 = new Paragraph("This is to certify that", subFont);
            para2.setAlignment(Element.ALIGN_CENTER);
            
            Paragraph newLine = new Paragraph(" ");
            
            Paragraph UserNameLine = new Paragraph(UserSession.getAttribute("Username").toString().toUpperCase(),catFont);
            UserNameLine.setAlignment(Element.ALIGN_CENTER);
            
            Paragraph para3 = new Paragraph("has completed the exam titled", subFont);
            para3.setAlignment(Element.ALIGN_CENTER);
            
            Paragraph ExamNameLine = new Paragraph(UserSession.getAttribute("ExamName").toString(),catFont);
            ExamNameLine.setAlignment(Element.ALIGN_CENTER);
            
            Paragraph ExamIDLine = new Paragraph("(UEID : "+UserSession.getAttribute("UEID").toString()+")",subFont);
            ExamIDLine.setAlignment(Element.ALIGN_CENTER);
            
            Paragraph para4 = new Paragraph("secured a score of", subFont);
            para4.setAlignment(Element.ALIGN_CENTER);

