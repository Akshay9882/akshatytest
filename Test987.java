import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'maxDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY px as parameter.
     */
    public static int maxDifference(List<Integer> px) {
        // Write your code here
       //Collections.sort(px);
        Integer[] input = new Integer[px.size()];
        px.toArray(input);      
        int maxCount = 0, tempMaxCount = 0, smallest = 0;
        int current = 0;
        for (int i = 0; i < px.size(); i++) {
            smallest = input[i];
            current = input[i];
            for (int j = i - 1; j >= 0; j--) {
                if (input[j] < smallest) {
                    smallest = input[j];
                }
            }
           if (current != smallest) {
                tempMaxCount = current - smallest;
                if (tempMaxCount > maxCount) {
                    maxCount = tempMaxCount;
                }
            }
        }
        if (maxCount == 0) {
            return -1;
        }
        return maxCount;
    }

}

public class Test987 {

    public static void main(String[] args) throws IOException {
        // String fileName = "C:\\input005.txt";

        BufferedReader bufferedReader = new BufferedReader(new FileReader("E:\\input005.txt"));
        //  FileReader bufferedReader=new FileReader(fileName);  

        //   BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int pxCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> px = IntStream.range(0, pxCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.maxDifference(px);
        System.out.println("result" + result);
        //    bufferedWriter.write(String.valueOf(result));
        //     bufferedWriter.newLine();

        //      bufferedReader.close();
        //       bufferedWriter.close();
    }
}
