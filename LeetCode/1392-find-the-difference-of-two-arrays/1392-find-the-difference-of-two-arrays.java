import java.util.*;

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<Integer> num1List = new ArrayList();
        List<Integer> num2List = new ArrayList();

        Set<Integer> num1Set = new HashSet();
        Set<Integer> num2Set = new HashSet();

        for(int i = 0; i < nums1.length; i++) {
            num1Set.add(nums1[i]);
        }

        for(int i = 0; i < nums2.length; i++) {
            num2Set.add(nums2[i]);
        }
        

        for(int num : num1Set.stream().toList()) {
            if(num2Set.contains(num)) {
                num1Set.remove(num);
                num2Set.remove(num);
            }
        }

        for(int i = 0; i < nums1.length; i++) {
            if(num1Set.contains(nums1[i])) {
                num1Set.remove(nums1[i]);
                num1List.add(nums1[i]);
            }
        }

        for(int i = 0; i < nums2.length; i++) {
            if(num2Set.contains(nums2[i])) {
                num2Set.remove(nums2[i]);
                num2List.add(nums2[i]);
            }
        }

        return List.of(num1List, num2List);
    }
}