/*
* Port Scanner
* 10/13/2017
* Coded by Mitchell Wolfe
* ~ Not to be used for malicious purposes
*/

import java.util.Scanner;

public class PortScan{
	public static void main(String[] args){

		int currentPort;
		int alignmentSpaces;

		Scanner scan = new Scanner(System.in);

		System.out.println("    [0] PORT RANGE");
		System.out.println("    [1] SINGLE PORT");
		System.out.println("    [2] COMMON PORTS");
		System.out.print("[0/1/2]: ");
		int menuChoice = scan.nextInt();

		if(menuChoice == 0 || menuChoice == 1 || menuChoice == 2){

			System.out.print("IP: ");
			String ip = scan.next();

			System.out.print("TIMEOUT: ");
			int timeout = scan.nextInt();

			System.out.println();

			SocketScan portscan1 = new SocketScan(ip, timeout);

			//RANGE SCANNER
			if(menuChoice == 0){
				System.out.println("\nPORT MIN: ");
				int portMin = scan.nextInt();

				System.out.println("\nPORT MAX: ");
				int portMax = scan.nextInt();
				System.out.println();


				portscan1.rangeScan(portMin, portMax);
			}


			//SINGLE SCANNER
			else if(menuChoice == 1){
				System.out.println("PORT: ");
				currentPort = scan.nextInt();
				portscan1.singleScan(currentPort);
			}

			//COMMON PORT SCANNER
			else if(menuChoice == 2){
				int[] ports = {21,22,23,25,53,80,110,111,135,139,143,389,443,445,587,1025,1352,1433,1723,3306,3389,5969,5900,6001,8080};
				portscan1.multiScan(ports);
			}
		}

		else{
			System.out.println("[ABORT] wrong input value. please enter 0, 1, or 2");
		}
	}
}
