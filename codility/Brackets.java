import java.util.*;

public class Brackets {

    public int solution(String S) {
        Stack<Character> openBrackets = new Stack<>();
        Map<Character, Character> openToCloseBracketMap = new HashMap<>() {{
            put('{', '}');
            put('(', ')');
            put('[', ']');
        }};

        for (int i = 0; i < S.length(); i++) {
            Character bracket = S.charAt(i);

            if (openToCloseBracketMap.get(bracket) != null) {
                openBrackets.push(bracket);
            } else if (openBrackets.isEmpty() || openToCloseBracketMap.get(openBrackets.pop()) != bracket) {
                return 0;
            }
        }

        return openBrackets.isEmpty() ? 1 : 0;
    }
}
