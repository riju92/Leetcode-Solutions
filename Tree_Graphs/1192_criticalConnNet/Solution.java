public class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections)
    {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer>[] graph = new ArrayList[n];
        int timer = 0;
        int[] timeStamp = new int[n];
        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for(List<Integer> connection : connections)
        {
            graph[connection.get(0)].add(connection.get(1));
            graph[connection.get(1)].add(connection.get(0));
        }

        dfs(visited, graph, result, timeStamp, -1, 0, timer);
        return result;
    }

    private void dfs(boolean[] visited, List<Integer>[] graph, List<List<Integer>> result, int[] timeStamp, int parent, int node, int timer)
    {
        visited[node] = true;
        timeStamp[node] = ++timer;
        int currentTime = timeStamp[node];

        for(int neighbour : graph[node])
        {
            if(neighbour == parent)
                continue;
            
            if(!visited[neighbour])
                dfs(visited, graph, result, timeStamp, node, neighbour, timer);

            timeStamp[node] = Math.min(timeStamp[node], timeStamp[neighbour]);

            if(currentTime < timeStamp[neighbour])
                result.add(Arrays.asList(node, neighbour));
        }
    }
    
}