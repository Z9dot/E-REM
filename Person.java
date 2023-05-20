public class Person {
    private String name;
    private String gender;
    private String cnic;

    public Person(String name, String gender, String cnic){
        this.name= name;
        this.gender= gender;
        this.cnic= cnic;

    }

    public String toString(){
        return name =" "+ gender +" "+cnic;
    }
}
