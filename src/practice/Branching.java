package practice;

public class Branching {
    public static void main(String[] args) {
        int search=5;
        for(int i=0;i<10;i++){
            for (int j = 0; j <10 ; j++) {
                if(i==3 &&j==5)break;
            }
            System.out.println(i);
        }

        search:{
            for(int i=0;i<10;i++){
                for (int j = 0; j <10 ; j++) {
                    if(i==3 && j==5)break search;
                }
                System.out.println(i);
            }
        }
    }
}
