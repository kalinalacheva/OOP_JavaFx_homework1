package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import zad1.CipherMethod;
import zad1.Encryption;
import zad1.IEncryptable;

public class Controller {


    @FXML
    private TextField txtKey;

    @FXML
    private TextField txtPlainText;

    @FXML
    private TextField txtCipherText;

    @FXML
    private Button btnEncrypt;

    @FXML
    private Button btnDecrypt;

    @FXML
    private Button btnQuit;



    @FXML
    void btnDecryptOnAction(ActionEvent event) {
        Encryption encryption = new Encryption();

        CipherMethod method = new CipherMethod();


        txtPlainText.setText(method.decryptText
                (txtCipherText.getText(),txtKey.getText()));
    }

    @FXML
    void btnEncryptOnAction(ActionEvent event) {
        Encryption encryption = new Encryption();

        CipherMethod method = new CipherMethod();


        txtCipherText.setText(method.encryptText
                (txtPlainText.getText(),txtKey.getText()));
    }

    @FXML
    void btnQuitOnAction(ActionEvent event) {
            System.exit(0);
    }

}
