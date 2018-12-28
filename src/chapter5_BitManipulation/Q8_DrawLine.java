package chapter5_BitManipulation;

public class Q8_DrawLine {
    void drawLine(byte[] screen, int width, int x1, int x2, int y){
        int offset = y*width/8;
        int idx1 = offset + x1/8;
        int idx2 = offset + x2/8;

        for(int i=idx1+1;i<idx2;i++) screen[i] = (byte)0xff;

        int offset1 = x1 % 8;
        int offset2 = x2 % 8;

        byte mask1 = (byte)(0xff >>> offset1);
        byte mask2 = (byte) (0xff << (7-offset2));

        if(idx1==idx2){
            byte mask = (byte) (mask1 & mask2);
            screen[idx1] |= mask;
        } else {
            screen[idx1] |= mask1;
            screen[idx2] |= mask2;
        }
    }
}
