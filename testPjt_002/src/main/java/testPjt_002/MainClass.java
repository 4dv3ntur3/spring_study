package testPjt_002;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// applicationContext.xml에서 명시해줬으므로 필요 없음
		// 스프링에서도 이렇게 해도 되긴 함
//		TransportationWalk transportationWalk = new TransportationWalk();
//		transportationWalk.move();
		
		// 스프링 프로젝트와 자바 프로젝트의 큰 차이점!!! 
		// 리소스를 이용해서 객체 생성 
		// xml에서 객체로 메모리 로딩을 해 놨음
		// 스프링 컨테이너에 먼저 접근
		// context.xml에 접근하기 위한 자료형
		// GenericApplicationContext 밑의
		// xml 파일을 로딩하는 자식 클래스
		// classpath: 파일 이름
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		// 컨테이너에 있는 bean
		// id로. 반환형은 당연히 이 클래스
		// 실제 객체를 가져온 부분 
		// 앞뒤로 로그들이 좀 추가됨 (빨간 글씨)
		// 객체 생성 처리 등 
		// spring은 디렉토리 구조, 프로젝트 구조를 잘 이해하면 됨
		TransportationWalk transportwalk = ctx.getBean("tWalk", TransportationWalk.class);
		transportwalk.move();
		
		// 리소스 사용했으니 닫는다
		ctx.close();
		

	}

}
