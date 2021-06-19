import java.util.*;

public class Main {

  // plays a card game via the console
  public static void playAGame(Board board)
  {
    CardGameConsole console = new CardGameConsole(board);
    console.playGame();
  }

  // play a card game using a GUI
  public static void playAGUIGame(Board board)
  {
    CardGameGUI gui = new CardGameGUI(board);
    gui.displayGame();
  }

  public static void main(String[] args)
  {
    boolean nonGUI = false;
    Scanner s1 = new Scanner(System.in);
    System.out.println("Welcome to the game\n===================\n");
    System.out.println("Choose a game to play: 1) Thirteens, 2) Elevens, 0) quit");

    String answer = s1.nextLine();

    while(!answer.equals("0")) {
      // start GUI version of the game
      if(answer.equals("2")){
          Board board = new ElevensBoard();
          System.out.println("Do you want to play the game graphically or using the console?\nType 1) Graphically, 2) Console, 0) quit");
            Scanner s2 = new Scanner(System.in);
            String chooseType = s1.nextLine();
            while(!chooseType.equals("0")) {
              if(chooseType.equals("1") || chooseType.equals("2")) {
                nonGUI = !chooseType.equals("1");
                break;
              } else {
                System.out.println("Invalid input - try again");
              }
            }
        if (nonGUI) playAGame(board);
        else playAGUIGame(board);
        break;
      }

      else if(answer.equals("1")) {
        Board board = new ThirteensBoard();
          System.out.println("Do you want to play the game graphically or using the console?\nType 1) Graphically, 2) Console, 0) quit");
            Scanner s2 = new Scanner(System.in);
            String chooseType = s1.nextLine();
            while(!chooseType.equals("0")) {
              if(chooseType.equals("1") || chooseType.equals("2")) {
                nonGUI = !chooseType.equals("1");
                break;
              } else {
                System.out.println("Invalid input - try again");
              }
            }
        if (nonGUI) playAGame(board);
        else playAGUIGame(board);
        break;
      }

      else {
        System.out.println("Invalid input. Try again.\nChoose a game to play: 1) Thirteens, 2) Elevens, 0) quit");
        answer = s1.nextLine();
      }
    }

    s1.close();


    /* Act 10 - add console UI to ask user which game they would like to play */
    /* Act 12 - extend to add an option to call non-GUI CardGameConsole to play */
  }

}