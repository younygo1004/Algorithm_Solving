import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int waiting = 0;
		int time = 0;
		List<Integer>[] humans = new LinkedList[N+1];
		
		for (int i = 0; i < humans.length; i++) {
			humans[i] = new LinkedList<Integer>();
		}
		
		for (int i = 1; i <= N; i++) {
			int idx = sc.nextInt();
			
			humans[idx].add(idx);
		}
		
		for (List<Integer> list : humans) {
			for (int v : list) {
				waiting += v;
				time += waiting;
			}
		}
		
		
		System.out.println(time);
		
	}

}
