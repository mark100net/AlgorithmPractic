// based on problem statement at:
// http://www.practice.geeksforgeeks.org/problem-page.php?pid=497

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
	    Scanner scan = new Scanner(System.in);
	    int t = scan.nextInt();
	    for (int i = 0; i < t; i++) {
	        int n = scan.nextInt();
	        int [][] grid = new int[n][n];
	        for (int r = 0; r < n; r++) {
	            for (int c = 0; c < n; c++) {
	                grid[r][c] = scan.nextInt();
	            }
	        }
	        rotate(grid);
	        printGrid(grid);
	    }
	}
	
	private static void rotate(int [][]grid) {
	    int rows = grid.length;
	    if (rows > 1) {
	        for (int topLeft = (rows / 2) - 1; topLeft >= 0; topLeft--) {
	            rotateLayer(grid, topLeft);
	        }
	    }
	}
	
	private static void rotateLayer(int [][]grid, int rowCol) {
		int rightCol = grid.length - rowCol - 1;
	    int bottomRow = rightCol;
	    for (int col = rowCol; col < rightCol; col++) {
	        //swap top and right
	        swap(grid, rowCol, col, col, rightCol);
	        //top and bottom
	        swap(grid, rowCol, col, bottomRow, rightCol - (col - rowCol));
	        //top and left
	        swap(grid, rowCol, col, bottomRow - (col - rowCol), rowCol);
	    }
	}

    private static void swap(int [][] grid, int fromRow, int fromCol, int toRow, int toCol) {
        int temp = grid[fromRow][fromCol];
        grid[fromRow][fromCol] = grid[toRow][toCol];
        grid[toRow][toCol] = temp;
    }
    
    private static void printGrid(int [][] grid) {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (row > 0 || col > 0) {
                    System.out.print(" ");
                }
                System.out.print(grid[row][col]);
            }
        }
        System.out.println();
    }
}
