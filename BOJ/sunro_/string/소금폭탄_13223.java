package Array.gold.string;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class 소금폭탄_13223 {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        String curTime = sc.nextLine();
        String targetTime = sc.nextLine();

        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        long curMillis = dateFormat.parse(curTime).getTime();
        long targetMillis = dateFormat.parse(targetTime).getTime();

        if(curMillis==targetMillis){
            System.out.println("24:00:00");
            return;
        }

        if(targetMillis<curMillis){
            targetMillis+=24*60*60*1000;
        }

        long diff =  targetMillis - curMillis;
        long hour = diff / 3600000;
        long min = diff % 3600000 / 60000;
        long sec = diff % 60000 / 1000;
        System.out.printf("%02d:%02d:%02d", hour, min, sec);
    }
}
