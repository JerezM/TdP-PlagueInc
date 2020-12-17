package main.logica.model;

import main.logica.game_master.GameMaster;
import main.view.ui_updater.UIUpdater;

public abstract class EntidadModel {
    
    private GameMaster gameMaster;
    protected UIUpdater uiUpdater;

    protected EntidadModel(EntidadModel entidad) {
        gameMaster = GameMaster.getInstance();
        uiUpdater = UIUpdater.getInstance();

        this.addEntidadToGameMaster(entidad);
        this.generarLabel();
    }

    /**
     * Se encarga de añadir la entidad parametrizada a la lista de entidades activas de gameMaster.
     * @param entidad Entidad a agregar a GameMaster.
     */
    private void addEntidadToGameMaster(EntidadModel entidad) {
        gameMaster.addEntidad(entidad);
    }

    /**
     * Se encarga de remover la entidad parametrizada de la lista de entidades activas de gameMaster.
     * @param entidad Entidad a remover de GameMaster.
     */
    protected void destruirEntidad(EntidadModel entidad) {
        gameMaster.removeEntidad(entidad);
    }

    /**
     * Se encarga de actualizar la entidad correspondiente y realizar el movimiento segun corresponda.
     */
    public abstract void update();

    /**
     * Se encarga de comunicarse con UIUpdater y brindarle los datos para generar el label.
     * 
     * @see UIUpdater#generarLabel(int, java.awt.Point, int, int, javax.swing.ImageIcon)
     */
    public abstract void generarLabel();
}
