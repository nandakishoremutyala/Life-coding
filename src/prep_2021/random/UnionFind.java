package prep_2021.random;

public class UnionFind {
    int[] parent;
    int[] rank;
    public UnionFind(){
        int N=5;
        parent=new int[]{N};
        for (int i = 0; i <N ; i++) {
            parent[i]=i;
        }
        rank=new int[N];
        for (int i = 0; i <N ; i++) {
            rank[i]=1;
        }
    }
    private void union(int i, int j){
        int x=find(i);
        int y=find(j);

        if(rank[x]>rank[y]){
            parent[y]=x;

        }else if(rank[x]<rank[y]){
            parent[x]=y;
        }else {
            parent[y] = x;
            rank[y]+=1;
        }
    }

    private int find(int i){
        while(parent[i]!=i){
            i=parent[i];
        }
        return parent[i];
    }
}
