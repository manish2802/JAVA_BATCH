
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import com.asthvinayak.annotation.ManishInfo;
import com.asthvinayak.annotation.MethodAnnotation;

public class TestAnnotation {

	public static void main(String[] args) {
		

		Class<MethodAnnotation> obj = MethodAnnotation.class;

		System.out.println(obj.getName());
		System.out.println(obj.getClassLoader());
		System.out.println(obj.getFields());

		Method[] methods = obj.getMethods();

		// Process @ManishInfo

		if (methods.length > 0) {
			if (methods[0].isAnnotationPresent(ManishInfo.class)) {

				Annotation annotation = methods[0].getAnnotation(ManishInfo.class);
				ManishInfo ManisherInfo = (ManishInfo) annotation;

				System.out.printf("%nPriority :%s", ManisherInfo.priority());
				System.out.printf("%nCreatedBy :%s", ManisherInfo.createdBy());
				System.out.printf("%nTags :");

				int tagLength = ManisherInfo.tags().length;
				for (String tag : ManisherInfo.tags()) {
					if (tagLength > 1) {
						System.out.print(tag + ", ");
					} else {
						System.out.print(tag);
					}
					tagLength--;
				}

				System.out.printf("%nLastModified :%s%n%n", ManisherInfo.lastModified());

			}

		}

	}

}
