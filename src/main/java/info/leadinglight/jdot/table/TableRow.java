package info.leadinglight.jdot.table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TableRow {
	public final List<TableCell> cells;

	public TableRow() {
		cells = new ArrayList<>();
	}

	public TableRow(TableCell ... cells) {
		this.cells = Arrays.asList(cells);
	}

	public TableCell addCell() {
		TableCell c = new TableCell();
		cells.add(c);
		return c;
	}

	public void toLabel(StringBuilder sb) {
		sb.append("<TR>");
		cells.forEach(c -> c.toLabel(sb));
		sb.append("</TR>");
	}

}
