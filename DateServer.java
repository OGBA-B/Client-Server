import java.net.*;        
import java.io.*;  

public class DateServer { 
  //@data : an array of strings(messages) to be printed by a Client
  static String[] data= {"Buy Low Sell High" 
               ,"Do No Evil"
               ,"Wash with Soap"
               ,"From Walmart"
               ,"THis is it"
               ,"Riddle me this"
                        }; 
 static int max= data.length; 
 static int min=0;
  public static void main(String[] args) 
  {
    try{  
      ServerSocket sock = new ServerSocket(6017); 
      /* now listen for connections */
      while (true) { 
      Socket client = sock.accept(); 
      PrintWriter pout = new PrintWriter(client.getOutputStream(), true); 
      /* write the Date to the socket */      
      pout.println(data[(int)(Math.random()*max)]);  
      /* close the socket and resume */     
      /* listening for connections */   
      client.close(); 
      }
    }
    catch (IOException ioe) 
    { 
      System.err.println(ioe); 
    }
  }
}