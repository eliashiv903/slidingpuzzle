import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class main {
	
    public static void main(String[] args) {
      
 	   int arr[][]= {{2,6,4},{3,8,1},{7,5,0}};
 	   int arr1[][]= {{1,2,3},{4,5,6},{7,8,0}};
        node a1= new node(3,3,arr);
        node a2= new node(3,3, arr1);
        System.out.println(bfs(a1, a2));  
    }
	  public static String bfs(node start, node end){
		  Set<String> visited = new HashSet<String>();
	      Queue<node> boards = new LinkedList<node>();
	      boards.add(start);
	      visited.add(start.word);
	      while(!boards.isEmpty()) {
	    	  node n = boards.poll();	  
	          int[] arr1= find0(n); 
	          
	     	  if(arr1[0]!= n.x-1) {
	     		 node x0=new node(Lswap(n, arr1[0], arr1[1]));  //up		     		
	     	     x0.word= stringtrue(x0.arr); 	     	     
	     	     x0.path= n.path+ ","+x0.arr[arr1[0]][arr1[1]]+"U";
	         	 if (x0.word.equals(end.word))  return x0.path;  	     		 
	     		 if (!visited.contains(x0.word)) {
	     		    boards.add(x0);
	                  }  
	     	 } 
	     	 if(arr1[0]!= 0) {
	     		  node x1= Rswap(n, arr1[0], arr1[1]);  //down		 
	     		  x1.word= stringtrue(x1.arr);
	     		  x1.path= n.path+ ","+x1.arr[arr1[0]][arr1[1]]+"D";
	     		 if (x1.word.equals(end.word))  return  x1.path;  			     			
	     		 if (!visited.contains(x1.word)) {
	                  boards.add(x1);	                 
	                  }  
	     	 }
	     	 if(arr1[1]!= 0) {
	     		  node x2= Uswap(n, arr1[0], arr1[1]);  //right		 
	     		  x2.word= stringtrue(x2.arr); 
	     		  x2.path= n.path+ ","+x2.arr[arr1[0]][arr1[1]]+"R";
	     		  if (x2.word.equals(end.word)) 	return x2.path;  	     		
	     		  if (!visited.contains(x2.word)) {
	                  boards.add(x2);
	                  }  
	     	 }
	     	 if(arr1[1]!= n.y-1) {
	     		 node x3= Dswap(n, arr1[0], arr1[1]);  //left
	     		 x3.word= stringtrue(x3.arr); 
	     		 x3.path= n.path+ ","+x3.arr[arr1[0]][arr1[1]]+"L";
	     		 if (x3.word.equals(end.word))  return x3.path;  	     		 
	     		 if (!visited.contains(x3.word)) {
	                  boards.add(x3);
	                 }  
	     	 }
	     	  visited.add(n.word);
	     	 }
	      return "-1";
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
       public static node Lswap(node first, int x, int y) {
    	   node firs= new node(first);
    	   firs.arr[x][y]= firs.arr[x+1][y];
    	   firs.arr[x+1][y]= 0;
    	   return firs;	 
       }
       public static node Rswap(node first, int x, int y) {
    	   node firs= new node(first);
    	   firs.arr[x][y]= firs.arr[x-1][y];
    	   firs.arr[x-1][y]= 0;
    	   return firs;	 
       }
       public static node Uswap(node first, int x, int y) {
    	   node firs= new node(first);
    	   firs.arr[x][y]= firs.arr[x][y-1];
    	   firs.arr[x][y-1]= 0;
    	   return firs;	 
       }
       public static node Dswap(node first, int x, int y) { 
    	   node firs= new node(first);
    	   firs.arr[x][y]= firs.arr[x][y+1];
    	   firs.arr[x][y+1]= 0;
    	   return firs;	 
       }    
       public static String stringtrue(int arr[][]) {
    	   String s= "";
    	   for (int j = 0; j < arr.length; j++) {
   			for (int j2 = 0; j2 < arr[0].length; j2++) {
   				s= s+ String.valueOf(arr[j][j2]);
   			}
   		}   
    	   return s;
       }    
       }
	     
 
