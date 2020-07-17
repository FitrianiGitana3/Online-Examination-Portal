/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.connect.security;

import java.sql.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Devanand
 */
public class RunExam extends HttpServlet {

    String dbUrl = "jdbc:odbc:Online_Exam_Portal";
String dbClass = "com.mysql.jdbc.Driver";
String query = "";
    
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            int iQuestionNo=0;
            String Direction = "";
            String SelectedOption = "";
            HttpSession UserSession = request.getSession(false);
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RunExam</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RunExam at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
            
            Cookie[] ExamCookies = request.getCookies();
            for(int cookieCount = 0; cookieCount < ExamCookies.length; cookieCount++)
            {
                if(ExamCookies[cookieCount].getName().equals("QuestionNo"))
                {
                    iQuestionNo = Integer.parseInt(ExamCookies[cookieCount].getValue());
                }
                if(ExamCookies[cookieCount].getName().equals("MoveDirection"))
                {
                    Direction = ExamCookies[cookieCount].getValue();
                }
            }
if(Direction.equals("Next"))
            {
                iQuestionNo= iQuestionNo-1;
            SelectedOption = request.getParameter("OptionsRadio");
            String OptionName= "Question"+iQuestionNo+"SelectedOption";
            UserSession.setAttribute(OptionName, SelectedOption);
            iQuestionNo++;
            }
            else if(Direction.equals("Back"))
            {
                iQuestionNo= iQuestionNo+1;
            SelectedOption = request.getParameter("OptionsRadio");
            String OptionName= "Question"+iQuestionNo+"SelectedOption";
            UserSession.setAttribute(OptionName, SelectedOption);
                iQuestionNo--;
            }
            //else
            //{
           //     SelectedOption = request.getParameter("OptionsRadio");
           // String OptionName= "Question"+iQuestionNo+"SelectedOption";
           // UserSession.setAttribute(OptionName, SelectedOption);
           // response.sendRedirect("submitExamConfirmation.jsp");
           // }
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
               
            
             Connection con = DriverManager.getConnection (dbUrl,"","");
        Statement stmt = con.createStatement();
        
        query="select Question, OptionA, OptionB, OptionC, OptionD from Exam_Question_Bank where ExamId="
                +UserSession.getAttribute("ExamID")+" and QuestionNo = "+iQuestionNo;
        ResultSet rs = stmt.executeQuery(query); 
        
        if(rs.next())
        {
            UserSession.setAttribute("CurrentQuestion", rs.getString("Question"));
            UserSession.setAttribute("OptionA", rs.getString("OptionA"));
            UserSession.setAttribute("OptionB", rs.getString("OptionB"));
            UserSession.setAttribute("OptionC", rs.getString("OptionC"));
            UserSession.setAttribute("OptionD", rs.getString("OptionD"));
        }
        
        //out.println(""+rs.getString("Question"));
        
            
            response.sendRedirect("QuestionPaper.jsp");
        } 
        catch(Exception e)
        {
            e.printStackTrace(out);
        }
        finally {            
            out.close();
        }
    }
