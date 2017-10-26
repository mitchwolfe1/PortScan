import java.net.*;
public class SocketCheck{
  public SocketCheck(){
  };

  public boolean portCheck(String ip, int port, int timeout) {
    try {
      Socket socket = new Socket();
      socket.connect(new InetSocketAddress(ip, port), timeout);
      socket.close();
      return true;
    }
    catch (Exception ex){
      //System.out.println(ex);
      return false;
    }
  }
}
