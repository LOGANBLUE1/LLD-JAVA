import java.util.List;

public class BoardManager implements BoardManagerInterface{
    String id;
    List<Board> boards;

    @Override
    public void deleteBoard(Board board) {
        boards.removeIf(m -> m.id.equals(board.id));
    }

    @Override
    public Board createBoard(CreateBoardDto board) {
        Board newBoard = new Board(board);
        boards.add(newBoard);
        return newBoard;
    }
}
