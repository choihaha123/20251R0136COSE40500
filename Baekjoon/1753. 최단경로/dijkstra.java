import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	
	static class Node{
		int node;
		int cost;
		
		public Node(int node, int cost) {
			this.node = node;
			this.cost = cost;
		}
	}
	
	static int v,e;
	static int start;
	static ArrayList<Node>[] adjList;
	static int[] distance;
	static boolean[] visited;
	
	
    public static void main(String args[]) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	v = Integer.parseInt(st.nextToken());
    	e = Integer.parseInt(st.nextToken());
    	adjList = new ArrayList[v+1];
    	visited = new boolean[v+1];
    	distance = new int[v+1];
    	for(int i = 0; i < v+1; i++) {
    		adjList[i] = new ArrayList<>();
    	}
    	start = Integer.parseInt(br.readLine());
    	for(int i = 0; i < e; i++) {
    		st = new StringTokenizer(br.readLine());
    		int u = Integer.parseInt(st.nextToken());
    		int v = Integer.parseInt(st.nextToken());
    		int w = Integer.parseInt(st.nextToken());
    		adjList[u].add(new Node(v, w));
    	}
    	
    	
    	dijkstra();
    	
    }
    
    public static void dijkstra() {
    	PriorityQueue<Node> q = new PriorityQueue<>((e1,e2) -> {
    		return e1.cost-e2.cost;
    	});
    	q.add(new Node(start, 0));
    	
    	Arrays.fill(distance, Integer.MAX_VALUE);
    	distance[start] = 0;
    	
    	while(!q.isEmpty()) {
    		Node n = q.poll();
    		
    		if(visited[n.node]) {
    			continue;
    		}
    		visited[n.node] = true;
    		
    		for(Node next : adjList[n.node]) {
    			if(distance[next.node] > next.cost + n.cost) {
    				distance[next.node] = next.cost + n.cost;
    				q.add(new Node(next.node, distance[next.node]));
    			}
    		}
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	
    	for(int i = 1; i < v+1; i++) {
    		if(distance[i] == Integer.MAX_VALUE) {
    			sb.append("INF\n");
    		}
    		else {
    			sb.append(distance[i] + "\n");
    		}
    	}
    	System.out.println(sb);
    	
    }
    
}
