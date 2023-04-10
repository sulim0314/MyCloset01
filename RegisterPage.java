package MyProject2;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.*;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * --------------------------------------- 
 * @author 고수림
 * 작성일: 2023-04-06
 * 버 전 : 1.0
 * MyClosetApp의 옷종류별(Outer,Top,Bottoms,Shoes) 등록 페이지(Register Page)를 구성하는  클래스
 * --------------------------------------
 */
public class RegisterPage extends JPanel implements ActionListener {

	private String sort, name, brand, color;
	private int price;
	
	JTextField tfName; // 명칭
	JTextField tfBrand; // 브랜드
	JTextField tfColor; // 색깔
	JTextField tfPrice; // 가격
	
	JButton btRg; // 등록 버튼
	JButton btCc; // 취소 버튼

	JButton btBack; // 뒤로가기
	
	public RegisterPage() { 
		this.setLayout(null);//레이아웃 해제
		
		tfName = new JTextField(20);
		tfBrand = new JTextField(20);
		tfColor = new JTextField(20);
		tfPrice = new JTextField(20);
		
		btRg = new JButton("Register");
		btCc = new JButton("Cancle");
		btBack = new JButton("◀");
		
		tfName.setBounds(67, 150, 200,50);//x,y, width,height
		tfBrand.setBounds(67, 220, 200, 50);
		tfColor.setBounds(67, 290, 200, 50);
		tfPrice.setBounds(67, 360, 200, 50);
		
		btRg.setBounds(60, 430,100,50);
		btCc.setBounds(170, 430,100,50);
		
		btRg.setBackground(new Color(110,0,110));
		btCc.setBackground(new Color(110,0,110));
		
		btRg.setForeground(Color.white);
		btCc.setForeground(Color.white);

		tfName.setBorder(new TitledBorder("< Name >"));
		tfBrand.setBorder(new TitledBorder("< Brand >"));
		tfColor.setBorder(new TitledBorder("< Color >"));
		tfPrice.setBorder(new TitledBorder("< Price >"));
		
		// ←
		btBack.setBounds(20,20,50,50);
		btBack.setBackground(Color.lightGray);
		btBack.setForeground(Color.black);
		
		add(tfName);
		add(tfBrand);
		add(tfColor);
		add(tfPrice);
		add(btRg);
		add(btCc);
		add(btBack);
		
		btRg.addActionListener(this);
		btCc.addActionListener(this);
	
	} //----------------------------------------------------
	/** 등록하기 버튼을 누르면 ArrayList에 저장되는 기능을 구현하는 메서드가 실행됨.
	*  취소하기 버튼을 누르면 TestField가 초기화되는 기능을 구현하는 메서드가 실행됨.
	* */
	@Override
	public void actionPerformed(ActionEvent e){
		Object obj=e.getSource();
		
		 if(obj == btRg) { // 작성 후 등록하기
			 ListPage lp = ListPage.getInstance1();
			 MyClosetApp MCA = new MyClosetApp();
			 lp.getSortList().add(MCA.getSort1());
			 lp.getNameList().add(tfName.getText());
			 lp.getBrandList().add(tfBrand.getText());
			 lp.getColorList().add(tfColor.getText());
			 lp.getPriceList().add(Integer.parseInt(tfPrice.getText()));
			 JOptionPane.showMessageDialog(null, "등록되었습니다.");
			 reset();
		 } else if(obj == btCc) { // 작성 후 취소하기
			 reset();
		   }
		
	} 

	/**  취소하기 버튼을 누르면 TextField가 초기화되는 기능을 구현하는 메서드.
	 * */
	public void reset() {
		// 작성 후 취소하기 (모두 초기화)
		tfName.setText("");
		tfBrand.setText("");
		tfColor.setText("");
		tfPrice.setText("");
		tfName.requestFocus(); //입력 포커스 주기
	} 

	
	
}
