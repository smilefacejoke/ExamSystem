package java����ҵ;

public abstract class TestSystem {//����������System
		int num1,num2,num3,Tag,stuTag,rightAnswer,stuAnswer;
		String fh1,fh2;

		
		public TestSystem(String a,String b) {
			fh1=a;
			fh2=b;
		}
		
		
		void getquestionNum() {//��ȡ��Ŀ�Ĳ���
			num1=(int)(Math.random()*100);
			num2=(int)(Math.random()*100);
			num3=(int)(Math.random()*100);
		}
		
		void setstuAnswer(int a,int b) {//����ѧ����
			stuAnswer=a;
			stuTag=b;
		}
		
		void setstuAnswer(int a) {
			setstuAnswer(a,0);
		}
		
		String isTrue() {//��֤���Ƿ���ȷ��������Ӧ
			if(stuAnswer==rightAnswer)
				return "����ȷ";
			else
				return "�𰸴���";
		}
		
		public String showquestion() {//�������
			getquestionNum();
			isTrue();
			return num1+fh1+num2+fh2+num3+"=";
		}
		
		public String showrightAnwser() {
			system();
			return "��ȷ����:"+rightAnswer;
		}
		
		
		
		
		//�趨���󷽷��ں����������ʵ��
		public abstract void system();
}
