import java.util.*;

/** Kadane-style linear maximum subsequence sum with indexes. */
public class MaxSubsequenceLinear {
    static class Result { int sum,start,end; Result(int s,int a,int b){sum=s;start=a;end=b;} }
    public static Result solve(int[] a) {
        int best = a[0], bestStart = 0, bestEnd = 0;
        int current = a[0], currentStart = 0;
        for (int i=1;i<a.length;i++) {
            if (current < 0) { current = a[i]; currentStart = i; }
            else current += a[i];
            if (current > best) { best=current; bestStart=currentStart; bestEnd=i; }
        }
        return new Result(best,bestStart,bestEnd);
    }
    public static void run(){int[] a={4,-3,5,-2,-1,2,6,-2};Result r=solve(a);System.out.println("-- MaxSubsequenceLinear sum="+r.sum+" start="+r.start+" end="+r.end+"\n");}
    public static void main(String[] args){run();}
}
