
import java.sql.*;

public class homeworkfive {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }
    public static void heapSort(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;

        if (l < n && arr[l] > arr[largest])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }

    }
    public static void main(String[] args) {
        // 加载 MySQL 驱动程序类
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        // 数据库连接参数
        String url = "jdbc:mysql://localhost:3306/student";
        String username = "root";
        String password = "zqy20812";

        // 声明数据库连接和结果集
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // 建立数据库连接
            connection = DriverManager.getConnection(url, username, password);

            // 创建 Statement 对象
            statement = connection.createStatement();

            // 插入数据
            String insertQuery1 = "INSERT INTO s (SNO, Name, Age, College) VALUES ('s001', '老大', 20, '计算机学院')";
            String insertQuery2 = "INSERT INTO s (SNO, Name, Age, College) VALUES ('s002', '老二', 19, '计算机学院')";
            String insertQuery3 = "INSERT INTO s (SNO, Name, Age, College) VALUES ('s003', '老三', 18, '计算机学院')";
            String insertQuery4 = "INSERT INTO s (SNO, Name, Age, College) VALUES ('s004', '老四', 17, '通信学院')";
            statement.executeUpdate(insertQuery1);
            statement.executeUpdate(insertQuery2);
            statement.executeUpdate(insertQuery3);
            statement.executeUpdate(insertQuery4);

            // 打印分隔线
            System.out.println("-----------------");

            // 执行查询并打印数据
            String query = "SELECT * FROM s";
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String sno = resultSet.getString("SNO");
                String name = resultSet.getString("Name");
                int age = resultSet.getInt("Age");
                String college = resultSet.getString("College");
                System.out.println("SNO: " + sno + ", Name: " + name + ", Age: " + age + ", College: " + college);
            }

            // 打印分隔线
            System.out.println("-----------------");

            // 删除s004的记录并重新打印数据
            String deleteQuery = "DELETE FROM s WHERE SNO = 's004'";
            statement.executeUpdate(deleteQuery);

            resultSet.close();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String sno = resultSet.getString("SNO");
                String name = resultSet.getString("Name");
                int age = resultSet.getInt("Age");
                String college = resultSet.getString("College");
                System.out.println("SNO: " + sno + ", Name: " + name + ", Age: " + age + ", College: " + college);
            }

            // 关闭resultSet
            resultSet.close();

            // 打印分隔线
            System.out.println("-----------------");

            // 查询并打印s003的记录
            String s003Query = "SELECT * FROM s WHERE SNO = 's003'";
            resultSet = statement.executeQuery(s003Query);
            if (resultSet.next()) {
                String sno = resultSet.getString("SNO");
                String name = resultSet.getString("Name");
                int age = resultSet.getInt("Age");
                String college = resultSet.getString("College");
                System.out.println("SNO: " + sno + ", Name: " + name + ", Age: " + age + ", College: " + college);
            }

            // 关闭resultSet
            resultSet.close();

            // 打印分隔线
            System.out.println("-----------------");

            // 修改s001的记录并重新打印数据
            String updateQuery = "UPDATE s SET Name = '老大', Age = 20, College = '通信学院' WHERE SNO = 's001'";
            statement.executeUpdate(updateQuery);

            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String sno = resultSet.getString("SNO");
                String name = resultSet.getString("Name");
                int age = resultSet.getInt("Age");
                String college = resultSet.getString("College");
                System.out.println("SNO: " + sno + ", Name: " + name + ", Age: " + age + ", College: " + college);
            }

            // 打印分隔线
            System.out.println("-----------------");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭连接和相关资源
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //冒泡排序
        int[] arr = {1,3,43,45,2,6,9};
        bubbleSort(arr);
        for(int i=0;i<7;i++)
        {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
        System.out.println();
        //插入排序
        int[] arr2 = {1,3,43,45,2,6,9};
        insertionSort(arr2);
        for(int i=0;i<7;i++)
        {
            System.out.print(arr2[i]);
            System.out.print(" ");
        }
        System.out.println();
        //快速排序
        int[] arr3 = {1,3,43,45,2,6,9};
        quickSort(arr3,0,6);
        for(int i=0;i<7;i++)
        {
            System.out.print(arr3[i]);
            System.out.print(" ");
        }
        System.out.println();
        //堆排序
        int[] arr4 = {1,3,43,45,2,6,9};
        heapSort(arr4);
        for(int i=0;i<7;i++)
        {
            System.out.print(arr4[i]);
            System.out.print(" ");
        }
        System.out.println();
    }
}