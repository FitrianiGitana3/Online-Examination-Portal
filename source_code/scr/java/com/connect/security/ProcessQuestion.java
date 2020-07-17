/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.connect.security;

import java.io.IOException;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Devanand
 */
public class ProcessQuestion extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     */
    String dbUrl = "jdbc:odbc:Online_Exam_Portal";
String dbClass = "com.mysql.jdbc.Driver";
String query = "";
    private String readTextarea(String textAreaName, HttpServletRequest request)
    {
        String textAreaContent = "";
        textAreaContent = request.getParameter(textAreaName);
        return textAreaContent;
    }

        private String convertTextareaContent(String content)
    {
        StringBuilder text = new StringBuilder(content);
  
        int loc = (new String(text)).indexOf('\n');
        while(loc > 0){
            text.replace(loc, loc+1, "<BR>");
            loc = (new String(text)).indexOf('\n');
       }
        return text.toString();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String txtQuestion = "";
        String txtOptionA = "";
        String txtOptionB = "";
        String Answer = "";
        UserSession.setAttribute("QuestionEntryException", null);
        try {
            txtQuestion = readTextarea("addNewQuestion",request);
            txtOptionA = readTextarea("addOptionA",request);
            txtOptionB = readTextarea("addOptionB",request);
    
    Answer = request.getParameter("CorrectAnswerRadio");
            //out.print(txtOptionD); 
            UserSession.setAttribute("QuestionEnteredValue", txtQuestion);
                UserSession.setAttribute("OptionAEnteredValue", txtOptionA);
                UserSession.setAttribute("OptionBEnteredValue", txtOptionB);
    if(txtQuestion==null|| "".equals(txtQuestion))
            {
                UserSession.setAttribute("QuestionEntryException", "Please enter a question");
                UserSession.setAttribute("QuestionEnteredValue", null);
                response.sendRedirect("AddQuestions.jsp");
            }
            else if(txtOptionA==null || "".equals(txtOptionA))
            {
                UserSession.setAttribute("QuestionEntryException", "Please enter Option A");
                response.sendRedirect("AddQuestions.jsp");
            } 
    else if(txtOptionC==null || "".equals(txtOptionC))
            {
                UserSession.setAttribute("QuestionEntryException", "Please enter Option C");
                response.sendRedirect("AddQuestions.jsp");
            }

    
    else
            {
                UserSession.setAttribute("QuestionEnteredValue", null);
                UserSession.setAttribute("OptionAEnteredValue", null);
                UserSession.setAttribute("OptionBEnteredValue", null);
                
                txtQuestion = convertTextareaContent(txtQuestion);
                txtOptionA = convertTextareaContent(txtOptionA);
                txtOptionB = convertTextareaContent(txtOptionB);
                
                Connection con = DriverManager.getConnection (dbUrl,"","");
        
        PreparedStatement insertNewQuestion;
        
                String ExamInfoInsertQuery=""
                + "insert into Exam_Question_Bank "
                + "(ExamId, QuestionNo, Question, OptionA, OptionB, OptionC, Answer) "
                + "values(?,?,?,?,?,?,?,?);";
           }
}


      /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}

