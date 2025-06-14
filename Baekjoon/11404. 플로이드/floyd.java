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
	
	
	static int n, m;
	static int[][] cost;
	static int INF = Integer.MAX_VALUE;
	
	
    public static void main(String args[]) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	n = Integer.parseInt(br.readLine());
    	m = Integer.parseInt(br.readLine());
    	
    	// initialize cost table
    	cost = new int[n+1][n+1];
    	for(int i = 1; i < n+1; i++) {
    		Arrays.fill(cost[i], INF);
    		cost[i][i] = 0;
    	}
    	
    	for(int i = 0; i < m; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		int c = Integer.parseInt(st.nextToken());
    		cost[a][b] = Math.min(cost[a][b], c);
    	}
    	
    	floydWarshall();
    }
    
    
    public static void floydWarshall() {
    	
    	for(int k = 1; k <= n; k++) {
    		for(int f = 1; f <= n; f++) {
    			for(int t = 1; t <= n; t++) {
    				if(cost[f][k] == INF || cost[k][t] == INF) {
    					continue;
    				}
    				
    				if(cost[f][t] > cost[f][k] + cost[k][t]) {
    					cost[f][t] = cost[f][k] + cost[k][t];
    				}
    			}
    		}
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	
    	for(int i = 1; i <= n; i++) {
    		for(int j = 1; j <= n; j++) {
    			if(cost[i][j] == INF) {
    				sb.append("0 ");
    				continue;
    			}
    			sb.append(cost[i][j] + " ");
    		}
    		sb.append("\n");
    	}
    	System.out.println(sb);
    }
    
}
