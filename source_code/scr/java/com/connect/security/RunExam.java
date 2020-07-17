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
   // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
 /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
