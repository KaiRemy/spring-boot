package de.karrieretutor.springboot.domain;

import de.karrieretutor.springboot.Const;
import com.sun.xml.bind.v2.TODO;
import de.karrieretutor.springboot.enums.Zahlungsart;
import org.springframework.validation.BindingResult;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static de.karrieretutor.springboot.Const.CUSTOMER;
import static javax.persistence.CascadeType.ALL;


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
    // TODO: in der DB verschlüsseln
    private String password;

    private String sprache = Locale.GERMAN.getLanguage();

    @OneToMany(mappedBy = CUSTOMER, cascade = ALL)
    private List<Bestellung> bestellungen = new ArrayList<>();

    public Kunde() {}

    public Kunde(String email, String passwort) {
        this.email = email;
        this.password = passwort;
    }

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

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public List<Bestellung> getBestellungen() {
        return bestellungen;
    }
    public void setBestellungen(List<Bestellung> bestellungen) {
        this.bestellungen = bestellungen;
    }


    // TODO: implementieren
    @Transient
    public boolean validiereZahlungsart(BindingResult result) {
        return false;
    }

    // TODO: implementieren
    private boolean validiereIBAN() { return false; }

//    private static final String DEFSTRS = ""
//            + "AL28 AD24 AT20 AZ28 BE16 BH22 BA20 BR29 BG22 "
//            + "HR21 CY28 CZ24 DK18 DO28 EE20 FO18 FI18 FR27 GE22 DE22 GI23 "
//            + "GL18 GT28 HU28 IS26 IE22 IL23 IT27 KZ20 KW30 LV21 LB28 LI21 "
//            + "LT20 LU20 MK19 MT31 MR27 MU30 MC27 MD24 ME22 NL18 NO15 PK24 "
//            + "PS29 PL28 PT25 RO24 SM27 SA24 RS22 SK24 SI19 ES24 SE24 CH21 "
//            + "TN24 TR26 AE23 GB22 VG24 GR27 CR21";
//    private static final Map<String, Integer> DEFINITIONS = new HashMap<> ();
//
//    static {
//        for (String definition : DEFSTRS.split(" "))
//            DEFINITIONS.put(definition.substring(0, 2), Integer.parseInt(definition.substring(2)));
//    }

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
