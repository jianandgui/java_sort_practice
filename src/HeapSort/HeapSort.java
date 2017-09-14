package HeapSort;

public class HeapSort {

    /**
     * 堆排序思想：
     * 1、建堆
     * 2、选出最大或者最小放在最后
     * 通过不断的建堆，每次都将最大最小选出来，然后用
     * 剩下的元素继续建堆，不断循环，其实也是一种选择排序
     * 只是减少了比较次数相对于直接选择排序，树型结构可以
     * 保留比较结果，不用重复比较
     *
     * 堆生成完全二叉树，最后一个非叶子节点为（i-1）/2
     * 左子节点为2×i+1 右字节点为2×i+2
     *
     * 使用堆排序也只是为了找出每次的最大值而已
     * 不断的使用堆排序
     * @param datas
     * @return
     */
    public int[] heapSort(int[] datas) {
        int length = datas.length;
        for (int i = 0; i < length -1; i++) {
            this.buildHeap(datas, length - 1 -i);
            this.swap(datas, 0, length - 1 -i);
        }
        return datas;
    }

    public void swap(int[] datas, int m, int n) {
        int temp = datas[m];
        datas[m] = datas[n];
        datas[n] = temp;
    }

    public void buildHeap(int[] datas, int lastIndex) {
        for (int i = (lastIndex - 1) / 2; i >=0; i--) {
            int curr = i;
            //代表存在子节点
            while (curr * 2 + 1 <= lastIndex) {
                //假设最大节点为左节点
                int bigIndex = curr * 2 + 1;
                //表示存在有右子节点
                if (bigIndex < lastIndex) {
                    if (datas[bigIndex] < datas[bigIndex + 1]) {
                        bigIndex++;
                    }
                }

                //如果左右子节点中存在比当前节点大的值就交换节点值
                if (datas[bigIndex] > datas[curr]) {
                    swap(datas, bigIndex, curr);
                    //如果该节点还存在子节点，就需要去比较子节点
                    //没有这行代码也是可以的，只是退化成了直接交换排序
                    //继续比较子节点
                    curr = bigIndex;
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] datas = {8, 7, 9, 6, 0, 4, 2, 1, 3,5,8};
        heapSort.heapSort(datas);
        for (int data : datas) {
            System.out.print(data+" ,");
        }
    }
}
