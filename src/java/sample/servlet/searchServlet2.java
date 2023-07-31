/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package sample.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.dao.PlanDAO;
import sample.dto.Plant;

/**
 *
 * @author Admin
 */
public class searchServlet2 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            String keyword = request.getParameter("txtsearch");
            String searchby = request.getParameter("searchby");
            ArrayList<Plant> list = PlanDAO.getPlants(keyword, searchby);
            //ArrayList<Plant> list = new ArrayList<>();
            if (list != null && !list.isEmpty()) {
                HttpSession session = request.getSession();
                session.setAttribute("listPlan", list);
                ServletConfig servletconfig = getServletConfig();
                String tmp2 = servletconfig.getInitParameter("lang");
                session.setAttribute("tmp2", tmp2);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
                response.sendRedirect("errorpage.html");
            }
//            String keyword = request.getParameter("txtsearch");
//            String searchby = request.getParameter("searchby");
//            String page = request.getParameter("page");
//            ArrayList<Plant> list = PlanDAO.getPlants(keyword, searchby);
//
//            //ArrayList<Plant> list = new ArrayList<>();
//            if (list != null && !list.isEmpty()) {
//                request.setAttribute("listPlan", list);
//                request.setAttribute("ERROR", "Plant not available");
//                ServletConfig servletconfig = getServletConfig();
//                String tmp2 = servletconfig.getInitParameter("lang");
//                request.setAttribute("tmp2", tmp2);
//                if ("searchPlant".equals(page)) {
//                    request.getRequestDispatcher("searchPlant.jsp").forward(request, response);
//                } else if ("ManagerPlant".equals(page)) {
//                    request.getRequestDispatcher("ManagePlant.jsp").forward(request, response);
//                }
//            } else {
//                if ("searchPlant".equals(page) && keyword != null) {
//                    request.setAttribute("ERROR", "Don't have any Plant you need");
//                    request.getRequestDispatcher("searchPlant.jsp").forward(request, response);
//                } else if ("ManagerPlant".equals(page) && keyword != null) {
//                    request.setAttribute("ERROR", "Don't have any Plant you need");
//                    request.getRequestDispatcher("ManagePlant.jsp").forward(request, response);
//                }
//
//            }
//
//        }
        }
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
    }// </editor-fold>

}
