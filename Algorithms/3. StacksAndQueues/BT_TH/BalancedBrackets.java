public class BalancedBrackets {

    public static boolean isBalanced(String s) {
        MyStack<Character> stack = new MyStack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    return false; 
                }
                char open = stack.pop();
                if (!isMatchingPair(open, c)) {
                    return false; 
                }
            }
        }
        return stack.isEmpty();
    }

    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')')
            || (open == '[' && close == ']')
            || (open == '{' && close == '}');
    }

    public static void main(String[] args) {
        String[] tests = {
            "{[()]}",     // true
            "{[(])}",     // false - sai thứ tự
            "((()))",     // true
            "([)]",       // false
            "{{[[(())]]}}", // true
            "(",          // false - thiếu đóng
            ")",          // false - thừa đóng
            "abc(def)[gh]{i}" // true - có ký tự thường xen kẽ
        };

        for (String t : tests) {
            System.out.println(t + "  ->  " + isBalanced(t));
        }
    }
}
