package de.karrieretutor.springboot.domain;

import de.karrieretutor.springboot.enums.Zahlungsart;
import org.springframework.validation.BindingResult;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


@Entity
public class Kunde {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "{validation.adresse.vorname}")
    private String vorname;

    @NotBlank(message = "{validation.adresse.nachname}")
    private String nachname;

    @NotBlank(message = "{validation.adresse.strasse}")
    private String strasse;

    @NotBlank(message = "{validation.adresse.plz}")
    private String plz;

    @NotBlank(message = "{validation.adresse.ort}")
    private String ort;

    @NotNull(message = "{validation.zahlungsart.zahlungsart}")
    private Zahlungsart zahlungsart;

    private String iban;
    private String kreditkartenNr;

    @Email
    @NotBlank(message = "{validation.zahlungsart.email}")
    private String email;

    private String sprache = Locale.GERMAN.getLanguage ();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNameFormatiert() {
        return vorname + " " + nachname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public Zahlungsart getZahlungsart() {
        return zahlungsart;
    }

    public void setZahlungsart(Zahlungsart zahlungsart) {
        this.zahlungsart = zahlungsart;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getKreditkartenNr() {
        return kreditkartenNr;
    }

    public void setKreditkartenNr(String kreditkartenNr) {
        this.kreditkartenNr = kreditkartenNr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSprache() {
        return sprache;
    }

    public void setSprache(String sprache) {
        this.sprache = sprache;
    }

    // TODO: implementieren
    @Transient
    public boolean validiereZahlungsart(BindingResult result) {
        return false;
    }

    // TODO: implementieren
    @Transient
    public boolean validiereIBAN() {

        Map<String, Integer> ibanMap = new HashMap<String, Integer> ();

        ibanMap.put ( "DE", 22 );
        ibanMap.put ( "FR", 27 );
        ibanMap.put ( "GB", 22 );
        ibanMap.put ( "ES", 24 );

        if (ibanMap.containsKey ( "DE" ) && ibanMap.containsValue ( 22 )) {
            return true;
        } else if (ibanMap.containsKey ( "FR" ) && ibanMap.containsValue ( 27 )) {
            return true;
        } else if (ibanMap.containsKey ( "GB" ) && ibanMap.containsValue ( 22 )) {
            return true;
        } else if (ibanMap.containsKey ( "ES" ) && ibanMap.containsValue ( 24 )) {
            return true;
        } else {
            return false;
        }


//        int IBAN_MIN_SIZE = 15;
//        int IBAN_MAX_SIZE = 34;
//        long IBAN_MAX = 999999999;
//        long IBAN_MODULUS = 97;
//
//        String trimmed = iban.trim ();
//
//        if (trimmed.length () < IBAN_MIN_SIZE || trimmed.length () > IBAN_MAX_SIZE) {
//            return false;
//        }
//
//        String reformat = trimmed.substring ( 4 ) + trimmed.substring ( 0, 4 );
//        long total = 0;
//
//        for (int i = 0; i < reformat.length (); i++) {
//
//            int charValue = Character.getNumericValue ( reformat.charAt ( i ) );
//
//            if (charValue < 0 || charValue > 35) {
//                return false;
//            }
//
//            total = ( charValue > 9 ? total * 100 : total * 10 ) + charValue;
//
//            if (total > IBAN_MAX) {
//                total = ( total % IBAN_MODULUS );
//            }
//        }
//
//        return ( total % IBAN_MODULUS ) == 1;
    }

    // TODO: implementieren
    private boolean validiereKreditkartenNr() {
        return false;
    }

    @Override
    public String toString() {
        return "Kunde{" +
                "id=" + id +
                ", vorname='" + vorname + '\'' +
                ", nachname='" + nachname + '\'' +
                ", strasse='" + strasse + '\'' +
                ", plz='" + plz + '\'' +
                ", ort='" + ort + '\'' +
                ", zahlungsart=" + zahlungsart +
                ", iban='" + iban + '\'' +
                ", kreditkartenNr='" + kreditkartenNr + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
