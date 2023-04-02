import dsa.Inversions;
import dsa.LinkedQueue;
import dsa.Queue;
import stdlib.In;
import stdlib.StdOut;

// A data type to represent a board in the 8-puzzle game or its generalizations.
public class Board {
    private int[][] tiles;

    // Constructs a board from an n x n array; tiles[i][j] is the tile at row i and column j, with 0
    // denoting the blank tile.
    public Board(int[][] tiles) {
        this.tiles = tiles;
    }

    // Returns the size of this board.
    public int size() {
        int result = 0;
        for(int i = 0; i < this.tiles.length; i++) {
            for(int j = 0; j < this.tiles[0].length; j++) {
                result++;
            }
        }
        return result;
    }

    // Returns the tile at row i and column j of this board.
    public int tileAt(int i, int j) {
        return this.tiles[i][j];
    }

    // Returns Hamming distance between this board and the goal board.
    public int hamming() {
        int index = 1;
        int res = 0;
        for(int i = 0; i < this.tiles.length; i++) {
            for(int j = 0; j < this.tiles[0].length; j++) {
                if(index != this.tiles[i][j]) res++;
            }
        }
        return res;
    }

    // Returns the Manhattan distance between this board and the goal board.
    public int manhattan() {
        int horizontal = this.tiles.length;
        int vertical = this.tiles[0].length;
        int [][] arr = {{1,2,3},{4,5,6},{7,8,9}};

    }

    // Returns true if this board is the goal board, and false otherwise.
    public boolean isGoal() {
        int index = 1;
        for(int i = 0; i < this.tiles.length; i++) {
            for (int j = 0; j < this.tiles[0].length; j++) {
                if(i == this.tiles.length - 1 && j == this.tiles[0].length && this.tiles[i][j] == 0) return true;
                if(this.tiles[i][j] != index) return false;
                index++;


            }
        }
        return true;
    }

    // Returns true if this board is solvable, and false otherwise.
    public boolean isSolvable() {
        int size = (this.tiles.length * this.tiles.length) - 1;
        int[] arr = new int[size];
        int index = 0;
        for (int i = 0; i < this.tiles.length; i++) {
            for(int j = 0; j < this.tiles[0].length; j++) {
                arr[index] = this.tiles[i][j];
                index++;
            }
        }
        long numOfInversions = Inversions.count(arr);
        if(this.tiles.length % 2 == 1) {
            if(numOfInversions % 2 == 1) {
                return false;
            }
        }
        else if(this.tiles.length % 2 == 0) {
            if(numOfInversions % 2 == 0) {
                return false;
            }
        }
        return true;

    }

    // Returns an iterable object containing the neighboring boards of this board.
    public Iterable<Board> neighbors() {
        Queue<Board> queue = new LinkedQueue<>();
        
    }

    // Returns true if this board is the same as other, and false otherwise.
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other == this) {
            return true;
        }
        if (other.getClass() != this.getClass()) {
            return false;
        }
        ...
    }

    // Returns a string representation of this board.
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                s.append(String.format("%2s", tiles[i][j] == 0 ? " " : tiles[i][j]));
                if (j < n - 1) {
                    s.append(" ");
                }
            }
            if (i < n - 1) {
                s.append("\n");
            }
        }
        return s.toString();
    }

    // Returns a defensive copy of tiles[][].
    private int[][] cloneTiles() {
        int[][] clone = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                clone[i][j] = tiles[i][j];
            }
        }
        return clone;
    }

    // Unit tests the data type. [DO NOT EDIT]
    public static void main(String[] args) {
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] tiles = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tiles[i][j] = in.readInt();
            }
        }
        Board board = new Board(tiles);
        StdOut.printf("The board (%d-puzzle):\n%s\n", n, board);
        String f = "Hamming = %d, Manhattan = %d, Goal? %s, Solvable? %s\n";
        StdOut.printf(f, board.hamming(), board.manhattan(), board.isGoal(), board.isSolvable());
        StdOut.println("Neighboring boards:");
        for (Board neighbor : board.neighbors()) {
            StdOut.println(neighbor);
            StdOut.println("----------");
        }
    }
}
