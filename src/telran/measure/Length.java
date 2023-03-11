package telran.measure;

public class Length implements Comparable<Length>{
	private float amount;
	private LengthUnit lengthUnit;
	public Length(float amount, LengthUnit lengthUnit) {
		this.amount = amount;
		this.lengthUnit = lengthUnit;
	}
	//HW30
	//TODO Methods TBD
	@Override
	/**
	 * equals two Length objects according to LengthUnit and amount
	 * 10m == 10000mm
	 */
	public boolean equals(Object obj) {
		boolean res = false;
		if (obj instanceof Length) {
			res = thisLengthMM() == objectLengthMM(obj);
		}
		return res;
	}
	private float objectLengthMM(Object obj) {
		return ((Length) obj).getAmount() * ((Length) obj).getUnit().value;
	}
	private float thisLengthMM() {
		return this.amount * this.lengthUnit.value;
	}

	@Override
	/**
	 * 
	 * @param o
	 * @return < 0 "this" object less than "o" object,
	 *  > 0 "this" object greater than "o" object,
	 *  == 0 "this" object equals "o" object,
	 */
	public int compareTo(Length o) {
		return (int) (thisLengthMM() - objectLengthMM(o));
	}
	/**
	 * 
	 * @param unit
	 * @return new Length object with a given LengthUnit
	 * example, convert(LengthUnit.M) returns Length in meters 
	 */
	public Length convert(LengthUnit unit) {
		return new Length (this.amount * this.getUnit().value/ unit.value, unit);
	}
	@Override
	/**
	 * returns string with amount and length unit pinned to amount with no space
	 * Example: 20.0M (string expression of Length object presenting 20 meters)
	 */
	public String toString() {
		return amount + this.getUnit().toString();
	}

	public float getAmount() {
		return amount;
	}

	public LengthUnit getUnit() {
		return lengthUnit;
	}

}
