package fr.epita.bank.datamodel;

public class StockOrder {
    Double unitPrice;
    Integer quantity;
    Double commission;
    InvestmentAccount account;
    Stock stock;


    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getCommission() {
        return commission;
    }

    public void setCommission(Double commission) {
        this.commission = commission;
    }

    public InvestmentAccount getAccount() {
        return account;
    }

    public void setAccount(InvestmentAccount account) {
        this.account = account;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
}
