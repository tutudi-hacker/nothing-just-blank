package lab04;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
public class Bonus {
    static class Member implements Serializable {
        private static final long serialVersionUID = 1L;
        String name;
        String id;
        String gender;
        Member(String name, String id, String gender) {
            this.name = name;
            this.id = id;
            this.gender = gender;
        }
        public String toString() {
            return "Name: " + name + ", ID: " + id + ", Gender: " + gender;
        }
    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList<Member> team = new ArrayList<>();
        team.add(new Member("Jet li", "123", "male"));
        team.add(new Member("Donnie yen", "234", "male"));
        team.add(new Member("Alice chan", "456", "Female"));
        try (FileOutputStream fileOut = new FileOutputStream("person.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(team);
            System.out.println("Objects serialized successfully to person.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<Member> deserializedTeam = null;
        try (FileInputStream fileIn = new FileInputStream("person.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            deserializedTeam = (ArrayList<Member>) in.readObject();
            System.out.println("--- Deserialized Team Members Info ---");
            for (Member m : deserializedTeam) {
                System.out.println(m);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
