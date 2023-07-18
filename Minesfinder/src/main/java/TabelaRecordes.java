import java.io.Serializable;
import java.util.ArrayList;

public class TabelaRecordes implements Serializable {

    private String nomeJogador;
    private long tempoJogo;
    private transient ArrayList<TabelaRecordesListener> listeners;

    public TabelaRecordes() {
        this.nomeJogador = "Anonimo";
        this.tempoJogo = 999999999;
        this.listeners = new ArrayList<>();
    }

    public String getNome() {
        return nomeJogador;
    }

    public long getTempo() {
        return tempoJogo;
    }

    public void setRecorde(String nomeJogador, long tempoJogo) {
        if (tempoJogo<this.tempoJogo) {
            this.nomeJogador=nomeJogador;
            this.tempoJogo=tempoJogo;
            notifyRecordesActualizados();
        }
    }

    public void addTabelaRecordesListener(TabelaRecordesListener list) {
        if (listeners == null) listeners = new ArrayList<>(); //ultimo ex
        listeners.add(list);
    }
    public void removeTabelaRecordesListener(TabelaRecordesListener list) {
        if (listeners != null) listeners.remove(list); //listeners.remove(list);//ultimo ex
    }
    private void notifyRecordesActualizados() {
        if (listeners != null) { //ultimo ex
            for (TabelaRecordesListener list : listeners)
                list.recordesActualizados(this);
        }
    }



}
