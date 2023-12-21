import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class normal extends customer{
    int status;

    public normal (String name, String password, int status){
        super(name,password);
        this.status=status;
    }
}
