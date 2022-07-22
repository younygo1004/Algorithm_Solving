package swea.D4.s3124_최소_스패닝_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
	int from;
	int to;
	int weight;
	
	
	public Edge(int from, int to, int weight) {
		super();
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
	
	
	@Override
	public int compareTo(Edge o) {
		
		return this.weight - o.weight;
	}


	@Override
	public String toString() {
		return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]\n";
	}
	
	
	
	
}

public class Solution3124_Kruskal {
	
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			parent = new int[V+1];
			Edge[] es = new Edge[E];
			
			for (int i = 0; i < parent.length; i++) { // 서로소 집합 초기화
				parent[i] = i;
			}
			
			for (int i = 0; i < es.length; i++) { // 간선 리스트 (배열) 초기화
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				
				es[i] = new Edge(from, to, weight);
				
			}
			
			Arrays.sort(es); // 간선을 오름차순으로 정렬
			
			int edgeCount = 0;
			long sumWeights = 0;
			
			for (int i = 0; i < es.length; i++) {
				if(union(es[i].from, es[i].to)) {
					edgeCount++;
					sumWeights += (long)es[i].weight;
					
					if(edgeCount == V-1)
						break;
					
				}
			}
			
			System.out.printf("#%d %d\n", tc, sumWeights);
			
			
		}
		
		br.close();

	}
	
	private static int findParent(int v) {
		if(v==parent[v]) return v;
		
		return parent[v] = findParent(parent[v]);
	}
	
	private static boolean union(int from, int to) {
		int f = findParent(from);
		int t = findParent(to);
		
		if(findParent(from) == findParent(to)) // 부모가 같으면 합치기 불가
			return false; 
		
		parent[t] = f;
		return true;
	}

}

