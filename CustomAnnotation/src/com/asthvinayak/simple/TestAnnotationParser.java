package com.asthvinayak.simple;
//TestAnnotationParser.java
import  java.lang.reflect.Method;
public class TestAnnotationParser 
{
    public void parse(Class clazz) throws Exception 
	{
        Method[ ] methods = clazz.getMethods();
	    for (Method method : methods) 
		{
			if (method.isAnnotationPresent(Test.class)) 
			{
				Test test = method.getAnnotation(Test.class);
	            String info = test.info();
				int version=test.version();
	            if ("AWESOME".equals(info) && version==2) 
				{
					 System.out.println("info is awesome!");
					 System.out.println("Version is : "+version);
	            }
				else
				{
					System.out.println("info and version are not good");
				}
		    }
		}
	}
}