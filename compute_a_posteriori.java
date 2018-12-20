


	import java.io.*;

	class compute_a_posteriori{
		public double prior;
		public double cherry;
		public double lime;
		
		compute_a_posteriori(double p_1, double c_1, double l_1){
			prior = p_1;
			cherry = c_1;
			lime = l_1;
		}  

		public static void main(String args[])throws Exception
		{
			if(args.length == 1){
				compute_a_posteriori h1 = new compute_a_posteriori(0.1, 1.0, 0.0);
				compute_a_posteriori h2 = new compute_a_posteriori(0.2, 0.75, 0.25);
				compute_a_posteriori h3 = new compute_a_posteriori(0.4, 0.5, 0.5);
				compute_a_posteriori h4 = new compute_a_posteriori(0.2, 0.25, 0.75);
				compute_a_posteriori h5 = new compute_a_posteriori(0.1, 0.0, 1.0);
				
				String observation = args[0];
				int observation_len =  observation.length();
				int count_c = 0, count_l = 0;
				double new_prior = 0.0, q_C0 = 0.0, q_L0 = 0.0;
				
				File newTextFile = new File("result.txt");
	            FileWriter fw = new FileWriter(newTextFile);
	            fw.write("Observation sequence Q: " + observation + "\r\n");
	            fw.write("Length of Q: " + Integer.toString(observation_len) + "\r\n");
	            fw.write("\r\n");
				
				for(int i = 0; i < observation_len; i++){
					q_C0 = (h1.prior*h1.cherry) + (h2.prior*h2.cherry) + (h3.prior*h3.cherry) + (h4.prior*h4.cherry) + (h5.prior*h5.cherry);
					q_L0 = (h1.prior*h1.lime) + (h2.prior*h2.lime) + (h3.prior*h3.lime) + (h4.prior*h4.lime) + (h5.prior*h5.lime);
					if(observation.charAt(i) == 'c' || observation.charAt(i) == 'C'){
						new_prior = ((h1.cherry * h1.prior) / q_C0);
						h1.prior = new_prior;
						new_prior = ((h2.cherry * h2.prior) / q_C0);
						h2.prior = new_prior;
						new_prior = ((h3.cherry * h3.prior) / q_C0);
						h3.prior = new_prior;
						new_prior = ((h4.cherry * h4.prior) / q_C0);
						h4.prior = new_prior;
						new_prior = ((h5.cherry * h5.prior) / q_C0);
						h5.prior = new_prior;
						count_c = count_c + 1;
						
						fw.write("After Observation " + Integer.toString(i+1) + " = " + observation.substring(0, (i+1)) + "\r\n");
						fw.write("P(h1 | Q) =  " + Double.toString(Math.round(h1.prior * 100000.0) / 100000.0) + "\r\n");
						fw.write("P(h2 | Q) =  " + Double.toString(Math.round(h2.prior * 100000.0) / 100000.0) + "\r\n");
						fw.write("P(h3 | Q) =  " + Double.toString(Math.round(h3.prior * 100000.0) / 100000.0) + "\r\n");
						fw.write("P(h4 | Q) =  " + Double.toString(Math.round(h4.prior * 100000.0) / 100000.0) + "\r\n");
						fw.write("P(h5 | Q) =  " + Double.toString(Math.round(h5.prior * 100000.0) / 100000.0) + "\r\n");
					
						fw.write("\r\n");
						
					}
					else if(observation.charAt(i) == 'l' || observation.charAt(i) == 'L'){
						new_prior = ((h1.lime * h1.prior) / q_L0);
						h1.prior = new_prior;
						new_prior = ((h2.lime * h2.prior) / q_L0);
						h2.prior = new_prior;
						new_prior = ((h3.lime * h3.prior) / q_L0);
						h3.prior = new_prior;
						new_prior = ((h4.lime * h4.prior) / q_L0);
						h4.prior = new_prior;
						new_prior = ((h5.lime * h5.prior) / q_L0);
						h5.prior = new_prior;
						count_l = count_l + 1;
						fw.write("After Observation " + Integer.toString(i+1) + " = " + observation.substring(0, (i+1)) + "\r\n");
						fw.write("P(h1 | Q) =  " + Double.toString(Math.round(h1.prior * 100000.0) / 100000.0) + "\r\n");
						fw.write("P(h2 | Q) =  " + Double.toString(Math.round(h2.prior * 100000.0) / 100000.0) + "\r\n");
						fw.write("P(h3 | Q) =  " + Double.toString(Math.round(h3.prior * 100000.0) / 100000.0) + "\r\n");
						fw.write("P(h4 | Q) =  " + Double.toString(Math.round(h4.prior * 100000.0) / 100000.0) + "\r\n");
						fw.write("P(h5 | Q) =  " + Double.toString(Math.round(h5.prior * 100000.0) / 100000.0) + "\r\n");
						
						fw.write("\r\n");
						
					}
					else{
						System.out.println("The inputs can only be a combination of C/c or L/l");
						return;
					}
				}
				q_C0 = (h1.prior*h1.cherry) + (h2.prior*h2.cherry) + (h3.prior*h3.cherry) + (h4.prior*h4.cherry) + (h5.prior*h5.cherry);
				q_L0 = (h1.prior*h1.lime) + (h2.prior*h2.lime) + (h3.prior*h3.lime) + (h4.prior*h4.lime) + (h5.prior*h5.lime);
				System.out.println("Probability that the next candy we pick will be Cherry is " + q_C0);
				System.out.println("Probability that the next candy we pick will be Cherry is " + q_L0);
				
				fw.write("\r\n");
	            fw.write("Probability that the next candy we pick will be Cherry is " + Double.toString((Math.round(q_C0 * 100000.0) / 100000.0)) + "\r\n");
				fw.write("Probability that the next candy we pick will be Cherry is " + Double.toString((Math.round(q_L0 * 100000.0) / 100000.0)) + "\r\n");
	            fw.close();
				
			}
			else{
				System.out.println("Invalid number of arguments ");
			}
		
		}
	}








