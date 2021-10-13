package zad1;

public class Encryption {
    private class MonoEncryption implements IEncryptable{


        private final char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
                'I',  'J', 'K', 'L', 'M', 'N', 'O', 'P',
                'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
                'Y', 'Z'};

        @Override
        public String encrypt(String plainText, String cipher){
            char[] cipherArr = cipher.toCharArray();

            int[] cipherInt = makeCipher(cipher);

            char[] cipherPad = new char[26];

            for(int i = 0; i < 26; i++)
                cipherPad[i] = alphabet[cipherInt[i]];

            String cipherText = new String();
            char[] plainTxt = plainText.toCharArray();
            for(int i = 0; i <= cipherArr.length; i++){
                cipherText+=cipherPad[plainTxt[i]-'A'];
            }
            return cipherText;
        }

        @Override
        public String decrypt(String cipherText, String cipher){
            char[] cipherArr = cipher.toCharArray();

            int[] cipherInt = makeCipher(cipher);

            char[] cipherPad = new char[26];

            for(int i = 0; i < 26; i++)
                cipherPad[i] = alphabet[cipherInt[i]];
            String plainText = new String();
            for(int i = 0; i < cipherArr.length; i++){
                plainText += alphabet[cipherPad[i]-'A'];
            }

            return plainText;

        }

        private int[] getCounts(String cipher){

            int[] counter = new int[26];
            char[] cipherArr = cipher.toCharArray();

            for(int i = 0; i < cipher.length(); i++){
                counter[cipherArr[i]-'A'] ++;
            }
            return counter;
        }
        private int[] makeCipher(String cipher){

            int[] cipherInt = new int[26];
            int[] counter = getCounts(cipher);
            char[] cipherArr = cipher.toCharArray();
            int index = 0;
            for(int i = 0 ; i < cipher.length(); i++){
                if(counter[cipherArr[i]-'A'] > 0){
                    cipherInt[index] = cipherArr[i];
                    index++;
                    counter[cipherArr[i]-'A'] = 0;
                }
            }
            for(int i = index ; i < 26 ;i++){
                cipherInt[i]  = alphabet[25 - (i - cipherArr.length)] - 'A';
            }

            return cipherInt;
        }
    }



    public MonoEncryption getMonoCipherMethod(){
        return new MonoEncryption();
    }
}
