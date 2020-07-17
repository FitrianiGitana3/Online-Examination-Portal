/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.connect.security;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Please wait while we analyze your request...</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Please wait... </h2>");
           // out.println("<br><h3>Oops... it seems our registration service is currently being updated...<br>"
             //       + "We're sorry for the inconvenience.... "
               //     + "You can check back later and we'll have it all up and running again.... Thank You..!!!</h3>");
            
            
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");



int output = insertUserInfo.executeUpdate();
                
                
        //--------------------------------------------------------------------------------
        // The following segment of out.println() code is only for debugging purposes...
        //--------------------------------------------------------------------------------
        out.println("<br><br><h3>New User Registration Details</h3>" 
                + "-----------------------------------------------------------------<br>");
        out.println("<br>Name     &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp: "+Name);
        out.println("<br>Email    &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp: "+Email);
        out.println("<br>Username &nbsp&nbsp&nbsp&nbsp&nbsp: "+UserName);
        out.println("<br>Password &nbsp&nbsp&nbsp&nbsp&nbsp: "+Password);
