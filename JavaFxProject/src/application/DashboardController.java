package application;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class DashboardController  implements Initializable{
	
	@FXML
    private TextField Etudiant_Adresse;

    @FXML
    private DatePicker Etudiant_DateDebut;
    @FXML
    private DatePicker Etudiant_DateDebut1;

    @FXML
    private DatePicker Etudiant_DateFin;

    @FXML
    private TextField Etudiant_ID;

    @FXML
    private ComboBox<?> Etudiant_Matiere;

    @FXML
    private ComboBox<?> Etudiant_Statue;

    @FXML
    private TextField Etudiant_Tele;
    
    
    @FXML
    private TextField searchTextField1;

    @FXML
    private ComboBox<?> Etudiant_genre;

    @FXML
    private ComboBox<?> Etudiant_niveau;

    @FXML
    private TextField Etudiant_nom;

    @FXML
    private ComboBox<?> Etudiant_typesub;

    @FXML
    private Button close;
    @FXML
    private Button logout_btn;



    @FXML
    private Button Update_btn;

    @FXML
    private Button clear_btn;
    @FXML
    private Button   suppri_btn;
  

    @FXML
    private Button Add_Etudiant1;
    @FXML
    private Button Annule_btn1;
    @FXML
    private DatePicker Etudiant_DateFin1;
    @FXML
    private TextField Etudiant_ID1;
    @FXML
    private ComboBox<String> Etudiant_Matiere1;
    @FXML
    private ComboBox<String> Etudiant_Statue1;
    @FXML
    private TextField Etudiant_Tele1;
    @FXML
    private ComboBox<String> Etudiant_genre1;

    @FXML
    private ComboBox<String> Etudiant_niveau1;
    @FXML
    private TextField Etudiant_nom1;
    @FXML
    private ComboBox<String> Etudiant_typesub1;

   

    @FXML
    private TableColumn<EnseignantData, String> Enseignant_id;

    @FXML
    private TableColumn<EnseignantData, String> Enseignant_nom;

    @FXML
    private TableColumn<EnseignantData, Integer> Eneignant_telaphone;

    @FXML
    private AnchorPane ensiegnant_form;

    @FXML
    private TableColumn<EnseignantData, String> Enseignant_niveau;

    @FXML
    private TableColumn<EnseignantData, String> Enseignant_matiere;
    @FXML
    private TableColumn<EnseignantData, String> Enseignant_genre;





    @FXML
    private TableView<EnseignantData> enseignat_tableView;


    @FXML
    private AnchorPane cour_form;

    @FXML
    private Button cours_btn;

    @FXML
    private Label dashboardNM;
    @FXML
    private Label username;

    @FXML
    private Label dashboardTC;

    @FXML
    private Label dashboardTI;

    @FXML
    private Button dashboard_btn;

    @FXML
    private AnchorPane dashboard_form;
    @FXML
    private AnchorPane ModifierEtudiant_Form;

    @FXML
    private AreaChart<?, ?> dashboard_incomeChart;

    @FXML
    private AreaChart<?, ?> dashboard_incomeChart1;

    @FXML
    private TextField searchTextField;
    @FXML
    private Button logout;
    @FXML
    private AnchorPane AddEnseignant_form;
    @FXML
    private AnchorPane ModifierEnseignant_Form;
    @FXML
    private Button Annule_btn_enseignat;
    @FXML
    private Button Ajouter_btn_enseignat;
   
    @FXML
    private Button Annule_btn_enseignat1;
    @FXML
    private Button Ajouter_btn_enseignat1;
    @FXML
    private TextField Text_Enseignant_ID;

    @FXML
    private TextField Text_Enseignant_nom;
    @FXML
    private TextField text_enseignant_tele;
    @FXML
    private TextField Text_Enseignant_ID1;

    @FXML
    private TextField Text_Enseignant_nom1;
    @FXML
    private TextField text_enseignant_tele1;
    @FXML
    private Button Update_btn1;
    @FXML
    private Button ajouter_btn1;
    @FXML
    private ComboBox<?> choix_Enseignant_gender;

    @FXML
    private ComboBox<?> choix_Enseignant_niveau;

    @FXML
    private ComboBox<?> choix_Enseignant_matiere;
    @FXML
    private ComboBox<String> choix_Enseignant_gender1;

    @FXML
    private ComboBox<String> choix_Enseignant_niveau1;

    @FXML
    private ComboBox<String> choix_Enseignant_matiere1;
    @FXML
    private Button clear_btn1;
    @FXML
    private Button Updatecour;

    

    @FXML
    private Button addCour;
    @FXML
    private Button clear_table_cour;
    @FXML
    private Button coaches_btn;
   
    @FXML
    private TextField courID;
    @FXML
    private TextField prix_nom;

    @FXML
    private TableColumn<CourData,String> cour_col_coruID;

    @FXML
    private TableColumn<CourData,String> cour_col_courname;

    @FXML
    private TableColumn<CourData,String> cour_col_niveau;

    @FXML
    private TableColumn<CourData,Float> cour_col_prix;
    @FXML
    private ComboBox<?> cour_niveau;
    @FXML
    private TextField cour_nom;

    @FXML
    private TableView<CourData> cour_tableView;
    @FXML
    private Button delete_cour;

    @FXML
    private AnchorPane main_form;

    @FXML
    private Button members_btn;

    @FXML
    private TableColumn<EtudiantData,String> members_col_Genre;



    @FXML
    private TableColumn<EtudiantData,String> members_col_endDate;

    @FXML
    private TableColumn<EtudiantData,String> members_col_etudiantID;

    @FXML
    private TableColumn<EtudiantData,String> members_col_matiere;

    @FXML
    private TableColumn<EtudiantData,String> members_col_name;

    @FXML
    private TableColumn<EtudiantData,String> members_col_niveau;

    @FXML
    private TableColumn<EtudiantData,Integer> members_col_phoneNum;

    @FXML
    private TableColumn<EtudiantData,String> members_col_startDate;

    @FXML
    private TableColumn<EtudiantData,String> members_col_status;

    @FXML
    private TableColumn<EtudiantData,String> members_col_tysub;
    @FXML
    private TableView<EtudiantData> members_tableView;


    @FXML
    private AnchorPane members_form;
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    private Statement statement;

    public void dashboardNM() {

        String sql = "SELECT COUNT(id) FROM etudiant";

        connect = MysqlConnection.connectDb();

        int nm = 0;

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                nm = result.getInt("COUNT(id)");
            }

            dashboardNM.setText(String.valueOf(nm));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void dashboardTC() {

        String sql = "SELECT COUNT(id) FROM enseignant";

        connect = MysqlConnection.connectDb();

        int tc = 0;

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                tc = result.getInt("COUNT(id)");
            }
            dashboardTC.setText(String.valueOf(tc));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void dashboardTI() {

        String sql = "SELECT SUM(price) FROM etudiant WHERE statue = 'Paid'";

        connect = MysqlConnection.connectDb();

        double ti = 0;

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                ti = result.getDouble("SUM(price)");
            }

            dashboardTI.setText(String.valueOf(ti) + " DH" );

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void dashboardChart() {

        dashboard_incomeChart.getData().clear();

        String sql = "SELECT DateDebut, count(*) FROM etudiant GROUP BY DateDebut ORDER BY TIMESTAMP(DateDebut) ASC LIMIT 10";

        connect = MysqlConnection.connectDb();

        XYChart.Series chart = new XYChart.Series();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                chart.getData().add(new XYChart.Data(result.getString(1), result.getDouble(2)));
            }

            dashboard_incomeChart.getData().add(chart);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void dashboardChart1() {

        dashboard_incomeChart1.getData().clear();

        String sql = "SELECT DateDebut, SUM(price) AS TotalPaid "
                     + "FROM etudiant WHERE Statue = 'Paid' "
                     + "GROUP BY DateDebut ORDER BY TIMESTAMP(DateDebut) ASC";

        connect = MysqlConnection.connectDb();

        XYChart.Series chart = new XYChart.Series();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            double runningTotal = 0;

            while (result.next()) {
                runningTotal += result.getDouble("TotalPaid");
                chart.getData().add(new XYChart.Data(result.getString("DateDebut"), runningTotal));
            }

            dashboard_incomeChart1.getData().add(chart);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   private String gender[] = {"Male", "Female"};
    public void membersGender() {
        List<String> genderList = new ArrayList<>();

        
		for (String data : gender) {
            genderList.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(genderList);
        Etudiant_genre.setItems(listData);

    }
    public void membersGender1() {
        List<String> genderList = new ArrayList<>();

        
		for (String data : gender) {
            genderList.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(genderList);
        Etudiant_genre1.setItems(listData);

    }
    public void EnseinantGender() {
        List<String> genderList = new ArrayList<>();

        
		for (String data : gender) {
            genderList.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(genderList);
        choix_Enseignant_gender.setItems(listData);

    }
   private String memberStatus[] = {"Paid", "Unpaid"};

    public void membersStatus() {

        List<String> ms = new ArrayList<>();

        for (String data : memberStatus) {
            ms.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(ms);
        Etudiant_Statue.setItems(listData);

    }
    public void membersStatus1() {

        List<String> ms = new ArrayList<>();

        for (String data : memberStatus) {
            ms.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(ms);
        Etudiant_Statue1.setItems(listData);

    }
    private String memberNiveau[] = {"1Bac", "2Bac"};

    public void membersniveau() {

        List<String> mn = new ArrayList<>();

        for (String data :  memberNiveau) {
        	mn.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(mn);
        Etudiant_niveau.setItems(listData);

    }
    public void membersniveau1() {

        List<String> mn = new ArrayList<>();

        for (String data :  memberNiveau) {
        	mn.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(mn);
        Etudiant_niveau1.setItems(listData);

    }
    public void Enseignantniveau() {

        List<String> mn = new ArrayList<>();

        for (String data :  memberNiveau) {
        	mn.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(mn);
        choix_Enseignant_niveau.setItems(listData);

    }
    public void Courniveau() {

        List<String> mn = new ArrayList<>();

        for (String data :  memberNiveau) {
        	mn.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(mn);
        cour_niveau.setItems(listData);

    }

    private String TypeSubs[] = {"1mois", "3mois","6mois"};

    public void memberTypesubs() {

        List<String> mt = new ArrayList<>();

        for (String data :  TypeSubs) {
        	mt.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(mt);
        Etudiant_typesub.setItems(listData);

    } public void memberTypesubs1() {

        List<String> mt = new ArrayList<>();

        for (String data :  TypeSubs) {
        	mt.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(mt);
        Etudiant_typesub1.setItems(listData);

    }
    private String Matiere[] = {"Math", "Pc","Anglais","Francais"};
    public void memberMatiere() {
        List<String> mm = new ArrayList<>();

        // Fetch Matiere values from the database
        String sql = "SELECT DISTINCT Description FROM cours"; // replace 'your_table_name' with the actual table name
        connect = MysqlConnection.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                mm.add(result.getString("Description"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Populate the combo box with the fetched values
        ObservableList listData = FXCollections.observableArrayList(mm);
        Etudiant_Matiere.setItems(listData);
    }


   /* public void memberMatiere() {

        List<String> mm = new ArrayList<>();

        for (String data :  Matiere) {
        	 mm.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList( mm);
        Etudiant_Matiere.setItems(listData);

    }*/ public void memberMatiere1() {

    	 List<String> mm = new ArrayList<>();

         // Fetch Matiere values from the database
         String sql = "SELECT DISTINCT Description FROM cours"; // replace 'your_table_name' with the actual table name
         connect = MysqlConnection.connectDb();

         try {
             prepare = connect.prepareStatement(sql);
             result = prepare.executeQuery();

             while (result.next()) {
                 mm.add(result.getString("Description"));
             }

         } catch (Exception e) {
             e.printStackTrace();
         }

         // Populate the combo box with the fetched values
         ObservableList listData = FXCollections.observableArrayList(mm);
         Etudiant_Matiere1.setItems(listData);

    } public void EnseignantMatiere() {
        List<String> mm = new ArrayList<>();

        // Fetch Matiere values from the database
        String sql = "SELECT DISTINCT Description FROM cours"; // replace 'your_table_name' with the actual table name
        connect = MysqlConnection.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                mm.add(result.getString("Description"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Populate the combo box with the fetched values
        ObservableList listData = FXCollections.observableArrayList(mm);
        choix_Enseignant_matiere.setItems(listData);
    }
 /*   public void EnseignantMatiere() {

        List<String> mr = new ArrayList<>();

        for (String data :  Matiere) {
        	 mr.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList( mr);
        choix_Enseignant_matiere.setItems(listData);

    }*/
    public void enseignantGender1() {
        List<String> genderList = new ArrayList<>();

        
		for (String data : gender) {
            genderList.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(genderList);
        choix_Enseignant_gender1.setItems(listData);

    }
    public void enseignantniveau1() {

        List<String> mn = new ArrayList<>();

        for (String data :  memberNiveau) {
        	mn.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(mn);
        choix_Enseignant_niveau1.setItems(listData);

    }
    public void enseignantMatiere1() {

        List<String> mm = new ArrayList<>();

        for (String data :  Matiere) {
        	 mm.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(mm);
        choix_Enseignant_matiere1.setItems(listData);

    } 
   
    public ObservableList<EtudiantData> membersDataList() {

        ObservableList<EtudiantData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM etudiant";

        connect = MysqlConnection.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            EtudiantData md;

            while (result.next()) {
                md = new EtudiantData(result.getInt("id"),
                        result.getString("etudiantId"),
                        result.getString("NomPrenom"),
                        result.getInt("Telephone"),
                        result.getString("niveau"),
                        result.getString("matiere"),
                        result.getDate("DateDebut"),
                        result.getDate("DateFin"),
                        result.getString("Statue"),
                        result.getString("TypeSubs"),
                        result.getString("Genre"),
                        result.getDouble("price")
                        );
                

                listData.add(md);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

 



    private ObservableList<EtudiantData> membersListData;

    
    public void membersShowData() {
        membersListData = membersDataList();
        filteredEtudiantList = new FilteredList<>(membersListData, p -> true);
        members_col_etudiantID.setCellValueFactory(new PropertyValueFactory<>("EtudiantId"));
        members_col_name.setCellValueFactory(new PropertyValueFactory<>("NomPrenom"));
        members_col_phoneNum.setCellValueFactory(new PropertyValueFactory<>("Telephone"));
        members_col_niveau.setCellValueFactory(new PropertyValueFactory<>("Niveau"));
        members_col_matiere.setCellValueFactory(new PropertyValueFactory<>("Matiere"));
        members_col_startDate.setCellValueFactory(new PropertyValueFactory<>("DateDebut"));
        members_col_endDate.setCellValueFactory(new PropertyValueFactory<>("DateFin"));
        members_col_status.setCellValueFactory(new PropertyValueFactory<>("status"));
        members_col_tysub.setCellValueFactory(new PropertyValueFactory<>("TypeSubs"));
        members_col_Genre.setCellValueFactory(new PropertyValueFactory<>("Genre"));
      

     

       
       

        members_tableView.setItems(filteredEtudiantList);
    }
    
   public void membersSelect() {

    	EtudiantData md = members_tableView.getSelectionModel().getSelectedItem();
        int num = members_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }
       
        Etudiant_ID.setText(md.getEtudiantId());
        Etudiant_nom.setText(md. getNomPrenom());
        Etudiant_Tele.setText(String.valueOf(md.getTelephone()));
      
       
 
   
       
        Etudiant_DateDebut.setValue(LocalDate.parse(String.valueOf(md.getDateDebut())));
        Etudiant_DateFin.setValue(LocalDate.parse(String.valueOf(md.getDateFin())));


    }
   

    @FXML
    private Button minimize;

    @FXML
    private AnchorPane payment_Form;

    @FXML
    private TextField payment_amount;

    @FXML
    private Button payment_btn;

    @FXML
    private AnchorPane AddEtudiant_Form;

    @FXML
    private Button Add_Etudiant;

    @FXML
    private Button Annule_btn;
    @FXML
    private TableColumn<EtudiantData, String> payment_col_customerID;

    @FXML
    private TableColumn<EtudiantData, String> payment_col_endDate;
    @FXML
    private TableColumn<EtudiantData, String> payment_col_Typesubs;

    @FXML
    private TableColumn<EtudiantData, String> payment_col_name;

    @FXML
    private TableColumn<EtudiantData, String> payment_col_startDate;

    @FXML
    private TableColumn<EtudiantData, String> payment_col_status;

    @FXML
    private ComboBox<?> payment_customerID;

    @FXML
    private ComboBox<?> payment_name;


    @FXML
    private Button ajouter_btn;



  

    @FXML
    private TableView<EtudiantData> payment_tableView;

    @FXML
    private Label payment_total;
    private int totalDay;
    private double price;
    public void emptyFields() {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error Message");
        alert.setHeaderText(null);
        alert.setContentText("Please fill all blank fields");
        alert.showAndWait();
    }
    public void membersAddBtn() {

        String sql = "INSERT INTO etudiant (etudiantID,NomPrenom, Telephone, niveau, 	matiere, DateDebut, DateFin, Statue, TypeSubs, Genre,price) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";

        connect = MysqlConnection.connectDb();

        try {
            Alert alert;

            if (Etudiant_ID.getText().isEmpty() || Etudiant_nom.getText().isEmpty()
                    || Etudiant_Tele.getText().isEmpty() 
                    || Etudiant_genre.getSelectionModel().getSelectedItem() == null
                    || Etudiant_Statue.getSelectionModel().getSelectedItem() == null
                    		|| Etudiant_niveau.getSelectionModel().getSelectedItem() == null
                    				|| Etudiant_typesub.getSelectionModel().getSelectedItem() == null
                    						|| Etudiant_Matiere.getSelectionModel().getSelectedItem() == null
                    || Etudiant_DateDebut.getValue() == null
                    || Etudiant_DateFin.getValue() == null) {
                emptyFields();
            } else {

                String checkData = "SELECT etudiantID FROM etudiant WHERE etudiantID = '"
                        + Etudiant_ID.getText() + "'";

                statement = connect.createStatement();
                result = statement.executeQuery(checkData);

                if (result.next()) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Member ID: " + Etudiant_ID.getText() + " was already taken!");
                    alert.showAndWait();
                } else {
                	 String fetchPriceSql = "SELECT prix FROM cours WHERE Description = ?";
                     prepare = connect.prepareStatement(fetchPriceSql);
                     prepare.setString(1, (String) Etudiant_Matiere.getSelectionModel().getSelectedItem());
                     ResultSet priceResult = prepare.executeQuery();

                     double matierePrice = 0.0;
                     if (priceResult.next()) {
                         matierePrice = priceResult.getDouble("prix");
                     }

                     // Calculate the total price based on TypeSubs and Matiere price
                     int typeSubsMultiplier =0;
                     String selectedTypeSubs = (String) Etudiant_typesub.getSelectionModel().getSelectedItem();
                     if ("1mois".equals(selectedTypeSubs)) {
                         typeSubsMultiplier = 1;
                     } else if ("3mois".equals(selectedTypeSubs)) {
                         typeSubsMultiplier = 3;
                     } else if ("6mois".equals(selectedTypeSubs)) {
                         typeSubsMultiplier = 6;
                     }

                     price = typeSubsMultiplier * matierePrice;
                    prepare = connect.prepareStatement(sql);
                    prepare.setString(1, Etudiant_ID.getText());
                    prepare.setString(2, Etudiant_nom.getText());
                    prepare.setString(3, Etudiant_Tele.getText());
              
                    prepare.setString(4,(String)   Etudiant_niveau.getSelectionModel().getSelectedItem());
                    prepare.setString(5, (String)  Etudiant_Matiere.getSelectionModel().getSelectedItem());
                    prepare.setString(6, String.valueOf(Etudiant_DateDebut.getValue()));
                    prepare.setString(7, String.valueOf(Etudiant_DateFin.getValue()));
                    prepare.setString(8, (String) Etudiant_Statue.getSelectionModel().getSelectedItem());
                    prepare.setString(9, (String)  Etudiant_typesub.getSelectionModel().getSelectedItem());
                    prepare.setString(10,   (String) Etudiant_genre.getSelectionModel().getSelectedItem());
                    prepare.setDouble(11, price);

                   

                    prepare.executeUpdate();
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfuly Added!");
                    alert.showAndWait();

                    membersShowData();
                  membersClear();
                  closeAnchorPane();                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void membersUpdate() {

       /* totalDay = (int) ChronoUnit.DAYS.between(members_startDate.getValue(), members_endDate.getValue());
        price = (totalDay * 50);
*/
        String sql = "UPDATE etudiant SET NomPrenom = '"
                + Etudiant_nom1.getText() + "', Telephone = '"
                + Etudiant_Tele1.getText() + "', niveau = '"
                + Etudiant_niveau1.getSelectionModel().getSelectedItem() + "', matiere = '"
                + Etudiant_Matiere1.getSelectionModel().getSelectedItem() + "', DateDebut = '"
                + Etudiant_DateDebut1.getValue() + "', DateFin = '"
                + Etudiant_DateFin1.getValue() +  "', Statue = '"
                + Etudiant_Statue1.getSelectionModel().getSelectedItem() + "', TypeSubs = '"
                + Etudiant_typesub1.getSelectionModel().getSelectedItem() + "', Genre = '"
                + Etudiant_genre1.getSelectionModel().getSelectedItem() + "' WHERE etudiantID = '"
                + Etudiant_ID1.getText() + "'";

        connect = MysqlConnection.connectDb();

        try {
            Alert alert;

            if (Etudiant_ID1.getText().isEmpty() || Etudiant_nom1.getText().isEmpty()
                    || Etudiant_Tele1.getText().isEmpty()
                    || Etudiant_genre1.getSelectionModel().getSelectedItem() == null
                    || Etudiant_niveau1.getSelectionModel().getSelectedItem() == null
                    		  || Etudiant_Matiere1.getSelectionModel().getSelectedItem() == null
                    				  || Etudiant_Statue1.getSelectionModel().getSelectedItem() == null
                    						  || Etudiant_typesub1.getSelectionModel().getSelectedItem() == null
                    || Etudiant_DateDebut1.getValue() == null
                    || Etudiant_DateFin1.getValue() == null) {
                emptyFields();
            } else {
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to UPDATE Etudiant_ID: " + Etudiant_ID1.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    prepare = connect.prepareStatement(sql);
                    prepare.executeUpdate();

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfuly Updated!");
                    alert.showAndWait();

                    membersShowData();
                    membersClear();
                    closemodifier1();

                } else {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Cancelled Update!!");
                    alert.showAndWait();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       
    }


    public void membersClear() {
    	 Etudiant_ID.setText("");
    	 Etudiant_nom.setText("");
    	 Etudiant_Tele.setText("");
    	 Etudiant_niveau.getSelectionModel().clearSelection();
    	 Etudiant_Matiere.getSelectionModel().clearSelection();
    	 Etudiant_Statue.getSelectionModel().clearSelection();
    	 Etudiant_typesub.getSelectionModel().clearSelection();
        Etudiant_DateDebut.setValue(null);
        Etudiant_DateFin.setValue(null);
        Etudiant_genre.getSelectionModel().clearSelection();
    }
    public void EnseignantClear() {
    	Text_Enseignant_nom.setText("");
    	Text_Enseignant_ID.setText("");
    	text_enseignant_tele.setText("");
    	choix_Enseignant_gender.getSelectionModel().clearSelection();
    	choix_Enseignant_matiere.getSelectionModel().clearSelection();
    	choix_Enseignant_niveau.getSelectionModel().clearSelection();

   }
    public void clearTable() {
        Alert confirmationAlert = new Alert(AlertType.CONFIRMATION);
        confirmationAlert.setTitle("Confirmation");
        confirmationAlert.setHeaderText(null);
        confirmationAlert.setContentText("Are you sure you want to clear all data?");

        Optional<ButtonType> result = confirmationAlert.showAndWait();
        
        if (result.isPresent() && result.get() == ButtonType.OK) {
            // User clicked OK, proceed with clearing the table and database
            // Clear data from the TableView
            membersListData.clear();
            members_tableView.setItems(membersListData);

            // Clear data from the database
            String sql = "DELETE FROM etudiant";
            connect = MysqlConnection.connectDb();

            try {
                prepare = connect.prepareStatement(sql);
                prepare.executeUpdate();

                // Display an information alert
                Alert infoAlert = new Alert(AlertType.INFORMATION);
                infoAlert.setTitle("Information");
                infoAlert.setHeaderText(null);
                infoAlert.setContentText("All data cleared successfully!");
                infoAlert.showAndWait();

            } catch (SQLException e) {
                e.printStackTrace();
                // Handle the exception (display an error alert, log the error, etc.)
            }
        } else {
            // User clicked Cancel or closed the dialog, do nothing
        }
    }


    public void membersDelete() {
        EtudiantData selectedEtudiant = members_tableView.getSelectionModel().getSelectedItem();

        if (selectedEtudiant == null) {
            // No row selected, show an error message or handle it accordingly
            // You can show an alert or any other UI feedback
            return;
        }

        String sql = "DELETE FROM etudiant WHERE etudiantID = ?";
        
        connect = MysqlConnection.connectDb();

        try {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to DELETE etudiantID: " + selectedEtudiant.getEtudiantId() + "?");
            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {
                prepare = connect.prepareStatement(sql);
                prepare.setString(1, selectedEtudiant.getEtudiantId());
                prepare.executeUpdate();

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Deleted!");
                alert.showAndWait();

                membersShowData();
                membersClear();
            } else {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Cancelled Delete!!");
                alert.showAndWait();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ObservableList<EnseignantData> EnseignantDataList() {

        ObservableList<EnseignantData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM enseignant";

        connect = MysqlConnection.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            EnseignantData me;

            while (result.next()) {
                me = new EnseignantData(result.getInt("id"),
                        result.getString("EnseignantId"),
                        result.getString("NomPrenom"),
                        result.getInt("Telephone"),
                        result.getString("Niveau"),
                        result.getString("matiere"),
                        result.getString("genre")
                      
                        );
                

                listData.add(me);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    
    public void enseignantShowData() {
        EnseignantListData = EnseignantDataList();
        filteredEnseignantList = new FilteredList<>(EnseignantListData, p -> true);

        Enseignant_id.setCellValueFactory(new PropertyValueFactory<>("EnseignantId"));
        Enseignant_nom.setCellValueFactory(new PropertyValueFactory<>("NomPrenom"));
        Eneignant_telaphone.setCellValueFactory(new PropertyValueFactory<>("Telephone"));
        Enseignant_niveau.setCellValueFactory(new PropertyValueFactory<>("Niveau"));
        Enseignant_matiere.setCellValueFactory(new PropertyValueFactory<>("Matiere"));
        Enseignant_genre.setCellValueFactory(new PropertyValueFactory<>("genre"));

        enseignat_tableView.setItems(filteredEnseignantList);
    }

    
    public void enseignantSelect() {

    	EnseignantData md = enseignat_tableView.getSelectionModel().getSelectedItem();
        int num = enseignat_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }
       
        Text_Enseignant_ID.setText(md.getEnseignantId());
        Text_Enseignant_nom.setText(md. getNomPrenom());
        text_enseignant_tele.setText(String.valueOf(md.getTelephone()));
      
       
 
   
       
 


    }
    public void displayUsername() {

        String user = data.username;
        user = user.substring(0, 1).toUpperCase() + user.substring(1);

        username.setText(user);

    }
    private ObservableList<EnseignantData> EnseignantListData;
    private FilteredList<EnseignantData> filteredEnseignantList;
    private FilteredList<EtudiantData> filteredEtudiantList;

    public void enseignantUpdate() {

        /* totalDay = (int) ChronoUnit.DAYS.between(members_startDate.getValue(), members_endDate.getValue());
         price = (totalDay * 50);
 */
         String sql = "UPDATE enseignant SET NomPrenom = '"
                 + Text_Enseignant_nom1.getText() + "', Telephone = '"
                 + text_enseignant_tele1.getText() + "', genre = '"
                 + choix_Enseignant_gender1.getSelectionModel().getSelectedItem() + "', 	niveau = '"
                 + choix_Enseignant_niveau1.getSelectionModel().getSelectedItem() + "', 	matiere = '"
                 + choix_Enseignant_matiere1.getSelectionModel().getSelectedItem() + "' WHERE enseignantID = '"
                 + Text_Enseignant_ID1.getText() + "'";

         connect = MysqlConnection.connectDb();

         try {
             Alert alert;

             if (Text_Enseignant_ID1.getText().isEmpty() || Text_Enseignant_nom1.getText().isEmpty()
                     || text_enseignant_tele1.getText().isEmpty()
                     || choix_Enseignant_gender1.getSelectionModel().getSelectedItem() == null
                     || choix_Enseignant_niveau1.getSelectionModel().getSelectedItem() == null
                     		  || choix_Enseignant_matiere1.getSelectionModel().getSelectedItem() == null
                     				 ) {
                 emptyFields();
             } else {
                 alert = new Alert(AlertType.CONFIRMATION);
                 alert.setTitle("Confirmation Message");
                 alert.setHeaderText(null);
                 alert.setContentText("Are you sure you want to UPDATE Enseignant_ID: " + Etudiant_ID1.getText() + "?");
                 Optional<ButtonType> option = alert.showAndWait();

                 if (option.get().equals(ButtonType.OK)) {
                     prepare = connect.prepareStatement(sql);
                     prepare.executeUpdate();

                     alert = new Alert(AlertType.INFORMATION);
                     alert.setTitle("Information Message");
                     alert.setHeaderText(null);
                     alert.setContentText("Successfuly Updated!");
                     alert.showAndWait();

                     membersShowData();
                     membersClear();

                 } else {
                     alert = new Alert(AlertType.ERROR);
                     alert.setTitle("Information Message");
                     alert.setHeaderText(null);
                     alert.setContentText("Cancelled Update!!");
                     alert.showAndWait();
                 }

             }
         } catch (Exception e) {
             e.printStackTrace();
         }
         enseignantShowData();
         closemodifier1();
         

     }
    public void courselect() {

    	CourData md = cour_tableView.getSelectionModel().getSelectedItem();
        int num = cour_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }
       
        courID.setText(md.getCourId());
        cour_nom.setText(md. getDescription());
        prix_nom.setText(String.valueOf(md.getPrix()));
      
       
 
   
       



    }

    public void enseignantAddBtn() {

        String sql = "INSERT INTO enseignant (	enseignantID,NomPrenom, Telephone, niveau, 	matiere,genre) "
                + "VALUES(?,?,?,?,?,?)";

        connect = MysqlConnection.connectDb();

        try {
            Alert alert;

            if (Text_Enseignant_ID.getText().isEmpty() || Text_Enseignant_nom.getText().isEmpty()
                    || text_enseignant_tele.getText().isEmpty() 
                   
                    || choix_Enseignant_niveau.getSelectionModel().getSelectedItem() == null
                    		|| choix_Enseignant_matiere.getSelectionModel().getSelectedItem() == null
                    		|| choix_Enseignant_gender.getSelectionModel().getSelectedItem() == null
                    				) {
                emptyFields();
            } else {

                String checkData = "SELECT enseignantId FROM enseignant WHERE enseignantId = '"
                        + Text_Enseignant_ID.getText() + "'";

                statement = connect.createStatement();
                result = statement.executeQuery(checkData);

                if (result.next()) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Member ID: " + Text_Enseignant_ID.getText() + " was already taken!");
                    alert.showAndWait();
                } else {
                    prepare = connect.prepareStatement(sql);
                    prepare.setString(1, Text_Enseignant_ID.getText());
                    prepare.setString(2, Text_Enseignant_nom.getText());
                    prepare.setString(3, text_enseignant_tele.getText());
              
                    prepare.setString(4,(String)   choix_Enseignant_niveau.getSelectionModel().getSelectedItem());
                    prepare.setString(5, (String)  choix_Enseignant_matiere.getSelectionModel().getSelectedItem());
                    prepare.setString(6, (String)  choix_Enseignant_gender.getSelectionModel().getSelectedItem());
                  
                    

                    prepare.executeUpdate();
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfuly Added!");
                    alert.showAndWait();

                    enseignantShowData();
                    EnseignantClear();
                    AddEnseignant_form .setVisible(false);
              //    membersClear();
                 // closeAnchorPane();                }

            }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void enseignantClear() {
    	Text_Enseignant_ID.setText("");
    	Text_Enseignant_nom.setText("");
    	text_enseignant_tele.setText("");
    	choix_Enseignant_niveau.getSelectionModel().clearSelection();
    	choix_Enseignant_matiere.getSelectionModel().clearSelection();
    	choix_Enseignant_gender.getSelectionModel().clearSelection();
   	 
   }
    public void clearEnseignantTable() {
        Alert confirmationAlert = new Alert(AlertType.CONFIRMATION);
        confirmationAlert.setTitle("Confirmation");
        confirmationAlert.setHeaderText(null);
        confirmationAlert.setContentText("Are you sure you want to clear all data?");

        Optional<ButtonType> result = confirmationAlert.showAndWait();
        
        if (result.isPresent() && result.get() == ButtonType.OK) {
            // User clicked OK, proceed with clearing the table and database
            // Clear data from the TableView
        	EnseignantListData.clear();
        	enseignat_tableView.setItems(EnseignantListData);

            // Clear data from the database
            String sql = "DELETE FROM enseignant";
            connect = MysqlConnection.connectDb();

            try {
                prepare = connect.prepareStatement(sql);
                prepare.executeUpdate();

                // Display an information alert
                Alert infoAlert = new Alert(AlertType.INFORMATION);
                infoAlert.setTitle("Information");
                infoAlert.setHeaderText(null);
                infoAlert.setContentText("All data cleared successfully!");
                infoAlert.showAndWait();

            } catch (SQLException e) {
                e.printStackTrace();
                // Handle the exception (display an error alert, log the error, etc.)
            }
        } else {
            // User clicked Cancel or closed the dialog, do nothing
        }
    }


    public void enseignantDelete() {
        EnseignantData selectedEnseignant = enseignat_tableView.getSelectionModel().getSelectedItem();

        if (selectedEnseignant == null) {
            // No row selected, show an error message or handle it accordingly
            // You can show an alert or any other UI feedback
            return;
        }

        String sql = "DELETE FROM enseignant WHERE enseignantID = ?";
        
        connect = MysqlConnection.connectDb();

        try {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to DELETE etudiantID: " + selectedEnseignant.getEnseignantId() + "?");
            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {
                prepare = connect.prepareStatement(sql);
                prepare.setString(1, selectedEnseignant.getEnseignantId());
                prepare.executeUpdate();

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Deleted!");
                alert.showAndWait();

                enseignantShowData();
                enseignantClear();
            } else {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Cancelled Delete!!");
                alert.showAndWait();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
 
   
    @FXML
    void close(ActionEvent event) {
        javafx.application.Platform.exit();

    }



   
    

    @FXML
    void membersSelect(MouseEvent event) {

    }
    @FXML
    void enseignantSelect(MouseEvent event) {

    }

    @FXML
    void minimize(ActionEvent event) {
    	Stage stage = (Stage) main_form.getScene().getWindow();
        stage.setIconified(true);
    }

   
    @FXML

    private void showAnchorPane() {
    	AddEtudiant_Form.setVisible(true);
    	
    }
    public ObservableList<CourData> courDataList() {

        ObservableList<CourData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM cours";

        connect = MysqlConnection.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            CourData cd;

            while (result.next()) {
                cd = new CourData(result.getInt("id"),
                        result.getString("CourId"),
                        result.getString("Description"),               
                        result.getString("Niveau"),
                        result.getFloat("Prix")
                       
                        );
                

                listData.add(cd);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }
  private ObservableList<CourData> courListData;

    
    public void courShowData() {
        courListData = courDataList();

        cour_col_coruID.setCellValueFactory(new PropertyValueFactory<>("CourId"));
        cour_col_courname.setCellValueFactory(new PropertyValueFactory<>("Description"));
       
        cour_col_niveau.setCellValueFactory(new PropertyValueFactory<>("Niveau"));
        cour_col_prix.setCellValueFactory(new PropertyValueFactory<>("Prix"));
       

     

       
       

        cour_tableView.setItems(courListData);
    }
    public void courAddBtn() {

        String sql = "INSERT INTO cours (courID,Description,niveau,prix) "
                + "VALUES(?,?,?,?)";

        connect = MysqlConnection.connectDb();

        try {
            Alert alert;

            if (courID.getText().isEmpty() || cour_nom.getText().isEmpty()
                    
                    || cour_niveau.getSelectionModel().getSelectedItem() == null
                    ||prix_nom.getText().isEmpty()  ) {
                emptyFields();
            } else {

                String checkData ="SELECT courID FROM cours WHERE courID = '"
                        + courID.getText() + "'";

                statement = connect.createStatement();
                result = statement.executeQuery(checkData);

                if (result.next()) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Member ID: " + courID.getText() + " was already taken!");
                    alert.showAndWait();
                } else {
                	 prepare = connect.prepareStatement(sql);
                     prepare.setString(1, courID.getText());
                     prepare.setString(2, cour_nom.getText());
                     
               
                     prepare.setString(3,(String)   cour_niveau.getSelectionModel().getSelectedItem());
                     prepare.setString(4,  prix_nom.getText());
                     

                     prepare.executeUpdate();
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfuly Added!");
                    alert.showAndWait();

                    courShowData();
               
                               }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
  
    public void clearCour() {
        Alert confirmationAlert = new Alert(AlertType.CONFIRMATION);
        confirmationAlert.setTitle("Confirmation");
        confirmationAlert.setHeaderText(null);
        confirmationAlert.setContentText("Are you sure you want to clear all data?");

        Optional<ButtonType> result = confirmationAlert.showAndWait();
        
        if (result.isPresent() && result.get() == ButtonType.OK) {
            // User clicked OK, proceed with clearing the table and database
            // Clear data from the TableView
            courListData.clear();
            cour_tableView.setItems(courListData);

            // Clear data from the database
            String sql = "DELETE FROM cours";
            connect = MysqlConnection.connectDb();

            try {
                prepare = connect.prepareStatement(sql);
                prepare.executeUpdate();

                // Display an information alert
                Alert infoAlert = new Alert(AlertType.INFORMATION);
                infoAlert.setTitle("Information");
                infoAlert.setHeaderText(null);
                infoAlert.setContentText("All data cleared successfully!");
                infoAlert.showAndWait();

            } catch (SQLException e) {
                e.printStackTrace();
                // Handle the exception (display an error alert, log the error, etc.)
            }
        } else {
            // User clicked Cancel or closed the dialog, do nothing
        }
        courShowData();  
    }
    public void CourUpdateBtn() {

        String sql = "UPDATE cours SET Description = '"
                + cour_nom.getText() + "', niveau = '"
               
                + cour_niveau.getSelectionModel().getSelectedItem() + "', prix = '"
                + prix_nom.getText()  + "' WHERE courID = '"

                + courID.getText() + "'";

        connect = MysqlConnection.connectDb();

        try {
            Alert alert;
            if (cour_nom.getText().isEmpty() 
                    || courID.getText().isEmpty()
                    || cour_niveau.getSelectionModel().getSelectedItem() == null
                    || prix_nom.getText().isEmpty()) {
                emptyFields();
            } else {
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to UPDATE Coach ID: " + courID.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    prepare = connect.prepareStatement(sql);

                    prepare.executeUpdate();
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();
                    // TO UPDATE TABLEVIEW
                    courShowData();
                  
                } else {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Cancelled Update!");
                    alert.showAndWait();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
   
    public void courDelete() {
        CourData selectedCour = cour_tableView.getSelectionModel().getSelectedItem();

        if (selectedCour == null) {
            // No row selected, show an error message or handle it accordingly
            // You can show an alert or any other UI feedback
            return;
        }

        String sql = "DELETE FROM cours WHERE courID = ?";
        
        connect = MysqlConnection.connectDb();

        try {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to DELETE courID: " + selectedCour.getCourId() + "?");
            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {
                prepare = connect.prepareStatement(sql);
                prepare.setString(1, selectedCour.getCourId());
                prepare.executeUpdate();

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Deleted!");
                alert.showAndWait();

                membersShowData();
                membersClear();
            } else {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Cancelled Delete!!");
                alert.showAndWait();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        courShowData();    }
    public void paymentMemberId() {

        String sql = "SELECT etudiantID FROM etudiant WHERE Statue = 'Unpaid'";

        connect = MysqlConnection.connectDb();

        try {
            ObservableList listData = FXCollections.observableArrayList();

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                listData.add(result.getString("etudiantID"));
            }
            payment_customerID.setItems(listData);

            paymentName();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void paymentName() {
        String selectedId = (String) payment_customerID.getSelectionModel().getSelectedItem();
        System.out.println("Selected ID: " + selectedId);

        String sql = "SELECT NomPrenom FROM etudiant WHERE etudiantID = '" + selectedId + "'";

        connect = MysqlConnection.connectDb();

        try {
            ObservableList listData = FXCollections.observableArrayList();
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                listData.add(result.getString("NomPrenom"));
            }

            System.out.println("List data size: " + listData.size());

            payment_name.setItems(listData);
            paymentDisplayTotal();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private double totalP;

    public void displayTotal() {

        String sql = "SELECT price FROM etudiant WHERE NomPrenom = '"
                + payment_name.getSelectionModel().getSelectedItem() + "' and etudiantID = '"
                + payment_customerID.getSelectionModel().getSelectedItem() + "'";

        connect = MysqlConnection.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                totalP = result.getDouble("price");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void paymentDisplayTotal() {
        displayTotal();
        payment_total.setText(String.valueOf(totalP)+" DH" );
    }

    


   

    public void paymentPayBtn() {

        String sql = "UPDATE etudiant SET Statue = 'Paid' WHERE etudiantID = '"
                + payment_customerID.getSelectionModel().getSelectedItem() + "'";

        connect = MysqlConnection.connectDb();

        try {
            Alert alert;
            if (totalP == 0 ) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Something Wrong :3");
                alert.showAndWait();
            } else {
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    prepare = connect.prepareStatement(sql);
                    prepare.executeUpdate();

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successful!");
                    alert.showAndWait();

                    paymentShowData();
                 
                } else {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Cancelled.");
                    alert.showAndWait();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public ObservableList<EtudiantData> paymentDataList() {

        ObservableList<EtudiantData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM etudiant";

        connect = MysqlConnection.connectDb();

        try {
        	EtudiantData md;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                md = new EtudiantData(result.getInt("id"),
                        result.getString("EtudiantId"),
                        result.getString("NomPrenom"),
                        result.getInt("Telephone"),
                        result.getString("Niveau"),
                        result.getString("Matiere"),

                        result.getDate("DateDebut"),
                        result.getDate("DateFin"),
                      
                        result.getString("statue"),
                        result.getString("TypeSubs"),
                        result.getString("Genre"),
                       
                        result.getDouble("price"));

                listData.add(md);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<EtudiantData> paymentListData;

    public void paymentShowData() {

        paymentListData = paymentDataList();

        payment_col_customerID.setCellValueFactory(new PropertyValueFactory<>("EtudiantId"));
        payment_col_name.setCellValueFactory(new PropertyValueFactory<>("NomPrenom"));
        payment_col_startDate.setCellValueFactory(new PropertyValueFactory<>("DateDebut"));
        payment_col_endDate.setCellValueFactory(new PropertyValueFactory<>("DateFin"));
        payment_col_Typesubs.setCellValueFactory(new PropertyValueFactory<>("TypeSubs"));
        payment_col_status.setCellValueFactory(new PropertyValueFactory<>("status"));

        payment_tableView.setItems(paymentListData);

    }
    @FXML

    private void showmodifier() {
        EtudiantData selectedStudent = members_tableView.getSelectionModel().getSelectedItem();

        if (selectedStudent != null) {
            // Populate text fields with the selected student's information
            Etudiant_ID1.setText(selectedStudent.getEtudiantId());
            Etudiant_nom1.setText(selectedStudent.getNomPrenom());
            Etudiant_Tele1.setText(String.valueOf(selectedStudent.getTelephone()));
            List<String> genderList = Arrays.asList("Male", "Female");
            ObservableList<String> listData = FXCollections.observableArrayList(genderList);
            Etudiant_genre1.setItems(listData);

            // Set the selected gender based on the student's data
            String selectedGender = selectedStudent.getGenre();
            Etudiant_genre1.setValue(selectedGender);
            List<String> descriptions = new ArrayList<>();

            String sql = "SELECT DISTINCT Description FROM cours"; // replace 'your_table_name' with the actual table name
            connect = MysqlConnection.connectDb();

            try {
                prepare = connect.prepareStatement(sql);
                result = prepare.executeQuery();

                while (result.next()) {
                    descriptions.add(result.getString("Description"));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            // Convert the ArrayList to an array if needed
            String[] descriptionsArray = descriptions.toArray(new String[0]);
            populateComboBox(TypeSubs, Etudiant_typesub1, selectedStudent.getTypeSubs());
            populateComboBox(descriptionsArray, Etudiant_Matiere1, selectedStudent.getMatiere());
            populateComboBox(memberNiveau, Etudiant_niveau1, selectedStudent.getNiveau());
            populateComboBox(memberStatus, Etudiant_Statue1, selectedStudent.getStatus());
            populateDatePicker(Etudiant_DateDebut1, selectedStudent.getDateDebut());
            populateDatePicker(Etudiant_DateFin1, selectedStudent.getDateFin());
            ModifierEtudiant_Form.setVisible(true);
            
            System.out.println("Selected Student ID: " + selectedStudent.getEtudiantId());
            System.out.println("Selected Student Name: " + selectedStudent.getNomPrenom());
            // Print other attributes for debugging

        } else {
            // No student selected
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Please select a student.");
            alert.showAndWait();
        }
    }
    private void populateComboBox(String[] data, ComboBox<String> comboBox, String selectedValue) {
        List<String> dataList = new ArrayList<>();

        for (String item : data) {
            dataList.add(item);
        }

        ObservableList<String> listData = FXCollections.observableArrayList(dataList);
        comboBox.setItems(listData);

        // Set the selected value if it exists in the data
        if (dataList.contains(selectedValue)) {
            comboBox.setValue(selectedValue);
        } else {
            // Handle the case where the selected value is not in the predefined list
            // You might want to provide a default value or handle it based on your requirements
        }
    }
    private void populateDatePicker(DatePicker datePicker, Date selectedDate) {
        // Convert java.sql.Date to java.util.Date
        java.util.Date utilDate = new java.util.Date(selectedDate.getTime());

        Instant instant = utilDate.toInstant();
        LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
        datePicker.setValue(localDate);
    }
   public void showmodifierEnseignant() {
        EnseignantData selectedEnseignant = enseignat_tableView.getSelectionModel().getSelectedItem();

        if (selectedEnseignant != null) {
            // Populate text fields with the selected student's information
        	Text_Enseignant_ID1.setText(selectedEnseignant.getEnseignantId());
            Text_Enseignant_nom1.setText(selectedEnseignant.getNomPrenom());
            text_enseignant_tele1.setText(String.valueOf(selectedEnseignant.getTelephone()));
            List<String> genderList = Arrays.asList("Male", "Female");
            ObservableList<String> listData = FXCollections.observableArrayList(genderList);
            choix_Enseignant_gender1.setItems(listData);

            // Set the selected gender based on the student's data
            String selectedGender = selectedEnseignant.getGenre();
            choix_Enseignant_gender1.setValue(selectedGender);
            List<String> descriptions = new ArrayList<>();

            String sql = "SELECT DISTINCT Description FROM cours"; // replace 'your_table_name' with the actual table name
            connect = MysqlConnection.connectDb();

            try {
                prepare = connect.prepareStatement(sql);
                result = prepare.executeQuery();

                while (result.next()) {
                    descriptions.add(result.getString("Description"));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            // Convert the ArrayList to an array if needed
            String[] descriptionsArray = descriptions.toArray(new String[0]);
           
            populateComboBox1(descriptionsArray, choix_Enseignant_matiere1, selectedEnseignant.getMatiere());
            populateComboBox1(memberNiveau, choix_Enseignant_niveau1, selectedEnseignant.getNiveau());
           
            ModifierEnseignant_Form.setVisible(true);
            
            System.out.println("Selected enseignant ID: " + selectedEnseignant.getEnseignantId());
            System.out.println("Selected enseignant Name: " + selectedEnseignant.getNomPrenom());
            // Print other attributes for debugging

        } else {
            // No student selected
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Please select a student.");
            alert.showAndWait();
        }
    }
    private void populateComboBox1(String[] data, ComboBox<String> comboBox, String selectedValue) {
        List<String> dataList = new ArrayList<>();

        for (String item : data) {
            dataList.add(item);
        }

        ObservableList<String> listData = FXCollections.observableArrayList(dataList);
        comboBox.setItems(listData);

        // Set the selected value if it exists in the data
        if (dataList.contains(selectedValue)) {
            comboBox.setValue(selectedValue);
        } else {
            // Handle the case where the selected value is not in the predefined list
            // You might want to provide a default value or handle it based on your requirements
        }
    } 
    public void courClearBtn() {
        courID.setText("");
        cour_nom.setText("");
    
        cour_niveau.getSelectionModel().clearSelection();
        prix_nom.setText("");
     
    }
    private double x = 0;
    private double y = 0;
    public void logout() {

        try {

            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to logout?");
            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {

                // TO HIDE YOUR DASHBOARD FORM
                logout.getScene().getWindow().hide();

                // LINK YOUR LOGIN FORM
                Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));

                Stage stage = new Stage();
                Scene scene = new Scene(root);

                
				root.setOnMousePressed((MouseEvent event) -> {
                    x = event.getSceneX();
                    y = event.getSceneY();
                });

                root.setOnMouseDragged((MouseEvent event) -> {
                    stage.setX(event.getScreenX() - x);
                    stage.setY(event.getScreenY() - y);

                    stage.setOpacity(.8);
                });

                root.setOnMouseReleased((MouseEvent event) -> {
                    stage.setOpacity(1);
                });

                stage.initStyle(StageStyle.TRANSPARENT);

                stage.setScene(scene);
                stage.show();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @FXML

    private void closemodifier() {
    	ModifierEtudiant_Form.setVisible(false);
    	
    }
    
    @FXML

    private void closemodifier1() {
    	ModifierEnseignant_Form.setVisible(false);
    	
    }
    
    @FXML
    private void showAnchorPaneEnseig() {
    	AddEnseignant_form.setVisible(true);
    	
    }
    @FXML
    private void closeAnchorPaneEnseig() {
        // Clear the content of the AnchorPane
    	

        // Make the AnchorPane invisible
    	AddEnseignant_form.setVisible(false);
    }
    @FXML
    private void closeAnchorPane() {
        // Clear the content of the AnchorPane
    	  membersClear();

        // Make the AnchorPane invisible
    	AddEtudiant_Form.setVisible(false);
    }
    
    @FXML
    
    void switchForm(ActionEvent event) {
    	  if (event.getSource() == dashboard_btn) {

              dashboard_form.setVisible(true);
              ensiegnant_form.setVisible(false);
              dashboardNM();
              dashboardTC();
              dashboardChart();
              dashboardTI();
              dashboardChart1();
              members_form.setVisible(false);
              payment_Form.setVisible(false);
          	ModifierEtudiant_Form.setVisible(false);
              cour_form.setVisible(false);
              AddEtudiant_Form.setVisible(false);

             

          } else if (event.getSource() == coaches_btn) {

              dashboard_form.setVisible(false);
         
              members_form.setVisible(false);
              payment_Form.setVisible(false);
              AddEnseignant_form.setVisible(false);
              ensiegnant_form.setVisible(true);
              EnseinantGender();
              EnseignantMatiere();
          	ModifierEtudiant_Form.setVisible(false);
              enseignantShowData();
              Enseignantniveau();
              cour_form.setVisible(false);
              AddEtudiant_Form.setVisible(false);

           

          }else if (event.getSource() == ajouter_btn) {

              dashboard_form.setVisible(false);
           
              members_form.setVisible(false);
              payment_Form.setVisible(false);
              AddEnseignant_form.setVisible(false);
              ensiegnant_form.setVisible(false);
          	ModifierEtudiant_Form.setVisible(false);
              cour_form.setVisible(false);
              AddEtudiant_Form.setVisible(true);
              

           

          }  else if (event.getSource() == members_btn) {

              dashboard_form.setVisible(false);
             
              members_form.setVisible(true);
              AddEnseignant_form.setVisible(false);
              ensiegnant_form.setVisible(false);
              payment_Form.setVisible(false);
         // 	ModifierEtudiant_Form.setVisible(false);
              cour_form.setVisible(false);
              AddEtudiant_Form.setVisible(false);
              membersShowData();
              membersGender() ;
              membersStatus();
              membersniveau() ;
              memberTypesubs();
              memberMatiere();
              membersGender1() ;
              membersStatus1();
              membersniveau1() ;
              memberTypesubs1();
              memberMatiere1();
        

          } else if (event.getSource() == payment_btn) {

              dashboard_form.setVisible(false);
              paymentShowData();
              paymentMemberId();
              paymentName();

              members_form.setVisible(false);
          	ModifierEtudiant_Form.setVisible(false);
              payment_Form.setVisible(true);
              AddEtudiant_Form.setVisible(false);
              AddEnseignant_form.setVisible(false);
              ensiegnant_form.setVisible(false);
              cour_form.setVisible(false);

          

          }else if  (event.getSource() == cours_btn) {

              dashboard_form.setVisible(false);
             
              AddEtudiant_Form.setVisible(false);
              members_form.setVisible(false);
          	ModifierEtudiant_Form.setVisible(false);
              payment_Form.setVisible(false);
              AddEnseignant_form.setVisible(false);
              ensiegnant_form.setVisible(false);
              Courniveau();
              courShowData();
              cour_form.setVisible(true);
          }


    }
    private void setupSearchFunctionality() {
    	// Assuming this is where you initialize your controller
        EnseignantListData = EnseignantDataList();
        filteredEnseignantList = new FilteredList<>(EnseignantListData, p -> true);

        // Set up the search functionality
        searchTextField1.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredEnseignantList.setPredicate(enseignantData -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                // You can add more conditions based on the columns you want to search
                return enseignantData.getEnseignantId().toLowerCase().contains(lowerCaseFilter)
                        || enseignantData.getNomPrenom().toLowerCase().contains(lowerCaseFilter)
                        || String.valueOf(enseignantData.getTelephone()).contains(lowerCaseFilter)
                        || enseignantData.getNiveau().toLowerCase().contains(lowerCaseFilter)
                        || enseignantData.getMatiere().toLowerCase().contains(lowerCaseFilter)
                        || enseignantData.getGenre().toLowerCase().contains(lowerCaseFilter);
            });
        });

        // Wrap the filtered list in a SortedList
        SortedList<EnseignantData> sortedEnseignantList = new SortedList<>(filteredEnseignantList);
        sortedEnseignantList.comparatorProperty().bind(enseignat_tableView.comparatorProperty());

        // Set the sorted and filtered list to the table
        enseignat_tableView.setItems(sortedEnseignantList);

        // ... (other initialization code)

        // Other setup code related to search functionality
    }
    private void setupSearchFunctionality1() {
        // Assuming this is where you initialize your controller
    	membersListData = membersDataList();
        filteredEtudiantList = new FilteredList<>(membersListData, p -> true);

        // Set up the search functionality
        searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredEtudiantList.setPredicate(etudiantData -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();
            
                String dateDebutString = etudiantData.getDateDebut().toLocalDate().toString();
                String dateFinString = etudiantData.getDateFin().toLocalDate().toString();

                // You can add more conditions based on the columns you want to search
                return etudiantData.getEtudiantId().toLowerCase().contains(lowerCaseFilter)
                        || etudiantData.getNomPrenom().toLowerCase().contains(lowerCaseFilter)
                        || String.valueOf(etudiantData.getTelephone()).contains(lowerCaseFilter)
                        || etudiantData.getNiveau().toLowerCase().contains(lowerCaseFilter)
                        || etudiantData.getMatiere().toLowerCase().contains(lowerCaseFilter)
                        || etudiantData.getStatus().toLowerCase().contains(lowerCaseFilter)
                        || etudiantData.getTypeSubs().toLowerCase().contains(lowerCaseFilter)
                        || etudiantData.getGenre().toLowerCase().contains(lowerCaseFilter)|| dateDebutString.contains(lowerCaseFilter)
                        || dateFinString.contains(lowerCaseFilter);
            });
        });

        // Wrap the filtered list in a SortedList
        SortedList<EtudiantData> sortedEtudiantList = new SortedList<>(filteredEtudiantList);
        sortedEtudiantList.comparatorProperty().bind(members_tableView.comparatorProperty());

        // Set the sorted and filtered list to the table
        members_tableView.setItems(sortedEtudiantList);

        // ... (other initialization code)

        // Other setup code related to search functionality
    }
   @Override
    public void initialize(URL location, ResourceBundle resources) {

      
	   displayUsername() ;
        dashboardNM();
        dashboardTC();
        dashboardChart();
        paymentShowData();
        paymentMemberId();
        paymentName();
        dashboardTI();
        membersShowData();
        membersGender();
        dashboardChart1();
        setupSearchFunctionality1();
        membersStatus();
        setupSearchFunctionality();
      

        

      

    }

    
}
