package APAssignment4;

import java.util.*;
import java.lang.*;
import java.io.*;

public class FastReader {
    private BufferedReader br;
    private StringTokenizer st;
    public FastReader()
    {
        br = new BufferedReader(
        new InputStreamReader(System.in));
    }
 
    public String next()
    {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }
 
    public int nextInt() { return Integer.parseInt(next()); }
 
    public long nextLong() { return Long.parseLong(next()); }
 
    public double nextDouble()
    {
        return Double.parseDouble(next());
    }
 
    public String nextLine()
    {
        String str = "";
        try {
            str = br.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}