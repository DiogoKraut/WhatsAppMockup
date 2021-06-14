import java.util.ArrayList;

class Programa {
    public static void main(String[] args) {
        User p1 = new User("p1");
        User p2 = new User("p2");
        User p3 = new User("p3");
        User p4 = new User("p4");
        Group g1 = p1.createGroup("g1");
        Group g2 = p1.createGroup("g2");
        Group g3 = p3.createGroup("g3");


        p1.addUser(g1, p2);
        p1.addUser(g1, p3);
        p1.addUser(g1, p4);

        p1.addUser(g2, p2);
        p1.addUser(g3, p3);

        p3.addUser(g3, p4);

        p2.sendText(g1, "p2 to g1");
        p1.sendText(g1, "p1 to g1");
        p2.sendText(g2, "p2 to g2");
        p3.sendText(g3, "p3 to g3");
        p3.sendText(g2, "p3 to g2");
        p3.sendText(g3, "p3 to g3");
    }
}
