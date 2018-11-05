/**
 * @author William Mou
 * @date 2018/11/5 17:21
 */
public class ReplaceSpaces {
    public static void ReplaceSpaces(char[] string, int length) {
        if (string == null || length <= 0) {
            return;
        }
        int numberOfBlank = 0;
        for (int i = 0; i < length; ++i) {
            if (string[i] == ' ') {
                numberOfBlank++;
            }
        }
        int newLength = length + 2 * numberOfBlank;
        if (newLength > string.length) {
            return;
        }
        int indexOfOriginal = length - 1;
        int indexOfNew = newLength - 1;
        while (indexOfOriginal >= 0 && indexOfNew > indexOfOriginal) {
            if (string[indexOfOriginal] == ' ') {
                string[indexOfNew--] = '0';
                string[indexOfNew--] = '2';
                string[indexOfNew--] = '%';
            } else {
                string[indexOfNew--] = string[indexOfOriginal];
            }
            indexOfOriginal--;
        }
    }

    public static void main(String[] args) {
        String str = "we are happy.";
        char[] string = new char[30];
        char[] str2 = str.toCharArray();
        for (int i = 0; i < str2.length; i++) {
            string[i] = str2[i];
        }
        ReplaceSpaces(string, str2.length);
        System.out.println(string);
    }
}
