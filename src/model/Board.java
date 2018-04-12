package model;

public class Board {

    private static int[][] board = new int[4][4];

    public Board(int[][] board) {   // konstruktor
        this.board = board;
    }


    public Board() {            // przykładowa tablica początkowa
        board = new int[][]{
                {2, 0, 2, 2},
                {0, 4, 8, 0},
                {2, 4, 0, 0},
                {0, 4, 8, 2}
        };
    }

    public static void moveDown() {
        goDown();
        System.out.println("Tablica po pierwszym przesuwaniu w dół: ");
        showBoard();
        mergeDown();
        System.out.println("Tablica po mergowaniu: ");
        showBoard();
        goDown();
        System.out.println("Tablica po ostatnim przesuwaniu w dół: ");
        showBoard();
    }

    // Przesuwanie w dół

    static void goDown() {
        for (int i = (board.length - 2); i >= 0; i--) { // iteracja od dołu począwszy od przedostatniego wiersza
            for (int j = (board.length - 1); j >= 0; j--) { // iteracja od końca począwszy od ostatniej kolumny
                if (board[i][j] != 0) {     // jeśli dana liczba w tablicy jest inna niż 0
                    int tmp = board[i][j];  // to zapisz tą wartość do zmiennej tmp
                    for (int k = (i + 1); k < board.length; k++) {  // iteracja rozpoczynająca się od pozycji poniżej
                        if (board[k][j] == 0) {     // jeśli dana wartość jest zerem
                            board[k][j] += tmp;     // dodaj wartość ze zmiennej tmp
                            board[k - 1][j] = 0;    // pozycji powyżej przypisujemy wartość 0
                        }
                    }
                }
            }
        }

    }
    // Sumowanie liczb o tej samej wartości stojących na sąsiednich pozycjach

    static void mergeDown() {
        for (int i = (board.length - 2); i >= 0; i--) {
            for (int j = (board.length - 1); j >= 0; j--) {
                if (board[i][j] != 0 && board[i + 1][j] == board[i][j]) {   // jeśli dana liczba nie jest 0 i jest równa tej poniżej
                    board[i + 1][j] += board[i][j];     // do pozycji niżej dodaj tą z góry
                    board[i][j] = 0;                    // na górze przypisz 0
                }
            }
        }
    }

    public static void moveUp() {
        goUp();
        System.out.println("Tablica po pierwszym przesuwaniu w górę: ");
        showBoard();
        mergeUp();
        System.out.println("Tablica po mergowaniu: ");
        showBoard();
        goUp();
        System.out.println("Tablica po ostatnim przesunięciu w górę: ");
        showBoard();
    }

    static void goUp() {
        for (int i = 1; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != 0) {
                    int tmp = board[i][j];
                    for (int k = (i - 1); k >= 0; k--) {
                        if (board[k][j] == 0) {
                            board[k][j] = tmp;
                            board[k + 1][j] = 0;
                        }
                    }
                }
            }
        }
    }

    static void mergeUp() {
        for (int i = 1; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if ((board[i][j] != 0) && (board[i][j] == board[i - 1][j])) {
                    board[i - 1][j] += board[i][j];
                    board[i][j] = 0;
                }
            }
        }
    }

    public static void moveRight() {
        goRight();
        mergeRight();
        goRight();
        showBoard();
    }

    static void goRight() {
        for (int i = (board.length - 1); i >= 0; i--) {
            for (int j = (board.length - 2); j >= 0; j--) {
                if (board[i][j] != 0) {
                    int tmp = board[i][j];
                    for (int k = (j + 1); k < board.length; k++) {
                        if (board[i][k] == 0) {
                            board[i][k] += tmp;
                            board[i][k - 1] = 0;
                        }
                    }
                }
            }
        }
    }

    static void mergeRight() {
        for (int i = (board.length - 1); i >= 0; i--) {
            for (int j = (board.length - 2); j >= 0; j--) {
                if (board[i][j] != 0 && board[i][j + 1] == board[i][j]) {
                    board[i][j + 1] += board[i][j];
                    board[i][j] = 0;
                }
            }
        }
    }


    public static void moveLeft() {
        goLeft();
        mergeLeft();
        goLeft();

    }

    public static void goLeft() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 1; j < board.length; j++) {
                if (board[i][j] != 0) {
                    int tmp = board[i][j];
                    for (int k = (j - 1); k >= 0; k--) {
                        if (board[i][k] == 0) {
                            board[i][k] = tmp;
                            board[i][k + 1] = 0;
                        }
                    }
                }
            }
        }
    }

    public static void mergeLeft() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 1; j < board.length; j++) {
                if((board[i][j] != 0) && (board[i][j] == board[i][j-1])) {
                    board[i][j-1] += board[i][j];
                    board[i][j] = 0;
                }
            }
        }
    }


    public int[][] getBoard() {
        return board;
    }

    public static void showBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }

    }


}
