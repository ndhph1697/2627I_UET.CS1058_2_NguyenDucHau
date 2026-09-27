import java.util.Scanner;

public class SimpleTextEditor {

    private static class Command {
        char type;   
        String data; 

        Command(char type, String data) {
            this.type = type;
            this.data = data;
        }
    }

    private final StringBuilder text = new StringBuilder();
    private final MyStack<Command> history = new MyStack<>();

    public void append(String w) {
        text.append(w);
        history.push(new Command('A', w));
    }

    public void delete(int k) {
        int start = text.length() - k;
        String removed = text.substring(start);
        text.delete(start, text.length());
        history.push(new Command('D', removed));
    }

    public char print(int k) {
        char c = text.charAt(k - 1);
        System.out.println(c);
        return c;
    }

    public void undo() {
        if (history.isEmpty()) {
            return;
        }
        Command c = history.pop();
        if (c.type == 'A') {
            int len = c.data.length();
            text.delete(text.length() - len, text.length());
        } else { 
            text.append(c.data);
        }
    }

    public String currentText() {
        return text.toString();
    }

    public static void main(String[] args) {
        SimpleTextEditor editor = new SimpleTextEditor();

        editor.append("abc");
        System.out.println(editor.currentText()); // abc

        editor.append("xy");
        System.out.println(editor.currentText()); // abcxy

        editor.print(3); // in 'c'

        editor.delete(3);
        System.out.println(editor.currentText()); // ab

        editor.undo(); // hoan tac delete(3) -> tro lai "abcxy"
        System.out.println(editor.currentText()); // abcxy

        editor.undo(); // hoan tac append("xy") -> tro lai "abc"
        System.out.println(editor.currentText()); // abc
    }
