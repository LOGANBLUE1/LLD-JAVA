package designProblemsAndGames.trello;

public interface BoardManagerInterface {
    Board createBoard(CreateBoardDto board);
    void deleteBoard(Board board);
}
