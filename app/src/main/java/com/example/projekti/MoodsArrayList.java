import java.util.ArrayList;

public class MoodsArrayList {
    private static final MoodsArrayList  ourInstance = new MoodsArrayList ();
    private ArrayList<Mood> moods;

    public static MoodsArrayList getInstance() {
        return ourInstance;
    }

    private moods () {
        moods = new ArrayList<Moods>();
        moods.add(new mood("Loistava", 5, 5, "Oksytosiinia? Leiki koiran/vauvan kanssa, kehu toista, halaa läheistä, mene hierontaan"));
        moods.add(new mood("Loistava", 5, 5, "Dopamiinia? Hemmettole itseäsi, syö hyvää ruokaa, tee jokin tehtävä loppuun"));
        moods.add(new mood("Hyvä", 4,4, "Endorfiinia? Katso vitsejä, ole luova, syö tummaa suklaata, urheile, venyttele, katso komediaa"));
        moods.add(new mood("Hyvä", 4,4, "Iloinen? Ole luova, kylmä suihku tai vesi, luontokävely"));
        moods.add(new mood("Kohtalainen", 3, 3, "Jännittääkö? Tee mukava rentouttava asia ja altistamisharjoitus"));
        moods.add(new mood("Kohtalainen", 3, 3, "Stressiä? Lenkki, Tanssi, Venyttely"));
        moods.add(new mood("Huono", 2, 2, "Yksinäisyys? Turva ja kuuntelu, luotettava kaveri tai miellyttävä tv-sarja"));
        moods.add(new mood("Huono", 2, 2, "Ahdistuneisuus? Hengitysharjoitus?"));
        moods.add(new mood("Surkea", 1, 1, "Uupumus? Päiväunet tai huilihetki?"));
        moods.add(new mood("Surkea", 1, 1, "Surullinen? Puhu jollekin"));
    }

    public ArrayList<Mood> getMoods() {
        return moods;
    }

    public Moods moods (int i){
        return moods.get(i);
    }
}
