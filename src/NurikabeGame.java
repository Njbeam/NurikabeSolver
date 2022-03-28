public class NurikabeGame {
    public final static int SIZE = 5;

    public static class cell{
        boolean white;
        boolean black;
        boolean unsolved;
        boolean stayWhite;
        int number;
        public cell(){
            this.white = false;
            this.black = true;
            this.unsolved = true;
            this.number = 0;
            this.stayWhite = false;
        }
    }

    public static class coordinates{
        int x;
        int y;
        public coordinates(){
            this.x = x;
            this.y = y;
        }
    }

    public static boolean squareExists(cell[][] board, int r, int c){

        if(board[r][c].black && board[r][c+1].black && board[r+1][c].black && board[r+1][c+1].black){
            return true;

        }
        return false;
    }

    public static boolean blackConnected(cell[][] board){
        return true;
    }

    public static boolean checkNumbersSatisfied(cell[][] board, int r, int c){
        //function adapted from Suriya Shankar
        //located at: https://github.com/Ayiruss/Nurikabe/blob/master/Solution.java
        int puzzleLength = board.length;
        int num = 1;

        if(board[r][c].number != 0){
            num = board[r][c].number;
        }
        int count = 0;
        if(r != 0 && board[r-1][c].white) count++;
        if(c != 0 && board[r][c-1].white) count++;
        if(r != puzzleLength-1 && board[r+1][c].white) count++;
        if(c != puzzleLength-1 && board[r][c+1].white) count++;
        if(count==num-1) return true;
        else return false;

    }

    public static coordinates checkNeighbors(cell[][] board, int r, int c){
        coordinates coords = new coordinates();
        if (r == 0) {
            if (c == 0) {
                if(!board[r][c+1].stayWhite){
                    coords.x = r;
                    coords.y = c+1;
                    return coords;
                }else if(!board[r+1][c].stayWhite){
                    coords.x = r+1;
                    coords.y = c;
                    return coords;
                }else{
                    System.out.println("\n\nNo solution found for your puzzle\n");
                }
            }
            if (c == 4) {
                if(!board[r][c-1].stayWhite){
                    coords.x = r;
                    coords.y = c-1;
                    return coords;
                }else if(!board[r+1][c].stayWhite){
                    coords.x = r+1;
                    coords.y = c;
                    return coords;
                }else{
                    System.out.println("\n\nNo solution found for your puzzle\n");
                }
            }
        }
        if (r == 4) {
            if (c == 0) {
                if(!board[r][c+1].stayWhite){
                    coords.x = r;
                    coords.y = c+1;
                    return coords;
                }else if(!board[r-1][c].stayWhite){
                    coords.x = r-1;
                    coords.y = c;
                    return coords;
                }else{
                    System.out.println("\n\nNo solution found for your puzzle\n");
                }
            }
            if (c == 4) {
                if(!board[r][c-1].stayWhite){
                    coords.x = r;
                    coords.y = c-1;
                    return coords;
                }else if(!board[r-1][c].stayWhite){
                    coords.x = r-1;
                    coords.y = c;
                    return coords;
                }else{
                    System.out.println("\n\nNo solution found for your puzzle\n");
                }
            }
        }
        else{
            if(!board[r][c+1].stayWhite){
                coords.x = r;
                coords.y = c+1;
                return coords;
            }else if(!board[r-1][c].stayWhite){
                coords.x = r-1;
                coords.y = c;
                return coords;
            }if(!board[r][c-1].stayWhite){
                coords.x = r;
                coords.y = c-1;
                return coords;
            }else if(!board[r+1][c].stayWhite){
                coords.x = r+1;
                coords.y = c;
                return coords;
            }
        }
        return coords;
    }

    public static void satisfyNumbers(cell[][] board) {
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                if (board[r][c].number != 0) {
                    board[r][c].stayWhite = true;
                }
                if (board[r][c].number != 0) {
                    boolean isSolved = false;
                    while (!isSolved) {
                        if (board[r][c].number == 1) {
                            if (r == 0) {
                                if (c == 0) {
                                    board[r + 1][c].unsolved = false;
                                    board[r][c + 1].unsolved = false;
                                }
                                if (c == 4) {
                                    board[r + 1][c].unsolved = false;
                                    board[r][c - 1].unsolved = false;
                                }
                            }
                            if (r == 4) {
                                if (c == 0) {
                                    board[r - 1][c].unsolved = false;
                                    board[r][c + 1].unsolved = false;
                                }
                                if (c == 4) {
                                    board[r - 1][c].unsolved = false;
                                    board[r][c - 1].unsolved = false;
                                }
                            }
                            if (c == 0) {
                                if (r == 0) {
                                    board[r + 1][c].unsolved = false;
                                    board[r][c + 1].unsolved = false;
                                }
                                if (r == 4) {
                                    board[r - 1][c].unsolved = false;
                                    board[r][c + 1].unsolved = false;
                                }
                            }
                            if (c == 4) {
                                if (r == 0) {
                                    board[r + 1][c].unsolved = false;
                                    board[r][c - 1].unsolved = false;
                                }
                                if (r == 4) {
                                    board[r - 1][c].unsolved = false;
                                    board[r][c - 1].unsolved = false;
                                }
                            } else {
                                board[r - 1][c].unsolved = false;
                                board[r][c - 1].unsolved = false;
                                board[r + 1][c].unsolved = false;
                                board[r][c + 1].unsolved = false;
                            }
                        } else if (board[r][c].number != 0) {
                            int total = board[r][c].number;
                            int rowIndex = 1;
                            int colIndex = 1;
                            while(total!= 0) {
                                try {
                                    if (board[r][c + colIndex] != null) {
                                        board[r][c + colIndex].white = true;
                                        colIndex += 1;
                                        total--;
                                    }
                                    else if (board[r + rowIndex][c] != null) {
                                        board[r + rowIndex][c].white = true;
                                        rowIndex += 1;
                                        total--;
                                    }
                                    else if (board[r - rowIndex][c] != null) {
                                        board[r - rowIndex][c].white = true;
                                        rowIndex += 1;
                                        total--;
                                    }
                                    else if(board[r][c - colIndex] != null) {
                                        board[r][c - colIndex].white = true;
                                        colIndex += 1;
                                        total--;
                                    }
                                } catch (Exception e) {
                                    System.out.println("\nException caught");
                                }
                            }


                            }
                        isSolved = true;
                        }

                    }
                }
            }

        }




    public static void main(String[] args) {
        int r,c = 0;
        cell[][] gameBoard5 = new cell[SIZE][SIZE];
        for(r = 0; r < SIZE; r++){
            for(c = 0; c < SIZE; c++){
                gameBoard5[r][c] = new cell();
                if(gameBoard5[r][c].number!=0){
                    gameBoard5[r][c].black=false;
                    gameBoard5[r][c].white=true;
                }
            }
        }

        gameBoard5[0][0].number=2;
        gameBoard5[1][2].number=1;
        gameBoard5[2][0].number=4;
        gameBoard5[2][4].number=2;
        gameBoard5[3][2].number=1;
        gameBoard5[4][4].number=1;
        System.out.println("\n\nSolving Nurikabe Puzzle from template below");
        for(r = 0; r < SIZE; r++){
            System.out.println();
            for(c = 0; c < SIZE; c++){
                if(gameBoard5[r][c].number==0){
                    System.out.print("-");
                }else{
                    gameBoard5[r][c].black=false;
                    gameBoard5[r][c].white=true;
                    System.out.print(gameBoard5[r][c].number);
                }

            }
        }
        System.out.println("\n\n\n\n black squares");
        satisfyNumbers(gameBoard5);
        for(r = 0; r < SIZE; r++){
            System.out.println();
            for(c = 0; c < SIZE; c++){
                System.out.print(" "+gameBoard5[r][c].black);
            }
        }

    }
}
