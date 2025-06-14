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
	
	static class Edge{
		int from;
		int to;
		int cost;
		
		public Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}
	
	
	static int n, m;
	static ArrayList<Edge> edges;
	static long[] distance;
	
	
    public static void main(String args[]) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	edges = new ArrayList<>();
    	distance = new long[n+1];
    	for(int i = 0; i < m; i++) {
    		st = new StringTokenizer(br.readLine());
    		int from = Integer.parseInt(st.nextToken());
    		int to = Integer.parseInt(st.nextToken());
    		int cost = Integer.parseInt(st.nextToken());
    		edges.add(new Edge(from, to, cost));
    	}
    	
    	if(bellman(1)) {
    		System.out.println("-1");
    		return;
    	}
    	StringBuilder sb = new StringBuilder();
    	for(int i = 2; i < n+1; i++) {
    		if(distance[i] == Long.MAX_VALUE) {
    			sb.append("-1\n");
    		}
    		else {
    			sb.append(distance[i] + "\n");
    		}
    	}
    	
    	System.out.println(sb);
    }
    
    
    public static boolean bellman(int start) {
    	Arrays.fill(distance, Long.MAX_VALUE);
    	distance[start] = 0;
    	
    	for(int i = 1; i < n+1; i++) {
    		for(int j = 0; j < m; j++) {
    			Edge e = edges.get(j);
    			if(distance[e.from] == Long.MAX_VALUE) {
    				continue;
    			}
    			
    			if(distance[e.to] > distance[e.from] + e.cost) {
    				if(i == n) {
    					return true;
    				}
    				distance[e.to] = distance[e.from] + e.cost;
    			}
    		}
    	}
    	
    	return false;
    }

}
