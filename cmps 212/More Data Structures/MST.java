import java.util.*;

public class MST{
	public static int n;
	public static int m;
	public static int answer;
	
	public static int[] par = new int[DefineConstants.N];
	public static int[] Rank = new int[DefineConstants.N];
	
	public static ArrayList<tangible.Pair<Integer, tangible.Pair<Integer, Integer>> > edges = new ArrayList<tangible.Pair<Integer, tangible.Pair<Integer, Integer>> >();
	public static ArrayList<tangible.Pair<Integer, tangible.Pair<Integer, Integer>> > mst = new ArrayList<tangible.Pair<Integer, tangible.Pair<Integer, Integer>> >();
	
	public static LinkedList<tangible.Pair<Integer, Integer>> zeros = new LinkedList<tangible.Pair<Integer, Integer>>();
	final class DefineConstants{
		public static final int N = 2005;
	}
	public static void main(String[] args){
		n = 4;
		m = 4;
		initialize();

		Add_edge(1, 2, 1);
		Add_edge(2, 3, 1);
		Add_edge(3, 4, 1);
		Add_edge(4, 1, 1);

		compute_MST();

		query(2, 1, 2);
		query(1);
		query(3, 1, 2);
		query(1);

	}
	public static void initialize(){
		for (int i = 0; i <= n; i++){
			par[i] = i;
			Rank[i] = 0;
		}
	}
	public static void Add_edge(int u, int v, int weight){
		edges.add(new tangible.Pair<Integer, tangible.Pair<Integer, Integer>>(weight, u, v));
	}	
	public static int find(int x){
		if (par[x] != x){
			par[x] = find(par[x]);
		}
		return par[x];
	}
	public static void Union(int x, int y){
		int xroot = find(x);
		int yroot = find(y);

		if (Rank[xroot] < Rank[yroot]){
			par[xroot] = yroot;
		}
		else if (Rank[xroot] > Rank[yroot]){
			par[yroot] = xroot;
		}
		else{
			par[yroot] = xroot;
			Rank[xroot]++;
		}
	}
	public static void compute_MST(){
		Collections.sort(edges);
		for (int i = 0; i < m; i++){
			int u = find(edges.get(i).second.first);
			int v = find(edges.get(i).second.second);

			if (u == v){
				continue;
			}
			mst.add(edges.get(i));
			answer += edges.get(i).first;
			Union(u, v);
		}
	}
	public static void query(int type, int u){
		query(type, u, 0);
	}
	public static void query(int type){
		query(type, 0, 0);
	}
	public static void query(int type, int u, int v){
		if (type == 2){
			zeros.offer(new tangible.Pair<Integer, Integer>(u, v));
			Modified_Kruskal(new tangible.Pair<Integer, Integer>(-1, -1));
		}
		else if (type == 3){
			zeros.offer(new tangible.Pair<Integer, Integer>(u, v));
			Modified_Kruskal(new tangible.Pair<Integer, Integer>(u, v));
		}
		else{
			System.out.print(answer);
			System.out.print("\n");
		}
	}
}