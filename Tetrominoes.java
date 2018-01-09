import java.awt.Color;

enum Tetrominoes{
    ZShape(new int[][]{{0,-1},{0,0},{-1,0},{1,-1}}),
    SShape(new int[][]{{0,-1},{0,0},{1,0},{-1,-1}}),
    TShape(new int[][]{{0,-1},{0,0},{1,0},{0,1}}),
    IShape(new int[][]{{0,-1},{0,0},{0,1},{0,2}}),
    SquareShape(new int[][]{{0,0},{1,0},{0,1},{1,1}}),
    Lshape(new int[][]{{1,-1},{0,-1},{0,0},{0,1}}),
    MirrorLShape(new int[][]{{-1,-1},{0,-1},{0,0},{0,1}});
    public int[][] coords;

    private Tetrominoes(int[][] coords ){
	this.coords = coords;
    }

    private Color[] tetroColors = { Color.red, Color.green, Color.pink, Color.cyan, Color.yellow, Color.orange, Color.blue};
}
