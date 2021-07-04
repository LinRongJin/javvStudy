package com.cookie.day01;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetCookie extends HttpServlet {
    @Override
    public void init() throws ServletException {

    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            System.out.printf("key: %s value: %s \n",cookie.getName(),cookie.getValue());
        }
    }

    @Override
    public void destroy() {

    }
}
