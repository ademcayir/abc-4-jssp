import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class BeeCore {
	Random rand = new Random();
	// static int mynum=14;
	final static int mynum = 6;
	static int matrixs_io[][] = new int[mynum][mynum];
	ArrayList<Integer> elements = new ArrayList<Integer>();
	static int temp_array[] = new int[mynum];
	Set set[] = new Set[mynum];
	static int k = 0;
	int num = 0;
	static HashMap hash = new HashMap();
	int el_count = 0;
	static int data_tr[] = new int[mynum];
	int happy = 0;
	static Set<Integer> path[] = new LinkedHashSet[mynum * mynum];
	Set<Integer> paths = new LinkedHashSet<Integer>();
	int tr_data = 0;
	int sum, max = 0;
	int count = 0;
	int det_count = 0;
	int check_var_start = mynum * 2;
	int check_var_j = mynum * 2;
	int throw_back = 1;

	BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

	static int ret_st[] = new int[mynum];
	static int my_array[][] = {
			{ 1, 5, mynum + 1, mynum + 1, mynum + 1, mynum + 1 },
			{ 2, mynum + 1, mynum + 1, mynum + 1, mynum + 1, mynum + 1 },
			{ 2, 3, 4, 5, mynum + 1, mynum + 1 },
			{ 5, mynum + 1, mynum + 1, mynum + 1, mynum + 1, mynum + 1 },
			{ 5, 3, 2, mynum + 1, mynum + 1, mynum + 1 },
			{ 5, mynum + 1, mynum + 1, mynum + 1, mynum + 1, mynum + 1 }, };

	void fill_matrix() throws NumberFormatException, IOException {
		for (int k = 0; k < mynum; k++) {
			System.out.println("Number of elements in row:");
			int numel = Integer.parseInt(stdin.readLine());
			for (int j = 0; j < numel; j++) {

				System.out.println("Enter elements:");
				int numel_1 = Integer.parseInt(stdin.readLine());

				my_array[k][j] = numel_1;
			}
		}
	}

	void print_fill_matrix() {
		System.out.println("print fill matrix");
		for (int k = 0; k < mynum; k++) {
			for (int j = 0; j < mynum; j++) {
				System.out.print(my_array[k][j] + "\t");
			}
			System.out.println();
		}
	}

	void initialize_temp_array() {
		for (int k = 0; k < mynum; k++) {
			temp_array[k] = 0;
		}
		initialize_set1();
	}

	void initialize_set1() {
		for (int k = 0; k < mynum; k++) {
			path[k] = new LinkedHashSet();
		}
	}

	int i, j;

	// static int my_array[][]=new int[mynum][mynum];

	void RandomMatrix() throws IOException {
		for (i = 0; i < mynum; i++)
			for (j = 0; j < mynum; j++) {
				my_array[i][j] = rand.nextInt(mynum);

			}

	}

	void matrixprint() {
		System.out.println("Random: " + mynum);
		System.out.println("Random matrix:\t");
		for (i = 0; i < mynum; i++) {
			for (j = 0; j < mynum; j++) {
				System.out.print(my_array[i][j] + "\t");

			}
			System.out.println("");

		}
	}

	void check_repeat() {
		int element;
		for (i = 0; i < mynum; i++) {
			elements.clear();
			for (j = 0; j < mynum; j++) {
				element = my_array[i][j];
				if (elements.contains(element)) {
					my_array[i][j] = mynum + 1;
				} else
					elements.add(element);

			}
		}

	}

	void iodegree() {
		int element;
		for (i = 0; i < mynum; i++)
			for (j = 0; j < mynum; j++) {
				element = my_array[i][j];
				if (element < mynum) {
					temp_array[element]++;
				} else {
				}
			}

	}

	void print_temp_array() {
		int k;
		System.out.println("temp array:");
		for (k = 0; k < mynum; k++) {
			System.out.print(temp_array[k] + "\t");
		}
		System.out.println();
	}

	void initialize_set() {
		for (i = 0; i < mynum; i++) {
			data_tr[i] = 0;
			set[i] = new HashSet();
			for (j = 0; j < mynum; j++)
				matrixs_io[i][j] = 0;
		}

	}

	void travelled(int state) {
		tr_data = data_tr[state];

		++tr_data;
		// System.out.println("Tr_data=+="+tr_data+"state=="+state);
		data_tr[state] = tr_data;

		// return data_tr[state];
	}

	void populate_main() {
		for (i = 0; i < mynum; i++)
			for (j = 0; j < mynum; j++) {
				// System.out.println("I: " + i + "J:" + j);
				if (my_array[i][j] >= mynum || my_array[i][j] == i) {
					matrixs_io[i][j] = -1;
				} else {
					matrixs_io[i][j] = temp_array[my_array[i][j]];
				}
				// matrixs[i][j].pre_tarv=travelled(i);

			}
	}

	void print_populate() {
		for (i = 0; i < mynum; i++)
			for (j = 0; j < mynum; j++) {
				System.out.println("[" + i + "]" + "[" + j + "]");
				System.out.println("IO_degree= " + matrixs_io[i][j]);// +" Pre Traversed= "+matrixs[i][j].pre_tarv);
			}
	}

	/*
	 * void det_path(int start) {
	 * 
	 * ++count; System.out.println("Count="+count);
	 * 
	 * i=start;
	 * 
	 * System.out.println("next=="+start); //path[i].add(start);
	 * if(paths.contains(i)) { System.out.println("State getting repeated:"+i);
	 * } else { paths.add(i); data_tr[i]=+1; }
	 * 
	 * while(count<=input) { for(j=0;j<input;j++) {
	 * sum=matrixs_io[i][j]+data_tr[j]; if(max<sum &&
	 * !(paths.contains(matrixs_io[i][j]))) { System.out.println("Max="+max);
	 * max=sum;} else continue; } //
	 * System.out.println("States having same max"); // for(i=0;i<input;i++)
	 * for(j=0;j<input;j++) { if(matrixs_io[i][j]+data_tr[j]==max ) {
	 * System.out.println("State in row:"+matrix[i][j]); if(count<=input &&
	 * !(paths.contains(matrix[i][j]))) { // path[i].add(matrix[i][j]);
	 * det_path(matrix[i][j]); } else { det_path(matrix[i][j]); }
	 * 
	 * 
	 * }
	 * 
	 * System.out.println("path contents:"+paths); // Iterator
	 * itr=path[i].iterator(); while(itr.hasNext()) {
	 * 
	 * } // System.out.println("Max value:"+max+"HashSet="+path[i]); } } }
	 */

	// int find_next(int num)

	void top() {
		int path = rand.nextInt(mynum);
		path = 0;
		for (int i = 0; i < mynum; i++) {
			throw_back = 1;
			if (check_var_start == mynum * 2 && check_var_j == mynum * 2) {
				System.out.println("---In top no cancel");
				next_state(path, i);
				print_path();
				System.out.println("---In top no cancel");
			} else {

				System.out.println("-----In top  1st cancel--------");
				System.out.println("Row-" + check_var_start + " column="
						+ check_var_j);
				next_state(path, i);
				print_path();

				System.out.println("-----In top  1st cancel-------");
			}
			my_array[check_var_start][check_var_j] = mynum + 1;

		}
	}

	int next_state(int path, int i) {
		int counter = 0;

		{

			for (int s = 0; s < mynum; s++) {

				count = 0;
				paths.clear();
				det_count = 0;
				populate_main();
				data_tr[s] = 0;
				determine_path(path, ++counter, i);
			}
		}
		// max_in_row(path);

		return 0;
	}

	// int my_path[][]=new int[mynum][mynum];
	int ks = 0;

	void determine_path(int start, int index, int i) {
		{
			int max = 0;
			int last = 0;
			// System.out.println("Path["+path[start]+"]"+" --Index="+index/*+"-->Paths="+paths*/);

			path[index - 1].add(start);

			// System.out.println("start:"+start);
			// my_path[++ks]=start;
			if (check_var_start == mynum * 2 && check_var_j == mynum * 2)
				max = max_in_row(start);
			else {
				my_array[check_var_start][check_var_j] = mynum + 1;
				max = max_in_row(start);
			}

			for (j = 0; j < mynum; j++) {

				if (my_array[start][j] == mynum + 1) {
					continue;
				} else {
					if (max == matrixs_io[start][j]
							+ data_tr[my_array[start][j]]) // &&
															// !paths.contains(matrix[start][j]))
					{
						matrixs_io[start][j] = -1;
						// System.out.println("Next state="+matrix[start][j]);
						travelled(my_array[start][j]);
						if (throw_back == 1) {
							check_var_start = mynum * 2;
							check_var_j = mynum * 2;
							while (check_var_start == mynum * 2
									&& check_var_j == mynum * 2) {
								check_var_start = start;
								check_var_j = j;
								// matrix[check_var_start][check_var_j]=input+1;
							}
						}
						throw_back = 0;

						if (++det_count <= mynum * mynum) {
							last = j;
							determine_path(my_array[start][j], index, i);

							System.out.println("Last=" + last);
							// System.out.println("start:"+my_array[start][j]);
						}
					}
				}

			}
			// matrixs_io[start][last]=-1;
			/*
			 * for(int w=0;w<mynum;w++) for(int t=0;t<mynum;t++)
			 * System.out.println("--Matrix_io="+w+"  "+t+matrixs_io[w][t]);
			 */
		}
	}

	int max_in_row(int row) {
		int current = 0;
		for (j = 0; j < mynum; j++) {
			if (my_array[row][j] == mynum + 1) {
				// System.out.println("Arrival of a final state");
				continue;
			} else {
				// System.out.println("io_data="+matrixs_io[row][j]+"  data_tr="+data_tr[matrix[row][j]]);

				max = matrixs_io[row][j] + data_tr[my_array[row][j]];

				// if(!path[index].contains(matrix[row][j]))

				if (max > current) {
					current = max;
					// System.out.println("Max=="+current+"state=="+row);

				} else {
					continue;
				}

			}

		}
		return current;
	}

	void print_visit() {
		for (int g = 0; g < mynum; g++)
			System.out.println("data[" + g + "]=" + data_tr[g]);
	}

	void print_path() {
		System.out.println("print path");
		for (int k = 0; k < mynum; k++)
			System.out.println("path[" + k + "]" + path[k]);
	}

	void print_ks() {
		// for(int ks=0;ks<mynum*10;k++)
		// System.out.println("KS="+my_path[ks]);
	}
}