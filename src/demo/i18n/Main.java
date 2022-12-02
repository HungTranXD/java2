package demo.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

public class Main {
    public static void main(String[] args) {
//        ResourceBundle rb1 = ResourceBundle.getBundle("demo.i18n.messages");
//        System.out.println(rb1.getString("hello"));
//
//        Locale vi = new Locale("vi", "VN");
//        ResourceBundle rb2 = ResourceBundle.getBundle("demo.i18n.messages",vi);
//        System.out.println(rb2.getString("hello"));


        //Cài mặc định khi chạy ứng dụng
        Locale vi = new Locale("vi", "VN");
        Locale.setDefault(vi);
        ResourceBundle rb = ResourceBundle.getBundle("demo.i18n.messages");
        System.out.println(rb.getString("hello"));
    }
}
