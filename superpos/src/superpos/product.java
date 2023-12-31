/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package superpos;
import com.mysql.cj.jdbc.result.ResultSetMetaData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.util.Vector;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author shiran
 */
public class product extends javax.swing.JFrame {

  

    /**
     * Creates new form category
     */
    public product() {
        initComponents();
        table_update();
        category ();
         brand ();
    }
    Connection con1;
    PreparedStatement pst;
    
    public class CategoryItem{
        int id;
        String name;
        
        public CategoryItem(int id,String name){
            this.id = id;
            this.name = name;
        }
        
        public String toString(){
            return name;
        }
    }
    
    
    
        public class BrandItem{
        int id;
        String name;
        
        public BrandItem(int id,String name){
            this.id = id;
            this.name = name;
        }
        
        public String toString(){
            return name;
        }
    }
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    private void category (){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
              con1 = DriverManager.getConnection("jdbc:mysql://localhost/superpos","root","");
              pst = con1.prepareStatement("Select * from  category");
              ResultSet rs =   pst.executeQuery();
              txtcat.removeAllItems();
              
              while(rs.next())
                      {
                          txtcat.addItem(new CategoryItem(rs.getInt(1),rs.getString(2)));
                      }
              
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
        private void brand (){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
              con1 = DriverManager.getConnection("jdbc:mysql://localhost/superpos","root","");
              pst = con1.prepareStatement("Select * from  brand");
              ResultSet rs =   pst.executeQuery();
              txtbrand.removeAllItems();
              
              while(rs.next()) 
                      {
                          txtbrand.addItem(new BrandItem(rs.getInt(1),rs.getString(2)));
                      }
              
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    private void table_update(){
        try {
            int c;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con1 = DriverManager.getConnection("jdbc:mysql://localhost/superpos","root","");
                pst = con1.prepareStatement("Select * from   product");
                ResultSet rs =   pst.executeQuery();
                ResultSetMetaData rsd = (ResultSetMetaData) rs.getMetaData();
                c = rsd.getColumnCount();
                DefaultTableModel d = (DefaultTableModel)jTable1.getModel();
                d.setRowCount(0);
                
                
                while(rs.next()){
                    Vector v2 = new Vector();
                    for(int i = 1;i<=c;i++){
                        v2.add(rs.getString("id"));
                        v2.add(rs.getString("product"));
                        v2.add(rs.getString("description"));
                        v2.add(rs.getString("cat_id"));
                        v2.add(rs.getString("brand_id"));
                        v2.add(rs.getString("cost_price"));
                        v2.add(rs.getString("retail_price"));
                        v2.add(rs.getString("qty"));
                        v2.add(rs.getString("barcode"));
                        v2.add(rs.getString("status"));
                    }
                    d.addRow(v2);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtcat = new javax.swing.JComboBox();
        txtpro = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtbrand = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        txtcostp = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtdesc = new javax.swing.JTextField();
        txtretailp = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtqty = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtbarcode = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtstatus = new javax.swing.JComboBox<>();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jScrollPane2.setViewportView(jTextPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 153, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Category");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Brand");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Product");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Pos");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Exit");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Cashier");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Product");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel8.setText("Superpos");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Product", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jLabel9.setText("Product");

        txtcat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcatActionPerformed(evt);
            }
        });

