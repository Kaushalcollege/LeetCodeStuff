import java.util.*;

class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Queue<String> q = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        String smallest = s;

        q.offer(s);
        seen.add(s);

        while (!q.isEmpty()) {
            String cur = q.poll();
            if (cur.compareTo(smallest) < 0)
                smallest = cur;
            String added = add(cur, a);
            if (seen.add(added)) q.offer(added);

            String rotated = rotate(cur, b);
            if (seen.add(rotated)) q.offer(rotated);
        }

        return smallest;
    }

    private String add(String t, int a) {
        char[] str = t.toCharArray();
        for (int i = 1; i < str.length; i += 2) {
            int digit = (str[i] - '0' + a) % 10;  
            str[i] = (char) (digit + '0');
        }
        return new String(str);
    }

    private String rotate(String t, int b) {
        int n = t.length();
        b %= n;
        return t.substring(n - b) + t.substring(0, n - b);
    }
}
