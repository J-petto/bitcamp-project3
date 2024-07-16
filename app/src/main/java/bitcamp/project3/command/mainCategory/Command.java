package bitcamp.project3.command.mainCategory;

import bitcamp.project3.vo.User;

import java.util.Stack;

public interface Command {
    void execute(Stack<String> menuPath, User user);
}
