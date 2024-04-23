public class BuilderSoultion {
    //Actual Desktop Class
    class Desktop {
        private String monitor;
        private String keyboard;
        private String mouse;
        private String speaker;
        private String ram;
        private String processor;
        private String motherBoard;

        public void setMonitor(String monitor) {
            this.monitor = monitor;
        }

        public void setKeyboard(String keyboard) {
            this.keyboard = keyboard;
        }

        public void setMotherBoard(String motherBoard) {
            this.motherBoard = motherBoard;
        }

        public void setMouse(String mouse) {
            this.mouse = mouse;
        }

        public void setProcessor(String processor) {
            this.processor = processor;
        }

        public void setRam(String ram) {
            this.ram = ram;
        }

        public void setSpeaker(String speaker) {
            this.speaker = speaker;
        }

        public String showSpecs() {
            return "Desktop{" +
                    "monitor='" + monitor + '\'' +
                    ", keyboard='" + keyboard + '\'' +
                    ", mouse='" + mouse + '\'' +
                    ", speaker='" + speaker + '\'' +
                    ", ram='" + ram + '\'' +
                    ", processor='" + processor + '\'' +
                    ", motherBoard='" + motherBoard + '\'' +
                    '}';
        }
    }
    // Interface that concrete builders like HP and Dell to follow
    interface Builder {
        public void buildMonitor();

        public void buildKeyboard();

        public void buildMouse();

        public void buildSpeaker();

        public void buildRam();

        public void buildProcessor();

        public void buildMotherBoard();

        public Desktop getDesktop();
    }
    // Builds or sets parts for Dell Desktop
    public class DellDesktopBuilder implements Builder {
        private Desktop desktop;

        public void buildMonitor() {
            desktop.setMonitor("Dell Monito");
        }

        public void buildKeyboard() {
            desktop.setKeyboard("Dell Keyboard");
        }

        public void buildMouse() {
            desktop.setMouse("Dell Mouse");
        }

        public void buildSpeaker() {
            desktop.setSpeaker("Dell Speaker");
        }

        public void buildRam() {
            desktop.setRam("Dell Ram");
        }

        public void buildProcessor() {
            desktop.setProcessor("Dell Processor");
        }

        public void buildMotherBoard() {
            desktop.setMotherBoard("Dell MotherBoard");
        }

        public Desktop getDesktop() {
            return this.desktop;
        }
    }

    public class HPDesktopBuilder implements Builder {
        private Desktop desktop;

        public void buildMonitor() {
            desktop.setMonitor("HP Monito");
        }

        public void buildKeyboard() {
            desktop.setKeyboard("HP Keyboard");
        }

        public void buildMouse() {
            desktop.setMouse("HP Mouse");
        }

        public void buildSpeaker() {
            desktop.setSpeaker("HP Speaker");
        }

        public void buildRam() {
            desktop.setRam("HP Ram");
        }

        public void buildProcessor() {
            desktop.setProcessor("HP Processor");
        }

        public void buildMotherBoard() {
            desktop.setMotherBoard("HP MotherBoard");
        }

        public Desktop getDesktop() {
            return this.desktop;
        }
    }

    //Director builds the Desktop based on parameters and process
    class Director {
        private Builder builder;

        Director(Builder builder) {
            this.builder = builder;
        }

        Desktop getDesktop() {
            return builder.getDesktop();
        }

        Desktop buildDesktop() {
            // You can pass and set params
            // Build only few parts if requird
            builder.buildKeyboard();
            builder.buildMonitor();
            builder.buildMotherBoard();
            builder.buildMouse();
            builder.buildProcessor();
            builder.buildRam();
            builder.buildSpeaker();
            return builder.getDesktop();
        }
    }

    //We are building Hp and Dell Desktops
    // Both have same set of parts but vary in company

    class Main {
        public static void main(String args[]) {
            HPDesktopBuilder hpDesktopBuilder = new HPDesktopBuilder();
            DellDesktopBuilder dellDesktopBuilder = new DellDesktopBuilder();

            Director director1 = new Director(hpDesktopBuilder);
            Director director2 = new Director(dellDesktopBuilder);

            Desktop hpDesktop = director1.buildDesktop();
            Desktop dellDesktop = director2.buildDesktop();

            System.out.println(hpDesktop.showSpecs());
            System.out.println(dellDesktop.showSpecs());

        }
    }
}