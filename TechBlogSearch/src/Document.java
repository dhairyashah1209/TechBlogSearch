import java.util.*;

class Document {
    private final int id;
    private final String title;
    private final String content;
    private final long createdAt;
    private long updatedAt;

    public Document(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = System.currentTimeMillis();
        this.updatedAt = this.createdAt;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void updateContent(String newContent) {
        this.updatedAt = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createdAt=" + new Date(createdAt) +
                ", updatedAt=" + new Date(updatedAt) +
                '}';
    }
}