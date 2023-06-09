//package com.example.webProjectCNN_jsp;
//
//import com.example.webProjectCNN_jsp.model.Image;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
////@WebServlet("/detected")
//public class Servlet  extends HttpServlet {
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        Image image = new Image();
//
//        System.out.println("Images --- " + image.getImageName());
//        request.setAttribute("name", "Tom");
//        request.setAttribute("age", 34);
//
//        getServletContext().getRequestDispatcher("/basic.jsp").forward(request, response);
//    }
//}
