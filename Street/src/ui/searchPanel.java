package ui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import bean.Street;
import service.StreetService;
import service.impl.StreetServiceImpl;

public class searchPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//查询信息面板按钮
	private JTextField searchText;
	private JButton searchBt;
	private JComboBox<String> searchByBox;
	private JTable searchTable;
	private DefaultTableModel model;
	private Vector<String> col; //保存列名
	private JScrollPane searchScroll;
	private JLabel messageLabel;
	
	// 表单列名与内容
	private String[] columnNames = {"街道号", "街道名称", "街道类型", "街道长度", "街道负责人", "街道所在区"};
	private String[][] record = {};	
	
	public searchPanel() {
		
		init();
		
		//查询信息面板
		this.setLayout(null);
		this.add(messageLabel);
		this.add(searchByBox);
		this.add(searchText);
		this.add(searchBt);
		this.add(searchScroll);
		this.setBounds(0, 160, 1440, 740);
		this.setVisible(false);
		
		// 查询界面查找按钮事件
		searchBt.addActionListener(new ActionListener() {
			@Override
		    public void actionPerformed(ActionEvent e) {
				int Index=searchByBox.getSelectedIndex();				// 获取复选框当前值index
				StreetService sp = new StreetServiceImpl();
				if(searchText.getText() == "") {
					JOptionPane.showMessageDialog(null, "搜索框不可为空！", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(Index == 0) {
					Street streetByid = sp.findById(searchText.getText());
					Vector<String> row = new Vector<String>();
					row.add(streetByid.getId());
					row.add(streetByid.getName());
					row.add(streetByid.getType());
					row.add(String.valueOf(streetByid.getLength()));
					row.add(streetByid.getManName());
					row.add(streetByid.getArea());
					
					Vector<Vector<String>> data = new Vector<Vector<String>>();
					data.add(row);

					model.setDataVector(data, col);
					
				}
				else if(Index == 1) {
					List<Street> findstreetlist = sp.seachByName(searchText.getText());
					Vector<Vector<String>> findData = new Vector<Vector<String>>();
					setTable(findstreetlist, findData, model);
				}
				else if(Index == 2) {
					List<Street> findstreetlist = sp.seachByType(searchText.getText());
					Vector<Vector<String>> findData = new Vector<Vector<String>>();
					setTable(findstreetlist, findData, model);
				}
				else if(Index == 3) {
					List<Street> findstreetlist = sp.seachByManName(searchText.getText());
					Vector<Vector<String>> findData = new Vector<Vector<String>>();
					setTable(findstreetlist, findData, model);
				}
				else if(Index == 4) {
					List<Street> findstreetlist = sp.seachByManName(searchText.getText());
					Vector<Vector<String>> findData = new Vector<Vector<String>>();
					setTable(findstreetlist, findData, model);
				}
		    }
		});
		
	}
	
    // 设置JTable内容
    private void setTable(List<Street> list, Vector<Vector<String>> data, DefaultTableModel model){
    	while(!list.isEmpty()) {
			Vector<String> row = new Vector<String>();
			row.add(list.get(0).getId());
			row.add(list.get(0).getName());
			row.add(list.get(0).getType());
			row.add(String.valueOf(list.get(0).getLength()));
			row.add(list.get(0).getManName());
			row.add(list.get(0).getArea());
			data.add(row);
			list.remove(0);
		}
    	model.setDataVector(data, col);
    }
    
    public void init() {
		// 初始化col
		col = new Vector<String>();
		col.add("街道号");
    	col.add("街道名称");
    	col.add("街道类型");
    	col.add("街道长度");
    	col.add("街道负责人");
    	col.add("街道所在区");
		
		//设置查询信息组件
		String[] itemList = {"街道号", "街道名", "街道类型", "街道负责人", "街道所在区"};
		searchByBox=new JComboBox<>(itemList);
		searchByBox.setSelectedIndex(0);
		searchByBox.setBounds(10, 90, 100, 40);
		
		searchText=new JTextField();
		searchText.setSize(1200, 40);
		searchText.setLocation(120,90);
		
		searchBt=new JButton("查询");	
		searchBt.setSize(100, 40);
		searchBt.setLocation(1330,90);
		
		messageLabel=new JLabel("查找街道信息");
		messageLabel.setSize(600, 80);
		messageLabel.setLocation(580,10);
		messageLabel.setFont(new Font("楷体", Font.BOLD,32));

		model = new DefaultTableModel(record, columnNames);
		searchTable = new JTable(model);
		searchScroll = new JScrollPane(searchTable);
		searchScroll.setPreferredSize(new Dimension(1200, 530)); 
		searchScroll.setBounds(120, 150, 1200, 530);
    }
}
