import java.io.StringReader;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

public static void main(String[] args) {

String letter1 = "Ing. Viktor Kaplan\n" + "�editel\n" + "Kubova 13 363 01 OSTROV NAD OH��\n"
+ "Vojkovice 8. z��� 2011\n" + "��dost o p�eru�en� studia ze zdravotn�ch d�vod�\n"
+ "V�en� pane �editeli,\n"
+ "��d�m o p�eru�en� studia m�ho syna Jana Medka, ��ka 3. ro�n�ku t��dy 3. A. D�vodem m� ��dosti je v�n� zdravotn� stav m�ho syna.\n"
+ "Syn trp� del�� dobu v�n�m ledvinov�m onemocn�n�m, kv�li n�mu� v pr�b�hu b�n�ho �koln�ho roku m�l n�kolik kr�tkodob�ch a dv� dlouhodob� absence. Krom� toho nastupuje 14. ��jna 2011 na m�s��n� l�ze�skou l��bu, je� bude m�t za n�sledek dal�� dlouhodobou nep��tomnost ve �kole.\n"
+ "Podle progn�zy l�ka�e, kter� je sou��st� p�ilo�en� l�ka�sk� zpr�vy, by se v�ak syn�v stav m�l zlep�it natolik, �e by od za��tku p��t�ho �koln�ho roku m�l b�t schopen opakov�n�m t�et�ho ro�n�ku ve studiu pokra�ovat. Vzhledem k dosavadn�mu dobr�mu prosp�chu m�ho syna\n"
+ "i k jeho z�jmu studium zd�rn� dokon�it v���m, �e m� ��dosti vyhov�te.\n"
+ "S pozdravem Franti�ek Medka\n";

String letter2 = "V�en� pan\n" + "MVDr. Daniel Tr�v��ek  \n" + "travnicek@gmail.com\n" + "F�gnerova 269/56\n"
+ "400 04 TRMICE\n" + "\n" + "V�en� pane doktore,\n"
+ "p�ipom�nam V�m z�t�ej�� konferenci veterin��� v Opav�\n" + "\n" + "T��me se na V�s,\n"
+ "HOTEL Opava\n";

Pattern pMail = Pattern.compile("([a-zA-Z0-9]+@[a-z]+[.]+[a-z]+)");
Pattern pGender = Pattern.compile("([p]+[a-�]+[n]+[e]+)");
Pattern pPhone = Pattern.compile("([1-9]{1}+[0-9]{8})");
Pattern pName = Pattern.compile("([A-Z����]{1}+[a-z����������]+[\\s]+[A-Z����]{1}+[a-z����������]+)");
Pattern pLanguage = Pattern.compile("([���])");
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
System.out.println(Addres1.group() + " - OSTROV NAD OH��");

}
if (Addres2.find()) {
pa.address = Addres2.group(1);
System.out.println(Addres2.group() + " - TRMICE");

}

}
}
}