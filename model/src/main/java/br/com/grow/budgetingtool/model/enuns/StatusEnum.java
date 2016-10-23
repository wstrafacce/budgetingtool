package br.com.grow.budgetingtool.model.enuns;

public enum StatusEnum {
	ACTIVE(1), INACTIVE(2), PENDING(3);
	
	private int index;

	private StatusEnum(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
	public static StatusEnum getStatusEnumByIndex(int index) {
		StatusEnum statusEnum = null;
		
		switch (index) {
		
		case 1:
			statusEnum = ACTIVE;
			break;
			
		case 2:
			statusEnum = INACTIVE;
			break;
			
		case 3:
			statusEnum = PENDING;
			break;
		}
		
		return statusEnum;
	}
}
