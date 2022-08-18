package com.example.test;

import com.example.utils.DruidUtils;
import org.junit.Test;

import java.sql.Connection;

public class JdbcTest {

    @Test
    public void testConnection() throws Exception {
        Connection connection = DruidUtils.getConnection();
        System.out.println(connection);
    }


}
