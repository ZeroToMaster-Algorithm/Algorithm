import java.util.*;
class Solution {
    public int solution(int[] citations) {
        
        
        int answer = 0;
        Arrays.sort(citations);
        
   
        for(int i=0;i<citations.length;i++)
        {
            int nowNum =citations[i];
    
            // 0 1 2 3
            // 
            
            if(citations.length-i <=nowNum)
            {
               return citations.length-i;
            }

        }
        
        return answer;
        
        //  0 1 3 5 6
        
        // 1 1 4 4 4 5
        
    }
}
