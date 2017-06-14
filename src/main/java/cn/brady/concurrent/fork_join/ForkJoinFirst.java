package cn.brady.concurrent.fork_join;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * Fork Join
 * example from below url:
 * https://my.oschina.net/u/2011321/blog/651097
 * Created by Brady on 2017/6/8.
 */
public class ForkJoinFirst {

    public static void main(String[] args){

        ForkJoinPool forkJoinPool = new ForkJoinPool();

        // add form 1 to 4;
        CountTask task = new CountTask(1, 4);
        Future<Integer> result = forkJoinPool.submit(task);
        try{
            System.out.println(result.get());
        }catch (InterruptedException e){
            e.printStackTrace();
        }catch (ExecutionException e){
            e.printStackTrace();
        }

        if(task.isCompletedAbnormally()){
            System.out.println(task.getException());
        }

    }

}

//output : 10;

class CountTask extends RecursiveTask<Integer>{

    private static final int THREADSHOLD = 2;
    private int start;
    private int end;

    public CountTask(int s, int e){
        start = s;
        end   = e;
    }



    @Override
    protected Integer compute() {

        int sum = 0;
        boolean canCompute = (end - start) <= THREADSHOLD;
        if(canCompute){
            for(int i=start; i<=end; i++){
                sum += i;
            }
        }else {
            int mid = (start + end) / 2;
            CountTask left = new CountTask(start, mid);
            CountTask right = new CountTask(mid + 1,  end);

            left.fork();
            right.fork();
            int leftResult  = left.join();
            int rightResult = right.join();

            sum = leftResult + rightResult;
        }

        return sum;
    }

}