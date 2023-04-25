import java.util.*;

public class Graph<T> {
    public class Edge<T>{
        T dest;
        int weight;
        Edge next;

        public Edge(T dest, int weight) {
            this.dest = dest;
            this.weight = weight;
            this.next = null;
        }
        public T getDestination() {
            return dest;
        }
        public int getWeight() {
            return weight;
        }
    }

    private Map<T, List<Edge>> AdjList;

    Graph(){
        this.AdjList = new HashMap<>();
    }
    public Map<T, List<Edge>> getAdjList() {
        return AdjList;
    }
    public void addNode(T node) {
        AdjList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(T source, T destination, int weight) {
        Edge edge1 = new Edge(destination, weight);
        AdjList.get(source).add(edge1);
        Edge edge2 = new Edge(source, weight);
        AdjList.get(destination).add(edge2);
    }
    public List<Edge> getNeighbors(T node) {
        return AdjList.get(node);
    }
    public void printAdjList() {
        for (T node : AdjList.keySet()) {
            System.out.print(node + ": ");
            List<Edge> edges = AdjList.get(node);
            for (Edge edge : edges) {
                System.out.print("(" + edge.getDestination() + ", " + edge.getWeight() + ") ");
            }
            System.out.println();
        }
    }

}
