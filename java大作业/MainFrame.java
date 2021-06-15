package java大作业;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sun.corba.se.spi.orb.Operation;

public class MainFrame extends JFrame {
	

	
	static JFrame title=new JFrame("广州市X小学数学考试自动系统");
	static JFrame test=new JFrame("考试窗口");
	
	//创建面板容器
	static CardLayout cd1=new CardLayout(4,4);//创建卡片布局界面
	static JPanel time=new JPanel();
	static JPanel maincard=new JPanel(cd1);
	static JPanel jpa=new JPanel();
	static JPanel jpa1=new JPanel();
	static JPanel jpa2=new JPanel();
	static JPanel jpa3=new JPanel();
	static JPanel jpa4=new JPanel();
	static JPanel jpa5=new JPanel();
	static JPanel jpa6=new JPanel();
	
	//创建按钮
	static JButton home=new JButton("首页");
	static JButton last=new JButton("尾页");
	static JButton pageback=new JButton("上一页");
	static JButton pagenext=new JButton("下一页");
	static JButton start=new JButton("开始答题");
	static JButton end=new JButton("交卷");
	
	//创建文字标签
	static JLabel name=new JLabel("姓名：");
	static JLabel youclass=new JLabel("班级：");
	static JLabel grade=new JLabel("年级:");
	static JLabel timeleft=new JLabel("考试时间:");
	static JLabel[] question=new JLabel[50];
	static JLabel[] right_answer=new JLabel[50];
	static JLabel[] showistrue=new JLabel[50];
	
	//创建文本框
	static JTextField tname=new JTextField("",15);
	static JTextField tyouclass=new JTextField("",15);
	static JTextField tgrade=new JTextField("",15);
	static JTextField ttime=new JTextField(4);
	static JTextField[] tanswer=new JTextField[50];
	
	//定义字体
	static Font label=new Font("宋体",Font.PLAIN,18);
	static Font jtf=new Font("宋体",Font.BOLD,18);
	static Font jlb=new Font("宋体",Font.PLAIN,18);
	
	//答题反应设置
	TestSystem[] questions=new TestSystem[50];
	int[] stuanswer=new int[50];//创建容放学生50个答案的整形数组
	int score;//学生成绩
	Counttime t=new Counttime();
	
	//创建counttime类进行计算考试时间
	class Counttime extends Thread{//线程类，它实现了Runnable接口
		public boolean flag;
		
