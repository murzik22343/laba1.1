import java.util.ArrayDeque;
import java.util.Deque;

public class murzik {
    public static boolean proverka(String stroka) {
        Deque<Character> stek = new ArrayDeque<>();
        for (int i = 0; i < stroka.length(); i++) {
            char znak = stroka.charAt(i);
            if (znak == '(' || znak == '[' || znak == '{') {
                stek.push(znak);
            } else if (znak == ')' || znak == ']' || znak == '}') {
                if (stek.isEmpty()) return false;
                char last = stek.pop();
                if ((znak == ')' && last != '(') ||
                        (znak == ']' && last != '[') ||
                        (znak == '}' && last != '{')) {
                    return false;
                }
            }
        }
        return stek.isEmpty();
    }

    public static void main(String[] args) {
        String[] tests = {"[]", "[](){}", "[({})]", "[({}()){}]", "{]", "({)}", "", "abc"};
        for (String t : tests) {
            System.out.println(t + " -> " + proverka(t));
        }
    }
}
