package cs2110Lab4;


//import Labs.Lab4Fall2020.List;

/**
 * Expense list provided by Srini
 */
public class ExpenseList
{
	private List<Expense> expenses;


	public ExpenseList()
	{
		expenses = new List<Expense>();
	}
	public void add(Expense exp)
	{
		expenses.add(exp);
	}

	public boolean isEmpty()
	{
		return expenses.isEmpty();
	}
	public boolean contains(Expense exp)
	{
		return expenses.contains(exp);
	}
	public Expense first()
	{
		return expenses.first();
	}
	public Expense next()
	{
		return expenses.next();
	}
	public void enumerate()
	{
		expenses.enumerate();
	}

    /**
     * returns the highest expense object in the expenses list
	 * @return
     */
	public double maxExpense()
	{
		double max =0.0, amt;
		Expense exp = expenses.first();
		while (exp!=null)
		{
			amt = exp.getAmount();
			if (amt>max)
				max = amt;
			exp = expenses.next();
		}
		return max;
	}

    /**
     * returns the lowest expense object in the expenses list
	 * @return
     */
	public double minExpense()
	{
		double min =Double.MAX_VALUE, amt;
		Expense exp = expenses.first();
		if (exp==null) return 0.0;
		else
		{

			while (exp!=null)
			{
				amt = exp.getAmount();
				if (amt<min)
					min = amt;
				exp = expenses.next();
			}
		}
		return min;
	}

	
	/*The following method implementations were done by 
	 * @author Alexander Gates | B00837129
	 */
	
    /**
     * returns the average expense value from the expenses list
	 * @return
     */
	public double avgExpense()  
	{
		double avg = 0.0;
		Expense exp = expenses.first();
		while(exp!=null) {
			avg+=exp.getAmount();
			exp =expenses.next();
		}	
		return avg/expenses.size();
	}

    /**
     * returns the total expenses from the expense list
	 * @return
     */
	public double totalExpense() 
	{
		double total = 0.0;
		Expense exp = expenses.first();
		while(exp!=null) {
			total+=exp.getAmount();
			exp = expenses.next();
		}
		return total;
	}

    /**
     * returns the total amount spent on a given item from the expenses lists
	 * @param expItem
     * @return
     */
	public double amountSpentOn(String expItem) //to be completed by the student
	{
		double amount = 0.0;
		Expense exp = expenses.first();
		while(exp!=null) {
			if(exp.getItem().equals(expItem))
				amount += exp.getAmount();
			exp = expenses.next();
		}
		return amount;
	}


}
