public class ConnectionManager {

    private static ConnectionManager connectionManager;

    private ConnectionManager(){

    }

    public static ConnectionManager getSingletonConnectionManager(){
        if(connectionManager==null){
            connectionManager = new ConnectionManager();
        }
        return connectionManager;
    }
}
