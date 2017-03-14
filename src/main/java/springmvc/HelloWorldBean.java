package springmvc;

public class HelloWorldBean {
	private String hello;

	public String getHello() {
		return hello;
	}

	public void setHello(String hello) {
		this.hello = hello;
	}
	
	public void show(){
		System.out.println("message---="+ getHello());
	}

}
