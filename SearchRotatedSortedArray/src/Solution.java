public class Solution {
    //this problem involves a simple search of a target in a sorted array
    //however the array may be rotated at a certain point, meaning it is sorted up to a certain index in which the n umbers begin again in ascending order
    //this problem must be solved with an algorithm that's solved in O(log n) complexity

    //by looking at the counters, this algorithm halves the search space each iteration in both findrotation and binary search, it has a time complexity of O(log n)
    //counters for measuring the complexity
    static int findRotationCounter = 0;
    static int binarySearchCounter = 0;

    public static void main(String args[]) {
        int[] nums = {5, 6, 7, 8, 1, 2, 3};
        int target = 2;

        System.out.println("Index of rotation: " + findRotation(nums));
        System.out.println("Index of target: " + search(nums, target));
        System.out.println("FindRotation loop count: " + findRotationCounter);
        System.out.println("BinarySearch loop count: " + binarySearchCounter);
    }

    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        int rotation = findRotation(nums);

        //no rotation found, do a regular binary search
        if (rotation == -1) {
            return binarySearch(nums, target, start, end);
        }

        //check if target is at the rotation point index
        if (nums[rotation] == target) {
            return rotation;
        }

        //search before or after the rotation
        if (nums[start] <= target && target <= nums[rotation - 1]) {
            return binarySearch(nums, target, start, rotation - 1);
        } else {
            return binarySearch(nums, target, rotation + 1, end);
        }
    }

    public static int findRotation(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            //increment counter for each loop iteration
            findRotationCounter++;
            int mid = (start + end) / 2;

            // Rotation found
            if (mid > start && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            }
            if (mid < end && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            if (nums[mid] <= nums[start]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] nums, int target, int start, int end) {
        while (start <= end) {
            //increment counter for each loop iteration
            binarySearchCounter++;
            int mid = (start + end) / 2;

            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
