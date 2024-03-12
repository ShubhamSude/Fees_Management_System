/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fees_management_system_1;

import java.awt.Color;
import javax.swing.JOptionPane;
import java.sql.*;
import java.text.SimpleDateFormat;

/**
 *
 * @author shubham
 */
public class AddFees extends javax.swing.JFrame {

    /**
     * Creates new form AddFees
     */
    public AddFees() {
        initComponents();
         DisplayCashFirst();
         fillComboBox();
         
         int receiptNo = getReceiptNo();
         txt_Reciptno.setText(Integer.toString(receiptNo));
        }
    
      public void DisplayCashFirst()
        {
            lbl_ddno.setVisible(false);
            lbl_chequeno.setVisible(false);
            lbl_bankname.setVisible(false);
            
            txt_ddno.setVisible(false);
            txt_Chequeno.setVisible(false);
            txt_bankname.setVisible(false);
       }
     
      
      public boolean Validation(){
          if(txt_recivedfrom.getText().equals("")){
              JOptionPane.showMessageDialog(this, "Plaese enter user name");
          return false;
          }
          
          if(Date_Chooler.getDate() ==null)
          {
              JOptionPane.showMessageDialog(this, "Plaese select the date");
              return false;
          }
          
           if(txt_Amount.getText().equals("") || txt_Amount.getText().matches("[0-9]+")==false){
              JOptionPane.showMessageDialog(this, "Plaese enter amount(in number)");
          return false;
          }
           
           if(Combo_Payemntmode.getSelectedItem().toString().equalsIgnoreCase("cheque"))
           {
               if(txt_Chequeno.getText().equals(""))
               {
                  JOptionPane.showMessageDialog(this, "Plaese enter Cheque number");
                 return false;   
               }
               
               if(txt_bankname.getText().equals(""))
               {
                  JOptionPane.showMessageDialog(this, "Plaese enter bank name");
                 return false;   
               }
           }
           
           if(Combo_Payemntmode.getSelectedItem().toString().equalsIgnoreCase("dd"))
           {
               if(txt_ddno.getText().equals(""))
               {
                 JOptionPane.showMessageDialog(this, "Plaese enter dd number");
                 return false;   
               }
               if(txt_bankname.getText().equals(""))
               {
                  JOptionPane.showMessageDialog(this, "Plaese enter bank name");
                 return false;   
               }
               
           }
           
          if(Combo_Payemntmode.getSelectedItem().toString().equalsIgnoreCase("Card"))
           {
              if(txt_bankname.getText().equals(""))
               {
                  JOptionPane.showMessageDialog(this, "Plaese enter bank name");
                 return false;   
               }
               
           }
          return true;
      }
      
      public void fillComboBox(){
          try 
          {   Class.forName("com.mysql.cj.jdbc.Driver");
              Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fees_management", "root", "Shubhu@2001");
              PreparedStatement ptmt=con.prepareStatement("select cname from course");
                 ResultSet rs= ptmt.executeQuery();
                 
                 while(rs.next())
                 {
                     combo_Course.addItem(rs.getString("cname"));
                 }
          } catch (Exception e) 
          {
              e.printStackTrace();
              e.toString();
             // System.out.println("");
          }
      }
      
      public int getReceiptNo(){
          int receiptNo = 0;
          try {
              Connection con=DBConnection.getConnection();
              PreparedStatement pst=con.prepareStatement("select max(reciept_no) from fees_details");
             ResultSet rs=pst.executeQuery();
             if(rs.next()== true)
             {
               receiptNo = rs.getInt(1);
             }
          
          } catch (Exception e) {
              e.printStackTrace();
          }
          return receiptNo+1;
      }
      
