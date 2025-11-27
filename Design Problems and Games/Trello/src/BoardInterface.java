public interface BoardInterface {
    User addMember(User member);
    void removeMember(User member);
    ItemList createList(String name);
    void deleteList(ItemList list);
}
