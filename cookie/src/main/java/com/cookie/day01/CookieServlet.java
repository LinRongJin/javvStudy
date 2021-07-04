package com.cookie.day01;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setContentType("text/html,charset=UTF-8");
        Cookie cookie = new Cookie("user","lihua0107");
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    @Override
    public void destroy() {

    }
}
