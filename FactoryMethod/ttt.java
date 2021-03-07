package FactoryMethod;

import javax.swing.*;
import java.awt.*;

interface Button {
    void render(Object closeDialog);
    void onClick(Object closeDialog);
}

class WindowsButton implements Button {
        public void render(Object closeDialog){

            JLabel label = new JLabel("Ernest Murzashev");
            label.setOpaque(true);
            label.setBackground(new Color(200, 215, 115));
            label.setFont(new Font("Dialog", Font.BOLD, 42));
            label.setHorizontalAlignment(SwingConstants.CENTER);
            onClick(closeDialog);
        }
        public void onClick(Object closeDialog) {
                    System.exit(0);
        }
}


class HTMLButton implements Button {
    public void render(Object closeDialog){
        System.out.println("<button>Test Button</button>");
        onClick(closeDialog);
    }
    public void onClick(Object closeDialog) {
        System.out.println("'Ernest Murzashev'");
    }
}

abstract class Dialog {
    void render(Object closeDialog) {
                Button okButton = createButton();
                okButton.onClick(closeDialog);
                okButton.render(closeDialog);
    }

    abstract Button createButton();
}


    class WindowsDialog extends Dialog {
        Button createButton() {
            return new WindowsButton();
        }
    }

    class WebDialog extends Dialog {
        Button createButton() {
            return new HTMLButton();
        }
    }


    class Application {
        Dialog dialog;


        void initialize(Object config) throws Exception {

            throw new Exception("Error! Unknown operating system.");
        }

        void main(Object closeDialog) {
            this.initialize();
            dialog.render(closeDialog);
        }

        private void initialize() {
        }
    }
