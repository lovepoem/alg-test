package io.lovepoem;

public class Bubble {
    /**
     * （1）比较前后相邻的二个数据，如果前面数据大于后面的数据，就将这二个数据交换。
     * （2）这样对数组的第 0个数据到 N-1个数据进行一次遍历后，最大的一个数据就“沉”到数组第
     * N-1个位置。
     * （3）N=N-1，如果 N 不为 0就重复前面二步，否则排序完成。
     *
     * @param a
     */
    public static void bubbleSort1(int[] a) {
        int i, j;
        for (i = 0; i < a.length; i++) {//表示 n次排序过程。
            for (j = 1; j < a.length - i; j++) {
                if (a[j - 1] > a[j]) {//前面的数字大于后面的数字就交换
                    //交换 a[j-1]和 a[j]
                    int temp;
                    temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    /**
     * 快速排序的原理：选择一个关键值作为基准值。比基准值小的都在左边序列（一般是无序的），
     * 比基准值大的都在右边（一般是无序的）。一般选择序列的第一个元素。
     * 一次循环：从后往前比较，用基准值和最后一个值比较，如果比基准值小的交换位置，如果没有
     * 继续比较下一个，直到找到第一个比基准值小的值才交换。找到这个值之后，又从前往后开始比
     * 较，如果有比基准值大的，交换位置，如果没有继续比较下一个，直到找到第一个比基准值大的
     * 值才交换。直到从前往后的比较索引>从后往前比较的索引，结束第一次循环，此时，对于基准值
     * 来说，左右两边就是有序的了。
     *
     * @param a
     * @param low
     * @param high
     */
    public static void quickSort(int[] a, int low, int high) {
        int start = low;
        int end = high;
        int key = a[low];
        while (end > start) {
            //从后往前比较
            while (end > start && a[end] >= key)
                //如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
                end--;
            if (a[end] <= key) {
                int temp = a[end];
                a[end] = a[start];
                a[start] = temp;
            }
            //从前往后比较
            while (end > start && a[start] <= key)
                //如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
                start++;
            if (a[start] >= key) {
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }
            //此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
        }
        //递归
        if (start > low) quickSort(a, low, start - 1);//左边序列。第一个索引位置到关键值索引-1
        if (end < high) quickSort(a, end + 1, high);//右边序列。从关键值索引+1到最后一个
    }


    public static void main(String[] args) {
        int[] ss = {2, 4, 4, 5, 555, 233, 22, 4};
        //bubbleSort1(ss);
        quickSort(ss, 0, ss.length - 1);
        for (int s : ss) {
            System.out.println(s);
        }
    }


}
