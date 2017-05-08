package cn.brady.generic;

import java.util.Date;

/**
 * Created by Brady on 2017/5/5.
 */
public class BridgePairSub extends BridgePair<Date> {

    @Override
    public void setSecond(Date second) {
        if(second.compareTo(getFirst()) > 0)
            super.setSecond(second);

    }


    public static void main(String[] args) throws InterruptedException{
        BridgePairSub bps = new BridgePairSub();

        bps.setFirst(new Date());
        bps.setSecond(new Date());
        System.out.println("Second value of Date: " + bps.getSecond().toString());

        Thread.sleep(10);
        BridgePair<Date> bridgePair = bps;
        bridgePair.setSecond(new Date());

        System.out.println("Second value of Date: " + bridgePair.getSecond().toString());

    }
}
