package InsertSort;

public class BinaryInsertSort {

    /**
     * 折半插入排序
     * @param datas
     * @return
     */
    public int[] binaryInsertSort(int[] datas) {

        for (int i=0;i<datas.length;i++) {

            int curr = datas[i];
            int low = 0;
            int high = i - 1;
            while (low <= high) {
                int mid = (low + high) / 2;

                //这种划分的方式最终会使low和high指针指向统一点，即low指针和high指针重合
                //low指针最终都指向刚好大于等于指定元素的索引
                if (curr > datas[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            // 将low到i的元素全部后移一位
            for (int j = i; j > low; j--) {
                datas[j] = datas[j - 1];
            }



            datas[low] = curr;
        }
        return datas;
    }

    public static void main(String[] args) {
        BinaryInsertSort binaryInsertSort = new BinaryInsertSort();
        int[] datas = {1, 3, 4, 2};
        datas = binaryInsertSort.binaryInsertSort(datas);
        for (int data : datas) {
            System.out.print(data+" ,");
        }
    }
}
