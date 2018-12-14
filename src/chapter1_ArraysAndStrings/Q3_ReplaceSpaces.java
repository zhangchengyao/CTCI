package chapter1_ArraysAndStrings;

public class Q3_ReplaceSpaces {
    void replaceSpaces(char[] str, int trueLength){
        int spaceCnt = 0;
        for(int i=0;i<trueLength;i++){
            if(str[i]==' ') spaceCnt++;
        }
        int idx = trueLength + spaceCnt*2 - 1;
        str[idx+1] = '\0';
        for(int i=trueLength-1;i>=0;i--){
            if(str[i]==' '){
                str[idx] = '0';
                str[idx-1] = '2';
                str[idx-2] = '%';
                idx -= 3;
            }else{
                str[idx--] = str[i];
            }
        }
    }
}
