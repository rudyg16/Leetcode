class Solution {
    public int countComponents(int n, int[][] edges) {
        boolean [] visited = new boolean [n];
        boolean adjMatrix [][] = new boolean [n][n];

        for(int i=0;i<edges.length;i++){
            int firstVert = edges[i][0];
            int secVert = edges[i][1];//store them for easy

            if(!adjMatrix[firstVert][secVert] && !adjMatrix[secVert][firstVert]){//convert edge matrix to adjacency to do proper bfs
                adjMatrix[firstVert][secVert] = true;
                adjMatrix[secVert][firstVert] =true;
            }
        }
        int conComp = 0;
        for(int i=0;i<adjMatrix.length;i++){
            if(!visited[i]){
                conComp += BFS(visited, adjMatrix,i);
            } 
        }
        return conComp;
    }
    public int BFS(boolean [] visited, boolean adjMatrix[][], int vertex){
        Queue <Integer> queue = new LinkedList<>();
        queue.add(vertex);
        visited[vertex] = true;
        while(!queue.isEmpty()){
            int currentVertex = queue.poll();
            for(int j=0;j<adjMatrix[currentVertex].length;j++){
               if(adjMatrix[currentVertex][j] && !visited[j]){//if it does have an edge and has not been visited
                    visited[j] = true;//set it to true and add it to queue
                    queue.add(j);
               }
            }
        }
        return 1;//after connected component has been fully explored, just return 1 to mark the amount 

        
    }
}
