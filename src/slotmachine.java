import java.util.*;
class slotmachine{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int credits= 10;
		int menu = menusystem();
		
		while(menu != 3){
			if(menu == 1){
				display_credits(credits);
			}
			else if(menu == 4){
				display_winnings();
			}
			else if(menu == 2 && credits >=1){
			credits = play_game(credits);
			}
			else if(credits==0){
				System.out.println("you have run out of credits");
				break;
			}
			else{
				System.out.println("you have inputed an invalid command");
			}
			menu = menusystem();
		}
		endgame(credits);
	}
	public static int menusystem(){
		Scanner menusys = new Scanner(System.in);
		System.out.println("|----------------------------|");
		System.out.println("| 1 |     display credits    |");
		System.out.println("| 2 |         Roll           |");
		System.out.println("| 3 |        exit game       |");
		System.out.println("| 4 |    Display Payouts     |");
		System.out.println("|----------------------------|");
		int input = menusys.nextInt();
		return(input);
	}
	public static void display_credits(int a){
		System.out.println("| the number of credits you have is "+a+"|");
	}
	public static void display_winnings(){
		System.out.println("|----------------------------------|");
		System.out.println("|      7-7-7       |  150 credits  |");
		System.out.println("|    3 Matching    |  80 Credits   |");
		System.out.println("|  3 Sequential    |  40 Credits   |");
		System.out.println("| 3 Non sequential |  80 Credits   |");
		System.out.println("|      2 Evens     |  40 Credits   |");
		System.out.println("|      2 Odds      |  40 Credits   |");
		System.out.println("|      One 7       |  40 Credits   |");
		System.out.println("|----------------------------------|");
	}
	public static int play_game(int credits){
		Random diceRoller = new Random();
		int f = diceRoller.nextInt(7)+1;
		int s = diceRoller.nextInt(7)+1;
		int t = diceRoller.nextInt(7)+1;
		
		System.out.println("| NO.1 |      "+f+"		|");
		System.out.println("| NO.2 |      "+s+"		|");
		System.out.println("| NO.3 |      "+t+"		|");
		credits-= 1;//use one credit
		if (f == 7 && s == 7 && t == 7)//7-7-7
			{
				System.out.println("| Triple 7 150 credits won |");
				credits+=150;	
			}
		else if (f == s && s == t && t == f && f != 7 )//any 3 matching not 7-7-7
			{
				System.out.println("| 3 Matched 80 credits won |");
				credits+=80;
			}
		else if (s == f + 1 && t == f + 2)//sequence 3 s can only be 1 more than f and t is only 2 more
			{
				System.out.println("| 3 sequential 40 credits won |");
				credits+=40;
			}
		else if ((f%2 == 0) && (f == s||f == t) || (s%2 == 0) && (s == f||s == t) || (t%2 == 0) && (t == s||t == f))
			//calcation for 2 evens when remainder is 0
			{
				System.out.println("| 2 evens 10 credits won |");
				credits+=10;
			}
		else if ((f%2 > 0) && (f == s||f == t) || (s%2 > 0) && (s == f||s == t) || (t%2 > 0) && (t == s||t == f))
			//calcuation for getting 2 odds when remainder is greater than 0
			{
				System.out.println("| 2 odds 5 credits won |");
				credits+=5;
			}
		else if (f == 7 || s == 7 || t == 7)// one 7 if f or s or t is 7 
			{
				System.out.println("| one 7 2 credits won |");
				credits+=2;
			}
		else
			{
				System.out.println("no credits won");
			}
		return(credits);
	}
	public static void endgame(int credits){
		System.out.println("| thanks for playing you have "+credits+" credits remaining |");
	}

}
