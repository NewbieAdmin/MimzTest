package newbie.base.leetcode.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * 按序打印
 * 执行顺序 1 -> 2 -> 3
 */
public class PrintInOrder {

    /**
     * 方法1：
     * 单机并发 使用内存可见变量 控制可见变量数值 即可实现

    private volatile int count;

    public PrintInOrder() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        count++;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (count != 1) {}
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        count++;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (count != 2) {}
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        count = 0;
    }
     */

    /**
     * 方法2:
     * 使用CountDownLatch计数器：
     * 控制线程执行顺序
     */

    // 创建计数器1 控制second线程
    private final CountDownLatch second = new CountDownLatch(1), third = new CountDownLatch(1);

    public PrintInOrder() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        second.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        second.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        third.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        third.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
