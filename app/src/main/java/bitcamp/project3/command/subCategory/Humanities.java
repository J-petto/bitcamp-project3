package bitcamp.project3.command.subCategory;

import bitcamp.project3.util.Prompt;
import bitcamp.project3.vo.Book;
import bitcamp.project3.vo.BookList;

import java.util.ArrayList;

public class Humanities extends AbstractSubCommand {
    BookList bookList = new BookList();

    ArrayList<Book> books = bookList.getBooks();

    protected String menuTitle;

    public Humanities(String menuTitle) {
        super(menuTitle);
    }

    @Override
    protected String getCheckGo(String menuTitle) {
        return menuTitle;
    }

    @Override
    protected void processMenu(int bookNo) {
        Book book = books.get(bookNo - 1);
        while (true) {
            String command = Prompt.input("%s를 대여하시겠습니까?", book.getBookTitle());
            if (command.equalsIgnoreCase("y")) {
                if (!book.isLoneBook()) {
                    book.setLoneBook(true);
                    System.out.println("대여했습니다.");
                    break;
                }
                bookReservation(book);
                break;
            } else if (command.equalsIgnoreCase("n")) {
                System.out.println("책을 제자리에 돌려놨습니다.");
                break;
            } else {
                System.out.println("y나 n로 대답해주세요.");
            }
        }
    }

    private void bookReservation(Book book) {
        while (true){
            String command = Prompt.input("다른 사람이 대출 중인 책입니다. 예약하시겠습니까?");
            if(command.equalsIgnoreCase("y")){
                System.out.println("예약했습니다");
                break;
            }else if(command.equalsIgnoreCase("n")){
                break;
            }else {
                System.out.println("y나 n로 대답해주세요.");
            }
        }

    }

    @Override
    protected ArrayList<Book> getMenus() {
        return books;
    }

}
