package cn.brady.datastructure.graph;


import java.util.ArrayList;
import java.util.Hashtable;

/***
 *
 *
 * https://github.com/malty-bcedu/Graph/blob/master/src/Graph.java
 * 2018-03-25
 */
public class GraphTwo<T> {

    protected Hashtable<Vertex<T>, ArrayList<Edge<T>>> adjacentList = null;
    protected Hashtable<Vertex<T>, Vertex<T>> connectedComponents = null;



    public class Edge<T>{

        private Vertex<T> v1;
        private Vertex<T> v2;

        public Edge(Vertex<T> v1,Vertex<T> v2)throws NullPointerException{

            if(v1 == null || v2 == null){
                throw new NullPointerException();
            }
            this.v1 = v1;
            this.v2 = v2;
        }

        public Vertex<T> getV1(){
            return v1;
        }

        public Vertex<T> getV2() {
            return v2;
        }

        public Vertex<T> getAdjacentVertex(Vertex<T> v){

            if(v1 == v){
                return v2;
            }else if(v2 == v){
                return v1;
            }else {
                return null;
            }
        }

        public boolean equals(Edge<T> e){
            if(v1 == e.v1 && v2 == e.v2){
                return true;
            }else if(v1 == e.v2 && v2 == e.v1){
                return true;
            }

            return false;
        }

        @Override
        public String toString() {
            return v1.toString()+ " , " + v2.toString();
        }
    }


    public class Vertex<T>{

        private T data;

        private boolean visited;
        private Vertex<T> parent;

        public Vertex(T value){
            this.data = value;
            visited = false;
            parent = null;
        }

        public void setData(T data) {
            this.data = data;
        }

        public T getData(){
            return data;
        }


        public boolean isVisited() {
            return visited;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }

        public Vertex<T> getParent() {
            return parent;
        }

        public void setParent(Vertex<T> parent) {
            this.parent = parent;
        }



        public boolean equals(Vertex<T> vertex) {
            return data.equals(vertex.getData());
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }


}
