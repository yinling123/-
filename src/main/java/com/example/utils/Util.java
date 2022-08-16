package com.example.utils;

import java.io.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

    //存储最新的输出流
    //ByteArrayOutputStream不需要关闭，直接面向内存，用字节数组进行读写操作
    static OutputStream outputStream1;

    /**
     *
     * @param fileUrl 文件路径
     * @param outputStream 输出流对象
     * @throws IOException
     * @function 将图片转化为字节流输入到输出流
     */
    public static void readFileByBytes(String fileUrl, OutputStream outputStream) throws IOException {

        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(fileUrl));
        byte[] bytes = new byte[1024];

        while(bufferedInputStream.read(bytes) != -1) {
            outputStream.write(bytes, 0, bytes.length);
        }

        outputStream1 = outputStream;

    }

    /**
     * @function 将刚检测完的输出流对象还原
     * @throws IOException
     */
    public static void refresh() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = (ByteArrayOutputStream) outputStream1;
        byte[] bytes = byteArrayOutputStream.toByteArray();

        FileOutputStream fileOutputStream = new FileOutputStream("D:\\projectTest\\Jdbc\\src\\img\\039.jpg");

        fileOutputStream.write(bytes);
        fileOutputStream.close();
        outputStream1.close();
    }

    public static Timestamp getCurrentTime(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        return new Timestamp(date.getTime());
    }

}
