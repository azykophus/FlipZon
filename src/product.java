public class product {
    float productId;
    String productName;
    int price;
    int quantity;
    String details;
    int discELite;
    int discPrime;
    int discNormal;
    float discountedPrice;
    int quantityinCart;

    product (float productId, String productName, int price, int quantity, String details){
        this.productId=productId;
        this.productName=productName;
        this.price=price;
        this.quantity=quantity;
        this.details=details;
    }
    product (int elite, int prime, int normal){
        this.discNormal=normal;
        this.discELite=elite;
        this.discPrime=prime;
    }

}
