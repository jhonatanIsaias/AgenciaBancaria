/**
 * 
 */
package Utilitarios;

import java.text.NumberFormat;
/**
 * @author Login
 *
 */
public class Utils {
	static NumberFormat formatandoValores = NumberFormat.getCurrencyInstance();
	
	public static String doubleToString(Double valor) {
			return formatandoValores.format(valor);
	}
}
