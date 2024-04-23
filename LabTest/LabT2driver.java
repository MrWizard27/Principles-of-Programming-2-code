public class LabT2driver{
    public static void main(String[] args){
        //instantiating student objects
        Student st1 = new Student();

        Student st2 = new Student("Biff", 18, "555-124-1819", 3.5);

        //setting instance variables for st1
        st1.setName("Nellie");

        st1.setAge(19);

        st1.setPhone("123-987-5432");

        st1.setGpa(3.7);
        
        //getting instance variable values for both students
        String name1 = st1.getName();
        int age1 = st1.getAge();
        String phone1 = st1.getPhone();
        double gpa1 = st1.getGpa();

        String name2 = st2.getName();
        int age2 = st2.getAge();
        String phone2 = st2.getPhone();
        double gpa2 = st2.getGpa();

        //printing out values for both students
        System.out.println(name1);
        System.out.println(age1);
        System.out.println(phone1);
        System.out.println(gpa1);
        System.out.println();
        
        System.out.println(name2);
        System.out.println(age2);
        System.out.println(phone2);
        System.out.println(gpa2);
        System.out.println();

        //testing setters
        st1.setName(name2);
        st1.setAge(age2);
        st1.setPhone(phone2);
        st1.setGpa(gpa2);

        //testing toString method
        System.out.println(st1);

        //testing equals method
        System.out.println(st1.equals(st2));
        System.out.println();
    }
}