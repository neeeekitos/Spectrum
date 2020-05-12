
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/** Représente le code secret permettant d'accéder à un projet en particulier
 * Ce code va expirer dans 24 h
 * @author Valentina ETEGAN
 * @author Lena LEHMANN
 */
public class Code {

        private String code;
        private String date;
        private int projectID;

         /** Constructeur qu'on appelle à partir de la fenêtre Create
          * @param code un code unique, spécifique au projet
          * */
        public Code(String code){
            this.code = code;
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
            this.date = dateFormat.format(new Date());;
            projectID = 0;
        }


         /** Constructeur qu'on va appeler quand on crée un code
         * @param code un code unique, spécifique au projet
         * @param projectID l'ID du projet
        * */
        public Code(String code, int projectID) {
            this.code = code;
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
            this.date = dateFormat.format(new Date());;
            this.projectID = projectID;
        }


        /** Constructeur qu'on va appeler dans la fenêtre Ajouter,
         * pour comparer le code qu'on vient d'écrire avec le code qu'on a dans la BD
         * @param code un code unique, spécifique au projet
         * @param date la date de création du code
         * @param projectID l'ID du projet
         * */
         public Code(String code, String date, int projectID){
            this.projectID= projectID;
            this.code = code;
            this.date = date;
         }

        /** Méthode qui compare le code donné avec le code existant dans le projet
         * et qui l'ajoute ou l'efface dans la base de données
         * */
         public void codeCompare(String code, Client user) {
             Code c;

             try {
                 c = ConnectionExchange.getCodeIfExists(code);
                 if (c != null) {

                     //On prend la date du moment présent et la date du moment où on a créé le code
                     //Si le Code a été créé il y a plus que 24 h, alors celui-ci n'est plus valide : il ne fonctionnera pas et va être effacé
                     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
                     Date date1 = sdf.parse(c.getDate());
                     Date date2 = sdf.parse(this.getDate());
                     long diffHeures = (date2.getTime() - date1.getTime())/1000/3600;
                     if (diffHeures<=24) {
                         System.out.println("Le code d'invitation est utilisé par @" + user.getUsername());
                         System.out.println("Le code d'invitation est encore valide pendant " + (24-diffHeures) + " heures");
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


        /** Retourne la date de création du code
         * @return date la date de création du code
         */
        public String getDate(){ return date;}



}
