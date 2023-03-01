public class Author {
    private String firstName;
    private String lastName;
    private Date birthdate;
    private String bio;
    private int noBooks;
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public Date getBirthdate(){
        return birthdate;
    }
    public String getBio(){
        return bio;
    }
    public int getNoBooks(){
        return noBooks;
    }
    public void setFirstName(String fN){
        firstName=fN;
    }
    public void setLastName(String lN){
        lastName=lN;
    }
    public void setBirthdate(Date bD){
        birthdate=bD;
    }
    public void setBio(String bio){
        this.bio=bio;
    }
    public void setNoBooks(int nB){
        noBooks=nB;
    }
    public String toString(){
        return "Author Details:\nName: "+firstName+" "+lastName+"\nBirthdate: "+birthdate+"\nNumber of published books: "+noBooks+"\nBio: "+firstName+" "+lastName+" "+bio;
    }
}
