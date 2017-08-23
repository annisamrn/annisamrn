/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skripsiannisameriana.soal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author USER
 */
public class SoalTabelModel extends AbstractTableModel{
    private List<Soal> list = new ArrayList<>();
    
    public void setData(List<Soal> list) {
        this.list = list;
        fireTableDataChanged();
    }

    public Soal get(int row) {
        return list.get(row);
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0: return rowIndex + 1;
            case 1: return list.get(rowIndex).getIdSoal();            
            case 2: return list.get(rowIndex).getSoal();
            case 3: return list.get(rowIndex).getKepentingan();
            case 4: return list.get(rowIndex).getNamaFakultas();
            case 5: return list.get(rowIndex).getNamaProdi();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "No";
            case 1: return "Kode Soal";
            case 2: return "Soal";
            case 3: return "Kepentingan";
            case 4: return "Fakultas";
            case 5: return "Program Studi";
            default:
                return null;
        }
    }
}
