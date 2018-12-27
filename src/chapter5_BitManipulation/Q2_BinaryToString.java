package chapter5_BitManipulation;

public class Q2_BinaryToString {
    String printBinary(double num){
        if(num>=1 || num<=0) return "ERROR";

        StringBuilder binary = new StringBuilder();
        binary.append("0.");

        while(num>0){
            if(binary.length()>32) return "ERROR";
            num *= 2;
            if(num>=1){
                binary.append("1");
                num -= 1;
            } else{
                binary.append("0");
            }
        }
        return binary.toString();
    }
}
