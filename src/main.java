import java.io.IOException;


public class main {
	public static void main(String args[]) throws IOException
	{
		BeeCore beecore=new BeeCore();
		Structure structure=new Structure();
		//beecore.RandomMatrix();
		//beecore.fill_matrix();
		beecore.matrixprint();
		beecore.print_fill_matrix();
		
		beecore.check_repeat();
	//	beecore.matrixprint();
		beecore.initialize_temp_array();
		beecore.initialize_set();
		beecore.iodegree();
		beecore.print_temp_array();
	//	beecore.prox_states();
	//	int happiness=beecore.calculate_happiness();
	//	System.out.println("Happiness="+happiness);
		beecore.populate_main();
		beecore.print_populate();
	//	beecore.det_path();
	//	beecore.next_state();
	//	beecore.print_populate();
		beecore.top();
		beecore.print_visit();
		beecore.print_path();
	//	beecore.print_ks();

	}

}
