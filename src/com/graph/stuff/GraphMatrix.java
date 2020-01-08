package com.graph.stuff;
public class GraphMatrix {
    private boolean adjMat[][];
    private int numOfV;

    public GraphMatrix(int i) {
        this.numOfV = i;
        adjMat = new boolean[i][i];
    }

    public void addEdge(int i, int j) {
        adjMat[i][j] = true;
        adjMat[j][i] = true;
    }

    public void remove(int i, int j) {
        adjMat[i][j] = false;
        adjMat[j][i] = false;
    }
    public boolean isEdge(int i,int j){
        return adjMat[i][j];
    }

}