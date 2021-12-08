
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.regex.Pattern;
import javax.security.auth.login.AccountException;

public class TpBank {

    //hàm check account
    //hàm check passwork
    //random capcha
    //check capcha
    public String checkAccount(ResourceBundle bundle) {
        Scanner sc = new Scanner(System.in);
        String account;
        while (true) {
            System.out.print(bundle.getString("account"));
            account = sc.nextLine();
            Pattern p = Pattern.compile("^[0-9]{10}$");
//            Pattern p = Pattern.compile("^\\d{10}$");
            if (p.matcher(account).find()) {
                break;
            } else {
                System.out.println(bundle.getString("check.account"));
            }
        }
        return account;
    }

    public String checkPassword(ResourceBundle bundle) {
        Scanner sc = new Scanner(System.in);
        String password;
        while (true) {
            System.out.print(bundle.getString("password"));
            password = sc.nextLine();
            Pattern p1 = Pattern.compile("^[0-9a-zA-Z]{8,31}$");   // check 8 - 31 kí tự
            Pattern p2 = Pattern.compile("^[A-Za-z0-9]*[0-9]+[A-Za-z0-9]*$"); // check password có ít nhất 1 số
            Pattern p3 = Pattern.compile("^[A-Za-z0-9]*[a-zA-Z]+[A-Za-z0-9]*$"); // check password có ít nhất 1 chữ
            if (p1.matcher(password).find() && p2.matcher(password).find() && p3.matcher(password).find()) {
                break;
            } else {
                System.out.println(bundle.getString("wrong.password"));
            }
        }
        return password;
    }

    public String randomCaptcha() {
        //capcha length = 5;
        //cau tao: chu hoa,chữ thg, số
        String root = "0123456789qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
        String captcha = "";
        int lenght = root.length();
        Random r = new Random();
        for (int i = 0; i < 5; i++) {
            int index = r.nextInt(lenght);
            captcha = captcha + root.charAt(index);
        }
        System.out.println("Captcha: " + captcha);
        return captcha;
    }

    public void inputCapcha(String capcha, ResourceBundle bundle) {
        Scanner sc = new Scanner(System.in);
        String input = "";
        while (true) {
            try {
                System.out.print(bundle.getString("enterCaptcha"));
                input = sc.nextLine();
                if (input.equals(capcha)) {
                    System.out.println(bundle.getString("login.success"));
                    break;
                } else {
                    System.out.println(bundle.getString("wrong.captcha"));
                    continue;
                }
            } catch (Exception e) {
            }
        }

    System.exit(0);
    }
}
