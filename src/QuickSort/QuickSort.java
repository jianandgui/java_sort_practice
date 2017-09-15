package QuickSort;

public class QuickSort {

    public void swap(int[] datas, int i, int j) {
        int temp = datas[i];
        datas[i] = datas[j];
        datas[j] = temp;
    }

    /**
     * 思想：递归
     * 空间复杂度o(logn)
     *  时间复杂度为O（nlogn）
     * 不稳定的算法
     * @param datas
     * @param start
     * @param end
     * @return
     */
    public int[] quickSort(int[] datas, int start, int end) {

        //只要开始索引小于结束索引就必须要排序，说明还有元素未排序
        if (start < end) {
            int i = start;
            //后面要执行--j 所以会+1
            int j = end + 1;
            int flag = datas[start];

            //如果i>j说明两边已经搜索完了
            while (true) {
                //i<end 是防止数组过界限制 不断的搜索比flag大的元素 找到就中止循环
                while (i < end && datas[++i] <= flag) ;
                while (j > start && datas[--j] >= flag) ;
                //i找到第一个大于flag索引 j找到第一个小于flag索引 然后交换索引值 使比他大的都在右边 小的都在左边
                //还要判断是否j跑到了i的左边
                if (i < j) {
                    swap(datas, i, j);
                } else {
                    break;
                }
            }
            //交换flag和j的值
            swap(datas, start, j);
            //递归 依次查找flag左边 和右边 现在flag就是j
            quickSort(datas, start, j - 1);
            quickSort(datas, j + i, end);
        }
        return datas;
        }


    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] datas = {9,-16,21,23,-30,-49,21,30,13};
        datas = quickSort.quickSort(datas, 0, datas.length - 1);
        for (int data : datas) {
            System.out.print(data+" ,");
        }
    }
}
