
public class node implements Comparable<node> {

    int x;
	int y;	
    int[][] arr; 
    String word; 
    String path;
    int priority=0;
	int sum=0;
       
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
    public node (int x, int y, int[][] inBoard, int priority,int sum){
    	this.x = x;
    	this.y = y;
    	this.arr = inBoard;
    	this.word= ""; 
    	this.path="";
    	this.priority=0;
    	this.sum=0;
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
    	this.priority=c.priority;
    	this.sum=c.sum;
    	int arr1[][]= new int[c.x][c.y];
    	for (int i = 0; i < c.x; i++) {
    		for (int j = 0; j < c.y; j++) {
    			arr1[i][j]=c.arr[i][j];
    		 }
		 }
    	this.arr= arr1;
     }
    
    public static node up(node first, int x, int y) {
 	   node firs= new node(first);
 	   firs.arr[x][y]= firs.arr[x+1][y];
 	   firs.arr[x+1][y]= 0;
 	   return firs;	 
    }
    public static node down(node first, int x, int y) {
 	   node firs= new node(first);
 	   firs.arr[x][y]= firs.arr[x-1][y];
 	   firs.arr[x-1][y]= 0;
 	   return firs;	 
    }
    public static node right(node first, int x, int y) {
 	   node firs= new node(first);
 	   firs.arr[x][y]= firs.arr[x][y-1];
 	   firs.arr[x][y-1]= 0;
 	   return firs;	 
    }
    public static node left(node first, int x, int y) { 
 	   node firs= new node(first);
 	   firs.arr[x][y]= firs.arr[x][y+1];
 	   firs.arr[x][y+1]= 0;
 	   return firs;	 
    }    
    public static node leftleft(node first, int x0, int y0, int x1, int y1){ 
  	   node firs= new node(first);
  	   firs.arr[x0][y0]= firs.arr[x0][y0+1];
  	   firs.arr[x0][y0+1]= 0;
  	   firs.arr[x1][y1]= firs.arr[x1][y1+1];
	   firs.arr[x1][y1+1]= 0;
  	   return firs;	 
     }    
    public static node rightright(node first, int x0, int y0, int x1, int y1){ 
   	   node firs= new node(first);
   	  firs.arr[x0][y0]= firs.arr[x0][y0-1];
	   firs.arr[x0][y0-1]= 0;
	   firs.arr[x1][y1]= firs.arr[x1][y1-1];
	   firs.arr[x1][y1-1]= 0;
   	   return firs;	 
      }    
    public static node upup(node first, int x0, int y0, int x1, int y1){ 
    	   node firs= new node(first);
    	   firs.arr[x0][y0]= firs.arr[x0+1][y0];
     	   firs.arr[x0+1][y0]= 0;
     	   firs.arr[x1][y1]= firs.arr[x1+1][y1];
    	   firs.arr[x1+1][y1]= 0;
    	       return firs;	 
       }    
    public static node downdown(node first, int x0, int y0, int x1, int y1){ 
    	   node firs= new node(first);
    	   firs.arr[x0][y0]= firs.arr[x0-1][y0];
     	   firs.arr[x0-1][y0]= 0;
     	   firs.arr[x1][y1]= firs.arr[x1-1][y1];
    	   firs.arr[x1-1][y1]= 0;
    	   return firs;	 
       }    
    public static String stringtrue(node x) {
 	   String s= "";
 	   for (int j = 0; j < x.arr.length; j++) {
			for (int j2 = 0; j2 < x.arr[0].length; j2++) {
				s= s+ String.valueOf(x.arr[j][j2]);
			}
		}   
 	   return s;
    }    
    public static int findnumof0(node c) {
    	 int x=0;
	 	  for (int i = 0; i < c.x; i++) {
				for (int j = 0; j < c.y; j++) {
					if (c.arr[i][j]==0) x++;
					}
					}
	 	  return x;
				}
	
    public static int[] find0(node c) {
	    int x0 = 0, y0 =0;
	 	  for (int i = 0; i < c.x; i++) {
				for (int j = 0; j < c.y; j++) {
					if (c.arr[i][j]==0) {
						x0= i;
						y0= j; 
					}					
				}
			}
	 	  int[] arr1= {x0,y0};
	    return arr1;
	  }
    public static int[] find02(node c) {
    	 int[] arr1= {0,0,0,0};
		 int k=0;
	 	  for (int i = 0; i < c.x; i++) {
				for (int j = 0; j < c.y; j++) {
					if (c.arr[i][j]==0) {
						arr1[k]= i;
						arr1[k+1]= j; 
						k+=2;
					}					
				}
			}	 
	    return arr1;
	  }
    public int compareTo(node o) {
        return o.priority > this.priority ? -1 : 1;
    }
  }




  
    

