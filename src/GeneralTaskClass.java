
public class GeneralTaskClass implements Runnable{
	String loading = "";
	int counter = 0;
	
	@Override
	public void run() {
		while(true){
			
		if(counter<3){
		 loading  +=".";
		 MinerFrame.loading = loading;
		 counter++;
		 }
		else{
		loading = " ";
		 MinerFrame.loading = loading;

        counter = 0;
		}
		}
		
	}

}
