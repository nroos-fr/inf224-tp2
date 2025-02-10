public class RemoteControl {
    Client client;
    public static void main(String[] args) {
        new RemoteControl();
    }

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

    

    public String searchCallback(String nameToSearch) {
        String command = "show(name=" + nameToSearch+")";
        String response = client.send(command);
        return response.replace("---", "\n");
    }

    public String playCallback(String nameToPlay) {
        String command = "play(name=" + nameToPlay+")";
        String response = client.send(command);
        return response.replace("---", "\n");
    }

    public String refreshMediaListCallback() {
        String command = "list()";
        String response = client.send(command);
        return response.replace("---", "\n");
    }

}
