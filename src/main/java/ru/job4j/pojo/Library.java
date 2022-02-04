package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {
        Book partOne = new Book("Nine Princes in Amber", 317);
        Book partTwo = new Book("The Guns of Avalon", 364);
        Book partThree = new Book("Sign of the Unicorn", 402);
        Book partFour = new Book("The Hand of Oberon", 447);
        Book cleanCode = new Book("Clean code", 500);
        Book[] book = new Book[5];
        book[0] = partOne;
        book[1] = partTwo;
        book[2] = partThree;
        book[3] = partFour;
        book[4] = cleanCode;

        for (int i = 0; i < book.length; i++) {
            System.out.println("В книге " + book[i].getName() + " " + book[i].getPageCount() + " страниц.");
        }
        System.out.println();
        System.out.println("Вывод книг с заменой 0 на 3 и наоборот");
        book[0] = partFour;
        book[3] = partOne;
        for (int i = 0; i < book.length; i++) {
            System.out.println("В книге " + book[i].getName() + " " + book[i].getPageCount() + " страниц.");
        }
        System.out.println();
        System.out.println("Вывод книг с названием Clean code");
        for (int i = 0; i < book.length; i++) {
            if ("Clean code".equals(book[i].getName())) {
                System.out.println("В книге " + book[i].getName() + " " + book[i].getPageCount() + " страниц.");
            }
        }
    }
}
