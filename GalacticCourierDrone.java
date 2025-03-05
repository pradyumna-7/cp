/*
In a distant galaxy, a delivery drone is assigned to transport supplies between n space stations arranged in a circular orbit. 
Each space station provides a certain amount of fuel, and the drone requires a specific amount of fuel to travel from one station
to the next in a clockwise direction.

The drone begins its journey with an empty fuel tank and must start from one of the stations.
Your task is to determine from which station the drone should start its journey to successfully 
complete one full trip around the orbit without running out of fuel. 
If it is impossible to complete the journey from any station, return -1.

Input Format:
--------------
An integer n representing the number of space stations.
An array fuel[i], where fuel[i] is the amount of fuel available at the ith station.
An array cost[i], where cost[i] is the fuel required to travel from station i to station (i+1) % n.

Output Format:
--------------
Return the index of the station where the drone should start its journey. If no such station exists, return -1.

Example 1:
----------
Input=
5  
fuel = [1, 2, 3, 4, 5]  
cost = [3, 4, 5, 1, 2]  
Output=
3
Explanation:
------------
Start at station 3 with 4 units of fuel. tank = 4.
Travel to station 4, consume 1 fuel, gain 5. tank = 4 - 1 + 5 = 8.
Travel to station 0, consume 2 fuel, gain 1. tank = 8 - 2 + 1 = 7.
Travel to station 1, consume 3 fuel, gain 2. tank = 7 - 3 + 2 = 6.
Travel to station 2, consume 4 fuel, gain 3. tank = 6 - 4 + 3 = 5.
Travel back to station 3, consume 5 fuel. tank = 5 - 5 = 0.
The drone successfully returns to station 3, so we return 3.

Example 2:
----------
Input=
3  
fuel = [2, 3, 4]  
cost = [3, 4, 3]  
Output=
-1
Explanation:
------------
Starting from any station, the drone will eventually run out of fuel before completing the journey.
Therefore, it's impossible to complete a full cycle, and the output is -1.

Constraints
-----------
1 <= n <= 10⁵
0 <= fuel[i], cost[i] <= 10⁴
The space stations are arranged in a circular path.
 */

import java.util.*;
class Solution{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int fuel[] = new int[n];
        int cost[] = new int[n];
        for(int i=0; i<n; i++) fuel[i] = sc.nextInt();
        for(int i=0; i<n; i++) cost[i] = sc.nextInt();
        
        int totCost=0, totFuel=0;
        for(int i=0; i<n; i++){
            totCost+=cost[i];
            totFuel+=fuel[i];
        }
        
        if(totFuel<totCost){
            System.out.print(-1);
            System.exit(0);
        }
        
        int start =0, currf=0;
        for(int i=0; i<n; i++){
            currf+=fuel[i]-cost[i];
            
            if(currf<0){
                start=i+1;
                currf=0;
            }
        }
        
        System.out.println(start);
    }
}