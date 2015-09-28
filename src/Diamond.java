public class Diamond {

    private String spaces(int n) {
        String res = "";
        while(n-- > 0)
            res += "-";
        return res;
    }

    public String build(int c, int level, int dir) {
        String me = spaces(level) + (char)c + spaces(2*(c - 'A')-1) + (char)c + spaces(level) + "\n";
        if (c == 'A') {
            return spaces(level) + 'A' + spaces(level) + "\n";
        } else {
            if (dir == 0) {
                return build(c - 1, level + 1, -1) + me + build(c - 1, level + 1, 1);
            } else if (dir > 0) {
                return me + build(c - 1, level + 1, dir);
            } else {
                return build(c - 1, level + 1, dir) + me;
            }
        }
    }

    public void draw(char root) {
        System.out.print(build(root, 0, 0));
    }

    public static void main(String args[]) {
        Diamond d = new Diamond();
        d.draw('J');
    }
}
