import com.asthvinayak.simple.Annotated;
import com.asthvinayak.simple.TestAnnotationParser;
//Main.java
public class Main
{
    public static void main(String[] args) throws Exception 
	{
        TestAnnotationParser parser = new TestAnnotationParser();
        parser.parse(Annotated.class);
    }
}