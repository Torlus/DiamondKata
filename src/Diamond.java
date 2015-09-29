public class Diamond {

    private static StringBuilder spaces(StringBuilder sb, int n) {
        while(n-- > 0)
            sb.append('-');
        return sb;
    }

    public static void build(StringBuilder sb, int c, int level, int dir) {
        if (c == 'A') {
            spaces(sb, level);
            sb.append('A');
            spaces(sb, level);
            sb.append('\n');
        } else {
            if (dir <= 0) {
                build(sb, c - 1, level + 1, -1);
            }
            spaces(sb, level);
            sb.append((char)c);
            spaces(sb, 2*(c - 'A')-1);
            sb.append((char)c);
            spaces(sb, level);
            sb.append('\n');
            if (dir >= 0) {
                build(sb, c - 1, level + 1, 1);
            }
        }
    }

    public static String create(char root) {
        StringBuilder sb = new StringBuilder();
        build(sb, root, 0, 0);
        return sb.toString();
    }

    public static void main(String args[]) {
        System.out.println(Diamond.create('F'));
        long now = System.currentTimeMillis();
        for(int i = 0; i < 1000000; i++) {
            Diamond.create('Z');
        }
        System.out.println(System.currentTimeMillis() - now);
    }
}
