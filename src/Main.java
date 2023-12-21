import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Math;


public class Main {
    public static void main(String[] args) {
        ArrayList<productCategory> categories = new ArrayList<>();
        ArrayList<customer> customers = new ArrayList<>();

        Scanner scs = new Scanner(System.in);
        String user = "Abhijay Singh";
        String pswd = "@";
        System.out.println("""
                
                ░█   █ █▀▀ █   █▀▀ █▀▀█ █▀▄▀█ █▀▀ 　 ▀▀█▀▀ █▀▀█ 　 ░█▀▀▀ ░█    ▀█▀ ░█▀▀█ ░█▀▀▀█ ░█▀▀▀█ ░█▄ ░█\s
                ░█░█░█ █▀▀ █   █   █  █ █ ▀ █ █▀▀ 　   █   █  █ 　 ░█▀▀▀ ░█    ░█  ░█▄▄█  ▄▄▄▀▀ ░█   █ ░█░█░█\s
                ░█▄▀▄█ ▀▀▀ ▀▀▀ ▀▀▀ ▀▀▀▀ ▀   ▀ ▀▀▀ 　   ▀   ▀▀▀▀ 　 ░█    ░█▄▄█ ▄█▄ ░█    ░█▄▄▄█ ░█▄▄▄█ ░█  ▀█""");



        while (true){
            System.out.println("""
                    1) Enter as Admin
                    2) Explore the Product Catalog
                    3) Show Available Deals
                    4) Enter as Customer
                    5) Exit the Application""");
            int welcome = scs.nextInt();

            //Admin
            if (welcome==1){
                System.out.println("""
                        Dear Admin,
                        Please enter your username and password""");

                while (true){
                    System.out.print("Username : ");
                    Scanner scos=new Scanner(System.in);
                    String username = scos.nextLine();
                    System.out.print("Password : ");
                    String password = scos.next();

                    if (password.equals(pswd)){
                        System.out.println("Credentials Verified!");
                        System.out.println("Logging in......");
                        System.out.println("");
                        System.out.println("Welcome Abhijay!");
                        break;
                    }
                    else{
                        System.out.println("Incorrect username or password! Enter again :(");
                    }
                }
                while (true){
                    System.out.println("""
                            Please choose any one of the following actions:
                            1) Add category
                            2) Delete category
                            3) Add Product
                            4) Delete Product
                            5) Set Discount on Product
                            6) Add giveaway deal
                            7) Back""");
                    int adminOptions = scs.nextInt();
                    if (adminOptions==1){
                        Scanner scps=new Scanner(System.in);
                        System.out.print("Add category ID: ");
                        int catId = scps.nextInt();
                        System.out.print("Add name of the category: ");
                        String catName = scps.nextLine();
                        scps.nextLine();
                        productCategory q = new productCategory(catId, catName);
                        categories.add(q);
                        System.out.println("Category added successfully!");
                    }
                    else if (adminOptions==2){
                        System.out.print("Enter ID of category to be removed: ");
                        int catdelete = scs.nextInt();
                        for (int i=0; i<categories.size(); i++){
                            if (categories.get(i).categoryId==catdelete){
                                categories.remove(categories.get(i));
                                System.out.println("Category removed successfully");
                            }
                        }
                    }
                    else if (adminOptions==3){
                        System.out.print("Enter Category ID: ");
                        int prodcatId = scs.nextInt();
                        for (int j=0; j<categories.size(); j++){
                            if (categories.get(j).categoryId==prodcatId){
                                Scanner scsz=new Scanner(System.in);
                                System.out.print("Product Name: ");
                                String prodName = scsz.nextLine();
                                System.out.print("Product ID: ");
                                float prodID = scsz.nextFloat();
                                System.out.print("Price: ");
                                int price = scsz.nextInt();
                                System.out.print("Quantity: ");
                                int quantity = scsz.nextInt();
                                System.out.print("Product Details: ");
                                Scanner scsg=new Scanner(System.in);
                                String details = scsg.nextLine();
                                product k = new product(prodID, prodName, price, quantity, details);
                                categories.get(j).products.add(k);
                                System.out.println("Product added successfully!");
                            }
                        }
                    }
                    else if (adminOptions==4){
                        System.out.print("Enter Category ID: ");
                        int prodcatId = scs.nextInt();
                        for (int j=0; j<categories.size(); j++){
                            if (categories.get(j).categoryId==prodcatId){
                                System.out.print("ID of Product to be deleted: ");
                                float prodiddelete = scs.nextFloat();
                                for (int i =0; i<categories.get(j).products.size(); i++){
                                    if (categories.get(j).products.get(i).productId==prodiddelete){
                                        categories.get(j).products.remove(i);
                                        System.out.println("Product removed successfully!");
                                    }
                                }
                            }
                        }
                    }
                    else if (adminOptions==5){
                        System.out.print("Enter category id: ");
                        int num = scs.nextInt();
                        System.out.print("Dear Admin give the Product ID you want to add discount for: ");
                        float prodidfordiscount = scs.nextFloat();
                        for (int i=0; i<categories.size(); i++){
                            if (categories.get(i).categoryId==num){
                                for (int j=0; j<categories.get(i).products.size();j++){
                                    if (categories.get(i).products.get(j).productId==prodidfordiscount){
                                        System.out.println("Enter discount for Elite, Prime and Normal customers respectively (in % terms): ");
                                        System.out.print("Elite: ");
                                        int discountElite = scs.nextInt();
                                        System.out.print("Prime: ");
                                        int discountPrime = scs.nextInt();
                                        System.out.print("Normal: ");
                                        int discountNormal = scs.nextInt();
                                        categories.get(i).products.get(j).discPrime=discountPrime;
                                        categories.get(i).products.get(j).discELite=discountElite;
                                        categories.get(i).products.get(j).discNormal=discountNormal;
                                    }
                                }
                            }
                        }
                    }
                    else if (adminOptions==6){

                    }
                    else if (adminOptions==7){
                        break;
                    }
                }
            }
            //Explore Product Catalog
            if (welcome==2){
                for (int i=0; i<categories.size(); i++){
                    System.out.println("Category "+categories.get(i).categoryName);
                    for (int j=0; j<categories.get(i).products.size();j++){
                        System.out.println("Name: "+categories.get(i).products.get(j).productName);
                        System.out.println("Product ID: "+categories.get(i).products.get(j).productId);
                        System.out.println("Price: "+categories.get(i).products.get(j).price);
                        System.out.println("Details: "+categories.get(i).products.get(j).details);
                        System.out.println("Quantity: "+categories.get(i).products.get(j).quantity);
                        System.out.println("");
                    }
                    System.out.println("---------");
                }
            }
            //Show available deals
            if (welcome==3){

            }
            //Enter as Customer
            if (welcome==4){
                while(true){
                    System.out.println("""
                            1) Sign up
                            2) Log in
                            3) Back""");
                    int cusOption = scs.nextInt();
                    if (cusOption==1){
                        Scanner so=new Scanner(System.in);
                        System.out.print("Enter Customer name: ");
                        String cusName = so.nextLine();
                        System.out.print("Create a password: ");
                        String cusPswd = so.next();

                        customer n = new customer(cusName, cusPswd);
                        n.status="Normal";
                        customers.add(n);
                        System.out.println("Customer registered Successfully!");
                    }
                    else if(cusOption==2){
                        int count = 0;
                        while (true){
                            System.out.print("Enter name: ");
                            String loginname = scs.nextLine();
                            scs.nextLine();
                            System.out.print("Enter password: ");
                            String loginpass = scs.next();
                            for (int i=0;i<customers.size();i++){
                                if (customers.get(i).customerPassword.equals(loginpass)){
                                    System.out.println("Welcome "+customers.get(i).customerName);
                                    count=count+i+1;
                                }
                                else{
                                    System.out.println("Incorrect username or password!");
                                }
                            }
                            if (count!=0){
                                break;
                            }
                        }

                        while (true){
                            System.out.println("""
                                    1) browse products
                                    2) browse deals
                                    3) add a product to cart
                                    4) add products in deal to cart
                                    5) view coupons
                                    6) check account balance
                                    7) view cart
                                    8) empty cart
                                    9) checkout cart
                                    10) upgrade customer status
                                    11) Add amount to wallet
                                    12) back""");
                            int custloginoptions = scs.nextInt();
                            if (custloginoptions==1){
                                for (int i=0; i<categories.size(); i++){
                                    System.out.println("Category "+categories.get(i).categoryName);
                                    for (int j=0; j<categories.get(i).products.size();j++){
                                        System.out.println("Name: "+categories.get(i).products.get(j).productName);
                                        System.out.println("Product ID: "+categories.get(i).products.get(j).productId);
                                        System.out.println("Price: "+categories.get(i).products.get(j).price);
                                        System.out.println("Details: "+categories.get(i).products.get(j).details);
                                        System.out.println("Quantity: "+categories.get(i).products.get(j).quantity);
                                        System.out.println("");
                                    }
                                    System.out.println("---------");
                                }
                            }
                            else if (custloginoptions==2){

                            }
                            else if (custloginoptions==3){
                                System.out.print("Enter product ID of the product to be added to the cart: ");
                                float proId = scs.nextFloat();
                                System.out.print("Enter product quantity: ");
                                int quan = scs.nextInt();
                                for (int i=0; i<categories.size(); i++){
                                    for (int j=0; j<categories.get(i).products.size(); j++){
                                        if (categories.get(i).products.get(j).productId==proId){
                                            if (categories.get(i).products.get(j).quantity<=0){
                                                System.out.println("Not enough Quantity");
                                                break;
                                            }
                                            customers.get(count-1).cart.add(categories.get(i).products.get(j));
                                            categories.get(i).products.get(j).quantity=categories.get(i).products.get(j).quantity-quan;
                                            categories.get(i).products.get(j).quantityinCart=categories.get(i).products.get(j).quantityinCart+quan;
                                        }
                                    }
                                }

                            }
                            else if (custloginoptions==4){

                            }
                            else if (custloginoptions==5){
                                if (customers.get(count-1).status=="Normal"){
                                    System.out.println("No coupons Available");
                                }
                                else{
                                    System.out.print("Coupons available are: ");
                                    for (int i=0; i<customers.get(count-1).coupons.size(); i++){
                                        System.out.print(customers.get(count-1).coupons.get(i)+"% ");
                                    }
                                    System.out.println("");
                                }
                            }
                            else if (custloginoptions==6){
                                System.out.println("Account balance is: INR "+customers.get(count-1).walletBalance);
                            }
                            else if (custloginoptions==7){
                                System.out.println("Cart details: ");
                                for (int i=0; i<customers.get(count-1).cart.size(); i++){
                                    System.out.println("Item number "+(i+1));
                                    System.out.println("Name: "+customers.get(count-1).cart.get(i).productName);
                                    System.out.println("Product id: "+customers.get(count-1).cart.get(i).productId);
                                    System.out.println("Price: "+customers.get(count-1).cart.get(i).price);
                                    System.out.println("Details: "+customers.get(count-1).cart.get(i).details);
                                    System.out.println("");

                                }
                            }
                            else if (custloginoptions==8){
                                customers.get(count-1).cart.clear();
                            }
                            else if (custloginoptions==9){

                                for (int i=0; i<customers.get(count-1).cart.size(); i++){

                                    if (customers.get(count-1).status.equals("Elite")){
                                        float pop = ((customers.get(count-1).max(10,customers.get(count-1).maxCouponValue(),customers.get(count-1).cart.get(i).discELite))/100)*customers.get(count-1).cart.get(i).price;
                                        System.out.println(pop);
                                        customers.get(count-1).cart.get(i).discountedPrice= (customers.get(count-1).cart.get(i).price)-pop;
                                        if (customers.get(count-1).max(10,customers.get(count-1).maxCouponValue(),customers.get(count-1).cart.get(i).discELite)==customers.get(count-1).maxCouponValue()){
                                            customers.get(count-1).useCoupon(customers.get(count-1).maxCouponValue());
                                        }
                                    }
                                    else if (customers.get(count-1).status.equals("Prime")){
                                        customers.get(count-1).cart.get(i).discountedPrice= customers.get(count-1).cart.get(i).price-((customers.get(count-1).max(5,customers.get(count-1).maxCouponValue(),customers.get(count-1).cart.get(i).discPrime))/100)*customers.get(count-1).cart.get(i).price;
                                        if (customers.get(count-1).max(5,customers.get(count-1).maxCouponValue(),customers.get(count-1).cart.get(i).discPrime)==customers.get(count-1).maxCouponValue()){
                                            customers.get(count-1).useCoupon(customers.get(count-1).maxCouponValue());
                                        }
                                    }
                                    else if (customers.get(count-1).status.equals("Normal")){
                                        customers.get(count-1).cart.get(i).discountedPrice= customers.get(count-1).cart.get(i).price-((customers.get(count-1).cart.get(i).discNormal)/100)*customers.get(count-1).cart.get(i).price;

                                    }
                                }
                                System.out.println("Proceding to checkout...");
                                System.out.println("Cart details: ");
                                for (int i=0; i<customers.get(count-1).cart.size(); i++){
                                    System.out.println("Item number "+(i+1));
                                    System.out.println("Product name: "+customers.get(count-1).cart.get(i).productName);
                                    System.out.println("Product id: "+customers.get(count-1).cart.get(i).productId);
                                    System.out.println("Price: "+customers.get(count-1).cart.get(i).price);
                                    System.out.println("Discounted price: "+customers.get(count-1).cart.get(i).discountedPrice);
                                    System.out.println("Details: "+customers.get(count-1).cart.get(i).details);
                                    System.out.println("");
                                }
                                System.out.print("Order Total: INR ");
                                System.out.println(customers.get(count-1).cartTotal());
                                System.out.print("Delivery Charge: INR ");
                                float grandTotal = 0;
                                if (customers.get(count-1).status=="Elite"){
                                    System.out.println(customers.get(count-1).deliveryChargeElite);
                                    System.out.print("Grand Total: INR ");
                                    grandTotal = customers.get(count-1).cartTotal()+customers.get(count-1).deliveryChargeElite;
                                    System.out.println(grandTotal);
                                }
                                else if (customers.get(count-1).status=="Prime"){
                                    System.out.println(customers.get(count-1).deliveryChargePrime);
                                    System.out.print("Grand Total: INR ");
                                    grandTotal = customers.get(count-1).cartTotal()+customers.get(count-1).deliveryChargePrime;
                                    System.out.println(grandTotal);
                                }
                                else if (customers.get(count-1).status=="Normal"){
                                    System.out.println(customers.get(count-1).deliveryCharge);
                                    System.out.print("Grand Total: INR ");
                                    grandTotal = customers.get(count-1).cartTotal()+customers.get(count-1).deliveryCharge;
                                    System.out.println(grandTotal);
                                }
                                if (customers.get(count-1).walletBalance>grandTotal){
                                    System.out.println("Order Placed Successfully!");
                                    System.out.print("Your order will be delivered in ");
                                    if (customers.get(count-1).status.equals("Elite")){
                                        System.out.println(customers.get(count-1).deliveryElite+" Business days");
                                        if (grandTotal>5000){
                                            customers.get(count-1).couponGeneratorElite();
                                            System.out.println("Congratulations you have recieved "+customers.get(count-1).couponsNumberElite+" Coupons");
                                        }
                                    }
                                    else if (customers.get(count-1).status.equals("Prime")){
                                        System.out.println(customers.get(count-1).deliveryPrime+" Business days");
                                        if (grandTotal>5000){
                                            customers.get(count-1).couponGeneratorPrime();
                                            System.out.println("Congratulations you have recieved "+customers.get(count-1).couponsNumberPrime+" Coupons");
                                        }
                                    }
                                    else if (customers.get(count-1).status.equals("Normal")){
                                        System.out.println(customers.get(count-1).delivery+" Business days");
                                    }
                                    customers.get(count-1).walletBalance=customers.get(count-1).walletBalance-grandTotal;
                                    customers.get(count-1).cart.clear();
                                }
                                else{
                                    System.out.println("Insufficient Wallet Balance");
                                    break;
                                }



                            }
                            else if (custloginoptions==10){
                                System.out.println("Current Status: "+customers.get(count-1).status);
                                System.out.print("Enter new status: ");
                                String status = scs.next();
                                if (status.equals("Elite")){
                                    customers.get(count-1).walletBalance=customers.get(count-1).walletBalance-300;
                                    customers.get(count-1).status="Elite";
                                }
                                else if (status.equals("Prime")){
                                    customers.get(count-1).walletBalance=customers.get(count-1).walletBalance-200;
                                    customers.get(count-1).status="Prime";
                                }
                            }
                            else if (custloginoptions==11){
                                System.out.print("Amount to be added: ");
                                int money = scs.nextInt();
                                customers.get(count-1).walletBalance = customers.get(count-1).walletBalance + money;
                                System.out.println("Money added successfully!");
                            }
                            else if (custloginoptions==12){
                                break;
                            }
                        }

                    }
                    else if (cusOption==3){
                        break;
                    }
                }
            }
            //Exit the Application
            if (welcome==5){
                System.out.println("""
                        🅃🄷🄰🄽🄺 🅈🄾🅄 🄵🄾🅁 🅅🄸🅂🄸🅃🄽🄶 🄵🄻🄸🄿🅉🄾🄽""");
                break;
            }
        }
    }
}
