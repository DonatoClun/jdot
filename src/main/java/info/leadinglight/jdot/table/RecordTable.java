package info.leadinglight.jdot.table;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class RecordTable {
	private final List<TableRow> rows;
	private final EnumMap<Attribute, String> attributes;

	public RecordTable() {
		rows = new ArrayList<>();
		attributes = new EnumMap<>(Attribute.class);
	}

	public RecordTable with(Attribute a, String value) {
		attributes.put(a, value);
		return this;
	}

	public TableRow addRow() {
		TableRow row = new TableRow();
		rows.add(row);
		return row;
	}

	public String toLabel() {
		StringBuilder sb = new StringBuilder();
		sb.append("<<TABLE");
		attributes.forEach((attribute, value) -> {
			sb.append(' ').append(attribute.name).append("=\"");
			sb.append(value.replace("\"","&quot;")).append("\"");
		});
		sb.append(">");
		rows.forEach(row -> row.toLabel(sb));
		sb.append("</TABLE>>");
		return sb.toString();
	}

	public enum Attribute {
		BORDER("BORDER"),
		CELLBORDER("CELLBORDER"),
		CELLSPACING("CELLSPACING"),
		CELLPADDING("CELLPADDING");

		private final String name;
		Attribute(String name) {
			this.name = name;
		}
	}
}
