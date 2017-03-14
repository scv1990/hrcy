package springmvc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class HelloWorld {

	public static void main(String[] args) {
		ApplicationContext ctx = new FileSystemXmlApplicationContext("src/helloworld.xml");
		HelloWorldBean bean = (HelloWorldBean)ctx.getBean("myHelloWorld");
		bean.show();
	}

}
