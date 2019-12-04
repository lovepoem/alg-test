package io.lovepoem;

public class BitNumberSub {
    public static String getMultiplyStringStringString(String s1, String s2) {

        char[] lefts = s1.toCharArray();
        char[] rights = s2.toCharArray();
        int length = lefts.length + rights.length - 1;
        int[] temp = new int[length];
        for (int i = 0; i < lefts.length; i++) {
            for (int j = 0; j < rights.length; j++) {
                temp[i + j] += Integer.parseInt(String.valueOf(lefts[i])) * Integer.parseInt(String.valueOf(rights[j]));
            }
        }

        for (int i = length - 1; i >= 0; i--) {
            if (temp[i] >= 10 && (i - 1) >= 0) {
                temp[i - 1] += temp[i] / 10;
                temp[i] = temp[i] % 10;
            }
        }

        StringBuffer result = new StringBuffer();
        for (int i = 0; i < length; i++) {
            System.out.print(temp[i]);
            result.append(temp[i]);
        }

        return result.toString();
    }

    public static String multiply(String num1, String num2) {
        String result = "";
        char[] left=num1.toCharArray();
        char[] right=num2.toCharArray();
        int length =  left.length+right.length-1;
        int[] combine = new int[length];
        for(int i=0;i<left.length;i++){
            for(int j=0;j<right.length;j++){
                combine[i+j] +=Integer.parseInt(String.valueOf(left[i]))*Integer.parseInt(String.valueOf(right[j]));
            }
        }

        for(int i=length-1;i>=0;i--){
            if (combine[i] >= 10 && (i - 1) >= 0) {
                combine[i-1] +=combine[i]/10;
                combine[i] = combine[i]%10;
            }
        }
        for(int i=0;i<length ;i++){
            result+=combine[i];
        }
        while(result.length()>0 && result.charAt(0) == '0'){
            if(!result.equals("0")){
                result = result.replaceFirst("0","");
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String one = "1230";
        String two = "456";
        String result = multiply(one, two);
        System.out.println(result);
    }
}
