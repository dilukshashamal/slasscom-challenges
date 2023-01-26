import java.util.ArrayList;
import java.util.List;

public class Letter_Com {
    static String[] mapping = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        dfs(res, digits, "", 0);
        return res;
    }

    private static void dfs(List<String> res, String digits, String curr, int index) {
        if (index == digits.length()) {
            res.add(curr);
            return;
        }
        String letters = mapping[digits.charAt(index) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            dfs(res, digits, curr + letters.charAt(i), index + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations(""));
    }
}
