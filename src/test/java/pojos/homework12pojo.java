package pojos;
import java.util.ArrayList;
import java.util.Arrays;

public class homework12pojo {
    private Integer id;
    private categoryDatepojo categoryDatepojo;
    private String name;
    private ArrayList photoUrls;
    private tagspojo tagsDatapojo;
    private String stateurl;

    @Override
    public String toString() {
        return "homework12pojo{" +
                "id=" + id +
                ", categoryDatepojo=" + categoryDatepojo +
                ", name='" + name + '\'' +
                ", photoUrls=" + photoUrls +
                ", tagsDatapojo=" + tagsDatapojo +
                ", stateurl='" + stateurl + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public homework12pojo(Integer id, pojos.categoryDatepojo categoryDatepojo, String name, ArrayList photoUrls, tagspojo tagsDatapojo, String stateurl) {
        this.id = id;
        this.categoryDatepojo = categoryDatepojo;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tagsDatapojo = tagsDatapojo;
        this.stateurl = stateurl;
    }

    public pojos.categoryDatepojo getCategoryDatepojo() {
        return categoryDatepojo;
    }

    public void setCategoryDatepojo(pojos.categoryDatepojo categoryDatepojo) {
        this.categoryDatepojo = categoryDatepojo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(ArrayList photoUrls) {
        this.photoUrls = photoUrls;
    }

    public pojos.tagspojo getTagsDatapojo() {
        return tagsDatapojo;
    }

    public void setTagsDatapojo(pojos.tagspojo tagsDatapojo) {
        this.tagsDatapojo = tagsDatapojo;
    }

    public String getStateurl() {
        return stateurl;
    }

    public void setStateurl(String stateurl) {
        this.stateurl = stateurl;
    }
}