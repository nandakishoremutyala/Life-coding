package leetcode;

public class LonelyPixelII {
    public int findBlackPixel(char[][] picture, int N) {
        if (picture == null || picture.length == 0 || picture[0].length == 0 || N < 0) return 0;

        int m = picture.length, n = picture[0].length;
        int[] rows = new int[m], cols = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 'B') {
                    rows[i]++;
                    cols[j]++;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 'B' && rows[i] == N && cols[j] == N) {
                    if (obeysRule2(picture, i, j, m, n, rows, cols)) {
                        res++;
                    }
                }
            }
        }
        return res;
    }

    private boolean obeysRule2(char[][] picture,
                               int index,//row
                               int j,//col
                               int m,//no of row
                               int n,//no of col
                               int[] rows,//b in rows
                               int[] cols) {
        for (int i = 0; i < m; i++) {
            if (i == index) continue;
            if (picture[i][j] == 'B') {
                if (rows[index] != rows[i]) return false; // violates rule2
                for (int col = 0; col < n; col++) {
                    if (picture[i][col] != picture[index][col]) return false; // violates rule1
                }
            }
        }
        return true;
    }
}
