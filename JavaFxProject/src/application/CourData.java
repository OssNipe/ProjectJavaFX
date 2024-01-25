package application;

public class CourData {
    private Integer id;
    private String CourId;
    private String Description;
    private String Niveau;
    private Float Prix;
   
    public CourData(Integer id, String CourId , String Description , String Niveau , Float Prix  ) {
        this.id = id;
        this.CourId = CourId;
        this.Description = Description;
        this.Niveau = Niveau;
        this.Prix = Prix;
       
    }

    public Integer getId() {
        return id;
    }

    public String getCourId() {
        return CourId;
    }

    public String getDescription() {
        return Description;
    }

   
    public String getNiveau() {
        return Niveau;
    }

  
    public float getPrix()
{
    	return Prix;

}


}
