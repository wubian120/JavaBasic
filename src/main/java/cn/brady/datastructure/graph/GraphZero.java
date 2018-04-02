package cn.brady.datastructure.graph;


import java.util.ArrayList;

/***
 * graph  adjcent list
 * 2018-03-24
 *
 * this is a copy code
 */

public class GraphZero {

    private ArrayList vertexList;

    private int[][] edges;
    private int numOfEdges;

    public GraphZero(int n){
        this.numOfEdges = 0;
        edges = new int[n][n];
        vertexList = new ArrayList(n);
    }


    public int getNumOfVertex(){
        return vertexList.size();
    }

    public int getNumOfEdges(){
        return this.numOfEdges;
    }


}
