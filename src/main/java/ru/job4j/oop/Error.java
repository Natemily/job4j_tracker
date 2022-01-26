package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public  Error() {
    }

    public  Error(boolean active, int status, String message) {
        this.active = active;
        this.message = message;
        this.status = status;
    }

    public void printInfo() {
        System.out.println("Состояние онлайн: " + active);
        System.out.println("Статус: " + status + " уровень.");
        System.out.println("Сообщение: " + message);
    }

    public static void main(String[] args) {
        Error noError = new Error(true, 2, "Все работает");
        noError.printInfo();
        Error defError = new Error();
        defError.printInfo();
        Error error = new Error(false, 5, "Не работает");
        error.printInfo();
    }
}
