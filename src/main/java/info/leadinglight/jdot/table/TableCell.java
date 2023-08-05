package info.leadinglight.jdot.table;


import java.util.EnumMap;

public class TableCell {

	private final EnumMap<Attribute, String> attributes;
	public String content;

	public TableCell(String content) {
		this.content = content;
		attributes = new EnumMap<>(Attribute.class);
	}

	public TableCell() {
		this.content = "";
		attributes = new EnumMap<>(Attribute.class);
	}

	public TableCell with(Attribute a, String value) {
		attributes.put(a, value);
		return this;
	}

	public TableCell withContent(String content) {
		this.content = content;
		return this;
	}

	public void toLabel(StringBuilder sb) {
		sb.append("<TD");
		attributes.forEach((attribute, value) -> {
			sb.append(' ').append(attribute.name).append("=\"");
			sb.append(value.replace("\"","&quot;")).append("\"");
		});
		sb.append(">");
		sb.append(content.replace("&","&amp;")
						.replace("<","&lt;")
						.replace(">","&gt;")
						.replace("ε","&epsilon;")
						.replace("\"", "&quot;")
						.replace("\\","&#92;&#8203;"));
		sb.append("</TD>");
	}

	public enum Attribute {
		COLSPAN("COLSPAN"),
		ROWSPAN("ROWSPAN"),
		BGCOLOR("BGCOLOR");

		private final String name;
		Attribute(String name) {
			this.name = name;
		}
	}
}
