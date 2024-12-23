package com.example;

import Graph.Graph;
import HashTable.HashTable;


public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addEdge("A", "B");
        graph.PrintGraph();
    }
}