import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class FibFrog {

    public int solution(int[] A) {
        List<Integer> track = Arrays.stream(A).boxed().collect(Collectors.toList());
        track.add(0, 1);
        track.add(1);
        int leafsSize = track.size();
        Integer[] path = new Integer[leafsSize];
        List<Integer> fibonacciSequence = fibonacciSeq(leafsSize);
        int[][] adjacencyMatrix = new int[leafsSize][leafsSize];
        LinkedList<Integer> q = new LinkedList<>();
        List<Integer> visited = new ArrayList<>();

        for (int i = 0; i < leafsSize; i++) {
            if (track.get(i) == 1) {
                for (int j = i + 1; j < leafsSize; j++) {
                    if (track.get(j) == 1 && fibonacciSequence.contains(j - i)) {
                        adjacencyMatrix[i][j] = 1;
                    }
                }
            }
        }

        path[0] = -1;
        q.push(0);
        visited.add(0);

        while (!q.isEmpty()) {
            int front = q.getFirst();
            q.pop();

            if (front == leafsSize - 1) {
                break;
            }

            for (int i = 0; i < leafsSize; i++) {
                if (adjacencyMatrix[front][i] != 0 && !visited.contains(i)) {
                    path[i] = front;
                    q.add(i);
                    visited.add(i);
                }
            }
        }

        int counter = 0;
        Integer it = path[leafsSize - 1];

        if (it == null)  {
            return -1;
        }

        while (it > -1) {
            it = path[it];
            if (it == null)  {
                return -1;
            }
            counter++;
        }

        return counter;
    }

    private static List<Integer> fibonacciSeq(Integer number) {
        List<Integer> sequence = new ArrayList<>(Arrays.asList(0, 1));

        for (int i = 2; i <= number; i++) {
            int nextItem = sequence.get(i - 1) + sequence.get(i - 2);
            sequence.add(nextItem);
        }

        return sequence;
    }
}

