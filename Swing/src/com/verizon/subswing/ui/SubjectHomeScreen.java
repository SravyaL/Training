package com.verizon.subswing.ui;



import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.verizon.subswing.exception.SubjectException;
import com.verizon.subswing.model.Subject;
import com.verizon.subswing.service.SubjectService;
import com.verizon.subswing.service.SubjectServiceImp;

public class SubjectHomeScreen extends JFrame {
	
	JMenuBar menuBar;
	SubjectService subjectService;
	DefaultTableModel model;
	SubjectApp subapp;
	
	public SubjectHomeScreen() {
		
		subjectService = new SubjectServiceImp();
		
		createMenuBar();
		model = new DefaultTableModel(new String[] {"Id", "Title", "Duration"}, 0);
		JTable table = new JTable(model);
		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		
		add(new JScrollPane(table));
		
		loadData();
		
		setTitle("Subject Set");
		int width = 700;
		int height= 500;
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((int)(dim.getWidth()-width)/2,(int)(dim.getHeight()-height)/2,width,height);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void loadData(int x) {
		try {
			List<Subject> subjectList = subjectService.getAllSubjects();
			int a = x;
			if(a == 1)
				Collections.sort(subjectList,new Compare());
			else if(a == 2)
				Collections.sort(subjectList,new Compare1());
			else
				Collections.sort(subjectList,new Compare2());
			model.setRowCount(0);
			for(Subject s : subjectList) {
				Object[] col = new Object[3];
				col[0] = s.getSubjectId();
				col[1] = s.getSubtitle();
				col[2] = s.getDurationInHours();
				model.addRow(col);
			}
		} catch(SubjectException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void loadData() {
		try {
			List<Subject> subjectList = subjectService.getAllSubjects();
			model.setRowCount(0);
			for(Subject s : subjectList) {
				Object[] col = new Object[3];
				col[0] = s.getSubjectId();
				col[1] = s.getSubtitle();
				col[2] = s.getDurationInHours();
				model.addRow(col);
			}
		} catch(SubjectException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
		}
	}

	private void createMenuBar() {
		
		HomeScreenActionAdapter adp = new HomeScreenActionAdapter();
		
		menuBar = new JMenuBar();
		JMenu mnFile = menuBar.add(new JMenu("File"));
		JMenu mnView = menuBar.add(new JMenu("View"));
		
		mnFile.setMnemonic('F');
		mnView.setMnemonic('V');
		
		setJMenuBar(menuBar);
		
		JMenuItem m1 =  mnFile.add("Add Subject");
		m1.setMnemonic('A');
		m1.addActionListener(adp);
		JMenuItem m2 = mnFile.add("Delete");
		m2.setMnemonic('D');
		m2.addActionListener(adp);
		mnFile.addSeparator();
		JMenuItem m3 = mnFile.add("Search");
		m3.setMnemonic('S');
		m3.addActionListener(adp);
		mnFile.addSeparator();
		JMenuItem m4 = mnFile.add("Exit");
		m4.setMnemonic('X');
		m4.addActionListener(adp);
		JMenu mnSort = (JMenu) mnView.add(new JMenu("Sort"));
		JMenuItem m5 = mnSort.add("By SubjectID");
		m5.addActionListener(adp);
		JMenuItem m6 = mnSort.add("By Subject Title");
		m6.addActionListener(adp);
		JMenuItem m7 = mnSort.add("By Duration in Hrs");
		m7.addActionListener(adp);
		
	}
	
	class HomeScreenActionAdapter implements ActionListener {
		
		public void  actionPerformed(ActionEvent event) {
			
			String cmd = event.getActionCommand();
			
			switch(cmd) {
			case "Add Subject":
				doAddSubject();
				break;
			case "Delete":
				doDeleteSubject();
				   break;
			case "Search":
				doSearchSubject();
				break;
			case "By SubjectID":
				doSortByID();
				break;
			case "By Subject Title":
				doSortByTitle();
				break;
			case "By Duration in Hrs":
				doSortByDuration();
				break;
			case "Exit":
				dispose();
				break;
			default:
				JOptionPane.showMessageDialog(null, cmd +" is not implemented in this version");
			}
		}
	}
	
private void doAddSubject() {
		SubjectEntryScreen entryScreen = new SubjectEntryScreen(this,null);
		entryScreen.setVisible(true);
		if(entryScreen.shallSave){
			try {
				subjectService.add(entryScreen.subject);
				loadData();
			} catch (SubjectException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(this, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}

	public void doSearchSubject() {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Subject Id", "Search", JOptionPane.INFORMATION_MESSAGE));
		
		try{
			Subject subject = subjectService.findByID(id);
			
			if(subject ==  null) {
					JOptionPane.showMessageDialog(this, "Subject does not exist","Access Denied",JOptionPane.INFORMATION_MESSAGE);
				}
			else {
					JOptionPane.showMessageDialog(this, subject,"Subject found",JOptionPane.INFORMATION_MESSAGE);
				}
		} catch(SubjectException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
		}
		
	}

	public void doDeleteSubject() {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(JOptionPane.showInputDialog(this,"Enter Subject ID"));
		try {
			boolean	isDeleted = subjectService.deleteSubject(id);
			if(isDeleted)
				loadData();
			else
				JOptionPane.showMessageDialog(this, "Subject does not exist","Access Denied",JOptionPane.INFORMATION_MESSAGE);
		} catch (SubjectException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void doSortByID() {
		loadData(1);
	}
	
	public void doSortByTitle() {
		loadData(2);
	}
	
	public void doSortByDuration() {
		loadData(3);
	}
}
