package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem_71 {
    public static void main(String[] args) {
        Problem_71 p = new Problem_71();
        String output = p.simplifyPath("/../..ga/b/.f..d/..../e.baaeeh./.a");
        System.out.println(output);
    }

    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque();
        int itr = 0;
        String[] comps = path.split("/");
        for (String com : comps) {
            if (com.isEmpty()) continue;

            if (com.equalsIgnoreCase("..")) {
                if (!stack.isEmpty()) {
                    stack.poll();
                }
                continue;
            } else if (com.equals(".")) continue;

            stack.push(com);
        }

        StringBuilder sb = new StringBuilder("");
        while (!stack.isEmpty()) {
            String x = stack.poll();
            sb.insert(0, x);
            sb.insert(0, "/");
        }
        if (sb.length() == 0) return "/";
        return sb.toString();
    }
}
