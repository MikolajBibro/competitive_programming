import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GuidewireTask1 {

    public int solution(int[] A, int[] B) {
        int overlaps = 0;
        int disjoints;

        List<Integer> arrayA = IntStream.of(A).boxed().collect(Collectors.toList());
        List<Integer> arrayB = IntStream.of(B).boxed().collect(Collectors.toList());

        List<Pair> pairs = new ArrayList<>();
        int size = Math.min(arrayA.size(), arrayB.size());


        for (int i = 0; i < size; i++) {
            pairs.add(new Pair(arrayA.get(i), arrayB.get(i)));
        }

        System.out.println(pairs.size());
        HashSet<Pair> intervalsWithPair = new HashSet<>();

        for (int i = 0; i < pairs.size() - 1; i++) {
            Pair pair1 = pairs.get(i);
            for (int j = i + 1; j < pairs.size(); j++) {
                if(isOverlapping(pair1, pairs.get(j))) {
                    intervalsWithPair.add(pair1);
                    intervalsWithPair.add(pairs.get(j));
                    overlaps++;
                }
            }
        }
        disjoints = pairs.size() - intervalsWithPair.size();
        return overlaps + disjoints;
    }

    public boolean isOverlapping(Pair pair1, Pair pair2) {
        return Math.max(pair1.getA(), pair2.getA()) <= Math.min(pair1.getB(), pair2.getB());
    }


    public static class Pair {
        private int a;
        private int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int getA() {
            return a;
        }

        public int getB() {
            return b;
        }
    }
}

