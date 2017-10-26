public class SocketScan{

  private String ip;
  private int timeout;
  private int currentPort;
  private int alignmentSpaces;

  //constructors
  public SocketScan(String ip, int timeout){
    this.ip = ip;
    this.timeout = timeout;
  }


  //methods
  SocketCheck check1 = new SocketCheck();

  public void rangeScan(int portMin, int portMax){
    for(int i = portMin; i <= portMax; i++){
      currentPort = i;
      alignmentSpaces = 8 - String.valueOf(currentPort).length();
      System.out.print(i);
      if(check1.portCheck(ip, i, timeout)){
        for(int x = 0; x < alignmentSpaces; x++){
          System.out.print(" ");
        }
        System.out.println(":OPEN");
      }
      else{
        for(int x = 0; x < alignmentSpaces; x++){
          System.out.print(" ");
        }
        System.out.println(":REQUEST TIMED OUT");
      }
    }
  }


  public void singleScan(int port){
    alignmentSpaces = 8 - String.valueOf(port).length();
    System.out.print(port);
    if(check1.portCheck(ip, port, timeout)){
      for(int i = 0; i < alignmentSpaces; i++){
        System.out.print(" ");
      }
      System.out.println(":OPEN");
    }
    else{
      for(int i = 0; i < alignmentSpaces; i++){
        System.out.print(" ");
      }
      System.out.println(":REQUEST TIMED OUT");
    }
  }


  public void multiScan(int[] ports){
    for(int i = 0; i < ports.length; i++){
      currentPort = ports[i];
      alignmentSpaces = 8 - String.valueOf(currentPort).length();
      System.out.print(currentPort);
      if(check1.portCheck(ip, currentPort, timeout)){
        for(int x = 0; x < alignmentSpaces; x++){
          System.out.print(" ");
        }
        System.out.println(":OPEN");
      }
      else{
        for(int x = 0; x < alignmentSpaces; x++){
          System.out.print(" ");
        }
        System.out.println(":REQUEST TIMED OUT");
      }
    }

  }


}
