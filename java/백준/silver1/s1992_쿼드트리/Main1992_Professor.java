package bj.silver1.s1992_쿼드트리;



/** 

입력

8
11110000
11110000
00011100
00011100
11110000
11110000
11110011
11110011


출력

((110(0101))(0010)1(0001)) 
*/

import java.util.Scanner;
 
public class Main1992_Professor {
    private static char map[][];
 
    private static String data = "8\n" + 
    		"11110000\n" + 
    		"11110000\n" + 
    		"00011100\n" + 
    		"00011100\n" + 
    		"11110000\n" + 
    		"11110000\n" + 
    		"11110011\n" + 
    		"11110011";
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(data);
        int N = sc.nextInt();
 
        map = new char[N][N];
 
        for (int i = 0; i < N; i++) {
            map[i] = sc.next().toCharArray();
        }
        
        solve(0, 0, N);
        sc.close();
    }
 
    private static boolean isSame(int x, int y, int n) {
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (map[x][y] != map[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
 
    private static void solve(int x, int y, int n) {
        if (isSame(x, y, n)) {
            System.out.print(map[x][y]);
            return;
        } 
        
        System.out.print("(");
        int s = n / 2;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                solve(x + s * i, y + s * j, s);
            }
        }
        System.out.print(")");
    }
}