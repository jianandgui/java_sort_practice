package BubbleSort;

public class BubbleSort {

    /**
     * 交换排序思想：
     *交换排序很简单，感觉与直接选择排序很相似
     * 不过直接选择排序是选择最值然后比较，而交换排序
     * 是将最值不断的右移或者左移
     * 类似于传递
     * @param datas
     * @return
     */
    public int[] bubbleSort(int[] datas) {
        int length = datas.length;
        for (int i=0;i<length;i++) {
            boolean isExchange= false;
            for (int j=0;j<length-i-1;j++) {
                if (datas[j] > datas[j + 1]) {
                    int temp = datas[j + 1];
                    datas[j + 1] = datas[j];
                    datas[j] = temp;

                    isExchange = true;
                }
            }
            if (!isExchange) {
                return datas;
            }
        }
        return datas;
    }

    public static void main(String[] args) {
        int[] datas = {8, 7, 9, 6, 0, 4, 2, 1, 3};
        BubbleSort bubbleSort = new BubbleSort();
        datas = bubbleSort.bubbleSort(datas);
        for (int data : datas) {
            System.out.print(data+",");
        }
    }
}
