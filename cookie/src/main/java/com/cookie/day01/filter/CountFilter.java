package com.cookie.day01.filter;

import com.cookie.day01.mapper.CountMapper;
import com.cookie.day01.util.SqlSessionFactory;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

/**
 * @author Roger
 */
public class CountFilter implements Filter {

    static int count=0;
    boolean isIn = false;
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactory();

    public void getCount(){
        int initCount = 0;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            initCount = sqlSession.getMapper(CountMapper.class).count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        count = Math.max(initCount, 1);
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        getCount();
        System.out.println(count);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        UUID uuid = UUID.randomUUID();
        Cookie cookie = new Cookie("id", "testsssss");
        Arrays.asList(request.getCookies()).forEach(cookieItem ->{
            if (Objects.equals(cookieItem.getName(),"id") && Objects.equals(cookieItem.getValue(),"testsssss")){
                isIn = true;
            }
        });
        if (isIn){
            count++;
        }else {
            response.addCookie(cookie);
            System.out.println("add cookie: "+cookie.toString());
        }
        System.out.printf("访问了“/count”路径：%d 次\n",count);
    }

    @Override
    public void destroy() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            sqlSession.getMapper(CountMapper.class).updateCount(count);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
