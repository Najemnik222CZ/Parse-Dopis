import java.io.StringReader;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

public static void main(String[] args) {

String letter1 = "Ing. Viktor Kaplan\n" + "øeditel\n" + "Kubova 13 363 01 OSTROV NAD OHØÍ\n"
+ "Vojkovice 8. záøí 2011\n" + "Žádost o pøerušení studia ze zdravotních dùvodù\n"
+ "Vážený pane øediteli,\n"
+ "žádám o pøerušení studia mého syna Jana Medka, žáka 3. roèníku tøídy 3. A. Dùvodem mé žádosti je vážný zdravotní stav mého syna.\n"
+ "Syn trpí delší dobu vážným ledvinovým onemocnìním, kvùli nìmuž v prùbìhu bìžného školního roku mìl nìkolik krátkodobých a dvì dlouhodobé absence. Kromì toho nastupuje 14. øíjna 2011 na mìsíèní lázeòskou léèbu, jež bude mít za následek další dlouhodobou nepøítomnost ve škole.\n"
+ "Podle prognózy lékaøe, která je souèástí pøiložené lékaøské zprávy, by se však synùv stav mìl zlepšit natolik, že by od zaèátku pøíštího školního roku mìl být schopen opakováním tøetího roèníku ve studiu pokraèovat. Vzhledem k dosavadnímu dobrému prospìchu mého syna\n"
+ "i k jeho zájmu studium zdárnì dokonèit vìøím, že mé žádosti vyhovíte.\n"
+ "S pozdravem František Medka\n";

String letter2 = "Vážený pan\n" + "MVDr. Daniel Trávíèek  \n" + "travnicek@gmail.com\n" + "Fügnerova 269/56\n"
+ "400 04 TRMICE\n" + "\n" + "Vážený pane doktore,\n"
+ "pøipomínam Vám zítøejší konferenci veterináøù v Opavì\n" + "\n" + "Tìšíme se na Vás,\n"
+ "HOTEL Opava\n";

Pattern pMail = Pattern.compile("([a-zA-Z0-9]+@[a-z]+[.]+[a-z]+)");
Pattern pGender = Pattern.compile("([p]+[a-á]+[n]+[e]+)");
Pattern pPhone = Pattern.compile("([1-9]{1}+[0-9]{8})");
Pattern pName = Pattern.compile("([A-ZŽŠÈØ]{1}+[a-záéìíùžšèøý]+[\\s]+[A-ZŽŠÈØ]{1}+[a-záéìíùžšèøý]+)");
Pattern pLanguage = Pattern.compile("([ìøù])");
Pattern pAddress = Pattern.compile( "([1-9]{1}+[0-9]{2}+[\\s]+[0-9]{2})");

System.out.println(" Email");
Matcher m1 = pMail.matcher(letter1);
Matcher m2 = pMail.matcher(letter2);

Person pe = new Person();
if (m2.find()) {
pe.email = m2.group(1);
System.out.println(m2.group() + " (2. letter)");

}
System.out.println();
System.out.println(" Gender");
Matcher m3 = pGender.matcher(letter1);
Matcher m4 = pGender.matcher(letter2);

Person pg = new Person();

if (m3.find()) {
pg.gender = m3.group(1);
System.out.println(m3.group() + "- man" + " (1. letter)");

}
if (m4.find()) {
pg.gender = m4.group(1);
System.out.println(m4.group() + "- man " + " (2. letter)");

}
System.out.println();
System.out.println(" Phone Number");
Matcher m5 = pPhone.matcher(letter1);
Matcher m6 = pPhone.matcher(letter2);

Person pp = new Person();
if (m5.find()) {
pp.phone = m5.group(1);
System.out.println(m5.group() + "- 1. letter");

} else {
if (m6.find()) {
pp.phone = m6.group(1);
System.out.println(m6.group() + "- 2. letter");

} else {
System.out.println("there is no telephone number in the letters ");
}

System.out.println();
System.out.println(" Language");

Person pl = new Person();
Matcher m7 = pLanguage.matcher(letter1);
Matcher m8 = pLanguage.matcher(letter2);

if (m7.find()) {
pl.language = m7.group(1);
System.out.println("I suppose, that person wrote in Czech because it appeared in the letter "
+ m7.group() + " (1. letter)");

}
if (m8.find()) {
pl.language = m8.group(1);
System.out.println("I suppose, that person wrote in Czech because it appeared in the letter "
+ m8.group() + " (2. letter)");
}

System.out.println();
System.out.println(
" Name (1. letter) --> I suppose, that person who is written first is the one I am looking for ");

Matcher m9 = pName.matcher(letter1);

Person pn = new Person();
if (m9.find()) {
pn.name = m9.group(1);
String Name = pn.name;
String name = Name.substring(0, Name.indexOf(' '));
String surname = Name.substring(Name.indexOf(' ') + 1);

System.out.println(name + " - first name");
System.out.println(surname + " - surname");
}

System.out.println();
System.out.println(
" Name (2. letter) --> I suppose, that person who is written first is the one I am looking for ");

Matcher m10 = pName.matcher(letter2);

if (m10.find()) {
pn.name = m10.group(1);
String Name = pn.name;
String name = Name.substring(0, Name.indexOf(' '));
String surname = Name.substring(Name.indexOf(' ') + 1);

System.out.println(name + " - first name");
System.out.println(surname + " - surname");
}

System.out.println();
System.out.println(" Addres");


Matcher Addres1 = pAddress.matcher(letter1);
Matcher Addres2 = pAddress.matcher(letter2);

Person pa = new Person();

if (Addres1.find()) {
pa.address = Addres1.group(1);
System.out.println(Addres1.group() + " - OSTROV NAD OHØÍ");

}
if (Addres2.find()) {
pa.address = Addres2.group(1);
System.out.println(Addres2.group() + " - TRMICE");

}

}
}
}