package test.leetcode2025;

/**
 * 三角形类型
 */
public class TriangleType {
    public String triangleType(int[] nums) {
        int a = nums[0];
        int b = nums[1];
        int c = nums[2];
        if(a+b<=c||a+c<=b||b+c<=a){
            return "none";
        }
        if(a==b&&a==c){
            return "equilateral";
        }
        if(a==b||b==c||c==a){
            return "isosceles ";
        }
        return "scalene";
    }
}
