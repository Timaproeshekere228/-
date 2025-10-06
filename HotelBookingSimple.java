import java.util.*;

public class HotelBookingSimple {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Выберите город:");
        System.out.println("1. Алматы\n2. Астана\n3. Шымкент");
        System.out.print("> ");
        int cityChoice = sc.nextInt();
        sc.nextLine();

        String city = switch (cityChoice) {
            case 1 -> "Алматы";
            case 2 -> "Астана";
            case 3 -> "Шымкент";
            default -> {
                System.out.println("Неверный выбор города.");
                yield null;
            }
        };
        if (city == null) return;

        System.out.print("Введите дату (например 2025-10-10): ");
        String date = sc.nextLine();

        String[] types = {"Одноместный", "Двухместный", "Люкс"};
        int[] prices;
        if (city.equals("Алматы")) prices = new int[]{15000, 22000, 45000};
        else if (city.equals("Астана")) prices = new int[]{14000, 21000, 43000};
        else prices = new int[]{12000, 18000, 35000};

        System.out.println("\nТипы номеров:");
        for (int i = 0; i < types.length; i++) {
            System.out.println((i + 1) + ". " + types[i] + " — " + prices[i] + " тнг/ночь");
        }

        System.out.print("Выберите тип номера (1-3): ");
        int typeChoice = sc.nextInt();
        if (typeChoice < 1 || typeChoice > 3) {
            System.out.println("Неверный выбор типа номера.");
            return;
        }

        int available = (int) (Math.random() * 6);

        System.out.println("\nГород: " + city);
        System.out.println("Дата: " + date);
        System.out.println("Тип номера: " + types[typeChoice - 1]);
        System.out.println("Цена: " + prices[typeChoice - 1] + " тнг/ночь");
        if (available > 0)
            System.out.println("Свободно: " + available + " номеров");
        else
            System.out.println("К сожалению, свободных номеров нет.");

        sc.close();
    }
}