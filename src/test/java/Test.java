import ru.popovash.api.PopovashAPI;

public class Test {
    public static void main(String[] args) {
        System.out.println(PopovashAPI.getLanguageManager().getItem("EN").getName());
    }
}
