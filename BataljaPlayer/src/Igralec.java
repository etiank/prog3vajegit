import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;


public class Igralec {
	public static void main(String[] args) throws Exception {
		FileWriter fstream = new FileWriter("Igralec.log");
		BufferedWriter out = new BufferedWriter(fstream);//na ta objekt pisemo debuganje
		try {
			/*
				**************
				Initialization
				**************
			*/
			// U <int> <int> <String>
			Scanner bralec = new Scanner(System.in);
			String line = "";
			String attack = "";
			int x,y;
			String color ="";

			//preberemo universe vrstico
			line = bralec.nextLine();
			String [] tokens = line.split(" ");
			x= Integer.parseInt(tokens[1]);
			y= Integer.parseInt(tokens[2]);
			color=tokens[3];//tokens[0] je U


			out.write(line + "\n");
			out.flush();

			/*
				**************
				Main game loop
				**************
			*/
			int c=0;
			while (true) {
				/*
					******************************
					clear state from previous turn
					******************************
				*/

				attack="";
				//ustvarimo novi objekt
				//oz brisi starega naredi novega
				NapadalniPanel np = new NapadalniPanel(x,y,color);
				//np.dodajPlanet(tokens);
				/*
					********************************
					read the input from the game and
					parse it (state of the game)
					********************************
				*/
				// P >int> <int> <int> <float> <int> <string>


				line=bralec.nextLine();
				while (!line.equals(("S"))){
					//procesiraj vrstico
					out.write(line+"\n");
					out.flush();
					tokens=line.split(" ");

					if (tokens[0].equals("P")){
						np.dodajPlanet(tokens);
					}
					line= bralec.nextLine();
				}

				/*
					*********************************
					LOGIC: figure out what to do with
					your turn
					*********************************
				*/

				// if enemy planets exist

				/*
					*********************************
					Print the attack command and thus
					end the turn
					*********************************
				*/
				attack= np.napad();
				attack += "E"; // end of turn command
				System.out.println(attack); // send commands to the game
			}
		} catch (Exception e) {
			e.printStackTrace();
			out.write("ERROR: ");
			out.write(e.getMessage());
			out.flush();
		}
		out.close();
	}
}
