public class Book {
    private String bookTitle;
    private Author authorDetails;
    private Date publishedDate;
    private int rating;
    public String getBookTitle(){
        return bookTitle;
    }
    public Author getAuthorDetails(){
        return  authorDetails;
    }
    public Date getPublishedDate(){
        return publishedDate;
    }
    public int getRating(){
        return rating;
    }
    public void setBookTitle(String bT){
        bookTitle=bT;
    }
    public void setAuthorDetails(Author aD){
        authorDetails=aD;
    }
    public void setPublishedDate(Date pD){
        publishedDate=pD;
    }
    public void setRating(int r){
        rating=r;
    }
    public String toString(){
        return "Book Details:\nBook Title: "+bookTitle+"\n"+authorDetails+"\nPublished Date: "+publishedDate+"\n"+"Rating(over 5): "+rating;
    }
    public void updatePublishedDate(Date updD){
        publishedDate=updD;
    }
    public void updateAuthor(Author updA){
        authorDetails=updA;
    }
    }


