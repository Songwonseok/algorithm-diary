import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, ArrayList<int[]>> map = new HashMap<>();
		Map<String, Integer> sumMap = new HashMap<>();

		for(int i = 0; i < genres.length; i++) {
			if(!map.containsKey(genres[i])) {
				map.put(genres[i], new ArrayList<>());
			}

			sumMap.put(genres[i], sumMap.getOrDefault(genres[i], 0) + plays[i]);
			map.get(genres[i]).add(new int[]{ i, plays[i] });
		}

		List<Map.Entry<String, Integer>> entries = sumMap.entrySet().stream()
			.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
			.collect(Collectors.toList());

		ArrayList<Integer> answer = new ArrayList<>();

		for (Map.Entry<String, Integer> entry : entries) {
			String genre = entry.getKey();

			ArrayList<int[]> list = map.get(genre);

			Collections.sort(list, (arr1, arr2) -> {
				if(arr1[1] == arr2[1]) {
					return Integer.compare(arr1[0], arr2[0]);
				}

				return -Integer.compare(arr1[1], arr2[1]);
			});

			for(int i = 0; i < 2 && i < list.size(); i++) {
				answer.add(list.get(i)[0]);
			}

		}

		return answer.stream()
			.mapToInt(Integer::intValue)
			.toArray();
    }
}