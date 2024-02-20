import java.util.Scanner;

class Add implements Compute{
    public Add() {
    }
    public int computer(int n, int m) {
        return m+n;
    }
}

class Subtract implements Compute{
    public Subtract() {
    }

    public int computer(int n, int m) {
        return n-m;
    }
}
class Multiply implements Compute{
    public Multiply() {
    }
    public int computer(int n, int m) {
        return m*n;
    }
}
class Except implements Compute{
    public Except() {
    }
    public int computer(int n, int m) {
        return n/m;
    }
}
class UseCompute {
    public UseCompute() {
    }

    public void useCom(Compute com, int one, int two) {
        double i = com.computer(one, two);
        System.out.println("计算结果为：" + i);
    }
}

class Employee {
    private String name;
    private int number;
    private MyDate birthday;

    public Employee(String name, int number, MyDate birthday) {
        this.name = name;
        this.number = number;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }
    public String toString() {
        return "name='" + name + '\'' + ", number=" + number + ", birthday=" + birthday.toDateString();
    }
}
class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String toDateString() {

        return year + "年" + month + "月" + day + "日";
    }
}

    public class homeworkthree {

        private static int contrast(String str, String word) {
            int i = 0;
            int j = 0;
            while (i < str.length() && j < word.length()) {
                if (str.charAt(i) == word.charAt(j)) {
                    j++;
                }
                i++;
            }
            if (j == word.length()) {
                System.out.println(word);
                return 1;
            } else {
                return 0;
            }
        }


        public static void main(String[] args) {
            System.out.println("第一题");
            Compute add = new Add();
            Compute sub = new Subtract();
            Compute mul = new Multiply();
            Compute exc = new Except();
            UseCompute Use = new UseCompute();
            Use.useCom(add, 1, 2);
            Use.useCom(sub, 1, 2);
            Use.useCom(mul, 1, 2);
            Use.useCom(exc, 1, 2);


            System.out.println("第二题");
            Scanner a=new Scanner(System.in);
            System.out.println("请输入成绩");
            try {
                int score=a.nextInt();
                if(score<0||score>100) {
                    throw new Exception();
                }else System.out.println("成绩："+score);
            }catch(Exception e) {
                System.out.println("分数必须在 0—100 之间");
            }


            System.out.println("第三题");
            Scanner input = new Scanner(System.in);
            int n;
            do {
                System.out.print("请输入一个正整数N：");
                n = input.nextInt();
                if (n < 0) {
                    System.out.println("N必须是正数或者0，请重新输入。");
                }
            } while (n < 0);
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                System.out.print("请输入第" + (i + 1) + "个整数：");
                nums[i] = input.nextInt();
            }
            try {
                double sum = 0.0;
                for (int num : nums) {
                    sum += num;
                }
                double avg = sum / n;
                System.out.println("这" + n + "个数的平均值为：" + avg);
            } catch (ArithmeticException e) {
                System.out.println("除数不能为零！");
            }

            System.out.println("第四题");
            Employee employees= new Employee("zhangsan",1,new MyDate(2016,5,21));
            System.out.println(employees.toString());

            System.out.println("第五题");
            String str = "abcde";
            String wordsStr = "a, bb,acd,ace";
            String[] words = wordsStr.split(",");
            int sum = 0;
            for (int i = 0; i < words.length; i++) {
                int indx = contrast(str,words[i]);//做字符串的匹配，如果能匹配到则返回1，否则返回0
                if (indx == 1){
                    sum++;
                }
            }
            System.out.println(sum);
        }
    }

