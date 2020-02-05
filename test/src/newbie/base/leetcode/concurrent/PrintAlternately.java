package newbie.base.leetcode.concurrent;

import java.util.concurrent.Semaphore;

/**
 * 交替打印
 * 顺序打印n个FooBar
 */
public class PrintAlternately {

    /**
     * 使用信号标
     * 初始化为1 可以直接执行，初始化为0 需要等待释放后执行
     *
     * 同样可以使用CountDownLatch、原子可见性：volatile、AtomicInteger等
     */
    private final Semaphore fooSem = new Semaphore(1);
    private final Semaphore barSem = new Semaphore(0);
    private int n;

    public PrintAlternately(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            fooSem.acquire(); // foo信号标获取执行 初始化为1 可执行
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            barSem.release(); // bar信号标释放1
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            barSem.acquire(); // bar信号标获取执行 初始化为0 不可执行
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            fooSem.release(); // foo信号标释放1
        }
    }

}
