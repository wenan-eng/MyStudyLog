package com.wenan.design.factory.simplefactory;

/**
 * 描述：    ProductFactory
 */
public class ProductFactory {

    public Product getProduct(String productType) {
        if (productType == null) {
            return null;
        }

        if (productType.equals("Apple")) {
            return new Apple();
        } else if (productType.equals("HuaWei")) {
            return new HuaWei();
        }
        return null;
    }

    public static void main(String[] args) {
        ProductFactory productFactory = new ProductFactory();

        Product apple = productFactory.getProduct("Apple");
        Product huaWei = productFactory.getProduct("HuaWei");

        apple.create();
        huaWei.create();

    }
}
