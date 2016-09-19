import com.twu.biblioteca.*;
import java.util.Scanner;

public class Application{
    public static void main(String args[]){
        BibliotecaApp library = new BibliotecaApp();
        library.ShowWelcomeMessage();
        library.bookList();
        Scanner scan = new Scanner(System.in);
        String str=scan.nextLine();

    }
}