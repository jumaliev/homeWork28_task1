public class Main {

    public static void main(String[] args) {

        var cats = Cat.makeCats(10);
        Printer.print(cats);
        Cat.sortByAge(cats);
        Printer.print(cats);
        Cat.sortByName(cats);
        Printer.print(cats);
        Cat.sortByBreed(cats);
        Printer.print(cats);
        Cat.removeCatNameLengthIs5(cats);
        Cat.removeCatCertainColor(cats, Cat.Color.GINGER);
        Printer.print(cats);


    }

}
