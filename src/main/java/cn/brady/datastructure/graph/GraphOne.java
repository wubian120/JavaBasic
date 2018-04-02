package cn.brady.datastructure.graph;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/***
 *
 *   copy code
 *   2018-03-24
 *  https://blog.csdn.net/u010425776/article/details/70140657
 */
public class GraphOne {








    public GraphOne(){

    }

    public static class Vertex<T extends  Comparable<T>> implements Comparable<Vertex<T>> {

        private T value = null;
        private int weight = 0;
        private List<Edge<T>> edges = new ArrayList<>();

        public Vertex(T value){
            this.value = value;
        }

        public Vertex(T value, int weight){
            this.value = value;
            this.weight = weight;
        }


        @Override
        public int hashCode() {
            final  int code = value.hashCode() + weight + edges.size();
            return 31 * code;
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }

        @Override
        public int compareTo(Vertex<T> o) {
            return 0;
        }
    }

    public static class Edge<T extends Comparable<T>> implements Comparable<Edge<T>> {



        @Override
        public int compareTo(Edge<T> o) {
            return 0;
        }
    }

}
