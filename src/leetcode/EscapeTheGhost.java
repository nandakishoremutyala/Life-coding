package leetcode;

public class EscapeTheGhost {
    public static void main(String[] args) {
        EscapeTheGhost escapeTheGhost = new EscapeTheGhost();
        System.out.println(escapeTheGhost.escapeGhosts(new int[][]{{1, 0}, {0, 3}}, new int[]{0, 1}));
    }

    public boolean escapeGhosts(int[][] ghosts, int[] t) {
        int d = Math.abs(t[0] - 0) + Math.abs(t[1] - 0);
        for (int[] g : ghosts) {
            if (d >= Math.abs(t[0] - g[0]) + Math.abs(t[1] - g[1]))
                return false;
        }
        return true;
    }
}
