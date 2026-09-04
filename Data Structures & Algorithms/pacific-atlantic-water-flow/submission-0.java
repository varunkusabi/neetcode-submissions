class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        boolean[][] pac = new boolean[n][m];
        boolean[][] atl = new boolean[n][m];

        // 1. Top (Pacific) and Bottom (Atlantic) borders -> loop over COLUMNS (m)
        for (int c = 0; c < m; c++) {
            dfs(0, c, pac, heights[0][c], heights);           // Top border
            dfs(n - 1, c, atl, heights[n - 1][c], heights);   // Bottom border
        }

        // 2. Left (Pacific) and Right (Atlantic) borders -> loop over ROWS (n)
        for (int r = 0; r < n; r++) {
            dfs(r, 0, pac, heights[r][0], heights);           // Left border
            dfs(r, m - 1, atl, heights[r][m - 1], heights);   // Right border
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (pac[r][c] && atl[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }
        return result;
    }

    private void dfs(int r, int c, boolean[][] ocean, int prevht, int[][] heights) {
        if (r < 0 || r >= heights.length || c < 0 || c >= heights[0].length || ocean[r][c] || heights[r][c] < prevht) {
            return;
        }

        ocean[r][c] = true;
        
        dfs(r + 1, c, ocean, heights[r][c], heights);
        dfs(r - 1, c, ocean, heights[r][c], heights);
        dfs(r, c + 1, ocean, heights[r][c], heights);
        dfs(r, c - 1, ocean, heights[r][c], heights);        
    }
}