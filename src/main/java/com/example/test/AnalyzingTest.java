package com.example.test;

import com.example.utils.Analyzing;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AnalyzingTest {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        Analyzing analyzing = new Analyzing();
        System.out.println(analyzing.analyzing(s));
    }
}
