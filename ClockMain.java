package clockdock;

import java.time.Clock;
import java.time.Duration;
import java.util.Timer;
import java.util.TimerTask;

public class ClockMain {
	
	static Timer t;
	static TimerTask tt;
	
	static int[][] clockRef = new int[10][5];
	
	static String[][] clockRefString = {{"&&&","& &","& &","& &","&&&"},{"  &", "  &", "  &", "  &", "  &"},{"&&&","  &","&&&","&  ","&&&"},{"&&&","  &","&&&","  &","&&&"},{"& &","& &","&&&","  &","  &"},
			{"&&&","&  ","&&&","  &","&&&"},{"&&&","&  ","&&&","& &","&&&"},{"&&&","  &","  &","  &","  &"},{"&&&","& &","&&&","& &","&&&"},{"&&&","& &","&&&","  &","  &"}};
	
	
	
	public static void main(String[] args) {

		myTimer();
		
	}
	
	public static void clockTime() {
		
		String time = getTime();
		
		if(time.length() < 4) {
			time = "0" + time;
		}
		
		String [] timeStrArr = time.split("");
		int[] timeArr = new int[timeStrArr.length];
			for(int i = 0;i < timeArr.length;i++) {
				timeArr[i] = Integer.parseInt(timeStrArr[i]);
			}
		
		printTime(timeArr);
	}
	
	public static String getTime() {
		
		Clock c = Clock.offset(Clock.systemDefaultZone(),Duration.ofHours(-4)); 
	    String time = c.instant().toString();
	    //11 12 14 15
	    int temp = Integer.parseInt("" + time.charAt(11) + time.charAt(12) + time.charAt(14) + time.charAt(15));
	    if (temp > 1200) {temp -= 1200;}
	    return String.valueOf(temp);
		
	}
	
	public static void myTimer() {
        TimerTask tt = new TimerTask() {

            @Override
            public void run() {
                clockTime();
            }
        };
        t = new Timer();
        t.schedule(tt, 0, 1000);
	}

	static void printTime(int[] timeArr) {
		
		System.out.print("\n");
		for(int i = 0; i < 5; i++) {
			
			if(timeArr[0] == 0) {
				System.out.print("      ");
			}else {
				System.out.print(clockRefString[timeArr[0]][i] + "   ");
			}	
			System.out.print(clockRefString[timeArr[1]][i]);
			
			if(i == 1 || i == 3) {
				System.out.print("  @  ");
			}else {
				System.out.print("     ");	
			}
			
			System.out.print(clockRefString[timeArr[2]][i] + "   ");
			
			System.out.print(clockRefString[timeArr[3]][i]);
			
			System.out.print("\n");
			
		}
		
		
	}
		
}
/*
		clockRefString[0][0] = "&&&";
		clockRefString[0][1] = "& &";
		clockRefString[0][2] = "& &";
		clockRefString[0][3] = "& &";
		clockRefString[0][4] = "&&&";
		
		clockRefString[1][0] = "  &";
		clockRefString[1][1] = "  &";
		clockRefString[1][2] = "  &";
		clockRefString[1][3] = "  &";
		clockRefString[1][4] = "  &";
		
		clockRefString[2][0] = "&&&";
		clockRefString[2][1] = "  &";
		clockRefString[2][2] = "&&&";
		clockRefString[2][3] = "&  ";
		clockRefString[2][4] = "&&&";
		
		clockRefString[3][0] = "&&&";
		clockRefString[3][1] = "  &";
		clockRefString[3][2] = "&&&";
		clockRefString[3][3] = "  &";
		clockRefString[3][4] = "&&&";
		
		clockRefString[4][0] = "& &";
		clockRefString[4][1] = "& &";
		clockRefString[4][2] = "&&&";
		clockRefString[4][3] = "  &";
		clockRefString[4][4] = "  &";
		
		clockRefString[5][0] = "&&&";
		clockRefString[5][1] = "&  ";
		clockRefString[5][2] = "&&&";
		clockRefString[5][3] = "  &";
		clockRefString[5][4] = "&&&";
		
		clockRefString[6][0] = "&&&";
		clockRefString[6][1] = "&  ";
		clockRefString[6][2] = "&&&";
		clockRefString[6][3] = "& &";
		clockRefString[6][4] = "&&&";

		clockRefString[7][0] = "&&&";
		clockRefString[7][1] = "  &";
		clockRefString[7][2] = "  &";
		clockRefString[7][3] = "  &";
		clockRefString[7][4] = "  &";
		
		clockRefString[8][0] = "&&&";
		clockRefString[8][1] = "& &";
		clockRefString[8][2] = "&&&";
		clockRefString[8][3] = "& &";
		clockRefString[8][4] = "&&&";
		
		clockRefString[9][0] = "&&&";
		clockRefString[9][1] = "& &";
		clockRefString[9][2] = "&&&";
		clockRefString[9][3] = "  &";
		clockRefString[9][4] = "  &";
*/