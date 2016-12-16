
public class FloydWarshall {

	public static void main(String[] args) {
		int k = 1;
		int i = 1;
		int j = 1;
		
		int n = 5;
		int values[][] = new int[2][3];
		for(k = 1; k <= n;k++) {
			for(i = 1; i <= n;i++) {
				for(j = 1; j <= n;j++) {
					values[0][0] = i;
					values[0][1] = k;
					values[0][2] = k - 1;
					values[1][0] = k;
					values[1][1] = j;
					values[1][2] = k - 1;
					System.out.printf("A[%d, %d, %d] = A[%d, %d, %d] + A[%d, %d, %d]", i, j, k, values[0][0], values[0][1], values[0][2], 
							values[1][0], values[1][1], values[1][2]);
					System.out.println();
				}
			}
		}

	}

}
