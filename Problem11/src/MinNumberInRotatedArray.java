/**
 * @author William Mou
 * @date 2019/1/18 10:55
 */
public class MinNumberInRotatedArray {
    /**
     * 二分查找最小值
     * 用两个指针，分别指向数组的头和尾，用二分法找到中间跳跃值
     * @param numbers
     * @return 最小值
     */
    public static int Min(int[] numbers) {
        if (numbers == null || numbers.length < 0) {
            throw new RuntimeException();
        }
        int index1 = 0;
        int index2 = numbers.length - 1;
        int indexMid = index1;
        while (numbers[index1] >= numbers[index2]) {
            if (index2 - index1 == 1) {
                indexMid = index2;
                break;
            }
            indexMid = (index1 + index2) / 2;
            if (numbers[index1] == numbers[index2] && numbers[index1] == numbers[indexMid]) {
                return MinInOrder(numbers, index1, index2);
            }
            if (numbers[indexMid] >= numbers[index1]) {
                index1 = indexMid;
            } else if (numbers[indexMid] <= numbers[index2]) {
                index2 = indexMid;
            }
        }
        return numbers[indexMid];
    }

    //顺序查找最小值
    public static int MinInOrder(int[] numbers, int index1, int index2) {
        int result = numbers[index1];
        for (int i = index1 + 1; i <= index2; i++) {
            if (result > numbers[i]) {
                result = numbers[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] numbers = {3,4,5,1,2};
        int[] numbers = {1, 0, 1, 1, 1};
        System.out.println(Min(numbers));
    }
}
