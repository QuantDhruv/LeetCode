import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1); // First element is always 1

            // Fill in the middle elements
            for (int j = 1; j < i; j++) {
                int prevRowVal = triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j);
                row.add(prevRowVal);
            }

            if (i > 0) {
                row.add(1); // Last element is always 1 (except for first row)
            }

            triangle.add(row);
        }

        return triangle;
    }
}
