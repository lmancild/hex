package com.app.delivery.pickup.application.utils;

/**
 * @author lmancild
 * @since 1.0.0
 *
 */
public class AppDevileryMessageUtils {
	
	private static final String SEPARATOR = "------------------------------------------------------------------------";
	private static final String LINEBREAK = "\n";

	/**
	 * 
	 * @param title
	 * @param obj
	 * @return
	 */
	public static String generatedMessageLog(String title, Object... obj) {
		StringBuilder b = new StringBuilder();
		b.append(LINEBREAK);
		b.append(LINEBREAK);
		b.append(SEPARATOR);
		b.append(LINEBREAK);
		b.append(" -> " + title);
		b.append(LINEBREAK);
		b.append(SEPARATOR);
		b.append(LINEBREAK);
		if(obj != null) {
			for(Object o : obj) {
				b.append(o);
				b.append(LINEBREAK);
			}
		}
		b.append(SEPARATOR);
		b.append(LINEBREAK);
		return b.toString();
	}

}
