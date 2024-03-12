/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fees_management_system_1;

import jakarta.mail.internet.MailDateFormat;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author shubham
 */
public class Genrate_Report extends javax.swing.JFrame {

    DefaultTableModel model;
    /**
     * Creates new form Genate_Report
     */
    public Genrate_Report() {
        initComponents();
        fillComboBox();
    }

    
     public void fillComboBox(){
          try 
          {   Class.forName("com.mysql.cj.jdbc.Driver");
              Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fees_management", "root", "Shubhu@2001");
              PreparedStatement ptmt=con.prepareStatement("select cname from course");
                 ResultSet rs= ptmt.executeQuery();
                 
                 while(rs.next())
                 {
                     combo_course_details.addItem(rs.getString("cname"));
                 }
          } catch (Exception e) 
          {
              e.printStackTrace();
              e.toString();
             // System.out.println("");
          }
      }
     
        public void setRecordsTOTable(){
            String cname=combo_course_details.getSelectedItem().toString();
            
            SimpleDateFormat datefromat =new SimpleDateFormat("YYYY-MM-dd");
            String fromDate=datefromat.format(datechooserFrom.getDate());
            String toDate=datefromat.format(datechooserTo.getDate());
            
            Float amountTotal=0.0f;
        try {
          Connection con=DBConnection.getConnection();
          PreparedStatement pst=con.prepareStatement("select * from fees_details where date between ? and ? and courses = ?");
          pst.setString(1, fromDate);
          pst.setString(2, toDate);
          pst.setString(3, cname);
          ResultSet rs=  pst.executeQuery();
          while(rs.next())
          {
           String receiptNo=rs.getString("reciept_no");
           String RollNo=rs.getString("roll_no");
           String studetName=rs.getString("student_name");
           String CourseName=rs.getString("courses");
           float amount=rs.getFloat("total_amount");
           String remark=rs.getString("remark");
           
           amountTotal=amountTotal + amount;
          
           
           Object[] obj={receiptNo,RollNo,studetName,CourseName,amount,remark};
            model=(DefaultTableModel)tbl_fees_details.getModel();
            model.addRow(obj);
          }
          lbl_Course.setText(cname);
          lbl_totalamount.setText(amountTotal.toString());
         lbl_total_in_word.setText(NumberToWordsConverter.convert(amountTotal.intValue()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
         public void clearTable(){
           DefaultTableModel model=(DefaultTableModel)tbl_fees_details.getModel();
           model.setRowCount(1);
       }
         
         public void exportToExcel(){
             XSSFWorkbook wb=new XSSFWorkbook();
        XSSFSheet ws = wb.createSheet();
        DefaultTableModel model=(DefaultTableModel)tbl_fees_details.getModel();
        TreeMap<String,Object[]>map=new TreeMap<>();
        map.put("0", new Object[]{model.getColumnName(0),model.getColumnName(1),model.getColumnName(2),
        model.getColumnName(3),model.getColumnName(4),model.getColumnName(5)});
        
             for (int i = 1; i < model.getRowCount(); i++) {
                 map.put(Integer.toString(i), new Object[]{model.getValueAt(i, 0),model.getValueAt(i, 1),model.getValueAt(i, 2),
                 model.getValueAt(i, 3),model.getValueAt(i, 4),model.getValueAt(i, 5)});
             }
             Set<String> id=map.keySet();

             XSSFRow frow;

             int rowId=0;
             
            for(String key:id){
                
                frow=ws.createRow(rowId++);
                
                Object[] value=map.get(key);
                
                int cellId=0;
                
                for(Object object:value){
                    XSSFCell cell=frow.createCell(cellId++);
                    cell.setCellValue(object.toString());
                }
             }
             try (FileOutputStream fos=new FileOutputStream(new File(txt_filepath.getText()))){
                
                wb.write(fos);
                 JOptionPane.showMessageDialog(this, "file exported Successfully"+txt_filepath.getText());
                fos.close();
             } catch (Exception e) 
             {
                 e.printStackTrace();
             }
             
            
         }
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panal_sidebar = new javax.swing.JPanel();
        Panal_search = new javax.swing.JPanel();
        btn_searchrecord = new javax.swing.JLabel();
        Panal_Edit = new javax.swing.JPanel();
        btn_Edit = new javax.swing.JLabel();
        Panal_courselist = new javax.swing.JPanel();
        btn_Courcelist = new javax.swing.JLabel();
        Panal_logout = new javax.swing.JPanel();
        btn_logout = new javax.swing.JLabel();
        Panal_home = new javax.swing.JPanel();
        btn_home = new javax.swing.JLabel();
        Panal_Allrecord = new javax.swing.JPanel();
        btn_Allrecord = new javax.swing.JLabel();
        Panal_back = new javax.swing.JPanel();
        btn_back = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        combo_course_details = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        datechooserTo = new com.toedter.calendar.JDateChooser();
        datechooserFrom = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txt_filepath = new javax.swing.JTextField();
        Print = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_fees_details = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbl_totalamount = new javax.swing.JLabel();
        lbl_Course = new javax.swing.JLabel();
        lbl_total_in_word = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panal_sidebar.setBackground(new java.awt.Color(0, 102, 102));
        Panal_sidebar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panal_search.setBackground(new java.awt.Color(0, 102, 102));
        Panal_search.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        Panal_search.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_searchrecord.setFont(new java.awt.Font("Sylfaen", 0, 30)); // NOI18N
        btn_searchrecord.setForeground(new java.awt.Color(255, 255, 255));
        btn_searchrecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system_1/images/search2.png"))); // NOI18N
        btn_searchrecord.setText(" Search Record");
        btn_searchrecord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_searchrecordMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_searchrecordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_searchrecordMouseExited(evt);
            }
        });
        Panal_search.add(btn_searchrecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 280, -1));

