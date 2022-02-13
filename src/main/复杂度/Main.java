package 复杂度;

/// 菲波那切数列求第n项的值
public class Main {
    public static void main(String[] args) {
        int n = 6;
        System.out.println("第"+n+"项的值是："+fib(n));
    }


    //递归
    public static final int fib(int n){
        if(n<2) return  n;
        return fib(n-1)+fib(n-2);
    }

}

