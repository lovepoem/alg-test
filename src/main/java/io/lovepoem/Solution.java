package io.lovepoem;

import java.util.*;

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                List<Integer> arr = new ArrayList();
                arr.add(i);
                arr.add(j);
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{};
    }

    public static String longestCommonPrefix(String[] strs) {

        Stack stack = new Stack();
        String commonPrefix = "";
        if (strs == null || strs.length == 0) {
            return commonPrefix;
        }
        char[] oneStr = strs[0].toCharArray();
        for (int i = 0; i < oneStr.length; i++) {
            for (int j = 1; j < strs.length && i < strs[j].length(); j++) {
                System.out.println(j+"   "+strs[j].charAt(i));
                 if(oneStr[i] != strs[j].charAt(i)){
                    return strs[0].substring(0,i);
                 }else {
                    // System.out.println(strs[0].substring(0,i-1));
                 }
            }
        }
        return commonPrefix;
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode11 = new ListNode(1);
        ListNode listNode13 = new ListNode(3);
        ListNode listNode14 = new ListNode(4);
        listNode.next = listNode2;
        listNode2.next = listNode4;
        listNode11.next = listNode13;
        listNode13.next = listNode14;

        ListNode node = ss.mergeTwoLists(listNode, listNode11);
        System.out.println(node);
        String[] aa = {"aa", "aabbc"};
        System.out.println("aa".substring(0,1));
        String aaP = longestCommonPrefix(aa);
        System.out.println(aaP);
        System.out.println(aaP);
        //int target = 6;
        //int[]  ss2 = twoSum(aa, target);
        //System.out.println(ss2[0] + "--" + ss2[1]);
        String s ="()[]{}";
        Boolean ss1111= s.replaceAll("()","").replaceAll("\\\\[\\\\]","").replaceAll("\\{\\\\}","").length()==0;
        System.out.println(ss1111);
    }
}
