package leetcode;

public class AddDigits {
    public static void main(String[] args) {
        AddDigits addDigits=new AddDigits();
        int result = addDigits.addDigits(38);
        System.out.println(result);
    }
    public int addDigits(int num) {
        if(num<10)return num;
        while(num>10){
            int sum=0;
            while(num>0){
                int temp=num%10;
                sum+=temp;
                num=num/10;
            }
            num=sum;
        }
        return num;
    }
}
