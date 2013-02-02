package registerOffice;

public final class Context {

	private int quantityOfLyzwy;
	private int quantityOfPeople;
	
	private Context() {
	}

	private static Context instance;

	public static Context getInstance() {
		
		if (instance == null)
			synchronized (Context.class) {
				if (instance == null)
					instance = new Context();
			}
		return instance;
	}
	
	public void RedukujLyzwy()
	{
		this.quantityOfLyzwy--;
	}
	
	public void RedukujPeople()
	{
		this.quantityOfPeople--;
	}
	public void raiseNumberOfLyzwy()
	{
		this.quantityOfLyzwy++;
	}

	public void raisenumberOfPeople()
	{
		this.quantityOfPeople++;
	}
	
	public int getQuantityOfPeople()
	{
		return this.quantityOfPeople;
	}
	public int getQuantity()
	{
		return this.quantityOfLyzwy;
	}
}
