package com.example.omerkadir;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class AnaSayfaController extends HelloController {
    @FXML
    private AnchorPane AnaSayfaYardımcıPane;

    @FXML
    private AnchorPane PaneElvisBilgi;

    @FXML
    private AnchorPane PaneFloydBilgi;

    @FXML
    private AnchorPane PaneMancoBilgi;

    @FXML
    private Label lblElvisBaslık;

    @FXML
    private Label lblElvisLakap;

    @FXML
    private Label lblElvisTur;

    @FXML
    private Label lblElvisCalgı;

    @FXML
    private Label lblFloydBaslık;

    @FXML
    private Label lblFloydUyruk;

    @FXML
    private Label lblFloydUye;

    @FXML
    private Label lblFloydTur;

    @FXML
    private Label lblFloydCalgı;

    @FXML
    private Label lblElvisUyruk;

    @FXML
    private ListView ListViewSepetTablo;

    @FXML
    private Label lblKartUzerıIsım;

    @FXML
    private Label lblKartUzeriSoyad;

    @FXML
    private Label lblKartNo;

    @FXML
    private Label lblCvc;

    @FXML
    private Label lblMusicHouse;

    @FXML
    private Label lblOmerkdr;


    @FXML
    private Label lblSepetTutarı;

    @FXML
    private AnchorPane PaneOdemeEkran;

    @FXML
    private AnchorPane PaneMagaza;

    @FXML
    private AnchorPane SanatcılarPane;

    @FXML
    private CheckBox chkAnketBaris;

    @FXML
    private CheckBox chkAnketElvis;

    @FXML
    private CheckBox chkAnketPink;

    @FXML
    private CheckBox chkblues;

    @FXML
    private CheckBox chkgece;

    @FXML
    private CheckBox chkgunbat;

    @FXML
    private CheckBox chkgundog;

    @FXML
    private CheckBox chkklas;

    @FXML
    private CheckBox chkpop;

    @FXML
    private CheckBox chkrock;

    @FXML
    private CheckBox chksanat;

    @FXML
    private CheckBox chkspotify;

    @FXML
    private CheckBox chkwalkman;

    @FXML
    private CheckBox chkyoutube;

    @FXML
    private Label lblAnketFav;

    @FXML
    private Label lblAnketKonser;

    @FXML
    private Label lblAnketPlat;

    @FXML
    private Label lblanketTur;

    @FXML
    private Label lblanketZaman;

    @FXML
    private AnchorPane paneAnket;

    @FXML
    private TextField txtAnketFav;

    @FXML
    private ListView listAnket;

    @FXML
    private Label lblGirisMusicHouse;

    @FXML
    private AnchorPane paneGecis;

    @FXML
    private CheckBox chkBarısSonsuz;

    @FXML
    private CheckBox chkMancoSaman;

    @FXML
    private CheckBox chkBarısTablo;

    @FXML
    private CheckBox chkElvisBest;

    @FXML
    private Label lblMancoBaslık;

    @FXML
    private Label lblMancoUyruk;

    @FXML
    private Label lblMancoLakap;

    @FXML
    private Label lblMancoCalgı;

    @FXML
    private Label lblMancoTur;

    @FXML
    private CheckBox chkElvisGold;

    @FXML
    private CheckBox chkElvisUkulele;

    @FXML
    private CheckBox chkFloydDarkside;

    @FXML
    private CheckBox chkFloydMetot;

    @FXML
    private CheckBox chkFloydWall;

    @FXML
    private TextField txtCVC;

    @FXML
    private TextField txtKartIsım;

    @FXML
    private TextField txtKartNo;

    @FXML
    private TextField txtKartSoyad;

    @FXML
    private ToggleGroup GroupToggle;

    @FXML
    private AnchorPane PaneBizeOner;

    @FXML
    private Label lblBizHouse;

    @FXML
    private Label lblbizKim;

    @FXML
    private TextField txtUrunOner;


    int toplamTutar = 0;
    int toplam = 0;



    @FXML
    protected void btnUygulamaGiris() {
        AnaSayfaYardımcıPane.setVisible(true);
        PaneOdemeEkran.setVisible(false);
        SanatcılarPane.setVisible(false);
        PaneMagaza.setVisible(false);
        PaneMagaza.setVisible(false);
        paneGecis.setVisible(false);

    }

    @FXML
    protected void btnGirisSayfasiClick() {
        AnaSayfaYardımcıPane.setVisible(true);
        PaneOdemeEkran.setVisible(false);
        SanatcılarPane.setVisible(false);
        PaneMagaza.setVisible(false);
        PaneMagaza.setVisible(false);
        paneGecis.setVisible(false);

    }

    @FXML
    protected void GerıDonOdemeClick() {
        AnaSayfaYardımcıPane.setVisible(false);
        PaneOdemeEkran.setVisible(false);
        SanatcılarPane.setVisible(false);
        PaneMagaza.setVisible(false);
        PaneMagaza.setVisible(true);
        paneGecis.setVisible(false);

    }

    @FXML
    protected void OdemeClick() throws IOException {

        Alert alert;
        if (txtKartIsım.getText().equals("") || txtKartSoyad.getText().equals("") || txtKartNo.getText().equals("") || txtCVC.getText().equals("")) {
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Mesaj Kutusu");
            alert.setHeaderText("Ödeme Bilgileri Alınamadı Eksiksiz giriniz");
            alert.showAndWait().ifPresent((rs) -> {
            });
        } else {
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Mesaj Kutusu");
            alert.setHeaderText("Ödeme Başarıyla Gerçekleştirildi");
            alert.showAndWait().ifPresent((rs) -> {
            });

            try (PrintWriter out = new PrintWriter(new BufferedWriter(   //DOSYAYA VERİ YAZAN KOD
                    new FileWriter("KartBilgileri.txt", true)))) {
                out.println(txtKartIsım.getText());
                out.println(txtKartSoyad.getText());
                out.println(txtKartNo.getText());
                out.println(txtCVC.getText());

            } catch (IOException exo) {
                exo.printStackTrace();
            }

        }

        try (PrintWriter out = new PrintWriter(new BufferedWriter(   //DOSYAYA VERİ YAZAN KOD LİSTEYİ YAZDIRCAK
                new FileWriter("AlışverisListesi.txt", true)))) {
            out.println(ListViewSepetTablo.getItems());

        } catch (IOException exo) {
            exo.printStackTrace();
        }

    }


    @FXML
    protected void btnBarisClick() throws IOException {
        PaneFloydBilgi.setVisible(false);
        PaneMancoBilgi.setVisible(true);
        PaneElvisBilgi.setVisible(false);

        try (BufferedReader readerManco = new BufferedReader(new FileReader("BarisManco.txt"))) {
            List.of(lblMancoBaslık, lblMancoUyruk, lblMancoLakap, lblMancoTur, lblMancoCalgı)
                    .forEach(label -> {
                        try {
                            label.setText(readerManco.readLine());
                        } catch (IOException exc) {
                            // handle exception
                        }
                    });
        }

    }

    @FXML
    protected void btnElvisClick() throws IOException {
        PaneFloydBilgi.setVisible(false);
        PaneMancoBilgi.setVisible(false);
        PaneElvisBilgi.setVisible(true);

        try (BufferedReader readerElvis = new BufferedReader(new FileReader("ElvisPresley.txt"))) {
            List.of(lblElvisBaslık, lblElvisUyruk, lblElvisLakap, lblElvisTur, lblElvisCalgı)
                    .forEach(label -> {
                        try {
                            label.setText(readerElvis.readLine());
                        } catch (IOException exc) {
                            // handle exception
                        }
                    });
        }

    }


    @FXML
    protected void btnFloydClick() throws IOException {
        PaneFloydBilgi.setVisible(true);
        PaneMancoBilgi.setVisible(false);
        PaneElvisBilgi.setVisible(false);

        try (BufferedReader readerFloyd = new BufferedReader(new FileReader("PinkFloyd.txt"))) {
            List.of(lblFloydBaslık, lblFloydUyruk, lblFloydUye, lblFloydTur, lblFloydCalgı)
                    .forEach(label ->
                    {
                        try {
                            label.setText(readerFloyd.readLine());
                        } catch (IOException exc) {
                            // handle exception
                        }
                    });
        }

    }

    @FXML
    protected void btnHakkımızdaClick() {
        AnaSayfaYardımcıPane.setVisible(true);
        PaneOdemeEkran.setVisible(false);
        SanatcılarPane.setVisible(false);
        PaneMagaza.setVisible(false);
        paneGecis.setVisible(false);

        Alert alert;
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Mesaj Kutusu");
        alert.setHeaderText("Bu proje Ömer Kadir KURT tarafından Hazırlanmıştır...");
        alert.showAndWait().ifPresent((rs) -> {
        });

    }

    @FXML
    protected void btnMagazaClick() {

        AnaSayfaYardımcıPane.setVisible(false);
        PaneOdemeEkran.setVisible(false);
        SanatcılarPane.setVisible(false);
        PaneMagaza.setVisible(true);
        paneGecis.setVisible(false);

    }

    @FXML
    protected void btnSepeteEkle() {

        try {
            for (int i = 0; i < 11; i++) {
                ArrayList<CheckBox> al = new ArrayList<>();
                al.add(chkBarısSonsuz);
                al.add(chkBarısTablo);
                al.add(chkFloydDarkside);
                al.add(chkFloydMetot);
                al.add(chkFloydWall);
                al.add(chkElvisUkulele);
                al.add(chkElvisBest);
                al.add(chkElvisGold);
                al.add(chkMancoSaman);
                if (al.get(i).isSelected()) {
                    ArrayList<Integer> urunFiyati = new ArrayList<Integer>();
                    urunFiyati.add(50);
                    urunFiyati.add(25);
                    urunFiyati.add(60);
                    urunFiyati.add(20);
                    urunFiyati.add(70);
                    urunFiyati.add(900);
                    urunFiyati.add(50);
                    urunFiyati.add(40);
                    urunFiyati.add(50);

                    for (int e = 0; e < 1; e++) {
                        toplam += urunFiyati.get(i);
                    }

                    lblSepetTutarı.setText(String.valueOf(toplam) + " TL ");

                    ListViewSepetTablo.getItems().add(al.get(i).getText() + urunFiyati.get(i) + "" + " TL ");

                }
            }

        } catch (Exception e) {
            System.out.println("Başarılı");
        }

        Alert alert;
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Mesaj Kutusu");
        alert.setHeaderText("Seçilen Ürünler Sepetinize Eklendi");
        alert.showAndWait().ifPresent((rs) -> {
        });

        txtKartIsım.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.matches("\\d*")) {
                txtKartIsım.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        txtKartSoyad.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.matches("\\d*")) {
                txtKartSoyad.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        txtCVC.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                txtCVC.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        txtKartNo.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                txtKartNo.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });

    }

    @FXML
    protected void btnSepetiSil() {
        toplam = 0;
        toplamTutar = 0;
        try {
            ListViewSepetTablo.getItems().clear();
            for (int i = 0; i < 11; i++) {
                ArrayList<CheckBox> al = new ArrayList<>();
                al.add(chkBarısSonsuz);
                al.add(chkBarısTablo);
                al.add(chkFloydDarkside);
                al.add(chkFloydMetot);
                al.add(chkFloydWall);
                al.add(chkElvisUkulele);
                al.add(chkElvisBest);
                al.add(chkElvisGold);
                al.add(chkMancoSaman);
                al.get(i).setSelected(false);

            }

        } catch (Exception e) {

        }
        Alert alert;
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Mesaj Kutusu");
        alert.setHeaderText("Sepetteki Tüm Ürünler Silindi");
        alert.showAndWait().ifPresent((rs) -> {
        });

        lblSepetTutarı.setText("0");


    }

    @FXML
    protected void btnOdemeEkranınaGec() throws IOException {
        AnaSayfaYardımcıPane.setVisible(false);
        PaneOdemeEkran.setVisible(true);
        SanatcılarPane.setVisible(false);
        PaneMagaza.setVisible(false);
        paneGecis.setVisible(false);
        try (BufferedReader readerOdemeEkrani = new BufferedReader(new FileReader("OdemeEkraniCekilenLabeller.txt"))) {
            List.of(lblKartUzerıIsım, lblKartUzeriSoyad, lblKartNo, lblCvc)
                    .forEach(label -> {
                        try {
                            label.setText(readerOdemeEkrani.readLine());
                        } catch (IOException exc) {
                            // handle exception
                        }
                    });
        }

    }

    @FXML
    protected void btnSanatciClick() {
        AnaSayfaYardımcıPane.setVisible(false);
        PaneOdemeEkran.setVisible(false);
        PaneMagaza.setVisible(false);
        SanatcılarPane.setVisible(true);
        paneGecis.setVisible(false);

    }

    @FXML
    void btnBizKimiz() throws IOException {
        AnaSayfaYardımcıPane.setVisible(false);
        PaneOdemeEkran.setVisible(false);
        PaneMagaza.setVisible(false);
        SanatcılarPane.setVisible(true);
        paneGecis.setVisible(false);
        PaneBizeOner.setVisible(true);

        try (BufferedReader readerBiz = new BufferedReader(new FileReader("BizKimizCekilecekler.txt"))) {
            List.of(lblbizKim, lblMusicHouse, lblBizHouse, lblOmerkdr)
                    .forEach(label ->
                    {
                        try {
                            label.setText(readerBiz.readLine());
                        } catch (IOException exc) {
                            // handle exception
                        }
                    });
        }

    }

    @FXML
    void btnUrunOner() throws IOException {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(
                new FileWriter("KullanıcıFeedback.txt", true)))) {
            out.println(txtUrunOner.getText());


        } catch (IOException exo) {
            exo.printStackTrace();
        }
        Alert alert;
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Mesaj Kutusu");
        alert.setHeaderText("Geri Bildiriminiz için Teşekkür ederiz");
        alert.showAndWait().ifPresent((rs) -> {
        });


    }

    @FXML
    protected void btnUrunOnerGeri() {
        AnaSayfaYardımcıPane.setVisible(true);
        PaneOdemeEkran.setVisible(false);
        PaneMagaza.setVisible(false);
        SanatcılarPane.setVisible(false);
        paneGecis.setVisible(false);
        PaneBizeOner.setVisible(false);


    }

    @FXML
    protected void btnAnket() throws IOException {
        AnaSayfaYardımcıPane.setVisible(true);
        PaneOdemeEkran.setVisible(false);
        PaneMagaza.setVisible(false);
        SanatcılarPane.setVisible(false);
        paneGecis.setVisible(false);
        PaneBizeOner.setVisible(false);
        paneAnket.setVisible(true);


        try (BufferedReader readerAnket = new BufferedReader(new FileReader("AnketSayfasıLabelCek.txt"))) {
            List.of(lblanketTur, lblanketZaman, lblAnketKonser, lblAnketPlat)
                    .forEach(label ->
                    {
                        try {
                            label.setText(readerAnket.readLine());
                        } catch (IOException exc) {
                            // handle exception
                        }
                    });
        }


    }
    @FXML
    protected  void btnSilAnket () {
        try {
            ListViewSepetTablo.getItems().clear();
            for (int i = 0; i < 15; i++) {
                ArrayList<CheckBox> anket = new ArrayList<>();
                anket.add(chkblues);
                anket.add(chkrock);
                anket.add(chkpop);
                anket.add(chksanat);
                anket.add(chkklas);
                anket.add(chkgundog);
                anket.add(chkgunbat);
                anket.add(chkgece);
                anket.add(chkAnketBaris);
                anket.add(chkAnketElvis);
                anket.add(chkAnketPink);
                anket.add(chkwalkman);
                anket.add(chkspotify);
                anket.add(chkyoutube);
                anket.get(i).setSelected(false);
                listAnket.getItems().clear();

            }

        } catch (Exception e) {

        }
        Alert alert;
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Mesaj Kutusu");
        alert.setHeaderText("Anket Temizlendi");
        alert.showAndWait().ifPresent((rs) -> {
        });

    }




     @FXML
     protected void btnktdon() {
        AnaSayfaYardımcıPane.setVisible(true);
        PaneOdemeEkran.setVisible(false);
        PaneMagaza.setVisible(false);
        SanatcılarPane.setVisible(false);
        paneGecis.setVisible(false);
        PaneBizeOner.setVisible(false);
        paneAnket.setVisible(false);

    }

    protected @FXML
    void btnsun() throws IOException {
        try {
            for (int i = 0; i < 15; i++) {
                ArrayList<CheckBox> anket = new ArrayList<>();
                anket.add(chkblues);
                anket.add(chkrock);
                anket.add(chkpop);
                anket.add(chksanat);
                anket.add(chkklas);
                anket.add(chkgundog);
                anket.add(chkgunbat);
                anket.add(chkgece);
                anket.add(chkAnketBaris);
                anket.add(chkAnketElvis);
                anket.add(chkAnketPink);
                anket.add(chkwalkman);
                anket.add(chkspotify);
                anket.add(chkyoutube);
                anket.get(i).isSelected();
                listAnket.getItems().add(anket.get(i).getText());

            }
            try (PrintWriter out = new PrintWriter(new BufferedWriter(
                    new FileWriter("AnketSonuclari.txt", true)))) {
                out.println(txtAnketFav.getText());


            } catch (IOException exo) {
                exo.printStackTrace();
            }


        } catch (Exception e) {
            System.out.println("Başarılı");
        }
        try (PrintWriter out = new PrintWriter(new BufferedWriter(
                new FileWriter("AnketSonuclari.txt", true)))) {
            out.println(listAnket.getItems());

        } catch (IOException exo) {
            exo.printStackTrace();
        }
        Alert alert;
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Mesaj Kutusu");
        alert.setHeaderText("Anket Sonuçları Dosyaya Yazdırıldı...");
        alert.showAndWait().ifPresent((rs) -> {
        });


    }

}
