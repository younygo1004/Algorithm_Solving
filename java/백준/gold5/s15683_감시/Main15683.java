package bj.gold5.s15683_감시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


class Location{
	int r;
	int c;
	
	public Location(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}

	@Override
	public String toString() {
		return "Location [r=" + r + ", c=" + c + "]";
	}
	
}

class CCTV extends Location{
	int type;
	int[] cctv;

	public CCTV(int r, int c, int type) {
		super(r, c);
		this.type = type;
	}

	@Override
	public String toString() {
		return "CCTV [r=" + r + ", c=" + c + ", type=" + type + "]";
	}
	
	
	
}

public class Main15683 {
	
	static int R, C;
	static ArrayList<CCTV> CCTVs = new ArrayList<CCTV>();
	static ArrayList<Location> walls = new ArrayList<Location>();
	
	// 상, 우, 하, 좌
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				int type = Integer.parseInt(st.nextToken());
				if(type != 0) {
					if(type == 6)
						walls.add(new Location(i, j));
					else 
						CCTVs.add(new CCTV(i, j, type));
				}
			}
		}
		
		br.close();
	}

}
