package pak;

public class Definitions {
	private String definition;
	private String partOfSpeech;
	
	public void definitions(String definition, String partOfSpeech) {
		this.definition = definition;
		this.partOfSpeech = partOfSpeech;
	}

	public String getDefinition() {
		return this.definition;
	}
	
	public void setDefintions(String definition) {
		this.definition = definition;
	}
	
	public String getPartOfSpeech() {
		return this.partOfSpeech;
	}
	
	public void setPartOfSpeech(String partOfSpeech) {
		this.partOfSpeech = partOfSpeech;
	}
}
