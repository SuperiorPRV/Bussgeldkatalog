import java.util.*;

public class Bugld {

    int ort;
    int maxkmh;
    double deinekmh;
    double level;
    int toleranz = 5;
    double bussgeld;
    int strafpunkt;
    int fahrverbot;
    String spunkte;
    String monate;
    String land;
    double justitia;

    public void eingabe() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Sind sie innerhalb oder ausserhalb einer geschlossenen Ortschaft gefahren?\n1.\tInnerhalb einer geschlossenen Ortschaft\n2.\tausserhalb einer geschlossenen Ortschaft\n");
        ort = sc.nextInt();
        System.out.println("Was hoch ist die erlaubte Höchstgeschwindigkeit gewesen?");
        maxkmh = sc.nextInt();
        System.out.println("Wie schnell waren sie?");
        deinekmh = sc.nextDouble();

        sc.close();
        
        /*justitia = deinekmh - maxkmh - toleranz;

        if (justitia <= 5) {
            System.out.println("Keine geschwindigkeits überschreitung konnte ermittelt werden."); 
            System.exit(0);
        } else {
            System.out.println();
        }*/ //Brauche ich doch nicht.

        if (ort < 2) {
            innerhalbOrt();
        } else {
            ausserhalbOrt();
        }
    
    }

    public void ausserhalbOrt() {
        level = deinekmh - maxkmh - toleranz;

        if (level<=5) {
            System.out.println("Kein verstoß");
            System.exit(0);
        }else if (level<=10) {
            bussgeld = 20;
        }else if (level<15) {
            bussgeld = 40;
        }else if (level<20) {
            bussgeld = 60;
        }else if (level<25) {
            bussgeld = 100;
            strafpunkt =1;
        }else if (level<30) {
            bussgeld = 150;
            strafpunkt =1;
        }else if (level<40) {
            bussgeld = 200;
            strafpunkt = 2;
            fahrverbot = 1;
        }else if (level<50) {
            bussgeld = 320;
            strafpunkt = 2;
            fahrverbot = 1;
        }else if (level<60) {
            bussgeld = 480;
            strafpunkt = 2;
            fahrverbot = 1;
        }else if (level<70) {
            bussgeld = 600;
            strafpunkt = 2;
            fahrverbot = 2;
        }else {
            bussgeld = 700;
            strafpunkt = 2;
            fahrverbot = 3;
        }
        
    }

    public void innerhalbOrt() {
        level = deinekmh - maxkmh - toleranz;

        if (level<=5) {
            System.out.println("Keine geschwindigkeits überschreitung konnte ermittelt werden.");
            System.exit(0);
        }else if (level<=10) {
            bussgeld = 30;
        }else if (level<15) {
            bussgeld = 50;
        }else if (level<20) {
            bussgeld = 70;
            strafpunkt = 1;
        }else if (level<25) {
            bussgeld = 115;
            strafpunkt =1;
        }else if (level<30) {
            bussgeld = 180;
            strafpunkt =1;
        }else if (level<40) {
            bussgeld = 260;
            strafpunkt = 2;
            fahrverbot = 1;
        }else if (level<50) {
            bussgeld = 400;
            strafpunkt = 2;
            fahrverbot = 1;
        }else if (level<60) {
            bussgeld = 600;
            strafpunkt = 2;
            fahrverbot = 2;
        }else if (level<70) {
            bussgeld = 700;
            strafpunkt = 2;
            fahrverbot = 3;
        }else {
            bussgeld = 800;
            strafpunkt = 2;
            fahrverbot = 3;
        }
        
    }

    public void sprachanpassung() {
        
        switch (strafpunkt) {
            case 1:
                spunkte = "strafpunkt";
                break;       
            default:
            spunkte = "strafpunkte";
                break;
        }

        switch (fahrverbot) {
            case 1:
                monate = "monat";
                break;
            default:
            monate = "monate";
                break;
        }

        switch (ort) {
            case 1:
                land = "innerhalb einer geschlossener Ortschaft";
                break;
            default:
            land = "ausserhalb einer geschlossener Ortschaft";
                break;
        }

    }

    public void ausgabe() {

        System.out.println("Sie sind " + land + deinekmh + " km/H gefahren.");
        System.out.println("Sie müssen nun " + bussgeld + "€ bezahlen");
        System.out.println("Fahverbot:\t" + fahrverbot + " " + monate);
        System.out.println("Strafpunkte:\t" + strafpunkt + " " + spunkte);
     
    }

    public static void main(String[] args) {
        Bugld b = new Bugld();

        b.eingabe();
        b.sprachanpassung();
        b.ausgabe();

    }
    
}
