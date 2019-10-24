package data_structure.graph.shortest_path;

import java.util.*;

public class DijkstraSP {

    static class Vertex {
        final String name;
        Edge[] adjacency;
        double minDistance = Double.POSITIVE_INFINITY;
        Vertex previous;

        Vertex(String argName) {
            name = argName;
        }

        public String toString() {
            return name;
        }
    }


    static class Edge {
        public final Vertex target;
        final double weight;

        Edge(Vertex argTarget, double argWeight) {
            target = argTarget;
            weight = argWeight;
        }
    }

    public static void computePaths(Vertex source) {
        source.minDistance = 0.;
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<>((v1, v2) -> {
            if (v2.minDistance > v1.minDistance) return -1;
            else if (v1.minDistance > v2.minDistance) return 1;
            else return 0;
        });
        vertexQueue.add(source);

        while (!vertexQueue.isEmpty()) {
            Vertex u = vertexQueue.poll();

            // Visit each edge exiting u
            for (Edge e : u.adjacency) {
                Vertex v = e.target;
                double weight = e.weight;
                double distanceThroughU = u.minDistance + weight;
                if (distanceThroughU < v.minDistance) {
                    vertexQueue.remove(v);
                    v.minDistance = distanceThroughU;
                    v.previous = u;
                    vertexQueue.add(v);
                }
            }
        }
    }

    public static List getShortestPathTo(Vertex target) {
        List path = new ArrayList();
        for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
            path.add(vertex);

        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        // mark all the vertices
        Vertex A = new Vertex("A");
        Vertex B = new Vertex("B");
        Vertex D = new Vertex("D");
        Vertex F = new Vertex("F");
        Vertex K = new Vertex("K");
        Vertex J = new Vertex("J");
        Vertex M = new Vertex("M");
        Vertex O = new Vertex("O");
        Vertex P = new Vertex("P");
        Vertex R = new Vertex("R");
        Vertex Z = new Vertex("Z");

        // set the edges and weight
        A.adjacency = new Edge[]{new Edge(M, 8)};
        B.adjacency = new Edge[]{new Edge(D, 11)};
        D.adjacency = new Edge[]{new Edge(B, 11)};
        F.adjacency = new Edge[]{new Edge(K, 23)};
        K.adjacency = new Edge[]{new Edge(O, 40)};
        J.adjacency = new Edge[]{new Edge(K, 25)};
        M.adjacency = new Edge[]{new Edge(R, 8)};
        O.adjacency = new Edge[]{new Edge(K, 40)};
        P.adjacency = new Edge[]{new Edge(Z, 18)};
        R.adjacency = new Edge[]{new Edge(P, 15)};
        Z.adjacency = new Edge[]{new Edge(P, 18)};


        computePaths(A); // run Dijkstra
        System.out.println("Distance to " + Z + ": " + Z.minDistance);
        List path = getShortestPathTo(Z);
        System.out.println("Path: " + path);
    }

}
