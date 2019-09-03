package Board;

public class Board {
    int[][] board;
    int initSize;
    int initCol;
    int initRow;

    Board(int s, int col, int row){
        initSize = s;
        initCol = col;
        initRow = row;

        board = new int[initSize][initSize];
        for(int i=0; i < initSize; i++){
            for(int j =0; j<initSize; j++){
                board[i][j] = 8;
            }
        }
        board[row][col] = 0;

        System.out.print("INITIAL ");
        System.out.println("ARRAY: \n");
        for(int i =0; i < initSize; i++){
            for (int j =0; j < initSize; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    void printArray(){
        System.out.println("ARRAY: \n");
        for(int i =0; i < initSize; i++){
            for (int j =0; j < initSize; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    int getMissingQuadrant(int n, int col, int row){
        int size = n/2;
        int c = col/size;
        int r = row/size;
        if(c % 2 != 0 && r % 2 == 0){
            return 2;
        }
        if(c % 2 == 0 && r % 2 != 0){
            return 1;
        }
        if(c % 2 == 0 && r % 2 == 0){
            return 3;
        }
        else return 4;
    }
    void solveBoard(){
        //System.out.println("initSize" + initSize);
        tileBoard(board.length, initCol, initRow, initSize/2, initSize/2);
    }
    void tileBoard(int n, int col, int row, int x, int y){
        if(n == 2){
            int missingQuadrant = getMissingQuadrant(n, col, row);
            //System.out.println("n=2 missing q: " + missingQuadrant);
            switch (missingQuadrant){
                case 1:{ // bottom left quadrant
                    //System.out.println("case 1");
                    board[row-1][col] = 1;
                    board[row][col+1] = 1;
                    board[row-1][col+1] = 1;
                    break;
                }
                case 2: { //upper right quadrant
                    //System.out.println("case 2");
                    board[row][col-1] = 2;
                    board[row+1][col] = 2;
                    board[row+1][col-1] = 2;
                    break;
                }
                case 3:{ //upper left quadrant
                    //System.out.println("case 3");
                    board[row][col+1] = 3;
                    board[row+1][col] = 3;
                    board[row+1][col+1] = 3;
                    break;
                }
                case 4:{ //bottom right quadrant
                    //System.out.println("case 4");
                    board[row-1][col] = 4;
                    board[row][col-1] = 4;
                    board[row-1][col-1] = 4;
                    break;
                }
            }
        }
        else{
            int missingQuadrant = getMissingQuadrant(n, col, row);
            //System.out.println("New call: ");
            //System.out.println("n: " + n + " missing q: " + missingQuadrant);
            switch (missingQuadrant) {
                case 1: { // bottom left quadrant
                    //System.out.println("case 1");

                    x -= 1;

                    board[y - 1][x] = 1;
                    board[y][x + 1] = 1;
                    board[y - 1][x + 1] = 1;

                    //printArray();
                        tileBoard(n / 2, col, row, x + 1 - n/4, y + n/4); //bottom left
                        tileBoard(n / 2, x, y-1, x+ 1 - n/4, y - n/4); //upper left
                        tileBoard(n / 2, x+1, y-1, x + n/4 + 1, y - n/4); //upper right
                        tileBoard(n / 2, x+1, y, x + n/4 + 1, y + n/4); //bottom right
                    break;
                }
                case 2: { //upper right quadrant
                    //System.out.println("case 2");

                    y -= 1;

                    board[y][x - 1] = 2;
                    board[y + 1][x] = 2;
                    board[y + 1][x - 1] = 2;

                    //printArray();
                        tileBoard(n / 2, col, row, x + n/4, y + 1 - n/4); //upper right
                        tileBoard(n / 2, x-1, y, x - n/4, y + 1 - n/4); //upper left
                        tileBoard(n / 2, x-1, y+1, x - n/4, y + 1 + n/4); //bottom left
                        tileBoard(n / 2, x, y+1, x + n/4,y + 1 + n/4); //bottom right
                    break;
                }
                case 3: { //upper left quadrant
                    x -= 1;
                    y -= 1;
                    board[y][x+1] = 3;
                    board[y+1][x] = 3;
                    board[y+1][x+1] = 3;

                    //printArray();
                        tileBoard(n / 2, col, row, x + 1 - n/4, y + 1 - n/4); //upper left
                        tileBoard(n / 2, x, y+1, x + 1 - n/4, y + 1 + n/4); //bottom left
                        tileBoard(n / 2, x+1, y, x + 1 + n/4, y + 1 - n/4); //upper right
                        tileBoard(n / 2, x+1, y+1, x + 1 + n/4, y + 1 + n/4); //bottom right
                    break;
                }
                case 4: { //bottom right quadrant
                    //System.out.println("case 4");
                    board[y - 1][x] = 4;
                    board[y][x - 1] = 4;
                    board[y - 1][x - 1] = 4;

                    //printArray();
                        tileBoard(n / 2, col, row, x + n/4, y + n/4); //bottom right
                        tileBoard(n / 2, x-1, y, x - n/4, y + n/4); //bottom left
                        tileBoard(n / 2, x, y-1, x + n/4, y - n/4); //upper right
                        tileBoard(n / 2, x-1,y-1, x - n/4, y - n/4); //upper left
                    break;
                }
            }
        }
    }
}
