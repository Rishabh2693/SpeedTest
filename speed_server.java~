import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Date;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
public class speed_server{
	public static void main(String[] args) throws IOException {
		Scanner i = new Scanner(System.in);
		System.out.println("Enter the port");        
	        int port = i.nextInt();
		System.out.println("Listening to: " + port);
		ServerSocket listener = new ServerSocket(port);
       		 try {
            		while (true) {
                		Socket socket = listener.accept();
                		try {
                			BufferedReader in = new BufferedReader( 
                            		new InputStreamReader(socket.getInputStream()));
                			PrintWriter out = new PrintWriter(
                    			socket.getOutputStream(), true);
                			int n;
                			String input = in.readLine();
                			if(input.equals("client")){
                       			String n_s = in.readLine();
                			n = Integer.valueOf(n_s);
                			long t1= System.currentTimeMillis();
                			long t2= System.currentTimeMillis();
                			while((t2-t1)<1000){
                				char[] data = new char[n];
                				Arrays.fill(data, '*');
                				String str = new String(data);
                				t1= System.currentTimeMillis();
                				out.println(str);
                	        		String answer = in.readLine();
                	        		t2= System.currentTimeMillis();
                	        		socket.close();
                	     		}             		
                		}
                		else{
                			long count = input.length();
                    			out.println(count);
                			}
                		} 
            			finally {
                    		socket.close();
                		}
            		}		
       		 }
        	finally {
            		listener.close();
        	}
    	}
}
