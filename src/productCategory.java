import java.util.ArrayList;

public class productCategory {
    int categoryId;
    String categoryName;
    ArrayList<product> products = new ArrayList<>();

    productCategory (int id, String name){
        this.categoryId=id;
        this.categoryName=name;
    }
}
