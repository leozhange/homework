import java.util.*;
class Book {
    private String title;
    private String author;
    private int year;
    public Book(String title, String author, int year){
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public void displayInfo(){
        System.out.println("Title:"+title+",Author:"+author+",Year:"+year);
    }
}

class Vehicle {
    public int speed;
    public int loader;
    public Vehicle(){

    }
    public Vehicle(int s,int l)
    {
        speed = s;
        loader = l;
    }

    public void wheel() {
        System.out.println("车轮的个数是:4");
    }
    public void Loader() {
        System.out.println("这是一辆车，能载4人,实载"+loader+"人");
    }
}
class Car extends Vehicle{
    public Car(int s,int l) {
        speed = s;
        loader = l;
    }
    public void Loader(){
        super.wheel();
        if(loader>=6)
            System.out.println("这是一辆小车，能载6人,实载"+loader+"人,你超员了！！！");
        else
            System.out.println("这是一辆小车，能载6人,实载"+loader+"人");
    }
}
class Truck extends Vehicle{
    public int weight;
    public Truck(int s,int l,int w) {
        speed = s;
        loader = l;
        weight = w;
    }
    public void wheel() {
        System.out.println("车轮的个数是:6");
    }
    public void Loader(){
        if(loader>=3)
            System.out.println("这是一辆卡车，能载3人,实载"+loader+"人,你超员了！！！");
        else
            System.out.println("这是一辆卡车，能载3人,实载"+loader+"人");
        if(weight>=5000)
            System.out.println("这是一辆卡车，核载5000kg，你已装载"+weight+"kg,你超载了！！！");
        else
            System.out.println("这是一辆卡车，核载5000kg，你已装载"+weight+"kg");

    }
}

class Calculator{
    private double a;
    private double b;
    public Calculator(double a,double b){
        this.a = a;
        this.b = b;
    }
    public String add(){
        return "Addition:"+(a+b);
    }
    public String subtract(){
        return "Subtraction:"+(a-b);
    }
    public String multiply(){
        return "Multiplication:"+a*b;
    }
    public String divide(){
        return  "Division:"+a/b;
    }
}

public class homeworktwo{
    public static String longest(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }


    public static void main(String[] args) {

        System.out.println("<-------第一题------->");
        Book b1 = new Book( "Java Programming", "John Smith", 2022);
        b1.displayInfo();
        System.out.println("<-------第二题------->");
        Car c1 = new Car(60,3);
        System.out.println("示例1");
        c1.Loader();
        System.out.println("-------------------");
        Truck t1 = new Truck(60,1,3000);
        t1.Loader();
        Car c2 = new Car(60,6);
        System.out.println("示例2");
        c2.Loader();
        System.out.println("--------------------");
        Truck t2 = new Truck(60,1,7000);
        t2.Loader();
        System.out.println("<-------第三题------->");
        Calculator cal = new Calculator(2.0,1.0);
        System.out.println(cal.add());
        System.out.println(cal.subtract());
        System.out.println(cal.multiply());
        System.out.println(cal.divide());
        System.out.println("<-------第四题------->");
        String[] strs1 = new String[]{"flower", "flow", "flight"};
        if(longest(strs1) == "输入不存在公共前缀。")
            System.out.println("");
        else
            System.out.println(longest(strs1));
        String[] strs2 = new String[]{"dog","racecar","car"};
        if(longest(strs2) == "")
            System.out.println("输入不存在公共前缀。");
        else
            System.out.println(longest(strs2));
    }
}