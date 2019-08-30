public class CaesarCipher {
    private static int charNum, newCharNum =0;

    private static int isPunctuation(char c){ //метод-чеккер для дальнейшего сохранения пунктуации
        switch (c){
            case ' ' : return 32;
            case ',' : return 44;
            case '.' : return 46;
            case ':' : return 58;
            case ';' : return 59;
            case '!' : return 33;
            case '?' : return 63;
            case '-' : return 45;
            default : return -1;
        }
    }

    public static String encrypt(String str,int key){
        String newStr = "";
        for (int i = 0; i <str.length() ; i++) { // проверка символа, в случае принадлежности к знакам пунктуации - сохранение
            if (isPunctuation(str.charAt(i))!=-1){
                newStr+=(char)isPunctuation(str.charAt(i));
            }
            else if (str.charAt(i)>=65 && str.charAt(i)<90) { // в случае принадлежности к заглавной латинице (в таблице 65-90) - шифр
                    charNum = (str.charAt(i) + key);
                    newCharNum = (charNum - 65) % 25 + 65;
                    newStr += (char) newCharNum;
            }
            else if (str.charAt(i)>=97 && str.charAt(i)<122) { // в случае принадлежности к прописной латинице (в таблице 97-122) - шифр
                if (str.charAt(i) == 122) {
                    newStr += (char) (97 + key - 1);
                }
                else {
                    charNum = (str.charAt(i) + key);
                    newCharNum = (charNum - 97) % 25 + 97;
                    newStr += (char) newCharNum;
                }
            }
            else if (str.charAt(i)>=1072 && str.charAt(i)<=1103) { // в случае принадлежности к прописной кириллице (в таблице 1072-1103) - шифр
                    charNum = (str.charAt(i) + key);
                    newCharNum = (charNum - 1072) % 31 + 1072;
                    newStr += (char) newCharNum;
            }else {                                                 // в случае принадлежности к заглавной кириллице (в таблице 1040-1071) - шифр
                    charNum = (str.charAt(i) + key);
                    newCharNum = (charNum - 1040) % 31 + 1040;
                    newStr += (char) newCharNum;
            }
        }
        return newStr;
    }

    /*
    * Аналогично для дешифратора
     */

    public static String decrypt(String str,int key){
        String newStr = "";
        for (int i = 0; i <str.length() ; i++) {
            if (isPunctuation(str.charAt(i))!=-1) {
                newStr += (char) isPunctuation(str.charAt(i));
            }
            else if (str.charAt(i)>=65 && str.charAt(i)<=90){
                charNum = (str.charAt(i)-key);
                if (charNum==89){
                    newStr+=(char)90;
                }else{
                newCharNum = (charNum-65)%25+65;
                newStr += (char) newCharNum;
                }
            }
            else if (str.charAt(i)>=97 && str.charAt(i)<=122){
                charNum = (str.charAt(i)-key);
                if (charNum == 96){
                    newStr +=(char)122;
                }else{
                newCharNum = (charNum-97)%25+97;
                newStr += (char) newCharNum;
                }
            }
            else if (str.charAt(i)>=1040&&str.charAt(i)<=1071){
                charNum = (str.charAt(i)-key);
                if (charNum==1039){
                    newStr+=(char)1071;
                }else {
                    newCharNum = (charNum - 1040) % 31 + 1040;
                    newStr += (char) newCharNum;
                }
            }
            else {
                charNum = (str.charAt(i)-key);
                if (charNum==1071){
                    newStr+= (char)1103;
                }else {
                    newCharNum = (charNum - 1072) % 31 + 1072;
                    newStr += (char) newCharNum;
                }
            }
        }
        return newStr;
    }
}
