package com.example.test;

import com.example.utils.Util;
import org.bytedeco.javacv.FFmpegFrameRecorder;
import org.bytedeco.javacv.FrameRecorder;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;

/**
 * 测试util的pic2MovByFfmpeg方法
 */

public class PhotoTest {

    public static void main(String[] args) throws Exception {
        // 文件对象
        File file = new File("D:\\CoalImage\\coal@.jpg");
        // 文件大小；其中file.length()获取的是字节，除以1024可以得到以kb为单位的文件大小
        long size = file.length() / 1024;
        // 图片对象
        BufferedImage bufferedImage = ImageIO.read(new FileInputStream(file));
        // 宽度
        int width = bufferedImage.getWidth();
        // 高度
        int height = bufferedImage.getHeight();
        // 打印信息
        System.out.printf("图片大小：%skb；图片宽度：%s像素；图片高度：%s像素", size, width, height);
    }

    @Test
    public void test(){
        try {
            Util.pic2MovByFfmpeg("D:\\CoalImage\\meiliutest.mp4",16,10);
        } catch (FFmpegFrameRecorder.Exception e) {
            e.printStackTrace();
        }
    }
}
