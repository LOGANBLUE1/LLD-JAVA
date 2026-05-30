package structuralPatterns.composite.example2;

import java.util.*;

class Folder implements FileSystemComponent {
    private List<FileSystemComponent> children = new ArrayList<>();

    public void add(FileSystemComponent component) {
        children.add(component);
    }

    @Override
    public int getSize() {
        int total = 0;

        for (FileSystemComponent child : children) {
            total += child.getSize();
        }

        return total;
    }
}