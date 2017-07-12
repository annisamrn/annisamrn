/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skripsiannisameriana.prodi;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author USER
 */
public class ProdiTabelModel extends AbstractTableModel{
    
    private List<Prodi> list = new ArrayList<>();
    
    public void setData(List<Prodi> list) {
        this.list = list;
        fireTableDataChanged();
    }

    public Prodi get(int row) {
        return list.get(row);
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0: return rowIndex + 1;
            case 1: return list.get(rowIndex).getNamaFakultas();
            case 2: return list.get(rowIndex).getIdProdi();
            case 3: return list.get(rowIndex).getNamaProdi();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "No";
            case 1: return "Fakultas";
            case 2: return "Kode Program Studi";
            case 3: return "Nama Program Studi";
            default:
                return null;
        }
    }
    
}
