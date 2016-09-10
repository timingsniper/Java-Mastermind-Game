
import java.util.Scanner;
public class mindMaster {
	/* MindMaster Game by Percy Jang
	 * This game has only one method: playGame(). This method includes all the logics that are needed for the game.
	 * There is no parameter, and the return type is void.
	 * 
	 * 1. The method creates an array named "mysteryArray" with size of 4 elements, and uses Math.random method to 
	 *    have 4 random numbers ranging from 1 to 8 in it. The elements in mysteryArray will be converted into string 
	 *    form by concatenation with "", and assigned to a String array named "usedToTest"(This is performed through a for loop). 
	 *    
	 * 2. Declared Strings inputs will be the user's input. input1~4 will store each individual values that was written in inputs.
	 *    Integer whiteCount and blackCount each represents number of whites and blacks the user will see. 
	 * 
	 * 3. Game begins from here- Instruction is prompted, and a huge for loop begins. This loop will prompt the users to input numbers for 10 times.
	 *    (Unless the user wins the game). This loop will repeat for 10 times as the user is given 10 tries.
	 *  
	 * 4. Number of tries is printed out. User enters four numbers, divided by spacing. Using substring method in here, each indivsual values are stored
	 *    into String input1, 2, 3 and 4. (example: inputs 1 2 3 4, input1 =1,input2=2,input3=3,input4=4)
	 *    
	 * 5. Checking process begins with if-else statement. If statement uses equals method to check if the user's input is equal to the randomly created
	 *    number. Each input is compared with elements in usedToTest array. If the input is equal to its corresponding postion, whiteCount increases by one.
	 *    If it doesn't, else statement is executed. Else statement checks wheter if the input equals to the number in the other position. This is performed through
	 *    for loop or indivisual position checking. If the number conforms this condition, blackCount increases by one. However, I found out when editing the last version 
	 *    that in case of duplication, the blackCount will give wrong numbers, it could even give 6. So I fixed the condtion of incrementing blackCount-
	 *    it will only increment when the value of input is not the value in the right postion, and when it checks if the input is at the other position, the blackCount
	 *    will only increment when the number of other input does not equal the value in that position.
	 *   
	 * 6. The user sees their black count and white count. If the user got 4 whites (which means he got it all right), the loop breaks immediately. 
	 * 
	 * 7. User sees his result in this phase. If statement is executed. If the user got 4 whites and won, he or she is congratulated. If the user lost,
	 *    he or she sees the message saying she lost. The right number was printed through for loop- it prints out elements in mysteryArray array.
	 *    
	 * This was the playGame method, but more things are added in main method.
	 * In the main method:
	 * 1. The playGame method is executed in a while loop, since the user will be asked after the game to try the game again. If the user writes "y", the
	 *    playGame method runs again. The condition is String tryAgain will equal String yes, which its value is "y". 
	 *    In order to ensure the game will run at the first execution, String tryAgain is initialized as "y".
	 * 
	 * 2. After playGame method finishes, the message asking whether the user wants to try again is printed, and the user gets to write his action
	 *    through Scanner nextLine method. If the user writes "y", playGame method will run again, but if user writes any other thing, the program will terminate
	 *    with a thank you message.
	 *    
	 *    
	 *
	 */
	 
