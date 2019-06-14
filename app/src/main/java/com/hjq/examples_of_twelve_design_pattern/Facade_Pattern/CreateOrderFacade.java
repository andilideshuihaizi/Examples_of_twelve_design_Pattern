package com.hjq.examples_of_twelve_design_pattern.Facade_Pattern;

/**
 * 门面类
 */
public class CreateOrderFacade {

    private Product product = new Product();
    private Price price = new Price();
    private ShippingAddress shippingAddress = new ShippingAddress();

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String creatOrder(String product ,String user){
        boolean ret = this.product.checkStock(product,10);
        double ret2 = this.price.getPrice(product);
        String ret3 = shippingAddress.getShippingAddress(user);

        return ret ? "不必采购："+product : "采购："+product+ (ret2!=-1?",每斤采购价："+Double.toString(ret2)+",送到客户"+user+",地址是："+ret3 :",该商品未知采购价");
    }
}
