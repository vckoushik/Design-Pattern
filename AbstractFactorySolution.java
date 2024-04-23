
public class AbstractFactorySolution {
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

    // Factory Interface That creates Button or Text Box
    interface IFactory {
        public IButton createButton();

        public ITextBox createTextBox();
    }

    //Win Factory implementation
    public class MacFactory implements IFactory {
        public IButton createButton() {
            return new MacButton();
        }

        public ITextBox createTextBox() {
            return new MacTextBox();
        }
    }
    // Mac Factory Implementation
    public class WinFactory implements IFactory {
        public IButton createButton() {
            return new WinButton();
        }

        public ITextBox createTextBox() {
            return new WinTextBox();
        }
    }

    // Create which Factory
    public class GUIAbstractFactory {
        public static IFactory createFactory(String osType) {
            if (osType == "Windows") {
                return new WinFactory();
            } else if (osType == "Mac") {
                return new MacFactory();
            }
            return null;
        }
    }

    public class Client {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String osType = sc.next();

            IFactory factory = new GUIAbstractFactory.createFactory(osType);

            IButton button = factory.createButton();
            button.render();

            ITextBox textbox = factory.createTextBox();
            textbox.show();

        }
    }
}
