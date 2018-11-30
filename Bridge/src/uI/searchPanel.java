package uI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import bean.Bridge;
import service.BridgeService;
import service.impl.BridgeServiceImpl;

public class searchPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 查询信息面板按钮
	private JTextField searchText;
	private JButton searchBt;
	private JComboBox<String> searchByBox;
	private JTable searchTable;
	private DefaultTableModel model;
	private Vector<String> col; // 保存列名
	private JScrollPane searchScroll;
	private JLabel messageLabel;

	// 表单列名与内容
	private String[] columnNames = { "桥梁编号", "桥梁名称", "桥梁类型", "桥梁长度", "桥梁负责人", "桥梁所在区" };
	private String[][] record = {};

	public searchPanel() {

		init();

		// 查询信息面板
		this.setLayout(null);
		this.add(messageLabel);
		this.add(searchByBox);
		this.add(searchText);
		this.add(searchBt);
		this.add(searchScroll);
		this.setBounds(0, 160, 1320, 740);
		this.setVisible(false);

		// 查询界面查找按钮事件
		searchBt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int Index = searchByBox.getSelectedIndex(); // 获取复选框当前值index
				BridgeService bp = new BridgeServiceImpl();
				if (Index == 0) {
					if (searchText.getText().equals("")) {
						List<Bridge> findstreetlist = bp.findAll();
						Vector<Vector<String>> findData = new Vector<Vector<String>>();
						setTable(findstreetlist, findData, model);
						// JOptionPane.showMessageDialog(null, "请输入编号！", "Error",
						// JOptionPane.ERROR_MESSAGE);
					} else {
						Bridge streetByid = bp.findById(searchText.getText());
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
				} else if (Index == 1) {
					if (searchText.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "请输入名称！", "Error", JOptionPane.ERROR_MESSAGE);
					} else {
						List<Bridge> findstreetlist = bp.seachByName(searchText.getText());
						Vector<Vector<String>> findData = new Vector<Vector<String>>();
						setTable(findstreetlist, findData, model);
					}
				} else if (Index == 2) {
					if (searchText.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "请输入类型！", "Error", JOptionPane.ERROR_MESSAGE);
					} else {
						List<Bridge> findstreetlist = bp.seachByType(searchText.getText());
						Vector<Vector<String>> findData = new Vector<Vector<String>>();
						setTable(findstreetlist, findData, model);
					}
				} else if (Index == 3) {
					if (searchText.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "请输入负责人！", "Error", JOptionPane.ERROR_MESSAGE);
					} else {
						List<Bridge> findstreetlist = bp.seachByManName(searchText.getText());
						Vector<Vector<String>> findData = new Vector<Vector<String>>();
						setTable(findstreetlist, findData, model);
					}
				} else if (Index == 4) {
					if (searchText.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "请输入区域！", "Error", JOptionPane.ERROR_MESSAGE);
					} else {
						List<Bridge> findstreetlist = bp.seachByArea(searchText.getText());
						Vector<Vector<String>> findData = new Vector<Vector<String>>();
						setTable(findstreetlist, findData, model);
					}
				}
			}
		});

	}

	// 设置JTable内容
	private void setTable(List<Bridge> list, Vector<Vector<String>> data, DefaultTableModel model) {
		while (!list.isEmpty()) {
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
		col.add("桥梁编号");
		col.add("桥梁名称");
		col.add("桥梁类型");
		col.add("桥梁长度");
		col.add("桥梁负责人");
		col.add("桥梁所在区");

		// 设置查询信息组件
		String[] itemList = { "桥梁编号", "桥梁名称", "桥梁类型", "桥梁负责人", "桥梁所在区" };
		searchByBox = new JComboBox<>(itemList);
		searchByBox.setSelectedIndex(0);
		searchByBox.setBounds(10, 50, 100, 40);

		searchText = new JTextField();
		searchText.setSize(120, 40);
		searchText.setLocation(120, 50);

		searchBt = new JButton("查询");
		searchBt.setSize(60, 40);
		searchBt.setLocation(250, 50);

		messageLabel = new JLabel("查找桥梁信息");
		messageLabel.setSize(180, 20);
		messageLabel.setLocation(300, 0);
		messageLabel.setFont(new Font("楷体", Font.BOLD, 24));

		model = new DefaultTableModel(record, columnNames);
		searchTable = new JTable(model);
		searchScroll = new JScrollPane(searchTable);
		searchScroll.setPreferredSize(new Dimension(500, 520));
		searchScroll.setBounds(10, 100, 880, 500);
	}
}
