package br.com.chatanalise;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DateHelper {
    
    public static Date toDate( String data ) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat( "dd-MM-yyyy HH:mm:ss" );
            return dateFormat.parse( data );
        } catch (java.text.ParseException ex) {
            Logger.getLogger(DateHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new Date();
    }
    
    public static String toString( Date data ) {
        SimpleDateFormat dateFormat = new SimpleDateFormat( "dd-MM-yyyy HH:mm:ss" );
        return dateFormat.format( data );
    }
}
