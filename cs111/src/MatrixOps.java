
public class MatrixOps {
	public static double[][] multiply(double[][] matrix1, double[][] matrix2)
	{
		double[][] matrix3;
		matrix3=new double [matrix1.length][(matrix2[0].length)];
		if(matrix1.length!=matrix2[0].length){
			IO.reportBadInput();
		}
		int a=0;
		int b=0;
		int c=0;
		int d=0;
		int k=0;
		int j=0;
		for(j=0,d=0;j<matrix1.length;j++,d++){
			for(b=0,c=0;b<matrix2.length;b++,c++){
				matrix3[k][j]+=((matrix1[a][b]*matrix2[c][d]));
			}
		}
		for(k=1,d=0,a=1,j=0;j<matrix2[0].length;d++,j++){
			for(b=0,c=0;b<matrix1[0].length;b++,c++){
				matrix3[k][j]+=((matrix1[a][b]*matrix2[c][d]));
			}
		}
		return matrix3;
	}
}

