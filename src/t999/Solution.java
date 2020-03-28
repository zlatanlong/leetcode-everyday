package t999;

public class Solution {
    public int numRookCaptures(char[][] board) {
        int rookX = 0;
        int rookY = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    rookX = i;
                    rookY = j;
                }
            }
        }
        int count = 0;
        for (int i = rookX - 1; i > -1; i--) {
            char tempChar = board[i][rookY];
            if (tempChar == 'p') {
                count++;
                break;
            } else if (tempChar == 'B') {
                break;
            }
        }
        for (int i = rookX + 1; i < 8; i++) {
            char tempChar = board[i][rookY];
            if (tempChar == 'p') {
                count++;
                break;
            } else if (tempChar == 'B') {
                break;
            }
        }
        for (int j = rookY - 1; j > -1; j--) {
            char tempChar = board[rookX][j];
            if (tempChar == 'p') {
                count++;
                break;
            } else if (tempChar == 'B') {
                break;
            }
        }
        for (int j = rookY + 1; j < 8; j++) {
            char tempChar = board[rookX][j];
            if (tempChar == 'p') {
                count++;
                break;
            } else if (tempChar == 'B') {
                break;
            }
        }


        return count;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] newchar = {
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', 'B', '.', '.', '.', '.'},
                {'.', 'p', 'B', 'R', 'p', 'B', 'p', '.'},
                {'.', '.', '.', 'p', 'p', '.', '.', '.'},
                {'.', '.', '.', 'B', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'}
        };

        System.out.println(solution.numRookCaptures(newchar));
    }
}
