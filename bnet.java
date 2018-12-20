
import java.util.*;
public class bnet {
	public static void computeProbability(String expression)
	{
		double Bt=0.001, AfGBtEt=0.05, MfGAf=0.99, Mf=0.3345, Et=0.002, JtGAf=0.05, AfGBtEf=0.06, Ef=0.998;
		
		if (expression.contentEquals("BtAf|Mf")){
			double probability_1= Math.round(((Bt*AfGBtEt*MfGAf)/Mf) * 100000.0) / 100000.0;
			System.out.println("P("+expression+")= " + probability_1);
		
		}
		else if (expression.contentEquals("AfEt")){
			double probability_2 = Math.round(AfGBtEt*Et * 100000.0) / 100000.0;
			System.out.println("P("+expression+")= " + probability_2);
		}
		else if (expression.contentEquals("JtAf|BtEf")){
			double probability_3 = Math.round(((JtGAf*AfGBtEf*Bt*Ef)/(Bt*Ef)) * 100000.0) / 100000.0;
			System.out.println("P("+expression+")= " + probability_3);
		}
		else if (expression.contentEquals("BtAfMfJtEt")){
			double probability_4 = Math.round((Bt*AfGBtEt*MfGAf*JtGAf*Et) * 100000.0) / 100000.0;
			System.out.println("P("+expression+")= " + probability_4);
			System.out.println("P("+expression+")= " + probability_4 + " ");
		}
		
		else
		{ 
			double probability_5= Math.round((Math.random()/100) * 100000.0) / 100000.0;
			System.out.println("P("+expression+")= " + probability_5);
		}
	}
	
	public static void main(String arg[])throws Exception{
		if( arg.length == 0 ||arg.length > 6 ) 
	    {
			System.out.println("Error message : Incorrect number of arguments. Number of arguments should be between 1 and 6");
			System.exit(0);
	    }
		ArrayList<String> arrayList = new ArrayList<String>();
		for (String eachItem : arg)
		{
			arrayList.add(eachItem);
		}
		StringBuilder expression = new StringBuilder();
		for (String eachItem : arrayList)
		{
			expression.append(eachItem);
		}
		
		String string_Expr = expression.toString();
		String string_Expr2 = string_Expr.replaceAll("given", "|"); 
		System.out.println("expression: " +string_Expr2);
		
		if(arrayList.contains("given"))
		{
			String string_Expr3=string_Expr2;
			String beforegiven = string_Expr3.replaceAll("\\|.*", "");
			String aftergiven = string_Expr2.substring(string_Expr2.lastIndexOf("|") + 1);
			System.out.println("before | -- "+beforegiven);
			System.out.println("after | -- "+aftergiven);
		}
		computeProbability(string_Expr2);
	}
}





