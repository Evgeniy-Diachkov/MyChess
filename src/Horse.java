public class Horse extends ChessPiece {

    // Метод для получения цвета фигуры
    @Override
    public String getColor() {
        return this.color;
    }

    // Конструктор, принимающий цвет фигуры
    public Horse(String color) {
        super(color);
    }

    // Метод для получения символа фигуры
    @Override
    public String getSymbol() {
        return "H";
    }

    // Метод для проверки, может ли фигура переместиться на указанную позицию
    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        // Проверяем, что координаты находятся в пределах доски
        if (!chessBoard.checkPos(line) || !chessBoard.checkPos(column) ||
                !chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn)) {
            return false;
        }

        // Проверяем, что начальная и конечная позиции не совпадают
        if (line == toLine && column == toColumn) {
            return false;
        }

        // Проверяем, что ход соответствует движению коня (буквой "Г")
        int dLine = Math.abs(toLine - line);
        int dColumn = Math.abs(toColumn - column);
        if ((dLine == 2 && dColumn == 1) || (dLine == 1 && dColumn == 2)) {
            // Проверяем, что конечная позиция свободна или занята фигурой противоположного цвета
            ChessPiece targetPiece = chessBoard.board[toLine][toColumn];
            if (targetPiece == null || !targetPiece.getColor().equals(this.color)) {
                return true;
            }
        }

        return false;
    }
}