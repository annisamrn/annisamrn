/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skripsiannisameriana.fakultas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author USER
 */
public class FakultasTabelModel extends AbstractTableModel{
    
    private List<Fakultas> list = new ArrayList<>();
    
    public void setData(List<Fakultas> list) {
        this.list = list;
        fireTableDataChanged();
    }

    public Fakultas get(int row) {
        return list.get(row);
    }

    @Override
    public int getRowCount() {
        return list.size();
    }
    
    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "No"; 
            case 1: return "Id Fakultas";
            case 2: return "Fakultas";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0: return rowIndex + 1;
            case 1: return list.get(rowIndex).getIdFakultas();
            case 2: return list.get(rowIndex).getNamaFakultas();
            default:
                return null;
        }
        
    }
    
}
