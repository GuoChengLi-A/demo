import java.util.concurrent.*;

public class Foo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
       /* boolean flag = true;
        if (flag) {
            System.out.println("Hello, Java!");
        }
        if (flag == true) {
            System.out.println("Hello, JVM!");
        }*/
//        Properties properties = System.getProperties();
//        properties.entrySet().forEach(System.out::println);
        LazyLoadSingleton instance = LazyLoadSingleton.getInstance(10);
        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 10; i++) {
            FutureTask<Integer> futureTask = new FutureTask<>(() -> {
                synchronized (instance) {
                    instance.setCount(instance.getCount() + 1);
                    System.out.println(Thread.currentThread().getName() + ":" + instance.getCount());
                    return instance.getCount();
                }
            });
            executor.submit(futureTask);
            /*executor.submit(new Runnable() {
                @Override
                public void run() {
                    synchronized (instance) {
                        instance.setCount(instance.getCount() + 1);
                        System.out.println(Thread.currentThread().getName() + ":" + instance.getCount());
                    }
                }
            });*/
        }
//        System.out.println(Thread.currentThread().getName());
      /*  executor.submit(task);
        System.out.println(Thread.currentThread().getName()+":"+instance.getCount());

        executor.submit(task);
        System.out.println(Thread.currentThread().getName()+":"+instance.getCount());*/
        executor.shutdown();
    }
}

/**
 * @Description: 延迟加载单例模式
 */
class LazyLoadSingleton {
    private Integer count;

    private LazyLoadSingleton(int count) {
        this.count = count;
    }

    private static LazyLoadSingleton lazyLoadSingleton;

    public static LazyLoadSingleton getInstance(Integer count) {
        lazyLoadSingleton = new LazyLoadSingleton(count);
        return lazyLoadSingleton;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
