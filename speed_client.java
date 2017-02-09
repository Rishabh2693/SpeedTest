import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class speed_client {
	public static void main(String[] args) throws IOException {
		if(args.length!=2){
			if(args.length<2){
				System.out.println("java speed_client <IP Address> <port number>");
				System.exit(1);
			}
			else{
				System.out.println("Too many args\nSyntax: java speed_client <IP Address> <port number>");
				System.exit(1);
			}
		}

		String serverAddress = args[0];
        //Upload
		int port = Integer.valueOf(args[1]);
		int n = 10000;
		long t1= System.currentTimeMillis();
		long t2= System.currentTimeMillis();
		int l = 0;
		while((t2-t1)<500){
			n = n*2;
			Socket s = new Socket(serverAddress, port);
	        PrintWriter out = new PrintWriter(
	        		s.getOutputStream(), true);
	        BufferedReader input =
	                new BufferedReader(new InputStreamReader(s.getInputStream()));
	        
			char[] data = new char[n];
			Arrays.fill(data, '*');
			String str = new String(data);
			l=str.length();
			t1= System.currentTimeMillis();
			out.println(str);
	        String answer = input.readLine();
	        t2= System.currentTimeMillis();
	        s.close();	      
		}
	//Num of bytes/time multiplied by 1000 to convert ms to seconds and 
	//since memory footprint of java string is atleast twice of length
        System.out.println("Upload Speed:" + (l*2*1000/(t2-t1)) + " Bytes/sec ");
        
        //Download
        
        Socket s = new Socket(serverAddress, port);
        PrintWriter out = new PrintWriter(
        		s.getOutputStream(), true);

        out.println("client");
        out.println(n);
        BufferedReader input =
        	new BufferedReader(new InputStreamReader(s.getInputStream()));
        t1= System.currentTimeMillis();
        String answer = input.readLine();
        t2= System.currentTimeMillis();
        s.close();
        System.out.println("Download speed:"+ (answer.length()*2*1000/(t2-t1)) + " Bytes/sec");
        System.exit(0);
    }
}
