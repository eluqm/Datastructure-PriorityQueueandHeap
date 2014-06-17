
public class Element implements Tipo_Element {
	
	private int chave;
	private String info;
	
	public Element(int key, String value) {
		chave = key;
		info = value;
	}

	@Override
	public int getKey() {
		return chave;
	}

	@Override
	public String getValue() {
		return info;
	}

}
