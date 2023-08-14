package controller;


public enum GameState {

	PLAY, MENU, SETTINGS, LOADING, HOWTOPLAY;

	public static GameState gameState = LOADING; // set to loading
	public static GameState previousGameState = null;

	public static void SetGameState(GameState state) {
		previousGameState = gameState;
		gameState = state;
	}

    public static GameState getGameState() {
        return gameState;
    }

    public static GameState getPreviousGameState() {
        return previousGameState;
    }

	

}
