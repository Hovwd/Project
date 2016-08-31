
public enum Gender {
MALE,FEMALE;
	
	public static Gender getGendder(String gender)
	{
		if(gender.equals(Gender.FEMALE.toString()))
		{
			return Gender.FEMALE;
		}
		if(gender.equals(Gender.MALE.toString()))
		{
			return Gender.MALE;
		}
		try {
			throw new Exception();
		} catch (Exception e) {
			
			System.out.println("the incorect Gender your gander is male");
			return Gender.MALE;
		}
	}
	
	
}
