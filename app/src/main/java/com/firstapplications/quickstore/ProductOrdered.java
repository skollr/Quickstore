package com.firstapplications.quickstore;

public class ProductOrdered
{
    private String productName;
    private int quantityOrdered;

    public ProductOrdered(String productName, int quantityOrdered)
    {
        this.productName = productName;
        this.quantityOrdered = quantityOrdered;
    }

    public String getProductName()
    {
        return productName;
    }

    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    public int getQuantityOrdered()
    {
        return quantityOrdered;
    }

    public void setQuantityOrdered(int quantityOrdered)
    {
        this.quantityOrdered = quantityOrdered;
    }

    @Override
    public String toString()
    {
        return "Order{" +
                "productName='" + productName + '\'' +
                '}';
    }
}
