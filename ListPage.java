package MyProject2;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * --------------------------------------- 
 * @author 고수림
 * 작성일: 2023-04-06
 * 버 전 : 1.0
 * MyClosetApp의 옷 목록 페이지(List Page) 화면과 기능을 구현하는 클래스
 * --------------------------------------
 */
public class ListPage extends JPanel implements ActionListener {
	private static ListPage instance1 = new ListPage();
	private ArrayList<String> sortList = new ArrayList<>(Arrays.asList("상의","상의","상의","상의","하의","하의","하의","하의","아우터","신발","신발","신발"));
    private ArrayList<String> nameList = new ArrayList<>(Arrays.asList("하늘하늘한 블라우스","오버핏 반팔","슬림핏 V넥라인 반팔","가오리핏 예쁜 맨투맨","부츠컷핏 하이웨스트","무지 레깅스","5부 반바지","연청 롱치마","항공점퍼","하이 컨버스","나이키 운동화","워커"));
    private ArrayList<String> brandList = new ArrayList<>(Arrays.asList("Zara","나이키","유니클로","노스페이스","리바이스","아디다스","Zara","보세","Zara","컨버스","나이키","닥터마틴"));
    private ArrayList<String> colorList = new ArrayList<>(Arrays.asList("핑크색","흰색","하늘색","검은색","진청","검은색","베이지색","연청","검은색","검은색","흰색","검은색"));
    private ArrayList<Integer> priceList = new ArrayList<>(Arrays.asList(50000,40000,30000,70000,70000,50000,50000,50000,90000,90000,150000,200000));

	JButton btSearch,btDelete,btRefresh; // 검색/ 삭제/ 새로고침
	JButton btBack;
	JTextArea ta; // 중앙
	JLabel lbTitle, lbSearch;
	JTextField tfSearch;
	JScrollPane scrollPane;
	
	public ListPage() {
		this.setLayout(null);//레이아웃 해제
		
		// 'List' 타이틀 넣기
		lbTitle = new JLabel("List");
	    this.add(lbTitle,BorderLayout.CENTER);
	    lbTitle.setBounds(120, 50, 300, 100);
	    lbTitle.setFont(new Font("Serif", Font.BOLD, 50));
		
	    // Back 버튼
	    btBack = new JButton("◀");
		btBack.setBounds(20,20,50,50);
		btBack.setBackground(Color.lightGray);
		btBack.setForeground(Color.black);
		add(btBack);

		//Name ▶
		lbSearch = new JLabel("Name ▶ ");
	    lbSearch.setBounds(10,112,300,100);
	    lbSearch.setFont(new Font("Serif", Font.BOLD, 14));
		this.add(lbSearch);
		
	    tfSearch = new JTextField(15);	
		tfSearch.setBounds(70,153,173,23); 
		this.add(tfSearch);
		
		// 검색 버튼
		btSearch = new JButton ("Search");
		btSearch.setBounds(249,153,80,23);
		btSearch.setFont(new Font("Serif", Font.BOLD, 15));
		this.add(btSearch);
		btSearch.addActionListener(this);
		
		// Refresh 버튼
	    btRefresh = new JButton("\u21BB");
		btRefresh.setBounds(270,470,50,50);
		btRefresh.setBackground(Color.pink);
		btRefresh.setForeground(Color.black);
		this.add(btRefresh);
		btRefresh.addActionListener(this);
		
		// 삭제 버튼
		btDelete = new JButton ("Delete");
		btDelete.setBounds(249,435,80,23);
		btDelete.setFont(new Font("Serif", Font.BOLD, 15));
		this.add(btDelete);
		
		// JTextArea ta에 현재 갖고 있는 List보여주기
		ta = new JTextArea();
		scrollPane = new JScrollPane(ta);
		scrollPane.setBounds(8, 190, 320, 230);
		this.add(scrollPane);
		
		
		
		for(int i=0; i<sortList.size(); i++) {
			ta.append(" "+ (i+1) +". ");
			ta.append(" | ");
			ta.append(sortList.get(i));
			ta.append(" | ");
			ta.append(nameList.get(i));
			ta.append(" | ");
			ta.append(brandList.get(i));
			ta.append(" | ");
			ta.append(colorList.get(i));
			ta.append(" | ");
			ta.append(""+priceList.get(i));
			ta.append("\n");
		}
		
	}

    /** 새로고침/ 삭제
	 * */
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == btRefresh) {
        	ta.setText("");
        } else if(e.getSource() == btDelete) {
        	String name = JOptionPane.showInputDialog("무엇을 삭제하시겠습니까? 번호를 입력해주세요.");
	        if (name == null) {
	            JOptionPane.showMessageDialog(null, "다시 입력해주세요.");
	        } else if (name.equals("")) {
	        	JOptionPane.showMessageDialog(null, "다시 입력해주세요.");
	        } 
        }

      
    }
    
    public static ListPage getInstance1() {
        return instance1;
    }
    public ArrayList<String> getSortList() {
        return sortList;
    }

    public ArrayList<String> getNameList() {
        return nameList;
    }

    public ArrayList<String> getBrandList() {
        return brandList;
    }

    public ArrayList<String> getColorList() {
        return colorList;
    }

    public ArrayList<Integer> getPriceList() {
        return priceList;
    }
    
    
    

}

