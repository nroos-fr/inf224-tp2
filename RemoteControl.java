/**
 * @file RemoteControl.java
 * @author Nathan Roos
 * @brief Main class of the Java Swing part of the system. 
 */

public class RemoteControl {
    Client client; /* client to connect to the set top box server */

    /*
     * @brief Connect to the server and launch the GUI
     */
    public static void main(String[] args) {
        new RemoteControl();
    }


    /**
     * @brief Constructor
     * @details Tries to connect to the set top box server and launch the GUI.
     * If the connection fails, close the app.
     */
    public RemoteControl() {
        String host = Client.DEFAULT_HOST;
        int port = Client.DEFAULT_PORT;
        try {
            client = new Client(host, port);
        } catch (Exception e) {
            System.err.println("Client: Couldn't connect to "+host+":"+port+ ", you should check that the server is online");
            System.exit(1);
        }

        new MainFrame(this::searchCallback, this::playCallback, this::refreshMediaListCallback);
    }

    
    /**
     * @brief Fetch the attributes of a multimedia entity
     * @param nameToSearch the name of the entity to get the attributes from
     * @return the entity's attributes
     */
    public String searchCallback(String nameToSearch) {
        String command = "show(name=" + nameToSearch+")";
        String response = client.send(command);
        return response.replace("---", "\n");
    }

    /**
     * @brief Command to the server to play a multimedia entity
     * @param nameToPlay the name of the entity to play
     * @return an information message about the state of the playing
     */
    public String playCallback(String nameToPlay) {
        String command = "play(name=" + nameToPlay+")";
        String response = client.send(command);
        return response.replace("---", "\n");
    }

    /**
     * @brief Fetch the list of available multimedia entities
     * @return the list of available multimedia entities
     */
    public String refreshMediaListCallback() {
        String command = "list()";
        String response = client.send(command);
        return response.replace("---", "\n");
    }

}
