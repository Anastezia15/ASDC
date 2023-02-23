package lab0;
import java.io.*;
import java.util.Objects;
/*Ресторанное меню
  Наименование блюда
  Стоимость
  Масса
  Category(Diet/Standard)
  Type(Soup,Salad,Garnish,Meat,Snack)
   */

public class Dish {
    private int id;
    private String name;
    private int price;
    private int weight;
    private Type type;
    private Category category;

    ///Standard constructor
    public Dish(int id, String name, int price, int weight, Type type, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.type = type;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public Dish() {
    }

    public int getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                ", type=" + type +
                ", category=" + category +
                '}';
    }

    ///Copiyng constructor
    public Dish(Dish dish) {
        this.id = dish.id;
        this.name = dish.name;
        this.price = dish.price;
        this.weight = dish.weight;
        this.type = dish.type;
        this.category = dish.category;
    }

    public Dish copying(Dish dish) {
        int id = dish.id;
        String name = dish.name;
        int price = dish.price;
        int weight = dish.weight;
        Type type = dish.type;
        Category category = dish.category;
        return new Dish(id, name, price, weight, type, category);

/*
        return new Dish(dish);
*/
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return id == dish.id && price == dish.price && weight == dish.weight && name.equals(dish.name) && type == dish.type && category == dish.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, weight, type, category);
    }

    public static String[] inputStreamDemo(File readingFile) throws IOException {
        String[] array = new String[16];
        try (BufferedReader inputStream = new BufferedReader(new FileReader(readingFile))) {
            for (int i = 0; inputStream.read() != -1; i++) {
                if (i < array.length){
                    array[i] = inputStream.readLine();
                }
            }
        }
        return array;
    }

    public static void outputStreamDemo(File recordingFile,String newRecord) throws IOException {
        OutputStream restaurantInfoOutput = new FileOutputStream(recordingFile,true);
        byte[] temp= newRecord.getBytes();
        restaurantInfoOutput.write(temp);
        restaurantInfoOutput.close();
    }
}
