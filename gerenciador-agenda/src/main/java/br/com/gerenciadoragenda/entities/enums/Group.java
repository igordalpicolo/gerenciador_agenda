package br.com.gerenciadoragenda.entities.enums;

public enum Group {

	FAMILY(1), 
	FRIENDS(2), 
	JOB(3);

	private int code;

	private Group(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static Group valueOf(int code) {
		for (Group value : Group.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid Group code");
	}
}
