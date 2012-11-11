
import java.util.Scanner;

public class Solution {

	/**
	 * @param args
	 */
	public int points[][];
	public int numberOfPoints;
	public int matrix[][];
	
	public void input(){
		Scanner in = new Scanner(System.in);
		numberOfPoints = in.nextInt();
		points = new int[numberOfPoints][2];
		
		int i;
		for (i=0; i<numberOfPoints; i ++ ){
			points[i][0] = new Integer(in.nextInt());
			points[i][1] = new Integer(in.nextInt());
		}
	}
	
	public void minimum(){
		int i,j,k,l=0;
		int sum, columnsum, distance;
		matrix = new int[numberOfPoints][];
		for(i = 0; i < numberOfPoints;i++){
			
			matrix[i] = new int[numberOfPoints - i];
			
			for(j=i; j < numberOfPoints ; j++){
				distance = Math.max(Math.abs(points[i][0] - points[j][0]) , Math.abs(points[i][1] - points[j][1]));  
				matrix[i][j - i] = distance;
			}
		}
		
		sum = Integer.MAX_VALUE;
		for(i=0; i < numberOfPoints; i++){
			columnsum = 0; k=0;
			for (j=0; j < numberOfPoints - i ; j++)
				columnsum += matrix[i][j];
			
			for(j = 0; j < i; j++ ){
				columnsum += matrix[j][i - k];
				k++;
			}
			
			if (columnsum < sum){
				sum = columnsum;
			}
		}
		System.out.print(sum);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		sol.input();
		sol.minimum();
	}
}
