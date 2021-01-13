package gui;

import javax.swing.table.AbstractTableModel;

import model.BazaPredmeta;

public class AbstractTableModelPredmeti extends AbstractTableModel {

		/**
		 * 
		 */
		private static final long serialVersionUID = -9031655068332887694L;

		public AbstractTableModelPredmeti() {}

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return BazaPredmeta.getInstance().getColumnCount();
		}

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return BazaPredmeta.getInstance().getPredmeti().size();
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub
			return BazaPredmeta.getInstance().getValueAt(rowIndex, columnIndex);
		}
		
		@Override
		public String getColumnName(int column) {
			return BazaPredmeta.getInstance().getColumnName(column);
		}
}
