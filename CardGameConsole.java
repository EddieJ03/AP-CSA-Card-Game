import java.util.*;
/**
 * This class provides a console based UI for solitaire games related to Elevens.
 */
public class CardGameConsole
{
  private Board board;

  public CardGameConsole(Board gameBoard)
  {
    board = gameBoard;
  }

  /**
   * Given a board (in the ctor), play a game via the console
   */
  public void playGame()
  {
    String boardName = (board instanceof ThirteensBoard) ? "ThirteensBoard" : "ElevensBoard";

    String answer = "";

    List<Integer> selectedCards = new ArrayList<Integer>();

    Scanner s1 = new Scanner(System.in);

    System.out.println("Welcome to " + boardName + "\nEnter q at any time to quit\nUse numbers separated by a space to select cards");

    displayBoard();

    System.out.println("Select your cards:");

    answer = s1.nextLine();

    while(!answer.trim().equals("q")) {
      
      Scanner selectedNumbers = new Scanner(answer);
      while(selectedNumbers.hasNext()) {
          try {
            Integer num = Integer.parseInt(selectedNumbers.next());
            selectedCards.add(num);
          } catch (Exception e) {
            System.out.println("Bad selection - try again. . .");
            selectedCards.clear();
            displayBoard();
            System.out.println("Select your cards:");
            answer = s1.nextLine();
          }
      }
      if(validSelection(selectedCards)) {
        System.out.println("Good selection. Replacing cards. . .");
        board.replaceSelectedCards(selectedCards);
        selectedCards.clear();
        displayBoard();
        System.out.println("Select your cards:");
        answer = s1.nextLine();
      } else {
        System.out.println("Bad selection - try again. . .");
        selectedCards.clear();
        displayBoard();
        System.out.println("Select your cards:");
        answer = s1.nextLine();
      }
    }

    System.out.println("Thanks for playing. . .");
    System.out.println(board.gameIsWon() ? "Congratulations! You Win!" : "You Lost. Better luck next time.");
  }

  /**
   * Called by playGame to display the current board state including:
   *  - the cards on the board and their indexes
   *  - the number of cards remaining in the deck
   */
  private void displayBoard()
  {
    System.out.println("---------- Cards ----------- (" + board.deckSize() + ")");
    System.out.println(board);
  }

  /**                                                                             
   * Called by playGame to checks if selectedCards indexes are within 
   * bounds and do not reference a null card                                                                           
   */
  private boolean validSelection(List<Integer> selectedCards)
  {
    boolean valid = true;
    int legalNumbers = 0;
    for(int i = 0; i < selectedCards.size(); i++) {
      if(selectedCards.get(i) > board.size() || selectedCards.get(i) < 0) {
        valid = false;
        break;
      } else {
        legalNumbers++;
      }
    }
    return (legalNumbers == selectedCards.size() && valid && board.isLegal(selectedCards));
  }

}