/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.system.view;

import br.com.system.dao.AddressDAO;
import br.com.system.dao.CustomerDAO;
import br.com.system.dao.EmployeeDAO;
import br.com.system.dao.ProductDAO;
import br.com.system.dao.SaleDAO;
import br.com.system.model.Address;
import br.com.system.model.Customer;
import br.com.system.model.Employee;
import br.com.system.model.Payment;
import br.com.system.model.Product;
import br.com.system.model.Sale;
import br.com.system.model.SaleItem;
import java.awt.HeadlessException;
import java.awt.Point;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;

/**
 *
 * @author Moveis Morante
 */
public class MainMenu extends javax.swing.JFrame {
    CustomerDAO customerDAO = new CustomerDAO();
    AddressDAO addressDAO = new AddressDAO();
    EmployeeDAO employeeDAO = new EmployeeDAO();
    ProductDAO productDAO = new ProductDAO();
    SaleDAO saleDAO = new SaleDAO();
    /**
     * Creates new form MainMenu
     */
    public MainMenu() {
        initComponents();
        addCustomerPanel.setVisible(false);
        editCustomerPanel.setVisible(false);
        addSalePanel.setVisible(false);
        addEmployeePanel.setVisible(false);
        editEmployeePanel.setVisible(false);
        addSalePanel.setVisible(false);
      
        
        JScrollBar verticalScrollBar = tabbedPanelScrollPane.getVerticalScrollBar();
        verticalScrollBar.setUnitIncrement(16);
    }
    
