package org.example;

import org.example.controller.Controller;

public class Main {
    public static void main(String[] args) {

        Controller controller = new Controller();
        if (args.length > 0) {
            controller.runWithFile(args[0]);
        } else {
            controller.runInteractive();
        }
    }
}