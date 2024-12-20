package com.example.ConsoleApp;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "transactions")
@Table(name = "transactions")
public class Transaction {

    @Id
    @SequenceGenerator(
            name = "transaction_sequence",
            sequenceName = "transaction_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "transaction_sequence"
    )
    @Column(
            name="id",
            updatable = false
    )
    private Long id;
    @Column(
            name="customer_id"
    )
    private Integer customer_id;
    @Column(
            name="tr_datetime"
    )
    private String tr_datetime;
    @Column(
            name="mcc_code"
    )
    private Integer mcc_code;
    @Column(
            name="tr_type"
    )
    private Integer tr_type;
    @Column(
            name="amount"
    )

    private Double amount;
    @Column(
            name="term_id"
    )
    private Integer term_id;

    public Transaction(Integer customer_id,
                       String tr_datetime,
                       Integer mcc_code,
                       Integer tr_type,
                       Double amount,
                       Integer term_id) {
        this.customer_id = customer_id;
        this.tr_datetime = tr_datetime;
        this.mcc_code = mcc_code;
        this.tr_type = tr_type;
        this.amount = amount;
        this.term_id = term_id;
    }

    public Transaction() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public String getTr_datetime() {
        return tr_datetime;
    }

    public void setTr_datetime(String tr_datetime) {
        this.tr_datetime = tr_datetime;
    }

    public Integer getMcc_code() {
        return mcc_code;
    }

    public void setMcc_code(Integer mcc_code) {
        this.mcc_code = mcc_code;
    }

    public Integer getTr_type() {
        return tr_type;
    }

    public void setTr_type(Integer tr_type) { this.tr_type = tr_type; }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getTerm_id() {
        return term_id;
    }

    public void setTerm_id(Integer term_id) {
        this.term_id = term_id;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", customer_id=" + customer_id +
                ", tr_datetime=" + tr_datetime +
                ", mcc_code=" + mcc_code +
                ", amount=" + amount +
                ", term_id=" + term_id +
                '}';
    }
}
