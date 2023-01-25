import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
    public int findJudge(int n, int[][] trust) {
//        int length = trust.length;
//        int flag = 0;
//        if(n <= length)
//            return -1;
//        int label = trust[0][1];
//        for(int i = 0;i < n;i++) {
//            if(trust[i][1] != label){
//                flag = 1;
//                break;
//            }
//            if(trust[i][0] == label) {
//                flag = 1;
//                break;
//            }
//        }
//        if(length == n-1) {
//            if(flag == 0)
//                return label;
//            else return -1;
//        }
//        else
//            return -1;

        int people[] = new int[n];
        for(int i = 0;i<n;i++) {
            people[i] =0;
        }

        int length = trust.length;
        for(int i = 0;i<length;i++) {
            people[trust[i][0] - 1] = -1;
            if(people[trust[i][1] - 1] != -1)
            people[trust[i][1] - 1] += 1;
        }
        for(int i = 0;i < n;i++) {
            if(people[i] == n-1) return i+1;
        }
        return -1;
    }

    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        int flag = -1;
        int numscopy[] = new int[length];
        for(int i = 0;i<length;i++) {
            numscopy[i] = nums[i];
        }
        Arrays.sort(nums);
        int ans[] = new int[2];
        int rem = 0;
        for(int i = 0;i < length;i++) {
            rem = target - nums[i];
            for(int j = length-1;j>i;j--) {
                if(nums[j] < rem) {
                    flag = 1;
                    break;
                }
                if(nums[j] == rem) {
                    flag = 0;
                    ans[0] = nums[i];
                    ans[1] = nums[j];
                    System.out.println("ans[0]: " + ans[0]);
                    System.out.println("ans[1]: " + ans[1]);
                    break;
                }
            }
            if(flag == 0){
                System.out.println("flag = 0");
                break;
            }
        }

        int check1 = 0;
        int check2 = 0;
        if(flag == 0) {
            for(int i = 0;i<length;i++) {
                if(check1 == 0 && numscopy[i] == ans[0]){

                    ans[0] = i;
                    check1 = 1;
                }
                else if (check2 == 0 && numscopy[i] == ans[1]) {

                    ans[1] = i;
                    check1 = 1;
                }
                else {
                    ans[0] = ans[0];
                }
            }
        }

        return ans;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        //Time Complexity - n^2
        //Technique 1: Brute Force Method
        /* Technique 2: Two pointer approach
        Sort the array. If we go from left to right using one pointer and one pointer from right to left then the left one
        will always increase and right one will always decrease so the lefter to left and righter to right has no business
        with each other

        Using sets to get constant time insertion
         */
        Set<List<Integer>> ans = new HashSet<>();
        int j,k;
        int length = nums.length;
        Arrays.sort(nums);

        for(int i = 0; i < length - 2;i++) {
            j = i + 1;
            k = length - 1;
            int sum;

            while(j<k) {
                List<Integer> triplet = new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k]));
                sum = nums[i] + nums[j] + nums[k];

                if(sum == 0) {
                    ans.add(triplet);
                    j++;
                    k--;
                }

                if(sum > 0) k--;
                if(sum < 0) j++;

            }
        }

        return new ArrayList<>(ans);

    }

    public int threeSumClosest(int[] nums, int target) {
        /* Time Complexity = n^2
         Modified 3 sum

         */
        Arrays.sort(nums);
        int length = nums.length;
        int mindeviation = nums[0] + nums[1] + nums[length - 1] - target;
        int deviation = 0;
        int j,k;

        for(int i = 0;i < length-2;i++) {
            j=i+1;
            k=length-1;
            while(j<k) {
                deviation = nums[i] + nums[j] + nums[k] - target;
                if(deviation == 0){
                    return target;
                }
                if(Math.abs(deviation) < Math.abs(mindeviation)) {
                    mindeviation = deviation;
                }
                if(deviation < 0) {
                    j++;
                }
                else {
                    k--;
                }


            }
        }
        return mindeviation + target;
    }


}