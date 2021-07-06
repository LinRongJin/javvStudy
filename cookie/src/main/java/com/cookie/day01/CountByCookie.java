package com.cookie.day01;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

public class CountByCookie extends HttpServlet {
    int count = 1;
    @Override
    public void init() throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("count", "countNumber");
        Arrays.asList(req.getCookies()).forEach(cookie1 -> {
            if (Objects.equals(cookie,cookie1)){
                count++;
            }
        });
        System.out.println(count);
        req.setAttribute("count",count);
        resp.sendRedirect("count");
    }

    @Override
    public void destroy() {

    }
}
