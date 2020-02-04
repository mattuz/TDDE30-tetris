package se.liu.ida.matge373.tddd78.tetris;

public class Poly
{
    private SquareType[][] polymino;


    public Poly(final SquareType[][] polymino) {
        this.polymino = polymino;
    }

    public int getHeight(){
        return this.polymino.length;
    }

    public int getWidth(){
        return this.polymino[0].length;
    }
}
