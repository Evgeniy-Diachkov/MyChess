public class Rook extends ChessPiece {

    // Метод для получения цвета фигуры
    @Override
    public String getColor() {
        return this.color;
    }

    // Конструктор, принимающий цвет фигуры
    public Rook(String color) {
        super(color);
    }

    // Метод для получения символа фигуры
    @Override
    public String getSymbol() {
        return "R";
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

        // Проверяем, что ход соответствует движению ладьи (по прямой линии)
        if (line == toLine || column == toColumn) {
            int stepLine = line == toLine ? 0 : (toLine - line) > 0 ? 1 : -1;
            int stepColumn = column == toColumn ? 0 : (toColumn - column) > 0 ? 1 : -1;
            int currentLine = line + stepLine;
            int currentColumn = column + stepColumn;

            // Проверяем, что на пути нет других фигур
            while (currentLine != toLine || currentColumn != toColumn) {
                if (chessBoard.board[currentLine][currentColumn] != null) {
                    return false;
                }
                currentLine += stepLine;
                currentColumn += stepColumn;
            }

            // Проверяем, что конечная позиция свободна или занята фигурой противоположного цвета
            ChessPiece targetPiece = chessBoard.board[toLine][toColumn];
            if (targetPiece == null || !targetPiece.getColor().equals(this.color)) {
                return true;
            }
        }

        return false;
    }
}
