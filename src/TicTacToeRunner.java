import java.util.Scanner;

public class TicTacToeRunner {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        char p = 'X';
        TicTacToeClass ttt = new TicTacToeClass();
        int r, c;
        String convert;
        char converted[];

        while (!(ttt.isWinner('X') || ttt.isWinner('O') || ttt.isFull())) {
            ttt.displayBoard();
            System.out.print("'" + p + "', choose your location (row, column): ");            
            // This makes the input work even if there is a comma, or anything really. 
            convert = keyboard.nextLine();
            convert = convert.replaceAll("[^0-9]","");
            System.out.println(convert);
            converted = convert.toCharArray();
            r = converted[0];
            c = converted[1];
            r = Character.getNumericValue(r);
            c = Character.getNumericValue(c);
            // original method provided by the base code
            // r = keyboard.nextInt();
            // c = keyboard.nextInt();

            while (ttt.isValid(r, c) == false || ttt.playerAt(r, c) != ' ') {
                if (ttt.isValid(r, c) == false)
                    System.out.println("That is not a valid location. Try again.");
                else if (ttt.playerAt(r, c) != ' ')
                    System.out.println("That location is already full. Try again.");

                System.out.print("Choose your location (row, column): ");
                convert = keyboard.nextLine();
                convert = convert.replaceAll("[^0-9]","");
                System.out.println(convert);
                converted = convert.toCharArray();
                r = converted[0];
                c = converted[1];
                r = Character.getNumericValue(r);
                c = Character.getNumericValue(c);
                // original method provided by the base code
                // r = keyboard.nextInt();
                // c = keyboard.nextInt();
            }

            ttt.playMove(p, r, c);

            if (p == 'X')
                p = 'O';
            else
                p = 'X';

        }

        ttt.displayBoard();

        if (ttt.isWinner('X'))
            System.out.println("X is the winner!");
            keyboard.close();
        if (ttt.isWinner('O'))
            System.out.println("O is the winner!");
            keyboard.close();
        if (ttt.isCat())
            System.out.println("The game is a tie.");
            keyboard.close();

    }

}