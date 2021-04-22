package board_proj;

public class TestMain {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		//패키지 정보(경로)
		String className = "board_proj.Sum";
		
		//패키지 정보이용
		//?의 의미 아무거나 다 받겠다(오브젝트와 같다)
		Class<?> cls = Class.forName(className);//JVM board_proj.sum 클래스 로드
		
		//패키지 정보만 넣어주면 그걸로 생성가능
		Sum s = (Sum) cls.newInstance(); // 요것도 생성자
		s.add(5, 3);
	}
}
