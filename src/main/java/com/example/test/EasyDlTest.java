package com.example.test;

import com.example.Thread.ThreadPool;
import org.bytedeco.javacv.FrameRecorder;

public class EasyDlTest {

    public static void main(String[] args) throws FrameRecorder.Exception {
        ThreadPool.startFrame();
        ThreadPool.startOne();
    }
}
