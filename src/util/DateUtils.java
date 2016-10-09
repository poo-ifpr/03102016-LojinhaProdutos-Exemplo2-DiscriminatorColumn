package util;

import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class DateUtils {

	private static SimpleDateFormat dateFormatter;
	private static String dateFormat = "dd/MM/yyyy";
	
	static {
		dateFormatter = new SimpleDateFormat();
		dateFormatter.applyPattern(dateFormat);
	}
	
	public static String formataData(Date date){
		return dateFormatter.format(date); 
	}
	
	public static Date converteData(String data){
		try {
			return dateFormatter.parse(data);
		} catch (ParseException e) {
			return null;
		}
	}
	
	public static Date hoje(){
		return Calendar.getInstance().getTime();
	}
	
	public static Date somar(Date date, int dias){
		long hoje_mili = hoje().getTime();
		long dias_mili = dias * 24 * 60 * 60 * 1000;
		long soma = hoje_mili + dias_mili;
		Date data_soma = Calendar.getInstance().getTime();
		data_soma.setTime(soma);
		return data_soma;
	}
	
}
