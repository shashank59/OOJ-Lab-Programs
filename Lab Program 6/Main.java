import cie.*;
import see.*;
import java.util.*;
class Main{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        externals[] e = new externals[2];
        internals[] in = new internals[2];
        for(int i=0;i<2;i++){
            System.out.println("Enter Usn,Name,Sem");
	    int usn1 = input.nextInt();
            String name1 = input.nextline();
            int sem1 = input.nextInt();
            int[][] cie = new int[2][5];
            int[][] see = new int[2][5];
	    System.out.println("Enter Cie Marks in 5 Subjects");
        
	    for(int j=0;j<5;j++){
	
                cie[i][j] = input.nextInt();
            }
	    System.out.println("Enter See Marks in 5 subjects");

	    for(int j=0;j<5;j++){
                see[i][j] = input.nextInt();
            }
            e[i] = new externals(usn1,name1,sem1,see[i]);
            in[i] = new internals(usn1,name1,sem1,cie[i]);
            int total = 0;
            System.out.println("Name: "+e[i].name+"\nUSN: "+e[i].usn+"\nsem: "+e[i].sem);
            
            for(int j=0;j<5;j++){
                total = (e[i].seeMarks[j]/2)+in[i].cieMarks[j];
                System.out.print("Final marks: "+total+" ");
            }
            System.out.println();
        }
    }
}