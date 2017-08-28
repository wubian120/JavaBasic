package cn.brady.string;

public class Keyword {

    private long id;
    private  String value;
    private long categoryId;
    private int type;
    private int exclude;


    public int getExclude() { return exclude; }
    public void setExclude(int exclude) { this.exclude = exclude; }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public void setType(int type) { this.type = type; }
    public int getType() { return type; }

    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }

    public long getCategoryId() { return categoryId; }
    public void setCategoryId(long categoryId) { this.categoryId = categoryId; }
}
