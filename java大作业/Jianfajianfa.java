package java����ҵ;

public class Jianfajianfa extends TestSystem{

	public Jianfajianfa() {
		super("-","-");
	}
	
	
	@Override
	void getquestionNum() {
		super.getquestionNum();
		if((num1-num2-num3)<0)
			this.getquestionNum();//�Ը��Ƿ�����ֹ���ָ���
	}
	@Override
	public void system() {
		// TODO �Զ����ɵķ������
		rightAnswer=num1-num2-num3;
	}


}
