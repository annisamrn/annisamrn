/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skripsiannisameriana.cmahasiswa;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author USER
 */
public class CMahasiswaTabelModel extends AbstractTableModel{
    
    private List<CMahasiswa> list = new ArrayList<>();
    
    public void setData(List<CMahasiswa> list) {
        this.list = list;
        fireTableDataChanged();
    }

    public CMahasiswa get(int row) {
        return list.get(row);
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0: return rowIndex + 1;
            case 1: return list.get(rowIndex).getIdPendaftar();            
            case 2: return list.get(rowIndex).getNamaPendaftar();
            case 3: return list.get(rowIndex).getAsalSekolah();
            case 4: return list.get(rowIndex).getTelepon();
            case 5: return list.get(rowIndex).getEmail();
            case 6: return list.get(rowIndex).getAlamat();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "No";
            case 1: return "No Pendaftaran";
            case 2: return "Nama Calon Mahasiswa";
            case 3: return "Asal Sekolah";
            case 4: return "Telepon";
            case 5: return "Email";
            case 6: return "Alamat";
            default:
                return null;
        }
    }
    
}
