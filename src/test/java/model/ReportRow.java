package model;

import java.util.Objects;

public class ReportRow {

    private String id;
    private String product;
    private String totalCost;

    public ReportRow() {
    }

    public ReportRow(String id, String product, String totalCost) {
        this.id = id;
        this.product = product;
        this.totalCost = totalCost;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(String totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return "ReportRow {" +
                "id='" + id + '\'' +
                ", product='" + product + '\'' +
                ", totalCost='" + totalCost + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReportRow reportRow = (ReportRow) o;
        return id.equals(reportRow.id) &&
                product.equals(reportRow.product) &&
                totalCost.equals(reportRow.totalCost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product, totalCost);
    }
}
