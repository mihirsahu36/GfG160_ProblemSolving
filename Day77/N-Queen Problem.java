/*N-Queen Problem
The n-queens puzzle is the problem of placing n queens on a (n × n) chessboard such that no two queens can attack each other. 
Note that two queens attack each other if they are placed on the same row, the same column, or the same diagonal.
Given an integer n, find all distinct solutions to the n-queens puzzle.
You can return your answer in any order but each solution should represent a distinct board configuration of the queen placements, 
where the solutions are represented as permutations of [1, 2, 3, ..., n]. In this representation, the number in the ith position denotes the row in which the queen is placed in the ith column.
For eg. below figure represents a chessboard [3 1 4 2].

Examples:

Input: n = 1
Output: [1]
Explaination: Only one queen can be placed in the single cell available.

Input: n = 4
Output: [[2 4 1 3 ] [3 1 4 2 ]]
Explaination: There are 2 possible solutions for n = 4.

Input: n = 2
Output: []
Explaination: There are no possible solutions for n = 2.

Constraints:

1 ≤ n ≤ 10*/

class Solution {
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        boolean []column = new boolean[n];
        boolean []diag = new boolean[2*n-1];
        boolean []anti_diag = new boolean[2*n-1];
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> currSol = new ArrayList<>();
        solve(n, 0, column, diag, anti_diag, res, currSol);
        return res;
    }
    
    static void solve(int n, int row, boolean[] column, boolean[] diag, boolean[] anti_diag, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> currSol){
        if (row == n){
            res.add(new ArrayList<>(currSol));
            return;
        }
        
        for(int col=0;col<n;col++){
            if(column[col] == false && diag[row+col] == false && anti_diag[row-col+n-1] == false){
                currSol.add(col+1);
                column[col] = true;
                diag[row+col] = true;
                anti_diag[row-col+n-1] = true;
                 
                solve(n, row + 1, column, diag, anti_diag, res, currSol);
                 
                currSol.remove(currSol.size() - 1);
                column[col] = false;
                diag[row+col] = false;
                anti_diag[row-col+n-1] = false;
            }
        }
    }
}
