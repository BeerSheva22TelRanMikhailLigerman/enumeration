package telran.measure;

public enum LengthUnit {
	MM(1), CM(10), IN(25.4f), M(1000),KM(1_000_000);
	float value;
	LengthUnit(float value) {
		this.value = value;
	}
	//HW30
	public Length between(Length l1, Length l2) {
		float lengthBetweenMM = (l1.getAmount() * l1.getUnit().value) - (l2.getAmount() * l2.getUnit().value);
		float lengthBetween = Math.abs(lengthBetweenMM / this.value); 
		return new Length(lengthBetween, this);
	}
	
	
	

public float getValue() {
	return value;
}

}
