package ma.ac.usms.dto;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

public class Tache {

    @BsonProperty("id")
    @BsonId
    private ObjectId id;
    private String category;
    private String title;

    public Tache() {
    }

    public Tache(String category, String title) {

        this.category = category;
        this.title = title;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Tache{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
