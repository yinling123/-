package com.example.test;

import com.example.pojo.Analysis;
import com.example.utils.Analyzing;
import com.example.utils.EasyDl;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.Java2DFrameConverter;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class label extends JFrame{

    private JLabel jl = new JLabel();

    public label() throws FrameGrabber.Exception {

        // 设置大小
        setSize(2100, 1000);
        // 居中显示
        setLocationRelativeTo(null);
        // 设置可见性
        setVisible(true);
        // 设置关闭退出
        setDefaultCloseOperation(EXIT_ON_CLOSE);




        //检测
        ShowP();
    }

    private void ShowP() throws FrameGrabber.Exception {
        //创建容器
        JPanel pa = (JPanel) getContentPane();
        pa.setLayout(null);
        //设置标签大小位置
        jl.setBounds(10, 10, 1426, 710);

        String videoPath = "D:\\CoalImage\\meiliu.mp4";
        String file_name = "coal";
        String out_directory_path = "D:\\CoalImage";
        String img_type = "jpg";

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                FFmpegFrameGrabber ff = null;
                try {
                    ff = FFmpegFrameGrabber.createDefault(videoPath);
                    ff.setOption("rtsp_transport", "tcp");
                    Java2DFrameConverter converter = new Java2DFrameConverter();
                    ff.start();
                    int i = 1;
                    while (true) {
                        // 获取每一帧的数据
                        Frame frame = ff.grabImage();
                        if (frame == null) break;
                        // 根据每帧的时间戳进行文件命名
                        //            long timestamp = frame.timestamp;
                        //            Date date = new Date();
                        //            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMddHHmmssZ");
                        //            String format = simpleDateFormat.format(date);
                        //            String curTime =simpleDateFormat.format(new Date().getTime() + timestamp);
                        // 写出图片
                        BufferedImage bi = converter.getBufferedImage(frame);
                        String out_file_name = file_name + i + "." + img_type;
                        String file_name_path = out_directory_path + File.separator + out_file_name;
                        System.out.println(file_name_path);
                        File output = new File(file_name_path);
                        try {
                            //保存图片？
                            ImageIO.write(bi, img_type, output);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        String s = EasyDl.doPostFile("http://127.0.0.1:24401/", file_name_path);
                        Analysis analyzing = Analyzing.analyzing(s);
                        if(analyzing != null) {
                            Graphics g = bi.getGraphics();
                            g.setColor(Color.RED);//画笔颜色
                            g.drawRect(analyzing.getLeft(), analyzing.getTop(), analyzing.getWidth(), analyzing.getLength());
                            try {
                                //保存图片？
                                ImageIO.write(bi, img_type, output);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        //更新窗口内图片
                        Icon c = new ImageIcon(file_name_path);
                        jl.setIcon(c);
                        i++;
                        if(i == 10){
                            i = 1;
                        }
                        System.out.println(s);
                        Thread.sleep(200);
                    }
                } catch (FrameGrabber.Exception | InterruptedException e) {
                    e.printStackTrace();

                } finally {
                    try {
                        ff.stop();
                    } catch (FrameGrabber.Exception e) {
                        e.printStackTrace();
                    }

                }
            }
        });
        thread.start();
        pa.add(jl);
    }


    public static void main(String[] args) throws FrameGrabber.Exception {

        new label();
    }
}
