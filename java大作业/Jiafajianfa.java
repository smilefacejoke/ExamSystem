package java����ҵ;

public class Jiafajianfa extends TestSystem {
	
	public Jiafajianfa() {
		super("+","-");
	}

	public void system() {
		// TODO �Զ����ɵķ������
		rightAnswer=num1+num2-num3;
	}
	
	void getquestionNum() {
		super.getquestionNum();
		if((num1+num2-num3)<0)
			this.getquestionNum();//�Ը��Ƿ�����ֹ���ָ���
	}
	
}
