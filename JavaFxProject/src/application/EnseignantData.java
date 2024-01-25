package application;
import java.sql.Date;
public class EnseignantData {
	

		    private Integer id;
		    private String EnseignantId;
		    private String NomPrenom;
		    private Integer Telephone;
		    private String Niveau;
		    private String Matiere;
		    private String genre;
		
		    public EnseignantData(Integer id, String EnseignantId, String NomPrenom, Integer Telephone,
		                         String Niveau, String matiere,String genre) {
		        this.id = id;
		        this.EnseignantId = EnseignantId;
		        this.NomPrenom = NomPrenom;
		        this.Telephone = Telephone;
		        this.Niveau = Niveau;
		        this.Matiere = matiere;
		        this.genre = genre;
		       
		    }

		    public Integer getId() {
		        return id;
		    }

		    public String getEnseignantId() {
		        return EnseignantId;
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
		 
		    public String getMatiere() {
		        return Matiere;
		    }
		  
		 
		    public String getGenre() {
		        return genre;
		    }
	
		
		}
		
