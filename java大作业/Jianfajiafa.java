package java����ҵ;

public class Jianfajiafa extends TestSystem{
	
	public Jianfajiafa() {
		super("-","+");
	}

	@Override
	public void system() {
		// TODO �Զ����ɵķ������
		rightAnswer=num1-num2+num3;
	}

	void getquestionNum() {
		super.getquestionNum();
		if((num1-num2+num3)<0)
			this.getquestionNum();//�Ը��Ƿ�����ֹ���ָ���
	}

}
