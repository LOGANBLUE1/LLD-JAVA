import java.util.ArrayList;
import java.util.List;

public class Board implements BoardInterface {
    String id;
    String name;
    Privacy privacy;
    String url;
    List<User> members;
    List<ItemList> lists;

    public Board(CreateBoardDto board) {
        this.name = board.name;
        this.privacy = board.privacy;
        this.url = board.url;
        this.members = new ArrayList<>();
        this.lists = new ArrayList<>();
    }

    @Override
    public User addMember(User member) {
        members.add(member);
        return member;
    }

    @Override
    public void removeMember(User member) {
        members.removeIf(m -> m.id.equals(member.id));
    }

    @Override
    public ItemList createList(String name) {
        ItemList newList = new ItemList();
        newList.name = name;
        lists.add(newList);
        return newList;
    }

    @Override
    public void deleteList(ItemList list) {
        lists.removeIf(l -> l.id.equals(list.id));
    }
}
