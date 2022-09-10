
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Frame6 extends JFrame {


	private File tempFile = new File( "Temp.txt");
	private File file = new File( "Create.txt");
	JButton addBtn;
	JButton createBtn;
	JButton deleteBtn;
	JButton editBtn;
	JLabel menuTitle;
	JSeparator horizontalLine;
	JPanel menuPanel;
	JButton showBtn,removeGButton;


	public Frame6() {

		menuPanel = new JPanel();
		createBtn = new JButton();
		editBtn = new JButton();
		deleteBtn = new JButton();
		showBtn = new JButton();
		removeGButton =new JButton();
		addBtn = new JButton();
		menuTitle = new JLabel();
		horizontalLine = new JSeparator();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Guest Checkin Checkout");
		setSize(new Dimension(800, 800));
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		menuPanel.setBackground(new Color(204, 204, 255));
		menuPanel.setToolTipText("Temporary files");
		menuPanel.setLayout(null);

		createBtn.setText("Create File");
		createBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				createBtnActionPerformed(evt);
			}
		});
		menuPanel.add(createBtn);
		createBtn.setBounds(40, 10, 320, 60);

		editBtn.setText("Edit Guest data");
		editBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				editBtnActionPerformed(evt);
			}
		});menuPanel.add(editBtn);
		editBtn.setBounds(40, 250, 320, 60);

		deleteBtn.setText("Delete File");
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				deleteBtnActionPerformed(evt);
			}
		});


		editBtn.setText("Edit Guest data");
		editBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				editBtnActionPerformed(evt);
			}
		});
		menuPanel.add(deleteBtn);
		deleteBtn.setBounds(40, 330, 320, 60);

		showBtn.setText("Show Guest details");
		showBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				showBtnActionPerformed(evt);
			}
		});
		menuPanel.add(showBtn);


		menuPanel.add(removeGButton);
		removeGButton.setBounds(40, 410, 320, 60);

		removeGButton.setText("Remove Guest");
		removeGButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				deleteGSTBtnActionPerformed(evt);
			}
		});
		menuPanel.add(showBtn);






		showBtn.setBounds(40, 170, 320, 60);

		addBtn.setText("Add Guest");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				addBtnActionPerformed(evt);
			}
		});



		menuPanel.add(addBtn);
		addBtn.setBounds(40, 90, 320, 60);

		getContentPane().add(menuPanel);
		menuPanel.setBounds(190, 60, 400, 510);

		menuTitle.setText("Menu");
		getContentPane().add(menuTitle);
		menuTitle.setBounds(370, 20, 99, 35);
		getContentPane().add(horizontalLine);
		horizontalLine.setBounds(330, 50, 120, 10);

	}

	private String getDataFromFile(String search) {
		String currentData = null;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
			String currentLine;

			while ((currentLine = reader.readLine()) != null) {

				currentLine = currentLine.trim();
				String[] trimLine = currentLine.split("!");
				if (trimLine[0].equals(search.trim())) {
					currentData = trimLine[0];
				}
			}
			writer.close();
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return currentData;
	}
	public void removeGuestFromFile(String lineToRemove) {
		try {
		BufferedReader reader = new BufferedReader(new FileReader(file));
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));

		String currentLine;

			while((currentLine = reader.readLine()) != null) {
				// trim newline when comparing with lineToRemove
				String trimmedLine = currentLine.trim();
				String[] strings = trimmedLine.split("!");
				String nameToRemove = strings[0].toLowerCase();
				System.out.println(nameToRemove);
				if (nameToRemove.equals(lineToRemove.toLowerCase())){
					System.out.println("Dhukse");
					writer.write("");
				}
			}
		writer.close();
		reader.close();

	}catch (IOException ex) {
			System.out.println(ex);
		}

	}

	public void editLineFromFile(String Search, String lineToAdd) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
			String currentLine;
			String currentData;
			String updatedAt = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
			while ((currentLine = reader.readLine()) != null) {
				currentLine = currentLine.trim();
				String[] trimLine = currentLine.split("!");
				if (trimLine[0].equals(Search.trim())) {
					writer.write(lineToAdd + "!" + updatedAt + "\n");
					continue;
				}
				writer.write(currentLine + "\n");
			}
			writer.close();
			reader.close();
			BufferedWriter BW = new BufferedWriter(new FileWriter(file));
			BufferedReader BR = new BufferedReader(new FileReader(tempFile));

			while ((currentData = BR.readLine()) != null) {
				BW.write(currentData + "!\n");
			}
			BW.close();
			BR.close();

		} catch (IOException e) {
			System.out.println(e);
		}
	}



	private void createBtnActionPerformed(ActionEvent evt) {
		if(!file.exists()){
			try {
				file.createNewFile();
				System.out.println("file created! " + file.getName());
				JOptionPane.showMessageDialog(this, "File Created!","Success" ,JOptionPane.PLAIN_MESSAGE);
			} catch (IOException ex) {
				System.out.println("system failed to create file! " + System.getProperty("user.dir") + ex);
			}
		}
		else{
			JOptionPane.showMessageDialog(this, "File Already Created!","Failed" ,JOptionPane.ERROR_MESSAGE);
		}
	}

	private void addBtnActionPerformed(ActionEvent evt) {
		try {
			BufferedWriter BW = new BufferedWriter(new FileWriter(file,true));
			String data = JOptionPane.showInputDialog(this, "Add data?");
			String createdAt = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
			BW.write(data.trim() + "!" + createdAt + "\n");
			BW.close();
			System.out.println("The following guest has Checked in:  " + data + "!");
		} catch (IOException ex) {
			System.out.println("This is an exception of unknown! " + ex);
		}
	}

	private void editBtnActionPerformed(ActionEvent evt) {
		String search = null, data = null;
		if (search == null) {
			search = JOptionPane.showInputDialog(this, "search your data");

			if (getDataFromFile(search) == null) {
				JOptionPane.showMessageDialog(this, "No data found", "Failed!", JOptionPane.ERROR_MESSAGE);
			}
			else{

				data = JOptionPane.showInputDialog(this, "edit your data", getDataFromFile(search));
				editLineFromFile(search, data);
				JOptionPane.showMessageDialog(this, "Guest edited successfully!", "Success", JOptionPane.PLAIN_MESSAGE);
			}

		}


	}

	private void deleteGSTBtnActionPerformed(ActionEvent evt) {
		String search = null, data = null;
		if (search == null) {
			search = JOptionPane.showInputDialog(this, "search your data");

			if (getDataFromFile(search) == null) {
				JOptionPane.showMessageDialog(this, "No Guest found", "Failed!", JOptionPane.ERROR_MESSAGE);
			} else {
				removeGuestFromFile(search);
				JOptionPane.showMessageDialog(this, "Guest Deleted successfully!", "Success", JOptionPane.PLAIN_MESSAGE);
			}

		}
	}
	private void showBtnActionPerformed(ActionEvent evt) {
		try {
			BufferedReader BR = new BufferedReader(new FileReader(file));
			String currentLine, fullText = "";
			while((currentLine = BR.readLine()) != null){
				fullText += currentLine+"\n";
			}
			JFrame showDataFrame = new JFrame();
			showDataFrame.setSize(500,400);
			showDataFrame.setLocationRelativeTo(this);
			showDataFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			showDataFrame.setVisible(true);
			showDataFrame.setLayout(null);
			JTextArea dataField = new JTextArea();
			dataField.append(fullText);
			dataField.setEditable(false);
			dataField.setBounds(50, 50, 400, 300);
			showDataFrame.add(dataField);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	private void deleteBtnActionPerformed(ActionEvent evt) {
		if(file.exists()){
			file.delete();
			JOptionPane.showMessageDialog(this, "File Successfully deleted", "Operation Success", JOptionPane.NO_OPTION);
		}else{
			JOptionPane.showMessageDialog(this, "You have not created any file yet!", "Operation Failed", JOptionPane.ERROR_MESSAGE);
		}
	}
}
