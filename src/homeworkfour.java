import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class homeworkfour {
    static int reverse(int x){
        if(x==0)return x;
        int a1=x;
        int n=0;//多少位
        int b=0;
        int[] a2=new int[10];
        while(a1!=0) {
            a2[n++]=a1%10;
            a1/=10;
            if(n==9&&a1!=0) {
                if(Math.abs(a2[0])>2){return 0;}
                else if(Math.abs(a2[0])<2)continue;
                else if(Math.abs(a2[1])>1){return 0;}
                else if(Math.abs(a2[1])<1)continue;
                else if(Math.abs(a2[2])>4){return 0;}
                else if(Math.abs(a2[2])<4)continue;
                else if(Math.abs(a2[3])>7){return 0;}
                else if(Math.abs(a2[3])<7)continue;
                else if(Math.abs(a2[4])>4){return 0;}
                else if(Math.abs(a2[4])<4)continue;
                else if(Math.abs(a2[5])>8){return 0;}
                else if(Math.abs(a2[5])<8)continue;
                else if(Math.abs(a2[6])>3){return 0;}
                else if(Math.abs(a2[6])<3)continue;
                else if(Math.abs(a2[7])>6){return 0;}
                else if(Math.abs(a2[7])<6)continue;
                if(Math.abs(a2[8])>4)
                {return 0;}
                else if(Math.abs(a2[8])<4)continue;
                else{
                    if(a1>0){
                        if(a1>7)return 0;}
                    else if(a1<-8)
                        return 0;
                }
            }
        }

        while(x%10==0) {
            x/=10;
            n--;
        }
        while(x!=0) {
            b+=Math.pow(10, n-1)*(x%10);
            x/=10;
            n--;
        }
        return b;
    }
    static int climbStairs(int n) {
        if( n == 1 || n == 0 )
            return 1;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Integer l = nums.length;
        int n = (int) Math.pow(2, l); //结果集个数

        for (int i = 0; i<n; i++) {
            String s = Integer.toBinaryString(i); //二进制字符串
            List<Integer> temp = new ArrayList<>();
            for (int j = s.length() - 1; j >= 0; j--) {
                if (s.charAt(j) == '1') {
//                    System.out.println("j:"+j);
                    temp.add(nums[s.length()-1-j]); //索引数组下标
                }
            }
            result.add(temp);
        }
        return result;
    }

    public static void main(String[] arg){
        System.out.println("第一题");
        Scanner a  = new Scanner(System.in);
        System.out.println("请输入一个数字");
        int x = a.nextInt();
        int num = reverse(x);
        System.out.println(num);
        System.out.println("第二题");
        System.out.println("请输入台阶数");
        Scanner b  = new Scanner(System.in);
        int n = a.nextInt();
        int count = climbStairs(n);
        System.out.println(count);
        System.out.println("第三题");
        int[] nums = {1,2,3};
        List<List<Integer>> res = subsets(nums);
        for (List<Integer> re : res) {
            System.out.println(re);
        }


        System.out.println("MYSQl的答案");
        System.out.println("1.\n" +
                "CREATE TABLE cqupt_student (\n" +
                "    studentid VARCHAR(10),\n" +
                "    name VARCHAR(20),\n" +
                "    sex VARCHAR(2),\n" +
                "    age INTEGER,\n" +
                "    Fee DECIMAL(10,2),\n" +
                "    address VARCHAR(50),\n" +
                "    memo VARCHAR(300)\n" +
                ");\n" +
                "\n" +
                "2.\n" +
                "CREATE TABLE CourseAa (\n" +
                "    Aa1 VARCHAR(20),\n" +
                "    Aa2 INTEGER,\n" +
                "    Aa3 DECIMAL(10)\n" +
                ");\n" +
                "\n" +
                "3.\n" +
                "CREATE TABLE CourseBb (\n" +
                "    Bb1 VARCHAR(30),\n" +
                "    Bb2 INTEGER,\n" +
                "    Bb3 DECIMAL(6)\n" +
                ");\n" +
                "\n" +
                "4.\n" +
                "ALTER TABLE ChooseBb\n" +
                "ADD Bb4 VARCHAR(20) NOT NULL DEFAULT '系统测试值';\n" +
                "\n" +
                "5.\n" +
                "ALTER TABLE ChooseBb\n" +
                "ADD Bb5 VARCHAR(10),\n" +
                "ADD CONSTRAINT PK_ChooseBb PRIMARY KEY (Bb5);\n" +
                "\n" +
                "6.\n" +
                "CREATE VIEW View_Choosebb AS\n" +
                "SELECT Bb1 AS View_bb1, Bb4 AS View_bb2, Bb5 AS View_bb3\n" +
                "FROM ChooseBb;\n" +
                "\n" +
                "7.\n" +
                "DROP VIEW View_Choosebb;\n" +
                "\n" +
                "8.\n" +
                "CREATE INDEX Index_bb2 ON ChooseBb (Bb2 ASC);\n" +
                "CREATE INDEX Index_bb4 ON ChooseBb (Bb4 DESC);\n" +
                "\n" +
                "9.\n" +
                "DROP INDEX Index_bb2 ON ChooseBb;\n" +
                "\n" +
                "10.\n" +
                "CREATE TABLE test (\n" +
                "    Name VARCHAR(20),\n" +
                "    Age INTEGER,\n" +
                "    Score NUMERIC(10,2),\n" +
                "    Address VARCHAR(60)\n" +
                ");\n" +
                "\n" +
                "11.\n" +
                "INSERT INTO test (Name, Age, Score, Address) VALUES\n" +
                "('赵一', 20, 580.00, '重邮宿舍12-3-5'),\n" +
                "('钱二', 19, 540.00, '南福苑5-2-9'),\n" +
                "('孙三', 21, 555.50, '学生新区21-5-15'),\n" +
                "('李四', 22, 505.00, '重邮宿舍8-6-22'),\n" +
                "('周五', 20, 495.50, '学生新区23-4-8'),\n" +
                "('吴六', 19, 435.00, '南福苑2-5-12');\n" +
                "\n" +
                "12.\n" +
                "CREATE TABLE test_temp (\n" +
                "    Name VARCHAR(20),\n" +
                "    Age INTEGER,\n" +
                "    Score NUMERIC(10,2),\n" +
                "    Address VARCHAR(60)\n" +
                ");\n" +
                "\n" +
                "13.\n" +
                "INSERT INTO test_temp (Name, Age, Score, Address) VALUES\n" +
                "('郑七', 21, 490.50, '重邮宿舍11-2-1'),\n" +
                "('张八', 20, 560.00, '南福苑3-3-3'),\n" +
                "('王九', 10, 515.00, '学生新区19-7-1');\n" +
                "\n" +
                "14.\n" +
                "INSERT INTO test (Name, Age, Score, Address)\n" +
                "SELECT Name, Age, Score, Address\n" +
                "FROM test_temp;\n" +
                "\n" +
                "15.\n" +
                "UPDATE test\n" +
                "SET Score = Score + 5\n" +
                "WHERE Age <= 20;\n" +
                "\n" +
                "16.\n" +
                "UPDATE test\n" +
                "SET Age = Age - 1\n" +
                "WHERE Address LIKE '%南福苑%';\n" +
                "\n" +
                "17.\n" +
                "DELETE FROM test\n" +
                "WHERE Age >= 21 AND Score >= 500;\n" +
                "\n" +
                "18.\n" +
                "DELETE FROM test\n" +
                "WHERE Score < 550 AND Address LIKE '%重邮宿舍%';\n" +
                "\n" +
                "19.\n" +
                "CREATE TABLE Student (\n" +
                "    Sno VARCHAR(20),\n" +
                "    Name VARCHAR(10),\n" +
                "    Age INTEGER,\n" +
                "    College VARCHAR(30)\n" +
                ");\n" +
                "\n" +
                "20.\n" +
                "CREATE TABLE Course (\n" +
                "    CourseID VARCHAR(15),\n" +
                "    CourseName VARCHAR(30),\n" +
                "    CourseBeforeID VARCHAR(15)\n" +
                ");\n" +
                "\n" +
                "21.\n" +
                "CREATE TABLE Choose (\n" +
                "    Sno VARCHAR(20),\n" +
                "    CourseID VARCHAR(30),\n" +
                "    Score DECIMAL(5,2)\n" +
                ");\n" +
                "\n" +
                "22.\n" +
                "INSERT INTO Student (Sno, Name, Age, College) VALUES\n" +
                "('S00001', '张三', 20, '计算机学院'),\n" +
                "('S00002', '李四', 19, '通信学院'),\n" +
                "('S00003', '王五', 21, '计算机学院');\n" +
                "\n" +
                "23.\n" +
                "INSERT INTO Course (CourseID, CourseName, CourseBeforeID) VALUES\n" +
                "('C1', '计算机引论', NULL),\n" +
                "('C2', 'C语言', 'C1'),\n" +
                "('C3', '数据结构', 'C2');\n" +
                "\n" +
                "24.\n" +
                "INSERT INTO Choose (Sno, CourseID, Score) VALUES\n" +
                "('S00001', 'C1', 95),\n" +
                "('S00001', 'C2', 80),\n" +
                "('S00001', 'C3', 84),\n" +
                "('S00002', 'C1', 80),\n" +
                "('S00002', 'C2', 85),\n" +
                "('S00003', 'C1', 78),\n" +
                "('S00003', 'C3', 70);\n" +
                "\n" +
                "25.\n" +
                "SELECT Sno, Name\n" +
                "FROM Student\n" +
                "WHERE College = '计算机学院';\n" +
                "\n" +
                "26.\n" +
                "SELECT *\n" +
                "FROM Student\n" +
                "WHERE Age BETWEEN 20 AND 23;\n" +
                "\n" +
                "27.\n" +
                "SELECT COUNT(*) AS TotalStudents\n" +
                "FROM Student;\n" +
                "\n" +
                "28.\n" +
                "SELECT \n" +
                "    MAX(Score) AS Max_Score,\n" +
                "    MIN(Score) AS Min_Score,\n" +
                "    SUM(Score) AS Total_Score,\n" +
                "    AVG(Score) AS Avg_Score\n" +
                "FROM \n" +
                "    Choose\n" +
                "WHERE \n" +
                "    CourseID = 'C1';\n" +
                "\n" +
                "29.\n" +
                "SELECT CourseID, CourseName\n" +
                "FROM Course\n" +
                "WHERE CourseBeforeID IS NULL;\n" +
                "\n" +
                "30.\n" +
                "SELECT s.Sno, s.Name, c.CourseName, ch.Score\n" +
                "FROM Student s\n" +
                "JOIN Choose ch ON s.Sno = ch.Sno\n" +
                "JOIN Course c ON ch.CourseID = c.CourseID;\n" +
                "\n" +
                "31.\n" +
                "SELECT *\n" +
                "FROM Student s\n" +
                "WHERE EXISTS (\n" +
                "    SELECT 1\n" +
                "    FROM Student\n" +
                "    WHERE Name = '张三' AND College = s.College\n" +
                ") AND Name != '张三';\n" +
                "\n" +
                "32.\n" +
                "SELECT Sno, Score\n" +
                "FROM Choose\n" +
                "WHERE CourseID = 'C1'\n" +
                "AND Score < (\n" +
                "    SELECT Score\n" +
                "    FROM Choose\n" +
                "    JOIN Student ON Choose.Sno = Student.Sno\n" +
                "    WHERE Name = '张三' AND CourseID = 'C1'\n" +
                ");\n" +
                "\n" +
                "33.\n" +
                "SELECT Sno\n" +
                "FROM Choose\n" +
                "WHERE CourseID = 'C1'\n" +
                "UNION\n" +
                "SELECT Sno\n" +
                "FROM Choose\n" +
                "WHERE CourseID = 'C3';\n" +
                "\n" +
                "34.\n" +
                "SELECT DISTINCT Sno\n" +
                "FROM (\n" +
                "    SELECT Sno\n" +
                "    FROM Choose\n" +
                "    WHERE CourseID = 'C1'\n" +
                "    UNION\n" +
                "    SELECT Sno\n" +
                "    FROM Choose\n" +
                "    WHERE CourseID = 'C3'\n" +
                ") AS StudentIDs;\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n");
    }
}
