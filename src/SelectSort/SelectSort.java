package SelectSort;

public class SelectSort {

    /**
     * 直接交换排序思想：
     * 每次都选出集合里面最小的一个，然后选出来放在前面，依次往后推
     * 使用这种直接排序在性能上有一点提升，就是不用每次遇到比他小（大）都交换，
     * 而是选出最小（大）的再进行交换
     * @param data
     * @return
     */
    public int[] selectSort(int[] data) {
        if (data.length == 0) {
            return null;
        }
        if (data.length == 1) {
            return data;
        }

        for (int i=0;i<data.length;i++) {

            int minIndex = i;
            for (int j=i+1;j<data.length;j++) {
                if (data[minIndex] > data[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = data[minIndex];
                data[minIndex] = data[i];
                data[i] = temp;
            }
        }
        return data;
    }

    public static void main(String[] args) {
        int[] datas = {8, 7, 9, 6, 0, 4, 5, 2, 1, 3};
        SelectSort selectSort = new SelectSort();
        datas = selectSort.selectSort(datas);
        for (int data : datas) {
            System.out.print(data+",");
        }
    }
}
