import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

final class Cat {
    private static final Random r = new Random();
    private static final List<String> names = List.of("Peach", "Ginger", "Toby", "Seth", "Tibbles", "Tabby", "Poppy",
            "Millie", "Daisy", "Jasper", "Misty", "Minka");
    private final String name;
    private final int age;
    private final Breed breed;
    private final Color color;

    private Cat() {
        name = names.get(r.nextInt(names.size()));
        age = r.nextInt(10) + 1;
        breed = Breed.values()[r.nextInt(Breed.values().length)];
        color = Color.values()[r.nextInt(Color.values().length)];
    }

    public static final List<Cat> makeCats(int amount) {
        return Stream.generate(Cat::new)
                .limit(amount)
                .collect(Collectors.toList());
    }

    public final Color getColor() {
        return color;
    }

    public final String getName() {
        return name;
    }

    public final int getAge() {
        return age;
    }

    public final Breed getBreed() {
        return breed;
    }

    enum Color {
        TABBY, SILVER, GRAY, PEACH, GINGER, TORTIE
    }

    enum Breed {
        SPHINX, BRITAIN, SCOTTISH, VULGARIS, ORIENTAL
    }

    public static void removeCatNameLengthIs5(List<Cat> cats) {
        System.out.println("""
                         Удаление по длине имени: \s
                ============================================
                """);
        cats.removeIf(cat -> cat.getName().length() == 5);
    }

    public static void removeCatCertainColor(List<Cat> cats, Color color) {
        System.out.println("""
                         Удаление по цвету \s
                ============================================
                """);
        cats.removeIf(cat -> cat.getColor().equals(color));
    }

    public static void sortByBreed(List<Cat> cats) {
        System.out.println("""
                         Сортировка по породе: \s
                ============================================
                """);
        Collections.sort(cats, (cat1, cat2) -> cat1.getBreed().compareTo(cat2.getBreed()));
    }

    public static void sortByName(List<Cat> cats) {
        System.out.println("""
                         Сортировка по имени: \s
                ============================================
                """);
        Collections.sort(cats, (cat1, cat2) -> cat1.getName().compareTo(cat2.getName()));
    }

    public static void sortByAge(List<Cat> cats) {
        System.out.println("""
                         Сортировка по возрасту: \s
                ============================================
                """);
        Collections.sort(cats, (cat1, cat2) -> cat1.getAge() - cat2.getAge());
    }
}