		public void run() {
			flag=true;
			int i=5400;//设置考试时间90分钟
			while(i>=0&&flag) {
				ttime.setText(""+i);
				try {
					sleep(1000);//Thread类的sleep方法里的1000为毫秒等于一秒
				}catch(InterruptedException e) {
					JFrame q=new JFrame();
					JOptionPane.showMessageDialog(q,"程序出现问题，请重启");//JOptionPane makes it easy to pop up a standard dialog box 
				}
				i--;
			}
			for(int j=0;j<50;j++) {
				if(tanswer[j].getText().equals("")) {
					tanswer[j].setText("未填");//时间到了
				}
			}
			showAnswer();//时间到展示答案
			JOptionPane.showMessageDialog(test, "成绩是"+score);
			
		}
	}

	
	public MainFrame() {
		//主框架属性设置
		title.setSize(700,150);
		title.setLocationRelativeTo(null);//让窗口在屏幕中央显示
		title.setLayout(new FlowLayout());//设定布局
		
		//首页设计
		tname.setText("");
		tyouclass.setText("");
		tgrade.setText("");
		//面板添加组件
		jpa1.add(name);
		jpa1.add(tname);
		jpa1.add(youclass);
		jpa1.add(tyouclass);
		jpa1.add(grade);
		jpa1.add(tgrade);
		jpa1.add(start);
		title.add(jpa1);
		
		//第二界面设计：答题界面设计
		pageback.setMargin(new Insets(2,2,2,2));//setMargin方法是设置按钮边框和标签之间的空白
		pagenext.setMargin(new Insets(2,2,2,2));
		home.setMargin(new Insets(2,2,2,2));
		last.setMargin(new Insets(2,2,2,2));
				//设定字体
		timeleft.setFont(jlb);
		ttime.setFont(jtf);
				//添加组件在显示时间容器内
		time.add(timeleft);
		time.add(ttime);
		
				//第一页题目设置
		for(int i=0;i<10;i++) {
			question[i]=new JLabel("");
			question[i].setFont(jlb);
			tanswer[i]=new JTextField(4);
			tanswer[i].setFont(jtf);
			right_answer[i]=new JLabel("");
			right_answer[i].setFont(jlb);
			showistrue[i]=new JLabel("");
			showistrue[i].setFont(jlb);
				//添加组件
			jpa2.add(question[i]);
			jpa2.add(tanswer[i]);
			jpa2.add(right_answer[i]);
			jpa2.add(showistrue[i]);
		}
				//第二页题目设置
		for(int i=10;i<20;i++) {//注意i的数
			question[i]=new JLabel("");
			question[i].setFont(jlb);
			tanswer[i]=new JTextField(4);
			tanswer[i].setFont(jtf);
			right_answer[i]=new JLabel("");
			right_answer[i].setFont(jlb);
			showistrue[i]=new JLabel("");
			showistrue[i].setFont(jlb);
				//添加组件
			jpa3.add(question[i]);
			jpa3.add(tanswer[i]);
			jpa3.add(right_answer[i]);
			jpa3.add(showistrue[i]);
		}
				//第三页题目设置
		for(int i=20;i<30;i++) {
			question[i]=new JLabel("");
			question[i].setFont(jlb);
			tanswer[i]=new JTextField(4);
			tanswer[i].setFont(jtf);
			right_answer[i]=new JLabel("");
			right_answer[i].setFont(jlb);
			showistrue[i]=new JLabel("");
			showistrue[i].setFont(jlb);
				//添加组件
			jpa4.add(question[i]);
			jpa4.add(tanswer[i]);
			jpa4.add(right_answer[i]);
			jpa4.add(showistrue[i]);
		}
				//第四页
		for(int i=30;i<40;i++) {
			question[i]=new JLabel("");
			question[i].setFont(jlb);
			tanswer[i]=new JTextField(4);
			tanswer[i].setFont(jtf);
			right_answer[i]=new JLabel("");
			right_answer[i].setFont(jlb);
			showistrue[i]=new JLabel("");
			showistrue[i].setFont(jlb);
				//添加组件
			jpa5.add(question[i]);
			jpa5.add(tanswer[i]);
			jpa5.add(right_answer[i]);
			jpa5.add(showistrue[i]);
		}
				//第五页
		for(int i=40;i<50;i++) {
			question[i]=new JLabel("");
			question[i].setFont(jlb);
			tanswer[i]=new JTextField(4);
			tanswer[i].setFont(jtf);
			right_answer[i]=new JLabel("");
			right_answer[i].setFont(jlb);
			showistrue[i]=new JLabel("");
			showistrue[i].setFont(jlb);
				//添加组件
			jpa6.add(question[i]);
			jpa6.add(tanswer[i]);
			jpa6.add(right_answer[i]);
			jpa6.add(showistrue[i]);
		}
		
		//对开始按钮添加监听器
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				//获取学生信息
				String str_name=tname.getText();
				String str_class=tyouclass.getText();
				String str_grade=tgrade.getText();
				
				if(str_name.length()==0)
					JOptionPane.showMessageDialog(title, "错误，姓名为空");
				else if(str_class.length()==0)
					JOptionPane.showMessageDialog(title,"错误，班级为空");
				else if(str_grade.length()==0)
					JOptionPane.showMessageDialog(title,"错误，年级为空");
				else {
					test.setSize(750, 400);
					test.setResizable(false);
					test.setLocationRelativeTo(null);//让窗口在屏幕中央显示
					test.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					test.setVisible(true);
					if(start.getText().equals("开始答题"));{
						start();
						t.start();//开始倒计时
					}
				}
			}
		});
		//对交卷按钮添加监听器
		end.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t.flag=false;//停止counttime类的时间倒计时
			}
		});
		
		//页面切换
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cd1.show(maincard, "p1");
			}
		});
		pagenext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cd1.next(maincard);
			}
		});
		pageback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cd1.previous(maincard);
			}
		});
		last.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cd1.show(maincard, "p5");
			}
		});
		
		
		//添加按钮
		jpa.add(home);
		jpa.add(pagenext);
		jpa.add(pageback);
		jpa.add(last);
		jpa.add(end);
		jpa.add(time);
		//jpa.add(average);
		
		//卡片布局添加页面并设定名称
		maincard.add(jpa2,"p1");
		maincard.add(jpa3,"p2");
		maincard.add(jpa4,"p3");
		maincard.add(jpa5,"p4");
		maincard.add(jpa6,"p5");
		
		//顶层框架添加窗口部件
		title.add(name);
		title.add(tname);
		title.add(youclass);
		title.add(tyouclass);
		title.add(grade);
		title.add(tgrade);
		title.add(start);
		
		test.getContentPane().add(maincard);
		test.getContentPane().add(jpa,BorderLayout.SOUTH);//设定边界布局并放在下面
		
		title.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		title.setVisible(true);
		
	}
	
	public void start() {//显示正确答案，得分和使用的时间，并写入文件
		for(int i=0;i<50;i++) {
			int ch=(int) (Math.random()*4+1);
			switch(ch) {
			case 1:
				questions[i]=new Jiafajiafa();
				question[i].setText(questions[i].showquestion());
				break;
			case 2:
				questions[i]=new Jiafajianfa();
				question[i].setText(questions[i].showquestion());
				break;
			case 3:
				questions[i]=new Jianfajianfa();
				question[i].setText(questions[i].showquestion());
				break;
			case 4:
				questions[i]=new Jianfajianfa();
				question[i].setText(questions[i].showquestion());
				break;
			default:
				JFrame q=new JFrame();
				JOptionPane.showMessageDialog(q, "出现错误，请重新启动程序");
			}
		}
	}
	public void showAnswer() {
		score=100;
		for(int i=0;i<50;i++) {
			try {
				stuanswer[i]=Integer.valueOf(tanswer[i].getText());
			}catch(Exception e) {
				//System.out.println("输入错误");
			}
			questions[i].setstuAnswer(stuanswer[i]);
			right_answer[i].setText(questions[i].showrightAnwser());
			showistrue[i].setText(questions[i].isTrue());
			
			if(showistrue[i].getText().equals("答案错误")) {
				score-=2;
			}
		}
	}
	
	File stuData=new File("学生.txt");{
		if(!(stuData.exists())) {
			try {
				stuData.createNewFile();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		try {
			PrintWriter out=new PrintWriter(new FileWriter(stuData,true));
			String newname=tname.getText();
			String newgrade=tgrade.getText();
			String newclass=tyouclass.getText();
			out.println("姓名:"+newname+" 年级:"+newgrade+"  班级:"+newclass+"  成绩："+score);
			out.close();
		}catch(FileNotFoundException e) {
			System.out.println("文件创建失败");
		}catch(IOException e1) {
			e1.printStackTrace();
		}
	}

	public static void main(String[] args) {
		MainFrame open=new MainFrame();
	}
}


	
	
	
	
	
