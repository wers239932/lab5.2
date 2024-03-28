package Server;

import Server.Commands.*;
import Server.Terminal.CommandArray;
import Server.Terminal.CommandMaker;

public class CommandSetter {
    public static void setCommands(CommandArray commandArray)
    {
        commandArray.addCommand(new String[]{"exit"}, new Exit());
        commandArray.addCommand(new String[]{"help"}, new Help());
        commandArray.addCommand(new String[]{"add"}, new Add());
        commandArray.addCommand(new String[]{"write"}, new OutputCommand());
        commandArray.addCommand(new String[]{"show"}, new Show());
        commandArray.addCommand(new String[]{"save"}, new Save());
        commandArray.addCommand(new String[]{"info"}, new Info());
        commandArray.addCommand(new String[]{"update"}, new Update());
        commandArray.addCommand(new String[]{"execute_script"}, new Execute_script());
        commandArray.addCommand(new String[]{"remove_by_id"}, new Remove_by_id());
        commandArray.addCommand(new String[]{"clear"}, new Clear());
        commandArray.addCommand(new String[]{"remove_first"}, new Remove_first());
        commandArray.addCommand(new String[]{"remove_greater"}, new Remove_greater());
        commandArray.addCommand(new String[]{"remove_all_by_car_code"}, new Remove_all_by_car_code());
        commandArray.addCommand(new String[]{"sum_of_car_code"}, new Sum_of_car_code());
        commandArray.addCommand(new String[]{"count_greater_than_capital"}, new Count_greater_than_capital());
    }
    public void addCommand(Command command, CommandArray commandArray, String[] names)
    {
        commandArray.addCommand(names, command);
    }
}
