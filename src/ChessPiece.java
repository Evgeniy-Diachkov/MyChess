public abstract class ChessPiece {
    protected String color;  // цвет шахматной фигуры
    protected boolean check = true;  // состояние шаха, по умолчанию true

    // Конструктор для инициализации цвета
    public ChessPiece(String color) {
        this.color = color;
    }

    // Метод для получения цвета фигуры
    public String getColor() {
        return this.color;
    }

    // Абстрактный метод для проверки, может ли фигура переместиться на указанную позицию
    public abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);

    // Абстрактный метод для получения символа фигуры
    public abstract String getSymbol();
}