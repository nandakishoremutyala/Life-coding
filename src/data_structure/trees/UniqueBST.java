package data_structure.trees;

public class UniqueBST {
    public static void main(String[] args) {
        UniqueBST uniqueBST=new UniqueBST();
        int result= uniqueBST.numTrees(3);
        System.out.println(result);
    }
    public int numTrees(int n) {

        int[] g=new int[n+1];
        g[0]=1;
        g[1]=1;

        for(int i=2;i<=n;++i){
            for (int j = 1; j <=i ; ++j) {
                g[i]+=g[j-1]*g[i-j];
            }
        }
        return g[n];
    }
}
