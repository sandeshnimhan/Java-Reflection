package genericDeser.util;

import genericDeser.util.Logger;

public class First {

	private int IntValue;
	private String StringValue;
	private float FloatValue;
	private short ShortValue;
	
	public First(){
		Logger.writeMessage("First Constructor", Logger.DebugLevel.CONSTRUCTOR);
	}
	public void setIntValue(int intValue) {
		IntValue = intValue;
	}
	
	public void setStringValue(String stringValue) {
		StringValue = stringValue;
	}
	
	public void setFloatValue(float floatValue) {
		FloatValue = floatValue;
	}
	
	public void setShortValue(short shortValue) {
		ShortValue = shortValue;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(FloatValue);
		result = prime * result + IntValue;
		result = prime * result + ShortValue;
		result = prime * result + ((StringValue == null) ? 0 : StringValue.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		First other = (First) obj;
		if (Float.floatToIntBits(FloatValue) != Float.floatToIntBits(other.FloatValue))
			return false;
		if (IntValue != other.IntValue)
			return false;
		if (ShortValue != other.ShortValue)
			return false;
		if (StringValue == null) {
			if (other.StringValue != null)
				return false;
		} else if (!StringValue.equals(other.StringValue))
			return false;
		return true;
	}
	
	
}
