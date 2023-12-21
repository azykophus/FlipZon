import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.lang.Math;

public class customer {
    String customerName;
    String status;
    String customerPassword;
    float walletBalance = 1000;

    Random rand = new Random();
    int delivery= rand.nextInt(7,11);

    float deliveryCharge = 100 + (5/100)*cartTotal();

    ArrayList<product> cart = new ArrayList<>();

    customer (String name, String pass){
        this.customerName=name;
        this.customerPassword=pass;
    }

    void addtoCart(product prod){
        cart.add(prod);
    }
    float cartTotal(){
        float total = 0;

        try {
            for (int i=0; i<cart.size(); i++){
                total = total + (cart.get(i).discountedPrice*cart.get(i).quantityinCart);
            }
        }catch (Exception e){
            System.out.println("");
        }
        return total;
    }



    ArrayList<Integer> coupons = new ArrayList<Integer>();

    //For elite
    Random rando = new Random();
    int deliveryElite= 2;

    int couponsNumberElite=rando.nextInt(3,5);

    void couponGeneratorElite(){
        for (int i=0; i<couponsNumberElite; i++){
            int couponValueElite = rando.nextInt(5,16);
            coupons.add(couponValueElite);
        }
    }

    int maxCouponValue(){
        int max=0;
        for (int i=0; i<coupons.size(); i++){
            if (max<coupons.get(i)){
                max=coupons.get(i);
            }
        }
        return max;
    }

    void useCoupon(int value){
        coupons.remove(value);
    }

    float deliveryChargeElite = 100;

    float max (int a, int b, int c){
        return Math.max(Math.max(a,b),c);
    }

    //For prime
    Random randp = new Random();
    int deliveryPrime= randp.nextInt(3,7);


    int couponsNumberPrime=randp.nextInt(1,3);

    void couponGeneratorPrime(){
        for (int i=0; i<couponsNumberPrime; i++){
            int couponValuePrime = randp.nextInt(5,16);
            coupons.add(couponValuePrime);
        }
    }

    float deliveryChargePrime = 100 + (2/100)*cartTotal();


}
