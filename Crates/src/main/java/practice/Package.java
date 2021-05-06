package practice;

/**
 * Created by Philip on 18/05/2017.
 */
public class Package {
    private final int maxVolume; // 背包容量
    private int maxRocks = 5; // 物品数量

    // 物品列表（体积、价值）
    private final int[] rockVolumes = new int[] {1, 2, 3, 4, 5, 6, 7};
    private final int[] rockValues = new int[] {1, 2, 3, 4, 5, 6, 7};

    private final int[][] maxPackValues;

    public Package(int maxV, int maxRocks) {
        this.maxVolume = maxV;
        if (maxRocks <= this.maxRocks) {
            this.maxRocks = maxRocks;
        }

        maxPackValues = new int[this.maxVolume][this.maxRocks];

        for (int i = 0; i < this.maxVolume; i++) {
            for (int j = 0; j < this.maxRocks; j++) {
                maxPackValues[i][j] = -1;
            }
        }
    }

    public void getMaxPack(int v) {
        int result = maxPack(v - 1, maxRocks - 1);

        System.out.println("the total volume of package : " + maxVolume);
        System.out.println("the number of rocks : " + maxRocks);
        System.out.println("the max value of packing is : " + result);
    }

    private int maxPack(int volume, int rockNum) {
        int retMaxPack;

        if (maxPackValues[volume][rockNum] != -1) {
            retMaxPack = maxPackValues[volume][rockNum];
        } else if (rockNum == 0) {
            if (volume >= rockVolumes[rockNum]) {
                retMaxPack = rockValues[rockNum];
            } else {
                retMaxPack = 0;
            }
        } else if (volume >= rockVolumes[rockNum]) {
            int load = maxPack(volume - rockVolumes[rockNum], rockNum - 1) + rockValues[rockNum];
            int unload = maxPack(volume, rockNum - 1);
            retMaxPack = Math.max(load, unload);
        } else {
            retMaxPack = maxPack(volume, rockNum - 1);
        }

        return retMaxPack;
    }


    public static void main(String[] args) {
        Package obj = new Package(13, 5);

        obj.getMaxPack(13);
    }

}
