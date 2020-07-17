/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.connect.security;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Devanand
 */

    public class AuthenticateLogin extends HttpServlet {

        /** 
         * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
         * @param request servlet request
         * @param response servlet response
         * @throws ServletException if a servlet-specific error occurs
         * @throws IOException if an I/O error occurs
         */
        String dbtime;
    String dbUrl = "jdbc:odbc:Online_Exam_Portal";
    String dbClass = "com.mysql.jdbc.Driver";
    String query = "";
    String adminSelectQuery="";
    int authenticatorFlag=0;
    int userTypeFlag=5;
            int DBUserId;
            String DBPass= "";
            String DBUser= "";

    static final int LOGIN_SUCCESS=1;
    static final int LOGIN_WRONGPASSWORD=2;
    static final int LOGIN_UNKNOWNUSERNAME=3;
    static final int ADMIN_USER=4;
    static final int NORMAL_USER=5;
    /**
     * authenticatorFlag - used to record various possible states for login authentication process
     * The value set in the authenticatorFlag may depict one of the many possible states for the 
     * validation process
     * 
     * 
     * 
     * @throws ServletException 
     */


    @Override
    public void init(ServletConfig config) throws ServletException{
super.init(config);
}
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Please wait while we authenticate your credentials...</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h3>Please wait... </h3>");
            out.println("</body>");
            out.println("</html>");
            //Thread.sleep(6000);
            //out.println(""
             //       + "<script type=\"text/javascript\">"
             //       + "document.body.innerHTML = '';"
              //      + "</script>");
            
            String Username="";
            String Password="";
        
        Username= request.getParameter("Username");
        Password= request.getParameter("Password");
            
        
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
               
        Connection con = DriverManager.getConnection (dbUrl,"","");
        Statement stmt = con.createStatement();
        
        query="select UserId, Username, Password from Login_Credentials where Username='"+Username+"'";
        ResultSet rs = stmt.executeQuery(query); 
        
        
        boolean UserAuth= false;
        if(rs.next())
        {
             DBUserId = rs.getInt("UserId");
        DBUser = rs.getString("Username");
        DBPass = rs.getString("Password");
       
        UserAuth = DBUser.contains(Username);//.equals(Username);
        }
        if(UserAuth)
        { 
            authenticatorFlag= LOGIN_WRONGPASSWORD;
            
            if(DBPass.contains(Password))//&& authenticatorFlag!=LOGIN_UNKNOWNUSERNAME)
            {
                //out.println("<br>Comparing <b>"+Password+"</b> to DB value : <b>"+DBPass+"</b>"
                  //      + "<br>Password.compareTo(DBPass) returned : "+Password.compareTo(DBPass)+"<br><br>");
                authenticatorFlag= LOGIN_SUCCESS;
                
            }  
        }

