package com.gaewoodi.bookstore.controller.mypage;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping("/cart")
public class Cart extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cookie[] cookies = request.getCookies();
        String commit = (String) request.getParameter("commit");
        String cart = "";

        if(cookies != null) {
            for(Cookie c : cookies) {
                if(c.getName().equals("cart")) {
                    cart = c.getValue();
                    break;
                }
            }
        }

        if(commit != null) {
            PrintWriter out =  response.getWriter();
            out.println(cart);
        }else {
            String product = request.getParameter("product");
            cart += product + "/";
            Cookie cartCookie = new Cookie("cart", cart);
            response.addCookie(cartCookie);
            response.sendRedirect("book_test.html");
        }
    }
}
