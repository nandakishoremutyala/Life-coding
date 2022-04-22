/**

https://leetcode.com/problems/reconstruct-itinerary/
*/
class ReconstructItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {

        ConcurrentHashMap<String, LinkedList<String>> map = new ConcurrentHashMap<>();

        for (List<String> l : tickets) {
            String src = l.get(0);
            String dest = l.get(1);

            map.compute(src, (k, v) -> v == null ? new LinkedList<>() : v).add(dest);
        }

        System.out.println(map);

        for (Map.Entry<String, LinkedList<String>> e : map.entrySet()) {
            Collections.sort(e.getValue());
        }
        List<String> result = new ArrayList<>();
        dfs("JFK", map, result);
        Collections.reverse(result);
        return result;
    }

    private void dfs(String src, Map<String, LinkedList<String>> map, List<String> result) {

        if (map.containsKey(src)) {
            LinkedList<String> destList = map.get(src);
            while (!destList.isEmpty()) {
                // while we visit the edge, we trim it off from graph.
                String dest = destList.pollFirst();
                dfs(dest, map, result);
            }
        }
        result.add(src);
    }

}
