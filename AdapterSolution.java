

public class AdapterSolution {
    // Adaptee Class
    // This is the source used by Adapater to convert
    public class XMLData{
        String xmlData;
        XMLData(String xmlData){
            this.xmlData = xmlData;
        }
        String getXMLData(){
            return xmlData;
        }
    }

    // Target which will be inherited by Adapter to make sure it fits XML
    public class DataAnalyticsTool{
        String jsonData;
        DataAnalyticsTool(String jsonData){
            this.jsonData = jsonData;
        }

        void analyzeData(){
            System.out.println("Analayzing JSON Data");
        }
    }

    public class Adapter extends DataAnalyticsTool{
        private XMLData xmlData;
        Adapter(XMLData xmlData){
            this.xmlData = xmlData;
        }

        @Override
        void analyzeData(){
            System.out.println("CONVERTING XML data to JSON");
            super.analyzeData();
        }
    }

    // Client takes a tool and processes it 
    // No changes should be made to client
    public class Client{
        void processData(DataAnalyticsTool tool){
            tool.analyzeData();
        }
    }

    public static void main(String args[]){
        XMLData xmlData = new XMLData("Sample XML Data");
        // Tool expects JSON
        // We use adapter object 
        DataAnalyticsTool tool = new Adapter();
        Client client  = new Client();
        client.processData(tool);
    }
}
