/*
 * Author: Thomas, Lindley
 * Project: CMSC 350 Project 4
 * Date: 10/13/2020
 * Class Description: This class creates a graph with an alternate adjacency list representation. Also contains a
 * Depth search first method that is meant to check if a cyclic dependency is present. Also contains a method that
 * returns a string representation of the graph to test my incomplete programs partial functionality.
 */

public class DirectedGraph<T> {
    Vertex vertices;

    public class Vertex {
        T value;
        Vertex linkVert;
        Edge linkEdge;
        boolean wasVisited;
        boolean recursive;
        boolean cycleDetected;

        Vertex(T input) {
            value = input;
            linkVert = null;
            wasVisited = false;
            cycleDetected = false;
            linkEdge = null;
            recursive = false;
        }
    }

    public class Edge {
        Vertex vert;
        Edge linkEdge;

        Edge(Vertex a) {
            vert = a;
            linkEdge = null;
        }
    }

    DirectedGraph() {
        vertices = null;
    }

    public Vertex addVertex(T input) {
        if (vertices == null) {
            vertices = new Vertex(input);
            return vertices;
        } else {
            Vertex temp = vertices;
            while (temp.linkVert != null) {
                temp = temp.linkVert;
            }
            temp.linkVert = new Vertex(input);
            return temp.linkVert;
        }
    }

    public void addEdge(T vertex, T edge) {
        Vertex addEdgesTo = null;
        Vertex edges = null;
        if(vertices == null){
            vertices = new Vertex(vertex);
        }
        Vertex temp = vertices;
        while (temp != null) {
            if (temp.value.equals(vertex)) {
                addEdgesTo = temp;
            }
            if (temp.value.equals(edge)) {
                edges = temp;
            }
            if (addEdgesTo != null && edges != null) {
                break;
            }
            temp = temp.linkVert;
        }
        if (addEdgesTo == null) {
            addEdgesTo = addVertex(vertex);
        }
        if (edges == null){
            edges = addVertex(edge);
        }
        if (addEdgesTo.linkEdge == null) {
            addEdgesTo.linkEdge = new Edge(edges);
        } else {
            Edge tempEdge = addEdgesTo.linkEdge;
            while (tempEdge.linkEdge != null) {
                tempEdge = tempEdge.linkEdge;
            }
            tempEdge.linkEdge = new Edge(edges);
        }
    }
    public void cycleDetected(){
        for (Vertex i = vertices; i != null; i = i.linkVert){
            i.wasVisited = false;
            i.recursive = false;
        }
        for (Vertex i = vertices; i != null; i = i.linkVert){
            depth_first_search(i);
        }
    }
    public void depth_first_search(Vertex s) {
        if(s.wasVisited == true){
            return;
        }
        s.wasVisited = true;
        s.recursive = true;
        for(Edge i = s.linkEdge; i != null; i = i.linkEdge){
            if(i.vert.recursive == true){
                s.cycleDetected = true;
            }
            depth_first_search(i.vert);
        }
        s.recursive = false;
    }

    public void string() {
        Vertex temp = vertices;
        while (temp != null) {
            System.out.println(temp.value + " " + "Cycle Detected: " + (temp.cycleDetected));
            for (Edge i = temp.linkEdge; i != null; i = i.linkEdge) {
                System.out.println("EDGE: " + i.vert.value);
            }
            temp = temp.linkVert;
        }
    }
}
