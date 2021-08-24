# Cloud db java wrapper

example:

```java
import com.wayv.cloud.db.APIBuilder;

public class Main {
    
    public static void main(String[] args) {
           APIBuilder db = new APIBuilder("key");
           db.editOrCreate("hello", "world");
           
    }
}