      public String insertData(){
          String status="";
          
          int recieptNo=Integer.parseInt(txt_Reciptno.getText());
          String studentName=txt_recivedfrom.getText();
          String rollNo=(txt_rollNo.getText());
          String paymentMode=Combo_Payemntmode.getSelectedItem().toString();
          String chequeNo=(txt_Chequeno.getText());
          String bankName=txt_bankname.getText();
          String ddNo=(txt_ddno.getText());
          String courseName=txt_Coursename.getText();
          String gstin=(txt_gstno.getText());
          float totalAmount=Float.parseFloat(txt_Total.getText());
          SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
          String date=dateFormat.format(Date_Chooler.getDate());
          float initialAmount=Float.parseFloat(txt_Amount.getText());
          float cgst=Float.parseFloat(txt_CGST.getText());
          float sgst=Float.parseFloat(txt_SGST.getText());
          String totalInWord=txt_totainwords.getText();
          String remark=txt_remark.getText();
          int year1=Integer.parseInt(txt_year1.getText());
          int year2=Integer.parseInt(txt_Year2.getText());
          
          try {
              Connection con=DBConnection.getConnection();
              PreparedStatement pst=con.prepareStatement("insert into fees_details values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
              pst.setInt(1, recieptNo);
              pst.setString(2, studentName);
              pst.setString(3, rollNo);
              pst.setString(4, paymentMode);
              pst.setString(5, chequeNo);
              pst.setString(6, bankName);
              pst.setString(7, ddNo);
              pst.setString(8, courseName);
              pst.setString(9, gstin);
              pst.setFloat(10, totalAmount);
              pst.setString(11, date);
              pst.setFloat(12, initialAmount);
              pst.setFloat(13, cgst);    
              pst.setFloat(14, sgst); 
              pst.setString(15, totalInWord);
              pst.setString(16, remark);
              pst.setInt(17, year1);
              pst.setInt(18, year2);
              
              int rowCount=pst.executeUpdate();
              if(rowCount== 1)
              {
                  status="Success";
              }
              else
              {
                  status="Failed";
              }
          } catch (Exception e) {
              e.printStackTrace();
          }
        return status;
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
        Panal_Parent = new javax.swing.JPanel();
        lbl_bankname = new javax.swing.JLabel();
        lbl_ddno = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_gstno = new javax.swing.JLabel();
        lbl_chequeno = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_Reciptno = new javax.swing.JTextField();
        txt_ddno = new javax.swing.JTextField();
        txt_Chequeno = new javax.swing.JTextField();
        Date_Chooler = new com.toedter.calendar.JDateChooser();
        Panel_child = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_rollNo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_totainwords = new javax.swing.JTextField();
        combo_Course = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txt_year1 = new javax.swing.JTextField();
        txt_Coursename = new javax.swing.JTextField();
        txt_CGST = new javax.swing.JTextField();
        txt_Amount = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        txt_SGST = new javax.swing.JTextField();
        txt_Total = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_remark = new javax.swing.JTextArea();
        jLabel19 = new javax.swing.JLabel();
        btn_Print = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txt_Year2 = new javax.swing.JTextField();
        Combo_Payemntmode = new javax.swing.JComboBox<>();
        txt_bankname = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_recivedfrom = new javax.swing.JTextField();

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
        Panal_search.add(btn_searchrecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 280, -1));

        Panal_sidebar.add(Panal_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 360, 70));

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
        Panal_Edit.add(btn_Edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 280, -1));

        Panal_sidebar.add(Panal_Edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 360, 70));

        Panal_courselist.setBackground(new java.awt.Color(0, 102, 102));
        Panal_courselist.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        Panal_courselist.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_Courcelist.setFont(new java.awt.Font("Sylfaen", 0, 30)); // NOI18N
        btn_Courcelist.setForeground(new java.awt.Color(255, 255, 255));
        btn_Courcelist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system_1/images/list_1.png"))); // NOI18N
        btn_Courcelist.setText(" Course List");
        btn_Courcelist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_CourcelistMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_CourcelistMouseExited(evt);
            }
        });
        Panal_courselist.add(btn_Courcelist, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 280, -1));

        Panal_sidebar.add(Panal_courselist, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 360, 70));

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
        Panal_logout.add(btn_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 280, -1));

        Panal_sidebar.add(Panal_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 560, 360, 70));

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
        Panal_home.add(btn_home, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 280, -1));

        Panal_sidebar.add(Panal_home, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 360, 70));

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
        Panal_Allrecord.add(btn_Allrecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 290, -1));

        Panal_sidebar.add(Panal_Allrecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 360, 70));

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
        Panal_back.add(btn_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 280, -1));

        Panal_sidebar.add(Panal_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, 360, 70));

        getContentPane().add(Panal_sidebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 680));
        Panal_sidebar.getAccessibleContext().setAccessibleName("");
        Panal_sidebar.getAccessibleContext().setAccessibleDescription("");

        Panal_Parent.setBackground(new java.awt.Color(0, 152, 152));
        Panal_Parent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_bankname.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_bankname.setText("Bank Name:");
        Panal_Parent.add(lbl_bankname, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        lbl_ddno.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_ddno.setText("DD no:");
        Panal_Parent.add(lbl_ddno, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Mode of Payment:");
        Panal_Parent.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        txt_gstno.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_gstno.setText("22SVSM234");
        Panal_Parent.add(txt_gstno, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 70, -1, -1));

        lbl_chequeno.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_chequeno.setText("Cheque no:");
        Panal_Parent.add(lbl_chequeno, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Reciept no: COE.");
        Panal_Parent.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("Date:  ");
        Panal_Parent.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 30, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("GSTIN:");
        Panal_Parent.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 70, -1, -1));

        txt_Reciptno.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        Panal_Parent.add(txt_Reciptno, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 140, -1));

        txt_ddno.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        Panal_Parent.add(txt_ddno, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 140, -1));

        txt_Chequeno.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        Panal_Parent.add(txt_Chequeno, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 140, -1));
        Panal_Parent.add(Date_Chooler, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 30, 170, 30));

        Panel_child.setBackground(new java.awt.Color(0, 152, 152));
        Panel_child.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("to");
        Panel_child.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("The following Payment the college office for the year:");
        Panel_child.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, 30));

        txt_rollNo.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        txt_rollNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_rollNoActionPerformed(evt);
            }
        });
        Panel_child.add(txt_rollNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 60, 100, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setText("Roll No:");
        Panel_child.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 60, -1, -1));

        txt_totainwords.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        txt_totainwords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_totainwordsActionPerformed(evt);
            }
        });
        Panel_child.add(txt_totainwords, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 390, 30));

        combo_Course.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        combo_Course.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_CourseActionPerformed(evt);
            }
        });
        Panel_child.add(combo_Course, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 350, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setText("Amount");
        Panel_child.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 110, -1, 30));
        Panel_child.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 320, 230, 20));
        Panel_child.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 820, 10));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setText("Course:");
        Panel_child.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel15.setText("Receiver Signature");
        Panel_child.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 320, -1, 30));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setText("Head");
        Panel_child.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, -1, 30));

        txt_year1.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        txt_year1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_year1ActionPerformed(evt);
            }
        });
        Panel_child.add(txt_year1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 100, -1));

        txt_Coursename.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        txt_Coursename.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CoursenameActionPerformed(evt);
            }
        });
        Panel_child.add(txt_Coursename, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 380, 30));

        txt_CGST.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        txt_CGST.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CGSTActionPerformed(evt);
            }
        });
        Panel_child.add(txt_CGST, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 190, 170, 30));

        txt_Amount.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        txt_Amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_AmountActionPerformed(evt);
            }
        });
        Panel_child.add(txt_Amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 150, 170, 30));
        Panel_child.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 820, 20));

        txt_SGST.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        txt_SGST.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_SGSTActionPerformed(evt);
            }
        });
        Panel_child.add(txt_SGST, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 230, 170, 30));

        txt_Total.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        txt_Total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_TotalActionPerformed(evt);
            }
        });
        Panel_child.add(txt_Total, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 280, 170, 30));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel17.setText("Sr No");
        Panel_child.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, 30));
        Panel_child.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 270, 230, 20));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel18.setText("Total in words:");
        Panel_child.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, 30));

        txt_remark.setColumns(20);
        txt_remark.setRows(5);
        jScrollPane1.setViewportView(txt_remark);

        Panel_child.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, 390, 60));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel19.setText("CGST 9%");
        Panel_child.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, -1, 30));

        btn_Print.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        btn_Print.setText("Print");
        btn_Print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_PrintActionPerformed(evt);
            }
        });
        Panel_child.add(btn_Print, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 380, -1, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel20.setText("SGST 9%");
        Panel_child.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, -1, 30));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel21.setText("Remarks:");
        Panel_child.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, 30));

        txt_Year2.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        txt_Year2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Year2ActionPerformed(evt);
            }
        });
        Panel_child.add(txt_Year2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 10, 100, -1));

        Panal_Parent.add(Panel_child, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 850, 460));

        Combo_Payemntmode.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        Combo_Payemntmode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DD", "Cheque", "Cash", "Card" }));
        Combo_Payemntmode.setSelectedIndex(2);
        Combo_Payemntmode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Combo_PayemntmodeActionPerformed(evt);
            }
        });
        Panal_Parent.add(Combo_Payemntmode, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 140, 30));

        txt_bankname.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        Panal_Parent.add(txt_bankname, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 140, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setText("Recieved From:");
        Panal_Parent.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        txt_recivedfrom.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        Panal_Parent.add(txt_recivedfrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 360, -1));

        getContentPane().add(Panal_Parent, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 850, -1));
        Panal_Parent.getAccessibleContext().setAccessibleName("");

        setSize(new java.awt.Dimension(1303, 689));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_searchrecordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_searchrecordMouseEntered
       Color clr=new Color(0,153,153);
       Panal_search.setBackground(clr);
    }//GEN-LAST:event_btn_searchrecordMouseEntered

    private void btn_searchrecordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_searchrecordMouseExited
        Color clr=new Color(0,103,103);
       Panal_search.setBackground(clr);
    }//GEN-LAST:event_btn_searchrecordMouseExited

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

    private void txt_rollNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_rollNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_rollNoActionPerformed

    private void txt_totainwordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totainwordsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_totainwordsActionPerformed

    private void txt_year1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_year1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_year1ActionPerformed

    private void txt_CoursenameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CoursenameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CoursenameActionPerformed

    private void txt_CGSTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CGSTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CGSTActionPerformed

    private void txt_AmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_AmountActionPerformed

     Float amnt=Float.parseFloat(txt_Amount.getText());
     Float cgst=(float)(amnt *0.09);
     Float sgst=(float)(amnt *0.09);
     
     txt_CGST.setText(cgst.toString());
     txt_SGST.setText(sgst.toString());
     
     float total =amnt + cgst + sgst;
     txt_Total.setText(Float.toString(total));
     
     txt_totainwords.setText(NumberToWordsConverter.convert((int)total)+" only");
    }//GEN-LAST:event_txt_AmountActionPerformed

    private void txt_SGSTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_SGSTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_SGSTActionPerformed

    private void txt_TotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_TotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TotalActionPerformed

    private void Combo_PayemntmodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Combo_PayemntmodeActionPerformed
       
        if(Combo_Payemntmode.getSelectedIndex() == 0)
        {
            lbl_ddno.setVisible(true);
            txt_ddno.setVisible(true);
            lbl_chequeno.setVisible(false);
            txt_Chequeno.setVisible(false);
            lbl_bankname.setVisible(true);
            txt_bankname.setVisible(true);
        }
        
         if(Combo_Payemntmode.getSelectedIndex() == 1)
        {
            lbl_ddno.setVisible(false);
            txt_ddno.setVisible(false);
            lbl_chequeno.setVisible(true);
            txt_Chequeno.setVisible(true);
            lbl_bankname.setVisible(true);
            txt_bankname.setVisible(true);
        }
         
          if(Combo_Payemntmode.getSelectedIndex() == 2)
        {
            lbl_ddno.setVisible(false);
            txt_ddno.setVisible(false);
            lbl_chequeno.setVisible(false);
            txt_Chequeno.setVisible(false);
            lbl_bankname.setVisible(false);
            txt_bankname.setVisible(false);
        }
          
           if(Combo_Payemntmode.getSelectedItem().equals("Card"))
        {
            lbl_ddno.setVisible(false);
            txt_ddno.setVisible(false);
            lbl_chequeno.setVisible(false);
            txt_Chequeno.setVisible(false);
            lbl_bankname.setVisible(true);
            txt_bankname.setVisible(true);
        }
    }//GEN-LAST:event_Combo_PayemntmodeActionPerformed

    private void btn_PrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_PrintActionPerformed
        if(Validation()==true)
        {
           String result=insertData();
           if(result.equals("Success"))
           {
               JOptionPane.showMessageDialog(this, "record inserted Successfully");
               Print_Receipt pr=new Print_Receipt();
               pr.setVisible(true);
               this.dispose();
           }
           else
           {
               JOptionPane.showMessageDialog(this, "record insertion failed");
           }
        }
    }//GEN-LAST:event_btn_PrintActionPerformed

    private void combo_CourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_CourseActionPerformed
       txt_Coursename.setText(combo_Course.getSelectedItem().toString());
    }//GEN-LAST:event_combo_CourseActionPerformed

    private void txt_Year2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Year2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Year2ActionPerformed

    private void btn_homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_homeMouseClicked
       Home_Page hm=new Home_Page();
       hm.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btn_homeMouseClicked

    private void btn_searchrecordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_searchrecordMouseClicked
        Search_Record sr=new Search_Record();
                sr.setVisible(true);
                this.dispose();
    }//GEN-LAST:event_btn_searchrecordMouseClicked

    private void btn_EditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_EditMouseClicked
        Edit_Course ed=new Edit_Course();
        ed.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_EditMouseClicked

    private void btn_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_logoutMouseClicked
       System.exit(0);
    }//GEN-LAST:event_btn_logoutMouseClicked

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
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddFees().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Combo_Payemntmode;
    private com.toedter.calendar.JDateChooser Date_Chooler;
    private javax.swing.JPanel Panal_Allrecord;
    private javax.swing.JPanel Panal_Edit;
    private javax.swing.JPanel Panal_Parent;
    private javax.swing.JPanel Panal_back;
    private javax.swing.JPanel Panal_courselist;
    private javax.swing.JPanel Panal_home;
    private javax.swing.JPanel Panal_logout;
    private javax.swing.JPanel Panal_search;
    private javax.swing.JPanel Panal_sidebar;
    private javax.swing.JPanel Panel_child;
    private javax.swing.JLabel btn_Allrecord;
    private javax.swing.JLabel btn_Courcelist;
    private javax.swing.JLabel btn_Edit;
    private javax.swing.JButton btn_Print;
    private javax.swing.JLabel btn_back;
    private javax.swing.JLabel btn_home;
    private javax.swing.JLabel btn_logout;
    private javax.swing.JLabel btn_searchrecord;
    private javax.swing.JComboBox<String> combo_Course;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lbl_bankname;
    private javax.swing.JLabel lbl_chequeno;
    private javax.swing.JLabel lbl_ddno;
    private javax.swing.JTextField txt_Amount;
    private javax.swing.JTextField txt_CGST;
    private javax.swing.JTextField txt_Chequeno;
    private javax.swing.JTextField txt_Coursename;
    private javax.swing.JTextField txt_Reciptno;
    private javax.swing.JTextField txt_SGST;
    private javax.swing.JTextField txt_Total;
    private javax.swing.JTextField txt_Year2;
    private javax.swing.JTextField txt_bankname;
    private javax.swing.JTextField txt_ddno;
    private javax.swing.JLabel txt_gstno;
    private javax.swing.JTextField txt_recivedfrom;
    private javax.swing.JTextArea txt_remark;
    private javax.swing.JTextField txt_rollNo;
    private javax.swing.JTextField txt_totainwords;
    private javax.swing.JTextField txt_year1;
    // End of variables declaration//GEN-END:variables
}
