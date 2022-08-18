package com.example.test;

import com.example.utils.FrameBlocking;
import org.bytedeco.javacv.FrameGrabber;

@SuppressWarnings("all")
public class FrameTest {

    public static void main(String[] args) throws FrameGrabber.Exception {
        FrameBlocking frameBlocking = new FrameBlocking();
        frameBlocking.framing("D:\\CoalImage\\meiliu.mp4","coal","D:\\CoalImage");

    }
}
