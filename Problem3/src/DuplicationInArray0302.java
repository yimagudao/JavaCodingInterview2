/**
 *
 * @author Wiiliam Mou
 */
public class DuplicationInArray0302 {

    public static int getDuplication(int[] numbers) {
        if (numbers == null || numbers.length <= 0) {
            return -1;
        }
        for (int i = 0; i < numbers.length; ++i) {
            if (numbers[i] < 1 || numbers[i] >= numbers.length) {
                return -1;
            }
        }
        int start = 1;
        int end = numbers.length - 1;
        int count = 0;
        int middle = 0;
        while (start <= end) {
            middle = (start + end) / 2;
            count = countRange(numbers, start, middle);
            if (start == end) {
                if (count > 1) {
                    return start;
                } else {
                    break;
                }
            }
            if (count > (middle - start + 1)) {
                end = middle;
            } else {
                start = middle + 1;
            }

        }
        return -1;
    }

    public static int countRange(int[] numbers, int start, int end) {
        int count = 0;
        if (numbers == null) {
            return 0;
        }
        for (int i = 0; i < numbers.length; ++i) {
            if (numbers[i] >= start && numbers[i] <= end) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 3, 5, 4, 3, 2, 6, 7};
        System.out.println(getDuplication(numbers));
    }
}
