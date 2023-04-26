public class Main {
    public static void main(String[] args) {
        Person person = new Person("", "", "", "", 1960);
        System.out.println("Test 1 -----------");
        System.out.println(person);
        System.out.println(person.toCSVDataRecord());

        System.out.println("Test 2 -----------");
        person.setFirstName("Aidan");
        person.setLastName("Oates");
        person.setId("000003");
        person.setTitle("Mr.");
        person.setYearOfBirth(2003);

        System.out.println(person);
        System.out.println("Full name: " + person.getFullName());
        System.out.println("Formal name: " + person.getFormalName());
        System.out.println("Age: " + person.getAge());
        System.out.println("Age in year: " + person.getAge(2022));
        System.out.println("CSV record: " + person.toCSVDataRecord());
    }
}