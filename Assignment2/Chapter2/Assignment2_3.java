package learnJava;
class Gear
{
	public int chainring,cog;
	public int rim,tire;
	public int ratio,diameter;
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
	public int diameter()
	{
		this.diameter = (this.rim + (this.tire)*2);
		return this.diameter;
	}
	public int gear_inches()
	{
		return this.ratio*this.diameter;
	}
}

class Assignment2_3
{
	public static void main(String[] args)
	{
		Gear ob = new Gear(52,11,26,5);
		System.out.println(ob.ratio());
		System.out.println(ob.diameter());
		System.out.println(ob.gear_inches());
	}
}