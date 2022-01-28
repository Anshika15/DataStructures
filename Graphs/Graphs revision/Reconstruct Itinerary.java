/*

Reconstruct Itinerary

You are given a list of airline tickets where tickets[i] = [fromi, toi] represent the departure and the arrival airports of one flight. Reconstruct the itinerary in order and return it.

All of the tickets belong to a man who departs from "JFK", thus, the itinerary must begin with "JFK". If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string.

For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
You may assume all tickets form at least one valid itinerary. You must use all the tickets once and only once.

*/

class Solution {
    
    LinkedList<String> res;
    
    public List<String> findItinerary(List<List<String>> tickets) {
        
        HashMap<String, PriorityQueue<String>> graph = new HashMap<>(); // we are using pq as we need lexicographic order
        res = new LinkedList<>();
        
        for(List<String> ticket : tickets)
        {
            PriorityQueue<String> pq = graph.getOrDefault(ticket.get(0), new PriorityQueue<>());
            pq.add(ticket.get(1));
            graph.put(ticket.get(0), pq);
        }
        
        dfs("JFK", graph);
        return res;
        
    }
    
    public void dfs(String src, HashMap<String, PriorityQueue<String>> graph)
    {
        PriorityQueue<String> pq = graph.get(src); // neighbours
        while(pq != null && pq.size() > 0)
        {
            String nbr = pq.remove(); // instead of keeping visited we are removing the nbr only but if we dont want to remove then keep a hashset with val as src-nbr to keep track of edges is used or not
            dfs(nbr, graph);
        }
        res.addFirst(src); // once the dfs is done for a node add it to res
    }
}
