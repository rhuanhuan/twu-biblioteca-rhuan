import com.twu.biblioteca.*;
import java.util.Scanner;

public class Application{
    public static void main(String args[]){
        String path = "/Users/rhuan/IdeaProjects/TWU_Biblioteca-master/book.json";
        BibliotecaApp library = new BibliotecaApp(path);
        library.libraryMenu();
    }
}
