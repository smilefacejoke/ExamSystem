package java����ҵ;

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
	

	
	static JFrame title=new JFrame("������XСѧ��ѧ�����Զ�ϵͳ");
	static JFrame test=new JFrame("���Դ���");
	
	//�����������
	static CardLayout cd1=new CardLayout(4,4);//������Ƭ���ֽ���
	static JPanel time=new JPanel();
	static JPanel maincard=new JPanel(cd1);
	static JPanel jpa=new JPanel();
	static JPanel jpa1=new JPanel();
	static JPanel jpa2=new JPanel();
	static JPanel jpa3=new JPanel();
	static JPanel jpa4=new JPanel();
	static JPanel jpa5=new JPanel();
	static JPanel jpa6=new JPanel();
	
	//������ť
	static JButton home=new JButton("��ҳ");
	static JButton last=new JButton("βҳ");
	static JButton pageback=new JButton("��һҳ");
	static JButton pagenext=new JButton("��һҳ");
	static JButton start=new JButton("��ʼ����");
	static JButton end=new JButton("����");
	
	//�������ֱ�ǩ
	static JLabel name=new JLabel("������");
	static JLabel youclass=new JLabel("�༶��");
	static JLabel grade=new JLabel("�꼶:");
	static JLabel timeleft=new JLabel("����ʱ��:");
	static JLabel[] question=new JLabel[50];
	static JLabel[] right_answer=new JLabel[50];
	static JLabel[] showistrue=new JLabel[50];
	
	//�����ı���
	static JTextField tname=new JTextField("",15);
	static JTextField tyouclass=new JTextField("",15);
	static JTextField tgrade=new JTextField("",15);
	static JTextField ttime=new JTextField(4);
	static JTextField[] tanswer=new JTextField[50];
	
	//��������
	static Font label=new Font("����",Font.PLAIN,18);
	static Font jtf=new Font("����",Font.BOLD,18);
	static Font jlb=new Font("����",Font.PLAIN,18);
	
	//���ⷴӦ����
	TestSystem[] questions=new TestSystem[50];
	int[] stuanswer=new int[50];//�����ݷ�ѧ��50���𰸵���������
	int score;//ѧ���ɼ�
	Counttime t=new Counttime();
	
	//����counttime����м��㿼��ʱ��
	class Counttime extends Thread{//�߳��࣬��ʵ����Runnable�ӿ�
		public boolean flag;
		
		public void run() {
			flag=true;
			int i=5400;//���ÿ���ʱ��90����
			while(i>=0&&flag) {
				ttime.setText(""+i);
				try {
					sleep(1000);//Thread���sleep�������1000Ϊ�������һ��
				}catch(InterruptedException e) {
					JFrame q=new JFrame();
					JOptionPane.showMessageDialog(q,"����������⣬������");//JOptionPane makes it easy to pop up a standard dialog box 
				}
				i--;
			}
			for(int j=0;j<50;j++) {
				if(tanswer[j].getText().equals("")) {
					tanswer[j].setText("δ��");//ʱ�䵽��
				}
			}
			showAnswer();//ʱ�䵽չʾ��
			JOptionPane.showMessageDialog(test, "�ɼ���"+score);
			
		}
	}

	
	public MainFrame() {
		//�������������
		title.setSize(700,150);
		title.setLocationRelativeTo(null);//�ô�������Ļ������ʾ
		title.setLayout(new FlowLayout());//�趨����
		
		//��ҳ���
		tname.setText("");
		tyouclass.setText("");
		tgrade.setText("");
		//���������
		jpa1.add(name);
		jpa1.add(tname);
		jpa1.add(youclass);
		jpa1.add(tyouclass);
		jpa1.add(grade);
		jpa1.add(tgrade);
		jpa1.add(start);
		title.add(jpa1);
		
		//�ڶ�������ƣ�����������
		pageback.setMargin(new Insets(2,2,2,2));//setMargin���������ð�ť�߿�ͱ�ǩ֮��Ŀհ�
		pagenext.setMargin(new Insets(2,2,2,2));
		home.setMargin(new Insets(2,2,2,2));
		last.setMargin(new Insets(2,2,2,2));
				//�趨����
		timeleft.setFont(jlb);
		ttime.setFont(jtf);
				//����������ʾʱ��������
		time.add(timeleft);
		time.add(ttime);
		
				//��һҳ��Ŀ����
		for(int i=0;i<10;i++) {
			question[i]=new JLabel("");
			question[i].setFont(jlb);
			tanswer[i]=new JTextField(4);
			tanswer[i].setFont(jtf);
			right_answer[i]=new JLabel("");
			right_answer[i].setFont(jlb);
			showistrue[i]=new JLabel("");
			showistrue[i].setFont(jlb);
				//������
			jpa2.add(question[i]);
			jpa2.add(tanswer[i]);
			jpa2.add(right_answer[i]);
			jpa2.add(showistrue[i]);
		}
				//�ڶ�ҳ��Ŀ����
		for(int i=10;i<20;i++) {//ע��i����
			question[i]=new JLabel("");
			question[i].setFont(jlb);
			tanswer[i]=new JTextField(4);
			tanswer[i].setFont(jtf);
			right_answer[i]=new JLabel("");
			right_answer[i].setFont(jlb);
			showistrue[i]=new JLabel("");
			showistrue[i].setFont(jlb);
				//������
			jpa3.add(question[i]);
			jpa3.add(tanswer[i]);
			jpa3.add(right_answer[i]);
			jpa3.add(showistrue[i]);
		}
				//����ҳ��Ŀ����
		for(int i=20;i<30;i++) {
			question[i]=new JLabel("");
			question[i].setFont(jlb);
			tanswer[i]=new JTextField(4);
			tanswer[i].setFont(jtf);
			right_answer[i]=new JLabel("");
			right_answer[i].setFont(jlb);
			showistrue[i]=new JLabel("");
			showistrue[i].setFont(jlb);
				//������
			jpa4.add(question[i]);
			jpa4.add(tanswer[i]);
			jpa4.add(right_answer[i]);
			jpa4.add(showistrue[i]);
		}
				//����ҳ
		for(int i=30;i<40;i++) {
			question[i]=new JLabel("");
			question[i].setFont(jlb);
			tanswer[i]=new JTextField(4);
			tanswer[i].setFont(jtf);
			right_answer[i]=new JLabel("");
			right_answer[i].setFont(jlb);
			showistrue[i]=new JLabel("");
			showistrue[i].setFont(jlb);
				//������
			jpa5.add(question[i]);
			jpa5.add(tanswer[i]);
			jpa5.add(right_answer[i]);
			jpa5.add(showistrue[i]);
		}
				//����ҳ
		for(int i=40;i<50;i++) {
			question[i]=new JLabel("");
			question[i].setFont(jlb);
			tanswer[i]=new JTextField(4);
			tanswer[i].setFont(jtf);
			right_answer[i]=new JLabel("");
			right_answer[i].setFont(jlb);
			showistrue[i]=new JLabel("");
			showistrue[i].setFont(jlb);
				//������
			jpa6.add(question[i]);
			jpa6.add(tanswer[i]);
			jpa6.add(right_answer[i]);
			jpa6.add(showistrue[i]);
		}
		
		//�Կ�ʼ��ť��Ӽ�����
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				//��ȡѧ����Ϣ
				String str_name=tname.getText();
				String str_class=tyouclass.getText();
				String str_grade=tgrade.getText();
				
				if(str_name.length()==0)
					JOptionPane.showMessageDialog(title, "��������Ϊ��");
				else if(str_class.length()==0)
					JOptionPane.showMessageDialog(title,"���󣬰༶Ϊ��");
				else if(str_grade.length()==0)
					JOptionPane.showMessageDialog(title,"�����꼶Ϊ��");
				else {
					test.setSize(750, 400);
					test.setResizable(false);
					test.setLocationRelativeTo(null);//�ô�������Ļ������ʾ
					test.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					test.setVisible(true);
					if(start.getText().equals("��ʼ����"));{
						start();
						t.start();//��ʼ����ʱ
					}
				}
			}
		});
		//�Խ���ť��Ӽ�����
		end.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t.flag=false;//ֹͣcounttime���ʱ�䵹��ʱ
			}
		});
		
		//ҳ���л�
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
		
		
		//��Ӱ�ť
		jpa.add(home);
		jpa.add(pagenext);
		jpa.add(pageback);
		jpa.add(last);
		jpa.add(end);
		jpa.add(time);
		//jpa.add(average);
		
		//��Ƭ�������ҳ�沢�趨����
		maincard.add(jpa2,"p1");
		maincard.add(jpa3,"p2");
		maincard.add(jpa4,"p3");
		maincard.add(jpa5,"p4");
		maincard.add(jpa6,"p5");
		
		//��������Ӵ��ڲ���
		title.add(name);
		title.add(tname);
		title.add(youclass);
		title.add(tyouclass);
		title.add(grade);
		title.add(tgrade);
		title.add(start);
		
		test.getContentPane().add(maincard);
		test.getContentPane().add(jpa,BorderLayout.SOUTH);//�趨�߽粼�ֲ���������
		
		title.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		title.setVisible(true);
		
	}
	
	public void start() {//��ʾ��ȷ�𰸣��÷ֺ�ʹ�õ�ʱ�䣬��д���ļ�
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
				JOptionPane.showMessageDialog(q, "���ִ�����������������");
			}
		}
	}
	public void showAnswer() {
		score=100;
		for(int i=0;i<50;i++) {
			try {
				stuanswer[i]=Integer.valueOf(tanswer[i].getText());
			}catch(Exception e) {
				//System.out.println("�������");
			}
			questions[i].setstuAnswer(stuanswer[i]);
			right_answer[i].setText(questions[i].showrightAnwser());
			showistrue[i].setText(questions[i].isTrue());
			
			if(showistrue[i].getText().equals("�𰸴���")) {
				score-=2;
			}
		}
	}
	
	File stuData=new File("ѧ��.txt");{
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
			out.println("����:"+newname+" �꼶:"+newgrade+"  �༶:"+newclass+"  �ɼ���"+score);
			out.close();
		}catch(FileNotFoundException e) {
			System.out.println("�ļ�����ʧ��");
		}catch(IOException e1) {
			e1.printStackTrace();
		}
	}

	public static void main(String[] args) {
		MainFrame open=new MainFrame();
	}
}


	
	
	
	
	
