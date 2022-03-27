package testPjt_003;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		TransportationWalk twalk = ctx.getBean("tWalk", TransportationWalk.class);
		twalk.move();
		
		ctx.close();
	}

}
