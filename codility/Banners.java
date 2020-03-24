import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Banners {

    public int solution(int[] H) {
        int area;
        int minArea;

        List<Integer> buildings = IntStream.of(H)
                .boxed()
                .collect(Collectors.toList());

        int oneBannerHeight = buildings.stream()
                .max(Comparator.comparing(Integer::intValue))
                .orElseThrow(NoSuchElementException::new);

        minArea = oneBannerHeight * buildings.size();

        for (int i = 1; i < buildings.size(); i++) {

            int firstBannerHeight = buildings.subList(0, i).stream()
                    .max(Comparator.comparing(Integer::intValue))
                    .orElseThrow(NoSuchElementException::new);

            int secondBannerHeight = buildings.subList(i, buildings.size()).stream()
                    .max(Comparator.comparing(Integer::intValue))
                    .orElseThrow(NoSuchElementException::new);

            area = firstBannerHeight * i + secondBannerHeight * (buildings.size() - i);

            if (area < minArea) {
                minArea = area;
            }
        }
        return minArea;
    }
}
