
public class Entry implements Tipo_Entry {
	
	private int chave;
	private String info;
	
	public Entry(int key, String value) {
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
