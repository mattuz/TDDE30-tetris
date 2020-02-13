package se.liu.ida.matge373.tddd78.tetris;

public class Poly
{
    private SquareType[][] polymino;


    public Poly(final SquareType[][] polymino) {
        this.polymino = polymino;
    }

    public int getPolyHeight() {
        return this.polymino.length;
    }

    public int getPolyWidth() {
        return this.polymino[0].length;
    }

    public SquareType[][] getPolymino() {
        return polymino;
    }

    public SquareType getPolyminoAt(int x, int y) {
        return polymino[x][y];
    }

    public static void main(String[] args) {
        Poly test = new TetrominoMaker().getPoly(2);
        System.out.println(test.getPolyHeight());
        System.out.println(test.getPolyWidth());
        System.out.println(test.getPolyminoAt(1, 2));
    }
}
