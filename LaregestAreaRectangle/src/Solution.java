import java.lang.Math;
public class Solution {
    //this project involves an integer array of numbers which represent different heights, visualised on a barchart
    //the objective is to try find the rectangle with the largest area on this barchart, using the "height" of the integers and the "width" of the space between them
    public static int largestArea(int[] height) {
        int left = 0; //left and right variables are used as indexes to compare elements in the array
        int right = height.length - 1;
        int width;
        int currMaxArea = 0;

        while(left < right) {
            width = right - left; //the "width" is the distance between the two indexes of the array we are accessing
            currMaxArea = Math.max(Math.min(height[left], height[right]) * width, currMaxArea); //we get the smallest number between both heights we are checking and multiply times the width, we update our currMaxArea variable if it exceeds its current value
            if (height[left] < height[right]) {
                left++; //we move whichever value is smallest to the next position to ensure we are always trying to compare the bigger numbers
            }
            else {
                right--;
            }
            }
        return currMaxArea;
        }

        public static void main(String args[]) {
        int[] testHeight = {1,8,6,2,5,4,8,3,7};
        System.out.println(largestArea(testHeight));
        }
    }

