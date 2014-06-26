/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        return cloneGraphRecur(node, 
                                new HashMap <UndirectedGraphNode, UndirectedGraphNode> ());
    }
    
    private UndirectedGraphNode cloneGraphRecur(UndirectedGraphNode node, Map <UndirectedGraphNode, UndirectedGraphNode> clonedMap) {
        if (clonedMap.containsKey(node)) {
            return clonedMap.get(node);
        }
        
        UndirectedGraphNode newGraphNode = new UndirectedGraphNode(node.label);
        clonedMap.put(node, newGraphNode);
        for(UndirectedGraphNode n: node.neighbors) {
            newGraphNode.neighbors.add(cloneGraphRecur(n, clonedMap));
        }
        
        return newGraphNode;
    }
}
