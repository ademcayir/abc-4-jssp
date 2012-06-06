import java.util.Iterator;


public class Structure {

	int io_degree;
	//int pre_tarv;
//	int close_final;
	
	
}

/*

void final_close(int accept)
{
	int states=0;


	//	System.out.println("Accept="+accept);

	{
		i=accept;
		for(j=0;j<input;j++)
		{
			states=matrix[i][j];
			ret_st[j]=states;
			System.out.println("ret_st:"+ret_st[j]);
			if(states==input+1||states==accept)
			{
				continue;
			}
			else
			{
				set[k].add(states);	
				hash.put(states, k);
				//		System.out.println("Hash contents:state:K="+hash.toString());				}
				//	System.out.println("Set["+k+"]="+set[k].toString());


				//	while(el_count<set[k].size())

				Iterator itr=set[k].iterator();
				{

					while(itr.hasNext())
					{   ++el_count;
					//System.out.println("NExt set element:"+itr.next());
					{   
						num=((Integer)itr.next()).intValue();
						System.out.printf("Next set num:"+num);
						if(el_count<=set[k].size())
						{
							//	final_close();
						}
						else
						{
							++k;
							//final_close(num);
						}
						//	final_close(num);
					}

					}
					//	++k;

				}

			}

		}
	}

*/


/*

int[] prox_states()
{	//Array ar = null; 
	int fin_close[]=new int[input];

	int final_rand=rand.nextInt(input);
	//	System.out.println("Final decided state:"+final_rand);

	//char str=(char)final_rand;
	//String send_rand=Character.toString(str);
	final_close(final_rand);
	if(el_count<set[k].size())
	{

	}
	//	set.add(final_close(final_rand));

	for(i=0;i<ret_st.length;i++)
	{

	}

	return fin_close;*/
/*int calculate_happiness()
{
	int state=rand.nextInt(input);
	int io_degree=temp_array[state];
	int travel_factor=travelled(state);
	happy=io_degree+travel_factor;
	System.out.println("IO degree="+io_degree+"travel_factor="+travel_factor);
	return happy;


}*/