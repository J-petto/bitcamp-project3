package bitcamp.project3.vo;



import java.time.LocalDate;

public class TakeOutRecord {
  private Book takesOutBook;
  private LocalDate takesOutDate;

  public TakeOutRecord(Book book) {
    this.takesOutBook = book;
    this.takesOutDate = LocalDate.now();
  }

  public Book getTakesOutBook() {
    return takesOutBook;
  }

  public LocalDate getTakesOutDate() {
    return takesOutDate;
  }
}
