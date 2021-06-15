package java大作业;

public abstract class TestSystem {//建立抽象父类System
		int num1,num2,num3,Tag,stuTag,rightAnswer,stuAnswer;
		String fh1,fh2;

		
		public TestSystem(String a,String b) {
			fh1=a;
			fh2=b;
		}
		
		
		void getquestionNum() {//获取题目的参数
			num1=(int)(Math.random()*100);
			num2=(int)(Math.random()*100);
			num3=(int)(Math.random()*100);
		}
		
		void setstuAnswer(int a,int b) {//设置学生答案
			stuAnswer=a;
			stuTag=b;
		}
		
		void setstuAnswer(int a) {
			setstuAnswer(a,0);
		}
		
		String isTrue() {//验证答案是否正确并作出反应
			if(stuAnswer==rightAnswer)
				return "答案正确";
			else
				return "答案错误";
		}
		
		public String showquestion() {//输出问题
			getquestionNum();
			isTrue();
			return num1+fh1+num2+fh2+num3+"=";
		}
		
		public String showrightAnwser() {
			system();
			return "正确答案是:"+rightAnswer;
		}
		
		
		
		
		//设定抽象方法在后面的子类中实现
		public abstract void system();
}
