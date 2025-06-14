import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int n,m;
	static ArrayList<Integer>[] adjustLst;
	static int[] inDegree;
	
    

    public static void main(String args[]) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	adjustLst = new ArrayList[n+1];
    	inDegree = new int[n+1];
    	for(int i = 0; i < adjustLst.length; i++) {
    		adjustLst[i] = new ArrayList<>();
    	}
    	for(int i = 0; i < m; i++) {
    		st = new StringTokenizer(br.readLine());
    		int from = Integer.parseInt(st.nextToken());
    		int to = Integer.parseInt(st.nextToken());
    		adjustLst[from].add(to);
    		inDegree[to] += 1;
    	}
    	sortTree();
    }
    
    public static void sortTree() {
    	
    	ArrayDeque<Integer> q = new ArrayDeque<>();
    	StringBuilder sb = new StringBuilder();
    	
    	for(int i = 1; i < inDegree.length; i++) {
    		if(inDegree[i] == 0) {
    			q.add(i);
    		}
    	}
    	
    	while(!q.isEmpty()) {
    		int node = q.pollFirst();
    		sb.append(node + " ");
    		for(Integer to : adjustLst[node]) {
    			inDegree[to] -= 1;
    			
    			if(inDegree[to] == 0) {
    				q.add(to);
    			}
    		}
    	}
    	
    	System.out.println(sb);
    }
}
