package north.lesson5;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        String password = "123456";
        System.out.println("MD5: " + MD5encryption.MD5(password));
    }
}
