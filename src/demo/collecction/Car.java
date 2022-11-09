package demo.collecction;

public class Car {
    private String brand;
    private Integer producedYear;

    public Car() {
    }

    public Car(String brand, Integer producedYear) {
        this.brand = brand;
        this.producedYear = producedYear;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getProducedYear() {
        return producedYear;
    }

    public void setProducedYear(Integer producedYear) {
        this.producedYear = producedYear;
    }
}
