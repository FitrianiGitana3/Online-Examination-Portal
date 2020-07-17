/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.connect.security;

import java.io.IOException;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Devanand
 */
public class ChangeUserPrivilage extends HttpServlet {
    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}

  String query = "";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String UserIdToChange = "";
        String ChangeType = "";
        String AddAdminQuery = "";
        String RemoveAdminQuery = "";
        int output;
        HttpSession UserSession = request.getSession(false);
        try {
            UserIdToChange = request.getParameter("UserToChange");
            ChangeType = request.getParameter("ChangeType");
            
            //out.print(UserIdToChange + " " + ChangeType);
            
            Connection con = DriverManager.getConnection (dbUrl,"","");
        PreparedStatement userPrivilageChanger;
        
        if("ToAdminUser".equals(ChangeType))
        {
        AddAdminQuery="insert into Administrator_List (UserId) values(?)";
        output = userPrivilageChanger.executeUpdate();

          
        userPrivilageChanger = con.prepareStatement(RemoveAdminQuery);
        userPrivilageChanger.setString(1, UserIdToChange);
        output = userPrivilageChanger.executeUpdate();
       }
      }   
      catch(Exception e)
                {
                    e.printStackTrace(out);
                }
        finally {            
            out.close();
        }
    }
  
}

