import java.util.Scanner;

public class homework {
    // 杨辉三角
    public static void showTriangle() {
        System.out.println("请输入想要打印的等腰三角形的行数");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[][] arr = new int[n][];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[i + 1];
        }
        for (int i = 0; i < n; i++) {
            arr[i][0] = 1;
            arr[i][i] = 1;
        }
        for (int i = 2; i < n; i++) {
            for (int j = 1; j < i; j++) {
                arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int k = n - i - 1; k > 0; k--) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }

    //位数、逆序输出
    public static void reverseSUM() {
        System.out.println("请输入一个正整数");
        Scanner n = new Scanner(System.in);
        String s = n.next();
        System.out.println("您输入的正整数的位数是" + s.length());
        char[] chars = s.toCharArray();
        char temp;
        for (int i = 0; i < s.length() / 2; i++) {
            temp = chars[i];
            chars[i] = chars[s.length() - i - 1];
            chars[s.length() - i - 1] = temp;
        }
        String s1 = String.valueOf(chars);
        System.out.println(s1);
        n.close();
    }

    public static void isPalindrome(int num) {

        String str = String.valueOf(num);
        String reverse = new StringBuilder(str).reverse().toString();
        boolean flag = false;
        if(str.equals(reverse))
        {
            flag = true;
        }
        if (flag)
        {
            System.out.println("是的") ;
        }
        else
        {
            System.out.println("不是") ;
        }
    }

    public static void ShuiXianHua() {
        for(int i = 100;i<1000;i++)
        {
            int a,b,c;
            a = i/100;
            b = i/10-a*10;
            c = i - a*100-b*10;
            int sum = a*a*a+b*b*b+c*c*c;
            if(sum==i)
            {
                System.out.print(i+" ");
            }
        }
        System.out.println();
    }
    public static void arraysDemo() { //操作
        int[] a ={1,2,3,4,5,6,7,8,9,10};
        int max = a[0];
        int min = a[0];
        for(int i = 1;i<10;i++)
        {
            if(max<=a[i])
                max = a[i];
            if(min>=a[i])
                min = a[i];
        }
        System.out.println("打印两个 最值");
        System.out.println("最大值为"+max);
        System.out.println("最小值为"+min);
    }

    public static void main(String[] args) {
        //打印选择题答案
        System.out.println("1、 B ");
        System.out.println("2、 B ");
        System.out.println("3、 D ");
        System.out.println("4、 B ");
        System.out.println("5、 B ");

        //每个编程题都要调用
        showTriangle();

        reverseSUM();

        int a = 123;
        int b = 121;
        isPalindrome(a);
        isPalindrome(b);

        ShuiXianHua();

        arraysDemo();
        //思考如果函数是有返回值呢， 以及如果函数定义中没有加static还可以直接调用吗？
    }
}
