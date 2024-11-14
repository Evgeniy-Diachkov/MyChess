public class Pawn extends ChessPiece {

    // Метод для получения цвета фигуры
    @Override
    public String getColor() {
        return this.color;
    }

    // Конструктор, принимающий цвет фигуры
    public Pawn(String color) {
        super(color);
    }

    // Метод для получения символа фигуры
    @Override
    public String getSymbol() {
        return "P";
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

        int direction = color.equals("White") ? 1 : -1;

        // Проверяем возможность обычного хода пешки (на 1 клетку вперед)
        if (column == toColumn && toLine == line + direction) {
            if (chessBoard.board[toLine][toColumn] == null) {
                return true;
            }
        }

        // Проверяем возможность первого хода пешки (на 2 клетки вперед)
        if (column == toColumn && ((color.equals("White") && line == 1 && toLine == line + 2) ||
                (color.equals("Black") && line == 6 && toLine == line - 2))) {
            if (chessBoard.board[toLine][toColumn] == null && chessBoard.board[line + direction][column] == null) {
                return true;
            }
        }

        // Проверяем возможность взятия фигуры противника (по диагонали)
        if (Math.abs(toColumn - column) == 1 && toLine == line + direction) {
            ChessPiece targetPiece = chessBoard.board[toLine][toColumn];
            if (targetPiece != null && !targetPiece.getColor().equals(this.color)) {
                return true;
            }
        }

        return false;
    }
}
