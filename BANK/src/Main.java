
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void menu() {
        System.out.println("------ Login Program -------");
        System.out.println("1.  vietnamese");
        System.out.println("2.  english");
        System.out.println("3.  exit");
        System.out.println("please choice one option");
    }

    public static int getChoice() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String txt = sc.nextLine();
            Pattern p = Pattern.compile("^[123]$");
            if (p.matcher(txt).find()) {
                int choice = Integer.parseInt(txt);
                return choice;
            } else {
                System.out.println("Invalid choice, pls try again: ");
            }
        }
    }
    static String[] accData = {"1234567890", "0987654321", "1234512345"};
    static String[] pwData = {"123456ab", "asdfghjkl1", "pao02112000"};

    public static void Login(Locale currentLocale) {
        TpBank tp = new TpBank();
        ResourceBundle bundle = ResourceBundle.getBundle("ResourcesFiles/Language", currentLocale);
        String acc = tp.checkAccount(bundle);
        String pw = tp.checkPassword(bundle);
        boolean check = false;
        for (int i = 0; i < accData.length; i++) {
            if (pw.equals(pwData[i]) && acc.equals(accData[i])) {
                check = true;
                break;
            }
        }
        if (check==false) {
            System.out.println(bundle.getString("login.fail"));
        }
        if(check==true){
            String captcha = tp.randomCaptcha();
            tp.inputCapcha(captcha, bundle);
        }

    }

    public static void main(String[] args) {
        while (true) {
            menu();
            int choice = getChoice();
            Locale currentLocale;
            switch (choice) {
                case 1:
                    currentLocale = new Locale("vi", "VN");
                    Login(currentLocale);
                    break;
                case 2:
                    currentLocale = new Locale("en", "US");
                    Login(currentLocale);
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }
}
