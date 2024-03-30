import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class homeworkseven {
    static Random random=new Random();
    public static void test(){
        System.out.println(task1("abbc","dog cat cat fish"));
        System.out.println(task2(new int[]{1,2,2,3,0}));
        for(int i=0;i<5;i++){
            int target = random.nextInt(15) - 3;
            System.out.println("target:"+target+"\tresult"+task3(new int[]{0,4,5,6,8},target));
        }
    }
    public static void main(String[] args) {
        // 第一题
        String a  = "abbc";
        String b = "dog cat cat fish";
        if (task1("abbc","dog cat cat fish") == true){
            System.out.println(b+"符合"+a+"型");
        }
        //第二题
        int[] arr1 = new int[] {2, 3, 1, 0, 2, 5, 3};
        System.out.println(task2(arr1));
        //第三题
        int[] arr2 = new int[] {0,3,5,6,8,9};
        if(task3(arr2,5)!=-1){
            System.out.println(task3(arr2,5));
        }
        else{
            System.out.println("没有这个数");
        }
    }
    public static boolean task1(String pattern, String str) {
//第一题代码
        if(pattern == null || str==null) return false;
        String[] strs = str.split(" ");
        if(pattern.length() != strs.length) return false;
        Map<Character, String> map = new HashMap<>();

        for(int i = 0; i< pattern.length(); i++) {
            if(map.containsKey(pattern.charAt(i))) {
                if(!map.get(pattern.charAt(i)).equals(strs[i])) {
                    return false;
                }
            }else {
                if(map.containsValue(strs[i])) return false;
                map.put(pattern.charAt(i), strs[i]);
            }
        }
        return true;
    }
    public static int task2(int[] nums) {
//第二题代码
        if(nums.length <= 0){
            throw new RuntimeException("nums 长度小于0");
        }
        int m = -1;
        for(int i =0 ;i<nums.length;i++){
            while(nums[i] != i){
                if(nums[i] == nums[nums[i]]){
                    // System.out.println(nums[i]);
                    m=nums[i];
                    break;
                }
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
            if(m != -1){ //这个是如果找出了第一个 就停止遍历
                // System.out.println(nums[i]);
                break;
            }
        }
        return m;
    }
    public static int task3(int []nums,int target){
//第三题代码
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]==target)
                    return j;
            }
        }
        return -1;
    }
}