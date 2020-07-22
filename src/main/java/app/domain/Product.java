package app.domain;


import java.time.LocalDate;

public class Product {
    //Field

    private int id;
    private String name;
    private String description;
    private LocalDate createDate;
    private int place_storage;
    private boolean reserved;

    //Constructor
    public Product() {
    }

    public Product(String name, String description, LocalDate createDate, int place_storage, boolean reserved) {
        this.name = name;
        this.description = description;
        this.createDate = createDate;
        this.place_storage = place_storage;
        this.reserved = reserved;
    }

    public Product(int id, String name, String description, LocalDate createDate, int place_storage, boolean reserved) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createDate = createDate;
        this.place_storage = place_storage;
        this.reserved = reserved;
    }

    //Function

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", createDate=" + createDate +
                ", place_storage=" + place_storage +
                ", reserved=" + reserved +
                '}';
    }


    //Getter and Setter

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public int getPlace_storage() {
        return place_storage;
    }

    public void setPlace_storage(int place_storage) {
        this.place_storage = place_storage;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }
}
