package java_swing_study.chap11.exam;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;

public class StudentFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel panel02;
	private StudentTblPanel panel03;
	private JButton btnAdd;
	private JButton btnCancel;
	private JPanel panel01;
	private StudentPanel pStudent;
	private ArrayList<Student> stds;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentFrame frame = new StudentFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public StudentFrame() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		panel01 = new JPanel();
		contentPane.add(panel01);
		panel01.setLayout(new BorderLayout(0, 0));
		
		pStudent = new StudentPanel();
		panel01.add(pStudent, BorderLayout.CENTER);
		panel02 = new JPanel();
		contentPane.add(panel02);
		
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		panel02.add(btnAdd);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		panel02.add(btnCancel);
		
		panel03 = new StudentTblPanel();
		contentPane.add(panel03);
		
		stds = new ArrayList<Student>();
		stds.add(new Student(1, "서현진", 80, 90, 70));
		stds.add(new Student(2, "이성경", 90, 90, 40));
		stds.add(new Student(3, "이유영", 50, 50, 60));
		
		panel03.loadData(stds);
//		panel03.setLayout(new BorderLayout(0, 0));
		

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			btnCancelActionPerformed(e);
		}
		if (e.getSource() == btnAdd) {
			btnAddActionPerformed(e);
		}
	}
	protected void btnAddActionPerformed(ActionEvent e) {
//		Student std = pStudent.getItem();
//		textArea.append(std.toString()+"\n");
		pStudent.clearTf();
	}
	protected void btnCancelActionPerformed(ActionEvent e) {
		pStudent.clearTf();
	}
}
