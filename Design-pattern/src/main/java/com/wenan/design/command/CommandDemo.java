package com.wenan.design.command;

// 抽象命令
interface Command {
    void execute();
}

/**
 * 描述：    CommandDemo
 */
public class CommandDemo {
    public static void main(String[] args) {
        // 1 建好一个遥控器命令
        Command realCommand = new RealCommand();
        // 2 新建执行者 小明
        Invoker xiaoming = new Invoker(realCommand,"小明");
        // 3 小明点击打开电视
        xiaoming.open();
    }
}

// 接收者
class Receiver {
    public void openTV() {
        System.out.println("电视机收到开机命令,电视开机了");
    }
}

// 具体命令，只负责传递一个执行命令
class RealCommand implements Command {
    private Receiver receiver;

    RealCommand() {
        this.receiver = new Receiver();
    }

    @Override
    public void execute() {
        System.out.println("遥控器发送开机命令");
        receiver.openTV();
    }
}

// 调用者
class Invoker {
    private String name;

    private Command command;

    Invoker(Command command,String name) {
        this.command = command;
        this.name = name;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void open() {
        System.out.println(name+"点击打开电视按钮");
        command.execute();
    }
}