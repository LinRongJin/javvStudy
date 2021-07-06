package com.cookie.day01.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.*;

/**
 * @author Roger
 */
public class SqlSessionFactory {
    public org.apache.ibatis.session.SqlSessionFactory sqlSessionFactory() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        return new SqlSessionFactoryBuilder().build(inputStream);

    }

    public SqlSession openSession() throws IOException {
        return sqlSessionFactory().openSession();
    }
}
