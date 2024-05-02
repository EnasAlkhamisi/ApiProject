package pojos;


public class categoryDatepojo {
    private Integer id;

    public categoryDatepojo(Integer id, String cat) {
        this.id = id;
        this.cat = cat;
    }

    private String cat;

    @Override
    public String toString() {
        return "categoryDatepojo{" +
                "id=" + id +
                ", cat='" + cat + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }
}