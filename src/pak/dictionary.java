package pak;

public class dictionary {
	
	private String def; //definition
	private String speech; //part of speech
	
	public void Definitions(String definition, String speech) {
		this.def = def;
		this.speech = speech;
	}
	
	public void setDef(String definition) {
		this.def = def;
	}
	
	public String getDef() {
		return this.def;
	}
	
	public void setSpeech(String speech) {
		this.speech = speech;
	}
	
	public String getSpeech() {
		return this.speech;
	}

}
