package entity;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT", schema = "DATABASE", catalog = "")
public class ProductEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "PRODUCT_NAME", nullable = true, length = 30)
    private String productName;
    @Basic
    @Column(name = "ID_CATEGORY", nullable = false)
    private int idCategory;
    @Basic
    @Column(name = "PRICE", nullable = true, precision = 0)
    private Double price;
    @Basic
    @Column(name = "ID_UNIT", nullable = false)
    private int idUnit;
    @Basic
    @Column(name = "IMG_PATH", nullable = true, length = 255)
    private String imgPath;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getIdUnit() {
        return idUnit;
    }

    public void setIdUnit(int idUnit) {
        this.idUnit = idUnit;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductEntity that = (ProductEntity) o;

        if (id != that.id) return false;
        if (idCategory != that.idCategory) return false;
        if (idUnit != that.idUnit) return false;
        if (productName != null ? !productName.equals(that.productName) : that.productName != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (imgPath != null ? !imgPath.equals(that.imgPath) : that.imgPath != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + idCategory;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + idUnit;
        result = 31 * result + (imgPath != null ? imgPath.hashCode() : 0);
        return result;
    }
}
