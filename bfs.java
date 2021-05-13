import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class algo_bfs {
	
    public static void main(String[] args) {      
    	
    	   int arr[][]= {{1,0,0},{4,2,3},{7,5,6}};
     	   int arr1[][]= {{1,2,3},{4,5,6},{7,0,0}};
           node a1= new node(3,3,arr,0,0);
           node a2= new node(3,3, arr1,0,0);
           System.out.println(bfs(a1, a2));  
    }
    public static String bfs(node start, node end){
    	if(node.findnumof0(start)==1) return bfs1(start,end);
    	if(node.findnumof0(start)==2) return bfs2(start,end);
    	return "error";
    }
    public static String bfs1(node start, node end){
		  Set<String> visited = new HashSet<String>();
	      Queue<node> boards = new LinkedList<node>();
	      boards.add(start);
	      visited.add(start.word);
	      while(!boards.isEmpty()) {
	    	  node n = boards.poll();	  
	          int[] arr1= node.find0(n); 
	          
	          if(arr1[1]!= n.y-1) {
		     		 node x3= node.left(n, arr1[0], arr1[1]);  //left
		     		 x3.word= node.stringtrue(x3); 
		     		 x3.path= n.path+ "-"+x3.arr[arr1[0]][arr1[1]]+"L";
		     		 if (x3.word.equals(end.word))  return x3.path.substring(1);  	     		 
		     		 if (!visited.contains(x3.word)) {
		                  boards.add(x3);
		                 }  
		     	 }
	          
	     	  if(arr1[0]!= n.x-1) {
	     		 node x0=new node(node.up(n, arr1[0], arr1[1]));  //up		     		
	     		 x0.word= node.stringtrue(x0);	     	     
	     	     x0.path= n.path+ "-"+x0.arr[arr1[0]][arr1[1]]+"U";
	         	 if (x0.word.equals(end.word))  return x0.path.substring(1);  	    		 
	     		 if (!visited.contains(x0.word)) {
	     		    boards.add(x0);
	                  }  
	     	 } 
	 
	     	 if(arr1[1]!= 0) {
	     		  node x2= node.right(n, arr1[0], arr1[1]);  //right		 
	     		  x2.word= node.stringtrue(x2);
	     		  x2.path= n.path+ "-"+x2.arr[arr1[0]][arr1[1]]+"R";
	     		  if (x2.word.equals(end.word)) return x2.path.substring(1);   	     		
	     		  if (!visited.contains(x2.word)) {
	                  boards.add(x2);
	                  }  
	     	 }	     	 
	     	 if(arr1[0]!= 0) {
	     		  node x1= node.down(n, arr1[0], arr1[1]);  //down		 
	     		  x1.word= node.stringtrue(x1);
	     		  x1.path= n.path+ "-"+x1.arr[arr1[0]][arr1[1]]+"D";
	     		 if (x1.word.equals(end.word))  return x1.path.substring(1);   			     			
	     		 if (!visited.contains(x1.word)) {
	                  boards.add(x1);	                 
	                  }  
	     	 }
	     	  visited.add(n.word);
	     	 }
	      return "-1";
	      } 
       
    public static String bfs2(node start, node end){
	    Set<String> visited = new HashSet<String>();
        Queue<node> boards = new LinkedList<node>();
        boards.add(start);
        visited.add(start.word);
            while(!boards.isEmpty()) {
  	        node n = boards.poll();	  
            int[] arr1= node.find02(n);
              
               if (arr1[1]!= n.y-1 && arr1[1]==arr1[3] && Math.abs(arr1[0]-arr1[2])==1) {  //left*2
            	     node x3= node.leftleft(n, arr1[0], arr1[1], arr1[2], arr1[3]);  
		     		 x3.word= node.stringtrue(x3); 
		     		 x3.path= n.path+ "-"+x3.arr[arr1[0]][arr1[1]]+"&"+x3.arr[arr1[2]][arr1[3]]+"L";
		     		 if (x3.word.equals(end.word))  return x3.path.substring(1);  	     		 
		     		 if (!visited.contains(x3.word)) {
		                  boards.add(x3);
		     		 }        
               }
               if (arr1[1]!= 0 && arr1[1]==arr1[3] && Math.abs(arr1[0]-arr1[2])==1) {  //right*2
            	   node x3= node.rightright(n, arr1[0], arr1[1], arr1[2], arr1[3]);  
		     		 x3.word= node.stringtrue(x3); 
		     		 x3.path= n.path+ "-"+x3.arr[arr1[0]][arr1[1]]+"&"+x3.arr[arr1[2]][arr1[3]]+"R";
		     		 if (x3.word.equals(end.word))  return x3.path.substring(1);  	     		 
		     		 if (!visited.contains(x3.word)) {
		                  boards.add(x3);
		     		 }        
               }
               if (arr1[0]!= n.x-1 && arr1[0]==arr1[2] && Math.abs(arr1[1]-arr1[3])==1) {  //up*2
          	         node x3= node.upup(n, arr1[0], arr1[1], arr1[2], arr1[3]);  
		     		 x3.word= node.stringtrue(x3); 
		     		 x3.path= n.path+ "-"+x3.arr[arr1[0]][arr1[1]]+"&"+x3.arr[arr1[2]][arr1[3]]+"U";
		     		 if (x3.word.equals(end.word))  return x3.path.substring(1);  	     		 
		     		 if (!visited.contains(x3.word)) {
		                  boards.add(x3);
		     		 }        
             }
               if (arr1[0]!= 0 && arr1[0]==arr1[2] && Math.abs(arr1[1]-arr1[3])==1) {  //down*2
          	     node x3= node.downdown(n, arr1[0], arr1[1], arr1[2], arr1[3]);  
		     		 x3.word= node.stringtrue(x3); 
		     		 x3.path= n.path+ "-"+x3.arr[arr1[0]][arr1[1]]+"&"+x3.arr[arr1[2]][arr1[3]]+"D";
		     		 if (x3.word.equals(end.word))  return x3.path.substring(1);  	     		 
		     		 if (!visited.contains(x3.word)) {
		                  boards.add(x3);
		     		 }        
             }
               if(arr1[3]!= n.y-1) {
		     		 node x3= node.left(n, arr1[2], arr1[3]);  //left
		     		 x3.word= node.stringtrue(x3); 
		     		 x3.path= n.path+ "-"+x3.arr[arr1[2]][arr1[3]]+"L";
		     		 if (x3.word.equals(end.word))  return x3.path.substring(1);  	     		 
		     		 if (!visited.contains(x3.word)) {
		                  boards.add(x3);
		                 }  
		     	 }
	          
	     	  if(arr1[2]!= n.x-1) {
	     		 node x0=new node(node.up(n, arr1[2], arr1[3]));  //up		     		
	     		 x0.word= node.stringtrue(x0);	     	     
	     	     x0.path= n.path+ "-"+x0.arr[arr1[2]][arr1[3]]+"U";
	         	 if (x0.word.equals(end.word))  return x0.path.substring(1);  	    		 
	     		 if (!visited.contains(x0.word)) {
	     		    boards.add(x0);
	                  }  
	     	 } 
	 
	     	 if(arr1[3]!= 0) {
	     		  node x2= node.right(n, arr1[2], arr1[3]);  //right		 
	     		  x2.word= node.stringtrue(x2);
	     		  x2.path= n.path+ "-"+x2.arr[arr1[2]][arr1[3]]+"R";
	     		  if (x2.word.equals(end.word)) return x2.path.substring(1);   	     		
	     		  if (!visited.contains(x2.word)) {
	                  boards.add(x2);
	                  }  
	     	 }	     	 
	     	 if(arr1[2]!= 0) {
	     		  node x1= node.down(n, arr1[2], arr1[3]);  //down		 
	     		  x1.word= node.stringtrue(x1);
	     		  x1.path= n.path+ "-"+x1.arr[arr1[2]][arr1[3]]+"D";
	     		 if (x1.word.equals(end.word))  return x1.path.substring(1);   			     			
	     		 if (!visited.contains(x1.word)) {
	                  boards.add(x1);	                 
	                  }  
	     	 }
	     	if(arr1[1]!= n.y-1) {
	     		 node x3= node.left(n, arr1[0], arr1[1]);  //left
	     		 x3.word= node.stringtrue(x3); 
	     		 x3.path= n.path+ "-"+x3.arr[arr1[0]][arr1[1]]+"L";
	     		 if (x3.word.equals(end.word))  return x3.path.substring(1);  	     		 
	     		 if (!visited.contains(x3.word)) {
	                  boards.add(x3);
	                 }  
	     	 }
         
    	  if(arr1[0]!= n.x-1) {
    		 node x0=new node(node.up(n, arr1[0], arr1[1]));  //up		     		
    		 x0.word= node.stringtrue(x0);	     	     
    	     x0.path= n.path+ "-"+x0.arr[arr1[0]][arr1[1]]+"U";
        	 if (x0.word.equals(end.word))  return x0.path.substring(1);  	    		 
    		 if (!visited.contains(x0.word)) {
    		    boards.add(x0);
                 }  
    	 } 

    	 if(arr1[1]!= 0) {
    		  node x2= node.right(n, arr1[0], arr1[1]);  //right		 
    		  x2.word= node.stringtrue(x2);
    		  x2.path= n.path+ "-"+x2.arr[arr1[0]][arr1[1]]+"R";
    		  if (x2.word.equals(end.word)) return x2.path.substring(1);   	     		
    		  if (!visited.contains(x2.word)) {
                 boards.add(x2);
                 }  
    	 }	     	 
    	 if(arr1[0]!= 0) {
    		  node x1= node.down(n, arr1[0], arr1[1]);  //down		 
    		  x1.word= node.stringtrue(x1);
    		  x1.path= n.path+ "-"+x1.arr[arr1[0]][arr1[1]]+"D";
    		 if (x1.word.equals(end.word))  return x1.path.substring(1);   			     			
    		 if (!visited.contains(x1.word)) {
                 boards.add(x1);	                 
                 }  
    	 }
    	 visited.add(n.word);
	     	 }
	      return "-1";
	      }                     
       }

 
