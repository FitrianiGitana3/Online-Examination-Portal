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
