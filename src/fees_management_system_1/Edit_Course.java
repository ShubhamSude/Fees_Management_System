/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fees_management_system_1;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author shubham
 */
public class Edit_Course extends javax.swing.JFrame {

    DefaultTableModel model;
    public Edit_Course() {
        initComponents();
        setRecordsTOTable();
    }

     public void setRecordsTOTable(){
        try {
          Connection con=DBConnection.getConnection();
          PreparedStatement pst=con.prepareStatement("select * from course");
          ResultSet rs=  pst.executeQuery();
          while(rs.next())
          {
           String CouseId=rs.getString("Id");
           String CouseName=rs.getString("CNAME");
           String CousePrice=rs.getString("COST");
          
           
           Object[] obj={CouseId,CouseName,CousePrice};
            model=(DefaultTableModel)tbl_course_data.getModel();
            model.addRow(obj);
          }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
       public void clearTable(){
           DefaultTableModel model=(DefaultTableModel)tbl_course_data.getModel();
           model.setRowCount(0);
       }
     
     public void addCouse(int Id,String Cname,double cost)
     {
         try {
             Connection con=DBConnection.getConnection();
             PreparedStatement pst=con.prepareStatement("insert into course values(?,?,?)");
             pst.setInt(1, Id);
             pst.setString(2, Cname);
             pst.setDouble(3, cost);
             
             int rowCount =pst.executeUpdate();
             if(rowCount == 1){
                 JOptionPane.showMessageDialog(this, "Course Added Successfully");
                 clearTable();
                   setRecordsTOTable();
             }
             else
             {
                 JOptionPane.showMessageDialog(this, "Course added Failed");
             }
         } catch (Exception e) {
             JOptionPane.showMessageDialog(this, "Course added Failed");
             e.printStackTrace();
         }
     }
     
     public void update(int Id,String CName,double Cost){
      
         try {
             Connection con=DBConnection.getConnection();
             PreparedStatement pst=con.prepareStatement("update course set cname = ?,cost = ? where id = ?");
            
             pst.setString(1, CName);
             pst.setDouble(2, Cost);
              pst.setInt(3, Id);
             
             int rowCount =pst.executeUpdate();
             if(rowCount == 1){
                 JOptionPane.showMessageDialog(this, "Course Updated Successfully");
                 clearTable();
                   setRecordsTOTable();
             }
             else
             {
                 JOptionPane.showMessageDialog(this, "Course Update Failed");
             }
         } catch (Exception e) {
             JOptionPane.showMessageDialog(this, "Course Update Failed");
             e.printStackTrace();
         }
         
     }
     
       public void delete(int Id){
      
         try {
             Connection con=DBConnection.getConnection();
             PreparedStatement pst=con.prepareStatement("delete from course where id = ?");
  
              pst.setInt(1, Id);
             
             int rowCount =pst.executeUpdate();
             if(rowCount == 1){
                 JOptionPane.showMessageDialog(this, "Course Deleted Successfully");
                 clearTable();
                   setRecordsTOTable();
             }
             else
             {
                 JOptionPane.showMessageDialog(this, "Course Delete Failed");
             }
         } catch (Exception e) {
             JOptionPane.showMessageDialog(this, "Course Delete Failed");
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_course_data = new javax.swing.JTable();
        txt_course_id = new javax.swing.JTextField();
        txt_course_price = new javax.swing.JTextField();
        txt_course_name = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();

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

        Panal_sidebar.add(Panal_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 360, 70));

        Panal_Edit.setBackground(new java.awt.Color(0, 102, 102));
        Panal_Edit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        Panal_Edit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_Edit.setFont(new java.awt.Font("Sylfaen", 0, 30)); // NOI18N
        btn_Edit.setForeground(new java.awt.Color(255, 255, 255));
        btn_Edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system_1/images/edit2.png"))); // NOI18N
        btn_Edit.setText(" Edit Course");
        btn_Edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_EditMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_EditMouseExited(evt);
            }
        });
        Panal_Edit.add(btn_Edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 280, -1));

        Panal_sidebar.add(Panal_Edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 360, 70));

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
        Panal_courselist.add(btn_Courcelist, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 280, -1));

        Panal_sidebar.add(Panal_courselist, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 360, 70));

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

        Panal_sidebar.add(Panal_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 560, 360, 70));

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

        Panal_sidebar.add(Panal_home, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 360, 70));

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

        Panal_sidebar.add(Panal_Allrecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 360, 70));

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

        Panal_sidebar.add(Panal_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 360, 70));

        getContentPane().add(Panal_sidebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 0, 410, 680));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_course_data.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        tbl_course_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Course Id", "Course Name", "Course Price"
            }
        ));
        tbl_course_data.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_course_dataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_course_data);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 100, 400, 530));

        txt_course_id.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jPanel1.add(txt_course_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 190, -1));

        txt_course_price.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jPanel1.add(txt_course_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, 190, -1));

        txt_course_name.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        txt_course_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_course_nameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_course_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, 190, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Couse Name:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 110, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Course Price:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, -1, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Edit Course Details");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 260, 30));

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system_1/images/update.png"))); // NOI18N
        jButton1.setText("UPDATE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 460, -1, 40));

        jButton2.setBackground(new java.awt.Color(0, 102, 102));
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system_1/images/delete.png"))); // NOI18N
        jButton2.setText("DELETE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 460, -1, -1));

        jButton3.setBackground(new java.awt.Color(0, 102, 102));
        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system_1/images/add2.png"))); // NOI18N
        jButton3.setText("ADD");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, -1, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Course Id:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 80, 30));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, 330, 10));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system_1/images/back1.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 70, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 680));

        setSize(new java.awt.Dimension(1274, 687));
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

    private void txt_course_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_course_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_course_nameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       int Id=Integer.parseInt(txt_course_id.getText());
       String cname=txt_course_name.getText();
       double cost=Double.parseDouble(txt_course_price.getText());
       
        update(Id, cname, cost);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         int Id=Integer.parseInt(txt_course_id.getText());
       
        delete(Id);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       int Id=Integer.parseInt(txt_course_id.getText());
       String cname=txt_course_name.getText();
       double cost=Double.parseDouble(txt_course_price.getText());
       
        addCouse(Id, cname, cost);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tbl_course_dataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_course_dataMouseClicked
        int rowNo=tbl_course_data.getSelectedRow();
        TableModel model=tbl_course_data.getModel();
        
        txt_course_id.setText(model.getValueAt(rowNo, 0).toString());
        txt_course_name.setText((String)model.getValueAt(rowNo, 1));
        txt_course_price.setText((String)model.getValueAt(rowNo, 2));
    }//GEN-LAST:event_tbl_course_dataMouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        Home_Page hm=new Home_Page();
        hm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

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
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Edit_Course.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Edit_Course.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Edit_Course.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Edit_Course.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Edit_Course().setVisible(true);
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
    private javax.swing.JLabel btn_Allrecord;
    private javax.swing.JLabel btn_Courcelist;
    private javax.swing.JLabel btn_Edit;
    private javax.swing.JLabel btn_back;
    private javax.swing.JLabel btn_home;
    private javax.swing.JLabel btn_logout;
    private javax.swing.JLabel btn_searchrecord;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tbl_course_data;
    private javax.swing.JTextField txt_course_id;
    private javax.swing.JTextField txt_course_name;
    private javax.swing.JTextField txt_course_price;
    // End of variables declaration//GEN-END:variables
}
