
public class node {

    int x;
	int y;
    int[][] arr; 
    String word; 
    String path;
       
    public node (int x, int y, int[][] inBoard){
    	this.x = x;
    	this.y = y;
    	this.arr = inBoard;
    	this.word= ""; 
    	this.path="";
    	
		 for (int j = 0; j < x; j++) {
			for (int j2 = 0; j2 < y; j2++) {
				this.word= this.word+ String.valueOf(inBoard[j][j2]);
			}
		}	
    }  
    public node(node c) {
    	this.x= c.x;
    	this.y= c.y;
    	this.word= c.word;
    	int arr1[][]= new int[c.x][c.y];
    	for (int i = 0; i < c.x; i++) {
    		for (int j = 0; j < c.y; j++) {
    			arr1[i][j]=c.arr[i][j];
    		 }
		 }
    	this.arr= arr1;
     }
  }




  
    

