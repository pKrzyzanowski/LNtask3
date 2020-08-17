import java.util.*;

public class GraphCounter {
    public static void main(String[] args) {
        GraphCounter graphCounter = new GraphCounter();
        long n = graphCounter.getNumOfSeparatedGraph(graphCounter.readList());
        System.out.println(n);
    }

    public  List<Integer> readList() {
        List<Integer> list = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            list.add(in.nextInt());
            list.add(in.nextInt());
        }
        return list;
    }

    public  long getNumOfSeparatedGraph(List<Integer> list) {
        int numOfGraphs = 0;
        Map<Integer, Integer> map = new TreeMap<>();
        if (list.size() % 2 != 0) {
            System.out.println("size of the list must be even");
            return 0;
        }

        for (int i = 1; i < list.size(); i += 2) {
            int from = list.get(i - 1);
            int to = list.get(i);
            if (!map.containsKey(from) && !map.containsKey(to)) {
                numOfGraphs++;
                map.put(from, numOfGraphs);
                map.put(to, numOfGraphs);
            }
            if (!map.containsKey(from) && map.containsKey(to)) {
                map.put(from, map.get(list.get(i)));
            }
            if (map.containsKey(from) && !map.containsKey(to)) {
                map.put(to, map.get(from));
            }
            if (map.containsKey(from) && map.containsKey(to) && !map.get(from).equals(map.get(to))) {
                numOfGraphs++;
                int finalNumOfGraphs = numOfGraphs;
                int firstGraphNumber = map.get(from);
                int secondGraphNumber = map.get(to);
                map.keySet().forEach(key -> {
                    if (map.get(key).equals(firstGraphNumber) || map.get(key).equals(secondGraphNumber)) {
                        map.put(key, finalNumOfGraphs);
                    }
                });
                map.put(from, numOfGraphs);
                map.put(to, numOfGraphs);
            }

        }
        return map.values().stream().distinct().count();
    }
}