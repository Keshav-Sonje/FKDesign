package learnJava;
class Gear
{
	public int chainring,cog;
	public int rim,tire;
	public int ratio;
	public Gear(int chainring,int cog,int rim,int tire)
	{
		this.chainring = chainring;
		this.cog = cog;
		this.rim = rim;
		this.tire = tire;
	}

	public int ratio()
	{
		this.ratio = this.chainring/this.cog;
		return this.ratio;
	}

	public int gear_inches()
	{
		return this.ratio*(this.rim + (this.tire)*2);
	}
}

class Assignment2_2
{
	public static void main(String[] args)
	{
		Gear ob = new Gear(52,11,26,5);
		System.out.println(ob.ratio());
		System.out.println(ob.gear_inches());
	}
}