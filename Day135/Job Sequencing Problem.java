/*Job Sequencing Problem
You are given two arrays: deadline[], and profit[], which represent a set of jobs, where each job is associated with a deadline, and a profit.
Each job takes 1 unit of time to complete, and only one job can be scheduled at a time. You will earn the profit associated with a job only if it is completed by its deadline.

Your task is to find:
The maximum number of jobs that can be completed within their deadlines.
The total maximum profit earned by completing those jobs.

Examples :

Input: deadline[] = [4, 1, 1, 1], profit[] = [20, 10, 40, 30]
Output: [2, 60]
Explanation: Job1 and Job3 can be done with maximum profit of 60 (20+40).

Input: deadline[] = [2, 1, 2, 1, 1], profit[] = [100, 19, 27, 25, 15]
Output: [2, 127]
Explanation: Job1 and Job3 can be done with maximum profit of 127 (100+27).

Input: deadline[] = [3, 1, 2, 2], profit[] = [50, 10, 20, 30]
Output: [3, 100]
Explanation: Job1, Job3 and Job4 can be completed with a maximum profit of 100 (50 + 20 + 30).

Constraints:

1 ≤ deadline.size() == profit.size() ≤ 10^5
1 ≤ deadline[i] ≤ deadline.size()
1 ≤ profit[i] ≤ 500*/

class Solution {

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        // code here
        int n = deadline.length;
        int [][]jobs = new int[n][2];
        
        for(int i=0;i<n;i++){
            jobs[i][0] = deadline[i];
            jobs[i][1] = profit[i];
        }
        
        Arrays.sort(jobs, (a, b) -> Integer.compare(b[1], a[1]));
        
        int maxDeadline = 0;
        for(int i=0;i<n;i++){
            maxDeadline = Math.max(maxDeadline, jobs[i][0]);
        }
        
        boolean []slots = new boolean[maxDeadline+1];
        int totalProfit = 0, jobCnt = 0;
        
        for(int i=0;i<n;i++){
            int jobDeadline = jobs[i][0];
            int jobProfit = jobs[i][1];
            
            for(int j=jobDeadline;j>0;j--){
                if(!slots[j]){
                    slots[j] = true;
                    jobCnt++;
                    totalProfit += jobProfit;
                    break;
                }
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        res.add(jobCnt);
        res.add(totalProfit);
        
        return res;
    }
}
