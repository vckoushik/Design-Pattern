import java.util.*;

public class AbstractFactoryProblem {
    // Button Interface
    interface IButton {
        public void render();
    }

    // Mac Button Implementation
    public class MacButton implements IButton {
        public void render() {
            System.out.println("Rendering Mac Button");
        }
    }

    // Windows Button Implementation
    public class WinButton implements IButton {
        public void render() {
            System.out.println("Rendering Windows Button");
        }
    }

    // Text Box Interface
    interface ITextBox {
        public void show();
    }

    // Mac Textbox Implementation
    public class MacTextBox implements ITextBox {
        public void show() {
            System.out.println("Showing Mac Text Box");
        }
    }

    // Windows Textbox Implementation
    public class WinTextBox implements ITextBox {
        public void show() {
            System.out.println("Showing Windows Text Box");
        }
    }

    public class Client {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String osType = sc.next();

            if (osType.equals("Windows")) {
                WinButton winButton = new WinButton();
                winButton.render();

                WinTextBox winTextBox = new WinTextBox();
                winTextBox.show();
            } else if (osType.equals("Mac")) {
                MacButton macButton = new MacButton();
                macButton.render();

                MacTextBox macTextBox = new MacTextBox();
                macTextBox.show();
            } else {
                System.out.println("Invalid OS type.");
            }
        }
    }
}
