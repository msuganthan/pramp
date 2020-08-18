import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PairWithSpecificDifference {

    public static void main(String[] args) {
        
    }

    static int[][] findPairsWithGivenDifference(int[] arr, int k) {
        Set<Integer> set = new HashSet<>();
        List<int[]> result = new ArrayList<>();
        for(int n: arr) {
          set.add(n);
        }

        for(int n: arr) {
          int targetElement = k + n; // 0 - (-1) => 1
          if(set.contains(targetElement)) {
            result.add(new int[] {targetElement, n});
          }
        }

        int[][] res = new int[result.size()][2];
        for(int i = 0; i< result.size(); i++) {
          res[i] = result.get(i);
        }
        return res;
    }
}
