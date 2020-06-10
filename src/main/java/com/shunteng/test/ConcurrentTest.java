package com.shunteng.test;

import java.util.List;
import java.util.concurrent.*;

import static java.util.Arrays.asList;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/5/25 上午9:27
 */
public class ConcurrentTest {

    static class sum implements Callable<Long> {

        private final long from;
        private final long to;

        sum(long from, long to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public Long call() throws Exception {
            long acc = 0L;
            for (long i = from; i <= to; i++) {
                acc += i;
            }
            return acc;
        }

        public static void main(String[] args) {
            ExecutorService executorService = Executors.newFixedThreadPool(2);
            List<Future<Long>> results = null;
            try {
                results = executorService.invokeAll(asList(new sum(0, 10), new sum(100, 1_000), new sum(10_000, 1_000_000)));
            } catch (Exception e) {
                e.printStackTrace();
            }
            executorService.shutdown();
            results.forEach(e -> {
                try {
                    System.out.println(e.get());
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            });
        }

    }

}