package bitcamp.project3.command.subCategory;

import bitcamp.project3.vo.User;

import java.util.Stack;

public interface SubCommand {
    void execute(Stack<String> menuPath, User user);
}
