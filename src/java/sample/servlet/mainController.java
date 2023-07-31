/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package sample.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class mainController extends HttpServlet {
    private String url = "errorpage.html";
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
            // phan cua user
           String action = request.getParameter("action");
           if (action == null || action.equals("") || action.equals("search") )
               url = "index.jsp";
           else if (action.equals("Login"))
               url = "loginServlet";
           else if (action.equals("create"))
               url = "registerServlet";
           else if (action.equals("Search"))
               url = "personalPage.jsp";
           else if (action.equals("change"))
               url = "changeProfileSevlet";
           else if (action.equals("logout"))
               url = "logoutServet";
           else if (action.equals("viewcart"))
               url = "viewCart.jsp";
           else if (action.equals("addtocart"))
                url = "addToCartServlet";
           else if (action.equals("update"))
                url = "updateCartServlet";
           else if (action.equals("saveOrder")) 
               url = "saveShoppingCartServlet";
           
           
           
           // phan cua admin
           //Accounts-------------------------------
           else if(action.equals("manageAccounts"))
               url = "manageAccountsServlet";
           else if(action.equals("updateStatusAccount"))
               url="updateStatusAccountServlet";
           else if(action.equals("searchAccount"))
               url ="searchAccountServlet";
           //----------------------------------------
           
           //Plant-----------------------------------
           else if(action.equals("managePlant"))
               url="managePlantServlet";
           else if(action.equals("Update"))
               url="updatePlantServlet";
           else if(action.equals("Create"))
               url="addPlantServlet";
           else if(action.equals("Delete"))
               url="deletePlantServlet";
           else if(action.equals("searchPlant"))
               url="searchPlantServlet";
           
           //Categories----------------------------
           else if(action.equals("manageCategories"))
               url ="manageCategoriesServlet";
           else if(action.equals("searchCate"))
               url="searchCateServlet";
           else if(action.equals("UpdateC"))
               url="updateCategoriesServlet";
           else if(action.equals("DeleteC"))
               url = "deleteCateServlet";
           else if(action.equals("AddCate"))
               url ="addCateServlet";
           
           //Order-------------------------------
           else if(action.equals("manageOrder"))
               url ="manageOrderServlet";
           else if(action.equals("searchBN"))
               url ="searchBNServlet";
           else if(action.equals("SearchBD"))
               url="searchBDServlet";
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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
