package sistema_inventario_equipamentos_ti;

import java.io.*;
import java.util.Map;
import java.util.HashMap;

public class GravadorDeDados {

    public static final String ARQUIVO_EQUIPAMENTOS = "equipamentos.dat";

    public void salvar(Map<String, Equipamento> inventario) throws IOException{
       ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO_EQUIPAMENTOS));
        oos.writeObject(inventario);
        oos.close();
    }

    public HashMap<String, Equipamento> recuperarEquipamentos() throws IOException {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARQUIVO_EQUIPAMENTOS));
            HashMap<String, Equipamento> inventario = (HashMap<String, Equipamento>) ois.readObject();
            ois.close();
            return inventario;
        } catch (ClassNotFoundException e) {
            throw new IOException("Erro ao recuperar dados!");
        }
    }

}
