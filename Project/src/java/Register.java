/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Register")  
public class Register extends HttpServlet {

   
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        
        String name=request.getParameter("name");
        String fname=request.getParameter("fname");
        String address=request.getParameter("address");
        String country=request.getParameter("country");
        
        
        try    
        {    
            Class.forName("com.mysql.jdbc.Driver");    
           
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/register", "root", "root");    
          
            PreparedStatement pstmt=con.prepareStatement("Insert into register values (?,?,?,?)");    
            pstmt.setString(1, name);    
            pstmt.setString(2, fname);    
            pstmt.setString(3,address);    
            pstmt.setString(4, country);      
                
            int i=pstmt.executeUpdate();    
                
            if(i>0)    
            {    
            out.println("Values Inserted Successfully");    
            }    
                
        }    
        catch(Exception e)    
        {    
                System.out.println(e);  
        }    
                
    }    
        
    

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
