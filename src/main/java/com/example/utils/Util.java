package com.example.utils;

import org.bytedeco.ffmpeg.global.avcodec;
import org.bytedeco.ffmpeg.global.avutil;
import org.bytedeco.javacv.FFmpegFrameRecorder;
import org.bytedeco.javacv.Java2DFrameConverter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
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

    /**
     * 获取当前时间的时间戳对象
     * @return
     */

    public static Timestamp getCurrentTime(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        return new Timestamp(date.getTime());
    }

    /**
     * 将获取的字节流转化为视频
     * @param mp4SavePath 转化后的视频存储路径
     * @param width 转化的视频的宽度
     * @param height 转化的视频的长度
     * @throws FFmpegFrameRecorder.Exception
     */

    public static void pic2MovByFfmpeg(String mp4SavePath,int width, int height) throws FFmpegFrameRecorder.Exception {
        //视频宽高最好是按照常见的视频的宽高  16：9  或者 9：16
        FFmpegFrameRecorder recorder = new FFmpegFrameRecorder(mp4SavePath, width, height);
        //设置视频编码层模式
        recorder.setVideoCodec(avcodec.AV_CODEC_ID_H264);
        //设置声音大小
        recorder.setAudioChannels(2);
        //设置视频为1帧每秒
        recorder.setFrameRate(1);
        //设置视频图像数据格式
        recorder.setPixelFormat(avutil.AV_PIX_FMT_YUV420P);
        recorder.setFormat("mp4");

        try {
            recorder.start();
            Java2DFrameConverter converter = new Java2DFrameConverter();
            int len = EasyDl.list.size();
            //循环读取数据
            for(int i = 0; i < len; i++){
                //将字节数组进行转化
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(EasyDl.list.get(i));
                BufferedImage bufferedImage = ImageIO.read(byteArrayInputStream);
                recorder.record(converter.getFrame(bufferedImage));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //最后一定要结束并释放资源
            recorder.stop();
            recorder.release();
        }
    }


}
