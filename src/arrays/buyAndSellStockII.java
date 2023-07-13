package arrays;

public class buyAndSellStockII {
	boolean buy = true;
	int val = -1;
	int total_profit = 0;
	for(int i=0;i<prices.length-1;i++) {
		if(buy && prices[i]<prices[i+1]) {
			val = prices[i];
			buy = !buy;
		}
		else if(!buy && val!=-1 && prices[i]>prices[i+1]) {
			total_profit += prices[i]-val;
			val = -1;
			buy = !buy;
		}
	}
	if(val!=-1) {
		total_profit += prices[prices.length-1]-val;
	}
	return total_profit;

}
