package application;

import java.sql.Date;
import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EtudiantData {
    private Integer id;
    private String EtudiantId;
    private String NomPrenom;
    private Integer Telephone;
    private String Niveau;
    private String Genre;
    private String Matiere;
    private Date DateDebut;
    private Date DateFin;
    private String status;
    private Double price;
    private String TypeSubs;
    public EtudiantData(Integer id, String etudiantId, String NomPrenom, Integer Telephone,
                         String Niveau, String matiere, Date DateDebut,
                         Date DateFin, String Statue, String TypeSubs, String Genre,Double price) {
        this.id = id;
        this.EtudiantId = etudiantId;
        this.NomPrenom = NomPrenom;
        this.Telephone = Telephone;
        this.Niveau = Niveau;
        this.Genre = Genre;
        this.Matiere = matiere;
        this.DateDebut = DateDebut;
        this.DateFin = DateFin;
        this.TypeSubs = TypeSubs;
        this.status = Statue;
    }
   
    public Integer getId() {
        return id;
    }

    public String getEtudiantId() {
        return EtudiantId;
    }

    public String getNomPrenom() {
        return NomPrenom;
    }

    public Integer getTelephone() {
        return Telephone;
    }

    public String getNiveau() {
        return Niveau;
    }

    public String getGenre() {
        return Genre;
    }

    public String getMatiere() {
        return Matiere;
    }

    public Date getDateDebut() {
        return DateDebut;
    }

    public Date getDateFin() {
        return DateFin;
    }

    public String getTypeSubs() {
        return TypeSubs;
    }

    public String getStatus() {
        return status;
    }
    public Double getPrice() {
        return price;
    }
}
