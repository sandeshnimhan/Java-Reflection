package genericDeser.util;

import genericDeser.util.Logger;

public class Second {
	
	private int IntValue;
	private double DoubleValue;
	private boolean BooleanValue;
	
	public Second(){
		Logger.writeMessage("Second Constructor", Logger.DebugLevel.CONSTRUCTOR);
	}

	
	public void setIntValue(int intValue) {
		IntValue = intValue;
	}


	public void setDoubleValue(double doubleValue) {
		DoubleValue = doubleValue;
	}

	public boolean isBooleanValue() {
		return BooleanValue;
	}

	public void setBooleanValue(boolean ooleanValue) {
		this.BooleanValue = ooleanValue;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (BooleanValue ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(DoubleValue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + IntValue;
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
		Second other = (Second) obj;
		if (BooleanValue != other.BooleanValue)
			return false;
		if (Double.doubleToLongBits(DoubleValue) != Double.doubleToLongBits(other.DoubleValue))
			return false;
		if (IntValue != other.IntValue)
			return false;
		return true;
	}
	
	
}
