package javaassignment;

public class Administrator extends User{

    public Administrator() {
    }

public Administrator(String ID, String Name, String Username, String Email, String Address,String Password, Role role) {
        super(ID, Name, Username, Email, Address, Password, role);
    }
}
