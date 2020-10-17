package nl.avd.javadev.proftaak;

public enum ShapeTableColumns {
    ID  (1),
    TYPE(2),
    PROPERTIES(3),
    VOLUME(4);

    private int columnIndex;

    ShapeTableColumns(int i) {
        this.columnIndex = i;
    }

    public int getIndex() {
        return this.columnIndex;
    }
}
