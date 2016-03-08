package kz.ef.art.graphics;

public enum DriveDirection {

    D5(0, 0, 5),
    D8(+0, -1, 8),
    D9(+1, -1, 9),
    D6(+1, +0, 6),
    D3(+1, +1, 3),
    D2(-0, +1, 2),
    D1(-1, +1, 1),
    D4(-1, -0, 4),
    D7(-1, -1, 7);

    private final int deltaX;
    private final int deltaY;
    private final int key;

    DriveDirection(int deltaX, int deltaY, int key) {
        this.deltaX = deltaX;
        this.deltaY = deltaY;
        this.key = key;
    }

    public static DriveDirection get(int key) {
        DriveDirection[] values = DriveDirection.values();
        for (DriveDirection value : values) {
            if (value.key == key) return value;
        }
        return D5;
    }

    public static DriveDirection get(int dX, int dY) {
        DriveDirection[] values = DriveDirection.values();
        for (DriveDirection value : values) {
            if (value.deltaX == dX && value.deltaY == dY) return value;
        }
        return D5;
    }

    public int getDeltaX() {
        return deltaX;
    }

    public int getDeltaY() {
        return deltaY;
    }

    public int getKey() {
        return key;
    }

}
