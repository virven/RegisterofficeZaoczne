package registerOffice.management.conditions;

public abstract class Condition<T> {

	protected Condition<T> condition;
	
	protected abstract boolean check(T obj);
	
	public void setCondition(Condition<T> condition)
	{
		this.condition=condition;
	}
	
	public boolean checkCondition(T obj)
	{
		if(this.condition!=null)
			return this.condition.checkCondition(obj) 
					&& this.check(obj);
		
		return this.check(obj);
	}
}
