enum GameState { GAME_START, ROLLING, FLIPPING, WON, GAME_OVER, ERROR };

public class BoxState {

private static BoxState instance = null;

private GameState state = GameState.GAME_START;


protected BoxState () {
	// defeats instantiation
}

public static BoxState getInstance() {
	if (instance == null){
		instance = new BoxState();
	}
	return instance;
}

public void setState(GameState newState){
	state = newState;
}

public GameState getState (){
	return state;
}

}
