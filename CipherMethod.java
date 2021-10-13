package zad1;

public class CipherMethod {
        IEncryptable callbackFtn;


        public String encryptText(String plainText,String cipher){
              return callbackFtn.encrypt(plainText,cipher);
        }
        public String decryptText(String cipherText, String cipher){
                return callbackFtn.decrypt(cipherText, cipher);
        }

}
