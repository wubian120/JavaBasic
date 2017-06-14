package cn.brady.concurrent;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Created by Brady on 2017/6/8.
 */
public class ForkJoinSecond {


    static class PiEstimateTask extends RecursiveTask<Double> {

        private final long begin;
        private final long end;

        private final long threshold;

        public PiEstimateTask(long begin, long end, long threshold){
            this.begin = begin;
            this.end = end;
            this.threshold = threshold;
        }

        @Override
        protected Double compute() {
            if(end - begin <= threshold){
                int sign = 1;
                double result = 0.0;
                for(long i=begin;i<end; i++){
                    result += sign / (i * 2.0 + 1);
                    sign = -sign;
                }
                return result *4;
            }

            long mid = (begin + end) / 2;
            PiEstimateTask left = new PiEstimateTask(begin, mid, threshold);
            PiEstimateTask right = new PiEstimateTask(mid + 1, end, threshold);

            left.fork();
            right.fork();

            double leftResult  = left.join();
            double rightResult = right.join();



            return leftResult + rightResult;
        }
    }

    public static void main(String[] args){

        ForkJoinPool pool = new ForkJoinPool(4);

        PiEstimateTask task = new PiEstimateTask(0, 1_000_000_000, 1_000_000);

        double pi = pool.invoke(task);
        System.out.println(" pai :" + pi);
        pool.shutdown();


    }

}