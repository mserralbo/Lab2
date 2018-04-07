/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import laboratorio.Student;
import laboratorio.ejb.StudentDAO;

/**
 *
 * @author Miriam
 */
@WebServlet(name = "StudentServlet", urlPatterns = {"/StudentServlet"})
public class StudentServlet extends HttpServlet {
 @EJB private StudentDAO studentDAO;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws controller.IllegalNameException
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ServletException {
        
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String age = request.getParameter("age");
        String group = request.getParameter("group");
        String specialty = request.getParameter("specialty");
        String operation = request.getParameter("operation");
        
        String str="  id ";
	int estId=Integer.parseInt(str.trim());
        String str1="  age ";
	int estAge=Integer.parseInt(str.trim());
        
        Student student = new Student(estId,name,surname,estAge,group,specialty);
        
        if(operation.equalsIgnoreCase("Add"))
        {
        studentDAO.addStudent(student);
        request.setAttribute("student", student);        
        } else if(operation.equalsIgnoreCase("Edit"))
        {
        studentDAO.editStudent(student);
        Student searchedStudent = studentDAO.getStudent(estId);
        request.setAttribute("student", searchedStudent); 
        }else if(operation.equalsIgnoreCase("Delete"))
        {
        studentDAO.deleteStudent(student);
        }else if(operation.equalsIgnoreCase("Search"))
        {
        Student searchedStudent = studentDAO.getStudent(estId);
        request.setAttribute("student", searchedStudent);         
        }
        request.getRequestDispatcher("studentInfo.jsp").forward(request, response);
              
        }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
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
     *
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
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// 
}

    