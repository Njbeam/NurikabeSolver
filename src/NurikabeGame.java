public class NurikabeGame {
    public final static int SIZE = 5;

    public static class cell{
        boolean white;
        boolean black;
        boolean unsolved;
        int number;
        public cell(){
            this.white = true;
            this.black = false;
            this.unsolved = true;
            this.number = 0;
        }
    }

    public static boolean squareExists(cell[][] board){
        for(int r = 0; r < SIZE-1; r++) {
            for (int c = 0; c < SIZE-1; c++) {
                if(board[r][c].black && board[r][c+1].black && board[r+1][c].black && board[r+1][c+1].black){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean blackConnected(cell[][] board){
        return true;
    }

    public static boolean numbersSatisfied(cell[][] board){
        return true;
    }

    public static boolean gameSolved(cell[][] board){

        if(squareExists(board) || !blackConnected(board) || !numbersSatisfied(board)){
            return false;
        }else{
            return true;
        }
    }

    public static void main(String[] args) {
        cell[][] gameBoard5 = new cell[SIZE][SIZE];
        for(int r = 0; r < SIZE; r++){
            for(int c = 0; c < SIZE; c++){
                gameBoard5[r][c] = new cell();
            }
        }
        gameBoard5[0][0].number=2;
        gameBoard5[1][2].number=1;
        gameBoard5[2][0].number=4;
        gameBoard5[2][4].number=2;
        gameBoard5[3][2].number=1;
        gameBoard5[4][4].number=1;
        System.out.println("\n\nSolving Nurikabe Puzzle from template below");
        for(int r = 0; r < SIZE; r++){
            System.out.println();
            for(int c = 0; c < SIZE; c++){
                if(gameBoard5[r][c].number==0){
                    System.out.print("-");
                }else{
                    System.out.print(gameBoard5[r][c].number);
                }

            }
        }
        long startTime = System.nanoTime();
        boolean gameSolved = gameSolved(gameBoard5);
        if(gameSolved){
            long endTime = System.nanoTime();
            long totalTime = endTime-startTime;
            System.out.println("\n\nThe puzzle was solved in " + totalTime + " milliseconds");
        }

    }
}
