package br.unic.generic.functions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataLib {
	
	public static String formatarData(String formato, Date data){
		SimpleDateFormat dateFormat = new SimpleDateFormat(formato);
		return dateFormat.format(data);
	}
	
	public static String formatarMysql(Date data){
		return formatarData("yyyy-MM-dd", data);
	}
	
	public static Date converterData(String formato, String data){
		if(data == "" || data == null){
			return null;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(formato);
		try {
			return dateFormat.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Date converterDataMysql(String data){
		return converterData("yyyy-MM-dd", data);
	}
}
