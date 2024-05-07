package Utils;

public class UtilsMethods {
    public static boolean isNumeric(String text){
        boolean result;

        try{
            Integer.parseInt(text);
            result = true;
        }catch (NumberFormatException e){
            result = false;
        }

        return result;
    }


}