    private void setTotalValue() {
        double rowCount = saleItemsTable.getRowCount();
        double totalValue = 0.00;
        String discountStr = applyDiscountField.getText().replace(",", ".");
        
        if(discountStr.isEmpty()) {
            discountStr = "0.00";
        }
        
        double discount = Double.parseDouble(discountStr);

        // Iterar pelas linhas da tabela e somar os valores da coluna 4
        for (int i = 0; i < rowCount; i++) {
            Object valueObject = saleItemsTable.getValueAt(i, 4);
            if (valueObject != null) {
                try {
                    String valueString = valueObject.toString();
                    if (!valueString.isEmpty()) {
                        double value = Double.parseDouble(valueString);
                        totalValue += value;
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Valor inválido na linha " + i + ", coluna 4: " + valueObject);
                }
            }
        }

        double finalValue = totalValue - discount;
        DecimalFormat df = new DecimalFormat("#.00");
        String formattedFinalValue = df.format(finalValue);
        totalValueField.setText(formattedFinalValue);
    }
    
    private void setRemainingAmount() {
        double rowCount = paymentsTable.getRowCount();
        double remainingAmount = Double.parseDouble(totalValueField.getText().replace(",", "."));
    
        for (int i = 0; i < rowCount; i++) {
            Object valueObject = paymentsTable.getValueAt(i, 1);
            if (valueObject != null) {
                try {
                    String valueString = valueObject.toString();
                    if (!valueString.isEmpty()) {
                        double value = Double.parseDouble(valueString);
                        remainingAmount -= value;
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Valor inválido na linha " + i + ", coluna 2: " + valueObject);
                }
            }
        }
        
        DecimalFormat df = new DecimalFormat("#.00");
        String formattedRemainingAmount = df.format(remainingAmount);
        
        remainingAmountField.setText(formattedRemainingAmount);
    }
    
    private void loadCustomersTables() {
    	CustomersTableLoader loader = new CustomersTableLoader(customersTable);
        CustomersTableLoader loader2 = new CustomersTableLoader(customerChoiceTable);
        Thread thread = new Thread(loader);
        Thread thread2 = new Thread(loader2);
        thread.start();
        thread2.start();
    }
    
    private void loadEmployeesTables() {
        EmployeesTableLoader loader = new EmployeesTableLoader(employeesTable);
        Thread thread = new Thread(loader);
        thread.start();
        EmployeesTableLoader loader2 = new EmployeesTableLoader(employeeChoiceTable);
        Thread thread2 = new Thread(loader2);
        thread2.start();
    }
    
    private void loadProductsTables() {
        ProductsTableLoader loader = new ProductsTableLoader(productsTable);
        Thread thread = new Thread(loader);
        thread.start();
        ProductsTableLoader loader2 = new ProductsTableLoader(productChoiceTable);
        Thread thread2 = new Thread(loader2);
        thread2.start();
    }
    
    private void loadSalesTable() {
        SalesTableLoader loader = new SalesTableLoader(salesTable);
        Thread thread = new Thread(loader);
        thread.start();
    }
    
    private boolean validateFields(String name) {
        if (name == null || name.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "O campo Nome é obrigatório.");
            return false;
        }
        return true;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        tabbedPanelScrollPane = new javax.swing.JScrollPane();
        tabbedPane = new javax.swing.JTabbedPane();
        customersPanel = new javax.swing.JPanel();
        editCustomerPanel = new javax.swing.JPanel();
        customerLabelName = new javax.swing.JLabel();
        editCellphoneField = new javax.swing.JFormattedTextField();
        editTellphoneField = new javax.swing.JFormattedTextField();
        editCustomerNameField = new javax.swing.JTextField();
        editCustomerCpfField = new javax.swing.JFormattedTextField();
        customerTellphoneLabel = new javax.swing.JLabel();
        customerCellphoneLabel = new javax.swing.JLabel();
        customerCpfLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        CancelEditCustomerBtn = new javax.swing.JButton();
        submitEditCustomerBtn = new javax.swing.JButton();
        editLogradouroField = new javax.swing.JTextField();
        customerLabelName5 = new javax.swing.JLabel();
        customerLabelName7 = new javax.swing.JLabel();
        editAddressNumberField = new javax.swing.JTextField();
        customerLabelName8 = new javax.swing.JLabel();
        editComplementField = new javax.swing.JTextField();
        customerLabelName11 = new javax.swing.JLabel();
        editBairroField = new javax.swing.JTextField();
        customerLabelName24 = new javax.swing.JLabel();
        editCityField = new javax.swing.JTextField();
        customerLabelName25 = new javax.swing.JLabel();
        editUfField = new javax.swing.JFormattedTextField();
        customerLabelName17 = new javax.swing.JLabel();
        editCustomerIdField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        customersTable = new javax.swing.JTable();
        openAddCustomerPaneBtn = new javax.swing.JButton();
        deleteCustomersBtn = new javax.swing.JButton();
        addCustomerPanel = new javax.swing.JPanel();
        customerLabelName9 = new javax.swing.JLabel();
        addCellphoneField = new javax.swing.JFormattedTextField();
        addTellphoneField = new javax.swing.JFormattedTextField();
        addCustomerNameField = new javax.swing.JTextField();
        addCustomerCpfField = new javax.swing.JFormattedTextField();
        customerTellphoneLabel1 = new javax.swing.JLabel();
        customerCellphoneLabel1 = new javax.swing.JLabel();
        customerCpfLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cancelAddPaymentBtn = new javax.swing.JButton();
        submitAddCustomerBtn = new javax.swing.JButton();
        addLogradouroField = new javax.swing.JTextField();
        customerLabelName13 = new javax.swing.JLabel();
        customerLabelName14 = new javax.swing.JLabel();
        addAddressNumberField = new javax.swing.JTextField();
        customerLabelName15 = new javax.swing.JLabel();
        addComplementField = new javax.swing.JTextField();
        customerLabelName16 = new javax.swing.JLabel();
        addBairroField = new javax.swing.JTextField();
        customerLabelName26 = new javax.swing.JLabel();
        addCityField = new javax.swing.JTextField();
        customerLabelName27 = new javax.swing.JLabel();
        addUfField = new javax.swing.JFormattedTextField();
        openEditCustomerBtn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jLabel18 = new javax.swing.JLabel();
        employeesPanel = new javax.swing.JPanel();
        openAddEmployeePaneBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        employeesTable = new javax.swing.JTable();
        deleteEmployeesBtn = new javax.swing.JButton();
        addEmployeePanel = new javax.swing.JPanel();
        employeeLabelName = new javax.swing.JLabel();
        addEmployeeNameField = new javax.swing.JTextField();
        employeeCpfLabel = new javax.swing.JLabel();
        addEmployeeCpfField = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        cancelAddEmployeeBtn = new javax.swing.JButton();
        submitAddEmployeeBtn = new javax.swing.JButton();
        editEmployeePanel = new javax.swing.JPanel();
        employeeLabelName1 = new javax.swing.JLabel();
        editEmployeeNameField = new javax.swing.JTextField();
        employeeCpfLabel1 = new javax.swing.JLabel();
        editEmployeeCpfField = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        cancelEditEmployeeBtn = new javax.swing.JButton();
        submitEditEmployeeBtn = new javax.swing.JButton();
        editEmployeeIdField = new javax.swing.JTextField();
        customerLabelName39 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        openEditEmployeePanelBtn = new javax.swing.JButton();
        inventoryPanel = new javax.swing.JPanel();
        addProductPanel = new javax.swing.JPanel();
        customerLabelName34 = new javax.swing.JLabel();
        addDescriptionField = new javax.swing.JTextField();
        customerLabelName35 = new javax.swing.JLabel();
        customerLabelName36 = new javax.swing.JLabel();
        customerLabelName37 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cancelAddProductBtn = new javax.swing.JButton();
        submitAddProductBtn = new javax.swing.JButton();
        addCostField = new javax.swing.JFormattedTextField();
        addPriceField = new javax.swing.JFormattedTextField();
        addProductQuantityField = new javax.swing.JTextField();
        editProductPanel = new javax.swing.JPanel();
        customerLabelName1 = new javax.swing.JLabel();
        editDescriptionField = new javax.swing.JTextField();
        customerLabelName2 = new javax.swing.JLabel();
        customerLabelName3 = new javax.swing.JLabel();
        customerLabelName4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cancelEditProductBtn = new javax.swing.JButton();
        submitEditProductBtn = new javax.swing.JButton();
        editProductIdField = new javax.swing.JTextField();
        customerLabelName38 = new javax.swing.JLabel();
        editCostField = new javax.swing.JFormattedTextField();
        editPriceField = new javax.swing.JFormattedTextField();
        editProductQuantityField = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        productsTable = new javax.swing.JTable();
        openAddProductPaneBtn = new javax.swing.JButton();
        deleteProductsBtn = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        openEditProductPaneBtn = new javax.swing.JButton();
        salesPanel = new javax.swing.JPanel();
        addSalePanel = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        customerLabelName6 = new javax.swing.JLabel();
        customerLabelName10 = new javax.swing.JLabel();
        addPaymentBtn = new javax.swing.JButton();
        paymentAmountField = new javax.swing.JFormattedTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        paymentsTable = new javax.swing.JTable();
        customerLabelName12 = new javax.swing.JLabel();
        remainingAmountField = new javax.swing.JFormattedTextField();
        paymentMethodCb = new javax.swing.JComboBox<>();
        deletePaymentsBtn = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        saleItemsTable = new javax.swing.JTable();
        deleteSaleItemsBtn = new javax.swing.JButton();
        customerLabelName22 = new javax.swing.JLabel();
        applyDiscountField = new javax.swing.JFormattedTextField();
        customerLabelName23 = new javax.swing.JLabel();
        totalValueField = new javax.swing.JFormattedTextField();
        jLabel20 = new javax.swing.JLabel();
        productChoisePanel = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        productChoiceTable = new javax.swing.JTable();
        submitProductChoiseBtn = new javax.swing.JButton();
        cancelProductChoiceBtn = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        customerLabelName20 = new javax.swing.JLabel();
        customerLabelName28 = new javax.swing.JLabel();
        productIdField = new javax.swing.JFormattedTextField();
        unitPriceField = new javax.swing.JFormattedTextField();
        customerLabelName21 = new javax.swing.JLabel();
        itemQuantityField = new javax.swing.JFormattedTextField();
        employeeLabelName5 = new javax.swing.JLabel();
        productDescriptionField = new javax.swing.JFormattedTextField();
        addSaleAddSaleItemBtn1 = new javax.swing.JButton();
        addSaleItemBtn = new javax.swing.JButton();
        employeeLabelName10 = new javax.swing.JLabel();
        applyDiscountBtn = new javax.swing.JButton();
        discountField = new javax.swing.JFormattedTextField();
        customerLabelName29 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cancelAddSaleBtn = new javax.swing.JButton();
        submitAddSaleBtn = new javax.swing.JButton();
        customerChoicePanel = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        submitCustomerChoiceBtn = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        customerChoiceTable = new javax.swing.JTable();
        cancelCustomerChoiceBtn = new javax.swing.JButton();
        sallerChoicePanel = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        submitSellerChoiceBtn = new javax.swing.JButton();
        jScrollPane12 = new javax.swing.JScrollPane();
        employeeChoiceTable = new javax.swing.JTable();
        cancelSellerChoiceBtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        customerNameCpfField = new javax.swing.JFormattedTextField();
        employeeLabelName3 = new javax.swing.JLabel();
        openChooseCustomerPanel = new javax.swing.JButton();
        employeeLabelName6 = new javax.swing.JLabel();
        employeeLabelName7 = new javax.swing.JLabel();
        customerIdField = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        employeeLabelName4 = new javax.swing.JLabel();
        sallerNameCpfField = new javax.swing.JFormattedTextField();
        openChooseSellerPanel = new javax.swing.JButton();
        employeeLabelName8 = new javax.swing.JLabel();
        employeeLabelName9 = new javax.swing.JLabel();
        sallerIdField = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        openAddSalePaneBtn = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        salesTable = new javax.swing.JTable();
        DeleteSalesBtn = new javax.swing.JButton();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(300, 300));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(new java.awt.FlowLayout());

        tabbedPanelScrollPane.setBackground(new java.awt.Color(102, 255, 102));
        tabbedPanelScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        tabbedPanelScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        tabbedPanelScrollPane.setAutoscrolls(true);
        tabbedPanelScrollPane.setFocusTraversalPolicyProvider(true);
        tabbedPanelScrollPane.setHorizontalScrollBar(null);
        tabbedPanelScrollPane.setInheritsPopupMenu(true);
        tabbedPanelScrollPane.setMinimumSize(new java.awt.Dimension(16, 800));
        tabbedPanelScrollPane.setOpaque(false);
        tabbedPanelScrollPane.setPreferredSize(new java.awt.Dimension(1280, 720));
        tabbedPanelScrollPane.setVerifyInputWhenFocusTarget(false);
        tabbedPanelScrollPane.setViewportView(tabbedPane);

        tabbedPane.setBackground(new java.awt.Color(153, 153, 153));
        tabbedPane.setMaximumSize(null);

        customersPanel.setBackground(new java.awt.Color(204, 204, 204));
        customersPanel.setAutoscrolls(true);
        customersPanel.setMaximumSize(new java.awt.Dimension(0, 0));
        customersPanel.setName(""); // NOI18N
        customersPanel.setPreferredSize(new java.awt.Dimension(1280, 1200));

        editCustomerPanel.setMaximumSize(new java.awt.Dimension(0, 0));
        editCustomerPanel.setName(""); // NOI18N
        editCustomerPanel.setRequestFocusEnabled(false);

        customerLabelName.setText("Nome Completo");

        try {
            editCellphoneField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        editCellphoneField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editCellphoneFieldActionPerformed(evt);
            }
        });

        try {
            editTellphoneField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        editCustomerNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editCustomerNameFieldActionPerformed(evt);
            }
        });

        try {
            editCustomerCpfField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        editCustomerCpfField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editCustomerCpfFieldActionPerformed(evt);
            }
        });

        customerTellphoneLabel.setText("Telefone");

        customerCellphoneLabel.setText("Celular");

        customerCpfLabel.setText("CPF");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Editar Cliente");
        jLabel1.setFocusable(false);

        CancelEditCustomerBtn.setBackground(new java.awt.Color(102, 102, 102));
        CancelEditCustomerBtn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        CancelEditCustomerBtn.setForeground(new java.awt.Color(255, 255, 255));
        CancelEditCustomerBtn.setText("Cancelar");
        CancelEditCustomerBtn.setPreferredSize(new java.awt.Dimension(80, 25));
        CancelEditCustomerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelEditCustomerBtnActionPerformed(evt);
            }
        });

        submitEditCustomerBtn.setBackground(new java.awt.Color(51, 153, 0));
        submitEditCustomerBtn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        submitEditCustomerBtn.setForeground(new java.awt.Color(255, 255, 255));
        submitEditCustomerBtn.setText("Finalizar");
        submitEditCustomerBtn.setToolTipText("");
        submitEditCustomerBtn.setAlignmentY(0.0F);
        submitEditCustomerBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        submitEditCustomerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitEditCustomerBtnActionPerformed(evt);
            }
        });

        editLogradouroField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editLogradouroFieldActionPerformed(evt);
            }
        });

        customerLabelName5.setText("Logradouro");

        customerLabelName7.setText("Nº");

        editAddressNumberField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editAddressNumberFieldActionPerformed(evt);
            }
        });

        customerLabelName8.setText("Complemento");

        editComplementField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editComplementFieldActionPerformed(evt);
            }
        });

        customerLabelName11.setText("Bairro");

        editBairroField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBairroFieldActionPerformed(evt);
            }
        });

        customerLabelName24.setText("Cidade");

        editCityField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editCityFieldActionPerformed(evt);
            }
        });

        customerLabelName25.setText("UF");

        try {
            editUfField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("??")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        customerLabelName17.setBackground(new java.awt.Color(153, 153, 153));
        customerLabelName17.setText("Id");

        editCustomerIdField.setEditable(false);
        editCustomerIdField.setBackground(new java.awt.Color(204, 204, 204));
        editCustomerIdField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editCustomerIdFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout editCustomerPanelLayout = new javax.swing.GroupLayout(editCustomerPanel);
        editCustomerPanel.setLayout(editCustomerPanelLayout);
        editCustomerPanelLayout.setHorizontalGroup(
            editCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editCustomerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editCustomerPanelLayout.createSequentialGroup()
                        .addGroup(editCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(editCustomerPanelLayout.createSequentialGroup()
                                .addComponent(customerLabelName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editCustomerNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(customerCpfLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editCustomerCpfField, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(customerCellphoneLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editCellphoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(customerTellphoneLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editTellphoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(editCustomerPanelLayout.createSequentialGroup()
                                .addComponent(customerLabelName5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editLogradouroField, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(customerLabelName7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editAddressNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(customerLabelName8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editComplementField, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(customerLabelName11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editBairroField, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(customerLabelName24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editCityField, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(customerLabelName25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editUfField, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(editCustomerPanelLayout.createSequentialGroup()
                                .addComponent(customerLabelName17)
                                .addGap(6, 6, 6)
                                .addComponent(editCustomerIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(499, 499, 499)
                                .addComponent(jLabel1)))
                        .addGap(201, 201, 201))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editCustomerPanelLayout.createSequentialGroup()
                        .addComponent(CancelEditCustomerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(submitEditCustomerBtn)
                        .addContainerGap())))
        );
        editCustomerPanelLayout.setVerticalGroup(
            editCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editCustomerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(customerLabelName17)
                        .addComponent(editCustomerIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(editCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editCustomerNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customerLabelName)
                    .addComponent(customerCpfLabel)
                    .addComponent(editCustomerCpfField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editCellphoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customerCellphoneLabel)
                    .addComponent(customerTellphoneLabel)
                    .addComponent(editTellphoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(editBairroField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(customerLabelName11)
                        .addComponent(customerLabelName25)
                        .addComponent(editUfField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(editCityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(customerLabelName24))
                    .addGroup(editCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(editLogradouroField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(customerLabelName5)
                        .addComponent(customerLabelName7)
                        .addComponent(editAddressNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(editComplementField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(customerLabelName8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CancelEditCustomerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(submitEditCustomerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        jScrollPane1.setPreferredSize(new java.awt.Dimension(1240, 500));

        customersTable.setAutoCreateRowSorter(true);
        customersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome Completo", "Cpf", "Celular", "Telefone", "Endereço"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        loadCustomersTables();
        customersTable.setPreferredSize(new java.awt.Dimension(1240, 500));
        customersTable.setShowGrid(true);
        jScrollPane1.setViewportView(customersTable);
        if (customersTable.getColumnModel().getColumnCount() > 0) {
            customersTable.getColumnModel().getColumn(0).setResizable(false);
            customersTable.getColumnModel().getColumn(0).setPreferredWidth(20);
            customersTable.getColumnModel().getColumn(1).setResizable(false);
            customersTable.getColumnModel().getColumn(1).setPreferredWidth(200);
            customersTable.getColumnModel().getColumn(2).setResizable(false);
            customersTable.getColumnModel().getColumn(3).setResizable(false);
            customersTable.getColumnModel().getColumn(4).setResizable(false);
            customersTable.getColumnModel().getColumn(5).setResizable(false);
            customersTable.getColumnModel().getColumn(5).setPreferredWidth(200);
        }

        openAddCustomerPaneBtn.setBackground(new java.awt.Color(51, 153, 0));
        openAddCustomerPaneBtn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        openAddCustomerPaneBtn.setForeground(new java.awt.Color(255, 255, 255));
        openAddCustomerPaneBtn.setText("Novo cliente");
        openAddCustomerPaneBtn.setPreferredSize(new java.awt.Dimension(80, 25));
        openAddCustomerPaneBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                openAddCustomerPaneBtnMouseClicked(evt);
            }
        });
        openAddCustomerPaneBtn.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                openAddCustomerPaneBtnComponentHidden(evt);
            }
        });
        openAddCustomerPaneBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openAddCustomerPaneBtnActionPerformed(evt);
            }
        });

        deleteCustomersBtn.setBackground(new java.awt.Color(153, 0, 51));
        deleteCustomersBtn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        deleteCustomersBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteCustomersBtn.setText("Deletar clientes selecionados");
        deleteCustomersBtn.setPreferredSize(new java.awt.Dimension(80, 25));
        deleteCustomersBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCustomersBtnActionPerformed(evt);
            }
        });

        addCustomerPanel.setMaximumSize(new java.awt.Dimension(0, 0));
        addCustomerPanel.setName(""); // NOI18N
        addCustomerPanel.setPreferredSize(new java.awt.Dimension(1240, 157));

        customerLabelName9.setText("Nome Completo");

        try {
            addCellphoneField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        addCellphoneField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCellphoneFieldActionPerformed(evt);
            }
        });

        try {
            addTellphoneField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        addCustomerNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCustomerNameFieldActionPerformed(evt);
            }
        });

        try {
            addCustomerCpfField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        addCustomerCpfField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCustomerCpfFieldActionPerformed(evt);
            }
        });

        customerTellphoneLabel1.setText("Telefone");

        customerCellphoneLabel1.setText("Celular");

        customerCpfLabel1.setText("CPF");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Adicionar Cliente");

        cancelAddPaymentBtn.setBackground(new java.awt.Color(102, 102, 102));
        cancelAddPaymentBtn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cancelAddPaymentBtn.setForeground(new java.awt.Color(255, 255, 255));
        cancelAddPaymentBtn.setText("Cancelar");
        cancelAddPaymentBtn.setPreferredSize(new java.awt.Dimension(80, 25));
        cancelAddPaymentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelAddPaymentBtnActionPerformed(evt);
            }
        });

        submitAddCustomerBtn.setBackground(new java.awt.Color(51, 153, 0));
        submitAddCustomerBtn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        submitAddCustomerBtn.setForeground(new java.awt.Color(255, 255, 255));
        submitAddCustomerBtn.setText("Finalizar");
        submitAddCustomerBtn.setToolTipText("");
        submitAddCustomerBtn.setAlignmentY(0.0F);
        submitAddCustomerBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        submitAddCustomerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitAddCustomerBtnActionPerformed(evt);
            }
        });

        addLogradouroField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addLogradouroFieldActionPerformed(evt);
            }
        });

        customerLabelName13.setText("Logradouro");

        customerLabelName14.setText("Nº");

        addAddressNumberField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAddressNumberFieldActionPerformed(evt);
            }
        });

        customerLabelName15.setText("Complemento");

        addComplementField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addComplementFieldActionPerformed(evt);
            }
        });

        customerLabelName16.setText("Bairro");

        addBairroField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBairroFieldActionPerformed(evt);
            }
        });

        customerLabelName26.setText("Cidade");

        addCityField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCityFieldActionPerformed(evt);
            }
        });

        customerLabelName27.setText("UF");

        try {
            addUfField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("??")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout addCustomerPanelLayout = new javax.swing.GroupLayout(addCustomerPanel);
        addCustomerPanel.setLayout(addCustomerPanelLayout);
        addCustomerPanelLayout.setHorizontalGroup(
            addCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addCustomerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addCustomerPanelLayout.createSequentialGroup()
                        .addComponent(customerLabelName13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addLogradouroField, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(customerLabelName14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addAddressNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(customerLabelName15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addComplementField, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(customerLabelName16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addBairroField, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(customerLabelName26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addCityField, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(customerLabelName27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addUfField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(addCustomerPanelLayout.createSequentialGroup()
                        .addGroup(addCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addCustomerPanelLayout.createSequentialGroup()
                                .addComponent(customerLabelName9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addCustomerNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(customerCpfLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addCustomerCpfField, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(customerCellphoneLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addCellphoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(customerTellphoneLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addTellphoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addCustomerPanelLayout.createSequentialGroup()
                                .addComponent(cancelAddPaymentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(submitAddCustomerBtn)))
                        .addContainerGap())))
            .addGroup(addCustomerPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        addCustomerPanelLayout.setVerticalGroup(
            addCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addCustomerPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(addCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addCustomerNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customerLabelName9)
                    .addComponent(customerCpfLabel1)
                    .addComponent(addCustomerCpfField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addCellphoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customerCellphoneLabel1)
                    .addComponent(customerTellphoneLabel1)
                    .addComponent(addTellphoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addLogradouroField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customerLabelName13)
                    .addComponent(customerLabelName14)
                    .addComponent(addAddressNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addComplementField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customerLabelName15)
                    .addComponent(addBairroField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customerLabelName16)
                    .addComponent(customerLabelName27)
                    .addComponent(addUfField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addCityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customerLabelName26))
                .addGap(18, 18, 18)
                .addGroup(addCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelAddPaymentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(submitAddCustomerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        openEditCustomerBtn.setBackground(new java.awt.Color(0, 102, 204));
        openEditCustomerBtn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        openEditCustomerBtn.setForeground(new java.awt.Color(255, 255, 255));
        openEditCustomerBtn.setText("Editar cliente selecionado");
        openEditCustomerBtn.setPreferredSize(new java.awt.Dimension(80, 25));
        openEditCustomerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openEditCustomerBtnActionPerformed(evt);
            }
        });

        jScrollPane3.setBorder(null);
        jScrollPane3.setOpaque(false);

        jLabel18.setBackground(new java.awt.Color(204, 204, 204));
        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel18.setText("Clientes");
        jLabel18.setFocusable(false);
        jLabel18.setOpaque(true);
        jScrollPane3.setViewportView(jLabel18);

        javax.swing.GroupLayout customersPanelLayout = new javax.swing.GroupLayout(customersPanel);
        customersPanel.setLayout(customersPanelLayout);
        customersPanelLayout.setHorizontalGroup(
            customersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customersPanelLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(customersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addCustomerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(customersPanelLayout.createSequentialGroup()
                        .addGroup(customersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(deleteCustomersBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(customersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(openAddCustomerPaneBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(openEditCustomerBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(editCustomerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        customersPanelLayout.setVerticalGroup(
            customersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addCustomerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editCustomerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(customersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(openAddCustomerPaneBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(customersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deleteCustomersBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(openEditCustomerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(1249, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Clientes", customersPanel);

        employeesPanel.setBackground(new java.awt.Color(204, 204, 204));
        employeesPanel.setAutoscrolls(true);
        employeesPanel.setMaximumSize(new java.awt.Dimension(0, 0));

        openAddEmployeePaneBtn.setBackground(new java.awt.Color(51, 153, 0));
        openAddEmployeePaneBtn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        openAddEmployeePaneBtn.setForeground(new java.awt.Color(255, 255, 255));
        openAddEmployeePaneBtn.setText("Novo funcionário");
        openAddEmployeePaneBtn.setPreferredSize(new java.awt.Dimension(80, 25));
        openAddEmployeePaneBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openAddEmployeePaneBtnActionPerformed(evt);
            }
        });

        jScrollPane2.setPreferredSize(new java.awt.Dimension(1240, 200));

        employeesTable.setAutoCreateRowSorter(true);
        employeesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Nome Completo", "Cpf"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        loadEmployeesTables();
        employeesTable.setPreferredSize(new java.awt.Dimension(770, 400));
        employeesTable.setShowGrid(true);
        jScrollPane2.setViewportView(employeesTable);
        if (employeesTable.getColumnModel().getColumnCount() > 0) {
            employeesTable.getColumnModel().getColumn(0).setPreferredWidth(5);
        }

        deleteEmployeesBtn.setBackground(new java.awt.Color(153, 0, 51));
        deleteEmployeesBtn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        deleteEmployeesBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteEmployeesBtn.setText("Deletar funcionários selecionados");
        deleteEmployeesBtn.setPreferredSize(new java.awt.Dimension(80, 25));
        deleteEmployeesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteEmployeesBtnActionPerformed(evt);
            }
        });

        addEmployeePanel.setPreferredSize(new java.awt.Dimension(1240, 75));

        employeeLabelName.setText("Nome Completo");

        addEmployeeNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEmployeeNameFieldActionPerformed(evt);
            }
        });

        employeeCpfLabel.setText("CPF");

        try {
            addEmployeeCpfField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        addEmployeeCpfField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEmployeeCpfFieldActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Adicionar funcionário");

        cancelAddEmployeeBtn.setBackground(new java.awt.Color(102, 102, 102));
        cancelAddEmployeeBtn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cancelAddEmployeeBtn.setForeground(new java.awt.Color(255, 255, 255));
        cancelAddEmployeeBtn.setText("Cancelar");
        cancelAddEmployeeBtn.setPreferredSize(new java.awt.Dimension(80, 25));
        cancelAddEmployeeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelAddEmployeeBtnActionPerformed(evt);
            }
        });

        submitAddEmployeeBtn.setBackground(new java.awt.Color(51, 153, 0));
        submitAddEmployeeBtn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        submitAddEmployeeBtn.setForeground(new java.awt.Color(255, 255, 255));
        submitAddEmployeeBtn.setText("Finalizar");
        submitAddEmployeeBtn.setToolTipText("");
        submitAddEmployeeBtn.setAlignmentY(0.0F);
        submitAddEmployeeBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        submitAddEmployeeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitAddEmployeeBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addEmployeePanelLayout = new javax.swing.GroupLayout(addEmployeePanel);
        addEmployeePanel.setLayout(addEmployeePanelLayout);
        addEmployeePanelLayout.setHorizontalGroup(
            addEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addEmployeePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addEmployeePanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(addEmployeePanelLayout.createSequentialGroup()
                        .addComponent(employeeLabelName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addEmployeeNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(employeeCpfLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addEmployeeCpfField, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelAddEmployeeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(submitAddEmployeeBtn)
                        .addGap(8, 8, 8))))
        );
        addEmployeePanelLayout.setVerticalGroup(
            addEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addEmployeePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(addEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employeeLabelName)
                    .addComponent(addEmployeeNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addEmployeeCpfField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(employeeCpfLabel))
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addEmployeePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(addEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitAddEmployeeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelAddEmployeeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        employeeLabelName1.setText("Nome Completo");

        editEmployeeNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editEmployeeNameFieldActionPerformed(evt);
            }
        });

        employeeCpfLabel1.setText("CPF");

        try {
            editEmployeeCpfField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        editEmployeeCpfField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editEmployeeCpfFieldActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Editar funcionário");

        cancelEditEmployeeBtn.setBackground(new java.awt.Color(102, 102, 102));
        cancelEditEmployeeBtn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cancelEditEmployeeBtn.setForeground(new java.awt.Color(255, 255, 255));
        cancelEditEmployeeBtn.setText("Cancelar");
        cancelEditEmployeeBtn.setPreferredSize(new java.awt.Dimension(80, 25));
        cancelEditEmployeeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelEditEmployeeBtnActionPerformed(evt);
            }
        });

        submitEditEmployeeBtn.setBackground(new java.awt.Color(51, 153, 0));
        submitEditEmployeeBtn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        submitEditEmployeeBtn.setForeground(new java.awt.Color(255, 255, 255));
        submitEditEmployeeBtn.setText("Finalizar");
        submitEditEmployeeBtn.setToolTipText("");
        submitEditEmployeeBtn.setAlignmentY(0.0F);
        submitEditEmployeeBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        submitEditEmployeeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitEditEmployeeBtnActionPerformed(evt);
            }
        });

        editEmployeeIdField.setEditable(false);
        editEmployeeIdField.setBackground(new java.awt.Color(204, 204, 204));
        editEmployeeIdField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editEmployeeIdFieldActionPerformed(evt);
            }
        });

        customerLabelName39.setBackground(new java.awt.Color(153, 153, 153));
        customerLabelName39.setText("Id");

        javax.swing.GroupLayout editEmployeePanelLayout = new javax.swing.GroupLayout(editEmployeePanel);
        editEmployeePanel.setLayout(editEmployeePanelLayout);
        editEmployeePanelLayout.setHorizontalGroup(
            editEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editEmployeePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editEmployeePanelLayout.createSequentialGroup()
                        .addComponent(customerLabelName39)
                        .addGap(6, 6, 6)
                        .addComponent(editEmployeeIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(477, 477, 477)
                        .addComponent(jLabel5)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(editEmployeePanelLayout.createSequentialGroup()
                        .addGroup(editEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(editEmployeePanelLayout.createSequentialGroup()
                                .addComponent(employeeLabelName1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editEmployeeNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(employeeCpfLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editEmployeeCpfField, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editEmployeePanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(cancelEditEmployeeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(submitEditEmployeeBtn)
                        .addGap(8, 8, 8))))
        );
        editEmployeePanelLayout.setVerticalGroup(
            editEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editEmployeePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(customerLabelName39)
                        .addComponent(editEmployeeIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(editEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employeeLabelName1)
                    .addComponent(editEmployeeNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editEmployeeCpfField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(employeeCpfLabel1))
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editEmployeePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(editEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelEditEmployeeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(submitEditEmployeeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel19.setText("Funcionários");

        openEditEmployeePanelBtn.setBackground(new java.awt.Color(0, 102, 204));
        openEditEmployeePanelBtn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        openEditEmployeePanelBtn.setForeground(new java.awt.Color(255, 255, 255));
        openEditEmployeePanelBtn.setText("Editar funcionário selecionado");
        openEditEmployeePanelBtn.setPreferredSize(new java.awt.Dimension(80, 25));
        openEditEmployeePanelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openEditEmployeePanelBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout employeesPanelLayout = new javax.swing.GroupLayout(employeesPanel);
        employeesPanel.setLayout(employeesPanelLayout);
        employeesPanelLayout.setHorizontalGroup(
            employeesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(employeesPanelLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(employeesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, employeesPanelLayout.createSequentialGroup()
                        .addComponent(deleteEmployeesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(openEditEmployeePanelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, employeesPanelLayout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(openAddEmployeePaneBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(editEmployeePanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addEmployeePanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        employeesPanelLayout.setVerticalGroup(
            employeesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(employeesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addEmployeePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editEmployeePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(employeesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(openAddEmployeePaneBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(employeesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteEmployeesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(openEditEmployeePanelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        tabbedPane.addTab("Funcionários", employeesPanel);

        inventoryPanel.setBackground(new java.awt.Color(204, 204, 204));
        inventoryPanel.setAutoscrolls(true);
        inventoryPanel.setRequestFocusEnabled(false);

        addProductPanel.setPreferredSize(new java.awt.Dimension(821, 108));
        addProductPanel.setRequestFocusEnabled(false);

        customerLabelName34.setText("Descrição");

        addDescriptionField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDescriptionFieldActionPerformed(evt);
            }
        });

        customerLabelName35.setText("Custo");

        customerLabelName36.setText("Preço");

        customerLabelName37.setText("Quantidade Inicial");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Adicionar Produto");

        cancelAddProductBtn.setBackground(new java.awt.Color(102, 102, 102));
        cancelAddProductBtn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cancelAddProductBtn.setForeground(new java.awt.Color(255, 255, 255));
        cancelAddProductBtn.setText("Cancelar");
        cancelAddProductBtn.setPreferredSize(new java.awt.Dimension(80, 25));
        cancelAddProductBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelAddProductBtnActionPerformed(evt);
            }
        });

        submitAddProductBtn.setBackground(new java.awt.Color(51, 153, 0));
        submitAddProductBtn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        submitAddProductBtn.setForeground(new java.awt.Color(255, 255, 255));
        submitAddProductBtn.setText("Finalizar");
        submitAddProductBtn.setToolTipText("");
        submitAddProductBtn.setAlignmentY(0.0F);
        submitAddProductBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        submitAddProductBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitAddProductBtnActionPerformed(evt);
            }
        });

        addCostField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        addCostField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCostFieldActionPerformed(evt);
            }
        });

        addPriceField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        addPriceField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPriceFieldActionPerformed(evt);
            }
        });

        addProductQuantityField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProductQuantityFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addProductPanelLayout = new javax.swing.GroupLayout(addProductPanel);
        addProductPanel.setLayout(addProductPanelLayout);
        addProductPanelLayout.setHorizontalGroup(
            addProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addProductPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addProductPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cancelAddProductBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(submitAddProductBtn))
                    .addGroup(addProductPanelLayout.createSequentialGroup()
                        .addComponent(customerLabelName34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addDescriptionField, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(customerLabelName35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addCostField, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(addProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addProductPanelLayout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addComponent(jLabel8))
                            .addGroup(addProductPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(customerLabelName36)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(customerLabelName37)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addProductQuantityField, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        addProductPanelLayout.setVerticalGroup(
            addProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addProductPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(addProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(customerLabelName37)
                        .addComponent(customerLabelName35)
                        .addComponent(customerLabelName36)
                        .addComponent(addCostField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(addPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(addProductQuantityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(addDescriptionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(customerLabelName34)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelAddProductBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(submitAddProductBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        editProductPanel.setPreferredSize(new java.awt.Dimension(825, 155));
        editProductPanel.setRequestFocusEnabled(false);
        editProductPanel.setVerifyInputWhenFocusTarget(false);

        customerLabelName1.setText("Descrição");

        editDescriptionField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editDescriptionFieldActionPerformed(evt);
            }
        });

        customerLabelName2.setText("Custo");

        customerLabelName3.setText("Preço");

        customerLabelName4.setText("Quantidade");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Editar Produto");

        cancelEditProductBtn.setBackground(new java.awt.Color(102, 102, 102));
        cancelEditProductBtn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cancelEditProductBtn.setForeground(new java.awt.Color(255, 255, 255));
        cancelEditProductBtn.setText("Cancelar");
        cancelEditProductBtn.setPreferredSize(new java.awt.Dimension(80, 25));
        cancelEditProductBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelEditProductBtnActionPerformed(evt);
            }
        });

        submitEditProductBtn.setBackground(new java.awt.Color(51, 153, 0));
        submitEditProductBtn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        submitEditProductBtn.setForeground(new java.awt.Color(255, 255, 255));
        submitEditProductBtn.setText("Finalizar");
        submitEditProductBtn.setToolTipText("");
        submitEditProductBtn.setAlignmentY(0.0F);
        submitEditProductBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        submitEditProductBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitEditProductBtnActionPerformed(evt);
            }
        });

        editProductIdField.setEditable(false);
        editProductIdField.setBackground(new java.awt.Color(204, 204, 204));
        editProductIdField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editProductIdFieldActionPerformed(evt);
            }
        });

        customerLabelName38.setBackground(new java.awt.Color(153, 153, 153));
        customerLabelName38.setText("Id");

        editCostField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        editCostField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editCostFieldActionPerformed(evt);
            }
        });

        editPriceField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        editPriceField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editPriceFieldActionPerformed(evt);
            }
        });

        editProductQuantityField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editProductQuantityFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout editProductPanelLayout = new javax.swing.GroupLayout(editProductPanel);
        editProductPanel.setLayout(editProductPanelLayout);
        editProductPanelLayout.setHorizontalGroup(
            editProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editProductPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editProductPanelLayout.createSequentialGroup()
                        .addComponent(customerLabelName38)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editProductIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(494, 494, 494)
                        .addComponent(jLabel7))
                    .addGroup(editProductPanelLayout.createSequentialGroup()
                        .addComponent(customerLabelName1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editDescriptionField, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(customerLabelName2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editCostField, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(customerLabelName3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(customerLabelName4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editProductQuantityField, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(editProductPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cancelEditProductBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(submitEditProductBtn)
                .addContainerGap())
        );
        editProductPanelLayout.setVerticalGroup(
            editProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editProductPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editProductIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customerLabelName38)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(editProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(customerLabelName4)
                        .addComponent(customerLabelName2)
                        .addComponent(customerLabelName3)
                        .addComponent(editCostField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(editPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(editProductQuantityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(editProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(editDescriptionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(customerLabelName1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelEditProductBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(submitEditProductBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jScrollPane7.setPreferredSize(new java.awt.Dimension(1240, 402));

        productsTable.setAutoCreateRowSorter(true);
        productsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Descrição", "Custo", "Preço", "Quantidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        loadProductsTables();
        productsTable.setPreferredSize(new java.awt.Dimension(1240, 400));
        productsTable.setRequestFocusEnabled(false);
        productsTable.setShowGrid(true);
        jScrollPane7.setViewportView(productsTable);
        if (productsTable.getColumnModel().getColumnCount() > 0) {
            productsTable.getColumnModel().getColumn(1).setPreferredWidth(230);
        }

        openAddProductPaneBtn.setBackground(new java.awt.Color(51, 153, 0));
        openAddProductPaneBtn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        openAddProductPaneBtn.setForeground(new java.awt.Color(255, 255, 255));
        openAddProductPaneBtn.setText("Novo produto");
        openAddProductPaneBtn.setPreferredSize(new java.awt.Dimension(80, 25));
        openAddProductPaneBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openAddProductPaneBtnActionPerformed(evt);
            }
        });

        deleteProductsBtn.setBackground(new java.awt.Color(153, 0, 51));
        deleteProductsBtn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        deleteProductsBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteProductsBtn.setText("Deletar produtos");
        deleteProductsBtn.setPreferredSize(new java.awt.Dimension(80, 25));
        deleteProductsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteProductsBtnActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setText("Produtos");

        openEditProductPaneBtn.setBackground(new java.awt.Color(0, 102, 204));
        openEditProductPaneBtn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        openEditProductPaneBtn.setForeground(new java.awt.Color(255, 255, 255));
        openEditProductPaneBtn.setText("Editar produto selecionado");
        openEditProductPaneBtn.setPreferredSize(new java.awt.Dimension(80, 25));
        openEditProductPaneBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openEditProductPaneBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout inventoryPanelLayout = new javax.swing.GroupLayout(inventoryPanel);
        inventoryPanel.setLayout(inventoryPanelLayout);
        inventoryPanelLayout.setHorizontalGroup(
            inventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inventoryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(editProductPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1240, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inventoryPanelLayout.createSequentialGroup()
                        .addComponent(deleteProductsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(openEditProductPaneBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(inventoryPanelLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(openAddProductPaneBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addProductPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1240, Short.MAX_VALUE))
                .addContainerGap())
        );
        inventoryPanelLayout.setVerticalGroup(
            inventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inventoryPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(addProductPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editProductPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(inventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(openAddProductPaneBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(inventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(openEditProductPaneBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteProductsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        addProductPanel.setVisible(false);
        editProductPanel.getAccessibleContext().setAccessibleName("");
        editProductPanel.setVisible(false);

        tabbedPane.addTab("Estoque/Produtos", inventoryPanel);

        salesPanel.setBackground(new java.awt.Color(204, 204, 204));
        salesPanel.setAutoscrolls(true);
        salesPanel.setPreferredSize(new java.awt.Dimension(1280, 2139));
        salesPanel.setRequestFocusEnabled(false);

        addSalePanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("Realizar Venda");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText("Itens da venda");

        jPanel3.setBackground(new java.awt.Color(231, 231, 222));

        customerLabelName6.setText("Valor à Pagar");

        customerLabelName10.setText("Forma de Pagamento");

        addPaymentBtn.setBackground(new java.awt.Color(51, 153, 0));
        addPaymentBtn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        addPaymentBtn.setForeground(new java.awt.Color(255, 255, 255));
        addPaymentBtn.setText("Adicionar pagamento");
        addPaymentBtn.setToolTipText("");
        addPaymentBtn.setAlignmentY(0.0F);
        addPaymentBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addPaymentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPaymentBtnActionPerformed(evt);
            }
        });

        paymentAmountField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentAmountFieldActionPerformed(evt);
            }
        });

        jScrollPane4.setPreferredSize(new java.awt.Dimension(452, 109));

        paymentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Forma de pagamento", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        paymentsTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        paymentsTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        paymentsTable.setFillsViewportHeight(true);
        paymentsTable.setPreferredSize(new java.awt.Dimension(480, 109));
        paymentsTable.setShowGrid(true);
        jScrollPane4.setViewportView(paymentsTable);
        if (paymentsTable.getColumnModel().getColumnCount() > 0) {
            paymentsTable.getColumnModel().getColumn(0).setPreferredWidth(280);
            paymentsTable.getColumnModel().getColumn(1).setMinWidth(0);
            paymentsTable.getColumnModel().getColumn(1).setPreferredWidth(200);
            paymentsTable.getColumnModel().getColumn(1).setMaxWidth(500);
        }

        customerLabelName12.setText("Valor Restante");

        remainingAmountField.setText("0.00");
        remainingAmountField.setEditable(false);
        remainingAmountField.setBackground(new java.awt.Color(204, 204, 204));
        remainingAmountField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        remainingAmountField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        remainingAmountField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remainingAmountFieldActionPerformed(evt);
            }
        });

        paymentMethodCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Dinheiro", "PIX", "Cartão de Débito", "C. de Crédito 1x", "C. de Crédito 2x", "C. de Crédito 3x", "C. de Crédito 4x", "C. de Crédito 5x", "C. de Crédito 6x", "C. de Crédito 7x", "C. de Crédito 8x", "C. de Crédito 9x", "C. de Crédito 10x" }));
        paymentMethodCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentMethodCbActionPerformed(evt);
            }
        });

        deletePaymentsBtn.setBackground(new java.awt.Color(153, 0, 51));
        deletePaymentsBtn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        deletePaymentsBtn.setForeground(new java.awt.Color(255, 255, 255));
        deletePaymentsBtn.setText("Deletar pagamentos selecionados");
        deletePaymentsBtn.setPreferredSize(new java.awt.Dimension(80, 25));
        deletePaymentsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletePaymentsBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(deletePaymentsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(customerLabelName12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(remainingAmountField, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(customerLabelName10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(paymentMethodCb, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(customerLabelName6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(paymentAmountField, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addPaymentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customerLabelName6)
                    .addComponent(customerLabelName10)
                    .addComponent(addPaymentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(paymentAmountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(paymentMethodCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(customerLabelName12)
                        .addComponent(remainingAmountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(deletePaymentsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(198, 209, 225));
        jPanel5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel5.setPreferredSize(new java.awt.Dimension(756, 605));
        jPanel5.setRequestFocusEnabled(false);

        jScrollPane6.setPreferredSize(new java.awt.Dimension(452, 174));

        saleItemsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id do produto", "Descrição do Produto", "Valor unitário", "Quantidade", "Valor Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        saleItemsTable.setPreferredSize(new java.awt.Dimension(305, 174));
        jScrollPane6.setViewportView(saleItemsTable);
        if (saleItemsTable.getColumnModel().getColumnCount() > 0) {
            saleItemsTable.getColumnModel().getColumn(0).setPreferredWidth(20);
            saleItemsTable.getColumnModel().getColumn(1).setPreferredWidth(200);
            saleItemsTable.getColumnModel().getColumn(3).setPreferredWidth(10);
            saleItemsTable.getColumnModel().getColumn(4).setPreferredWidth(10);
        }

        deleteSaleItemsBtn.setBackground(new java.awt.Color(153, 0, 51));
        deleteSaleItemsBtn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        deleteSaleItemsBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteSaleItemsBtn.setText("Deletar itens selecionados");
        deleteSaleItemsBtn.setPreferredSize(new java.awt.Dimension(80, 25));
        deleteSaleItemsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteSaleItemsBtnActionPerformed(evt);
            }
        });

        customerLabelName22.setText("Desconto");

        applyDiscountField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        applyDiscountField.setText("0.00");
        applyDiscountField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                applyDiscountFieldFocusLost(evt);
            }
        });
        applyDiscountField.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                applyDiscountFieldCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                applyDiscountFieldInputMethodTextChanged(evt);
            }
        });
        applyDiscountField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyDiscountFieldActionPerformed(evt);
            }
        });
        applyDiscountField.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                applyDiscountFieldPropertyChange(evt);
            }
        });

        customerLabelName23.setText("Valor Total");

        totalValueField.setEditable(false);
        totalValueField.setBackground(new java.awt.Color(204, 204, 204));
        totalValueField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        totalValueField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        totalValueField.setText("0,00");
        totalValueField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        totalValueField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalValueFieldActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel20.setText("Itens da venda");

        productChoisePanel.setVisible(false);
        productChoisePanel.setBackground(new java.awt.Color(204, 204, 204));
        productChoisePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jScrollPane10.setPreferredSize(new java.awt.Dimension(821, 190));

        productChoiceTable.setAutoCreateRowSorter(true);
        productChoiceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Descrição", "Custo", "Preço", "Quantidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        loadProductsTables();
        productChoiceTable.setPreferredSize(new java.awt.Dimension(545, 190));
        productChoiceTable.setRequestFocusEnabled(false);
        jScrollPane10.setViewportView(productChoiceTable);
        if (productChoiceTable.getColumnModel().getColumnCount() > 0) {
            productChoiceTable.getColumnModel().getColumn(0).setPreferredWidth(20);
            productChoiceTable.getColumnModel().getColumn(1).setPreferredWidth(230);
        }

        submitProductChoiseBtn.setBackground(new java.awt.Color(51, 153, 0));
        submitProductChoiseBtn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        submitProductChoiseBtn.setForeground(new java.awt.Color(255, 255, 255));
        submitProductChoiseBtn.setText("Finalizar escolha");
        submitProductChoiseBtn.setToolTipText("");
        submitProductChoiseBtn.setAlignmentY(0.0F);
        submitProductChoiseBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        submitProductChoiseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitProductChoiseBtnActionPerformed(evt);
            }
        });

        cancelProductChoiceBtn.setBackground(new java.awt.Color(102, 102, 102));
        cancelProductChoiceBtn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cancelProductChoiceBtn.setForeground(new java.awt.Color(255, 255, 255));
        cancelProductChoiceBtn.setText("Cancelar escolha");
        cancelProductChoiceBtn.setPreferredSize(new java.awt.Dimension(122, 28));
        cancelProductChoiceBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelProductChoiceBtnActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel23.setText("Escolher produto");

        javax.swing.GroupLayout productChoisePanelLayout = new javax.swing.GroupLayout(productChoisePanel);
        productChoisePanel.setLayout(productChoisePanelLayout);
        productChoisePanelLayout.setHorizontalGroup(
            productChoisePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productChoisePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(productChoisePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(productChoisePanelLayout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, productChoisePanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cancelProductChoiceBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(submitProductChoiseBtn)))
                .addContainerGap())
        );
        productChoisePanelLayout.setVerticalGroup(
            productChoisePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, productChoisePanelLayout.createSequentialGroup()
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(productChoisePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitProductChoiseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelProductChoiceBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        customerLabelName20.setText("Preço Unitário");

        customerLabelName28.setText("ID do produto");

        productIdField.setEditable(false);
        productIdField.setBackground(new java.awt.Color(204, 204, 204));
        productIdField.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        productIdField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productIdFieldActionPerformed(evt);
            }
        });

        unitPriceField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        unitPriceField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unitPriceFieldActionPerformed(evt);
            }
        });

        customerLabelName21.setText("Quantidade");

        itemQuantityField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        itemQuantityField.setText("1");
        itemQuantityField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemQuantityFieldActionPerformed(evt);
            }
        });

        employeeLabelName5.setText("Produto");

        productDescriptionField.setEditable(false);
        productDescriptionField.setBackground(new java.awt.Color(204, 204, 204));
        productDescriptionField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
        productDescriptionField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productDescriptionFieldActionPerformed(evt);
            }
        });

        addSaleAddSaleItemBtn1.setBackground(new java.awt.Color(153, 153, 153));
        addSaleAddSaleItemBtn1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        addSaleAddSaleItemBtn1.setForeground(new java.awt.Color(255, 255, 255));
        addSaleAddSaleItemBtn1.setText("Buscar produto");
        addSaleAddSaleItemBtn1.setToolTipText("");
        addSaleAddSaleItemBtn1.setAlignmentY(0.0F);
        addSaleAddSaleItemBtn1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addSaleAddSaleItemBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSaleAddSaleItemBtn1ActionPerformed(evt);
            }
        });

        addSaleItemBtn.setBackground(new java.awt.Color(51, 153, 0));
        addSaleItemBtn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        addSaleItemBtn.setForeground(new java.awt.Color(255, 255, 255));
        addSaleItemBtn.setText("Adicionar item");
        addSaleItemBtn.setToolTipText("");
        addSaleItemBtn.setAlignmentY(0.0F);
        addSaleItemBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addSaleItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSaleItemBtnActionPerformed(evt);
            }
        });

        employeeLabelName10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        employeeLabelName10.setText("Item");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(addSaleItemBtn))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(employeeLabelName10)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(customerLabelName28)
                                .addGap(7, 7, 7)
                                .addComponent(productIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(employeeLabelName5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(productDescriptionField, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addSaleAddSaleItemBtn1)
                                .addGap(18, 18, 18)
                                .addComponent(customerLabelName20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(unitPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(customerLabelName21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(itemQuantityField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(employeeLabelName10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(customerLabelName28)
                        .addComponent(productIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(productDescriptionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(addSaleAddSaleItemBtn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(customerLabelName20)
                        .addComponent(unitPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(employeeLabelName5))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(itemQuantityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(customerLabelName21))))
                .addGap(18, 18, 18)
                .addComponent(addSaleItemBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        applyDiscountBtn.setBackground(new java.awt.Color(51, 153, 0));
        applyDiscountBtn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        applyDiscountBtn.setForeground(new java.awt.Color(255, 255, 255));
        applyDiscountBtn.setText("Aplicar");
        applyDiscountBtn.setToolTipText("");
        applyDiscountBtn.setAlignmentY(0.0F);
        applyDiscountBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        applyDiscountBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyDiscountBtnActionPerformed(evt);
            }
        });

        discountField.setEditable(false);
        discountField.setBackground(new java.awt.Color(204, 204, 204));
        discountField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        discountField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        discountField.setText("0,00");
        discountField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        discountField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discountFieldActionPerformed(evt);
            }
        });

        customerLabelName29.setText("Desconto Aplicado");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(productChoisePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(deleteSaleItemsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(customerLabelName22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(applyDiscountField, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(applyDiscountBtn)
                        .addGap(18, 18, 18)
                        .addComponent(customerLabelName29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(discountField, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(customerLabelName23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalValueField, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(productChoisePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customerLabelName22)
                    .addComponent(applyDiscountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customerLabelName23)
                    .addComponent(totalValueField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteSaleItemsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(applyDiscountBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customerLabelName29)
                    .addComponent(discountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setText("Pagamento");

        cancelAddSaleBtn.setBackground(new java.awt.Color(102, 102, 102));
        cancelAddSaleBtn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cancelAddSaleBtn.setForeground(new java.awt.Color(255, 255, 255));
        cancelAddSaleBtn.setText("Cancelar venda");
        cancelAddSaleBtn.setPreferredSize(new java.awt.Dimension(80, 25));
        cancelAddSaleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelAddSaleBtnActionPerformed(evt);
            }
        });

        submitAddSaleBtn.setBackground(new java.awt.Color(51, 153, 0));
        submitAddSaleBtn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        submitAddSaleBtn.setForeground(new java.awt.Color(255, 255, 255));
        submitAddSaleBtn.setText("Finalizar venda");
        submitAddSaleBtn.setToolTipText("");
        submitAddSaleBtn.setAlignmentY(0.0F);
        submitAddSaleBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        submitAddSaleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitAddSaleBtnActionPerformed(evt);
            }
        });

        customerChoicePanel.setBackground(new java.awt.Color(204, 204, 204));
        customerChoicePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel21.setText("Escolher cliente");

        submitCustomerChoiceBtn.setBackground(new java.awt.Color(51, 153, 0));
        submitCustomerChoiceBtn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        submitCustomerChoiceBtn.setForeground(new java.awt.Color(255, 255, 255));
        submitCustomerChoiceBtn.setText("Finalizar escolha");
        submitCustomerChoiceBtn.setToolTipText("");
        submitCustomerChoiceBtn.setAlignmentY(0.0F);
        submitCustomerChoiceBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        submitCustomerChoiceBtn.setPreferredSize(new java.awt.Dimension(122, 28));
        submitCustomerChoiceBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitCustomerChoiceBtnActionPerformed(evt);
            }
        });

        jScrollPane11.setPreferredSize(new java.awt.Dimension(740, 407));
        jScrollPane11.setRequestFocusEnabled(false);

        customerChoiceTable.setAutoCreateRowSorter(true);
        customerChoiceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome Completo", "Cpf", "Celular", "Telefone", "Endereço"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        loadCustomersTables();
        customerChoiceTable.setPreferredSize(new java.awt.Dimension(740, 207));
        customerChoiceTable.setShowGrid(true);
        customerChoiceTable.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                customerChoiceTableInputMethodTextChanged(evt);
            }
        });
        jScrollPane11.setViewportView(customerChoiceTable);
        if (customerChoiceTable.getColumnModel().getColumnCount() > 0) {
            customerChoiceTable.getColumnModel().getColumn(0).setPreferredWidth(20);
            customerChoiceTable.getColumnModel().getColumn(1).setPreferredWidth(200);
            customerChoiceTable.getColumnModel().getColumn(5).setPreferredWidth(200);
        }

        cancelCustomerChoiceBtn.setBackground(new java.awt.Color(102, 102, 102));
        cancelCustomerChoiceBtn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cancelCustomerChoiceBtn.setForeground(new java.awt.Color(255, 255, 255));
        cancelCustomerChoiceBtn.setText("Cancelar escolha");
        cancelCustomerChoiceBtn.setPreferredSize(new java.awt.Dimension(122, 28));
        cancelCustomerChoiceBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelCustomerChoiceBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout customerChoicePanelLayout = new javax.swing.GroupLayout(customerChoicePanel);
        customerChoicePanel.setLayout(customerChoicePanelLayout);
        customerChoicePanelLayout.setHorizontalGroup(
            customerChoicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(customerChoicePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cancelCustomerChoiceBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(submitCustomerChoiceBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
            .addGroup(customerChoicePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(customerChoicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, customerChoicePanelLayout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        customerChoicePanelLayout.setVerticalGroup(
            customerChoicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customerChoicePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(customerChoicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitCustomerChoiceBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelCustomerChoiceBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        sallerChoicePanel.setBackground(new java.awt.Color(204, 204, 204));
        sallerChoicePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel22.setText("Escolher vendedor");

        submitSellerChoiceBtn.setBackground(new java.awt.Color(51, 153, 0));
        submitSellerChoiceBtn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        submitSellerChoiceBtn.setForeground(new java.awt.Color(255, 255, 255));
        submitSellerChoiceBtn.setText("Finalizar escolha");
        submitSellerChoiceBtn.setToolTipText("");
        submitSellerChoiceBtn.setAlignmentY(0.0F);
        submitSellerChoiceBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        submitSellerChoiceBtn.setPreferredSize(new java.awt.Dimension(122, 28));
        submitSellerChoiceBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitSellerChoiceBtnActionPerformed(evt);
            }
        });

        jScrollPane12.setPreferredSize(new java.awt.Dimension(821, 402));

        employeeChoiceTable.setAutoCreateRowSorter(true);
        employeeChoiceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Nome Completo", "Cpf"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        loadEmployeesTables();
        employeeChoiceTable.setPreferredSize(new java.awt.Dimension(821, 159));
        employeeChoiceTable.setShowGrid(true);
        jScrollPane12.setViewportView(employeeChoiceTable);
        if (employeeChoiceTable.getColumnModel().getColumnCount() > 0) {
            employeeChoiceTable.getColumnModel().getColumn(0).setPreferredWidth(5);
        }

        cancelSellerChoiceBtn.setBackground(new java.awt.Color(102, 102, 102));
        cancelSellerChoiceBtn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cancelSellerChoiceBtn.setForeground(new java.awt.Color(255, 255, 255));
        cancelSellerChoiceBtn.setText("Cancelar escolha");
        cancelSellerChoiceBtn.setPreferredSize(new java.awt.Dimension(122, 28));
        cancelSellerChoiceBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelSellerChoiceBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sallerChoicePanelLayout = new javax.swing.GroupLayout(sallerChoicePanel);
        sallerChoicePanel.setLayout(sallerChoicePanelLayout);
        sallerChoicePanelLayout.setHorizontalGroup(
            sallerChoicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sallerChoicePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sallerChoicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sallerChoicePanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cancelSellerChoiceBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(submitSellerChoiceBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(sallerChoicePanelLayout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        sallerChoicePanelLayout.setVerticalGroup(
            sallerChoicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sallerChoicePanelLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sallerChoicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cancelSellerChoiceBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(submitSellerChoiceBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        customerNameCpfField.setEditable(false);
        customerNameCpfField.setBackground(new java.awt.Color(204, 204, 204));
        customerNameCpfField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
        customerNameCpfField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerNameCpfFieldActionPerformed(evt);
            }
        });

        employeeLabelName3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        employeeLabelName3.setText("Cliente");

        openChooseCustomerPanel.setBackground(new java.awt.Color(153, 153, 153));
        openChooseCustomerPanel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        openChooseCustomerPanel.setForeground(new java.awt.Color(255, 255, 255));
        openChooseCustomerPanel.setText("Buscar cliente");
        openChooseCustomerPanel.setToolTipText("");
        openChooseCustomerPanel.setAlignmentY(0.0F);
        openChooseCustomerPanel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        openChooseCustomerPanel.setPreferredSize(new java.awt.Dimension(122, 28));
        openChooseCustomerPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openChooseCustomerPanelActionPerformed(evt);
            }
        });

        employeeLabelName6.setText("Nome e CPF");

        employeeLabelName7.setText("ID");

        customerIdField.setEditable(false);
        customerIdField.setBackground(new java.awt.Color(204, 204, 204));
        customerIdField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
        customerIdField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerIdFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(employeeLabelName3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(employeeLabelName7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(customerIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(employeeLabelName6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(customerNameCpfField, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(openChooseCustomerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(employeeLabelName3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(customerIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(employeeLabelName7)
                        .addComponent(employeeLabelName6)
                        .addComponent(customerNameCpfField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(openChooseCustomerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        employeeLabelName4.setText("Nome e CPF");

        sallerNameCpfField.setEditable(false);
        sallerNameCpfField.setBackground(new java.awt.Color(204, 204, 204));
        sallerNameCpfField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
        sallerNameCpfField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sallerNameCpfFieldActionPerformed(evt);
            }
        });

        openChooseSellerPanel.setBackground(new java.awt.Color(153, 153, 153));
        openChooseSellerPanel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        openChooseSellerPanel.setForeground(new java.awt.Color(255, 255, 255));
        openChooseSellerPanel.setText("Buscar vendedor");
        openChooseSellerPanel.setToolTipText("");
        openChooseSellerPanel.setAlignmentY(0.0F);
        openChooseSellerPanel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        openChooseSellerPanel.setPreferredSize(new java.awt.Dimension(122, 28));
        openChooseSellerPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openChooseSellerPanelActionPerformed(evt);
            }
        });

        employeeLabelName8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        employeeLabelName8.setText("Vendedor");

        employeeLabelName9.setText("ID");

        sallerIdField.setEditable(false);
        sallerIdField.setBackground(new java.awt.Color(204, 204, 204));
        sallerIdField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
        sallerIdField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sallerIdFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(employeeLabelName8)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(employeeLabelName9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sallerIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(employeeLabelName4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sallerNameCpfField, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(openChooseSellerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(employeeLabelName8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(sallerIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(employeeLabelName9))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(employeeLabelName4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sallerNameCpfField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(openChooseSellerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout addSalePanelLayout = new javax.swing.GroupLayout(addSalePanel);
        addSalePanel.setLayout(addSalePanelLayout);
        addSalePanelLayout.setHorizontalGroup(
            addSalePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addSalePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addSalePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addSalePanelLayout.createSequentialGroup()
                        .addGroup(addSalePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addSalePanelLayout.createSequentialGroup()
                                .addComponent(cancelAddSaleBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(submitAddSaleBtn))
                            .addGroup(addSalePanelLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(customerChoicePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sallerChoicePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 1228, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(addSalePanelLayout.createSequentialGroup()
                        .addGroup(addSalePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        addSalePanelLayout.setVerticalGroup(
            addSalePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addSalePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(customerChoicePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sallerChoicePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addSalePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelAddSaleBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(submitAddSaleBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        customerChoicePanel.setVisible(false);
        sallerChoicePanel.setVisible(false);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setText("Vendas Realizadas");

        openAddSalePaneBtn.setBackground(new java.awt.Color(51, 153, 0));
        openAddSalePaneBtn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        openAddSalePaneBtn.setForeground(new java.awt.Color(255, 255, 255));
        openAddSalePaneBtn.setText("Nova venda");
        openAddSalePaneBtn.setPreferredSize(new java.awt.Dimension(80, 25));
        openAddSalePaneBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openAddSalePaneBtnActionPerformed(evt);
            }
        });

        jScrollPane5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane5.setPreferredSize(new java.awt.Dimension(1240, 402));

        salesTable.setAutoCreateRowSorter(true);
        salesTable.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        salesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Cliente", "Endereço Completo", "Vendedor", "Itens", "Valor Liquido", "Desconto", "Valor Bruto", "Pagamentos"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        loadSalesTable();
        salesTable.setMaximumSize(new java.awt.Dimension(0, 0));
        salesTable.setMinimumSize(new java.awt.Dimension(0, 0));
        salesTable.setPreferredSize(new java.awt.Dimension(1240, 402));
        salesTable.setRowHeight(40);
        salesTable.setShowGrid(true);
        jScrollPane5.setViewportView(salesTable);
        if (salesTable.getColumnModel().getColumnCount() > 0) {
            salesTable.getColumnModel().getColumn(0).setPreferredWidth(40);
            salesTable.getColumnModel().getColumn(2).setPreferredWidth(200);
            salesTable.getColumnModel().getColumn(4).setPreferredWidth(300);
            salesTable.getColumnModel().getColumn(5).setPreferredWidth(30);
            salesTable.getColumnModel().getColumn(6).setPreferredWidth(30);
            salesTable.getColumnModel().getColumn(7).setPreferredWidth(30);
            salesTable.getColumnModel().getColumn(8).setPreferredWidth(200);
        }

        DeleteSalesBtn.setBackground(new java.awt.Color(153, 0, 51));
        DeleteSalesBtn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        DeleteSalesBtn.setForeground(new java.awt.Color(255, 255, 255));
        DeleteSalesBtn.setText("Deletar vendas selecionadas");
        DeleteSalesBtn.setPreferredSize(new java.awt.Dimension(80, 25));
        DeleteSalesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteSalesBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout salesPanelLayout = new javax.swing.GroupLayout(salesPanel);
        salesPanel.setLayout(salesPanelLayout);
        salesPanelLayout.setHorizontalGroup(
            salesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(salesPanelLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(salesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(addSalePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DeleteSalesBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, salesPanelLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(openAddSalePaneBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        salesPanelLayout.setVerticalGroup(
            salesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(salesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addSalePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(salesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(openAddSalePaneBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DeleteSalesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        addSalePanel.setVisible(false);

        tabbedPane.addTab("Vendas", salesPanel);

        tabbedPanelScrollPane.setViewportView(tabbedPane);

        getContentPane().add(tabbedPanelScrollPane);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openAddCustomerPaneBtnComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_openAddCustomerPaneBtnComponentHidden

    }//GEN-LAST:event_openAddCustomerPaneBtnComponentHidden

    private void openAddCustomerPaneBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openAddCustomerPaneBtnActionPerformed
        editCustomerPanel.setVisible(false);
        addCustomerPanel.setVisible(true); 
    }//GEN-LAST:event_openAddCustomerPaneBtnActionPerformed

    private void deleteCustomersBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCustomersBtnActionPerformed
        try {
            int[] selectedRows = customersTable.getSelectedRows();

            if (selectedRows.length != 0) {
                for(int i = selectedRows.length - 1; i >= 0; i--) {
                    int selectedRowIndex = selectedRows[i];
                    Object customerIdObject = customersTable.getValueAt(selectedRowIndex, 0);
                    int customerIdInt = (int) customerIdObject;
                    
                    customerDAO.delete(customerIdInt);
                    loadCustomersTables();
                    JOptionPane.showMessageDialog(this, "Cliente deletado com sucesso!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Nenhum cliente selecionado!");
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(this, "Erro ao deletar cliente(s)" + e.getMessage());
        }     
    }//GEN-LAST:event_deleteCustomersBtnActionPerformed

    private void editCellphoneFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCellphoneFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editCellphoneFieldActionPerformed

    private void editCustomerNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCustomerNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editCustomerNameFieldActionPerformed

    private void editCustomerCpfFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCustomerCpfFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editCustomerCpfFieldActionPerformed

    private void editDescriptionFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editDescriptionFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editDescriptionFieldActionPerformed

    private void openAddCustomerPaneBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openAddCustomerPaneBtnMouseClicked
     
    }//GEN-LAST:event_openAddCustomerPaneBtnMouseClicked

    private void addEmployeeCpfFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEmployeeCpfFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addEmployeeCpfFieldActionPerformed

    private void addEmployeeNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEmployeeNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addEmployeeNameFieldActionPerformed

    private void deleteEmployeesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteEmployeesBtnActionPerformed
        try {
            int[] selectedRows = employeesTable.getSelectedRows();

            if (selectedRows.length != 0) {
                for(int i = selectedRows.length - 1; i >= 0; i--) {
                    int selectedRowIndex = selectedRows[i];
                    Object idObject = employeesTable.getValueAt(selectedRowIndex, 0);
                    int idInt = (int) idObject;
                    
                    employeeDAO.delete(idInt); 
                    loadEmployeesTables();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Nenhum funcionário selecionado!");
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(this, "Erro ao deletar funcionário(s)" + e.getMessage());
        }  
    }//GEN-LAST:event_deleteEmployeesBtnActionPerformed

    private void openAddEmployeePaneBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openAddEmployeePaneBtnActionPerformed
        addEmployeeNameField.setText("");
        addEmployeeCpfField.setText("");
        
        addEmployeePanel.setVisible(true);
        editEmployeePanel.setVisible(false);
    }//GEN-LAST:event_openAddEmployeePaneBtnActionPerformed

    private void paymentAmountFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentAmountFieldActionPerformed

    }//GEN-LAST:event_paymentAmountFieldActionPerformed

    private void addPaymentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPaymentBtnActionPerformed
        DefaultTableModel paymentsTableModel = (DefaultTableModel) paymentsTable.getModel();
        
        String paymentMethod = (String) paymentMethodCb.getSelectedItem();
        if(paymentMethod == null || paymentMethod.isEmpty()) {
            JOptionPane.showMessageDialog(this, "O método de pagamento não pode está vázio");
            return;
        }
        
        String paymentAmountStr = paymentAmountField.getText().replace(",", ".");
        if(paymentAmountStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "A quantia do pagamento não pode está vázio");
            return;
        }
        double paymentAmount;
        paymentAmount = Double.parseDouble(paymentAmountStr);

        double remainingAmount = Double.parseDouble(remainingAmountField.getText().replace(",", "."));
        
        try {
            if (paymentAmount <= remainingAmount) {
                paymentsTableModel.addRow(new Object[]{
                    paymentMethod,
                    paymentAmount
                });
                setRemainingAmount();
            } else {
                JOptionPane.showMessageDialog(this, "Valor de pagamento acima do valor restante.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
       } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Valores inválidos.", "Erro", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_addPaymentBtnActionPerformed

    private void deletePaymentsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletePaymentsBtnActionPerformed
        DefaultTableModel saleItemsTableModel = (DefaultTableModel) paymentsTable.getModel();
        int[] selectedRows = paymentsTable.getSelectedRows();
        for(int i = selectedRows.length - 1; i >= 0; i--) {
            saleItemsTableModel.removeRow(selectedRows[i]);
        }
    
        setRemainingAmount();
    }//GEN-LAST:event_deletePaymentsBtnActionPerformed

    private void remainingAmountFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remainingAmountFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_remainingAmountFieldActionPerformed

    private void openAddSalePaneBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openAddSalePaneBtnActionPerformed
        DefaultTableModel saleItemsTableModel = (DefaultTableModel) saleItemsTable.getModel();
        DefaultTableModel paymentsTableModel = (DefaultTableModel) paymentsTable.getModel();
        
        unitPriceField.setText("");
        itemQuantityField.setText("");
        saleItemsTableModel.setRowCount(0);
        paymentsTableModel.setRowCount(0);
        applyDiscountField.setText("");
        paymentMethodCb.setSelectedItem(0);
        paymentAmountField.setText("");
        remainingAmountField.setText("0.00");
        sallerNameCpfField.setText("");
        sallerIdField.setText("");
        customerNameCpfField.setText("");
        customerIdField.setText("");
        productIdField.setText("");
        totalValueField.setText("0.00");
        productDescriptionField.setText("");
                
        addSalePanel.setVisible(true);
    }//GEN-LAST:event_openAddSalePaneBtnActionPerformed

    private void addSaleItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSaleItemBtnActionPerformed
        if (
            productIdField.getText().isEmpty() || 
            productDescriptionField.getText().isEmpty() || 
            unitPriceField.getText().isEmpty() || 
            itemQuantityField.getText().isEmpty()) {

            JOptionPane.showMessageDialog(this, "Todos os campos devem ser preenchidos.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int productId;
        try {
            productId = Integer.parseInt(productIdField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID do produto inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String productDescription = productDescriptionField.getText();

        double unitPrice;
        try {
            unitPrice = Double.parseDouble(unitPriceField.getText().replace(",", "."));   
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Preço unitário inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int itemQuantity;
        try {
            itemQuantity = Integer.parseInt(itemQuantityField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Quantidade do item inválida.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double totalValue = unitPrice * itemQuantity;

        DefaultTableModel saleItemsTableModel = (DefaultTableModel) saleItemsTable.getModel();
        saleItemsTableModel.addRow(new Object[]{
            productId,
            productDescription,
            unitPrice,
            itemQuantity,
            totalValue
        });

        setTotalValue();
        setRemainingAmount();
       
    }//GEN-LAST:event_addSaleItemBtnActionPerformed

    private void unitPriceFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unitPriceFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unitPriceFieldActionPerformed

    private void itemQuantityFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemQuantityFieldActionPerformed

    }//GEN-LAST:event_itemQuantityFieldActionPerformed

    private void deleteSaleItemsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteSaleItemsBtnActionPerformed
        DefaultTableModel saleItemsTableModel = (DefaultTableModel) saleItemsTable.getModel();
        int[] selectedRows = saleItemsTable.getSelectedRows();
        
        for(int i = selectedRows.length - 1; i >= 0; i--) {
            saleItemsTableModel.removeRow(selectedRows[i]);
        }
        
        setTotalValue();
    }//GEN-LAST:event_deleteSaleItemsBtnActionPerformed

    private void applyDiscountFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyDiscountFieldActionPerformed

    }//GEN-LAST:event_applyDiscountFieldActionPerformed

    private void totalValueFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalValueFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalValueFieldActionPerformed

    private void paymentMethodCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentMethodCbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paymentMethodCbActionPerformed

    private void submitAddSaleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitAddSaleBtnActionPerformed
        try {
            String customerIdStr = customerIdField.getText();
            if (customerIdStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "O campo do cliente não pode estar vazio.");
                return;
            }
            int customerId = Integer.parseInt(customerIdStr);

            String sallerIdStr = sallerIdField.getText();
            if (sallerIdStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "O campo do vendedor não pode estar vazio.");
                return;
            }
            int sallerId = Integer.parseInt(sallerIdStr);

            String discountStr = discountField.getText().replace(",", ".");
            Double discount;
            if (discountStr.isEmpty()) {
                discount = 0.00;
            } else {
                discount = Double.valueOf(discountStr);
            }

            List<SaleItem> saleItems = new ArrayList<>();
            int saleItemsRowCount = saleItemsTable.getRowCount();
            if (saleItemsRowCount == 0) {
                JOptionPane.showMessageDialog(this, "A venda deve conter pelo menos um item.");
                return;
            }

            for (int i = 0; i < saleItemsRowCount; i++) {
                int productId = (int) saleItemsTable.getValueAt(i, 0);
                double unitValue = (Double) saleItemsTable.getValueAt(i, 2);
                int quantity = (int) saleItemsTable.getValueAt(i, 3);

                Product product = productDAO.findById(productId);
                SaleItem saleItem = new SaleItem(product, unitValue, quantity);
                saleItems.add(saleItem);
            }

            // Criar lista de pagamentos
            List<Payment> payments = new ArrayList<>();
            int paymentsRowCount = paymentsTable.getRowCount();
            if (paymentsRowCount == 0) {
                JOptionPane.showMessageDialog(this, "A venda deve conter pelo menos um pagamento.");
                return;
            }

            for (int i = 0; i < paymentsRowCount; i++) {
                String paymentMethod = (String) paymentsTable.getValueAt(i, 0);
                double paymentAmount = (double) paymentsTable.getValueAt(i, 1);

                Payment payment = new Payment(paymentAmount, paymentMethod);
                payments.add(payment);
            }

            // Obter cliente e vendedor do banco de dados
            Customer customer = customerDAO.findById(customerId);
            if (customer == null) {
                JOptionPane.showMessageDialog(this, "Cliente não encontrado.");
                return;
            }

            Employee saller = employeeDAO.findById(sallerId);
            if (saller == null) {
                JOptionPane.showMessageDialog(this, "Vendedor não encontrado.");
                return;
            }

            Sale sale = new Sale(saleItems, customer, saller, discount, payments);
            saleDAO.save(sale);
            JOptionPane.showMessageDialog(this, "Venda registrada com sucesso!");

            tabbedPanelScrollPane.getViewport().setViewPosition(new Point(0, 0));
            loadSalesTable();
            salesPanel.setVisible(false);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Formato de número incorreto.");
            System.out.println("Ocorreu um erro ao registrar a venda: " + e.getMessage());
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "Um dos campos obrigatórios está vazio");
            System.out.println("Ocorreu um erro ao registrar a venda: " + e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro inesperado ao registrar a venda");
            System.out.println("Ocorreu um erro ao registrar a venda: " + e.getMessage());
        }
    }//GEN-LAST:event_submitAddSaleBtnActionPerformed

    private void cancelAddSaleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelAddSaleBtnActionPerformed
        addSalePanel.setVisible(false);
    }//GEN-LAST:event_cancelAddSaleBtnActionPerformed

    private void CancelEditCustomerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelEditCustomerBtnActionPerformed
        editCustomerPanel.setVisible(false);
    }//GEN-LAST:event_CancelEditCustomerBtnActionPerformed

    private void submitEditCustomerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitEditCustomerBtnActionPerformed
        try {
            int customerId = Integer.parseInt(editCustomerIdField.getText());
            String name = editCustomerNameField.getText();
            String cpf = editCustomerCpfField.getText();
            String cellphone = editCellphoneField.getText();
            String tellphone = editTellphoneField.getText();
            String logradouro = editLogradouroField.getText();
            String addressNumber = editAddressNumberField.getText();
            String complement = editComplementField.getText();
            String bairro = editBairroField.getText();
            String city = editCityField.getText();
            String uf = editUfField.getText();

            Address address = addressDAO.findById(customerId);
            int addressId = address.getId();

            Address newAddress = new Address(addressId, customerId, logradouro, addressNumber, complement, bairro, city, uf);
            Customer newCustomer = new Customer(customerId, name, cpf, cellphone, tellphone, newAddress);
            if(validateFields(name)) {
                customerDAO.update(newCustomer);
                loadCustomersTables();
                JOptionPane.showMessageDialog(this, "Cliente atualizado com sucesso!");
                editCustomerPanel.setVisible(false);
            }           
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(this, "Não foi possivel atualizar cliente");
            System.out.println("Não foi possivel atualizar cliente: " + e.getMessage());
        }
    }//GEN-LAST:event_submitEditCustomerBtnActionPerformed

    private void editLogradouroFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editLogradouroFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editLogradouroFieldActionPerformed

    private void editAddressNumberFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editAddressNumberFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editAddressNumberFieldActionPerformed

    private void editComplementFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editComplementFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editComplementFieldActionPerformed

    private void editBairroFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBairroFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editBairroFieldActionPerformed

    private void editCityFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCityFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editCityFieldActionPerformed

    private void cancelAddEmployeeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelAddEmployeeBtnActionPerformed
       addEmployeePanel.setVisible(false);
    }//GEN-LAST:event_cancelAddEmployeeBtnActionPerformed

    private void submitAddEmployeeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitAddEmployeeBtnActionPerformed
        String name = addEmployeeNameField.getText();
        String cpf = addEmployeeCpfField.getText();
        
        Employee employee = new Employee(name, cpf);
        try {
            if(validateFields(name)) {
                employeeDAO.save(employee);
                JOptionPane.showMessageDialog(this, "Funcionário adicionado com sucesso!");
                loadEmployeesTables();
                addEmployeePanel.setVisible(false);
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(this, "Erro ao adicionar funcionário");
            System.out.println("Erro ao adicionar funcionário: " + e.getMessage());
        }      
    }//GEN-LAST:event_submitAddEmployeeBtnActionPerformed

    private void cancelEditProductBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelEditProductBtnActionPerformed
        editProductPanel.setVisible(false);
    }//GEN-LAST:event_cancelEditProductBtnActionPerformed

    private void submitEditProductBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitEditProductBtnActionPerformed
        try {
            String id = editProductIdField.getText();
            String description = editDescriptionField.getText();
            String cost = editCostField.getText();
            String price = editPriceField.getText();
            String quantity = editProductQuantityField.getText();

            if (cost.trim().isEmpty()) {
                cost = "0.00";
            }

            if (price.trim().isEmpty()) {
                price = "0.00";
            }

            if (quantity.trim().isEmpty()) {
                quantity = "0";
            }

            Product product = new Product(
                Integer.parseInt(id),
                description,
                Double.valueOf(cost),
                Double.valueOf(price),
                Integer.parseInt(quantity)
            );

            productDAO.update(product);
            loadProductsTables();

            editProductPanel.setVisible(false);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, insira valores numéricos válidos para custo, preço e quantidade");
            System.out.println("Ocorreu um erro ao atualizar o produto: " + e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocorreu um erro ao atualizar o produto");
            System.out.println("Ocorreu um erro ao atualizar o produto: " + e.getMessage());
        }
    }//GEN-LAST:event_submitEditProductBtnActionPerformed

    private void deleteProductsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteProductsBtnActionPerformed
       try {
            int[] selectedRows = productsTable.getSelectedRows();

            if (selectedRows.length != 0) {
                for(int i = selectedRows.length - 1; i >= 0; i--) {
                    int selectedRowIndex = selectedRows[i];
                    Object idObject = productsTable.getValueAt(selectedRowIndex, 0);
                    int idInt = (int) idObject;
                    
                    productDAO.delete(idInt); 
                    loadProductsTables();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Nenhum produto selecionado!");
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(this, "Erro ao deletar produto(s)" + e.getMessage());
        } 
    }//GEN-LAST:event_deleteProductsBtnActionPerformed

    private void addCellphoneFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCellphoneFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addCellphoneFieldActionPerformed

    private void addCustomerNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCustomerNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addCustomerNameFieldActionPerformed

    private void addCustomerCpfFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCustomerCpfFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addCustomerCpfFieldActionPerformed

    private void cancelAddPaymentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelAddPaymentBtnActionPerformed
        addCustomerPanel.setVisible(false);
    }//GEN-LAST:event_cancelAddPaymentBtnActionPerformed

    private void submitAddCustomerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitAddCustomerBtnActionPerformed
        String name = addCustomerNameField.getText();
        String cpf = addCustomerCpfField.getText();
        String cellphone = addCellphoneField.getText();
        String tellphone = addTellphoneField.getText();
        String logradouro = addLogradouroField.getText();
        String addressNumber = addAddressNumberField.getText();
        String complement = addComplementField.getText();
        String bairro = addBairroField.getText();
        String city = addCityField.getText();
        String uf = addUfField.getText();
        
        Address address = new Address(logradouro, addressNumber, complement, bairro, city, uf);
        Customer customer = new Customer(name, cpf, cellphone, tellphone, address);
   
        try {
            if (validateFields(name)) {
                customerDAO.save(customer);
                JOptionPane.showMessageDialog(this, "Cliente adicionado com sucesso!");
                loadCustomersTables();
                addCustomerPanel.setVisible(false);
            }
        } catch (HeadlessException e) {
               JOptionPane.showMessageDialog(this, "Erro ao adicionar cliente :" + e.getMessage());  
        }
    }//GEN-LAST:event_submitAddCustomerBtnActionPerformed

    private void addLogradouroFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addLogradouroFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addLogradouroFieldActionPerformed

    private void addAddressNumberFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAddressNumberFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addAddressNumberFieldActionPerformed

    private void addComplementFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addComplementFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addComplementFieldActionPerformed

    private void addBairroFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBairroFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addBairroFieldActionPerformed

    private void addCityFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCityFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addCityFieldActionPerformed

    private void editCustomerIdFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCustomerIdFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editCustomerIdFieldActionPerformed

    private void editEmployeeNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editEmployeeNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editEmployeeNameFieldActionPerformed

    private void editEmployeeCpfFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editEmployeeCpfFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editEmployeeCpfFieldActionPerformed

    private void cancelEditEmployeeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelEditEmployeeBtnActionPerformed
        editEmployeePanel.setVisible(false);
    }//GEN-LAST:event_cancelEditEmployeeBtnActionPerformed

    private void submitEditEmployeeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitEditEmployeeBtnActionPerformed
        try {
            int id = Integer.parseInt(editEmployeeIdField.getText());
            String name = editEmployeeNameField.getText();
            String cpf = editEmployeeCpfField.getText();     
            Employee employee = new Employee(id, name, cpf);
            if (validateFields(name)) {
                employeeDAO.update(employee);
                JOptionPane.showMessageDialog(this, "Funcionário atualizado com sucesso!");
                loadEmployeesTables();
                editEmployeePanel.setVisible(false);
            }
        } catch(HeadlessException e) {
            System.out.println("Erro ao atualizar funcionário" + e.getMessage());       
        }        
    }//GEN-LAST:event_submitEditEmployeeBtnActionPerformed

    private void DeleteSalesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteSalesBtnActionPerformed
        int[] selectedRows = salesTable.getSelectedRows();
        
        if (selectedRows.length != 0) {
            for (int i = 0; i < selectedRows.length; i++) {
                int id = (int) salesTable.getValueAt(i, 0);
                saleDAO.delete(id);
                
            }
        loadSalesTable();
        JOptionPane.showMessageDialog(this, "Venda deletada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(this, "Selecione alguma(s) venda(s) antes de a deletar.");
        }
    }//GEN-LAST:event_DeleteSalesBtnActionPerformed

    private void addDescriptionFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDescriptionFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addDescriptionFieldActionPerformed

    private void cancelAddProductBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelAddProductBtnActionPerformed
        addProductPanel.setVisible(false);
    }//GEN-LAST:event_cancelAddProductBtnActionPerformed

    private void submitAddProductBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitAddProductBtnActionPerformed
        try {
            String description = addDescriptionField.getText();
            String costText = addCostField.getText().replace(",", ".");
            String priceText = addPriceField.getText().replace(",", ".");
            String quantityText = addProductQuantityField.getText();
            
            if(costText.trim().isEmpty()){
                costText = "0.00";
            }
            
            if(priceText.trim().isEmpty()){
                priceText = "0.00";
            }
            
            if(quantityText.trim().isEmpty()) {
                quantityText = "0";
            }

            Double cost = Double.valueOf(costText);
            Double price = Double.valueOf(priceText);
            int quantity = Integer.parseInt(quantityText);
                       
            Product product = new Product(description, cost, price, quantity);
            if(validateFields(description)) {
                productDAO.save(product);
            }
            
            loadProductsTables();
            addProductPanel.setVisible(false);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, insira valores numéricos válidos para custo, preço e quantidade.");
            System.out.println(e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocorreu um erro ao adicionar o produto.");
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_submitAddProductBtnActionPerformed

    private void editProductIdFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editProductIdFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editProductIdFieldActionPerformed

    private void openAddProductPaneBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openAddProductPaneBtnActionPerformed
        addDescriptionField.setText("");
        addCostField.setText("");
        addPriceField.setText("");
        addProductQuantityField.setText("");
        
        editProductPanel.setVisible(false);
        addProductPanel.setVisible(true); 
    }//GEN-LAST:event_openAddProductPaneBtnActionPerformed

    private void openEditEmployeePanelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openEditEmployeePanelBtnActionPerformed
        int selectedRow = employeesTable.getSelectedRow();
        
        try {
            if (selectedRow != -1) {
                Object idObject = employeesTable.getValueAt(selectedRow, 0);
                int idInt = (int) idObject;
                Employee employee = employeeDAO.findById(idInt);
                String name = employee.getName();
                String cpf = employee.getCpf(); 

                editEmployeeIdField.setText(String.valueOf(idInt));
                editEmployeeNameField.setText(name);
                editEmployeeCpfField.setText(cpf);

                editEmployeePanel.setVisible(true);
                addEmployeePanel.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "Nenhuma linha selecionada");
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(this, "Erro ao atualizar funcionário");
            System.out.println("Erro ao atualizar funcionário" + e.getMessage());
        }
    }//GEN-LAST:event_openEditEmployeePanelBtnActionPerformed

    private void openEditCustomerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openEditCustomerBtnActionPerformed
        int selectedRow = customersTable.getSelectedRow();
        if (selectedRow != -1) {
            // Obtém o valor da primeira coluna da linha selecionada
            Object idObject = customersTable.getValueAt(selectedRow, 0);
            int idInt = (int) idObject;
            Customer customer = customerDAO.findById(idInt);
            Address address = customer.getAddress();
            
            editCustomerIdField.setText(String.valueOf(customer.getId()));
            editCustomerNameField.setText(customer.getName());
            editCustomerCpfField.setText(customer.getCpf());
            editCellphoneField.setText(customer.getCellphone());
            editTellphoneField.setText(customer.getTellphone());
            editLogradouroField.setText(address.getLogradouro());
            editAddressNumberField.setText(address.getAddressNumber());
            editBairroField.setText(address.getBairro());
            editComplementField.setText(address.getComplement());
            editCityField.setText(address.getCity());
            editUfField.setText(address.getUf());
            
            editCustomerPanel.setVisible(true);
            addCustomerPanel.setVisible(false);
        } else {
            // Informa ao usuário que nenhuma linha está selecionada
            JOptionPane.showMessageDialog(this, "Nenhuma linha selecionada");
        }        
    }//GEN-LAST:event_openEditCustomerBtnActionPerformed

    private void openEditProductPaneBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openEditProductPaneBtnActionPerformed
        int selectedRow = productsTable.getSelectedRow();
        
        if (selectedRow != -1) {
            Object idObject = productsTable.getValueAt(selectedRow, 0);
            int idInt = (int) idObject;

            Product product = productDAO.findById(idInt);

            String id = String.valueOf(idInt);
            String description = product.getDescription();
            String cost = String.valueOf(product.getCost());
            String price = String.valueOf(product.getPrice());
            String quantity = String.valueOf(product.getQuantity());

            editProductIdField.setText(id);
            editDescriptionField.setText(description);
            editCostField.setText(cost);
            editPriceField.setText(price);
            editProductQuantityField.setText(quantity);

            editProductPanel.setVisible(true);
            addProductPanel.setVisible(false);
        } else {
            // Informa ao usuário que nenhuma linha está selecionada
            JOptionPane.showMessageDialog(this, "Nenhuma linha selecionada");
        }        
    }//GEN-LAST:event_openEditProductPaneBtnActionPerformed

    private void editEmployeeIdFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editEmployeeIdFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editEmployeeIdFieldActionPerformed

    private void addSaleAddSaleItemBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSaleAddSaleItemBtn1ActionPerformed
        productChoisePanel.setVisible(true);
    }//GEN-LAST:event_addSaleAddSaleItemBtn1ActionPerformed

    private void productDescriptionFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productDescriptionFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productDescriptionFieldActionPerformed

    private void customerNameCpfFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerNameCpfFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerNameCpfFieldActionPerformed

    private void sallerNameCpfFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sallerNameCpfFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sallerNameCpfFieldActionPerformed

    private void openChooseCustomerPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openChooseCustomerPanelActionPerformed
       customerChoicePanel.setVisible(true);
    }//GEN-LAST:event_openChooseCustomerPanelActionPerformed

    private void openChooseSellerPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openChooseSellerPanelActionPerformed
        sallerChoicePanel.setVisible(true);
    }//GEN-LAST:event_openChooseSellerPanelActionPerformed

    private void submitCustomerChoiceBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitCustomerChoiceBtnActionPerformed
        int selectedRow = customerChoiceTable.getSelectedRow();
        
        if (selectedRow != -1) {
            Object idObj = customerChoiceTable.getValueAt(selectedRow, 0);
            Object nameObj = customerChoiceTable.getValueAt(selectedRow, 1);

            String id = String.valueOf((int) idObj);
            String name = String.valueOf(nameObj);

            customerIdField.setText(id);
            customerNameCpfField.setText(name);
            customerChoicePanel.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "Nenhum cliente selecionado");
        }
    }//GEN-LAST:event_submitCustomerChoiceBtnActionPerformed

    private void submitSellerChoiceBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitSellerChoiceBtnActionPerformed
        int selectedRow = employeeChoiceTable.getSelectedRow();
        
        if (selectedRow != -1) {
            Object idObj = employeeChoiceTable.getValueAt(selectedRow, 0);
            Object nameObj = employeeChoiceTable.getValueAt(selectedRow, 1);

            String id = String.valueOf((int) idObj);
            String name = String.valueOf(nameObj);

            sallerIdField.setText(id);
            sallerNameCpfField.setText(name);
            sallerChoicePanel.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "Nenhum funcionário selecionado");
        }
    }//GEN-LAST:event_submitSellerChoiceBtnActionPerformed

    private void customerChoiceTableInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_customerChoiceTableInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_customerChoiceTableInputMethodTextChanged

    private void cancelCustomerChoiceBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelCustomerChoiceBtnActionPerformed
        customerChoicePanel.setVisible(false);
    }//GEN-LAST:event_cancelCustomerChoiceBtnActionPerformed

    private void cancelSellerChoiceBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelSellerChoiceBtnActionPerformed
        sallerChoicePanel.setVisible(false);
    }//GEN-LAST:event_cancelSellerChoiceBtnActionPerformed

    private void submitProductChoiseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitProductChoiseBtnActionPerformed
        int selectedRow = productChoiceTable.getSelectedRow();
        
        if (selectedRow != -1) {
            Object idObj = productChoiceTable.getValueAt(selectedRow, 0);
            Object descriptionObj = productChoiceTable.getValueAt(selectedRow, 1);
            Object priceObj = productChoiceTable.getValueAt(selectedRow, 3);

            String id = String.valueOf((int) idObj);
            String description = String.valueOf(descriptionObj);
            String price = String.valueOf(priceObj);

            productIdField.setText(id);
            productDescriptionField.setText(description);
            unitPriceField.setText(price);

            productChoisePanel.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "Nenhum produto selecionado");
        }
    }//GEN-LAST:event_submitProductChoiseBtnActionPerformed

    private void cancelProductChoiceBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelProductChoiceBtnActionPerformed
        productChoisePanel.setVisible(false);
    }//GEN-LAST:event_cancelProductChoiceBtnActionPerformed

    private void productIdFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productIdFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productIdFieldActionPerformed

    private void customerIdFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerIdFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerIdFieldActionPerformed

    private void sallerIdFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sallerIdFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sallerIdFieldActionPerformed

    private void applyDiscountFieldInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_applyDiscountFieldInputMethodTextChanged
        
    }//GEN-LAST:event_applyDiscountFieldInputMethodTextChanged

    private void applyDiscountFieldPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_applyDiscountFieldPropertyChange
    
    }//GEN-LAST:event_applyDiscountFieldPropertyChange

    private void applyDiscountFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_applyDiscountFieldFocusLost

    }//GEN-LAST:event_applyDiscountFieldFocusLost

    private void applyDiscountBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyDiscountBtnActionPerformed
        discountField.setText(applyDiscountField.getText());
        setTotalValue();
    }//GEN-LAST:event_applyDiscountBtnActionPerformed

    private void applyDiscountFieldCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_applyDiscountFieldCaretPositionChanged
        
    }//GEN-LAST:event_applyDiscountFieldCaretPositionChanged

    private void discountFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discountFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_discountFieldActionPerformed

    private void addCostFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCostFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addCostFieldActionPerformed

    private void editCostFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCostFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editCostFieldActionPerformed

    private void editPriceFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editPriceFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editPriceFieldActionPerformed

    private void addPriceFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPriceFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addPriceFieldActionPerformed

    private void editProductQuantityFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editProductQuantityFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editProductQuantityFieldActionPerformed

    private void addProductQuantityFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProductQuantityFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addProductQuantityFieldActionPerformed

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
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelEditCustomerBtn;
    private javax.swing.JButton DeleteSalesBtn;
    private javax.swing.JTextField addAddressNumberField;
    private javax.swing.JTextField addBairroField;
    private javax.swing.JFormattedTextField addCellphoneField;
    private javax.swing.JTextField addCityField;
    private javax.swing.JTextField addComplementField;
    private javax.swing.JFormattedTextField addCostField;
    private javax.swing.JFormattedTextField addCustomerCpfField;
    private javax.swing.JTextField addCustomerNameField;
    private javax.swing.JPanel addCustomerPanel;
    private javax.swing.JTextField addDescriptionField;
    private javax.swing.JFormattedTextField addEmployeeCpfField;
    private javax.swing.JTextField addEmployeeNameField;
    private javax.swing.JPanel addEmployeePanel;
    private javax.swing.JTextField addLogradouroField;
    private javax.swing.JButton addPaymentBtn;
    private javax.swing.JFormattedTextField addPriceField;
    private javax.swing.JPanel addProductPanel;
    private javax.swing.JTextField addProductQuantityField;
    private javax.swing.JButton addSaleAddSaleItemBtn1;
    private javax.swing.JButton addSaleItemBtn;
    private javax.swing.JPanel addSalePanel;
    private javax.swing.JFormattedTextField addTellphoneField;
    private javax.swing.JFormattedTextField addUfField;
    private javax.swing.JButton applyDiscountBtn;
    private javax.swing.JFormattedTextField applyDiscountField;
    private javax.swing.JButton cancelAddEmployeeBtn;
    private javax.swing.JButton cancelAddPaymentBtn;
    private javax.swing.JButton cancelAddProductBtn;
    private javax.swing.JButton cancelAddSaleBtn;
    private javax.swing.JButton cancelCustomerChoiceBtn;
    private javax.swing.JButton cancelEditEmployeeBtn;
    private javax.swing.JButton cancelEditProductBtn;
    private javax.swing.JButton cancelProductChoiceBtn;
    private javax.swing.JButton cancelSellerChoiceBtn;
    private javax.swing.JLabel customerCellphoneLabel;
    private javax.swing.JLabel customerCellphoneLabel1;
    private javax.swing.JPanel customerChoicePanel;
    private javax.swing.JTable customerChoiceTable;
    private javax.swing.JLabel customerCpfLabel;
    private javax.swing.JLabel customerCpfLabel1;
    private javax.swing.JFormattedTextField customerIdField;
    private javax.swing.JLabel customerLabelName;
    private javax.swing.JLabel customerLabelName1;
    private javax.swing.JLabel customerLabelName10;
    private javax.swing.JLabel customerLabelName11;
    private javax.swing.JLabel customerLabelName12;
    private javax.swing.JLabel customerLabelName13;
    private javax.swing.JLabel customerLabelName14;
    private javax.swing.JLabel customerLabelName15;
    private javax.swing.JLabel customerLabelName16;
    private javax.swing.JLabel customerLabelName17;
    private javax.swing.JLabel customerLabelName2;
    private javax.swing.JLabel customerLabelName20;
    private javax.swing.JLabel customerLabelName21;
    private javax.swing.JLabel customerLabelName22;
    private javax.swing.JLabel customerLabelName23;
    private javax.swing.JLabel customerLabelName24;
    private javax.swing.JLabel customerLabelName25;
    private javax.swing.JLabel customerLabelName26;
    private javax.swing.JLabel customerLabelName27;
    private javax.swing.JLabel customerLabelName28;
    private javax.swing.JLabel customerLabelName29;
    private javax.swing.JLabel customerLabelName3;
    private javax.swing.JLabel customerLabelName34;
    private javax.swing.JLabel customerLabelName35;
    private javax.swing.JLabel customerLabelName36;
    private javax.swing.JLabel customerLabelName37;
    private javax.swing.JLabel customerLabelName38;
    private javax.swing.JLabel customerLabelName39;
    private javax.swing.JLabel customerLabelName4;
    private javax.swing.JLabel customerLabelName5;
    private javax.swing.JLabel customerLabelName6;
    private javax.swing.JLabel customerLabelName7;
    private javax.swing.JLabel customerLabelName8;
    private javax.swing.JLabel customerLabelName9;
    private javax.swing.JFormattedTextField customerNameCpfField;
    private javax.swing.JLabel customerTellphoneLabel;
    private javax.swing.JLabel customerTellphoneLabel1;
    private javax.swing.JPanel customersPanel;
    private javax.swing.JTable customersTable;
    private javax.swing.JButton deleteCustomersBtn;
    private javax.swing.JButton deleteEmployeesBtn;
    private javax.swing.JButton deletePaymentsBtn;
    private javax.swing.JButton deleteProductsBtn;
    private javax.swing.JButton deleteSaleItemsBtn;
    private javax.swing.JFormattedTextField discountField;
    private javax.swing.JTextField editAddressNumberField;
    private javax.swing.JTextField editBairroField;
    private javax.swing.JFormattedTextField editCellphoneField;
    private javax.swing.JTextField editCityField;
    private javax.swing.JTextField editComplementField;
    private javax.swing.JFormattedTextField editCostField;
    private javax.swing.JFormattedTextField editCustomerCpfField;
    private javax.swing.JTextField editCustomerIdField;
    private javax.swing.JTextField editCustomerNameField;
    private javax.swing.JPanel editCustomerPanel;
    private javax.swing.JTextField editDescriptionField;
    private javax.swing.JFormattedTextField editEmployeeCpfField;
    private javax.swing.JTextField editEmployeeIdField;
    private javax.swing.JTextField editEmployeeNameField;
    private javax.swing.JPanel editEmployeePanel;
    private javax.swing.JTextField editLogradouroField;
    private javax.swing.JFormattedTextField editPriceField;
    private javax.swing.JTextField editProductIdField;
    private javax.swing.JPanel editProductPanel;
    private javax.swing.JTextField editProductQuantityField;
    private javax.swing.JFormattedTextField editTellphoneField;
    private javax.swing.JFormattedTextField editUfField;
    private javax.swing.JTable employeeChoiceTable;
    private javax.swing.JLabel employeeCpfLabel;
    private javax.swing.JLabel employeeCpfLabel1;
    private javax.swing.JLabel employeeLabelName;
    private javax.swing.JLabel employeeLabelName1;
    private javax.swing.JLabel employeeLabelName10;
    private javax.swing.JLabel employeeLabelName3;
    private javax.swing.JLabel employeeLabelName4;
    private javax.swing.JLabel employeeLabelName5;
    private javax.swing.JLabel employeeLabelName6;
    private javax.swing.JLabel employeeLabelName7;
    private javax.swing.JLabel employeeLabelName8;
    private javax.swing.JLabel employeeLabelName9;
    private javax.swing.JPanel employeesPanel;
    private javax.swing.JTable employeesTable;
    private javax.swing.JPanel inventoryPanel;
    private javax.swing.JFormattedTextField itemQuantityField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JButton openAddCustomerPaneBtn;
    private javax.swing.JButton openAddEmployeePaneBtn;
    private javax.swing.JButton openAddProductPaneBtn;
    private javax.swing.JButton openAddSalePaneBtn;
    private javax.swing.JButton openChooseCustomerPanel;
    private javax.swing.JButton openChooseSellerPanel;
    private javax.swing.JButton openEditCustomerBtn;
    private javax.swing.JButton openEditEmployeePanelBtn;
    private javax.swing.JButton openEditProductPaneBtn;
    private javax.swing.JFormattedTextField paymentAmountField;
    private javax.swing.JComboBox<String> paymentMethodCb;
    private javax.swing.JTable paymentsTable;
    private javax.swing.JTable productChoiceTable;
    private javax.swing.JPanel productChoisePanel;
    private javax.swing.JFormattedTextField productDescriptionField;
    private javax.swing.JFormattedTextField productIdField;
    private javax.swing.JTable productsTable;
    private javax.swing.JFormattedTextField remainingAmountField;
    private javax.swing.JTable saleItemsTable;
    private javax.swing.JPanel salesPanel;
    private javax.swing.JTable salesTable;
    private javax.swing.JPanel sallerChoicePanel;
    private javax.swing.JFormattedTextField sallerIdField;
    private javax.swing.JFormattedTextField sallerNameCpfField;
    private javax.swing.JButton submitAddCustomerBtn;
    private javax.swing.JButton submitAddEmployeeBtn;
    private javax.swing.JButton submitAddProductBtn;
    private javax.swing.JButton submitAddSaleBtn;
    private javax.swing.JButton submitCustomerChoiceBtn;
    private javax.swing.JButton submitEditCustomerBtn;
    private javax.swing.JButton submitEditEmployeeBtn;
    private javax.swing.JButton submitEditProductBtn;
    private javax.swing.JButton submitProductChoiseBtn;
    private javax.swing.JButton submitSellerChoiceBtn;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JScrollPane tabbedPanelScrollPane;
    private javax.swing.JFormattedTextField totalValueField;
    private javax.swing.JFormattedTextField unitPriceField;
    // End of variables declaration//GEN-END:variables
}
