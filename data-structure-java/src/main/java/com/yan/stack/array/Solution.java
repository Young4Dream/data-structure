package com.yan.stack.array;

import com.yan.array.dynamic.Array;
import com.yan.stack.Stack;

/**
 * @author Administrator
 * @since 1.0.0
 * 2019/10/8 0008 11:31
 */
@SuppressWarnings("all")
public class Solution {
    private static final Character[] INPUT_CHARS;
    private static final Character[] OUTPUT_CHARS;

    static {
        INPUT_CHARS =  new Character[]{'(', '[', '{', '<', '《', '（', '【'};
        OUTPUT_CHARS = new Character[]{')', ']', '}', '>', '》', '）', '】'};
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new ArrayStack<>();
        Array<Character> inputs = new Array<>(INPUT_CHARS);
        Array<Character> outputs = new Array<>(OUTPUT_CHARS);

        for (char c : s.toCharArray()) {
            if (!(inputs.contains(c) || outputs.contains(c))) continue;
            if (inputs.contains(c)) {
                stack.push(c);
                continue;
            }
            int index = outputs.find(c);
            Character topChar = stack.peek();
            if ((topChar == null) || (index != inputs.find(topChar))) {
                return false;
            }
            stack.pop();
        }
        return stack.isEmpty();
    }
}
