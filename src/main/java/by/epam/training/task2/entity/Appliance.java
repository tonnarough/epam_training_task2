package by.epam.training.task2.entity;

import java.util.Objects;

public class Appliance {

    private String productName;
    private int id;

    public Appliance() {
    }

    public Appliance(String productName, int id) {
        this.productName = productName;
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appliance that = (Appliance) o;
        return id == that.id && productName.equals(that.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, id);
    }

    @Override
    public String toString() {
        return "Appliances{" +
                "productName='" + productName + '\'' +
                ", id=" + id +
                '}';
    }
}