	public static void playGame()
	{
		int[]mysteryArray = new int[4];                  //Array that stores randomly created numbers
		for(int i = 0; i<4; i++)
		{
			mysteryArray[i] = (int)(Math.random()*7+1);  //4 Random ints from 1 to 8 is stored in this array
			
		}
		String inputs;                                   //User input is stored
		String input1;                                   //input1~4 stores indivisual values from the String "inputs"
		String input2;
		String input3;
		String input4;
		
		int whiteCount = 0;                              //whiteCount is the number of whites the user get
		int blackCount = 0;                              //blackCount is the number of blacks the user get
		Scanner sc = new Scanner(System.in);             //sc scanner is initialized
		String[]usedToTest = new String[4];              //usedToTest array will be used to check white and black values in the user input later
		for(int i = 0; i<4; i++)
		{
		  usedToTest[i] = ""+mysteryArray[i];            //int values in mysteryArray array are converted into String form and stored in usedToTest array
		}
		System.out.println("\nWelcome to MindMaster Game!\n4 numbers from 1~8 are randomly created, try to guess it within 10 tries!\nPlease Seperate the Numbers by space.");
		
		for(int go = 1; go<=10; go++)                   //The user is given 10 tries(go), and it will terminate after the 10th try.
			{ 
			whiteCount = 0; blackCount = 0;              //black and white counts are always initialized to 0 when the loop begins
			
			{
				System.out.println("\nNumber " + go + " try"); //user sees his number of trial
				inputs = sc.nextLine();                  //User inputs 4 number, but he needs to divide them with space(or ERROR!)
				input1 = inputs.substring(0,1);          //Substring method "cuts off" the String inputs, and stores each indivisual position's value
				input2 = inputs.substring(2,3);
				input3 = inputs.substring(4,5);
				input4 = inputs.substring(6,7);
				if(input1.equals(usedToTest[0]))         //Checking process begins- if input of the postion equals the number in the corresponding postion
					whiteCount++;       
				
					//whiteCount increases by one.
				if(input1.equals(usedToTest[1])&&!input2.equals(usedToTest[1]))  //this whole if-else-if statement checks the blackCount
				{
					blackCount++;                       //blackCount increases when the input value equals answer in other postion, but if other inputs have same value as that answer's position, blackCount decreases or remains same to prevent duplication.
				}
				
				else if(input1.equals(usedToTest[2])&&!input3.equals(usedToTest[2]))
				{
					blackCount++;
				}
				else if(input1.equals(usedToTest[3])&&!input4.equals(usedToTest[3]))
				{
					blackCount++;
				}
		
				
				if(input2.equals(usedToTest[1]))
					whiteCount++;
		
				else if(input2.equals(usedToTest[0])&&!input3.equals(usedToTest[0]))
				{
					blackCount++;
				}
				else if(input2.equals(usedToTest[2])&&!input3.equals(usedToTest[2]))
				{
					blackCount++;
				}
				else if(input2.equals(usedToTest[3])&&!input3.equals(usedToTest[3]))
				{
					blackCount++;
				}
				if(input2.equals(input1)&&input2.equals(input3)&&input2.equals(input4))
				{
					if(usedToTest[1].equals(usedToTest[0])||usedToTest[2].equals(usedToTest[3]))
					{
						blackCount--;
					}
				}
				
				if(input3.equals(usedToTest[2]))
					whiteCount++;
				
				else if(input3.equals(usedToTest[0])&&!input4.equals(usedToTest[0]))
				{
					blackCount++;
				}
				else if(input3.equals(usedToTest[1])&&!input4.equals(usedToTest[1]))
				{
					blackCount++;
				}
				else if(input3.equals(usedToTest[3])&&!input4.equals(usedToTest[3]))
				{
					blackCount++;
				}
				if(input3.equals(input1)&&input2.equals(input2)&&input2.equals(input4))
				{
					if(usedToTest[2].equals(usedToTest[0])||usedToTest[1].equals(usedToTest[3]))
					{
						blackCount--;
					}
				}
				
				if(input4.equals(usedToTest[3]))
					whiteCount++;
				else if(input4.equals(usedToTest[0]))
				{
					blackCount++;
				}
				else if(input4.equals(usedToTest[1]))
				{
					blackCount++;
				}
				else if(input4.equals(usedToTest[2]))
				{
					blackCount++;
				}
				if(input4.equals(input1)&&input2.equals(input2)&&input2.equals(input3))
				{
					
						blackCount--;
					
				}
				if(blackCount<0)
					blackCount=0;
			

				
				System.out.println(whiteCount+" White, " + blackCount+" Black."); //After the checking process is complete, the user sees how many blacks and whites he/she got.
				if(whiteCount == 4)                                               //If the user got it ALL RIGHT, the loop immediately breaks regardless of number of the trial.
					break;
				System.out.println("Try guessing again!!");                       //Depressing message 
			}          
			}//else, the loop starts again with a new trial. This will continue until trial number 10 or user gets everything right!
		
				if(whiteCount == 4)                                               //if the user wins, he gets a congratulation message from me.
				{
					System.out.println("Congrats! You won the game! the number was: ");
					for(int i = 0; i<4; i++)                                      //The user sees the correct answer.
					{
						System.out.print(mysteryArray[i]);
						System.out.print(" ");
					}
				}
			
				else                                                              //This means our poor user did not get it right until trial ten. I tell him he lost.
				{
					System.out.println("You lose! The number was: ");
				for(int i = 0; i<4; i++)                                          //The user sees the correct answer.
				{
					System.out.print(mysteryArray[i]);
					System.out.print(" ");
				
				}
				}
				
				
				
	}
	

	public static void main(String[] args) {                                      //Now playGame() method will execute in the main method, but the main method gives user the option to try again.
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String yes = "y";                                                         // this String is used for equals method below
		String tryAgain = "y";                                                    // if tryAgain string is not initialized as "y", the game will never execute.
		System.out.println("***************MindMaster Game by Percy Jang***************"); //My cool introduction
		while(tryAgain.equals(yes))                                               //the loop continues as long as the user types in "y". Although there is no user input,
		{                                                                         //the game will still execute at first run because the program thinks user input is already a "y".
		playGame();                                                               //The game runs!
		System.out.println("Try again? Press y.");                                //After the user sees the result, He will be asked to try again or not.
		tryAgain = sc.nextLine();                                                 //He/she will type in y or whatever else- if y is typed in, the game runs again, else, the program terminates.
		}
		System.out.println("Thank you for Playing!");                             //bye!
		

		
		/*test
		 * Answer: 1 1 7 3
		 * Try 1 = 1 1 1 1, 2 white, 0 black
		 * try 2 = 7 3 1 1, 0 white, 3 black
		 * 
		 * 
		 * Answer: 3 3 6 5 
		 * Try 1 = 3 3 3 3, 2 white, 0 black
		 * Try 2 = 1 2 3 4, 0 white, 1 black
		 * 
		 * Answer: 3 7 6 2
		 * Try 1 = 1 2 3 4, 0 white, 2 black
		 * Try 2 = 3 3 1 7, 1 white, 2 black
		 * Try 3 = 4 5 6 6, 1 white, 1 black
		 * Try 4 = 3 7 6 2, 4 white, 0 black (win)
		 * 
		 * Answer: 4 4 3 2
		 * Try 1 = 4 4 4 4, 2 white, 0 black
		 * Try 2 = 3 2 1 3, 0 white, 2 black
		 */
		
		
		
		
	}
	

}

