package goorm.dbjj.ide.storageManager.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Resource {
    protected String name;
    protected String fullPath;
    private String content;
    protected ResourceType resourceType;
    private List<Resource> children;
    private Resource[] child;

    private Resource(String name, String fullPath, ResourceType resourceType) {
        this.name = name;
        this.fullPath = fullPath;
        this.resourceType = resourceType;
    }

    private Resource(String name, String fullPath, String content, ResourceType resourceType) {
        this.name = name;
        this.fullPath = fullPath;
        this.content = content;
        this.resourceType = resourceType;
    }

    public static Resource file(String name, String path, String content) {
        return new Resource(name, path, content, ResourceType.FILE);
    }

    public static Resource directory(String name, String path) {
        return new Resource(name, path,null, ResourceType.DIRECTORY);
    }

    public static Resource resource(String name, String path, ResourceType resourceType) {
        return new Resource(name, path, resourceType);
    }

    public void setChild(List<Resource> children) {
        this.children = children;
    }

    public void addChildren(Resource children) {
        this.children.add(children);
    }

    @Override
    public String toString() {
        return toStringHelper("");
    }

    private String toStringHelper(String indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(indent).append("Name: ").append(name).append(", Type: ").append(resourceType).append("\n");
        if (resourceType == ResourceType.DIRECTORY && child != null) {
            for (Resource res : children) {
                sb.append(res.toStringHelper(indent + "  ")); // 들여쓰기를 위해 공백 추가
            }
        }
        return sb.toString();
    }
    public boolean isDirectory() {
        return this.resourceType == ResourceType.DIRECTORY;
    }
    public boolean isFile() {
        return this.resourceType == ResourceType.FILE;
    }
}