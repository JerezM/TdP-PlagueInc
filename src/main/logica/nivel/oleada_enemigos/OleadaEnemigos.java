package main.logica.nivel.oleada_enemigos;

public interface OleadaEnemigos {
    
    /**
     * Consulta si todavia hay niveles para jugar.
     * @return True en caso de que haya niveles, falso en caso de que ya se hayan jugado todos los niveles.
     */
    public boolean hasNextLevel();

    /**
     * Se encarga de inicializar y mandar la oleada del proximo nivel disponible.
     */
    public void empezarOleadaProximoNivel();

    /**
     * Consulta si ya se han eliminado a todos los infectados del nivel actual.
     * @return True en caso de que se haya completado el nivel, false en caso contrario.
     */
    public boolean isLevelComplete();

    /**
     * Se encarga de actualizar la oleada de enemigos.
     */
    public void update();

    //public void freezeEnemigos();
}
