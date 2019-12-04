package io.lovepoem;

import java.util.ArrayList;
import java.util.List;

public class Test {


    /**
     * 两个已顺序排序数组的合并
     *
     * @param aList
     * @param bList
     * @return
     */

    public static List<Integer> mergeTwoSortList(List<Integer> aList,

                                                 List<Integer> bList) {
        int aLength = aList.size(), bLength = bList.size();
        List<Integer> mergeList = new ArrayList();
        int i = 0, j = 0;
        while (aLength > i && bLength > j) {
            if (aList.get(i) > bList.get(j)) {
                mergeList.add(i + j, bList.get(j));
                j++;
            } else {
                mergeList.add(i + j, aList.get(i));
                i++;
            }
        }

        // blist元素已排好序， alist还有剩余元素

        while (aLength > i) {
            mergeList.add(i + j, aList.get(i));
            i++;

        }

        // alist元素已排好序， blist还有剩余元素

        while (bLength > j) {
            mergeList.add(i + j, bList.get(j));
            j++;
        }
        return mergeList;
    }

    public static List<Integer> merge(List<Integer> one, List<Integer> two) {
        int m = 0;
        int n = 0;
        int lengthOne = one.size();
        int lengthTwo = two.size();
        List<Integer> newList = new ArrayList<>();
        while (lengthOne > m && lengthTwo > n) {
            if (one.get(m) > two.get(n)) {
                newList.add(two.get(n));
                n++;
            } else {
                newList.add(one.get(m));
                m++;
            }
        }

        while (lengthOne > m) {
            newList.add(one.get(m));
            m++;
        }

        while (lengthTwo > n) {
            newList.add(two.get(n));
            n++;
        }

        return newList;
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0;
        List arr = new ArrayList();
        int numnOneSize = m;
        int numnTwoSize = n;
        while (numnOneSize > i && numnTwoSize > j) {
            if (nums1[i] > nums2[j]) {
                arr.add(nums2[j]);
                j++;
            } else {
                arr.add(nums1[i]);
                i++;
            }
        }
        while (numnOneSize > i) {
            arr.add(nums1[i]);
            i++;
        }
        while (numnTwoSize > j) {
            arr.add(nums2[j]);
            j++;
        }

        nums1 = new int[arr.size()];
        for (int p = 0; p < arr.size(); p++) {
            nums1[p] = (int) arr.get(p);
        }
        for (int mmmm = 0; mmmm < nums1.length; mmmm++) {

            System.out.println(nums1[mmmm]);
        }
    }

    public static void main(String[] args) {

        int[] a = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] b = {2, 5, 6};
        int n = 3;

        merge(a, m, b, n);
        List<Integer> one = new ArrayList<>();
        one.add(1);
        one.add(3);
        one.add(5);
        List<Integer> two = new ArrayList<>();
        two.add(2);
        two.add(4);
        List<Integer> com = merge(one, two);
        //System.out.println(com);
        for (Integer in : com) {
            //  System.out.println("hahaah " + in);
        }

    }
}
