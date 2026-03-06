class Solution {
    public ArrayList<String> ratInMaze(int[][] maze) {

        ArrayList<String> result = new ArrayList<>();

        int len = maze.length;

        if(maze[0][0] == 0 || maze[len-1][len-1] == 0) {
            return result;
        }

        getAllPath(maze, 0, 0, len, result, "");
        return result;
    }

    private void getAllPath(int[][] maze, int row, int col, int len,
                            ArrayList<String> result, String currStr) {

        if(row >= len || row < 0 || col >= len || col < 0 || maze[row][col] == 0) {
            return;
        }

        if(row == len - 1 && col == len - 1) {
            result.add(currStr);
            return;
        }

        maze[row][col] = 0; // visited

        getAllPath(maze, row + 1, col, len, result, currStr + "D");
        getAllPath(maze, row, col - 1, len, result, currStr + "L");
        getAllPath(maze, row, col + 1, len, result, currStr + "R");
        getAllPath(maze, row - 1, col, len, result, currStr + "U");

        maze[row][col] = 1; // backtrack
    }
}