package java大作业;

public class Jianfajiafa extends TestSystem{
	
	public Jianfajiafa() {
		super("-","+");
	}

	@Override
	public void system() {
		// TODO 自动生成的方法存根
		rightAnswer=num1-num2+num3;
	}

	void getquestionNum() {
		super.getquestionNum();
		if((num1-num2+num3)<0)
			this.getquestionNum();//对覆盖方法防止出现负数
	}

}
