package structuralPatterns.composite;

//The client treats both through the same interface,
// without caring whether it's a single object (leaf) or a collection (composite).

// Common interface for both type of classes
// Classes use FileSystemComponent inside their implementation
// recusive calling of method inside object make a tree-like structure
public class Demo {
    public static void main(String[] args) {
        Folder root = new Folder();

        root.add(new File(10));
        root.add(new File(20));

        Folder docs = new Folder();
        docs.add(new File(50));

        Folder projects = new Folder();
        projects.add(new File(100));

        docs.add(projects);
        root.add(docs);

        System.out.println(root.getSize());
    }
}