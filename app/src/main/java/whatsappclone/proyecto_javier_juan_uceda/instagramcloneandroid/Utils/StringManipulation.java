package whatsappclone.proyecto_javier_juan_uceda.instagramcloneandroid.Utils;

public class StringManipulation {

   public static String expandUsername(String username){
      return username.replace(".", " ");
   }

   public static String condenseUsername(String username){
      return username.replace(" " , ".");
   }
}