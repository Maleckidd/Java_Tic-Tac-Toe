public class TTT {

    private char[][] board;
    private char currentPlayerMark;

    public char getCurrentPlayerMark() {
        return currentPlayerMark;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }

    public void initializeBoard(){

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                board[i][j] ='-';
            }
        }
    }

    public void printBoard(){
        System.out.println("-------------");

        for (int i = 0; i < 3; i++){
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    public boolean isBoardFull(){
       for (int i = 0; i < 3; i++){
           for (int j = 0; j< 3; j++){
               if(board[i][j] == '-'){
                   return true;
               }
           }
       }
       return false;
    }

    public boolean checkColRow(char x,char y ,char z){
        for(int i = 0; i < 3; i++ ) {
            for (int j = 0; j < 3; j++) {
                if ((x == 'x' && y == 'x' && z == 'x') ||(x == 'o' && y == 'o' && z == 'o')) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkForWin() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (checkColRow(board[i][0], board[i][1], board[i][2])) {
                    return true;
                } else if (checkColRow(board[0][j], board[1][j], board[2][j])) {
                    return true;
                } else if (checkColRow(board[0][0], board[1][1], board[2][2])){
                    return true;
                } else if (checkColRow(board[0][0], board[1][1], board[2][2])){
                    return true;
                }
            }
        }
        return false;
    }

    public void changePlayer(){
        if (currentPlayerMark == 'x'){
            currentPlayerMark = 'o';
        } else {
            currentPlayerMark = 'x';
        }
    }

    public boolean placeMark(int row, int col) {
        if ((row >= 0) && (row < 3)){
            if ((col >= 0) && (col < 3)){
                if (board[row][col] == '-'){
                    board[row][col] = currentPlayerMark;
                    return true;
                } else {
                    System.out.println("no empty field");
                }
            } else {
                System.out.println("out of scope");
            }
        } else {
            System.out.println("out of scope");
        }
        return false;
    }
}