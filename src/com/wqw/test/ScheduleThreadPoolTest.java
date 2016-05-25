package com.wqw.test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleThreadPoolTest {


    private static long lastTime = 0;

    /**
     * �����ϴ�λ�õ�״̬
     */
    private static void refreshUploadPosStatus() {
        ScheduledExecutorService  mReportExecutor = Executors.newSingleThreadScheduledExecutor();

        /**
         * �ϱ�����ʱ����߳�
         */
        ScheduledExecutorService  mDurationExecutor = Executors.newSingleThreadScheduledExecutor();
        mReportExecutor.shutdownNow();
        mDurationExecutor.shutdownNow();
   
        lastTime = System.currentTimeMillis();
        mReportExecutor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("send  interval is " + (System.currentTimeMillis() - lastTime)/1000);
                lastTime = System.currentTimeMillis();
            }
        }, 1, 10, TimeUnit.SECONDS);

        mDurationExecutor.schedule(new Runnable() {
            @Override
            public void run() {

            }
        }, 60, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        refreshUploadPosStatus();
    }
}
