package com.pojo;

public class Brand {
    private int id;
    private String brandName;
    private String companyName;
    private String description;
    private int ordered;
    private int status;

    public Brand() {
    }

    public Brand(int id, String brandName, String companyName, String description, int ordered, int status) {
        this.id = id;
        this.brandName = brandName;
        this.companyName = companyName;
        this.description = description;
        this.ordered = ordered;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getOrdered() {
        return ordered;
    }

    public void setOrdered(int ordered) {
        this.ordered = ordered;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", brandName='" + brandName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", description='" + description + '\'' +
                ", ordered=" + ordered +
                ", status=" + status +
                '}';
    }
}