        Panal_sidebar.add(Panal_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 320, 70));

        Panal_Edit.setBackground(new java.awt.Color(0, 102, 102));
        Panal_Edit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        Panal_Edit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_Edit.setFont(new java.awt.Font("Sylfaen", 0, 30)); // NOI18N
        btn_Edit.setForeground(new java.awt.Color(255, 255, 255));
        btn_Edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system_1/images/edit2.png"))); // NOI18N
        btn_Edit.setText(" Edit Course");
        btn_Edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_EditMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_EditMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_EditMouseExited(evt);
            }
        });
        Panal_Edit.add(btn_Edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 280, -1));

        Panal_sidebar.add(Panal_Edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 320, 70));

        Panal_courselist.setBackground(new java.awt.Color(0, 102, 102));
        Panal_courselist.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        Panal_courselist.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_Courcelist.setFont(new java.awt.Font("Sylfaen", 0, 30)); // NOI18N
        btn_Courcelist.setForeground(new java.awt.Color(255, 255, 255));
        btn_Courcelist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system_1/images/list_1.png"))); // NOI18N
        btn_Courcelist.setText(" Course List");
        btn_Courcelist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_CourcelistMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_CourcelistMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_CourcelistMouseExited(evt);
            }
        });
        Panal_courselist.add(btn_Courcelist, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 280, -1));

        Panal_sidebar.add(Panal_courselist, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 320, 70));

        Panal_logout.setBackground(new java.awt.Color(0, 102, 102));
        Panal_logout.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        Panal_logout.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_logout.setFont(new java.awt.Font("Sylfaen", 0, 30)); // NOI18N
        btn_logout.setForeground(new java.awt.Color(255, 255, 255));
        btn_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system_1/images/logout.png"))); // NOI18N
        btn_logout.setText("Logout");
        btn_logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_logoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_logoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_logoutMouseExited(evt);
            }
        });
        Panal_logout.add(btn_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 280, -1));

        Panal_sidebar.add(Panal_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 560, 320, 70));

        Panal_home.setBackground(new java.awt.Color(0, 102, 102));
        Panal_home.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        Panal_home.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_home.setFont(new java.awt.Font("Sylfaen", 0, 30)); // NOI18N
        btn_home.setForeground(new java.awt.Color(255, 255, 255));
        btn_home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system_1/images/home.png"))); // NOI18N
        btn_home.setText(" Home");
        btn_home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_homeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_homeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_homeMouseExited(evt);
            }
        });
        Panal_home.add(btn_home, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 280, -1));

        Panal_sidebar.add(Panal_home, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 320, 70));

        Panal_Allrecord.setBackground(new java.awt.Color(0, 102, 102));
        Panal_Allrecord.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        Panal_Allrecord.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_Allrecord.setFont(new java.awt.Font("Sylfaen", 0, 30)); // NOI18N
        btn_Allrecord.setForeground(new java.awt.Color(255, 255, 255));
        btn_Allrecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system_1/images/view all record.png"))); // NOI18N
        btn_Allrecord.setText(" View All Record");
        btn_Allrecord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_AllrecordMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_AllrecordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_AllrecordMouseExited(evt);
            }
        });
        Panal_Allrecord.add(btn_Allrecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 290, -1));

        Panal_sidebar.add(Panal_Allrecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 320, 70));

        Panal_back.setBackground(new java.awt.Color(0, 102, 102));
        Panal_back.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        Panal_back.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_back.setFont(new java.awt.Font("Sylfaen", 0, 30)); // NOI18N
        btn_back.setForeground(new java.awt.Color(255, 255, 255));
        btn_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system_1/images/left-arrow.png"))); // NOI18N
        btn_back.setText(" Back");
        btn_back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_backMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_backMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_backMouseExited(evt);
            }
        });
        Panal_back.add(btn_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 280, -1));

        Panal_sidebar.add(Panal_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 320, 70));

        getContentPane().add(Panal_sidebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 680));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("From Date:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 90, 30));

        combo_course_details.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jPanel1.add(combo_course_details, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 260, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Select Course:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 110, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("To Date:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, 70, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Select Date:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 100, 30));
        jPanel1.add(datechooserTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 120, 30));
        jPanel1.add(datechooserFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 120, 30));

        jButton1.setBackground(new java.awt.Color(0, 103, 103));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Export To Excel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 200, -1, 30));

        jButton2.setBackground(new java.awt.Color(0, 103, 103));
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Submit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, 30));

        txt_filepath.setText("jTextField1");
        jPanel1.add(txt_filepath, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 280, 30));

        Print.setBackground(new java.awt.Color(0, 103, 103));
        Print.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        Print.setForeground(new java.awt.Color(255, 255, 255));
        Print.setText("Print");
        Print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintActionPerformed(evt);
            }
        });
        jPanel1.add(Print, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, -1, 30));

        jButton3.setBackground(new java.awt.Color(0, 103, 103));
        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Browse");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, -1, 30));

        tbl_fees_details.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Receipt No", "Roll No", "Student Name", "Course Name", "Amount", "Remark"
            }
        ));
        jScrollPane1.setViewportView(tbl_fees_details);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 270, 800, 370));

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Total Amount in words:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 180, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Total amount Collected:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 190, 30));

        lbl_totalamount.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        lbl_totalamount.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lbl_totalamount, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 150, 30));

        lbl_Course.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        lbl_Course.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lbl_Course, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 150, 30));

        lbl_total_in_word.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        lbl_total_in_word.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lbl_total_in_word, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 340, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Course Selected:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, 360, 170));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 900, 680));

        setSize(new java.awt.Dimension(1294, 687));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_searchrecordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_searchrecordMouseClicked
        Search_Record sr=new Search_Record();
        sr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_searchrecordMouseClicked

    private void btn_searchrecordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_searchrecordMouseEntered
        Color clr=new Color(0,153,153);
        Panal_search.setBackground(clr);
    }//GEN-LAST:event_btn_searchrecordMouseEntered

    private void btn_searchrecordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_searchrecordMouseExited
        Color clr=new Color(0,103,103);
        Panal_search.setBackground(clr);
    }//GEN-LAST:event_btn_searchrecordMouseExited

    private void btn_EditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_EditMouseClicked
        Edit_Course ed=new Edit_Course();
        ed.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_EditMouseClicked

    private void btn_EditMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_EditMouseEntered
        Color clr=new Color(0,153,153);
        Panal_Edit.setBackground(clr);
    }//GEN-LAST:event_btn_EditMouseEntered

    private void btn_EditMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_EditMouseExited
        Color clr=new Color(0,103,103);
        Panal_Edit.setBackground(clr);
    }//GEN-LAST:event_btn_EditMouseExited

    private void btn_CourcelistMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_CourcelistMouseEntered
        Color clr=new Color(0,153,153);
        Panal_courselist.setBackground(clr);
    }//GEN-LAST:event_btn_CourcelistMouseEntered

    private void btn_CourcelistMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_CourcelistMouseExited
        Color clr=new Color(0,103,103);
        Panal_courselist.setBackground(clr);
    }//GEN-LAST:event_btn_CourcelistMouseExited

    private void btn_logoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_logoutMouseEntered
        Color clr=new Color(0,153,153);
        Panal_logout.setBackground(clr);
    }//GEN-LAST:event_btn_logoutMouseEntered

    private void btn_logoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_logoutMouseExited
        Color clr=new Color(0,103,103);
        Panal_logout.setBackground(clr);
    }//GEN-LAST:event_btn_logoutMouseExited

    private void btn_homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_homeMouseClicked
        Home_Page hp=new Home_Page();
        hp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_homeMouseClicked

    private void btn_homeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_homeMouseEntered
        Color clr=new Color(0,153,153);
        Panal_home.setBackground(clr);
    }//GEN-LAST:event_btn_homeMouseEntered

    private void btn_homeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_homeMouseExited
        Color clr=new Color(0,103,103);
        Panal_home.setBackground(clr);
    }//GEN-LAST:event_btn_homeMouseExited

    private void btn_AllrecordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_AllrecordMouseEntered
        Color clr=new Color(0,153,153);
        Panal_Allrecord.setBackground(clr);
    }//GEN-LAST:event_btn_AllrecordMouseEntered

    private void btn_AllrecordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_AllrecordMouseExited
        Color clr=new Color(0,103,103);
        Panal_Allrecord.setBackground(clr);
    }//GEN-LAST:event_btn_AllrecordMouseExited

    private void btn_backMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_backMouseEntered
        Color clr=new Color(0,153,153);
        Panal_back.setBackground(clr);
    }//GEN-LAST:event_btn_backMouseEntered

    private void btn_backMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_backMouseExited
        Color clr=new Color(0,103,103);
        Panal_back.setBackground(clr);
    }//GEN-LAST:event_btn_backMouseExited

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        exportToExcel();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       JFileChooser filechooser=new JFileChooser();
       filechooser.showOpenDialog(this);
       
        SimpleDateFormat dateformate=new SimpleDateFormat("YYYY-MM-dd");
        String date=dateformate.format(new Date());
        
        try {
            File f=filechooser.getSelectedFile();
            String path=f.getAbsolutePath();
            path=path+ "-"+date+".xlsx";
            txt_filepath.setText(path);
                    
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
               
               
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       clearTable();
        setRecordsTOTable();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void PrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintActionPerformed
             SimpleDateFormat Date_Format = new SimpleDateFormat("YYYY-MM-dd"); 
        String datefrom=  Date_Format.format(datechooserFrom.getDate());
      String dateto=  Date_Format.format(datechooserTo.getDate());
       
        MessageFormat header=new MessageFormat("Report From "+datefrom+" To " +dateto);
MessageFormat footer=new MessageFormat("page{0,number,integer}");
        try {
            tbl_fees_details.print(JTable.PrintMode.FIT_WIDTH, header, footer);
            
        } catch (Exception e) {
            e.getMessage();
        } 

    }//GEN-LAST:event_PrintActionPerformed

    private void btn_AllrecordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_AllrecordMouseClicked
       View_All_Record var=new View_All_Record();
       var.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btn_AllrecordMouseClicked

    private void btn_backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_backMouseClicked
            Home_Page hm=new Home_Page();
            hm.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_btn_backMouseClicked

    private void btn_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_logoutMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btn_logoutMouseClicked

    private void btn_CourcelistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_CourcelistMouseClicked
       View_courses vc=new View_courses();
       vc.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btn_CourcelistMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Genrate_Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Genrate_Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Genrate_Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Genrate_Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Genrate_Report().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panal_Allrecord;
    private javax.swing.JPanel Panal_Edit;
    private javax.swing.JPanel Panal_back;
    private javax.swing.JPanel Panal_courselist;
    private javax.swing.JPanel Panal_home;
    private javax.swing.JPanel Panal_logout;
    private javax.swing.JPanel Panal_search;
    private javax.swing.JPanel Panal_sidebar;
    private javax.swing.JButton Print;
    private javax.swing.JLabel btn_Allrecord;
    private javax.swing.JLabel btn_Courcelist;
    private javax.swing.JLabel btn_Edit;
    private javax.swing.JLabel btn_back;
    private javax.swing.JLabel btn_home;
    private javax.swing.JLabel btn_logout;
    private javax.swing.JLabel btn_searchrecord;
    private javax.swing.JComboBox<String> combo_course_details;
    private com.toedter.calendar.JDateChooser datechooserFrom;
    private com.toedter.calendar.JDateChooser datechooserTo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_Course;
    private javax.swing.JLabel lbl_total_in_word;
    private javax.swing.JLabel lbl_totalamount;
    private javax.swing.JTable tbl_fees_details;
    private javax.swing.JTextField txt_filepath;
    // End of variables declaration//GEN-END:variables
}
