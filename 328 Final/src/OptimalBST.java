
public class OptimalBST {

	public static void main(String[] args) {
		double prob[] = {0, .25, .2, .05, .2, .3};
		BST(prob);
	}

	private static void BST(double[] prob) {
		int n = prob.length;
		double e[][] = new double[n + 1][n];
		double w[][] = new double[n + 1][n];
		int root[][] = new int[n + 1][n + 1];
		
		for(int i = 1;i < n + 1;i++) {
			e[i][i-1] = 0;
			w[i][i-1] = 0;
		}
		
		for(int l = 1;l < n; l++) {
			for(int i = 1; i < n-l+1;i++) {
				int j = i+l-1;
				e[i][j] = 10;
				printMatrix(e);
				w[i][j] = w[i][j-1] + prob[j];
		 		for(int r = i; r < j; r++) {
		 			double t = e[i][r-1] + e[r+1][j] + w[i][j];
		 			if(t < e[i][j]) {
		 				e[i][j] = t;
		 				root[i][j] = r;
		 			}
		 		}
			}
		}
		

	}

	public static void printMatrix(double[][] matrix) {
	    for (int row = 1; row < matrix.length; row++) {
	        for (int col = 0; col < matrix[row].length; col++) {
	            System.out.print(matrix[row][col] + "   ");
	        }
	        System.out.println();
	    }
	}
}
