package learnJava;
class Gear
{
	public int chainring,cog;
	public Gear(int chainring,int cog)
	{
		this.chainring = chainring;
		this.cog = cog;
	}

	public int ratio()
	{
		return this.chainring/this.cog;
	}

}

class Assignment2_1
{
	public static void main(String[] args)
	{
		Gear ob = new Gear(52,11);
		System.out.println(ob.ratio());
	}
}