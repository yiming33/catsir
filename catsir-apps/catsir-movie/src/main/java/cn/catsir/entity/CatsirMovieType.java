package cn.catsir.entity;

public class CatsirMovieType {
    private String id;

    private String name;

    private String parentId;

    private String hierarchicalId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getHierarchicalId() {
        return hierarchicalId;
    }

    public void setHierarchicalId(String hierarchicalId) {
        this.hierarchicalId = hierarchicalId;
    }
}