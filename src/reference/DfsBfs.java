package reference;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//DFS, BFS

//첫 줄에 정점의 개수 N과 간선의 개수 M이 주어집니다.
//다음 M줄에 간선의 관계 시작정점 u와 도착정점 v가 주어집니다.
//입력에 따른 깊이 우선 탐색 결과를 출력합니다.
public class DfsBfs {
	static int n;    // 정점
    static int m;    // 간선
    static boolean[][] edge;    // 인접행렬
    static boolean[] visited;    // 방문여부
 
    public static void main (String[] args)    {
        Scanner scanner = new Scanner(System.in);
 
        n = scanner.nextInt();    
        m = scanner.nextInt();    
        edge = new boolean[n+1][n+1];    
        visited = new boolean[n+1];    
        
        for (int i=0; i<m; i++)
        {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            edge[u][v] = true;
        }
        
        dfs(1);
        //bfs(1);
 
        scanner.close();
    }
    
    public static void dfs (int cur)
    {
        visited[cur] = true;
        System.out.print(cur + " ");
        for (int i=1; i<=n; i++)
        {
            if (visited[i] || !edge[cur][i])    // 방문했거나 연결되어있지 않으면
                continue;
            dfs(i);
        }
    }
    
    public static void bfs (int cur)
    {
        Queue<Integer> q = new LinkedList<>();
        visited[cur] = true;
        q.add(cur);        // 큐에 현재 정점 추가
        
        while (!q.isEmpty())    // 큐가 빌 때까지
        {
            int here = q.remove();    // 헤드를 제거하고 here에 대입
            System.out.print(here + " ");
            
            for (int there=1; there<=n; there++)
            {
                if (visited[there] || !edge[here][there])    // 방문했거나 연결되어있지 않으면
                    continue;
                visited[there] = true;
                q.add(there);
            }
        }
    }

}
