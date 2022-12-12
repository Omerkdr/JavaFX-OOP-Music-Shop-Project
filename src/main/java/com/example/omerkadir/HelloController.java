package com.example.omerkadir;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

import java.io.*;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import java.util.ArrayList;

import static javafx.application.Application.launch;

public class HelloController extends HelloApplication {
    @FXML
    private static Stage girisStage;
    @FXML
    private TextField txtKullaniciAdiGiris;
    @FXML
    private PasswordField txtSifreGiris;
    @FXML
    private TextField txtKullaniciAdiUye;
    @FXML
    private PasswordField txtSifreUye;

    private Button BtnUyeOl;
    private Button BtnGirisYap;
    private static String kullaniciName;
    private static ArrayList<String> kisiKullaniciName = new ArrayList();
    ArrayList<String> kisiSifresi = new ArrayList();

    public static Stage getGirisStage() {
        return girisStage;
    }

    public static String getkullaniciName() {
        return kullaniciName;
    }

    public static ArrayList<String> getKisiKullaniciName() {
        return kisiKullaniciName;
    }

    public HelloController() {

    }

    int sayac = 1;

    public void sayac() {
        try {
            RandomAccessFile rnd = new RandomAccessFile("KullaniciBilgileri.txt", "rw");

            for (int i = 1; rnd.readLine() != null; i++) {
                System.out.println(this.sayac);
                sayac++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    protected void BtnGirisYapClick() {
        sayac();
        try {
            RandomAccessFile raf = new RandomAccessFile("KullaniciBilgileri.txt", "rw");

            for (int i = 0; i < sayac - 2; ++i) {
                String dosyadakiKullanici = raf.readLine();
                String dosyadakiSifre = raf.readLine();
                Alert alert;
                if (txtKullaniciAdiGiris.getText().equals(dosyadakiKullanici) && txtSifreGiris.getText().equals(dosyadakiSifre)) {
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Mesaj Kutusu");
                    alert.setHeaderText("Giriş Başarılı");
                    alert.showAndWait().ifPresent((rs) -> {
                    });
                    Stage stage = new Stage();
                    girisStage = stage;
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Ana-Sayfa.fxml"));
                    Scene scene = null;

                    try {
                        scene = new Scene((Parent) fxmlLoader.load(), 829.0D, 570.0D);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    stage.setTitle("Ana Sayfa");
                    stage.setScene(scene);
                    getGirisStage().hide();
                    txtKullaniciAdiGiris.clear();
                    txtKullaniciAdiUye.clear();
                    txtSifreGiris.clear();
                    txtSifreUye.clear();
                    stage.show();
                    break;
                }

                if (i == sayac - 2)
                {
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Mesaj Kutusu");
                    alert.setHeaderText("Giriş Başarısız Üye Olmayı Denediniz mi ?");
                    alert.showAndWait().ifPresent((rs) -> {
                    });
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    protected void BtnUyeOlClick() {
        if (!this.txtKullaniciAdiUye.getText().equals("") && !this.txtSifreUye.getText().equals(""))
        {
            File file = new File("KullaniciBilgileri.txt");

            try {
                FileWriter fw = new FileWriter(file, true);
                file.createNewFile();
                String kisiKullaniciAdı = txtKullaniciAdiUye.getText();
                fw.write(kisiKullaniciAdı + "\r\n" + txtSifreUye.getText() + "\r\n");
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Mesaj Kutusu");
            alert.setHeaderText("Kayıt Başarılı Bir Şekilde Alındı");
            alert.showAndWait().ifPresent((rs) -> {
            });
            kisiKullaniciName.add(txtKullaniciAdiUye.getText());
            kisiSifresi.add(txtSifreUye.getText());
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Mesaj Kutusu");
            alert.setHeaderText("Eksik veya Hatalı Giriş Yaptınız");
            alert.showAndWait().ifPresent((rs) -> {
            });
        }

    }

    public static void main(String[] args) {
        launch();
    }

}