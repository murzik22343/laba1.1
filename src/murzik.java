import java.util.ArrayDeque;
import java.util.Deque;

public class murzik {
    public static boolean isBalanced(String str) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            // Открывающая скобка
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            // Закрывающая скобка
            else {
                // Если стек пуст, значит открывающей скобки нет
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                // Проверяем соответствие скобок
                if (c == ')' && top != '(') {
                    return false;
                }
                if (c == ']' && top != '[') {
                    return false;
                }
                if (c == '}' && top != '{') {
                    return false;
                }
            }
        }
        // Если стек пуст — все скобки закрыты
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        System.out.println("[] -> " + isBalanced("[]"));
        System.out.println("[](){} -> " + isBalanced("[](){}"));
        System.out.println("[({})] -> " + isBalanced("[({})]"));
        System.out.println("[({}()){}] -> " + isBalanced("[({}()){}]"));
        System.out.println("{] -> " + isBalanced("{]"));
        System.out.println("({)} -> " + isBalanced("({)}"));
    }
}
