package cn.brady.leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DynamicProgramming {

    public List<Integer> exists=new ArrayList<Integer>();
    public List<Integer> remove=new ArrayList<Integer>();
    public List<Integer> total=new ArrayList<Integer>();
    public double[][] routeMap;
    public Map<Integer, Double> distance=new HashMap<Integer, Double>();
    public Map<Integer, Integer> parentNode=new HashMap<Integer,Integer>();
    public void init(double[][] routeMap,int length)
    {
        this.routeMap=routeMap;
        for(int i=0;i<length;i++)
        {
            this.total.add(i);
            if(i!=0)
            {
                this.remove.add(i);
                this.distance.put(i, Double.MAX_VALUE-1);
            }
            else
            {
                this.exists.add(i);
                this.distance.put(i, 0.0);
                this.parentNode.put(i,-1);
            }
        }
    }
    public void programm()
    {
        while(remove.size()!=0)
        {
            int start=exists.get(exists.size()-1);
            int end=-1;
            for(int i=0;i<remove.size();i++)
            {
                end=remove.get(i);
                if(routeMap[start][end]+distance.get(start)<=distance.get(end) && routeMap[start][end]!=-1)
                {
                    distance.put(end, routeMap[start][end]+distance.get(start));
                    parentNode.put(end, start);
                }
            }
            double minroute=Double.MAX_VALUE;
            int minIndex=-1;
            for(int i=0;i<remove.size();i++)
            {
                if(minroute>distance.get(remove.get(i)))
                {
                    minIndex=i;
                    minroute=distance.get(remove.get(i));
                }
            }
            exists.add(remove.get(minIndex));
            remove.remove(minIndex);

        }
    }
    public static void main(String[] args)
    {
        double[][] route={{0,6,3,-1,-1,-1},{-1,-1,0,5,-1,-1},{-1,2,0,3,4,-1},{-1,-1,-1,0,2,3},{-1,-1,-1,-1,0,5},{-1,-1,-1,-1,-1,0}};
        DynamicProgramming dynamicProgramming=new DynamicProgramming();
        dynamicProgramming.init(route, 6);
        dynamicProgramming.programm();
        System.out.println(dynamicProgramming.distance);
        System.out.println(dynamicProgramming.parentNode);
    }
}
