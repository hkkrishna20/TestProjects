import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Test {

	
	static String cellulosedegrading="GH5; GH6; GH7; GH8; GH9; GH10; GH12; GH26; GH44; GH45; GH48; GH51; GH74; GH124; GH1; GH2; GH3; GH5; GH9; GH30; GH39; GH116; GH5; GH6; GH9; AA9; AA10; AA15; AA3; GH1; GH3; GH5; GH9; CBM1; CBM2; CBM3; CBM4; CBM6; CBM8; CBM9; CBM10; CBM16; CBM17; CBM28; CBM30; CBM37; CBM44; CBM46; CBM49; CBM59; CBM63; CBM64; CBM72";
	static String hemicellulosedegrading ="GH3; GH5; GH8; GH9; GH10; GH11; GH12; GH16; GH26; GH30; GH43; GH44; GH51; GH62; GH98; GH141;GH1; GH2; GH3; GH5; GH9; GH30; GH39; GH116; GH1; GH2; GH5; GH1; GH3; GH5; GH30; GH39; GH43; GH51; GH52; GH54; GH116; GH120;GH3; GH5; GH16; GH17; GH55; GH5; GH9; GH26; GH44; GH113; GH134; GH5; GH9; GH12; GH16; GH26; GH44; GH74; GH30; GH5;CE1; CE2; CE3; CE4; CE5; CE6; CE7; CE12; CE15; AA9; AA14;CBM2; CBM4; CBM6; CBM9; CBM13; CBM15; CBM22; CBM31; CBM35; CBM36; CBM37; CBM42; CBM54; CBM59; CBM60; CBM72;CBM13; CBM16; CBM23; CBM27; CBM29; CBM35; CBM59; CBM62; CBM72; CBM76; CBM80;CBM13; CBM42; CBM62; CBM44; CBM62; CBM65; CBM75; CBM76; CBM78; CBM80; CBM81; GH3; GH43; GH51; GH54; GH62; GH127; GH137; GH142; GH146;";
	static String lignindegrading="AA1; AA2; AA3; AA4; AA5; AA6; AA8; AA9; AA12; CE1; CE15; CE10;";
	static String pectindegrading ="GH28; GH28; GH33; GH78; GH106;GH4; GH78; GH106; GH2; GH3; GH10; GH43; GH51; GH54; GH62;GH93; GH1; GH2; GH3; GH35; GH39; GH42; GH50; GH59; GH147;PL1; PL2; PL3; PL9; PL10; PL1; PL2; PL9; PL1; PL4; PL9; PL11;PL11; PL26; PL22; CE8; CE12; CE13; CE6; CBM41; CBM77; CBM13; CBM32; CBM51; CBM61; CBM80; CBM67; CBM62;";
	static String starchdegrading ="GH13; GH14; GH57; GH119; GH126;AA13; GH4; GH31; GH63; GH97; GH122; GT35; CBM20; CBM21; CBM25; CBM26; CBM34; CBM45; CBM53; CBM69; CBM74; CBM82; CBM83;";
	static String inulingrading=" GH32; GH91; CBM38";
	static String cellulosedegradingArray[] = cellulosedegrading. split(";");
	static String hemicellulosedegradingArray[] = hemicellulosedegrading. split(";");
	static String lignindegradingArray[] = lignindegrading. split(";");
	static String pectindegradingArray[] = pectindegrading. split(";");
	static String starchdegradingArray[] = starchdegrading. split(";");
	static String inulingradingArray[] = inulingrading. split(";");
	
	static List<String> cellulosedegradinglist= new ArrayList<String>(Arrays.asList(cellulosedegradingArray));
	static List<String> hemicellulosedegradinglist= new ArrayList<String>(Arrays.asList(hemicellulosedegradingArray));
	static List<String> lignindegradinglist= new ArrayList<String>(Arrays.asList(lignindegradingArray));
	static List<String> pectindegradinglist= new ArrayList<String>(Arrays.asList(pectindegradingArray));
	static List<String> starchdegradinglist= new ArrayList<String>(Arrays.asList(starchdegradingArray));
	static List<String> inulingradinglist= new ArrayList<String>(Arrays.asList(inulingradingArray));
	
	static List<String> uniquecellulosedegradinglistStrings = 
			cellulosedegradinglist.stream().map(String::trim).collect(Collectors.toList());
	static List<String> uniquehemicellulosedegradinglistStrings = 
			hemicellulosedegradinglist.stream().map(String::trim).collect(Collectors.toList());
	static List<String> uniquelignindegradinglistStrings = 
			lignindegradinglist.stream().map(String::trim).collect(Collectors.toList());
	static List<String> uniquepectindegradinglistStrings = 
			pectindegradinglist.stream().map(String::trim).collect(Collectors.toList());
	static List<String> uniquestarchdegradinglistStrings = 
			starchdegradinglist.stream().map(String::trim).collect(Collectors.toList());
	static List<String> uniqueinulingradinglistStrings = 
			inulingradinglist.stream().map(String::trim).collect(Collectors.toList());
	
	
	
	static List<String> uniquecellulosedegradinglist = uniquecellulosedegradinglistStrings.stream().distinct().collect(Collectors.toList());
	static List<String> uniquehemicellulosedegradinglist = uniquehemicellulosedegradinglistStrings.stream().distinct().collect(Collectors.toList());
	static List<String> uniquelignindegradinglist = uniquelignindegradinglistStrings.stream().distinct().collect(Collectors.toList());
	static List<String> uniquepectindegradinglist = uniquepectindegradinglistStrings.stream().distinct().collect(Collectors.toList());
	static List<String> uniquestarchdegradinglist = uniquestarchdegradinglistStrings.stream().distinct().collect(Collectors.toList());
	 
	static List<String> uniqueinulingradinglist = uniqueinulingradinglistStrings.stream().distinct().collect(Collectors.toList());
	 
	

	
public static void main(String[] args) {
	
	
	System.out.println(" unique Cellulose Degrading List :"+ uniquecellulosedegradinglist + " size : "+uniquecellulosedegradinglist.size() );
	System.out.println("\n\n\n ");
	System.out.println("\n\n\n unique hemi Cellulose Degrading List :"+uniquehemicellulosedegradinglist + " size : "+uniquehemicellulosedegradinglist.size() ); 
	System.out.println("\n\n\n ");
	System.out.println("\n\n\n unique lignin Degrading List :"+uniquelignindegradinglist + " size : "+uniquelignindegradinglist.size() );
	System.out.println("\n\n\n ");
	System.out.println("\n\n\n unique pectin Degrading List :"+uniquepectindegradinglist + " size : "+uniquepectindegradinglist.size() );
	System.out.println("\n\n\n ");
	System.out.println("\n\n\n unique starch Degrading List :"+uniquestarchdegradinglist + " size : "+uniquestarchdegradinglist.size() );
	System.out.println("\n\n\n unique inulin Degrading List :"+uniqueinulingradinglist + " size : "+uniqueinulingradinglist.size() );

}
}
