package bitcamp.project3.command.subCategory;

import java.util.Stack;

public interface SubCommand {
    void execute(Stack<String> menuPath);
}
