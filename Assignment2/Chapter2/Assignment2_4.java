package learnJava;
class Gear
{
	public int chainring,cog;
	public Wheel wheel;
	public float ratio;

	public Gear(int chainring,int cog,int rim,int tire)
	{
		this.chainring = chainring;
		this.cog = cog;
		wheel = new Wheel(rim,tire);
	}

	public float ratio()
	{
		this.ratio = this.chainring/this.cog;
		return this.ratio;
	}
	

	public float gear_inches()
	{
		return this.ratio*wheel.diameter();
	}
}

class Wheel
{
	public int rim,tire;
	public float diameter;
	public float circumference;
	public Wheel(int rim,int tire)
	{
		this.rim = rim;
		this.tire = tire;
	}

	public float diameter()
	{
		this.diameter = (this.rim + (this.tire)*2);
		return this.diameter;
	}

	public float circumference()
	{
		this.circumference = this.diameter*2;
		return this.circumference;
	}

}
class Assignment2_4
{
	public static void main(String[] args)
	{
		Gear ob = new Gear(52,11,26,5);
		System.out.println(ob.ratio());
		System.out.println(ob.gear_inches());
	}
}