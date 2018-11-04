
/**
 *长度为n的数组里所有数字都在0~n-1中，找出数组中某个重复的数字
 * @author Wiiliam Mou
 */
public class DuplicationInArray0301 {

    public static int duplication = -1; // -1 表示没找到相同的

    public static boolean duplicate(int[] numbers) {
        if (numbers == null || numbers.length <= 0) {
            return false;
        }
        for (int i = 0; i < numbers.length; ++i) {
            if (numbers[i] < 0 || numbers[i] > numbers.length - 1) {
                return false;
            }
        }
        for (int i = 0; i < numbers.length; ++i) {
            while (numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication = numbers[i];
                    System.out.println(duplication);
                    return true;
                }
                int temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] numers = {2, 3, 2, 0, 2, 5, 3};
        System.out.println(duplicate(numers));
    }
}
