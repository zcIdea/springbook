package cn.tx.springboot;

import sun.awt.windows.ThemeReader;

public class ThreadTest {

    public static void main(String[] args) {
        Thread thread=new Thread();
        System.out.println(thread.getPriority());

        Thread thread1=new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getPriority()+"==="+Thread.currentThread().getName());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread1.setPriority(6);
        thread1.start();

        System.out.println("main".equals(Thread.currentThread().getName()));

        Thread thread2=new Thread(){
            @Override
            public void run() {
                System.out.print(Thread.currentThread().getName());
                System.out.println(Thread.currentThread()==this);
            }
        };
        thread2.start();


    }
}
