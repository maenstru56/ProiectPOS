package entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "TRANSACTION_TABLE", schema = "DATABASE", catalog = "")
public class TransactionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "TRANSACTION_DATE", nullable = true)
    private Timestamp transactionDate;
    @Basic
    @Column(name = "ID_CASHIER", nullable = false)
    private int idCashier;
    @Basic
    @Column(name = "ID_TYPE", nullable = false)
    private int idType;
    @Basic
    @Column(name = "VALUE", nullable = true, precision = 0)
    private Double value;
    @Basic
    @Column(name = "RENTAL_RETURN_DATE", nullable = true)
    private Timestamp rentalReturnDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Timestamp transactionDate) {
        this.transactionDate = transactionDate;
    }

    public int getIdCashier() {
        return idCashier;
    }

    public void setIdCashier(int idCashier) {
        this.idCashier = idCashier;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Timestamp getRentalReturnDate() {
        return rentalReturnDate;
    }

    public void setRentalReturnDate(Timestamp rentalReturnDate) {
        this.rentalReturnDate = rentalReturnDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransactionEntity that = (TransactionEntity) o;

        if (id != that.id) return false;
        if (idCashier != that.idCashier) return false;
        if (idType != that.idType) return false;
        if (transactionDate != null ? !transactionDate.equals(that.transactionDate) : that.transactionDate != null)
            return false;
        if (value != null ? !value.equals(that.value) : that.value != null) return false;
        if (rentalReturnDate != null ? !rentalReturnDate.equals(that.rentalReturnDate) : that.rentalReturnDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (transactionDate != null ? transactionDate.hashCode() : 0);
        result = 31 * result + idCashier;
        result = 31 * result + idType;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (rentalReturnDate != null ? rentalReturnDate.hashCode() : 0);
        return result;
    }
}
