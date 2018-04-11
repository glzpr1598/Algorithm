package algorithm.q14503;

import java.util.Scanner;

// 14503 로봇 청소기
// https://www.acmicpc.net/problem/14503
public class Main {
	static int[][] room;
    static int[][] cleaned;
    static int r, c, d;
    static int answer = 0;
 
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
 
        int n = scanner.nextInt();
        int m = scanner.nextInt();
 
        r = scanner.nextInt();
        c = scanner.nextInt();
        d = scanner.nextInt();
 
        room = new int[n][m];
        cleaned = new int[n][m];
        
        for (int i=0; i<n; i++)
        {
            for (int j=0; j<m; j++)
            {
                room[i][j] = scanner.nextInt();
            }
        }
        clean();
 
        System.out.println(answer);
 
        scanner.close();
    }
 
    public static void clean ()
    {
        int[] dir_r = {-1, 0, 1, 0};
        int[] dir_c = {0, 1, 0, -1};
        
        int count = 0;    // 현재 위치에서의 탐색 카운트
        while(true)
        {
            // 1. 현재 위치 청소
            if (cleaned[r][c] == 0)
            {
                cleaned[r][c] = 1;
                answer++;
            }
            
            // 2. 왼쪽방향 탐색
            int left_d = turn(d);    // 왼쪽방향
            int left_r = r + dir_r[left_d];    // 왼쪽 방 r좌표
            int left_c = c + dir_c[left_d]; // 왼쪽 방 c좌표 
            
            // 2.1 왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
            if (room[left_r][left_c] == 0 && cleaned[left_r][left_c] == 0)
            {
                d = turn(d);    // 회전
                r = r + dir_r[d];    // d 방향으로 전진
                c = c + dir_c[d];
                count = 0;
                continue;
            }
            // 왼쪽 방향에 청소할 방향이 없다면
            else
            {
                if (count == 4)    // 2.3 네 방향 모두 청소가 이미 되어있거나 벽인 경우
                {
                    if (room[r-dir_r[d]][c-dir_c[d]] == 1)    // 2.4 뒤쪽이 벽이라면
                        break;    // 작동 중지
                    
                    r = r - dir_r[d];    // d 방향에서 후진
                    c = c - dir_c[d];
                    count = 0;
                    continue;
                }
                
                d = turn(d);    // 2.2 청소할 방이 없으면 회전
                count++;
                continue;
                
            }
            
        }
        
 
 
    }
    
    public static int turn (int d)
    {
        switch(d)
        {
        case 0 : return 3;
        case 1 : return 0;
        case 2 : return 1;
        case 3 : return 2;
        default : return -1;
        }
    }
}
