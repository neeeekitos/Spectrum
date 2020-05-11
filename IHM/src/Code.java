
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Code {

        private String code;
        private String date;
        private int projectID;

        public Code(String code, String date){
            this.code = code;
            this.date = date;
            projectID = 0;
        }

        //Constructeur qu'on appelle dans la fenetre ajouter quand on vais creer le code
        //On utilise ça car on n'a pas besoin d'avoir la date donnee dans constructeurs
         public Code(String code, int projectID){
            this.projectID= projectID;
            this.code = code;
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
            date = dateFormat.format(new Date());
         }

         public void codeCompare(String code, Client user) {
             Code c;

             try {
                 c = ConnectionExchange.getCodeIfExists(code);
                 if (c != null) {
                     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
                     Date date1 = sdf.parse(c.getDate());
                     Date date2 = sdf.parse(this.getDate());
                     long diffHeures = (date2.getTime() - date1.getTime())/1000/3600;
                     if (diffHeures<=24) {
                         System.out.println("Le code d'invitation est utilisé par @" + user.getUsername());
                         System.out.println("Le code d'invitation est encore valide " + (24-diffHeures) + " heures");
                         user.getConnectionExchange().addCollabInProject(user.getUsername(), c.getProjectID());
                     } else {
                         System.out.println("Le code n'est plus valide");
                         //ConnectionExchange.deleteProjectCode(code);
                     }

                 }
                 // date.now() - c.getDate() < 1 jour
                 //long difference = date2.getTime() - date1.getTime();
             } catch (SQLException e) {
                 e.printStackTrace();
             } catch (ParseException e) {
                 e.printStackTrace();
             }
         }



        public int getProjectID(){ return projectID;}

        public String getCode(){ return code;}

        public String getDate(){ return date;}

        public void setCode(String c){


        }

        public boolean verifCode(String c,int date2){
                return false;
        }
}
