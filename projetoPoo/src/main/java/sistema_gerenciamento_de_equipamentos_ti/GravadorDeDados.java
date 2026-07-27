package sistema_gerenciamento_de_equipamentos_ti;

import java.io.*;
import java.util.Map;
import java.util.HashMap;

public class GravadorDeDados {

    public static final String ARQUIVO_EQUIPAMENTOS = "equipamentos.dat";
    public Object recuperarEquipamentos;

    public void salvar(Map<String, Equipamento> inventario) throws IOException{
       ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO_EQUIPAMENTOS));
        oos.writeObject(inventario);
        oos.close();
    }

    @SuppressWarnings("unchecked")
    public HashMap<String, Equipamento> recuperarEquipamentos() throws IOException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARQUIVO_EQUIPAMENTOS))) {
            return (HashMap<String, Equipamento>) ois.readObject();
        } catch (FileNotFoundException e) {
            return new HashMap<>();
        } catch (ClassNotFoundException e) {
            throw new IOException("Erro ao recuperar dados: arquivo corrompido ou incompatível", e);
        }
    }

}