        txtpro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtproActionPerformed(evt);
            }
        });

        jLabel10.setText("Category");

        jLabel11.setText("Description");

        jLabel12.setText("Brand");

        txtbrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbrandActionPerformed(evt);
            }
        });

        jLabel13.setText("Cost price");

        txtcostp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcostpActionPerformed(evt);
            }
        });

        txtdesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdescActionPerformed(evt);
            }
        });
        jScrollPane3.setViewportView(txtdesc);

        jScrollPane4.setViewportView(jScrollPane3);

        txtretailp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtretailpActionPerformed(evt);
            }
        });

        jLabel14.setText("Retail Price");

        jLabel15.setText("Qty");

        txtqty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtqtyActionPerformed(evt);
            }
        });

        jLabel16.setText("Barcode");

        txtbarcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbarcodeActionPerformed(evt);
            }
        });

        jLabel17.setText("Status");

        txtstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Deactiive" }));
        txtstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtstatusActionPerformed(evt);
            }
        });

        jToggleButton1.setText("Add");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jToggleButton2.setText("Edit");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jToggleButton3.setText("Delete");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel13))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel9)
                        .addComponent(jLabel11)
                        .addComponent(jLabel10)
                        .addComponent(jLabel12)))
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtbrand, javax.swing.GroupLayout.Alignment.LEADING, 0, 241, Short.MAX_VALUE)
                    .addComponent(txtcat, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtpro, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtcostp)
                    .addComponent(jScrollPane4))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtretailp)
                            .addComponent(txtqty)
                            .addComponent(txtbarcode)
                            .addComponent(txtstatus, 0, 228, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jToggleButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(203, 203, 203))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtpro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)
                                    .addComponent(txtretailp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(jLabel11))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtqty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtbarcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtcat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(txtstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbrand, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcostp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(41, 41, 41))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jToggleButton1)
                            .addComponent(jToggleButton2)
                            .addComponent(jToggleButton3))
                        .addGap(88, 88, 88))))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "product", "description", "Category", "Brand", "Costprice", "Retail price", "Qty", "Barcode", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1080, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(383, 383, 383)
                        .addComponent(jLabel8)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(19, 19, 19)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(124, Short.MAX_VALUE))
        );

        jPanel2.getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtproActionPerformed
        // TODO add your handling code her
        
       
        
        
    }//GEN-LAST:event_txtproActionPerformed

    private void txtcatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcatActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
         DefaultTableModel d1 = (DefaultTableModel)jTable1.getModel();
         int selectIndex = jTable1.getSelectedRow();
         
         txtpro.setText(d1.getValueAt(selectIndex, 1).toString());
          txtdesc.setText(d1.getValueAt(selectIndex, 2).toString());
           txtcat.setSelectedItem(d1.getValueAt(selectIndex, 3).toString());
            txtbrand.setSelectedItem(d1.getValueAt(selectIndex, 4).toString());
            txtcostp.setText(d1.getValueAt(selectIndex, 5).toString());
             txtretailp.setText(d1.getValueAt(selectIndex, 6).toString());
              txtqty.setText(d1.getValueAt(selectIndex, 7).toString());
               txtbarcode.setText(d1.getValueAt(selectIndex, 8).toString());
                txtstatus.setSelectedItem(d1.getValueAt(selectIndex, 9).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void txtbrandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbrandActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbrandActionPerformed

    private void txtcostpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcostpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcostpActionPerformed

    private void txtdescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdescActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdescActionPerformed

    private void txtretailpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtretailpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtretailpActionPerformed

    private void txtqtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtqtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtqtyActionPerformed

    private void txtbarcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbarcodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbarcodeActionPerformed

    private void txtstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtstatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtstatusActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        // TODO add your handling code here:
        
         DefaultTableModel d1 = (DefaultTableModel)jTable1.getModel();
         int selectIndex = jTable1.getSelectedRow();
      
    
        int id = Integer.parseInt(d1.getValueAt(selectIndex,0).toString());
        
       String product = txtpro.getText();
          String desc = txtdesc.getText();
          CategoryItem citem = (CategoryItem)txtcat.getSelectedItem();
          BrandItem britem = (BrandItem)txtbrand.getSelectedItem();
          String cprice = txtcostp.getText();
          String rprice = txtretailp.getText();
          String qty = txtqty.getText();
          String barcode = txtbarcode.getText();
        String status = txtstatus.getSelectedItem().toString();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
             con1 = DriverManager.getConnection("jdbc:mysql://localhost/superpos","root","");
            pst = con1.prepareStatement("update product set product=?,description=?,cat_id=?,brand_id=?,cost_price=?,retail_price=?,qty=?,barcode=?,status=? where id=?");
            pst.setString(1,product);
            pst.setString(2,desc);
            pst.setInt(3,citem.id);
            pst.setInt(4,britem.id);
            pst.setString(5,cprice);
            pst.setString(6,rprice);
            pst.setString(7,qty);
            pst.setString(8,barcode);
            pst.setString(9,status);
            pst.setInt(10,id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog( null,"product updated");
            table_update();
           
            txtpro.setText("");
            txtdesc.setText("");
            txtcat.setSelectedIndex(-1);
             txtbrand.setSelectedIndex(-1);
             txtcostp.setText("");
            txtretailp.setText("");
            txtqty.setText("");
            txtbarcode.setText("");          
            txtstatus.setSelectedIndex(-1);
            txtpro.requestFocus();
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(brand.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        // TODO add your handling code here:
        
           DefaultTableModel d1 = (DefaultTableModel)jTable1.getModel();
         int selectIndex = jTable1.getSelectedRow(); 
        int id = Integer.parseInt(d1.getValueAt(selectIndex,0).toString());
        int dialogResult = JOptionPane.showConfirmDialog(null,"Do you realy want to delete","warning",JOptionPane.YES_NO_OPTION);
        if(dialogResult == JOptionPane.YES_OPTION)
        {
             try {
                 Class.forName("com.mysql.jdbc.Driver");
                  con1 = DriverManager.getConnection("jdbc:mysql://localhost/superpos","root","");
                pst = con1.prepareStatement("delete from product where id=?");
                pst.setInt(1, id);
                pst.executeUpdate();
                JOptionPane.showMessageDialog( null,"product deleted");
            table_update();
             txtpro.setText("");
            txtdesc.setText("");
            txtcat.setSelectedIndex(-1);
             txtbrand.setSelectedIndex(-1);
             txtcostp.setText("");
            txtretailp.setText("");
            txtqty.setText("");
            txtbarcode.setText("");          
            txtstatus.setSelectedIndex(-1);
            txtpro.requestFocus();
                
             } catch (ClassNotFoundException ex) {
                 Logger.getLogger(brand.class.getName()).log(Level.SEVERE, null, ex);
             } catch (SQLException ex) {
                 Logger.getLogger(brand.class.getName()).log(Level.SEVERE, null, ex);
             }
               
        }
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed

          String product = txtpro.getText();
          String desc = txtdesc.getText();
          CategoryItem citem = (CategoryItem)txtcat.getSelectedItem();
          BrandItem britem = (BrandItem)txtbrand.getSelectedItem();
          String cprice = txtcostp.getText();
          String rprice = txtretailp.getText();
          String qty = txtqty.getText();
          String barcode = txtbarcode.getText();
            
          
        String status = txtstatus.getSelectedItem().toString();
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost/superpos","root","");
            pst = con1.prepareStatement("insert into product (product,description,cat_id,brand_id,cost_price,retail_price,qty,barcode,status) values (?,?,?,?,?,?,?,?,?)");
            pst.setString(1,product);
            pst.setString(2,desc);
            pst.setInt(3,citem.id);
            pst.setInt(4,britem.id);
            pst.setString(5,cprice);
            pst.setString(6,rprice);
            pst.setString(7,qty);
            pst.setString(8,barcode);
            pst.setString(9,status);
            pst.executeUpdate();
            JOptionPane.showMessageDialog( null,"product added");
            table_update();
            txtpro.setText("");
            txtdesc.setText("");
            txtcat.setSelectedIndex(-1);
             txtbrand.setSelectedIndex(-1);
             txtcostp.setText("");
            txtretailp.setText("");
            txtqty.setText("");
            txtbarcode.setText("");          
            txtstatus.setSelectedIndex(-1);
            txtpro.requestFocus();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(brand.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(SQLException ex){
            
        } 

    
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseClicked

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
            java.util.logging.Logger.getLogger(product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new product().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JTextField txtbarcode;
    private javax.swing.JComboBox txtbrand;
    private javax.swing.JComboBox txtcat;
    private javax.swing.JTextField txtcostp;
    private javax.swing.JTextField txtdesc;
    private javax.swing.JTextField txtpro;
    private javax.swing.JTextField txtqty;
    private javax.swing.JTextField txtretailp;
    private javax.swing.JComboBox<String> txtstatus;
    // End of variables declaration//GEN-END:variables
}
