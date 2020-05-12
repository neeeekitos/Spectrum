
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/** Represente le code
 * Cette code va expirer dans 24 h
 * @author Valentina ETEGAN
 * @author Lena LEHMANN
 */
public class Code {

        private String code;
        private String date;
        private int projectID;

         /** Constructeur qu'on appele à partir de la fénetre Create
          * @param code un code unique du projet
          * */
        public Code(String code){
            this.code = code;
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
            this.date = dateFormat.format(new Date());;
            projectID = 0;
        }


         /** Constructeur qu'on va appeler quand on crée un code
         * @param code un code unique du projet
         * @param projectID l'ID du projet
        * */
        public Code(String code, int projectID) {
            this.code = code;
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
            this.date = dateFormat.format(new Date());;
            this.projectID = projectID;
        }


        /** Constructeur qu'on va appeler dans la fenetre Ajouter
         * pour comparer le code qu'on vient d'ecrire avec le code qu'on a dans la DB
         * @param code un code unique du projet
         * @param date la date de creation de code
         * @param projectID l'ID du projet
         * */
         public Code(String code, String date, int projectID){
            this.projectID= projectID;
            this.code = code;
            this.date = date;
         }

        /** Methode qui compare le code donnee avec le code existent dans le projet
         * et qui l'ajout ou efface dans la base des donees
         * */
         public void codeCompare(String code, Client user) {
             Code c;

             try {
                 c = ConnectionExchange.getCodeIfExists(code);
                 if (c != null) {

                     //On prend la date de ce moment et la date du moment quand on a cree le code
                     //Si le Code a ete creer de plus que 24 h alors le code ne vais pas functiionner et il vais etre effacer
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



        /** Retourne le projetID du projet
         * @return projetID l'ID du projet
         */
        public int getProjectID(){ return projectID;}


        /** Retourne le code du projet
         * @return code un code unique pour le projet
         */
        public String getCode(){ return code;}


        /** Retourne la date de creation de code
         * @return date la date de creation de code
         */
        public String getDate(){ return date;}



}
