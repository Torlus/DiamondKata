package fr.craftinglabs.kata;

public class DiamondAV {

    private static final String SEPARATOR = "-";
    private static final String END_OF_LINE = "\n";

    public static String create(Character c) {
        int size = sizeOfDIamond(c);

        if(size == 1) return "A";

        return buildDiamond(size);
    }

    private static String buildDiamond(int size) {
        StringBuilder builder = new StringBuilder();
        builder.append(diamondTip(size)).append(END_OF_LINE);

        for (int floor = size - 2; floor >= -(size - 2) ; floor --) {
            builder.append(diamondWall(size, floor)).append(END_OF_LINE);
        }

        builder.append(diamondTip(size));

        return builder.toString();
    }

    private static int sizeOfDIamond(Character c) {
        return c - 'A' + 1;
    }

    private static String diamondWall(int size, int floor) {
        int width = size * 2 - 1;
        int absoluteFloor = Math.abs(floor);

        Character wall = wallForTheFloor(size, absoluteFloor);
        StringBuilder builder = new StringBuilder();

        return builder
                .append(manySpaces(absoluteFloor))
                .append(wall)
                .append(manySpaces(width - 2*(absoluteFloor + 1)))
                .append(wall)
                .append(manySpaces(absoluteFloor))
                .toString();
    }

    private static char wallForTheFloor(int size, int absoluteFloor) {
        return Character.toChars('A' + size - absoluteFloor -1)[0];
    }

    private static String diamondTip(int size) {
        return manySpaces(size -1) + "A" + manySpaces(size - 1);
    }

    private static String manySpaces(int nbSpaces) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < nbSpaces; i++) {
            builder.append(SEPARATOR);
        }
        return builder.toString();
    }

    public static void main(String args[]) {
        long now = System.currentTimeMillis();
        System.out.println(DiamondAV.create('F'));
        for(int i = 0; i < 1000000; i++)
            DiamondAV.create('Z');
        System.out.println(System.currentTimeMillis() - now);
    }
}
