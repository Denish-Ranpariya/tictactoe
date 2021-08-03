import java.util.Scanner;
import java.util.HashSet;
class TicTacToe{
    int[] status;
    boolean isOver;
    boolean isCross;
    HashSet<Integer> hs;
    boolean isCorrectPosition;

    public static void main(String[] args) {
        TicTacToe newGame = new TicTacToe();
        newGame.startGame();
    }

    public void startGame(){
        
        Scanner sc = new Scanner(System.in);
        status = new int[9];
        hs = new HashSet<Integer>();
        //0 - empty 
        //1 - cross
        //2 - circle

        isOver = false;
        isCross = false;
        isCorrectPosition = false;
        

        while(!isOver){
            int position = -1;
            while(!isCorrectPosition){
                printMatrix();
                System.out.println(!isCross ? ":::Player 1 turn:::" : ":::Player 2 turn:::");
                System.out.println("Enter the position(0-9): ");
                position = sc.nextInt();
                if(hs.contains(position)){
                    System.out.println("You can not fill the place which is already filled.");
                }else{
                    hs.add(position);
                    isCorrectPosition = true;
                }
                
            }
            isCorrectPosition = false;
            isCross = !isCross;

            if(isCross){
                status[position] = 1;
            }else{
                status[position] = 2;
            }
            
            ifGameOver();
        }
    }

    public String getSymbol(int status){
        if(status == 0){
            return " ";
        }else if(status == 1){
            return "*";
        }else{
            return "O";
        }
    }

    public void printMatrix(){
        System.out.println(getSymbol(status[0]) + " | " + getSymbol(status[1]) + " | " + getSymbol(status[2]) );
        System.out.println(getSymbol(status[3]) + " | " + getSymbol(status[4]) + " | " + getSymbol(status[5]) );
        System.out.println(getSymbol(status[6]) + " | " + getSymbol(status[7]) + " | " + getSymbol(status[8]) );
    }

    public boolean checkStatus(int p1, int p2, int p3){
        return (status[p1] != 0 && status[p1] == status[p2] && status[p2] == status[p3]);
    }

    public void printWinner(){
        System.out.println(isCross ? "Player 1 is winner" : "Player 2 is winner");
        isOver = true;
    }

    public void ifGameOver(){
        if(checkStatus(0,1,2)){
            printWinner();
        }else if(checkStatus(3,4,5)){
            printWinner();
        }else if(checkStatus(6,7,8)){
            printWinner();
        }else if(checkStatus(0,3,6)){
            printWinner();
        }else if(checkStatus(1,4,7)){
            printWinner();
        }else if(checkStatus(2,5,8)){
            printWinner();
        }else if(checkStatus(0,4,8)){
            printWinner();
        }else if(checkStatus(2,4,6)){
            printWinner();
        }else if(hs.size() == 9){
            System.out.println("Match Draw");
            isOver = true;
        }
    }
}

// 0 1 2
// 3 4 5
// 6 7 8