package bitcamp.project3.vo;

import java.util.ArrayList;

public class BookList {
    private final ArrayList<Book> books = new ArrayList<>();

    public BookList(){
        testBookList();
    }

    private void testBookList(){
        for(int i = 0; i < 5; i++){
            Book book = new Book();
            book.setBookTitle(String.format("책이름 %d", i));
            book.setBookContents(new String[]{String.format("책%d 내용 1", i), String.format("책%d 내용 2", i), String.format("책%d 내용 3", i)});
            book.setCategory("한국서적 과학");
            books.add(book);
        }
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
}
