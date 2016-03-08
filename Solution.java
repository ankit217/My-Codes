//MAZE ESCAPE PROBLEM ON HACKERRANK

import java.io.*;
import java.util.*;

public class Solution {

    public static void move_next(String prev, String prev_p, String maze[])throws IOException {
        String tmp = prev;
        File fileName = new File( "myfile.txt" );
        FileWriter fileWrite = new FileWriter( fileName );
        BufferedWriter bufferedWriter = new BufferedWriter( fileWrite );
        
        if(maze[1].charAt(0)=='e') prev = "LEFT";
        else if(maze[0].charAt(1)=='e') prev = "UP";
        else if(maze[1].charAt(2)=='e') prev = "RIGHT";
        else if(maze[2].charAt(1)=='e') prev = "DOWN";
        else if(maze[0].charAt(0)=='e'){
            if(maze[0].charAt(1) != '#') prev = "UP";
            else prev = "LEFT";
        } 
        else if(maze[0].charAt(2)=='e'){
            if(maze[0].charAt(1) != '#') prev = "UP";
            else prev = "RIGHT";
        } 
        else if(maze[2].charAt(0)=='e'){
            if(maze[1].charAt(0) != '#') prev = "LEFT";
            else prev = "DOWN";
        } 
        else if(maze[2].charAt(2)=='e'){
            if(maze[1].charAt(2) != '#') prev = "RIGHT";
            else prev = "DOWN";
        }
        else if(maze[0].charAt(0)=='#' && maze[0].charAt(1)=='#' && maze[0].charAt(2)=='#' && maze[1].charAt(0)=='#' && maze[2].charAt(0)=='#') prev = "DOWN";
        else if(maze[0].charAt(0)=='#' && maze[0].charAt(1)=='#' && maze[0].charAt(2)=='#' && maze[1].charAt(2)=='#' && maze[2].charAt(2)=='#') prev = "LEFT";
        else if(maze[2].charAt(0)=='#' && maze[2].charAt(1)=='#' && maze[2].charAt(2)=='#' && maze[0].charAt(2)=='#' && maze[1].charAt(2)=='#') prev = "UP";
        else if(maze[2].charAt(0)=='#' && maze[2].charAt(1)=='#' && maze[2].charAt(2)=='#' && maze[0].charAt(0)=='#' && maze[1].charAt(0)=='#') prev = "RIGHT";
        else if(maze[0].charAt(0)=='#' && maze[1].charAt(0)=='#' && maze[2].charAt(0)=='#'){if(prev.equals("START")) prev = "RIGHT"; else prev = "DOWN";}
        else if(maze[0].charAt(2)=='#' && maze[1].charAt(2)=='#' && maze[2].charAt(2)=='#'){if(prev.equals("START")) prev = "LEFT"; else prev = "UP";}
        else if(maze[0].charAt(0)=='#' && maze[0].charAt(1)=='#' && maze[0].charAt(2)=='#'){if(prev.equals("START")) prev = "DOWN"; else prev = "LEFT";}
        else if(maze[2].charAt(0)=='#' && maze[2].charAt(1)=='#' && maze[2].charAt(2)=='#'){if(prev.equals("START")) prev = "UP"; else prev = "RIGHT";}
        else if(maze[1].charAt(2)=='#' && maze[2].charAt(2)=='#') prev = "UP";
        else if(maze[2].charAt(2)=='#'){if(!prev_p.equals("RIGHT")) prev = "RIGHT"; else prev = "UP";}  
        else if(maze[1].charAt(2)=='#') prev = "UP";
	    else if(maze[2].charAt(1)=='-') prev = "DOWN";
        else if(maze[1].charAt(2)=='-') prev = "RIGHT";
        else if(maze[1].charAt(0)=='-') prev = "LEFT";
        else if(maze[0].charAt(1)=='-') prev = "UP";
        
        
        bufferedWriter.write(prev);
        bufferedWriter.write("\n");
        bufferedWriter.write(tmp);
        bufferedWriter.close();
	System.out.println(prev);
    }
    public static void main(String[] args)throws IOException {
        Scanner sc = new Scanner(System.in);
        File fileName = new File( "myfile.txt" );
        int N;
        String maze[] = new String[3];
        N = sc.nextInt();
        for(int i = 0; i < 3; i++){
            maze[i] = sc.next();
        }
        String prev = "START";
        String prev_p = "";
        if( !fileName.exists() )
        {
            fileName.createNewFile();
            FileWriter fileWrite = new FileWriter( fileName );
            BufferedWriter bufferedWriter = new BufferedWriter( fileWrite );
            bufferedWriter.write(prev+"\n");
            bufferedWriter.write(prev_p);
            bufferedWriter.close();
        }
        else
        {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            prev = br.readLine();
            prev_p = br.readLine();
            br.close();
        }
	move_next(prev,prev_p,maze);
        
    }
}
