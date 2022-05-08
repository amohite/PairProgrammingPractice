import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.*;
import java.util.stream.Collectors.*;
import java.io.*;

import static java.util.stream.Collectors.toList;

class plusminus {
    public static void result(int[] arry) {
        double negative = 0;
        double positive = 0;
        double Zero = 0;
        double Total = 0;
        for (Integer i : arry) {
            if (i < 0) {
                negative += 1;
            } else if (i > 0) {
                positive += 1;
            } else if (i == 0) {
                Zero += 1;
            }
        }
        double ration = 0;
        DecimalFormat df = new DecimalFormat("#.######");

        Total = arry.length;

//        System.out.println("Positive Percentage  " +positive / Total);
//        System.out.println("Negative Percentage  " + negative / Total);
//        System.out.println("Zero Percentage  " + Zero / Total);
        System.out.println(positive / Total);
        System.out.println(negative / Total);
        System.out.println(Zero / Total);
    }
}

class min_max_sun {
    public static void result(long[] Arr) {
        long MaxSum = 0;
        long MinSum = 0;
        Arrays.sort(Arr);

        for (int i = 0; i < Arr.length; i++) {
            if (i > 0) {
                MaxSum += Arr[i];
            }
            if (i < Arr.length - 1) {
                MinSum += Arr[i];
            }
        }

        System.out.println(MinSum + " " + MaxSum);
    }
}

class Convertto24clock {
    public static void result(String s) {
        String[] T = s.split(":");

        String FindAMPM = T[2].substring(2, 4);

        System.out.println(s);
        if (FindAMPM.equals("PM")) {
            int NewTime = Integer.parseInt(T[0]) + 12;
            if (NewTime == 24) {
                T[0] = "12";
            } else {
                T[0] = String.valueOf(NewTime);
            }

        } else if (FindAMPM.equals("AM")) {
            if (T[0].equals("12")) {
                T[0] = "00";
            }
        }
        System.out.println(T[0] + ":" + T[1] + ":" + T[2].substring(0, 2));

    }

}

class FindLonely {
    public static int result(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                i += 1;
            } else {
                return arr[i];
            }

        }
        return arr[arr.length - 1];
    }
}

class DiagonalDifference {

    public static void result(int length, int arr[][]) {
        double diff = 0;
        for (int i = 0; i < length; i++) {
            diff += arr[i][i] - arr[i][length - 1 - i];
        }
        System.out.println(Math.abs(diff));
    }

    public static void WithGetData() throws IOException {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);

        int length = 0;
        System.out.println("Enter size of Metrics - ");
        length = Integer.parseInt(br.readLine());
        System.out.println("This is Length - " + length);
        double Diff = 0;
        for (int i = 0; i < length; i++) {
            System.out.println("Enter row - " + i + " of Metrics");
            String[] row = br.readLine().split(",");
            Diff += Double.parseDouble(row[i]) - Double.parseDouble(row[length - 1 - i]);
            System.out.println(" Diff - " + Diff);
        }
        System.out.println("This is Length - " + length);
        System.out.println("Net Diff - " + Math.abs(Diff));
        br.close();

    }

}

class CountingSorting {
    public static void result(List<Integer> arr) {
        int out[] = new int[arr.get(0) + 1];
        //List<Integer> output = Arrays.asList(new Integer[arr.get(0)]);
        for (int i = 1; i < arr.size(); i++) {
            out[arr.get(i)] += 1;
        }

        System.out.println(Arrays.toString(out));

    }
}

class caesarCipher {


    private static char ConvertChar(char C, int Places) {
        int charint = (int) C;
        if (Character.isAlphabetic(C)) {
            System.out.println(C + " - " + (int) C);
            charint = charint + (Places % 26);
            if (Character.isUpperCase(C)){
                if (charint > (int) 'Z') {
                    charint = (int) 'A' + charint - (int) 'Z' - 1;
                }

            }else {
                if (charint > (int) 'z') {
                    charint = (int) 'a' + charint - (int) 'z' - 1;
                }
            }
            System.out.println(charint + " - " + (char) charint);
            return (char) charint;
        } else {
            return C;
        }

    }

    public static void result(String s, int k) {
        char[] c = s.toCharArray();
        String output = "";

        for (int i = 0; i < c.length; i++) {
            output += ConvertChar(c[i], k);
        }
        System.out.println(s);
        System.out.println(output);

    }

}

public class Main {
    public static void main(String[] args) {


        System.out.println("Hello world!");

        long arr[] = Stream.of("2,13,4,1,5".replaceAll("\\s+$", "").split(","))
                .mapToLong(Integer::parseInt)
                .toArray();

        plusminus.result(new int[]{-4, 3, -9, 0, 4, 1});
        min_max_sun.result(arr);

        Convertto24clock.result("07:05:45PM");
        Convertto24clock.result("12:40:22AM");

        System.out.println(FindLonely.result(new int[]{1, 2, 3, 4, 3, 2, 1}));

        DiagonalDifference.result(3, new int[][]{{11, 2, 4}, {4, 5, 6}, {10, 8, -12}});

        try {
            //  DiagonalDifference.WithGetData();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        List<Integer> counting = Stream.of("100 63 25 73 1 98 73 56 84 86 57 16 83 8 25 81 56 9 53 98 67 99 12 83 89 80 91 39 86 76 85 74 39 25 90 59 10 94 32 44 3 89 30 27 79 46 96 27 32 18 21 92 69 81 40 40 34 68 78 24 87 42 69 23 41 78 22 6 90 99 89 50 30 20 1 43 3 70 95 33 46 44 9 69 48 33 60 65 16 82 67 61 32 21 79 75 75 13 87 70 33".replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
        CountingSorting.result(counting);

        caesarCipher.result("azAZefgh", 1);

        caesarCipher.result("middle-Outz", 2);



    }
}
