package fourTest;

public class Main {

    public static void main(String[] args) {
        Notebook hp = new Notebook("Hp EliteBook 1g", "Windows 10", 95000);
        Notebook dell = new Notebook();
        dell.setModel("Acer aspire 5742g");
        dell.setOperatingSystem("Linux");
        dell.setPrice(20000);

        System.out.println(hp);
        System.out.println(dell);

        Phones iphone = new Phones("Iphone 8", 20000);
        Phones honor = new Phones();
        honor.setModel("Honor A8");
        honor.setPrice(35000);

        System.out.println(iphone);
        System.out.println(honor);
    }
}
