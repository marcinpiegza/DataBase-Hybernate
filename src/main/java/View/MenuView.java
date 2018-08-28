package View;

public class MenuView {

    public static void showMenu(){
        System.out.println("Witaj. Wybierz opcje" +"\n"+
                "1 - Filtruj kraje po zakresie ludności " +"\n"+
                "2 - Filtruj kraje po języku" +"\n"+
                "3 - Filtruj kraje po miastach" +"\n"+
                "4 - Filtruj miasta województwie" +"\n"+
                "5 - Filtruj miasta po kraju"+"\n" +
                "6 - Filtruj miasta po oficjalnym języku" +"\n"+
                "7 - Pokaż wszystkie kraje" +"\n"+
                "8 - Pokaż kraj o największej powierzchni" +"\n"+
                "9 - Pokaż średnią długość zycia w Eurupie" +"\n"+
                "10 - Znajdź kraje gdzie językiem oficjalnym jest angielski ");
    }

    public static void showMenuWrontAnswer(){
        System.out.println("Podałeś złą opcje");
    }
}
