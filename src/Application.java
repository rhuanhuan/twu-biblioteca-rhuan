import com.twu.biblioteca.*;
import java.util.Scanner;

public class Application{
    public static void main(String args[]){
        String path1 = "/Users/rhuan/IdeaProjects/TWU_Biblioteca-master/book.json";
        String path2 = "/Users/rhuan/IdeaProjects/TWU_Biblioteca-master/movie.json";
        BibliotecaApp library = new BibliotecaApp(path1,path2);
        library.mainMenu();
    }
}
