
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Code {

        private String code;
        private String date;
        private int projectID;

        public Code(String code, String date){
            this.code = code;
            this.date = date;

        }

        //Constructuer qu'on appelle dans la fenetre ajouter quand on vais creer le code
        //On utilise ça car on n'a pas besoin d'avoir la date donnee dans constructeurs
         public Code(String code, int projectID){
            this.projectID= projectID;
            this.code = code;
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
            date = dateFormat.format(new Date());
         }

         //public void codeCompare(String code)

            // Code c = ConnectionExchange.getCodeIfExists(code);
           // date.now() - c.getDate() < 1 jour

        public int getProjectID(){ return projectID;}

        public String getCode(){ return code;}

        public String getDate(){ return date;}

        public void setCode(String c){


        }

        public boolean verifCode(String c,int date2){
                return false;
        }
}
