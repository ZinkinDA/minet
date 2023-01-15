package sweeper;

public class MatrixField {
    private StatusUpperField[][] privateFieldMatrix; // статус 0 - открыто, 1 - закрыто, 2 - флаг бомбы,
    private int[][] publicMatrixField; // статус 0 - нет цифры, 1-8 количество бомб вокруг
    private final int WIDTH, HEIGHT;

    protected MatrixField(int WIDTH, int HEIGHT) {
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        privateFieldMatrix = new StatusUpperField[WIDTH][HEIGHT];
        publicMatrixField = new int[WIDTH][HEIGHT];
        initField();
    }

    protected void initField() {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                privateFieldMatrix[x][y] = StatusUpperField.CLOSED;
            }
        }
    }

    protected StatusUpperField getFieldMatrix(int x, int y) {
        return privateFieldMatrix[x][y];
    }

    protected void setFieldMatrix(int x, int y, StatusUpperField status) {
        privateFieldMatrix[x][y] = status;
    }

    protected int getField(int x, int y) {
        return publicMatrixField[x][y];
    }

    protected void setField(int x, int y, int number) {
        publicMatrixField[x][y] = number;
    }
}