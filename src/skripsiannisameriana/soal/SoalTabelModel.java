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
        return 13;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0: return rowIndex + 1;
            case 1: return list.get(rowIndex).getIdSoal();            
            case 2: return list.get(rowIndex).getSoal();
            case 3: return list.get(rowIndex).getA();
            case 5: return list.get(rowIndex).getB();
            case 7: return list.get(rowIndex).getC();
            case 9: return list.get(rowIndex).getD();
            case 4: return list.get(rowIndex).getNilaiA();
            case 6: return list.get(rowIndex).getNilaiB();
            case 8: return list.get(rowIndex).getNilaiC();
            case 10: return list.get(rowIndex).getNilaiD();
            case 11: return list.get(rowIndex).getNamaFakultas();
            case 12: return list.get(rowIndex).getNamaProdi();
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
            case 3: return "Jawaban A";
            case 5: return "Jawaban B";
            case 7: return "Jawaban C";
            case 9: return "Jawaban D";
            case 4: return "Nilai A";
            case 6: return "Nilai B";
            case 8: return "Nilai C";
            case 10: return "Nilai D";
            case 11: return "Fakultas";
            case 12: return "Program Studi";
            default:
                return null;
        }
    }
}
