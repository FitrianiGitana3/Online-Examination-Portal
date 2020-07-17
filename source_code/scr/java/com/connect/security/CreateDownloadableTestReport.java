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

/**
 *
 * @author Devanand
 */
public class CreateDownloadableTestReport extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
      try {
            // Get the text that will be added to the PDF
            //PrintWriter out = response.getWriter();
            //out.print("Please Wait....");
            response.setHeader("Expires", "0");
            response.setHeader("Cache-Control","must-revalidate, post-check=0, pre-check=0");
            

            
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
            
            int Score = Integer.parseInt(UserSession.getAttribute("ExamScore").toString()); 
            String performance = "";
            if(Score>=50 && Score<60)
            {
                performance = "Satisfactory";
            }


            if(Score>=60 && Score<70)
            {
                performance = "Fair";
            }
            if(Score>700 && Score<=100)
            {
                performance = "Excellent";
            }
            If(Score<50)
            {
                performance = "Poor";
            }
            // step 3
            document.open();

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

