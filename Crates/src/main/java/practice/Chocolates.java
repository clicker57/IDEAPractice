package practice;

import java.util.HashMap;
import java.util.Map;

/**
 * 面粉，鸡蛋，牛奶，水果，可可粉
 * 戚风（7+4+3+0+0）5，水果（5+4+3+3+0）7，巧克力（6+4+3+0+2）12
 * Created by Philip on 2/8/17.
 */
public class Chocolates {
    private int coco;
    private int milk;
    private int cream;
    private int jam;
    private int rum;

    private HashMap<String, int[]> recipeBook = new HashMap();
    private HashMap<String, Integer> priceBook = new HashMap();

    public Chocolates(int cocoPortion, int milkPortion, int creamPortion, int jamPortion, int rumPortion) {
        setCoco(cocoPortion);
        setMilk(milkPortion);
        setCream(creamPortion);
        setJam(jamPortion);
        setRum(rumPortion);
    }

    public void addRecipe(String brand, int coco, int milk, int cream, int jam, int rum) {
        if (brand == null || brand.equals("")) {
            return;
        }

        int[] parts = new int[] {coco, milk, cream, jam, rum};
        recipeBook.put(brand, parts);
    }

    private void addPrice(String brand, int value) {
        if (brand == null || brand.equals("")) {
            return;
        }

        priceBook.put(brand, value);
    }

    public void setRecipeBook(HashMap<String, int[]> ingredients) {
        for (Map.Entry<String, int[]> entry : ingredients.entrySet()) {
            recipeBook.put(entry.getKey(), entry.getValue());
        }
    }

    public HashMap<String, int[]> getRecipeBook() {
        return recipeBook;
    }

    public static void main(String[] args) {
        HashMap<String, Integer> pack;
        int packValue;

        Chocolates gifts = new Chocolates(15, 9, 9, 3, 3);

        gifts.addRecipe("choc001", 1, 1, 0, 3, 2);
        gifts.addPrice("choc001", 3);

        pack = gifts.produce();
        packValue = gifts.calcValue(pack);
        System.out.println("the best gift pack is :");
        for (Map.Entry<String, Integer> entry : pack.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("Total value is : " + packValue);
    }

    public int calcValue(HashMap<String, Integer> pack) {
        return 0;
    }

    public HashMap<String, Integer> produce() {
        // TODO 背包问题，递归求解

        return null;
    }

    public int getCoco() {
        return coco;
    }

    public void setCoco(int coco) {
        this.coco = coco;
    }

    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public int getCream() {
        return cream;
    }

    public void setCream(int cream) {
        this.cream = cream;
    }

    public int getJam() {
        return jam;
    }

    public void setJam(int jam) {
        this.jam = jam;
    }

    public int getRum() {
        return rum;
    }

    public void setRum(int rum) {
        this.rum = rum;
    }

    @Override
    public String toString() {
        return "Chocolates{" +
                "coco=" + coco +
                ", milk=" + milk +
                ", cream=" + cream +
                ", jam=" + jam +
                ", rum=" + rum +
                ", recipeBook=" + recipeBook +
                ", priceBook=" + priceBook +
                '}';
    }
}
